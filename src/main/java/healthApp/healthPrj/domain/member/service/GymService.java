package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.domain.member.dto.GymForm;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;
    private final GymValidator gymValidator;
    private final PasswordEncoder passwordEncoder;

    /**
     * 헬스장 등록
     */
    @Transactional
    public void join(GymForm gymForm){

        gymForm.validate(gymValidator);

        Gym gym = gymForm.entity(passwordEncoder);


        gymRepository.save(gym);


    }



    /**
     * 헬스장 전체 목록 조회
     */
    public List<Gym> findGyms(){
        return gymRepository.findAll();
    }


}
