package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Trainer;
import healthApp.healthPrj.repository.custom.TrainerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long>, TrainerRepositoryCustom {
}
