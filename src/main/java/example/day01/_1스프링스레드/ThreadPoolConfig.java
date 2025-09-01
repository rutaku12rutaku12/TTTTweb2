package example.day01._1스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration // 스프링 컨테이너 빈 등록 , IOC
public class ThreadPoolConfig {

    // 1. 스프링 멀티스레드 커스텀 // Executor : java.util import 하기
    @Bean // 해당 하는 메소드를 컨테이너 빈 등록하는 어노테이션
    public Executor taskExecutor () {
        // 1) ThreadPoolTaskExecutor : 스레드풀 작업스레드 객체
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // 기본(최소) 실행 스레드 개수 실행
        executor.setMaxPoolSize(3); // 최대 실행 스레드 개수 설정
        executor.setQueueCapacity(20); // 최대 대기 개수 설정 , 20명 대기상태가 넘치면 503 오류 발생
        executor.initialize(); // 스레드를 초기화 : 서버 재실행 마다 초기화
        return executor;
    }
}
