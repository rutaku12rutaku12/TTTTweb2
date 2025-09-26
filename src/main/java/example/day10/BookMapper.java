package example.day10;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {
    // 1. 책 재고 차감
    @Update("update books set stock = stock-1 where id = #{bookid} and stock > 0")
    int decStock(int bookid);
    // 2. 책 대여 기록
    @Insert("insert into rentals ( book_id , member ) values( #{bookid} , #{member} )")
    int insertRental( int bookid , String member );

    // 1. 책 재고 증가
    @Update("update books set stock = stock+1 where id = #{bookid}")
    int ascStock(int bookid);
    // 2. 책 대여 기록 수정
    @Update("update rentals set return_date = now() where id = #{id} and book_id=#{bookid} ")
    int returnRental( int id , int bookid );

}
