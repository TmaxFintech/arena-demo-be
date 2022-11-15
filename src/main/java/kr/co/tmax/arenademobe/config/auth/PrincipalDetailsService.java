package kr.co.tmax.arenademobe.config.auth;

import kr.co.tmax.arenademobe.domain.UserAccount;
import kr.co.tmax.arenademobe.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserAccountRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount member = memberRepository.findByUsername(username);
        System.out.println("member = " + member);
        if (member != null) {
            return new PrincipalDetails(member);
        }
        return null;
    }
}
