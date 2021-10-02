package healthApp.healthPrj.domain.gym.service;

import healthApp.healthPrj.domain.gym.dto.GymForm;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.domain.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;
    private final GymValidator gymValidator;

    /**
     * 헬스장 등록
     */
    @Transactional
    public void join(GymForm gymForm){

        gymForm.validate(gymValidator);

        Gym gym = gymForm.entity();


        gymRepository.save(gym);


    }



    /**
     * 헬스장 전체 목록 조회
     */
    public List<Gym> findGyms(){
        return gymRepository.findAll();
    }


}
