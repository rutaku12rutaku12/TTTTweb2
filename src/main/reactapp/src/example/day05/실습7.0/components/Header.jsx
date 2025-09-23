import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { login, logout } from "../../userSlice";
// const { isAuthenticated} = useSelector( (state)=>state.user);
export default function Header( props ){

    const { isAuthenticated, userInfo } = useSelector( (state)=> state.user);
    console.log(userInfo);

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const onLogout = async()=>{
        alert('로그아웃 성공');
        dispatch(logout());
        navigate('/login');
    }
    const onLogin = async()=>{
        alert('로그인 성공');
        dispatch(login());
        navigate('/');
    }
    return(<>
        <div>
            <h3> 헤더 페이지 </h3>
            <ul>
                <li><Link to ="/">메인페이지</Link></li>
                {isAuthenticated == true 
                ? <>
                        <li><span> 안녕하세요.{userInfo.name} 님 </span></li>
                        <li><Link to ="/profile"> 프로필 페이지</Link></li>
                        <li><button onClick={onLogout}>로그아웃 버튼</button></li>
                </>
                :   
                <>
                        <li><Link to ="/login"> 로그인 페이지</Link></li>
                </>
                }
            </ul>
        </div>
    </>)
}