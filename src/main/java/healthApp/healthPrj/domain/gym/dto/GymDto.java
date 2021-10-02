package healthApp.healthPrj.domain.gym.dto;

import healthApp.healthPrj.common.object.Address;

import lombok.Data;

@Data
public class GymDto {

    private String gymName;
    private Address address;

    public GymDto(String gymName, Address address) {
        this.gymName = gymName;
        this.address = address;
    }
}
