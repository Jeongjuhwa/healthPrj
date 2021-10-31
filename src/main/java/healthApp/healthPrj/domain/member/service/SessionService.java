package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.common.security.JwtService;
import healthApp.healthPrj.domain.member.dto.LoginForm;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import healthApp.healthPrj.domain.member.repository.MemberRepository;
import healthApp.healthPrj.domain.member.repository.query.MemberQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final GymRepository gymRepository;

    public String login(LoginForm loginForm, int duration){

        String loginType = loginForm.getLoginType();

        if(loginTypeEq(loginType)){
            Optional<Member> email = memberRepository.findByEmailId(loginForm.getEmailId());
            Member member = email.orElseThrow(() -> new HealthAppException(ErrorCode.MEMBER_NOT_FOUND));
            member.checkPassword(loginForm.getPassword(), passwordEncoder);
            return jwtService.createToken(member.createPayload(), ZonedDateTime.now().plusSeconds(duration));
        }else{
            Optional<Gym> email = gymRepository.findByEmailId(loginForm.getEmailId());
            Gym gym = email.orElseThrow(() -> new HealthAppException(ErrorCode.GYM_NOT_FOUND));
            gym.checkPassword(loginForm.getPassword(), passwordEncoder);
            return jwtService.createToken(gym.createPayload(),ZonedDateTime.now().plusSeconds(duration));
        }

    }

    private boolean loginTypeEq(String loginType) {
        return "일반".equals(loginType);
    }
}
