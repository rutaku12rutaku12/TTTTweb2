// TASK5 : 기존 TASK4.jsx 이어 useEffect/axios를 활용해서 spring+mybatis 서버 와 통신하여 TASK5 완성(등록/전체조회/삭제)하시오.

import axios from "axios";
import { useEffect, useState } from "react";
import './Task5.css'

export default function Task5( props ){
    // [1] 입력받은 데이터들을 관리하는 useState
    const [ mname , setName ] = useState('');
    const [ mphone , setPhone ] = useState('');
    const [ mage , setAge ] = useState('');
    const mno = '';

    // [2] axios 이용하여 스프링 서버에게 등록 요청
    const memberAdd = async ( ) => {
        // 2-1 : 입력받은 데이터들을 객체화
        const obj = { mname , mphone , mage }
        // 2-2 : axios 요청
        const response = await axios.post("http://localhost:8080/member",obj)
        console.log(response.data);
        memberPrint();
        setName('');
        setPhone('');
        setAge('');
    }
    // [3] 출력할 데이터들을 관리하는 useState
    const [ members , setMembers ] = useState( 
        [ {mno :1 , mname:"유재석" ,mphone:"010-2231-2231",mage:30} ] 
    );

    // [4] 출력할 데이터들을 axios 이용하여 스프링에게  요청 
    const memberPrint = async() =>{
        const response = await axios.get("http://localhost:8080/member")
        setMembers(response.data)
    }
    // [5] useEffect 이용한 최초 컴포넌트 실행시 출력함수 실행
    useEffect(()=>{ memberPrint() } , []) 

    // [6] 삭제함수 정의/만들기 
    const memberDelete = async ( deletemno )=>{ console.log( deletemno );
        // 6-1 : axios 이용하여 삭제할번호를 스프링 서버에게 보내서 요청한다. 백엔드 제거
        const response = await axios.delete(`http://localhost:8080/member?mno=${deletemno}`)
        // 6-2 : 삭제할 mno를 매개변수로 받아서 반복문을 이용하여 삭제할 mno를 제외한 새로운 리스트 생성 , 프론트 제거
        const newMembers = members.filter( (e)=> { return e.mno != deletemno ; })
        setMembers( [ ...newMembers ] );
    }

    return (<>
    <div className="wrap">
        <h1>전화번호부</h1>
        <input className="inputBox" value={ mname } onChange={ (e)=>{ setName(e.target.value ) } } placeholder="성명" />
        <input className="inputBox" value={ mphone } onChange={ (e)=>{ setPhone( e.target.value) } }
        placeholder="연락처 (예: 010-1234-5678)"/>
        <input className="inputBox" value={ mage } onChange={ (e)=>{ setAge( e.target.value ) } } 
        placeholder="나이"/>
        <button className="addButton" onClick={ memberAdd }> 등록 </button> <br/>

        {   members.map( ( e ) => {
                return <div key={e.mno}>
                        <div className="underLine">
                            <span className="bold">성명 :</span> { e.mname } 
                            <span className="bold">연락처 :</span> { e.mphone } 
                            <span className="bold">나이 :</span> { e.mage }
                        <button id="leftMargin" className="deleteButton" onClick={ ()=> { memberDelete( e.mno ) }  }> 삭제 </button>
                        </div>
                    </div>
            })
        }
        <span className="grayFont">총 {members.length}명</span>
    </div>
    </>)
}
