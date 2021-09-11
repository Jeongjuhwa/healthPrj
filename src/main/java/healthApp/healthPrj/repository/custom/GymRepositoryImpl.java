package healthApp.healthPrj.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import healthApp.healthPrj.entity.Gym;
import healthApp.healthPrj.entity.JoinStatus;
import healthApp.healthPrj.entity.QGym;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static healthApp.healthPrj.entity.QGym.gym;

@RequiredArgsConstructor
public class GymRepositoryImpl implements GymRepositoryCustom{

    private final EntityManager em;





    @Override
    public List<Gym> findAcceptGymById(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Gym> findGym = queryFactory
                .selectFrom(gym)
                .where(gym.status.eq(JoinStatus.ACCEPT))
                .fetch();


        return findGym;
    }
}
