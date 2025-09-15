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
  // 4-1 : 렌더링할 컴포넌트(함수) 가져오기
import App from './App.jsx'
  // 4-2 : 렌더링하기 
create.render( <App></App> );

// * 2 ~ 4-2 요약가능 , 즉]  createRoot( document.querySelector('#root') ).render( <최초출력할함수명 /> );
// createRoot( document.querySelector('#root') ).render( <App /> );

// ** 순수 JS 방식 **
// const root = document.querySelector('#root');
// const html = `안녕하세요`;
// root.innerHTML = html;
