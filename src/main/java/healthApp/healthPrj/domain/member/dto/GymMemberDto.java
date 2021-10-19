package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.domain.member.model.Gym;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GymMemberDto {
    private List<MemberDto> memberList;

    public GymMemberDto(Gym gym) {
        memberList = gym.getMemberList().stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
    }
}
