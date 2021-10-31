package healthApp.healthPrj.domain.member.dto;

import lombok.Data;

@Data
public class LoginForm {
    private String emailId;
    private String password;
    private String loginType;

}
