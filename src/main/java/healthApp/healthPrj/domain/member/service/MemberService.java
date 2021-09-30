package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member){

        validationDuplicateMember(member);

        memberRepository.save(member);

        return member.getId();

    }
    private void validationDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findByEmailId(member.getEmailId());
        if(!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
}
