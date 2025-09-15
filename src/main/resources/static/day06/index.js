
console.log('index.js open')

// [1] 변수 와 사웃 키워드
let count = 10;     // 변수의 선언과 초기화 
count = 20;         // 변수값 수정

const count2 = 20;  // 상수의 선언과 초기화 
// count2 = 20;     // 상수값 수정 불가능

// 변수/상수 에는 객체/함수/배열 를 담기 가능
const obj = { name : "유재석" };
const method = () => {}
const arr = [ "유재석" , "강호동" ]

// * var 키워드 : let 키워드 없었던 시절에 사용된 키워드
var count3 = 30;
var count3 = 40; // var 키워드는 중복 변수명을 허용한다. 식별이 어렵다.

// [2] 백틱 : 문자열 템플릿 , 문자열내 JS표현식을 연결할때 사용한다. JSX
console.log( `Hello : ${ count } `);
let html = ``;
html += `<div> Hello : ${count2} <div>`
console.log( html );

// [3-1] 조건문1 : IF
const point = 85;
if( point >= 90 ){ console.log( "A학점"); }
else if( point >= 80){console.log("B학점"); }
else{ console.log("C학점"); }

// [3-2] 조건문2 : 삼항연산자 , 조건 ? 참 : 거짓 , 간단한조건 에서 주로 사용됨
console.log( point >= 90 ? "A학점" : point >=80 ? "B학점" : "C학점");

// [3-3] 조건문3 : 단축평가 , 조건 && 참이면 결과 , 조건 || 거짓이면결과
console.log( point >= 90 && "A학점" ); // 만약에 참이면 "A학점" 아니면 false 
console.log( point >= 90 || "A학점" ); // 만약에 참이면 true 아니면 "A학점"

const array = [ 10 , 20 , 30 , 40 ,50 ]
// [4] 반복문1 : 
for( let index = 0 ; index < array.length ; index++ ){ console.log( array[index] ) };
for( let index in array ){ console.log( array[index] ) }
for( let value of array ){ console.log( value ) }

// forEach
array.forEach( (value)  => { console.log(value); } )
// ** map ** : forEach 다르게 retrun 가능하다.
let newArray = array.map( (value) => { console.log( value ); return value; } )
// ** filter ** : 조건부 return 가능하다. 
let newArray2 = array.filter( (value) => { console.log( value ); return value > 20; } )

// [5] 함수 : 
function fun1( param1 , param2 ) { } // 선언적 함수 선언
const fun2 = function( param1 , param2 ) { } // 익명 함수 선언
const fun3 = ( param1 , param2 ) => {} // 화살표(람다) 함수 선언
const fun4 = ( param1 , param2 = "강호동" ) => { } // 매개변수의 기본값

fun1( 4 , 10 ) // 함수 호출
fun2( 10 , "유재석" ); // 함수 호출
fun3( 10 , { name : "유재석"} ); // 함수 호출
fun4( 10 ); 

// [6] 객체 : 여러개의 값을 가진 (하나의) 값 , (1개)가방
// 변수/상수 는 값을 저장하는 상징적인 이름
const obj1 = { name : "유재석" , age : 40 }
const name2 = "강호동";
const age2 = 50;
const obj2 = { name2 , age2 }; // key 와 value의 변수명이 같으면 key 생략가능
const obj3 = [ "유재석" , 40 ]
console.log( obj1.name )
console.log( obj3[0] );
// *** 스프레드 연산자 : ... 배열이나 객체를 복사 할때 사용 , 왜? 주소값 변경 목적
const obj4 = { ...obj1 , phone : "010"}; console.log( obj4 );
const obj5 = [ ...obj3 ]; console.log( obj5 ); // 값의 차이가 없지만 새로운 주소값으로 복사 
const obj6 = [ ...obj3 , 6 , 7 ]; console.log( obj6 );

// [7] 구조 분해 할당 : 객체나 배열에서 값을 분해 하는 방법
const user = { name : "유재석" , age : 40 }
const { name , age } = user;    // 객체내 key(속성명) 과 동일하게 상수/변수를 선언하면 분해 가능하다.
console.log( name ); console.log( user.name );
console.log( age );

// [8] 비구조화 할당 과 나머지 연산자
const [ num , ...intArray ] = [ 1 ,2 , 3, 4]
console.log(num); // 순서대로(인덱스) 분해후 나머지는 ...에 저장한다.
console.log( intArray ); 

// [9] async/await 동기화
    // 1. 비동기 ,fetch , fetch 함수는 원래 비동기 래퍼( new promise ) 이다.
const method1 = ( ) => {
    fetch( "url" ).then( response => response.json() ).then( data => console.log( data ) );
}
    // 2. 동기 ,fetch
const method2 = async () => {
    const response = await fetch( "url" );
    const data = await response.json();
    console.log( data );
}

    // ********** Promise : await은 promise 를 사용하는 함수들에 적용된다. ***********
const promiseFunc = async ( ) => {
    return await new Promise ( ( resolve , reject ) => { // resolve : 성공매개변수 , reject : 실패매개변수
        if( 10 > 13 ){ resolve(" 10이 13보다 크다");}
        else{ reject(" 10이 13보다 작다. "); }
    } )
}































































