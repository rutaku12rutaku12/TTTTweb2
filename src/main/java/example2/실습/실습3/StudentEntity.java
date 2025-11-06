package example2.실습.실습3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudent")
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId; // 학생번호
    private String studentName; // 학생명


    @OneToMany(mappedBy = "studentEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity>
        enrollEntityList = new ArrayList<>();

}
