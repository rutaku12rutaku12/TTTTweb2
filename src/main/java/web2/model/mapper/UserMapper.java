package web2.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import web2.model.dto.UserDto;

@Mapper
public interface UserMapper {

    // 1. 회원가입 (pk반환)
    @Insert("insert into users (uid,upwd,uname,uphone,urole) values (#{uid},#{upwd},#{uname},#{uphone},#{urole})")
    @Options( useGeneratedKeys = true , keyProperty = "uno")
    public int signup(UserDto userDto);

    // 2-1 로그인
//    @Select("select *from users where uid=#{uid} and upwd= #{upwd}")
//    UserDto login( UserDto userDto);

    // 2-2 : 회원 아이디로 계정 정보 조회 + 로그인
    @Select("select * from users where uid=#{uid}")
    UserDto login(String uid);

    // 3. : 패스워드를 제외한 아이디로 계정 정보 조회
    @Select("select uno,uid,uname,uphone,urole,udate from users where uid=#{uid}")
    UserDto myinfo(String uid);

    // 4. 로그가웃

}
