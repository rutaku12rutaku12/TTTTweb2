package web2.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
@Builder
public class JwtService {

    // [1] 개발자가 비밀키 정의 , 32 글자 이상의 문자열로 구성
    private final String secret = "12345678912345678912345678912314124";
    // [2] 개발자가 정의한 비밀키를 이용한 sha-256 알고리즘 적용
    private final Key secretKey = Keys.hmacShaKeyFor( secret.getBytes( StandardCharsets.UTF_8 ) );

    // [3] 토큰 함수
    // [3-1] 토큰 생성 : 회원로그인 전용( 아이디 , 권한 )
    public String createToken( String uid , String urole ){
        String token = Jwts.builder() // 토큰객체 생성 빌더 함수 시작
                .claim("uid", uid ) // uid 라는 이름의 로그인성공한 회원아이디 저장
                .claim("urole" , urole ) // urole 라는 key의 로그인성공한 회원권한명 저장
                .setIssuedAt( new Date() ) // 발급시간 , 현재 시스템(pc) 날짜/시간
                .setExpiration( new Date( System.currentTimeMillis() + 1000 * 60 * 60 ) ) // 1시간
                .signWith( secretKey, SignatureAlgorithm.HS256 ) // HS256 서명 알고리즘 적용
                .compact(); // 토큰 객체 생성 빌더 함수 종료
        System.out.println("token = " + token);
        return token;
    }
    // [3-2] 토큰 검증
    public boolean checkToken( String token ){
        try {
            Jwts.parser()
                    .setSigningKey( secretKey) // 서명 검증시 필요한 비밀키 대입
                    .build()
                    .parseClaimsJws(token); // 검증할 토큰 대입 하여 검증 실행
            return true; // 예외가 발생하지 않으면 검증 성공
        }catch (JwtException e){
            return false; // 예외가 발생하면 검증 실패 : 유효기간이 지난 토큰이거나 존재하지 않은 토큰
        }
    }
    // [3-3] 토큰 클레임(값) 호출
    public Claims getclaims(String token){
        return Jwts.parser()
                .setSigningKey( secretKey )
                .build()
                .parseClaimsJws( token )
                .getBody(); // 검증에 성공한 토큰의 (저장된데이터)클레임들 반환
    }
    // [3-4] 클레임들의 특정 값 추출 getter 함수
    public String getUid( String token ){
        return getclaims( token ).get("uid" , String.class);

    }
    public String getUrole( String token ){
        return getclaims( token ).get("urole", String.class);
    }

/// /////////////////////////////////////////////////////////////////////

    // [JWT] : JSON(자바스크립트객체) WEB Token(징표)
    // 웹에서 자바스크립트 기반(클라이언트)의 특정한 데이터를 대신하는 징표
    // 특정한 데이터를 직접적으로 보여주지 않고 징표를 대신 보여주는 구조
    // 웹(클라이언트)에서 데이터 숨기기 (보안)

    // JWT 토큰 가능하지만 , 데이터들 간의 서로다른 토큰 과 복잡한 계산식 추가
    // SHA-256 알고리즘 사용하여 비밀키(임의, 개발자만들기, 토큰 풀기 위한 비밀번호)를 32글자이상
    // 1-2 : 내가 만든 임의의 토큰에 사용되는 계산식의 비밀키
    private final String 비밀번호 = "12345678901234567890123456789012"; // 난수 키 보다는 직접생성한 (임의)키 권장
    // 1-2 : 비밀키에 알고리즘 적용 하여 계산식(미리 태어난 사람이 SHA) 생성
    private final Key 비밀키 = Keys.hmacShaKeyFor(비밀번호.getBytes(StandardCharsets.UTF_8) );


    // [1] 토큰 생성
    public String 토큰생성( String 데이터 ){
        // 1-1 토큰 생성 : 라이브러리
        // .builder() : 필더패턴(생성자 대신에 함수형 객체생성) 이용한 토큰 생성
        String token = Jwts.builder()
                .claim("key", 데이터 ) // .claim( key , value ) : 토큰에 넣을 데이터 대입
                .setIssuedAt( new Date() ) // .setIssuedAt( 토큰 발급날짜/시간 )
                // .setExpiration( new Date( System.currentTimeMillis()+1000 * 초 ) ) // .setExpiration( 토큰 만료시간 )
                .setExpiration( new Date( System.currentTimeMillis()+1000 * 25 ) ) // 25초
                .signWith( 비밀키 , SignatureAlgorithm.HS256 )// 알코리즘 이용한 토큰에 서명하기
                .compact(); // 최종 JWT 문자열 형태로 생성
        System.out.println("token = " + token);// 확인 soutv
        return token;
    }

    // [2] 토큰 검증 : 토큰 유효 검사
    public boolean 토큰감증( String 토큰 ){
        try {
            Jwts.parser() // parser
                    .setSigningKey(비밀키) // 서명 검증에 필요한 비밀키 대입
                    .build() // 비밀키 확인
                    .parseClaimsJws(토큰); // 검증할 토큰 대입
            return true; // 예외가 발생하지 않으면 토큰
        } catch ( Exception e ){
            return false; // 토큰 비정상
        }
    } // m end

    // [3] 토큰 payload(내용물) claim 값 추출
    public String 값추출(String 토큰){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(비밀키)
                    .build()
                    .parseClaimsJws(토큰)
                    .getBody(); // 검증후 클레임(내용물) 가져오기
            System.out.println("claims = " + claims);
            String value = (String) claims.get("key");
            return value;
        }catch (Exception e){
            return null;}
    }


} // class end
// new Date() : 자바에서 시스템(컴퓨터)의 시간을 반환하는 클래스
// 밀리초 :  1/1000초 , new Date( System.currentTimeMillis() ) : 현재 날짜/시간을 밀리초로 반환
