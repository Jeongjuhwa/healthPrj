package healthApp.healthPrj.domain.admin.service;

import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.domain.admin.dto.WaitJoinGymDto;
import healthApp.healthPrj.domain.admin.repository.AdminRepository;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {

    private final GymRepository gymRepository;
    private final AdminRepository adminRepository;

    /**
     * 가입 승인(헬스장)
     */
    @Transactional
    public void acceptGym(Long id){
        Optional<Gym> findGym = adminRepository.findById(id);
        Gym gym = findGym.get();
        gym.accept();
        

    }

    public List<WaitJoinGymDto> findAllPendingByStatus(JoinStatus joinStatus){

        List<Gym> findGym = adminRepository.findAllPendingByStatus(JoinStatus.PENDING);
        List<WaitJoinGymDto> collect = findGym.stream().map(gym -> new WaitJoinGymDto(gym)).collect(Collectors.toList());
        return collect;


    }

}
