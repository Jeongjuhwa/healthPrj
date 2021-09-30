package healthApp.healthPrj.domain.board.repository;

import healthApp.healthPrj.domain.board.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long>, CommentRepositoryCustom {

}
