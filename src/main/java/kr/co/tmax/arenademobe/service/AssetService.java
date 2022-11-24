package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.Asset;
import kr.co.tmax.arenademobe.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public Asset findAssetByAssetName(String assetName) {
        return assetRepository.findByAssetName(assetName);
    }
}
