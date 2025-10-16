package example.day16;

import example.실습.실습3.model.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    // 1. 책books 테이블에 price 가격(int) 필드 추가
    public int change1();

    // 2. 책books 테이블에 title 책이름 필드 (longtext) 필드 수정
    public int change2();

    // 3. 평균 재고보다 많은 재고를 가진 도서 조회
    public List<BooksDto> ser1();

    // 4. 가장 많이 대출한 도서 조회
    public BooksDto ser2();

    // 5. 대출기록 상세 뷰 생성 ( 책 + 대출기록 JOIN )
    public boolean cre1();

    // 6. 평균 재고보다 많은 재고를 가진 도서 조회 뷰 생성
    public boolean cre2();

    // 7. 대출 상세 뷰 조회
    public List<Map<String, Object>> sel1();

    // 8. 평균 재고보다 많은 재고를 가진 도서 조회 뷰 조회
    public List<Map<String, Object>> sel2();

}
