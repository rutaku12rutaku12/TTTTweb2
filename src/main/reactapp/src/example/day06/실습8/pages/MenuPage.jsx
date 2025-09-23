import { useDispatch, useSelector } from "react-redux"
import { minus, plus } from "../store/cartSlice";

export default function MenuPage(props){

    const menu = [
    { id: 1, name: "아메리카노", price: 3000 }, 
    { id: 2, name: "카페라떼", price: 4000 },
    { id: 3, name: "카푸치노", price: 4500 },
    ];



    const { cartcount } = useSelector((state)=>state.count)
    console.log(cartcount);

    // [1] 액션(상태변경) 하기위한 dispatch 함수 가져오기
    const dispatch = useDispatch();
    // 담기 함수 정의 : axios 생략
    const onPlus = async (id) => {
        alert('담기 성공'); 
        dispatch(plus(id));console.log("아이디번호:"+id);
    }
    // 빼기 함수 정의 : axios 생략
    const onMinus = async (id) => {
        alert('빼기 성공');
        dispatch(minus(id));console.log("아이디번호:"+id);

    }
                                           
    return(<> 제품 페이지 
        { menu.map( (e) =>{
            return <div key={e.id}>
                <ul>
                    { cartcount >= 1 ?
                    <li>{e.name} : {e.price}원 <button onClick={()=>{onPlus(e.id)}}> 담기 </button><button onClick={()=>{onMinus(e.id)}}>빼기</button></li>
                    :<li>{e.name} : {e.price}원 <button onClick={()=>{onPlus(e.id)}}> 담기 </button></li>
                    }
                </ul>
            </div>
            })
        }
    </>)
    
}