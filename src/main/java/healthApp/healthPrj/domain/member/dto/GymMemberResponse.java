package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.common.object.Address;
import lombok.Getter;

@Getter
public class GymMemberResponse {

    private final String memberName;
    private final Integer memberAge;
    private final String memberSex;
    private final Address address;

    public GymMemberResponse(String memberName, Integer memberAge, String memberSex, Address address) {
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberSex = memberSex;
        this.address = address;
    }

    public String getAddress(){return address.address();}
}
