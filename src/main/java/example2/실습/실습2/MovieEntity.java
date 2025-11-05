package example2.실습.실습2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 해당 클래스에 데이터베이스 테이블 과 매핑
@Table(name = "movie") // 테이블 이름 정의, 생략 시 클래스명
@Data@Builder@NoArgsConstructor@AllArgsConstructor
public class MovieEntity extends BaseTime{

    @Id // pK 주입
    // auto_increment 주입, MySQL만 가능 , 오라클 불가능
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @Column( nullable = false)
    private String title;
    @Column( nullable = false)
    private String director;
    @Column( nullable = false)
    private String releaseDate;
    @Column( nullable = false)
    private int rating;

    public MovieDto toDto(){
        return MovieDto.builder()
                .movieId(this.movieId)
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .build();
    }


}
