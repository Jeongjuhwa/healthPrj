package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
