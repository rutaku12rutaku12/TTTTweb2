import { Link } from "react-router-dom";

export default function Hedaer(props){
    
    return(<>  
    
        <Link to={"/"}> 홈으로 </Link> <br/>
        <Link to={"/menu"}> 제품 페이지 </Link><br/>
        <Link to={"/cart"}> 장바구니 </Link><br/><br/>
    </>)
}