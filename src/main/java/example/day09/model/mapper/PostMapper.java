package example.day09.model.mapper;

import example.day09.model.dto.PostDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    // [1] 토론 글 작성
    @Insert("insert into post (mno,pcontent,ppwd) values (#{mno}, #{pcontent},#{ppwd});")
    public Boolean postAdd(PostDto postDto);

    // [2] 토론 글 삭제 (비밀번호 기반)
    @Delete("delete from post where pno = #{pno} and ppwd = #{ppwd};")
    public boolean postDelete(int pno , String ppwd);

    // [3] 영화별 토론 전체 조회
    @Select("select * from post where mno = #{mno};")
    public List<PostDto> postPrint(int mno);
}
