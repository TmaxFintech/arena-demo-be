package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.Asset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssetServiceTest {

    @Autowired
    private AssetService assetService;

    @Test
    void assettest() {
        Asset 삼성전자 = assetService.findAssetByAssetName("삼성전");
        System.out.println("삼성전자 = " + 삼성전자);
    }
}