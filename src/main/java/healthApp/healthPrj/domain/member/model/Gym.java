package healthApp.healthPrj.domain.member.model;

import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.domain.member.dto.MemberGymPayload;
import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gym extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "gym_id")
    private Long id;

    private String emailId;

    private String password;

    private String gymName;

    private String gymNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private JoinStatus status;

    @Builder
    public Gym(String emailId, String password, String gymName, String gymNumber, Address address, JoinStatus status) {
        this.emailId = emailId;
        this.password = password;
        this.gymName = gymName;
        this.gymNumber = gymNumber;
        this.address = address;
        this.status = JoinStatus.PENDING;
    }




    /**
     * 가입승인
     */
    public void accept() {
        if(isNotPending()){
            throw new HealthAppException(ErrorCode.GYM_NOT_PENDING);
        }
        this.status = JoinStatus.ACCEPT;
    }

    private boolean isNotPending() {
        return this.getStatus() != JoinStatus.PENDING;
    }

    public void checkJoinStatus(){
        if(isNotAccept()){
            throw new HealthAppException(ErrorCode.GYM_NOT_ACCEPT);
        }
    }

    private boolean isNotAccept() {
        return this.getStatus() != JoinStatus.ACCEPT;
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
