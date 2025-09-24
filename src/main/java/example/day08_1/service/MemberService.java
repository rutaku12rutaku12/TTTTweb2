package example.day08_1.service;

import example.day08_1.model.dto.MemberDto;
import example.day08_1.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    // [1] 등록
    public boolean memberAdd(MemberDto memberDto){
        boolean result = memberMapper.memberAdd(memberDto);
        return result;
    }
    // [2] 전체조회
    public List<MemberDto> memberPrint(){
        List<MemberDto> result = memberMapper.memberPrint();
        return result;
    }
    // [3] 삭제
    public boolean memberDelete(int mno){
        boolean result = memberMapper.memberDelete(mno);
        return result;
    }
}
