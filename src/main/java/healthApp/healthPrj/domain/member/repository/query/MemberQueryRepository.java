package healthApp.healthPrj.domain.member.repository.query;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.domain.member.dto.MemberDto;
import healthApp.healthPrj.domain.member.dto.MemberSearch;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static healthApp.healthPrj.domain.member.model.QMember.member;

@RequiredArgsConstructor
public class MemberQueryRepository{

    private final JPAQueryFactory query;


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
                .where(
                        isCondition(memberSearch.getName()),
                        isNotDeleted()

                )
                .fetch();

        return new PageImpl<>(response, pageable, response.size());


    }


    public Page<MemberDto> findMemberByGym(Long gymId, Pageable pageable) {

        List<MemberDto> response = query.select(Projections.constructor(MemberDto.class,
                member.memberName,
                member.memberAge,
                member.memberSex
                )
        )
                .from(member)
                .where(
                        gymIdEq(gymId),
                        isNotDeleted()
                )
                .fetch();
        return new PageImpl<>(response, pageable, response.size());

    }

    private BooleanExpression gymIdEq(Long gymId) {
        return member.gym.id.eq(gymId);
    }

    private BooleanExpression isNotDeleted() {
        return member.deletedDateTime.isNull();
    }

    private BooleanExpression isCondition(String name) {

        if(name == null){
            return null;
        }

        return member.memberName.eq(name);
    }
}
