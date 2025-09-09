package example.day05._2웹크롤링;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task/day05")
@RequiredArgsConstructor // final 멤버변수의 생성자를 자동
public class CrawlingController {

    private final CrwalingService crwalingService;

    // 1.
    @GetMapping("/crawling1")
    public Map<String,String> task1(){
        return crwalingService.task1();
    }
    @GetMapping("/crawling2")
    public List<String> task2(){
        return crwalingService.task2();
    }
}
