package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long>, GymRepositoryCustom {

    Long countByGymNumber(String gymNumber);


}
