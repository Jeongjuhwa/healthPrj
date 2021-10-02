package healthApp.healthPrj.domain.gym.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.domain.gym.dto.GymDto;
import healthApp.healthPrj.domain.gym.dto.GymSearchCondition;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.common.enums.JoinStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static healthApp.healthPrj.domain.gym.model.QGym.gym;
import static healthApp.healthPrj.domain.member.model.QMember.member;


@RequiredArgsConstructor
public class GymRepositoryImpl implements GymRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<Gym> findAcceptGym() {
        List<Gym> findGym = query
                .selectFrom(gym)
                .where(isAccepted())
                .fetch();


        return findGym;
    }

    @Override
    public Page<GymDto> findByGymSearchCondition(GymSearchCondition gymSearchCondition, Pageable pageable) {

        List<GymDto> response = query.select(Projections.constructor(GymDto.class,
                gym.gymName,
                gym.address
                )
            )
            .from(gym)
            .where(
                    isAccepted(),
                    isCondition(gymSearchCondition.getName())
            )
            .fetch();


        return new PageImpl<>(response,pageable,response.size());
    }

    private BooleanExpression isAccepted() {
        return gym.status.eq(JoinStatus.ACCEPT);
    }

    private BooleanExpression isCondition(String name) {

        if (name == null) {
            return null;
        }

        return gym.gymName.eq(name);
    }
}
