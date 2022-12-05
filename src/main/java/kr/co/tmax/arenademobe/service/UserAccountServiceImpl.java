package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserAccount getUserByEmail(String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserAccount getUserByUsername(String username) {
        return memberRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void saveUser(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        userAccount.setRoles(Collections.singletonList("ROLE_USER"));
        System.out.println("userAccount = " + userAccount);
        memberRepository.save(userAccount);
    }
}
