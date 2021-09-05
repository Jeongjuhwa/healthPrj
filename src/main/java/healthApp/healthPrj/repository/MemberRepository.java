package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByEmailId(String emailId);
}
