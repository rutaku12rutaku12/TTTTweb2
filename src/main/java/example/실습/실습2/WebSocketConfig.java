package example.실습.실습2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 스프링 컨테이너 빈 등록
@EnableWebSocket // 웹소켓 사용 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired private AlarmHandler alarmHandler; // 서버웹소켓 객체

    // 1. 개발자가 만든 서버웹소컷(핸들러) 객체들으 스프링이 알 수 있게 경로 등록한다.
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(alarmHandler ,"/alarm");
    }
}
