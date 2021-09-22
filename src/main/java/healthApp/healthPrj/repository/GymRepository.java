package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Gym;
import healthApp.healthPrj.entity.JoinStatus;
import healthApp.healthPrj.repository.custom.GymRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long>, GymRepositoryCustom {

    Optional<Gym> findByGymNumber(String gymNumber);

    List<Gym> findAllPendingByStatus(JoinStatus joinStatus);
}
