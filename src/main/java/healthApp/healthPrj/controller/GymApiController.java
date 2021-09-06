package healthApp.healthPrj.controller;

import healthApp.healthPrj.entity.Address;
import healthApp.healthPrj.entity.Gym;
import healthApp.healthPrj.service.GymService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
public class GymApiController {

    private final GymService gymService;

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
