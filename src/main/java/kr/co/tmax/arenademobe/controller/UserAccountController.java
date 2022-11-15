package kr.co.tmax.arenademobe.controller;

import kr.co.tmax.arenademobe.config.auth.PrincipalDetails;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(UserAccount userAccount) throws Exception {
        userAccount.setRole("ROLE_MEMBER");
        userAccountService.saveUser(userAccount);
        return "redirect:/loginForm";
    }

    @ResponseBody
    @GetMapping("api/v0/userAccount")
    public UserAccount currentMember(@AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception {
        String username = principalDetails.getUsername();
        UserAccount userAccount = userAccountService.getUserByUsername(username);
        return userAccount;
    }
}
