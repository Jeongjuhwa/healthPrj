package healthApp.healthPrj.domain.member;

import healthApp.healthPrj.common.security.annotation.JwtClaim;
import healthApp.healthPrj.domain.member.dto.GymForm;
import healthApp.healthPrj.domain.member.dto.GymSearchCondition;
import healthApp.healthPrj.domain.member.dto.TrainerForm;
import healthApp.healthPrj.domain.member.service.TrainerService;
import healthApp.healthPrj.domain.member.service.query.GymQueryService;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import healthApp.healthPrj.domain.member.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gym")
public class GymApiController {

    private final GymService gymService;
    private final GymQueryService gymQueryService;
    private final TrainerService trainerService;

    /**
     * 헬스장가입
     * @return ResponseEntity<?>
     */

    @PostMapping("/join")
    public ResponseEntity<?> saveGym(@RequestBody @Valid GymForm gymForm){

        gymService.join(gymForm);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    /**
     * 헬스장 목록 조회
     */
    @GetMapping
    public ResponseEntity<?> findGyms(GymSearchCondition gymSearchCondition, Pageable pageable){

        return ResponseEntity.ok(gymQueryService.findByGymSearchCondition(gymSearchCondition,pageable));

    }

    /**
     * 내 헬스장 회원 목록 조회
     */
    @GetMapping("/member")
    public ResponseEntity<?> findGymMembers(@JwtClaim("info.id") Long gymId, Pageable pageable){

        return ResponseEntity.ok(gymQueryService.findGymMembers(gymId,pageable));

    }

    /**
     * 트레이너 등록
     */
    @PostMapping("/trainer")
    public ResponseEntity<?> registerTrainer(@JwtClaim("info.id")Long gymId, TrainerForm trainerForm){
        trainerService.registerTrainer(gymId, trainerForm);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }






}
