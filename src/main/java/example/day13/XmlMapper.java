package example.day13;

import example.day06.StudentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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


    // =========== 동적쿼리 , 일반 SQL 코드를 프로그래밍 SQL로 변경 : <if> <forEach> 등등 =============
    // # 6-1. 특정한 국어점수가 이상인 학생 조회
    // 방법1 : @어노테이션( """<script> XML형식의SQL </script> """ ) XML 방식의 SQL 작성할 수 있다.
    @Select("""
            <script>
                select * from student where 1=1
                <if test="kor != null">
                    and kor >= #{kor}
                </if>
            </script>
            """)
    // """ """ : java15 이상부터 """ 템플릿 지원 , +연산자처럼 문자열 연결
    // where 1=1 : 무조건 true 만들기 위한 강제 참 , 문법 오류를 막기 위해 사용
        // 생략시, select * from student where and kor >= 90 으로 문제발생.
    // <if test="조건식"> 참일경우 SQL </if>
    List<StudentDto> query1( int kor );

    // [6-2] 방법2 : XML
    List<StudentDto> query2( int kor );

    // [7] 이름(포함된) 또는 수학점수(이상) 로 검색
    List<StudentDto> query3( String name , int math);

    // [8] 여러개 학생 등록
    int saveAll(List<StudentDto> dtos );
} // i end
