package example.day09_1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class MovieDto {

    private int mno;            // 영화 게시물 번호
    private String mtitle;      // 영화 제목
    private String mdirector;   // 영화 감독
    private String mgenre;      // 영화 장르
    private String mcontent;    // 영화 소개
    private String mpwd;        // 영화 비밀번호

}
