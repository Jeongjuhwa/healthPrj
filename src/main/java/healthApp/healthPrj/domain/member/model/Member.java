package healthApp.healthPrj.domain.member.model;

import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    private String emailId;

    private String password;

    private String memberName;

    private Integer memberAge;

    private String memberSex;

    @Embedded
    private Address address;


    @Builder
    public Member(Long id, String emailId, String password, String memberName, int memberAge, String memberSex, Address address) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberSex = memberSex;
        this.address = address;

    }

    public Member mapGym(Gym gym){
        this.gym = gym;
        return this;
    }


}
