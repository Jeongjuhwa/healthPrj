package healthApp.healthPrj.domain.admin.dto;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.member.model.Gym;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class WaitJoinGymDto {

    private String gymName;

    private String gymNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private JoinStatus status;

    public WaitJoinGymDto(Gym gym) {
        this.gymName = gym.getGymName();
        this.gymNumber = gym.getGymNumber();
        this.address = gym.getAddress();
        this.status = gym.getStatus();
    }
}
