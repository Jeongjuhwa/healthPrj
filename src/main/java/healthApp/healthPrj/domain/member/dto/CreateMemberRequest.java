package healthApp.healthPrj.domain.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateMemberRequest {

    @NotEmpty
    private String emailId;

    @NotEmpty
    private String password;

    private String memberName;

    private int memberAge;

    private String memberSex;

    private String city;

    private String street;

    private String zipcode;

}
