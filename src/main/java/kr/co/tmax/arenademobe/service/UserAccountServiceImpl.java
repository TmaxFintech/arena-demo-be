package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserAccount getUserByEmail(String email) throws Exception {
        return memberRepository.findByEmail(email);
    }

    @Override
    public UserAccount getUserByUsername(String username) throws Exception {
        return memberRepository.findByUsername(username);
    }

    @Override
    public void saveUser(UserAccount userAccount) {
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        memberRepository.save(userAccount);
    }
}
