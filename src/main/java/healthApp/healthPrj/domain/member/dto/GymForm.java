package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.service.GymValidator;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class GymForm {

    @NotEmpty
    private String gymName;

    @NotEmpty
    private String emailId;

    @NotEmpty
    private String password;

    @NotEmpty
    @Size(max = 10)
    private String gymNumber;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private String zipcode;

    public Gym entity(PasswordEncoder passwordEncoder){
        encryptPassword(passwordEncoder);

        return Gym.builder()
                .gymName(gymName)
                .emailId(emailId)
                .password(password)
                .gymNumber(gymNumber)
                .address(new Address(city,street,zipcode))
                .build();
    }

    public void validate(GymValidator gymValidator){
        gymValidator.validateDuplicateGymNumber(this.gymNumber);
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

}
