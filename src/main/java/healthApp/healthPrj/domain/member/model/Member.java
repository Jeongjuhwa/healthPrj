package healthApp.healthPrj.domain.member.model;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.common.base.BaseEntity;
import healthApp.healthPrj.domain.member.dto.MemberGymPayload;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public Member(String emailId, String password, String memberName, int memberAge, String memberSex, Address address) {
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

    public void checkPassword(String password, PasswordEncoder passwordEncoder){
        if(passwordIsNotEqual(password, passwordEncoder)){
            throw new HealthAppException(ErrorCode.NOT_EQUAL_PASSWORD);
        }
    }

    private boolean passwordIsNotEqual(String password, PasswordEncoder passwordEncoder) {
        return !passwordEncoder.matches(password, this.password);
    }

    public MemberGymPayload createPayload(){return new MemberGymPayload(id, emailId);}


}
