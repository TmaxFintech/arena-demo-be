package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.domain.Member;
import kr.co.tmax.arenademobe.repository.CompanyStockRepository;
import kr.co.tmax.arenademobe.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyStockServiceTest {

    @Autowired
    private CompanyStockRepository companyStockRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CompanyStockService companyStockService;

    @BeforeEach
    public void 회원미리저장() {
        memberRepository.save(new Member(1L, "userA", "삼성전자", "LG에너지솔루션", "현대차"));
    }

    @Test
    public void 추천로직테스트() {
        List<CompanyStock> recommend = companyStockService.getRecommend(memberRepository.findById(1L).get());
        System.out.println("recommend = " + recommend);
    }
}