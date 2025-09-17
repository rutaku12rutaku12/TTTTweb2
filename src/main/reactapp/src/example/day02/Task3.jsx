import { useState } from "react";

export default function Task3( props ){
    
    // [1] 현재 수량을 관리하는 useState , const [ 변수명 , set변수명 ] = useState(초기값)
        // 1. 선언
    const [count , setCount] = useState(4); // useState(초기값);
        // 2. 수정 : 증가함수
    const countAdd = (e)=>{setCount(count+1);}
        // 2. 수정 : 감소함수
    const countMinus = (e)=>{setCount(count-1);}
    
    // [2] 현재 입력받은 제품명 관리 하는 useState
        // 2-1 선언
    const [data , setData] = useState(''); // '' 빈 문자열
        // 2-2 입력받은 제품명 변경 함수 , e : onChange를 이벤트결과 정보 담긴 객체
    const dataAdd = ( e ) => {setData(e.target.value);}

    return(<>
            <h3> 제품명 : <input value={data} onChange={dataAdd} /> </h3>
            <h3> 현재 수량 : {count}</h3>
            <button onClick={countAdd}>증가</button> <button onClick={countMinus}>감소</button>
        </>)
}