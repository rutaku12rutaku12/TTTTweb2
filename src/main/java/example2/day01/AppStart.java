package example2.day01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@SpringBootApplication
@EnableWebSecurity
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    } // m end

    @Bean // 특정한 경로는 시큐리티 무시
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)-> web.ignoring()
                .requestMatchers("/api/exam/**");
    }
} // c end

