import { use, useState } from "react"


export default function Task4(props) {
    // 1. useState : 상태(변수값) 관리(변수값에 따른 재렌더링) 훅 
    const [ name , setName ] = useState('');
    const nameChange =( e )=>{setName( e.target.value );}
    
    const [ phone, setPhone ] = useState('');
    const phoneChange = (e)=>{setPhone( e.target.value);}

    const [ age , setAge ] = useState('');
    const ageChange = (e)=>{setAge( e.target.value);}
   
    const [ list , setList ] = useState( [ ] ); // 회원정보 객체를 담는 리스트
    // 2. '등록' 버튼을 클릭 했을때 함수
    const register = () =>{
        // 2-1 : 입력받은 데이터들을 객체화
        const member = {
            name: name,
            phone: phone,
            age : age
        }
        // 2-2 객체를 리스트에 저장
        list.push(member); 
        // 2-3 리스트를 재렌더링
        // ( 주의할점 : 객체/배열는 ...스프레드 연산자 이용한 복사 = 주소값 변경 )
        setList([...list])
           // setName('');
           // setPhone('');
           // setAge('');
    };
        // 3. 삭제 버튼을 클릭했을때, 무엇을 삭제할지 매개변수(pk/중복값없는) 필요
        const onDelete = ( deletePhone ) =>{
            // 3-1 반복문 이용하여 리스트내 삭제할 번호를 찾아서 제거한다.
            const newlist = list.filter( m=>{
                return m.phone!= deletePhone; })
            
            // 3-2 : *** 수정된 리스트를 재렌더링
            setList([...newlist]);
            // for vs forEach vs map +return vs filter +if
        }


    // ----------- jsx 에서 { }중괄호 js표현식의 시작과 끝
    // ----------- [1] 1. onClick= { 함수명 } 또는 
                    // 2. onCLick = { ()=>{} 함수정의 } 
                        // * 주의할점 : onClick={ 함수명() } 이렇게하면 즉시실행됨
                    // 3. onClick={ ()=> 함수명(매개변수) } 
    // ----------- [2] 리스트 출력시 forEach 대신에 ** map ** 사용한다.
    return(<>
        <h3> 전화번호부 </h3>
        성명: <input value={name} onChange={nameChange}/>
        연락처: <input value={phone} onChange={phoneChange}/>
        나이: <input value={age} onChange={ageChange}/>
        <button onClick={register}>등록</button>
        <br/>
        { 
            list.map(( m )=> {
                return <div> 
                            성명: {m.name} 연락처: {m.phone} 나이: {m.age} 
                            <button onClick={()=>{onDelete( m.phone)}}>삭제</button>
                        </div>
            })

        }
        총 인원 : {list.length}명

    </>)
}