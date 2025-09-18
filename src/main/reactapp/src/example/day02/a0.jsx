import { useState } from "react";

export default function Aa2(){
const [name ,setName] = useState('');
const [phone,setPhone] = useState('');
const [age,setAge] = useState('');
const [members,setMembers] = useState([]);

const onAdd = ()=>{
    const obj = {
        name, phone, age 
    }
    members.push(obj);
    setMembers([...members])
}
const onDelete = (deletePhone) =>{
    const newMembers = members.filter(e=>{
      return deletePhone != e.phone ;})
    setMembers([...newMembers]);
    }

return(<>
    이름:<input value={name} onChange={(e)=>setName(e.target.value)}/>
    핸드폰:<input value={phone} onChange={(e)=>setPhone(e.target.value)}/>
    나이:<input value={age} onChange={(e)=>setAge(e.target.value)}/>
    <button onClick={ onAdd }>등록</button>
    
    {
        members.map((e)=>{
            return <div>{e.name} {e.phone} {e.age} 
                <button onClick={()=>{onDelete(e.phone)}}> 삭제 </button>
            </div>
        })
    }

</>)
}