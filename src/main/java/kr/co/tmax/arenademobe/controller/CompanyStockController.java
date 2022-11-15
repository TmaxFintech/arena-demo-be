package kr.co.tmax.arenademobe.controller;


import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import kr.co.tmax.arenademobe.service.CompanyStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyStockController {

    private final UserAccountRepository memberRepository;
    private final CompanyStockService companyStockService;

    @GetMapping("/api/v0/hotnews")
    public List<CompanyStock> getHotNews() {
        return companyStockService.getRecommend(memberRepository.findById(1L).get());
    }
}
