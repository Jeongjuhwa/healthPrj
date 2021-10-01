package healthApp.healthPrj.domain.member.service.query;


import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.member.dto.MemberSearch;
import healthApp.healthPrj.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public Page<MemberDto> findByMemberSearch(MemberSearch memberSearch, Pageable pageable){
        return memberRepository.findByMemberSearch(memberSearch,pageable);
    }

}
