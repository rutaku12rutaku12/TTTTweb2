package example2.실습.실습3;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "eenroll")
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class EnrollEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollId; // 수강번호
    private String status; // 수강상태

    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;


}
