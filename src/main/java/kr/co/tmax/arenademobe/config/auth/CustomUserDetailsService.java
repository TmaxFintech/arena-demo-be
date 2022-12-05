package kr.co.tmax.arenademobe.config.auth;

import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.exception.UserNotFoundException;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    public UserDetails loadUserByUsername(String userPk) {
        return userAccountRepository.findById(Long.valueOf(userPk)).orElseThrow(UserNotFoundException::new);
    }
}
