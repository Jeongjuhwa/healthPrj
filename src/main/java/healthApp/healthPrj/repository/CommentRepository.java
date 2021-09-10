package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Comment;
import healthApp.healthPrj.repository.custom.CommentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long>, CommentRepositoryCustom {

}
