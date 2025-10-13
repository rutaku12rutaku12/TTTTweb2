package example.day13;

import example.day06.StudentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

@Mapper
public interface XmlMapper {

    // # 1. 등록
    // Mybatis 에서 SQL 매핑하는 방법
    // 방법1 : 추상메소드 위에 @insert("SQL") 작성 , 간단한 SQL CRUD 권장
    // 방법2 : 추상메소드를 매핑하는 XML 파일에서 SQL 작성 , 복잡한 ( 동적쿼리 ) SQL 권장
    // @Insert("INSERT INTO student(name, kor, math)values( #{name} , #{kor}, #{math}")
    // @Options( useGeneratedKeys = true , keyProperty = "sno") // 생성된 PK 값을 sno 필드에 매핑
    int save(StudentDto dto);

    // # 2. 전체조회
    List<StudentDto> findAll();

    // # 3. 개별 학생 조회
    StudentDto find( int sno);

    // # 4. 개별 학생 삭제
    int delete ( int sno);

    // # 5. 개별 학생 수정
    int update( StudentDto dto);


} // i end
