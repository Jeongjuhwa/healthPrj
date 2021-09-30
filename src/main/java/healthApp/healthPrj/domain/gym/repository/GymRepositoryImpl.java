package healthApp.healthPrj.domain.gym.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.domain.gym.model.Gym;
import healthApp.healthPrj.common.enums.JoinStatus;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static healthApp.healthPrj.entity.QGym.gym;

@RequiredArgsConstructor
public class GymRepositoryImpl implements GymRepositoryCustom{

    private final EntityManager em;





    @Override
    public List<Gym> findAcceptGym() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Gym> findGym = queryFactory
                .selectFrom(gym)
                .where(gym.status.eq(JoinStatus.ACCEPT))
                .fetch();


        return findGym;
    }
}
