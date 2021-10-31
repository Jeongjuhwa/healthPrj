package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long> {

    Optional<Gym> findByEmailId(String emailId);
    Long countByGymNumber(String gymNumber);


}
