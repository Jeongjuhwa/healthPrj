package healthApp.healthPrj.domain.member.model;

import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trainer extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "trainer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    private String trainerName;

    private int trainerAge;

    private int trainerCareer;


    public Trainer mapGym(Gym gym){
        this.gym = gym;
        return this;
    }




}
