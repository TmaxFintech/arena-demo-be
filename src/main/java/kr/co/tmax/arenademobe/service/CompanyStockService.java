package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.CompanyStock;
import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.repository.CompanyStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CompanyStockService {

    private final CompanyStockRepository companyStockRepository;

    public List<CompanyStock> getRecommend(UserAccount userAccount) {
        String preferred1st = userAccount.getPreferred1st();
        String preferred2nd = userAccount.getPreferred2nd();
        String preferred3rd = userAccount.getPreferred3rd();

        List<CompanyStock> top3ByAssetName = companyStockRepository.findTop3ByAssetName(preferred1st);
        List<CompanyStock> top2ByAssetName = companyStockRepository.findTop2ByAssetName(preferred2nd);
        List<CompanyStock> top1ByAssetName = companyStockRepository.findTop1ByAssetName(preferred3rd);

        List<CompanyStock> collect = Stream.concat(top3ByAssetName.stream(), top2ByAssetName.stream()).collect(Collectors.toList());
        return Stream.concat(collect.stream(), top1ByAssetName.stream()).collect(Collectors.toList());
    }
}
