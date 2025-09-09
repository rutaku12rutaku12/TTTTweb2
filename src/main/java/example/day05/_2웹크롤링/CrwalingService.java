package example.day05._2웹크롤링;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // 스프링이 컨테이너(메모리) 빈(객체) 주입
public class CrwalingService {

    // 1. 다음날씨 정보 크롤링
    public Map<String,String> task1(){
        // 1-1 : 크롬 설치
        WebDriverManager.chromedriver().setup();
        // 1-2 : 크롬 옵션 객체 생성
        ChromeOptions chromeOptions = new ChromeOptions();
        // * 크롬은 사용하지만
        chromeOptions.addArguments("--headless=new" , "--disable-gpu");
        // 1-3 크롬 옵션을 웹드라이버(셀레니옴) 에 객체생성
        WebDriver webDriver = new ChromeDriver( chromeOptions );
        // 1-4 크롤링 할 웹주소
        String URL = "https://weather.daum.net/";
        // 1-5 : 셀레니움(웹드라이버) 으로 크롤링할 웹주소 가져오기
        webDriver.get( URL );
        // 1-6 : 셀레니움(웹드라이버) 잠시 대기 , new WebDriverWait(셀레니움객체, Duration.ofSeconds( 초 ));
            // * 왜? 대기하나요? 동적페이지는 JS(fetch)가 정보를 가져올때까지 정보가 없으므로 기다린다.
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        // 1-7 대기후 크롤링할 HTML CSS 분석하기 , 권장: 식별자가 1개가 아닌 상위식별자를 넣어서 중복방지
            // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector( 크롤링할선택자 )))
            // (1) 지역 .info_location .tit_location
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".info_location .tit_location")));
            System.out.println("location = " + location);
            // (2) 온도 .wrap_weather .num_deg
        WebElement temp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".wrap_weather .num_deg")));
            System.out.println("temp = " + temp);
            // (3) 상태 .sub_info .txt_sub
        WebElement stats = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sub_info .txt_sub")));
            System.out.println("stats = " + stats);
            // (4) 미세먼지 .list_air .item_air
        WebElement dust = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list_air .item_air")));
        // 1-8 크롤링한 요소(HTML 마크업)의 텍스트를 추출하여 map/dto 저장
        Map<String,String> map = new HashMap<>();
        map.put("위치",location.getText() ); //.get("key",value);
        map.put("온도",temp.getText() );
        map.put("상태",stats.getText() );
        map.put("미세먼지",dust.getText());
        // 1-9 셀리니움(웹드라이버) 수동 종료
        webDriver.quit();

        return map; // 구성한 map 반환
    } // m end

    // 2. CGV 영화리뷰(+무한스크롤)
    public List<String> task2(){
        // 2-1 크롬 설치
        WebDriverManager.chromedriver().setup();
        // 2-2 크롬 옵션 , 브라우저 화면 띄우지않는다.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new","--disable-gpu");
        // 2-3 셀레니움(웹드라이버) 객체 생성
        WebDriver webDriver = new ChromeDriver( chromeOptions );
        // 2-4 크롤링할 웹주소
        String URL = "https://cgv.co.kr/cnm/cgvChart/movieChart/89833";
        // 2-5 셀레니움(웹드라이버) 으로 크롤링할 웹주소 가져오기
        webDriver.get(URL);
        // 2-6 : 리뷰( .reveiwCard_txt__RrTgu) 를 여러개 가져오기
        // 1개 WebElement webElement = webDriver.findElement();
        // N개: List<WebElement> elements = webDriver.findElements();

        List<String> list = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        // 2-9 ========= 아래 작업들을 N번 반복 ==============//
        for( int i = 1; i<=10; i++ ){
        List <WebElement> webElements =
            webDriver.findElements(By.cssSelector(".reveiwCard_txt__RrTgu"));
        // 2-7 가져온 리뷰들을 리스트에 담아보기
        int startCount = list.size();
        for( WebElement element : webElements ) { // 여러개 리뷰 요소들을 하나씩 조회
            String text = element.getText(); // 현재 조회중인 요소의 텍스트(리뷰) 가져오기
            if( list.contains(text)){// 만약에 스크롤 내리고 리스트내 앞전의 리뷰와 포함되면 생략/패스
                continue; // 가장 가까운 반복문으로 이동 -> 2-7
            }
            list.add(text);
        }
        // ** 만약에 비어있거나 list에 추가적인 내용이 없으면 2-9 반복문 종료
        int endCount = list.size();
        if( startCount == endCount )break;

        // ============ 자바에서 JS 사용 ( 스크롤 내리는 작업 ) ==============//
        // 2-8 자바스크립트 조작하는 객체 , 셀레니움객체를 자바스크립트실행객체로 변환
            // JavascriptExecutor js = (JavascriptExecutor) webDriver; 위로 올림
        // document.body(화면) 에서 최하단으로 스크롤 이동
        js.executeScript("window.scrollTo( 0 , document.body.scrollHeight); ");
        try{Thread.sleep(1500);}catch (Exception e){System.out.println(e);}// 0.5초 대기

        }
        return list;
    }// func end

} // class end









































