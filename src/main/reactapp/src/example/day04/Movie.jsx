import axios from "axios";
import { use, useEffect, useState } from "react"

export default function Movie(props){
    // [1] 입력받은 데이터들을 관리하는 useState
    const [mtitle , setMtitle] = useState('');
    const [mdirector, setMdirector] = useState('');
    const [mgenre, setMgenre] = useState('');
    const [mcontent , setMcontent] = useState('');
    const [mpwd, setMpwd] = useState('');
    const mno = '';

    // [2] axios 이용하여 스프링 서버에게 등록 요청
    const movieAdd = async()=>{
        // 2-0 유효성 검사 
        if(!mtitle || !mdirector || !mgenre || !mcontent || !mpwd) return alert("모든 값을 입력해주세요.");
        // 2-1 입력받은 데이터들을 객체화
        const obj = {
            mtitle , mdirector , mgenre , mcontent , mpwd
        }
        // 2-2 axios 요청
        const response = await axios.post("http://localhost:8080/movie",obj)
        console.log(response.data);
        moviePrint();
        setMtitle('');
        setMdirector('');
        setMgenre('');
        setMcontent('');
        setMpwd('');
    }
    // [3] 출력할 데이터들을 관리하는 useState
    const [ movies , setMovies ] = useState( [
        {mno:1,mtitle:"어쩔수없다",mdirector:"감독님",mgenre:"스릴러",mcontent:"범인은 바로 당신",mpwd:1324} 
    ] );

    // [4] 출력할 데이터들을 axios 이용하여 스프링에게 요청
    const moviePrint = async () => {
        const response = await axios.get("http://localhost:8080/movie")
        setMovies(response.data)
    }
    
    // [5] useEffect 이용한 최초 컴포넌트 실행시 출력함수 실행
    useEffect(()=>{moviePrint()} , [] )

    // [6] 삭제함수 정의/만들기 
    const movieDelete = async (no,password)=>{
         console.log('삭제할 번호:'+no); console.log('삭제할 번호의 비밀번호:'+password);
        // * 유효성 검사
        const password1 = prompt("비밀번호를 입력하세요. :");
        // 프롬프트로 입력받은 비밀번호와 실제로 삭제할 번호의 비밀번호가 일치하지 않으면 
        if(password1!=password)return alert('비밀번호가 일치하지 않습니다.');
        // 6-0 : 프롬프트로 사용자로부터 입력받은 값을 객체화 
        const obj = {
            no,mpwd:password1
        }
        // 6-1 : axios 이용하여 삭제할 번호를 스프링 서버에게 보내서 요청한다. 백엔드 제거
        const response = await axios.delete(`http://localhost:8080/movie`,{params:{mno:no},data:obj});
        
        console.log(response.data);
        // 6-2 : 삭제할 mno 와 password를 매개변수로 받아서 반복문을 이용하여 삭제할 mno 를 제외한 새로운 리스트 생성, 프론트 제거 
        const newMovies = movies.filter((e)=> { return (e.mno != no )} );
        setMovies([...newMovies]);
        alert("삭제가 완료되었습니다.")
    }

    // [7]

    return(<>
    <h1>추천 영화 등록</h1>
    <input value={mtitle} onChange={(e)=>setMtitle(e.target.value)} placeholder="영화제목을 작성해주세요." /><br/><br/>
    <input value={mdirector} onChange={(e)=>setMdirector(e.target.value)} placeholder="감독을 작성해주세요."/><br/><br/>
    <input value={mgenre} onChange={(e)=>setMgenre(e.target.value)} placeholder="장르를 작성해주세요."/><br/><br/>
    <textarea value={mcontent} onChange={(e)=>setMcontent(e.target.value)} placeholder="간단한 소개를 작성해주세요."/><br/><br/>
    <input value={mpwd} onChange={(e)=>setMpwd(e.target.value)} type="password" placeholder="비밀번호를 작성해주세요."/><br/><br/>
    <button onClick={movieAdd}>등록</button>

    <br/><br/> <h1>추천 영화 목록</h1>
    { movies.map((e)=>{
        return <div key ={e.mno}>
            <span>영화 제목 :{e.mtitle}</span> <br/><br/>
            <span>감독 :{e.mdirector}</span> <br/><br/>
            <span>장르 :{e.mgenre}</span> <br/><br/>
            <span>영화 소개 :{e.mcontent}</span> <br/><br/>
            <button onClick={()=>{movieDelete(e.mno,e.mpwd)}}>삭제</button><br/><br/>
        </div>
    })
    }
    <br/><br/><Post></Post>
  

    </>)
}

function Post(props){
    // [1] 입력받은 데이터들을 관리하는 useState
    const [pcontent , setPcontent] = useState('');
    const [ppwd , setPpwd] = useState('');

    // [2] axios 이용하여 스프링 서버에게 등록 요청
    const postAdd = async ()=>{
        // 2-1 : 입력받은 값들을 객체화
        const obj = { pcontent , ppwd }
        // 2-2 : axios 요청
        const response = await axios.post("http://localhost:8080/post",obj)
        console.log(response.data);
        postPrint();
        setPcontent('');
        setPpwd('');
    }

    // [3] 출력할 데이터들을 관리하는 useState
    const [ posts , setPosts ] = useState(
        [ {mtitle :"귀멸의칼날",pcontent:"칼날비",ppwd:"1324" } ]
    );
    // [4] 출력할 데이터들을 axios 이용하여 스프링에게 요청
    const postPrint = async(no) =>{
        const response = await axios.get(`http://localhost:8080/post?mno=${no}`)
        setPosts(response.data);
    }
    // [5] useEffect 이용한 최초 컴포넌트 실행시 출력함수 실행
    useEffect(()=>{postPrint()},[])

    // [6] 삭제함수 정의/만들기
    const postDelete = async (no,password)=>{ console.log(no); console.log(password);
        // 6-1 입력받은 비밀번호를 객체화  
        const inputPassword = prompt('비밀번호를 입력해주세요.')
        const obj = {ppwd:inputPassword}
        // 6-2 삭제할 게시물의 비밀번호와 일치하는지 확인
        if(inputPassword!=password)return alert('비밀번호가 다릅니다.')
        // 6-3 axios 이용하여 삭제할 번호와 비밀번호를 스프링 서버에게 보내서 요청한다. 백엔드 제거
        const response = await axios.delete(`http://localhost:8080/post?pno=${no}`,obj)
        // 6-4 삭제할 pno를 매개변수로 받아서 반복문을 이용하여 삭제할 pno를 제외한 새로운 리스트 생성, 프론트에서 제거
        const newPosts = posts.filter((e)=>{return e.pno != no;});
        setPosts([...newPosts]);
    }

    return(<>
      <textarea value={pcontent} onChange={(e)=>setPcontent(e.target.value)} placeholder="해당 영화에 대한 토론 글을 작성해주세요."/> <br/><br/>
      <input type="password" onChange={(e)=>setPpwd(e.target.value)}/><br/><br/>
    <button onClick={postAdd}>등록</button>


    <br/><br/> <h3>영화별 토론 글 목록</h3>
        {
            posts.map((e)=>{
                return <div key={e.pno}>
                    영화제목:{e.mtitle}<br/><br/>
                    토론 글:{e.pcontent}<br/><br/>
                    <br/><br/>
                    <button onClick={()=>{postDelete(e.pno,e.ppwd)}}>삭제</button> 
                </div>
            })
        }
        
    
    </>)
}