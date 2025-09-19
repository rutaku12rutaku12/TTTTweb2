package example.day09.controller;

import example.day09.model.dto.MovieDto;
import example.day09.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // http 요청과 응답 처리
@RequestMapping("/movie") // 공통 HTTP URL 매핑
@RequiredArgsConstructor // final 변수에 대해 자동 생성자
@CrossOrigin( value="http://localhost:5173/") // 리액트 서버와 CORS 통신 허용
public class MovieController {

    private final MovieService movieService;

    // [1] 영화 등록
    @PostMapping
    public ResponseEntity<Boolean> movieAdd(@RequestBody MovieDto movieDto){
        try{
        boolean result = movieService.movieAdd(movieDto);
        return ResponseEntity.status(200).body(result);
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }
    // [2] 영화 삭제 (비밀번호 기반)
    @DeleteMapping
    public ResponseEntity<Boolean> movieDelete(@RequestParam int mno , @RequestBody String mpwd ){
        boolean result = movieService.movieDelete(mno,mpwd);
        return ResponseEntity.status(200).body(result);
    }

    // [3] 영화 목록 조회
    @GetMapping
    public ResponseEntity<List<MovieDto>> moviePrint(){
        List<MovieDto> result = movieService.moviePrint();
        return ResponseEntity.status(200).body(result);
    }
}
