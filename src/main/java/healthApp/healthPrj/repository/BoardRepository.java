package healthApp.healthPrj.repository;

import healthApp.healthPrj.entity.Board;
import healthApp.healthPrj.repository.custom.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardRepositoryCustom {
}
