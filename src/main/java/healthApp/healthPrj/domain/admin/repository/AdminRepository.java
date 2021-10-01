package healthApp.healthPrj.domain.admin.repository;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.domain.gym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Gym, Long> {

    List<Gym> findAllPendingByStatus(JoinStatus joinStatus);
}
