package healthApp.healthPrj.domain.member.repository;

import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.member.dto.MemberSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<MemberDto> findByMemberSearch(MemberSearch memberSearch, Pageable pageable);

}
