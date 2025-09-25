package example.day09_1.model.mapper;

import example.day09_1.model.dto.MovieDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {

    // [1] 영화 등록
    @Insert("insert into movie (mtitle, mdirector , mgenre , mcontent , mpwd) values (#{mtitle},#{mdirector},#{mgenre},#{mcontent},#{mpwd})")
    public boolean movieAdd(MovieDto movieDto);

    // [2] 영화 삭제 (비밀번호 기반)
    @Delete("delete from movie where mno = #{mno} and mpwd = #{mpwd}")
    public boolean movieDelete(int mno , String mpwd);

    // [3] 영화 목록 조회
    @Select("select * from movie")
    public List<MovieDto> moviePrint();
}
