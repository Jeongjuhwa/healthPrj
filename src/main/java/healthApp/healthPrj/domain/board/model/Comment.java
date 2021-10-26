package healthApp.healthPrj.domain.board.model;

import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private Long memberId;

    private String commentContent;


    @Builder
    public Comment(Board board, Long memberId, String commentContent) {
        this.board = board;
        this.memberId = memberId;
        this.commentContent = commentContent;
    }

    public Comment mapWriter(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public Comment mapBoard(Board board) {
        this.board = board;
        return this;
    }


}
