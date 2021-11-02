package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.domain.member.model.Trainer;
import lombok.Data;

@Data
public class TrainerForm {

    private String trainerName;

    private Integer trainerAge;

    private Integer trainerCareer;

    public Trainer entity(){
        return Trainer.builder()
                .trainerName(trainerName)
                .trainerAge(trainerAge)
                .trainerCareer(trainerCareer)
                .build();
    }

}
