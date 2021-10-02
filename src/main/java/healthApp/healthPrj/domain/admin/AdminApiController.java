package healthApp.healthPrj.domain.admin;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.common.dto.Result;
import healthApp.healthPrj.domain.admin.dto.WaitJoinGymDto;
import healthApp.healthPrj.domain.admin.service.AdminService;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.domain.gym.repository.GymRepository;
import healthApp.healthPrj.domain.gym.service.GymService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminApiController {

    private final AdminService adminService;

    /**
     * 등록대기 헬스장 목록 조회
     * @param
     * @return Result
     */

    @GetMapping("/wait/gym")
    public ResponseEntity<?> findWaitJoinGym(){

        List<WaitJoinGymDto> findWaitJoinGym = adminService.findAllPendingByStatus(JoinStatus.PENDING);

        return ResponseEntity.ok(findWaitJoinGym);


    }

    /**
     * 헬스장 가입승인
     */
    @PostMapping("/gym/{gymId}/accept")
    public ResponseEntity<?> acceptGym(@PathVariable("gymId") Long id){

        adminService.acceptGym(id);


        return ResponseEntity.ok(HttpStatus.CREATED);

    }




}
