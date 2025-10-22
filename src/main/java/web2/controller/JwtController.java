package web2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web2.service.JwtService;

@RestController
@RequestMapping("/api/jwt")
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    // [1] 토큰 생성
    @GetMapping("/create") // http://localhost:8080/api/jwt/create?데이터="11"
    public ResponseEntity<?> 토큰생성(@RequestParam String 데이터){
        String token = jwtService.토큰생성(데이터);
        return ResponseEntity.ok(token);
    }

    // [2] 토큰 검증
    @GetMapping("/read") // http://localhost:8080/api/jwt/read?토큰=eyJhbGciOiJIUzI1NiJ9.eyJrZXkiOiJcIjExXCIiLCJpYXQiOjE3NjEwOTYzMTcsImV4cCI6MTc2MTA5NjMzN30.Yqny1qVP7JtaApcRvM7wCvold6OEMW1Zd_0COkOXFQs
    public ResponseEntity<?> 토큰검증(
            @RequestParam String 토큰){
        boolean result = jwtService.checkToken(토큰);
        return ResponseEntity.ok(result);
    }

    // [3] 토큰 값 추출
    @GetMapping("/value") // http://localhost:8080/api/jwt/value?토큰=eyJhbGciOiJIUzI1NiJ9.eyJrZXkiOiJcIjExXCIiLCJpYXQiOjE3NjEwOTY5NDgsImV4cCI6MTc2MTA5Njk3M30.rMllz1qzQufhrMsE3aj5wwt6PCnO4JMwcezl0x1Upnk
    public ResponseEntity<?> 토큰값추출(
            @RequestParam String 토큰){
        String value = jwtService.값추출(토큰);
        return ResponseEntity.ok(value);


    }



}
