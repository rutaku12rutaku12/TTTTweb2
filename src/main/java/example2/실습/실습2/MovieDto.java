package example2.실습.실습2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
// 엔티티는 서비스에서만 사용!
@Data@AllArgsConstructor
@NoArgsConstructor@Builder
public class MovieDto {

    private int movieId;
    private String title;
    private String director;
    private String releaseDate;
    private int rating;

    private LocalDateTime createdAt; // 생성 날짜/시간
    private String updatedAt; // 수정날짜/시간

    // dto -> entity
    // controller-> service
    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .movieId(this.movieId)
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                // 날짜는 자동 제외
                .build();
    }

}
