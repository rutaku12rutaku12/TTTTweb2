
console.log('chatting.js open');

// [*] 익명의 채팅(비회원제) , Math.floor( Math.random() * 끝값 ) + 시작값
const randomId = Math.floor( Math.random() * 1000 ) + 1
const nickName = `익명${randomId}` // 익명{난수} // 회원제 일경우 서버 로그인세션정보

// [*] 방번호( url querystring )
const params = new URL( location.href ).searchParams
const room = params.get('room') || "0"; // url 경로상의 room 번호 가져오기 없으면 0

// [1] 서버 웹 소켓과 연동하는 클라이언트 소켓 (객체) 생성
const client = new WebSocket("/chat");

// [2] 서버 웹 소켓과 연동 성공했을때
client.onopen = (event)=>{
    console.log("============ 서버 소켓과 연동 성공했다.===============");
    // (1). ======= 방번호에 특정한 닉네임을 **등록** 메시지 보내기 =========
    let msg = { type : "join" , room : room , nickName : nickName } // JSON 형식으로 문자열 메시지 보내기
    // JSON.stringify() : 객체(JSON)를 형식을 유지하고 문자열 타입으로 변환
    // JSON.parse()     : 문자열 타입을 객체(JSON) 타입으로 변환
    client.send( JSON.stringify(msg) );
}

// [3] 서버 웹 소켓과 연동 끊겼을때
client.close = (event)=>{
    console.log("============ 서버 소켓과 연동 끊겼다.===============");
}
// [4] 서버 웹 소켓으로 부터 메시지를 받았을때
client.onmessage = (event)=>{
    console.log("============ 서버 소켓으로부터 메시지를 받았다.===============");
    
    console.log( event ); // 해당 메소드가 왜 실행 되었는지 여러 정보가 들어있는 객체
    console.log( event.data ); // 4-1 서버로부터 받은 메시지(data속성) 확인

    // 4-2 받은 메시지를 JSON타입으로 변환
    const message = JSON.parse( event.data );
    // 4-3 받은 메시지의 type를 확인하여 서로 다른 html 만들어주기.
    let html = ``
    if( message.type == 'alarm' ){
        html += `<div class="alarm">
                    <span> ${message.message} </span>
                </div>`

    }else if( message.type == 'msg'){
        // *** 내가 보낸 메시지 
        if( message.from == nickName ){
            html += `<div class="secontent">
                        <div class="date"> ${message.date} </div>
                        <div class="content"> ${message.message} </div>
                    </div>`}
        // *** 남이 보낸 메시지
        else{html += `<div class="receiveBox">
                        <div class="profileImg">
                            <img  src="default.jpg"/>
                        </div>
                        <div>
                            <div class="recontent">
                                <div class="memberNic"> ${message.from} </div>
                                <div class="subcontent">
                                    <div class="content"> ${message.message} </div>
                                    <div class="date"> ${message.date} </div>
                                </div>
                            </div>
                        </div>
                    </div>`}
    } // 4-3 end 

    // 4-4 구성한 html를 <div class="msgbox"> 에 추가하기 , 대입 = , 추가 +=
    document.querySelector(".msgbox").innerHTML += html;

    // 4-5 만약에 <div class="msgbox"> 내 내용물이 고정 사이즈보다 커지면 자동 스크롤 내리기
    const msgbox = document.querySelector(".msgbox");
        // *** 현재 msgbox의 스크롤 (탑)위치를 가장 하단에 대입하기.
    msgbox.scrollTop = msgbox.scrollHeight
    // DOM객체.scrollTOP : 현재 dom(마크업)의 스크롤 상단 꼭지점 위치
    // DOM객체.scrollHeight : 현재 dom(마크업)의 스크롤 전체 길이 
} // func end

// [5] 클라이언트 소켓이 서버에게 **일반** 메시지 보내기
const onMsgSend = () =>{
    // 5-1. input 으로 부터 입력받은 값 가져오기
    const msginput = document.querySelector('.msginput');
    const message = msginput.value;
    // 5-2. 만약에 값이 없으면 종료
    if( message == '' ) return;
    // 5-3. 메시지 구성하기
    const msg = { 
        type : 'msg' ,                              // type:메시지종류(msg/join/alarm) 
        message : message ,                         // message : 메시지내용물
        from : nickName ,                           // from : 보낸사람
        date : new Date().toLocaleDateString()      // date : 현재날짜/시간
    }
    // 5-4 클라이언트소켓이 서버에게 구성한 메시지를 보내기
    client.send( JSON.stringify( msg))
    // 5-5 input 마크업 초기화
    msginput.value = '';
}
// [6] <input class="msginput"/> 에서 enter 입력 했을때
const enterKey = () =>{
    // 만약에 input 에서 enter키를 눌렀을때 , keyCode에서 enter : 13번
    if( window.event.keyCode == 13 ){ // keyCode : k소문자 C대문자
        onMsgSend(); // [5]메시지함수 호출
    }
}






















