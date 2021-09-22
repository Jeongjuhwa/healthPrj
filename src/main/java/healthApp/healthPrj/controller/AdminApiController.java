package healthApp.healthPrj.controller;

import healthApp.healthPrj.controller.dto.GymDto;
import healthApp.healthPrj.controller.dto.Result;
import healthApp.healthPrj.entity.*;
import healthApp.healthPrj.repository.GymRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AdminApiController {

    private final GymRepository gymRepository;

    /**
     * 등록대기 헬스장 목록 조회
     * @param
     * @return Result
     */

    @GetMapping("/admin/wait/gym")
    public Result findWaitJoinGym(){

        List<Gym> findGyms = gymRepository.findAllPendingByStatus(JoinStatus.PENDING);
        List<InnerGymDto> collect = findGyms.stream().map(gym -> new InnerGymDto(gym)).collect(Collectors.toList());

        return new Result(collect.size(),collect);

    }

    @Data
    static class InnerGymDto{

        private String gymName;

        private String gymNumber;

        @Embedded
        private Address address;

        @Enumerated(EnumType.STRING)
        private JoinStatus status;

        public InnerGymDto(Gym gym) {
            this.gymName = gym.getGymName();
            this.gymNumber = gym.getGymNumber();
            this.address = gym.getAddress();
            this.status = gym.getStatus();
        }
    }
}
