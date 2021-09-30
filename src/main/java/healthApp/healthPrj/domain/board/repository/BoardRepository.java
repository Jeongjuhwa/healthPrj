package healthApp.healthPrj.domain.board.repository;

import healthApp.healthPrj.domain.board.model.Board;
import healthApp.healthPrj.domain.board.repository.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardRepositoryCustom {
}
