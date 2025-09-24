package example.day08_1.model.mapper;

import example.day08_1.model.dto.MemberDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    // [1] 등록
    @Insert("insert into members (mname,mphone,mage) values ( #{mname},#{mphone},#{mage})")
    public boolean memberAdd(MemberDto memberDto);
    // [2] 전체조회
    @Select("select * from members")
    public List<MemberDto> memberPrint();
    // [3] 삭제
    @Delete("delete from members where mno = #{mno}")
    public boolean memberDelete(int mno);

} // class end
