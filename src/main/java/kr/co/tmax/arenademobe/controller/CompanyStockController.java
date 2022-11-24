package kr.co.tmax.arenademobe.controller;


import kr.co.tmax.arenademobe.common.CommonResponse;
import kr.co.tmax.arenademobe.config.auth.PrincipalDetails;
import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.service.CompanyStockService;
import kr.co.tmax.arenademobe.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompanyStockController {

    private final UserAccountService userAccountService;
    private final CompanyStockService companyStockService;

    @GetMapping("/api/v0/hotnews")
    public ResponseEntity<CommonResponse> getHotNews(@AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception {
        String username = principalDetails.getUsername();
        UserAccount userAccount = userAccountService.getUserByUsername(username);
        List<CompanyStock> hotNews = companyStockService.getRecommend(userAccount);
        log.info("hotNews: {}", hotNews);

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
