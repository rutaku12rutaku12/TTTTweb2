package example2.실습.실습2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;
    // 영화 등록       새로운 영화 정보를 입력받아 DB에 저장
    @PostMapping
    public ResponseEntity<?> moviePost(@RequestBody MovieDto movieDto){

        return ResponseEntity.ok(
                movieService.moviePost(movieDto)
        );
    }
    // 영화 전체 조회   모든 영화 목록을 조회
    @GetMapping("/list")
    public ResponseEntity<?> movieAllFind(){
        return ResponseEntity.ok(movieService.movieAllFind());
    }

    // 영화 개별 조회   영화번호(movieId)를 기준으로 특정 영화 상세 정보 조회
    @GetMapping
    public ResponseEntity<?> movieOneFind(@RequestParam int movieId){
        return ResponseEntity.ok(movieService.movieOneFind(movieId));
    }
    // 특정 영화 수정   영화번호(movieId)를 기준으로 해당 영화 정보 수정, @Transactional의 역할을 서술한다.
    @PutMapping
    public ResponseEntity<?> movieUpdate(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.movieUpdate(movieDto));
    }
    // 특정 영화 삭제   영화번호(movieId)를 기준으로 해당 영화 삭제
    @DeleteMapping
    public ResponseEntity<?> movieDelete(@RequestParam int movieId){
        return ResponseEntity.ok(movieService.movieDelete(movieId));
    }
}
