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
} // class end
