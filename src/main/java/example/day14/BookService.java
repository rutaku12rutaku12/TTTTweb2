package example.day14;

import example.실습.실습3.model.dto.BooksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    // 1. 책 단일 등록 기능
    int add(BooksDto dto){
        int result = bookMapper.add(dto);
        return result;
    }

    // 2. 대출 기록 검색
    List<Map<String,Object>> find(String member , String title){
        List<Map<String,Object>> result = bookMapper.find(member,title);
        return result;
    }

    // 3. 책 일괄 등록 기능
    @Transactional
    int addAll(List<BooksDto> dtos){
        try{
            int result = bookMapper.addAll(dtos);
            if( result != dtos.size() ){
                throw new RuntimeException("등록 실패");
            }return result;
        }catch (Exception e){
            throw new RuntimeException("등록 실패");
        }
    } // m end

} // class end
