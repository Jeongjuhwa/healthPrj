package healthApp.healthPrj.domain.gym.service;

import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.domain.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    /**
     * 헬스장 등록
     */
    @Transactional
    public Long join(Gym gym){
        validateDuplicateGymNumber(gym);

        gymRepository.save(gym);

        return gym.getId();

    }

    private void validateDuplicateGymNumber(Gym gym) {

        Optional<Gym> findGym = gymRepository.findByGymNumber(gym.getGymNumber());

        if(!findGym.isEmpty()){
            throw new IllegalStateException("이미 등록된 업체입니다.");
        }

    }

    /**
     * 헬스장 전체 목록 조회
     */
    public List<Gym> findGyms(){
        return gymRepository.findAll();
    }

    /**
     * 가입 승인(헬스장)
     */
    @Transactional
    public Long acceptGym(Long id){
        Optional<Gym> findGym = gymRepository.findById(id);
        Gym gym = findGym.get();
        gym.accept();

        return gym.getId();

    }
}
