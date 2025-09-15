package example.day06;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper // 해당 인터페이스를 스프링 컨테이너 등록, xxxDAO 역할 대신 한다.
public interface BatisMapper {
    // 1. 학생 등록
    // dao : insert into student( name , kor , math) values( ? , ? , ? );
    // mybatis : insert into student( name, kor, math)values( #{ 매개변수 } , #{ 매개변수 } , #{ 매개변수 }
    @Insert("insert into student(name,kor,math) values (#{name},#{kor},#{math} )")
    int save( StudentDto studentDto ); // 추상메소드
    // 2. 전체 학생 조회
    @Select("select * from student")
    List< StudentDto > findAll();
    // 3. 개별 학생 조회 // DTO도 가능하지만 MAP으로 테스트
    @Select("select * from student where sno = #{sno}")
    Map< String, Object > find(int sno);
    // 4. 개별 학생 삭제
    @Delete("delete from student where sno = #{sno}")
    int delete( int sno ); // 추상메소드
    // 5. 개별 학생 수정
    @Update("update student set  kor = #{kor} ,math = #{math} where sno = #{sno }")
    int update(StudentDto studentDto);
}
