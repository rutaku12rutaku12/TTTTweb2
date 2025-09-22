import { BrowserRouter, Link, Route, Routes, useNavigate, useSearchParams } from "react-router-dom";
// [1] CSS 컴포넌트 가져오기
import './Task6.css';
import { useRef } from "react";

// [3] 홈 컴포넌트
function Home(props){
    return(<> 
    <h3>홈 페이지</h3> 
    
    좌측 메뉴에서 회원가입 또는 로그인으로 이동해보세요.
    </>)    
}
// [4] 회원가입 컴포넌트
function Signup(props){
    // [4-1] : 입력상자들을 참조하는 useRef
    const idRef = useRef(null);
    const pwdRef = useRef(null);
    // [4-3] : 라우터 전용 페이지 전환 함수 
    const navigator = useNavigate(null);
    // [4-2] : 특정한 이벤트에서 참조중인 useRef current 확인하기 
    const 회원가입 = async()=>{ console.log( idRef.current.value );
        // idRef.current [vs] document.querySelector() 도큐먼트는 전체 페이지에서 가져오는것이고 idRef는 아이디 인풋에서만 가져오는것 
        // idRef.current.value [vs] document.querySelector().value
        const id = idRef.current.value; // idRef : 참조객체 , idRef.current : 참조객체가 참조중인 값
        const pwd = pwdRef.current.value;
        const obj = {id,pwd}; 
        // * axios 를 이용한 서버(스프링) 통신 했다 치고 가정하고, *
        alert('[회원가입 성공]');
        // location.href="login" // 라우터 방식이 아닌 고전적인 HTML 방식으로 새로고침된다.(깜빡거림)
        navigator('/login'); // 라우터 방식 
    }
    return(<>
    <h3> 회원가입 페이지 </h3>
    <input ref={idRef} placeholder="아이디"/><br/>
    <input ref={pwdRef} placeholder="비밀번호"/><br/>
    <button onClick={회원가입} >회원가입</button>
    </>)
}
// [5] 로그인 컴포넌트
function Login(porps){
    const navigator = useNavigate(null);

    
        // [5-3] 라우터 페이지 전환
        // [5-1] 입력받은 정보들을 갖는 form 참조하는 useRef
        const formRef= useRef(null);
        // [5-2] 특정한 이벤트/함수에서 참조중인 useRef current 확인하기
        const 로그인 = async()=>{ console.log( formRef.current ); 
            const id = formRef.current.elements['id'].value;
            const pwd = formRef.current.elements['pwd'].value;
            // axios 했다 가정하고 
            alert('[로그인 성공]');
            navigator('/'); 

            
        }

    return(<>
    <h3> 로그인 페이지</h3>
        <form ref={formRef}>
            <input name="id" placeholder="아이디"/><br/>
            <input name="pwd" placeholder="비밀번호"/><br/>
            <button type="button" onClick={로그인}>로그인</button>
        </form>
    </>)
}
// [2] 라우터로 사용할 최초 컴포넌트 
export default function Task6(props){

    return(<>
    <BrowserRouter>
        <div className="container">
            <ul>
                <li><Link to='/'>홈</Link> </li>
                <li><Link to='/signup'>회원가입</Link></li>
                <li><Link to='/login'>로그인</Link></li>
            </ul>
            <div>
                <Routes>
                    <Route path="/" element= {<Home></Home>}></Route>
                    <Route path="/signup" element={<Signup></Signup>}></Route>
                    <Route path="/login" element={<Login/>}></Route>
                </Routes>
            </div>
        </div>
    </BrowserRouter>
    </>)
}