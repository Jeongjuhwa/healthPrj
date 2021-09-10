package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Member;

import healthApp.healthPrj.repository.custom.MemberRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom{

    Optional<Member> findByEmailId(String emailId);







}
