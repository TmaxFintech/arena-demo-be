package kr.co.tmax.arenademobe.validator;

import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import kr.co.tmax.arenademobe.service.AssetService;
import kr.co.tmax.arenademobe.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAccountValidator implements Validator {

    private final UserAccountService userAccountService;
    private final AssetService assetService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserAccount.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.debug("{}.{}() is called", this.getClass().getSimpleName(), "validate");

        UserAccount userAccount = (UserAccount) target;

        if (userAccountService.getUserByUsername(userAccount.getUsername()) != null) {
            errors.rejectValue("username", "duplicated");
        }

        if (userAccountService.getUserByEmail(userAccount.getEmail()) != null) {
            errors.rejectValue("email", "duplicated");
        }

        if (assetService.findAssetByAssetName(userAccount.getPreferred1st()) == null) {
            errors.rejectValue("preferred1st", "required");
        }

        if (assetService.findAssetByAssetName(userAccount.getPreferred2nd()) == null) {
            errors.rejectValue("preferred2nd", "required");
        }

        if (assetService.findAssetByAssetName(userAccount.getPreferred3rd()) == null) {
            errors.rejectValue("preferred3rd", "required");
        }
    }
}
