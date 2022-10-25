package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyStockRepository extends MongoRepository<CompanyStock, String> {

    List<CompanyStock> findTop3ByAssetName(String assetName);
    List<CompanyStock> findTop2ByAssetName(String assetName);
    List<CompanyStock> findTop1ByAssetName(String assetName);
}
