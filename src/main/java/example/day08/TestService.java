package example.day08;

public class TestService {

    // 메소드1
    public void enter1(){
        System.out.println("식당 입장");
    }
    // 메소드2
    public void enter2(){
        System.out.println("학원 입장");
    }

    public static void main(String[] args) {
        TestService testService = new TestService(); // 메소드1/2 실행하기 위한 객체 생성
        testService.enter1(); // 메소드1 호출
        testService.enter2(); // 메소드2 호출


    } // main end
} // class end
