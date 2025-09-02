package example.day02;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component // 스프링 컨테이너에 빈 등록
public class ChatHandler extends TextWebSocketHandler {

    // ********** 서버에 접속된 클라이언트 소켓 명단 목록 *************
    private static final List< WebSocketSession > 접속명단 = new Vector<>();
    // * ArrayList 동기화 지원x , Vector 동기화 지원o : 채팅은 동시다발적으로 요청이 있으므로 동기화

    // 1. 클라이언트 소켓이 서버소켓으로부터 연결을 성공했을때 실행되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 성공");
        // WebSocketSession 이란 : ws 기반으로 서버로부터 요청한 클라이언트 정보가 저장된 객체
        // HttpSession 이란 : http 기반으로 클라이언트가 요청한 정보가 저장된 객체
        System.out.println("[클라이언트 웹소켓 객체] : " + session );
        // 1. 접속된 클라이언트 소켓들을 저장 : 받은 메세지를 접속된 소켓들에게 재전송 하기
        접속명단.add( session ); // 서버와 접속 성공한 클라이언트 소켓 정보(세션) 을 리스트에 저장
    }

    // 2. 클라이언트 소켓이 서버소켓 과 연결을 끊겼을때 실행되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[서버] 클아이언트소켓과 연동 실패");
        // 1. 클라이언트 소켓과 연결이 끊겼을때 접속명단에서 제외
        접속명단.remove( session );
    }

    // 3. 클라이언트 소켓이 서버소켓 에게 메시지를 보냈을때 실행되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("[서버] 클라이언트로부터 메시지 도착");
        System.out.println("[메시지확인] " + message.getPayload() );
        // [*] 서버가 클라이언트에게 메시지 보내기 , new TextMessage("문자열")
        // session.sendMessage( new TextMessage("클라이언트 안녕") );
        // 메시지를 받을세션.sendMessage( )
        // 서버로 부터 메시지를 보내온 클라이언트 소켓에게 메시지는 보내는 예제

        // 1. 특정한 클라이언트 소켓으로 부터 받은 메시지를 현재 접속된 다른 클라이언트소켓들에게 메시지를 보내기
        // 김현수 --> 안녕하세요(message) --> 카카오 서버 --> 안녕하세요(message) --> 김재영
        //                             --> 카카오 서버 --> 안녕하세요(message) --> 김현수
        for( WebSocketSession clientSocket : 접속명단 ){
            // 접속명단(리스트)내 저장된(접속)된 클라이언트소켓들을 하나씩 꺼낸다.
            // 클라이언트소켓 하나씩 .sendMessage 함수를 이용한 서버가 받은 메시지를 보내준다.
            clientSocket.sendMessage( message ); // message : 서버가 받은 메시지
        }

    } // func end

} // class end
