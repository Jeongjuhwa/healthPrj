package healthApp.healthPrj.controller;

import healthApp.healthPrj.controller.dto.MemberDto;
import healthApp.healthPrj.controller.dto.Result;
import healthApp.healthPrj.entity.Address;
import healthApp.healthPrj.entity.Gym;
import healthApp.healthPrj.entity.Member;
import healthApp.healthPrj.repository.GymRepository;
import healthApp.healthPrj.repository.MemberRepository;
import healthApp.healthPrj.service.GymService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GymApiController {

    private final GymService gymService;
    private final GymRepository gymRepository;
    private final MemberRepository memberRepository;

    /**
     * 헬스장가입
     * @param request
     * @return createGymResponse
     */

    @PostMapping("/gym")
    public createGymResponse saveGym(@RequestBody @Valid createGymRequest request){

        Address address = new Address(request.getCity(), request.getStreet(), request.getZipcode());
        Gym gym = new Gym(request.getGymName(),request.getGymNumber(),address);

        Long gymId = gymService.join(gym);


        return new createGymResponse(gymId,"등록완료");
    }

    /**
     * 헬스장 목록 전체 조회
     */
    @GetMapping("/gyms")
    public Result findGyms(){
        List<Gym> gymList = gymService.findGyms();

        List<GymDto> collect = gymList.stream().map(gym -> new GymDto(gym)).collect(Collectors.toList());

        return new Result(collect.size(),collect);

    }

    /**
     * 헬스장 별 가입회원 조회
     * @param id
     * @return Result
     */
    @GetMapping("/gym/members/{id}")
    public Result findGymMembers(@PathVariable("id") Long id){

        Optional<Gym> findGym = gymRepository.findById(id);
        Gym gym = findGym.get();
        List<Member> memberList = gym.getMemberList();
        List<MemberDto> collect = memberList.stream().map(m -> new MemberDto(m)).collect(Collectors.toList());

        return new Result(collect.size(),collect);


    }

    @Data
    static class GymDto{
        private String gymName;
        private Address address;

        public GymDto(Gym gym) {
            this.gymName = gym.getGymName();
            this.address = gym.getAddress();
        }
    }






    @Data
    static class createGymResponse{
        private Long id;
        private String message;

        public createGymResponse(Long id, String message) {
            this.id = id;
            this.message = message;
        }
    }

    @Data
    static class createGymRequest{
        @NotEmpty
        private String gymName;
        @NotEmpty
        @Size(max = 10)
        private String gymNumber;
        @NotEmpty
        private String city;
        @NotEmpty
        private String street;
        @NotEmpty
        private String zipcode;

    }




}
