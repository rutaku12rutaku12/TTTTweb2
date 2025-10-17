package example.day17;

import example.day06.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    // [*] 간단한 텍스트를 레디스에 접근하는 객체
    private final RedisTemplate redisTemplate; // 템플릿이란? 미리 만들어진 틀/형식

    // [1] 간단한 텍스트를 레디스 서버에 저장/호출 하기 ( 서비스 )
    @GetMapping("test")
    public ResponseEntity<?> test1(){
        System.out.println("RedisController.test1");
        // [저장] 레디스템플릿객체명.redisTemplate.opsForValue().set( key , value ); , key 값은 중복잉 안되므로 중복이면 덮어쓰기 적용
        // { "유재석" : "90" } , { "강호동" : "80" }
        redisTemplate.opsForValue().set( "유재석" , "90" ) ; // 임의 데이터1
        redisTemplate.opsForValue().set( "강호동" , "80" ) ; // 임의 데이터2
        redisTemplate.opsForValue().set( "유재석" , "100") ; // key는 중복을 허용하지 않고 , value 중복 허용
        // [ 모든 키 호출] 레디스템플릿객체명.keys("*")             : 레디스에 저장된 모든 키 반환
        // [ 특정한 키의 값 호출] 레디스템플릿객체명.opsForValue().get( key );
        Set<String> keys = redisTemplate.keys("*");
            // List vs Map vs Set 컬렉션 프레임워크란?
        List< Object > result = new ArrayList<>(); // 임의의 리스트
        for( String key : keys ){
            result.add( redisTemplate.opsForValue().get( key ) );
        }
        return ResponseEntity.ok(result);
    } // m end


    // day13/day06 CRUD를 데이터베이스 없이 레디스로 실습 반환

    private final RedisTemplate<String,Object> studentTemplate;

    // # 1. 등록
    @PostMapping("")
    public ResponseEntity< ? > save(@RequestBody example.day17.StudentDto studentDto){
        System.out.println("studentDto = " + studentDto);
        // 0. 중복없는 key 구성
        String key = "student:"+studentDto.getSno(); // sno를 key로 조합하여, 예] student:1 , student:2
        // 1. 레디스에 전달받은 값 저장한다.
        // 해석 : { "student:1" : { sno : 1 , name : "강호동" , math : 80 , kor : 100 } }
        studentTemplate.opsForValue().set( key, studentDto );
        return ResponseEntity.ok().body("[저장성공]");
    }
    // # 2. 전체조회
    @GetMapping("")
    public ResponseEntity< ? > findAll(){
        // 0. 조회할 key를 모두 가져온다. * : 레디스 내 모든 키 / xxxx:* : xxxx:동일한 * 자리는 임의의 문자 대응
        // studentTemplate.keys("문자열*"); // 문자열까지는 동일하면 * 위치는 서로다른 문자열 패턴
        Set<String> keys = studentTemplate.keys("student:*"); // student:1 , student:2 ~~
        // 1. 반복문 이용한 value 꺼내서 리스트에 담기
        List<Object> result = new ArrayList<>();
        for( String key : keys ){ result.add( studentTemplate.opsForValue().get(key) );}
        return ResponseEntity.ok().body(result);
    }

    // # 3. 개별 학생 조회
    @GetMapping("find")
    public ResponseEntity< ? >find(@RequestParam int sno ){
        // 1. 조회할 key 구성
        String key = "student:"+sno;
        // 2. 특정한 key의 value 호출
        Object result = studentTemplate.opsForValue().get( key );
        return ResponseEntity.ok(result);
    }
    // # 4. 개별 학생 삭제
    @DeleteMapping("")
    public ResponseEntity< ? >delete(@RequestParam int sno){
        // 1. 삭제할 key 구성
        String key = "student:"+sno;
        // 2. 특정한 key를 이용한 엔트리(key-value 한쌍) 삭제 ,
        // 템플릿객체명.delete( key ); , 삭제 성공시 true / 실패시 false
        boolean result = studentTemplate.delete(key);
        return ResponseEntity.ok(result);
    }
    // # 5. 개별 학생 수정
    @PutMapping("")
    public ResponseEntity< ? >update(@RequestBody StudentDto studentDto){
        // 1. 수정할 key 구성
        String key = "student:"+studentDto.getSno();
        // 2. 특정한 key를 덮어쓰기/수정
        studentTemplate.opsForValue().set( key , studentDto );
        return ResponseEntity.ok(true); //
    }

    // * 인증코드 발급 해서 레디스 유효기간 정하기
    // TTL : 레디스에저장된 엔트리(key-value) 를 특정한 기간(시간)이 되면 자동 삭제
    @GetMapping("/auth/send")
    public ResponseEntity<?> authSend( @RequestParam String phone ){
        // 1. key 구성 , "auth:고객전화번호"
        String key = "auth:"+phone; // 번호마다 1개씩 인증코드
        // 난수 6자리 ( 인증코드 생성 )
        String code = String.format( "%06d" , new Random().nextInt(999999) );
        // 2. 레티스에 인증코드 저장하기 , TTL(유효기간) , Duration.ofXXXX( 수 )
        redisTemplate.opsForValue().set( key , code , Duration.ofSeconds(20) ); // 20초
        // API 이용하여 고객전화번호 에게 인증코드 전송
        return ResponseEntity.ok().body("인증코드 발급 완료 : "+ code);
    }
    @GetMapping("/auth/confirm")
    public ResponseEntity<?> authConfirm( @RequestParam String phone, @RequestParam String code ){
        // 1. 조회할 key 구성
        String key = "auth:"+phone;
        Object savedCode = redisTemplate.opsForValue().get(key); // 2. 조회할 key 이용한 value 호출
        if( savedCode == null ) { return ResponseEntity.ok("인증실패 : 인증 만료 또는 코드 불일치 "); }
        else if ( savedCode.equals( code ) ){ return ResponseEntity.ok("[인증성공]"); }
        else { return ResponseEntity.ok("[인증실패]"); }
    }
} // class end
