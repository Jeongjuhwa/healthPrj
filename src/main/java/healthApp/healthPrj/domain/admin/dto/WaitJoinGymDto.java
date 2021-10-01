package healthApp.healthPrj.domain.admin.dto;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.gym.model.Gym;
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
        this.gymName = gymName;
        this.gymNumber = gymNumber;
        this.address = address;
        this.status = status;
    }
}
