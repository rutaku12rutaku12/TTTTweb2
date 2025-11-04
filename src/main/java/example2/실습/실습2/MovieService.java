package example2.실습.실습2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    // 영화 등록       새로운 영화 정보를 입력받아 DB에 저장
    public MovieDto moviePost( MovieDto movieDto){
        MovieEntity entity = movieDto.toEntity();
        MovieEntity postEntity = movieRepository.save(entity);
        if(postEntity.getMovieId()>0){
            return postEntity.toDto();
        }
        return movieDto;
    }
    // 영화 전체 조회   모든 영화 목록을 조회
    public List<MovieDto> movieAllFind(){
        List<MovieEntity> movieEntityList = movieRepository.findAll();

        List<MovieDto> movieDtoList = movieEntityList
                .stream().map( MovieEntity :: toDto)
                .collect(Collectors.toList());
        return movieDtoList;
    }
    // 영화 개별 조회   영화번호(movieId)를 기준으로 특정 영화 상세 정보 조회
    public MovieDto movieOneFind( int movieId){
        Optional<MovieEntity> optional = movieRepository.findById(movieId);
        if( optional.isPresent()){
            MovieEntity entity = optional.get();
            return entity.toDto();
        }
        return null;
    }
    // 특정 영화 수정   영화번호(movieId)를 기준으로 해당 영화 정보 수정, @Transactional의 역할을 서술한다.
    public MovieDto movieUpdate(MovieDto movieDto){
        Optional<MovieEntity> optional =
                movieRepository.findById(movieDto.getMovieId());
        if(optional.isPresent()){
            MovieEntity entity = optional.get();
                entity.setTitle(movieDto.getTitle());
                entity.setDirector(movieDto.getDirector());
                entity.setRating(movieDto.getRating());
                entity.setReleaseDate(movieDto.getReleaseDate());
                return entity.toDto();
        }
        return movieDto;
    }
    // 특정 영화 삭제   영화번호(movieId)를 기준으로 해당 영화 삭제
    public boolean movieDelete(int movieId){
        if( movieRepository.existsById(movieId)){
            movieRepository.deleteById(movieId);
            return true;
        }
        return false;
    }
}











