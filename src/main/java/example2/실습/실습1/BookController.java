package example2.실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookEntity save(@RequestBody BookEntity bookEntity){
        BookEntity bookEntity1 = bookService.save(bookEntity);
        return bookEntity1;
    }
    @GetMapping
    public List<BookEntity> get(){
        List<BookEntity> bookEntityList = bookService.get();
        return bookEntityList;
    }
    @PutMapping
    public BookEntity put(@RequestBody BookEntity bookEntity){
        System.out.println(bookEntity);
        BookEntity bookEntity1 = bookService.put(bookEntity);
        System.out.println(bookEntity1);
        return bookEntity1;
    }
    @DeleteMapping
    public boolean delete(@RequestParam int Book_id){
        boolean result = bookService.delete(Book_id);
        return result;
    }
}
