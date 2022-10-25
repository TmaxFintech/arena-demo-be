package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyStockRepositoryTest {

    @Autowired
    private CompanyStockRepository companyStockRepository;

}