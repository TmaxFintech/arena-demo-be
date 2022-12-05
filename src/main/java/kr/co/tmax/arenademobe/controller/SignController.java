package kr.co.tmax.arenademobe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.tmax.arenademobe.common.CommonResponse;
import kr.co.tmax.arenademobe.common.CommonResult;
import kr.co.tmax.arenademobe.common.SingleResult;
import kr.co.tmax.arenademobe.config.auth.JwtTokenProvider;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.exception.UserNotFoundException;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import kr.co.tmax.arenademobe.service.ResponseService;
import kr.co.tmax.arenademobe.service.UserAccountService;
import kr.co.tmax.arenademobe.validator.UserAccountValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserAccountRepository userAccountRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;
    private final UserAccountService userAccountService;
    private final UserAccountValidator userAccountValidator;

    @InitBinder
    public void initItem(WebDataBinder dataBinder) {
        dataBinder.addValidators(userAccountValidator);
    }

    @ApiOperation(value = "로그인", notes = "회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원ID : 닉네임", required = true) @RequestParam String username,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {
        UserAccount userAccount = userAccountRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(password, userAccount.getPassword()))
            throw new UserNotFoundException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(userAccount.getId()), userAccount.getRoles()));

    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> join(@RequestBody @Validated UserAccount userAccount, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new BindException((bindingResult));
        }

        userAccountService.saveUser(userAccount);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.withMessage("회원가입 성공"));
    }
}