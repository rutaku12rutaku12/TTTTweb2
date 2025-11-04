package example2.실습.실습2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface MovieRepository
        extends JpaRepository<MovieEntity,Integer> {
}
