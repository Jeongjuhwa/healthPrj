package healthApp.healthPrj.domain.gym.repository;

import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.common.enums.JoinStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long>, GymRepositoryCustom {

    Long countByGymNumber(String gymNumber);


}
