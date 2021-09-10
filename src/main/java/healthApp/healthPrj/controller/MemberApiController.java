package healthApp.healthPrj.controller;

import healthApp.healthPrj.controller.dto.MemberDto;
import healthApp.healthPrj.controller.dto.Result;
import healthApp.healthPrj.entity.Address;
import healthApp.healthPrj.entity.Member;
import healthApp.healthPrj.repository.MemberRepository;
import healthApp.healthPrj.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * @param request
     * @return createMemberResponse
     */
    @PostMapping("/members")
    public createMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request){
        Address address = new Address(request.getCity(),request.getStreet(), request.getZipcode());
        Member member = new Member(request.getEmailId(), request.getPassword(), request.getMemberName(), request.getMemberAge(), request.getMemberSex(),address );
        Long memberId = memberService.join(member);
        return new createMemberResponse(memberId, "가입 완료");
    }

    /**
     * 회원전체조회
     * @return Result<MemberDTO>
     * 헬스장 계정이 회원등록을 위해 회원전체목록을 조회하는 API(페이징 처리)
     */
    @GetMapping("/members")
    public Result findAllMemberByPage(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                      @RequestParam(value = "limit", defaultValue = "100") int limit){

        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Member> all = memberRepository.findAll(pageRequest);
        Page<MemberDto> map = all.map(m -> new MemberDto(m));
        long totalElements = map.getTotalElements();
        return new Result(totalElements,map);

    }








    @Data
    static class createMemberResponse{

        private Long id;

        private String message;

        public createMemberResponse(Long id, String message) {
            this.id = id;
            this.message = message;
        }

    }

    @Data
    static class CreateMemberRequest{

        @NotEmpty
        private String emailId;

        @NotEmpty
        private String password;

        private String memberName;

        private int memberAge;

        private String memberSex;

        private String city;

        private String street;

        private String zipcode;

    }
}
