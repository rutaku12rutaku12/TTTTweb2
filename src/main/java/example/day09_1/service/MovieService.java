package example.day09_1.service;

import example.day09_1.model.dto.MovieDto;
import example.day09_1.model.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;

    // [1] 영화 등록
    public boolean movieAdd(MovieDto movieDto){
        boolean result = movieMapper.movieAdd(movieDto);
        return result;
    }

    // [2] 영화 삭제 (비밀번호 기반)
    public boolean movieDelete(int mno, String mpwd){
        boolean result = movieMapper.movieDelete(mno,mpwd);
        return result;
    }

    // [3] 영화 목록 조회
    public List<MovieDto> moviePrint(){
        List<MovieDto> result = movieMapper.moviePrint();
        return result;
    }
}
