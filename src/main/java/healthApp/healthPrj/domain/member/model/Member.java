package healthApp.healthPrj.domain.member.model;

import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.gym.model.Trainer;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements Persistable<Long> {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String emailId;

    private String password;

    private String memberName;

    private int memberAge;

    private String memberSex;

    @Embedded
    private Address address;

    @JoinColumn(name = "gym_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @Override
    public boolean isNew() {
        return this.getCreatedDate() == null;
    }

    @Builder
    public Member(Long id, String emailId, String password, String memberName, int memberAge, String memberSex, Address address, Gym gym, Trainer trainer) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberSex = memberSex;
        this.address = address;
        this.gym = gym;
        this.trainer = trainer;
    }


    /**
     * 연관관계 메서드
     */
    public void setGym(Gym gym){
        this.gym =gym;
        gym.getMemberList().add(this);
    }

    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
        trainer.getMemberList().add(this);
    }
}
