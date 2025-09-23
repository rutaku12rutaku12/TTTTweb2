import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { login, logout } from "../../userSlice";

export default function Header(props){
    // [1] store 저장된 상태를 가져오기 , useSelector( (state) => state.상태명 )
    // const { isAuthenticated } = useSelector( ( state ) => state.user );
    // console.log( isAuthenticated ); // 로그인시 true 아닐시 false 콘솔 출력
    const {isAuthenticated , userInfo } = useSelector( (state)=>state.user);

    
    // [2] dispatch 이용한 상태 변경 하기 
    const dispatch = useDispatch();
    const navigate = useNavigate();
  
    const logoutHandle = ( ) => {
        alert('로그아웃 성공');
        dispatch( logout() );
        navigate('/login');
    }

    return(<>
        <h3>헤더 페이지 </h3>
        <ul>
            <li><Link to="/"> 메인페이지 </Link> </li>
            {isAuthenticated == true
            ? <div>
                
                <li><Link to="/profile"> 프로필페이지 </Link> </li>
                <p>안녕하세요 {userInfo.name} 회원님!</p>
                <button onClick={logoutHandle}> 로그아웃 버튼</button>
            </div>
            :
            <div>
                <p>로그인 상태가 아닙니다.</p>
                <li><Link to="/login"> 로그인페이지 </Link> </li>
            </div>
            }
            
            
        </ul>
    </>)
}