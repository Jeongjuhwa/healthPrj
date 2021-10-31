package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.domain.member.service.MemberValidator;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

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

    public Member entity(MemberValidator memberValidator, PasswordEncoder passwordEncoder){
        validate(memberValidator);
        encryptPassword(passwordEncoder);
        return Member
                .builder()
                .emailId(emailId)
                .password(password)
                .memberName(memberName)
                .memberAge(memberAge)
                .memberSex(memberSex)
                .address(new Address(city,street,zipcode))
                .build();
    }

    public void validate(MemberValidator memberValidator){
        memberValidator.validationDuplicateMember(emailId);
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) { this.password = passwordEncoder.encode(this.password); }
}
