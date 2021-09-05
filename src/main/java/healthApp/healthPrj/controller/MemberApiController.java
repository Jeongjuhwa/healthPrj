package healthApp.healthPrj.controller;

import healthApp.healthPrj.entity.Address;
import healthApp.healthPrj.entity.Member;
import healthApp.healthPrj.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("members")
    public createMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request){
        Address address = new Address(request.getCity(),request.getStreet(), request.getZipcode());
        Member member = new Member(request.getEmailId(), request.getPassword(), request.getMemberName(), request.getMemberAge(), request.getMemberSex(),address );
        Long memberId = memberService.join(member);
        return new createMemberResponse(memberId, "가입 완료");
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
