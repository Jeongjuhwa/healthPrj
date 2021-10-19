package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
