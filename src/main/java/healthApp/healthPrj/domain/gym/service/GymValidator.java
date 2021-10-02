package healthApp.healthPrj.domain.gym.service;

import healthApp.healthPrj.domain.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymValidator {
    
    private final GymRepository gymRepository;

    public void validateDuplicateGymNumber(String gymNumber) {

        Long count = gymRepository.countByGymNumber(gymNumber);

        if(isPresent(count)){
            throw new IllegalStateException("이미 등록된 업체입니다.");
        }

    }

    private boolean isPresent(Long count) {
        return count == 1;
    }
}
