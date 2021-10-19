package healthApp.healthPrj.domain.member.repository.query;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class TrainerQueryRepository {

    private final EntityManager em;
}
