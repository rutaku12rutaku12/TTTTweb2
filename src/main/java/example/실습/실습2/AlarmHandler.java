package example.실습.실습2;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component // 스프링 컨테이너에 빈 등록
public class AlarmHandler extends TextWebSocketHandler {

    private static final List< WebSocketSession > 접속명단 = new Vector<>();

    // 1. 클라이언트 소켓이 서버소켓으로 부터 연결을 성공했을때 실행되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 성공");
        System.out.println("[클라이언트 웹소켓 객체] : " + session );
        // 서버와 접속 성공한 클라이언트 소켓 정보를 리스트에 저장
        접속명단.add(session);
        for( WebSocketSession clientSocket : 접속명단 ){
            clientSocket.sendMessage( new TextMessage("익명의 유저가 접속했습니다."));
        }
    }

    // 2. 클라이언트 소켓이 서버소켓 과 연결을 끊겼을때 실행되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 실패");
        // 클라이언트 소켓과 연결이 끊겼을때 접속명단에서 제외
        접속명단.remove(session);
        for( WebSocketSession clientSocket : 접속명단 ){
            clientSocket.sendMessage( new TextMessage("익명의 유저가 퇴장했습니다."));
        }
    }


} // class end
