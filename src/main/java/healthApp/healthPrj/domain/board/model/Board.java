package healthApp.healthPrj.domain.board.model;

import healthApp.healthPrj.domain.member.model.Member;
import healthApp.healthPrj.common.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private Long memberId;

    private String title;

    private String content;

    private Long hit;

    private Long heart;


    @Builder
    public Board(Long memberId, String title, String content, int hit, int heart) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.hit = 0L;
        this.heart = 0L;
    }

    public void hit(){
        hit += 1;
    }

    public void heart(){heart +=1;}


    public Board mapWriter(Long memberId) {
        this.memberId = memberId;
        return this;
    }


}
