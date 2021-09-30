package healthApp.healthPrj;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.common.dto.Result;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.domain.gym.repository.GymRepository;
import healthApp.healthPrj.domain.gym.service.GymService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AdminApiController {

    private final GymRepository gymRepository;
    private final GymService gymService;

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

    /**
     * 헬스장 가입승인
     */
    @PostMapping("/admin/gym/{gymId}/accept")
    public AcceptResponse acceptGym(@PathVariable("gymId") Long id){

        Long gymId = gymService.acceptGym(id);


        return new AcceptResponse(gymId,"가입승인되었습니다.");

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

    @Data
    static class AcceptResponse{

        private Long id;

        private String message;

        public AcceptResponse(Long id, String message) {
            this.id = id;
            this.message = message;
        }

    }
}
