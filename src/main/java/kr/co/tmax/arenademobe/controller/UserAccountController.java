package kr.co.tmax.arenademobe.controller;

import kr.co.tmax.arenademobe.common.CommonResponse;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.service.UserAccountService;
import kr.co.tmax.arenademobe.validator.UserAccountValidator;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1", produces = "application/json; charset=utf-8")
@RestController
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserAccountValidator userAccountValidator;

    @InitBinder
    public void initItem(WebDataBinder dataBinder) {
        dataBinder.addValidators(userAccountValidator);
    }

}
