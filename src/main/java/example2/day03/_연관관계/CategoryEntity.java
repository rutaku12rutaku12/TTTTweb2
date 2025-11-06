package example2.day03._연관관계;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity // 영속성 부여 , 테이블로 사용 가능
@Table( name = "ecategory" )
@Data @Builder
public class CategoryEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int cno;
    private String cname;
    // * 양방향 연결 ** //
    // 상위 엔터티가 하위 엔티티 참조관계
    @OneToMany( mappedBy = "categoryEntity" ) // 1:M, 하나 PK가 다수 FK 에게
    // JPA 양방향 사용하고 DB 에서는 양방향 하지 않는다.
    @ToString.Exclude // 순환참조 방지
    @Builder.Default // 만약에 빌더패턴 사용 시 초기값 사용
    private List<BoardEntity>
            boardEntityList = new ArrayList<>();
}
