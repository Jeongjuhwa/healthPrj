package healthApp.healthPrj.domain.board.model;

import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity implements Persistable<Long> {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String commentContent;

    @Override
    public boolean isNew() {
        return this.getCreatedDate() == null;
    }
}
