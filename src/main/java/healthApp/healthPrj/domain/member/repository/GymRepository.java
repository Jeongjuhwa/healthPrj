package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {

    Long countByGymNumber(String gymNumber);


}
