// import { StrictMode } from 'react'
// import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.jsx'

// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

// ** main.jsx 에서 index.html의 id='root' 마크업에 최초의 컴포넌트(화면함수) 렌더링하는곳 **
// 1. 리액트 라이브러리 의 createRoot 함수 import 한다.
import { createRoot  } from 'react-dom/client'

// 2. index.html(SPA) 에서 root 마크업 가져오기 
const root = document.querySelector('#root');

// 3. 가져온 root 마크업을 createRoot 함수의 매개변수로 전달한다.
const create = createRoot( root ); 

// 4. root에 렌더링할 컴포넌트(화면함수) 
//   4-1 : 렌더링할 컴포넌트(함수) 가져오기
// import App from './App.jsx'
//   // 4-2 : 렌더링하기 
// create.render( <App></App> );

// day01
import Component1 from './example/day01/Component1.jsx';
// // create.render( <Component1/> </Component1> )
// create.render( <Component1 /> )

import Component2 from './example/day01/Component2.jsx';
// create.render( <Component2 />)

import Component3 from './example/day01/Component3.jsx';
// create.render( < Component3 /> )

import Task1 from './example/day01/Task1.jsx';
// create.render( <Task1 /> )
import Task2 from './example/day01/Task2.jsx';
// create.render( <Task2 /> )
import Component4 from './example/day02/Component4.jsx';
// create.render( <Component4/> )
import Component5 from './example/day02/Component5.jsx';
// create.render(<Component5></Component5>)
import Component6 from './example/day02/Component6.jsx';
// create.render(<Component6></Component6>)
import Component7 from './example/day02/Component7.jsx';
// create.render(<Component7/>)
import Task3 from './example/day02/Task3.jsx';
// create.render(<Task3></Task3>)
import Task4 from './example/day02/Task4.jsx';
// create.render(<Task4></Task4>)
import Component8 from './example/day03/Component8.jsx';
// create.render(<Component8></Component8>)
import Copmonent9 from './example/day03/Component9.jsx';
// create.render(<Copmonent9></Copmonent9>)
import Component10 from './example/day03/Component10.jsx';
// create.render(<Component10/>)
import Task5 from './example/day03/Task5.jsx';
// create.render(<Task5></Task5>)
import Movie from './example/day04/Movie.jsx';
create.render(<Movie></Movie>)


// import Aa2 from './example/day02/a0.jsx';
// create.render(<Aa2></Aa2>)

// * 2 ~ 4-2 요약가능 , 즉]  createRoot( document.querySelector('#root') ).render( <최초출력할함수명 /> );
// createRoot( document.querySelector('#root') ).render( <App /> );

// ** 순수 JS 방식 **
// const root = document.querySelector('#root');
// const html = `안녕하세요`;
// root.innerHTML = html;
