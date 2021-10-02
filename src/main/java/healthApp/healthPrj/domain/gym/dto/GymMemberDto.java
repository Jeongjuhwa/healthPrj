package healthApp.healthPrj.domain.gym.dto;

import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.gym.model.Gym;
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
