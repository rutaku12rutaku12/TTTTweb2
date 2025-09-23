import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom";
import { login } from "../../userSlice";

export default function LoginPage(props){
    const dispatch = useDispatch();
    const navigate = useNavigate();
    
    const onLogin = async () =>{
        alert('로그인성공');
        // dispatch(login());
        const obj = {id:3, name : "유재석"}
        dispatch(login(obj));
        navigate("/");
    }
    return(<>
        <h3> 로그인페이지</h3>
        <button onClick={onLogin}>로그인버튼</button>
    </>)
}