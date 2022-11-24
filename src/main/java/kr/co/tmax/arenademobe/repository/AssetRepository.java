package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    public Asset findByAssetName(String assetName);
}
