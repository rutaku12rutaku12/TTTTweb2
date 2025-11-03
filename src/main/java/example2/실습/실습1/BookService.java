package example2.실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // 여러 SQL이 처리 중 하나라도 실패시 전체 실패
public class BookService {

    private final BookRepository bookRepository;

    // 도서등록
    public BookEntity save(BookEntity bookEntity){
        BookEntity bookEntity1 = bookRepository.save(bookEntity);
        return bookEntity1;
    }

    // 도서 전체 조회
    public List<BookEntity> get(){
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList;
    }
    // 특정 도서 수정
    @Transactional
    public BookEntity put(BookEntity bookEntity){
        Optional<BookEntity> optional = bookRepository.findById(bookEntity.getBook_id());
        if(optional.isPresent()){
            BookEntity entity = optional.get();
            entity.setBook_name(bookEntity.getBook_name());
            entity.setBook_author(bookEntity.getBook_author());
            entity.setBook_publisher(bookEntity.getBook_publisher());
            return entity;
        }
                return bookEntity;
    }
    // 특정 도서 삭제
    public boolean delete(int Book_id){
        bookRepository.deleteById(Book_id);
        return true;
    }
}
