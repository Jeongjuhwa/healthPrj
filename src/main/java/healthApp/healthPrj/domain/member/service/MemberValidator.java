package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberValidator {

    private final MemberRepository memberRepository;

    public void validationDuplicateMember(String email) {
        Long count = memberRepository.countByEmailId(email);
        if(isPresent(count)){
            throw new HealthAppException(ErrorCode.DUPLICATE_EMAIL);
        }

    }

    private boolean isPresent(Long count) {
        return count == 1;
    }
}
