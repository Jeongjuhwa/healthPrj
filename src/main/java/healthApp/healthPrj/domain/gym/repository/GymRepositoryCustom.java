package healthApp.healthPrj.domain.gym.repository;

import healthApp.healthPrj.domain.gym.dto.GymDto;
import healthApp.healthPrj.domain.gym.dto.GymSearchCondition;
import healthApp.healthPrj.domain.gym.model.Gym;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GymRepositoryCustom {


    List<Gym> findAcceptGym();

    Page<GymDto> findByGymSearchCondition(GymSearchCondition gymSearchCondition, Pageable pageable);




}
