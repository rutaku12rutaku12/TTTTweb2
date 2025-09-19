package example.day09.service;

import example.day09.model.dto.PostDto;
import example.day09.model.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    // [1] 토론 글 작성
    public boolean postAdd(PostDto postDto){
        boolean result = postMapper.postAdd(postDto);
        return result;
    }
    // [2] 토론 글 삭제 (비밀번호 기반)
    public boolean postDelete(int pno, String ppwd){
        boolean result = postMapper.postDelete(pno,ppwd);
        return result;
    }
    // [3] 영화별 토론 전체 조회
    public List<PostDto> postPrint(int mno){
        List<PostDto> result = postMapper.postPrint(mno);
        return result;
    }
}
