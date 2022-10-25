package kr.co.tmax.arenademobe.controller;


import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.domain.Finance;
import kr.co.tmax.arenademobe.domain.Member;
import kr.co.tmax.arenademobe.repository.MemberRepository;
import kr.co.tmax.arenademobe.service.CompanyStockService;
import kr.co.tmax.arenademobe.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;
    private final MemberRepository memberRepository;
    private final CompanyStockService companyStockService;

    @GetMapping("/api")
    public List<Finance> get() {
        System.out.println("hi");
        System.out.println(financeService.getFinanceNews());
        return financeService.getFinanceNews();
    }

    @GetMapping("/api/v0/hotnews")
    public List<CompanyStock> getHotNews() {
        return companyStockService.getRecommend(memberRepository.findById(1L).get());
    }

    @PostConstruct
    public void init() {
        memberRepository.save(new Member(1L, "userA", "삼성전자", "LG에너지솔루션", "현대차"));
    }
}
