package example2.실습.실습3;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AppStart.class)
public class BaseTime {

    @CreatedDate // 현재 날짜 시간 자동 주입
    private LocalDateTime createAt; // 생성 날짜/시간
    @LastModifiedDate // 엔티티 변화 시점의 날짜/시간 자동 주입
    private LocalDateTime updateAt; // 수정 날짜/시간
}
