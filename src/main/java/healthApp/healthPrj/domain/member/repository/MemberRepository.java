package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom{

    Optional<Member> findByEmailId(String emailId);

    Long countByEmailId(String emailId);







}
