package example2.실습.실습2;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter // 롬복
@MappedSuperclass // 엔티티 상속용도
// AppStart 클래스 위에 @EnableJpaAuditing 주입해야 가능하다! +_+
// JPA가 데이터베이스를 모니터링 하여 엔티티가 변화하면 데이터베이스 변화 실행
@EntityListeners(AutoCloseable.class) // 해당 엔티티를 자동 감시 적용
public class BaseTime {

    @CreatedDate // 현재 날짜 시간 자동으로 주입
    private LocalDateTime createdAt; // 생성 날짜/시간
    @LastModifiedDate // 엔티티 변화 시점의 날짜/시간 자동으로 주입
    private LocalDateTime updatedAt; // 수정날짜/시간
}
