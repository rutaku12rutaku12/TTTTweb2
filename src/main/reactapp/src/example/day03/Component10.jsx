import axios from "axios" // ☆☆☆☆☆☆☆☆☆ 'axios' import 하기
import { useEffect, useState } from "react";

// ========= 스프링 서버내 day07(boardservice13) ==========
export default function Component10 (props) {
    // [1] 입력받은 데이터들을 관리하는 useState
    const [ bcontent , setBcontent ] = useState('');
    const [ bwriter , setBwriter ] = useState('');

    // [2] axios 이용하여 스프링 서버에게 등록 요청
    const boardWrite = async () =>{
        // 2-1 : 입력받은 데이터들을 객체화
        const obj ={ bcontent, bwriter }
        // 2-2 : axios 요청
        const response = await axios.post("http://localhost:8080/board", obj)
        console.log(response.data);
        boardPrint()
    }
    // [3] 출력할 데이터들을 관리하는 useState
    const [ posts , setPosts ] = useState([ {bno : 1 , bcontent: "test" , bwriter : "test"} ]);

    // [4] 출력할 데이터들을 axios 이용하여 스프링에게 요청 , [2-3]실행 , [5] 실행
    const boardPrint = async()=>{
        // 4-1 : axios 요청
        const response = await axios.get("http://localhost:8080/board");
        // 4-2 : axios 요청값을 상태관리 변수에 저장
        setPosts(response.data);

        console.log(response.data);
        console.log(response.status);
    }
    // [5] useEffect 이용한 최초 컴포넌트 실행시 출력함수 실행
    useEffect(()=>{ boardPrint() }, []) // 의존성배열이 비어있는 경우 ☆☆☆ 1번만 ☆☆☆ 실행

    // [6] 삭제함수 정의/만들기 
    const boardDelete = async(deletebno) =>{
        // 6-1 : axios 이용하여 삭제할번호를 스프링 서버에게 보내서 요청한다. (백엔드에서 삭제해라 요청)
        const response = await axios.delete(`http://localhost:8080/board?bno=${deletebno}`)

        // *** 6-2(1) *** : 삭제할 bno를 매개변수로 받아서 반복문 이용하여 삭제할 bno를 제외한 새로운 리스트 생성 (프론트에서 삭제해라 요청)
            const newposts = posts.filter( m=>{return deletebno != m.bno})
            // 6-3 재렌더링 
            setPosts([...newposts]);
        
        // *** 6-2(2) *** [4] 함수를 재실행하여 axios 와 재렌더링한다.
        // boardPrint()
    }
    return(<>
        <h3> 스프링 서버의 boardService13(day07) 통신</h3>
        <input value={bcontent} onChange={(e)=>setBcontent(e.target.value) } />
        <input value={bwriter} onChange={(e)=>setBwriter(e.target.value) }/>
        <button onClick={boardWrite}>등록</button>
        {
            posts.map((e)=>{
                    return <div> {e.bno} {e.bcontent} {e.bwriter}
                            <button onClick={ () =>{boardDelete(e.bno)}}>삭제</button>
                            <button>수정</button>
                    </div>

                })
        }
        
    </>)
} // func end 

    const boardFind = async()=>{
        const response2 = await axios.get(`http://localhost:8080/board/find?bno=${bno}`)
        console.log(response2.data);
        console.log(response2.status);
    }
    const boardUpdate = async() =>{
        const response1 = await axios.put(`http://localhost:8080/board?bno=${bno}`)
        console.log(response1.data);
        console.log(response1.status);
        boardPrint()
    }