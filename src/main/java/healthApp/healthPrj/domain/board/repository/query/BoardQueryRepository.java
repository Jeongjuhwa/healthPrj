package healthApp.healthPrj.domain.board.repository.query;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class BoardQueryRepository {

    private final EntityManager em;

}
