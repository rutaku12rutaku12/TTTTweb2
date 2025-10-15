package example.day15;

import example.실습.실습3.model.dto.BooksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 1. 책books 테이블에 price 가격(int) 필드 추가
    @PostMapping("c1")
    public ResponseEntity< ? > change1(){
        System.out.println("BookController.change1");
        int result = bookService.change1();
        return ResponseEntity.ok(result);
    }
    // 2. 책books 테이블에 title 책이름 필드 (longtext) 필드 수정
    @PostMapping("c2")
    public ResponseEntity< ? > change2(){
        int result = bookService.change2();
        return ResponseEntity.ok(result);
    }

    // 3. 평균 재고보다 많은 재고를 가진 도서 조회
    @GetMapping("s1")
    public ResponseEntity< ? > ser1(){
        List<BooksDto> result = bookService.ser1();
        return ResponseEntity.ok(result);
    }
    // 4. 가장 많이 대출한 도서 조회
    @GetMapping("s2")
    public ResponseEntity< ? > ser2(){
        BooksDto result = bookService.ser2();
        return ResponseEntity.ok(result);
    }

}
