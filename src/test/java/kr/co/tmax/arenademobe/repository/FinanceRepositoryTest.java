package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.Finance;
import kr.co.tmax.arenademobe.service.FinanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FinanceRepositoryTest {

    @Autowired
    FinanceRepository newsRepository;

    @Autowired
    FinanceService financeService;

    @Test
    public void 금융섹션뉴스_5개_조회() {
        List<Finance> results = financeService.getFinanceNews();
        System.out.println("results = " + results);
    }
}