package example.day09.controller;

import example.day09.model.dto.PostDto;
import example.day09.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // http 요청 응답 처리
@RequestMapping("/post") // 공통 HTTP URL 설정
@RequiredArgsConstructor // 파이널 변수에 대해 자동 생성자
@CrossOrigin( value = "http://localhost:5173/") // 리액트 서버와 CORS 통신 허용
public class PostController {

    private final PostService postService;

    // [1] 토론 글 작성
    @PostMapping
    public ResponseEntity<Boolean> postAdd(@RequestBody PostDto postDto){
        boolean result = postService.postAdd(postDto);
        return ResponseEntity.status(200).body(result);
    }
    // [2] 토론 글 삭제 (비밀번호 기반)
    @DeleteMapping
    public ResponseEntity<Boolean> postDelete(@RequestParam int pno , @RequestBody String ppwd){
        boolean result = postService.postDelete(pno,ppwd);
        return ResponseEntity.status(200).body(result);
    }
    // [3] 영화별 토론 전체 조회
    @GetMapping
    public ResponseEntity<List<PostDto>> postPrint(@RequestParam int mno){
        List<PostDto> result = postService.postPrint(mno);
        return ResponseEntity.status(200).body(result);
    }
}
