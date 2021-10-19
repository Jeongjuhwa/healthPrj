package healthApp.healthPrj.domain.member;

import healthApp.healthPrj.domain.member.dto.MemberForm;
import healthApp.healthPrj.domain.member.dto.MemberSearch;
import healthApp.healthPrj.domain.member.service.MemberService;
import healthApp.healthPrj.domain.member.service.query.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;
    private final MemberQueryService memberQueryService;

    /**
     * 회원가입
     * @param memberForm
     * @return ResponseEntity<?>
     */
    @PostMapping("/join")
    public ResponseEntity<?> saveMember(@RequestBody @Valid MemberForm memberForm){

        memberService.join(memberForm);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    /**
     * 회원전체조회(이름 검색 기능)
     * @return ResponseEntity<?>
     * 헬스장 계정이 회원등록을 위해 회원전체목록을 조회하는 API(페이징 처리)
     */
    @GetMapping
    public ResponseEntity<?> findMemberByMemberSearch(MemberSearch memberSearch, Pageable pageable){

        return ResponseEntity.ok(memberQueryService.findByMemberSearch(memberSearch,pageable));

    }

    /**
     * 헬스장별 회원조회
     */
    @GetMapping("/gym/{gymId}")
    public ResponseEntity<?> findMemberByGym(@PathVariable Long gymId, Pageable pageable){


        return ResponseEntity.ok(memberQueryService.findMemberByGym(gymId, pageable));

    }




}
