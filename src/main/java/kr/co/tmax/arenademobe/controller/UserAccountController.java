package kr.co.tmax.arenademobe.controller;

import kr.co.tmax.arenademobe.common.CommonResponse;
import kr.co.tmax.arenademobe.config.auth.PrincipalDetails;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.service.UserAccountService;
import kr.co.tmax.arenademobe.validator.UserAccountValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v0/", produces = "application/json; charset=utf-8")
@RestController
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserAccountValidator userAccountValidator;

    @InitBinder
    public void initItem(WebDataBinder dataBinder) {
        dataBinder.addValidators(userAccountValidator);
    }

    @PostMapping("/join")
    public ResponseEntity<CommonResponse> join(@RequestBody @Validated UserAccount userAccount, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new BindException((bindingResult));
        }

        userAccount.setRole("ROLE_MEMBER");
        userAccountService.saveUser(userAccount);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.withMessage("회원가입 성공"));
    }

    @GetMapping("/userAccount")
    public UserAccount currentMember(@AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception {
        String username = principalDetails.getUsername();
        return userAccountService.getUserByUsername(username);
    }
}
