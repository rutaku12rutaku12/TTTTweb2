package example2.실습.실습4_플러터;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class TodoEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    public TodoDto toDto(){
        return TodoDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .createdAt(this.getCreatedAt().toString())
                .updateAt(this.getUpdateAt().toString())
                .build();
    }
}
