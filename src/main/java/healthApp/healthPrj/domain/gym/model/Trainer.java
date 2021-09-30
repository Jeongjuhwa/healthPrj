package healthApp.healthPrj.domain.gym.model;

import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trainer extends BaseEntity implements Persistable<Long> {

    @Id @GeneratedValue
    @Column(name = "trainer_id")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @OneToMany(mappedBy = "trainer" )
    private List<Member> memberList = new ArrayList<>();

    private String trainerName;

    private int trainerAge;

    private int trainerCareer;

    @Override
    public boolean isNew() {
        return this.getCreatedDate() == null;
    }

    /**
     * 연관관계 메서드
     */
    public void setGym(Gym gym){
        this.gym = gym;
        gym.getTrainerList().add(this);
    }


}
