console.log('실습2.js open');


// 1. JS가 SPRING 에게 웹소켓 접속/연결 요청

const client = new WebSocket("/alarm")

// 2-1. 서버 소켓과 연결이 성공 되었을때
client.onopen = ( event ) => {
    console.log("[클라이언트] 연동 성공");
}

// 2-2. 서버 소켓과 연결이 종료 되었을때
client.onclose = ( event ) => {
    console.log("[클라이언트] 연동 종료");
}

// 2-3. 에러 발생시
client.onerror = ( event ) => {
    console.log("[클라이언트] 서버소켓과 에러발생");
}

client.onmessage = ( event ) => {
    console.log("[클라이언트] 서버로 부터 메시지 도착");
    console.log( event );
    console.log( event.data );
    alert(event.data);
}
