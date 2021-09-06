package healthApp.healthPrj.entity;

import healthApp.healthPrj.entity.base.BaseEntity;
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
public class Gym extends BaseEntity implements Persistable<Long> {

    @Id @GeneratedValue
    @Column(name = "gym_id")
    private Long id;

    @OneToMany(mappedBy = "gym")
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "gym")
    private List<Trainer> trainerList = new ArrayList<>();

    private String gymName;

    private String gymNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private JoinStatus status;

    @Override
    public boolean isNew() {
        return this.getCreatedDate() == null;
    }

    public Gym(String gymName, String gymNumber, Address address) {
        this.gymName = gymName;
        this.gymNumber = gymNumber;
        this.address = address;
        this.status = JoinStatus.PENDING;
    }
}
