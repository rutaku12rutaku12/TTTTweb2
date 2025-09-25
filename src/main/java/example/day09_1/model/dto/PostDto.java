package example.day09_1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class PostDto {

    private int mno;            // 영화 게시물 번호
    private int pno;            // 토론 글 번호
    private String pcontent;    // 토론 글 내용
    private String ppwd;        // 토론 글 비밀번호

}
