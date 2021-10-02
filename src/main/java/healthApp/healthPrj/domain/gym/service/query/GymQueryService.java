package healthApp.healthPrj.domain.gym.service.query;

import healthApp.healthPrj.domain.gym.dto.GymDto;
import healthApp.healthPrj.domain.gym.dto.GymSearchCondition;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.domain.gym.repository.GymRepository;
import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GymQueryService {

    private final GymRepository gymRepository;

    public List<MemberDto> findGymMembers(Long id){
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new RuntimeException("등록되지 않은 헬스장 입니다."));
        gym.checkJoinStatus();
        List<Member> memberList = gym.getMemberList();
        List<MemberDto> collect = memberList.stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
        return collect;


    }

    public Page<GymDto> findByGymSearchCondition(GymSearchCondition gymSearchCondition, Pageable pageable){

        return gymRepository.findByGymSearchCondition(gymSearchCondition,pageable);

    }

}
