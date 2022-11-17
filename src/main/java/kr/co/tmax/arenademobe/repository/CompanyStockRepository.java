package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompanyStockRepository extends JpaRepository<CompanyStock, Long> {

    List<CompanyStock> findTop3ByAssetName(String assetName);
    List<CompanyStock> findTop2ByAssetName(String assetName);
    List<CompanyStock> findTop1ByAssetName(String assetName);
}
