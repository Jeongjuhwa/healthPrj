package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymValidator {
    
    private final GymRepository gymRepository;

    public void validateDuplicateGymNumber(String gymNumber) {

        Long count = gymRepository.countByGymNumber(gymNumber);

        if(isPresent(count)){
            throw new HealthAppException(ErrorCode.DUPLICATE_GYMNUMBER);
        }

    }

    private boolean isPresent(Long count) {
        return count == 1;
    }
}
