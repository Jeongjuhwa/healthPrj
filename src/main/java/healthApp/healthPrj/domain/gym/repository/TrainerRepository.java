package healthApp.healthPrj.domain.gym.repository;

import healthApp.healthPrj.domain.gym.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long>, TrainerRepositoryCustom {
}
