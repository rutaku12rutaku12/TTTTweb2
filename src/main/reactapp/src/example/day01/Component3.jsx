/*
    [web1] 백틱 템플릿 : 키보드 [tab]키 위에 `(백틱) 기호 이용한 문자열내 JS코드 연결방법
            예] let name = "유재석"
            `<div> ${ name } </div>`
    [web2] JSX 템플릿 : 리액트내 자동 포함 
            예] let name = "유재석"
            return <div> { name } </div>
*/

// [1] 컴포넌트/함수 선언
export default function Component3( props ){
    // -------------> JS 코드 START
    let name = "유재석"
    // <------------- JS 코드 END : return 전까지

    // -------------> JSX 코드 START : return 부터는 JSX 문법
    return ( <> 
        { /* 주석처리 */ }
    <div> {name} 입니다. </div>
    <div> {13+20}</div> 
    { /* 다른 컴포넌트 포함 하면서 속성(props)/자료 전달 
        속성명 : 이름       key         자료명
        속성값 : 유재석     value       자료값 */}
    <SubCom1 key1 = "value1" key2 = "40" />
    <SubCom1 key1 = "유재석" key2 = "60" />
    </> )

    // <------------- JSX 코드 END
} // func end

// [2] 컴포넌트/함수 선언2
function SubCom1( props ){
    const obj = { name : "강호동" , age : 50 }
    console.log( obj );
    // 2-1 : props 확인
    console.log( props );
    // 2-2 : props (배열/객체) 구조 분해 (쪼개기)
    const { key1 , key2 } = props;
    // vs const key1 = props.key1;    const key2 = props.key2;
    // <<--------------------- JSX 문법 --------------->>
    return (<>
        <h4>{obj.name} 님의 나이는 {obj.age} 입니다. </h4>
        <h4>{props.key1} 님의 나이는 {props.key2} 입니다. </h4>
        <h4>{key1} 님의 나이는 {key2} 입니다. </h4>
    </>)

} // func end