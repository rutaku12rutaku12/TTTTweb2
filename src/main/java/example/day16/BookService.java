package example.day16;

import example.실습.실습3.model.dto.BooksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;


    // 1. 책books 테이블에 price 가격(int) 필드 추가
    public int change1(){
        System.out.println("BookService.change1");
        int result = bookMapper.change1();
        return result;
    }
    // 2. 책books 테이블에 title 책이름 필드 (longtext) 필드 수정
    public int change2(){
        int result = bookMapper.change2();
        return result;
    }

    // 3. 평균 재고보다 많은 재고를 가진 도서 조회
    public List<BooksDto> ser1(){
        List<BooksDto> result = bookMapper.ser1();
        return result;
    }
    // 4. 가장 많이 대출한 도서 조회
    public BooksDto ser2(){
        BooksDto result = bookMapper.ser2();
        return result;
    }

    // 5. 대출기록 상세 뷰 생성 ( 책 + 대출기록 JOIN )
    public boolean cre1(){
        boolean result = bookMapper.cre1();
        return result;
    }

    // 6. 평균 재고보다 많은 재고를 가진 도서 조회 뷰 생성
    public boolean cre2(){
        boolean result = bookMapper.cre2();
        return result;
    }

    // 7. 대출 상세 뷰 조회
    public List<Map<String, Object>> sel1(){
        List<Map<String, Object>> result = bookMapper.sel1();
        return result;
    }

    // 8. 평균 재고보다 많은 재고를 가진 도서 조회 뷰 조회
    public List<Map<String, Object>> sel2(){
        List<Map<String, Object>> result = bookMapper.sel2();
        return result;
    }
}
