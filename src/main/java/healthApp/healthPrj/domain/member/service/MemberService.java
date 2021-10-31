package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.domain.member.dto.MemberForm;
import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    @Transactional
    public void join(MemberForm memberForm){

        Member member = memberForm.entity(memberValidator, passwordEncoder);
        memberRepository.save(member);


    }

}
