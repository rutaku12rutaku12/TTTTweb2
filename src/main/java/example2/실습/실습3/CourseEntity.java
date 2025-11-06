package example2.실습.실습3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ecourse")
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class CourseEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId; // 과정번호
    private String courseName; // 과정명

    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity>
        enrollEntityList = new ArrayList<>();
}
