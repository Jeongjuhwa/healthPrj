package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long> {

    Optional<Gym> findByGymNumber(String gymNumber);
}
