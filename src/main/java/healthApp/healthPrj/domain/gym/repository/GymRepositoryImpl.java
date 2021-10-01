package healthApp.healthPrj.domain.gym.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.common.enums.JoinStatus;
import healthApp.healthPrj.domain.gym.model.QGym;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static healthApp.healthPrj.domain.gym.model.QGym.gym;


@RequiredArgsConstructor
public class GymRepositoryImpl implements GymRepositoryCustom{

    private final JPAQueryFactory query;





    @Override
    public List<Gym> findAcceptGym() {
        List<Gym> findGym = query
                .selectFrom(gym)
                .where(gym.status.eq(JoinStatus.ACCEPT))
                .fetch();


        return findGym;
    }
}
