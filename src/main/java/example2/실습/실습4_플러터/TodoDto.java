package example2.실습.실습4_플러터;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
@Builder
public class TodoDto {
    private int id;
    private String title;
    private String content;
    private String createdAt;
    private String updateAt;


    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }
}
