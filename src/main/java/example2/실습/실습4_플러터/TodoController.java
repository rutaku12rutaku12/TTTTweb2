package example2.실습.실습4_플러터;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    // 1. Todo 등록 (저장)
    @PostMapping
    public ResponseEntity<?> createTodo(
            @RequestBody TodoDto todoDto ){
        System.out.println(todoDto);
        return ResponseEntity.ok(
                todoService.createTodo(todoDto) );
    }

    // 2. 전체조회
    @GetMapping
    public ResponseEntity<?> getTodoList(){
        return ResponseEntity.ok(todoService.getTodoList() );
    }

}
