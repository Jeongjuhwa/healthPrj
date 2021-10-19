package healthApp.healthPrj.domain.board.repository.query;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class CommentQueryRepository {

    private final EntityManager em;
}
