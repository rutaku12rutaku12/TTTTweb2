import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom";
import { login } from "../store/userSlice";

export default function LoginPage(props){

    // [1] 액션하기위한 dispatch 함수 가져오기
    const dispatch = useDispatch();
    // [2] 가상 URL 로 페이지 전환하기 위한 navigate 함수 가져오기
    const navigate = useNavigate();
    // 1. 로그인 처리 함수 정의  axios 생략
    const onLogin =async()=>{
        alert('[로그인성공]');
        // dispatch(login()); // 로그인(true)으로 전역상태 변경
        const obj = {id : 3, name: "유재석"} // [1-2] lgoin 액션에 보낼 데이터
        dispatch(login(obj)); // [1-3] 매개변수를 포함한 login 액션요청
        navigate("/"); // 라우터 등록된 "/" URL로 이동
    }

    return(<>
    <h3> Login페이지</h3>
    <button onClick={onLogin}>로그인</button>
    </>)
}