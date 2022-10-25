package kr.co.tmax.arenademobe.repository;

import kr.co.tmax.arenademobe.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
