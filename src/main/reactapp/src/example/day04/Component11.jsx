import { useEffect, useRef, useState } from "react";

export default function Component11(props){

    // [1] 렌더링 하지 않고 데이터를 참조하는 훅 , useRefvs useState 
    const inputRef = useRef( null ); // 1. useRef 자동완성 => import 생성
    // 2. useRef( 초기값 )
    const 등록함수 = ()=>{ 
        // 3. inputRef : 현재 참조중인 객체 정보 { current : 참조값 }
        console.log( inputRef); 
        // 4. useRef.currnet : 참조값 
        console.log( inputRef.current);
        // -포커스( 마우스커서)
        inputRef.current.focus();
        // 단순 입력이라면 useState 보다 useRef 코드가 단순하다.
        console.log( inputRef.current.value );
    }
    // [2] useState 와 useRef 차이점
    const [ count , setCount] = useState(0);
    const countRef = useRef( count ); // useRef(초기값)
        // 2. count가 변경 될때 마다 
    // useEffect( () => {} , [] ) : 특정한 상태가 변경 될때마다 실행되는 훅(함수)
    useEffect( ()=>{countRef.current=count;},[count]); // count 의 상태가 변경되며 해당 함수(자동) 실행

    // [3] 
    const formRef = useRef();
    const 전송함수 = () =>{
        console.log(formRef.current); // 폼 내용물들을 한번에 가져와서 한번에 자바(스프링)에게 전송
        console.log(formRef.current.elements['textData'].value ); // formRef.current.elements[name속성명값]
        console.log(formRef.current.querySelector('.textData').value);
        console.log( document.querySelector('.textData').value);
    }
    return(<>
        <h3> useRef 예제1 </h3>
        <input ref={ inputRef } /> 
        <button onClick={ 등록함수 }> 등록 </button>

        <h3> useRef 예제2 </h3>
        <p> 현재 count : { count } / 이전 count: {countRef.current} </p>
        <button onClick={ (e)=>{ setCount(count+1) } }>증가</button>

        <h3> useRef 예제3 : 입력 폼 </h3>
        <form ref= {formRef}>
            <input name="textData" id="textData" class="textData"/>
            <select name="selectData"> <option> 바나나 </option></select>
            <textarea name="text2Data"></textarea>
            <button onClick={전송함수} type="button"> 폼 전송</button>

        </form>
    </>)
}
// form 안에서 버튼을 쓸 때는 type="button" 꼭 써야함