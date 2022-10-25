package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.Finance;
import kr.co.tmax.arenademobe.repository.FinanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private final FinanceRepository financeRepository;

    public List<Finance> getFinanceNews() {
        return financeRepository.findTop5ByMedia("조선비즈");
    }
}
