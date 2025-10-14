package example.day14;

import example.실습.실습3.model.dto.BooksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 1. 책 단일 등록 기능
    @PostMapping("")
    public ResponseEntity< ? > add(@RequestBody BooksDto dto){
        int result = bookService.add(dto);
        if( result > 0 ){
        return ResponseEntity.ok(dto.getId());}
        else { return ResponseEntity.status(400).body("오류발생"); }
    }

    // 2. 대출 기록 검색
    @GetMapping("find")
    public ResponseEntity< ? > find(@RequestParam String member, @RequestParam String title){
        List<Map<String,Object>> result = bookService.find(member,title);
        return ResponseEntity.ok(result);
    }

    // 3. 책 일괄 등록 기능
    @PostMapping("/all")
    public ResponseEntity< ? > addAll(@RequestBody List<BooksDto> dtos){
        int result = bookService.addAll(dtos);
        if( result > 0 ){
        return ResponseEntity.ok(result);}
        else {return ResponseEntity.status(400).body("오류발생"); }
    }
}
