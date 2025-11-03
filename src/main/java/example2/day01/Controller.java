package example2.day01;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam")
@RequiredArgsConstructor
public class Controller {

    private final ExamService examService;

    @PostMapping
    public ExamEntity post(@RequestBody ExamEntity examEntity){
        ExamEntity result = examService.post(examEntity);
        return result;
    }
    @GetMapping
    public List<ExamEntity> get(){
        List<ExamEntity> result = examService.get();
        return result;
    }

    @PutMapping
    public ExamEntity put(@RequestBody ExamEntity examEntity){
        System.out.println(examEntity);
        ExamEntity result= examService.put2(examEntity);
        System.out.println(result);
        return result;
    }
    // 4.
    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam int col1 ){
        return ResponseEntity.ok(examService.delete(col1) );

    }

}
