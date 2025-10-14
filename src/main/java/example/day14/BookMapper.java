package example.day14;

import example.실습.실습3.model.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    // 1. 책 단일 등록 기능
    int add(BooksDto dto);

    // 2. 대출 기록 검색
    List<Map<String,Object>> find(String member , String title);

    // 3. 책 일괄 등록 기능
    int addAll(List<BooksDto> dtos);

}
