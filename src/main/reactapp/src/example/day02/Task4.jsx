import { use, useState } from "react"

export default function Task4(props) {

    const [ name , setName ] = useState('');
    const nameChange =( name )=>{
        setName( name.target.value );        
    }
    const [ phone, setPhone ] = useState('');
    const phoneChange = (phone)=>{
        setPhone( phone.target.value);
    }
    const [ age , setAge ] = useState('');
    const ageChange = (age)=>{
        setAge( age.target.value);
    }
   
    const [ list , setList ] = useState([]);
    
    const register = () =>{
        const member = {
            name: name,
            phone: phone,
            age : age
        }
        setList([...list,member])
        setName('');
        setPhone('');
        setAge('');
    };

    return(<>
        <h3> 전화번호부 </h3>
        <input value={name} onChange={nameChange}/>
        <input value={phone} onChange={phoneChange}/>
        <input value={age} onChange={ageChange}/>
        <button onClick={register}>등록</button>
        <br></br>

        
        <h3>성명: {} 연락처:{} 나이: {}
         
        <button> 삭제  </button></h3><br></br>

        총 인원 : {}

    
        
        

    </>)
}