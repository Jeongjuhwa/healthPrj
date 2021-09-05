package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
