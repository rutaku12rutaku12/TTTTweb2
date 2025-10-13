package example.day13;

import example.day06.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {
    // #
    private final XmlMapper xmlMapper;
    // # 1. 등록
    @PostMapping("")
    public ResponseEntity< ? > save(@RequestBody StudentDto dto){
        System.out.println("dto = " + dto); // sno 없다
        // < ? > : 제네릭타입에 ? 넣으면 모든 타입을 지정한다. 와일드카드
        int result = xmlMapper.save(dto);   // ===== SQL 실행 =====
        System.out.println("dto = " + dto); // sno 있다.
        return ResponseEntity.ok(true );
    }

    // # 2. 전체조회
    @GetMapping("")
    public ResponseEntity< ? > findAll(){
        List< StudentDto > result = xmlMapper.findAll();
        return ResponseEntity.ok(result);
    }

    // # 3. 개별 학생 조회
    @GetMapping("find")
    public ResponseEntity< ? >find(@RequestParam int sno){
        StudentDto dto = xmlMapper.find(sno);
        return ResponseEntity.ok(dto);
    }

    // # 4. 개별 학생 삭제
    @DeleteMapping("")
    public ResponseEntity< ? >delete(@RequestParam int sno){
        int result = xmlMapper.delete(sno);
        return ResponseEntity.ok(result);
    }

    // # 5. 개별 학생 수정
    @PutMapping("")
    public ResponseEntity< ? >update(@RequestBody StudentDto dto){
        int result = xmlMapper.update(dto);
        return ResponseEntity.ok(result);
    }

    // # 6-1. 특정한 국어점수가 이상인 학생 조회
    @GetMapping("/q1")
    public ResponseEntity< ? > query1(@RequestParam int kor ){
        List<StudentDto> dtos = xmlMapper.query1(kor);
        return ResponseEntity.ok(dtos);
    }

    // # 6-2. 특정한 국어점수가 이상인 학생 조회 , XML 방법
    @GetMapping("/q2")
    public ResponseEntity< ? > query2(@RequestParam int kor ){
        List<StudentDto> dtos = xmlMapper.query2(kor);
        return ResponseEntity.ok(dtos);
    }

    // # 7. 이름(포함된) 또는 수학점수(이상) 로 검색
    @GetMapping("/q3")
    public ResponseEntity< ? > query3(@RequestParam String name , @RequestParam int math){
        List<StudentDto> result = xmlMapper.query3(name,math);
        return ResponseEntity.ok(result);
    }

    // # 8. 여러개 학생 등록
    @PostMapping("/saveall")
    public ResponseEntity< ? > saveAll(@RequestBody List<StudentDto> dtos){
        int result = xmlMapper.saveAll(dtos);
        return ResponseEntity.ok(result);
    }

} // class end
