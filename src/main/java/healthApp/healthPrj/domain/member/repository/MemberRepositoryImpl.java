package healthApp.healthPrj.domain.member.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.member.dto.MemberSearch;
import healthApp.healthPrj.domain.member.model.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static healthApp.healthPrj.domain.member.model.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory query;

    @Override
    public Page<MemberDto> findByMemberSearch(MemberSearch memberSearch, Pageable pageable) {
        List<MemberDto> response = query.select(Projections.constructor(MemberDto.class,
                member.memberName,
                member.memberAge,
                member.memberSex,
                member.address.city,
                member.address.street,
                member.address.zipcode
                )
        )
                .from(member)
                .where(isCondition(memberSearch))
                .fetch();

        return new PageImpl<>(response, pageable, response.size());


    }

    private BooleanExpression isCondition(MemberSearch memberSearch) {

        if(memberSearch.getName() == null){
            return null;
        }

        return member.memberName.eq(memberSearch.getName());
    }
}
