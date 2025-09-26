package example.실습.실습3.model.mapper;

import example.실습.실습3.model.dto.RentalsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {

    // (1) 대출
    @Update( "update books set stock = stock-1 where title = #{title}")
    public boolean rend( String title );

    // (1) 대출 로그 추가 // 자동번호id임으로 id생략
    @Insert("INSERT INTO rentals (book_id, member) VALUES (#{book_id}, #{member});")
    public boolean rendLog(RentalsDto rentalsDto);

    // (2) 반납
    @Update( "update books set stock = stock+1 where title = #{title} ")
    public boolean return1( String title );

    // (2) 반납 로그 수정
    @Update("update rentals set return_date = now() where id = #{id} and book_id=#{book_id} and member = #{member}")
    public boolean returnLog( RentalsDto rentalsDto );
}
