package example.실습.실습3.service;

import example.실습.실습3.model.dto.BooksDto;
import example.실습.실습3.model.dto.RentalsDto;
import example.실습.실습3.model.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    @Transactional
    public boolean rending( RentalsDto rentalsDto ){

        String o = "";
        // 1. 대출시 재고 감소
        boolean result1 = bookMapper.rend( o);
        // 2. 로그 추가
        boolean result2 = bookMapper.rendLog( rentalsDto );

        return true;
    } // func1 end

    @Transactional
    public boolean returning( RentalsDto rentalsDto ){

        String title = "";

        int id = rentalsDto.getId();
        int book_id = rentalsDto.getBook_id();
        String member = rentalsDto.getMember();
        // 1. 반납시 재고 증가
        boolean result1 = bookMapper.return1(title);
        // 2. 로그 수정
        boolean result2 = bookMapper.returnLog(rentalsDto);
        return true;
    } // func2 end
} // class end
