package healthApp.healthPrj.domain.member.service;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.domain.member.dto.TrainerForm;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.model.Trainer;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import healthApp.healthPrj.domain.member.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TrainerService {

    private final GymRepository gymRepository;
    private final TrainerRepository trainerRepository;

    @Transactional
    public void registerTrainer(Long gymId, TrainerForm trainerForm){

        Trainer trainer = trainerForm.entity();
        Gym gym = gymRepository.findById(gymId).orElseThrow(() -> new HealthAppException(ErrorCode.GYM_NOT_FOUND));
        trainer.mapGym(gym);
        trainerRepository.save(trainer);

    }

}
