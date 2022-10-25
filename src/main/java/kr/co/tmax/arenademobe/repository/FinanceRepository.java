package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.Finance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FinanceRepository extends MongoRepository<Finance, String> {

    List<Finance> findBySection(String section);
    List<Finance> findTop5ByMedia(String media);


}
