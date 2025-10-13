/**
 *  슬라이스 : 상태(state) , 리듀서(reducer) , 액션(action) 정의하는 곳
 *  createSlice
 */
import {createSlice} from '@reduxjs/toolkit'
// [1] 상태의 초기값 정의 , 로그인여부
const initialState = {isAuthenticated : false , userInfo : null}
// [2] 슬라이스 정의
const userSlice = createSlice({
    name: "user" , // 슬라이스 상태명
    initialState ,
    reducers: { // 여러개의 상태변경함수 정의한곳 
        login : (state , action) =>{state.isAuthenticated=true;
            state.userInfo = action.payload;
        },
        logout : (state) =>{state.isAuthenticated=false;
            state.userInfo=null;
        }

    }
})

// [3] store에 저장할수 있게 export 해주기
export default userSlice.reducer // 현쟂 ㅓㅇ의한 리듀서(reducers)들을 store 등록 예정
// [4] 다른 컴포넌트에서 액션이 가능하도록 login,logout export 해주기
export const{ login,logout} =userSlice.actions

