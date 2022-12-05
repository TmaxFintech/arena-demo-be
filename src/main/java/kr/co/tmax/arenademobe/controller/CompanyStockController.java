package kr.co.tmax.arenademobe.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import kr.co.tmax.arenademobe.common.CommonResponse;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.service.CompanyStockService;
import kr.co.tmax.arenademobe.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
public class CompanyStockController {

    private final UserAccountService userAccountService;
    private final CompanyStockService companyStockService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @GetMapping("hotnews")
    public ResponseEntity<CommonResponse> getHotNews() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserAccount userAccount = userAccountService.getUserByUsername(username);
        List<CompanyStock> hotNews = companyStockService.getRecommend(userAccount);

        if (hotNews.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.withMessage("추천할 기사가 없습니다."));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.withMessageAndData("핫뉴스 조회 성공", hotNews));
    }
}
