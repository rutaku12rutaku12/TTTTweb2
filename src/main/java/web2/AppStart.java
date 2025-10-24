package web2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

//spring.security.oauth2.client.registration.google.client-id=486927776307-647ccivfs32mq42jiiv8c2q3nqsaj2j5.apps.googleusercontent.com
//# spring.security.oauth2.client.registration.google.client-secret=발급받은보안비밀번호
//spring.security.oauth2.client.registration.google.client-secret=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
//#spring.security.oauth2.client.registration.google.redirect-uri=로그인성공시반환되는경로(타사신청시 작성)
//# baseUrl : 자동으로 현재 서버 도메인
//spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/google
//#spring.security.oauth2.client.registration.google.scope=동의항목명(동의항목 신청시 확인)
//spring.security.oauth2.client.registration.google.scope=email,profile
//
//# [7-2] 카카오 설정
//spring.security.oauth2.client.registration.kakao.client-id=50fc1c18af02d58d843af3f625b5f621
//spring.security.oauth2.client.registration.kakao.client-secret=f7N8WMOx3a8JNtTn3LsL2G8EaAHYCsWo

