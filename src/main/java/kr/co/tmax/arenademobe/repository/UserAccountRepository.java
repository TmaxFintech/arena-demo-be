package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByEmail(String email);

    public UserAccount findByUsername(String username);
}
