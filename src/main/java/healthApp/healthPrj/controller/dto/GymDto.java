package healthApp.healthPrj.controller.dto;

import healthApp.healthPrj.entity.Gym;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GymDto {
    private List<MemberDto> memberList;

    public GymDto(Gym gym) {
        memberList = gym.getMemberList().stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
    }
}
