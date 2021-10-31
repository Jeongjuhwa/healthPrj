package healthApp.healthPrj.domain.member.service.query;

import healthApp.healthPrj.domain.member.dto.GymDto;
import healthApp.healthPrj.domain.member.dto.GymMemberResponse;
import healthApp.healthPrj.domain.member.dto.GymSearchCondition;
import healthApp.healthPrj.domain.member.repository.query.GymQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GymQueryService {

    private final GymQueryRepository gymQueryRepository;

    public Page<GymDto> findByGymSearchCondition(GymSearchCondition gymSearchCondition, Pageable pageable){

        return gymQueryRepository.findByGymSearchCondition(gymSearchCondition,pageable);

    }

    public Page<GymMemberResponse> findGymMembers(Long gymId, Pageable pageable){
        return gymQueryRepository.findGymMembers(gymId, pageable);
    }

}
