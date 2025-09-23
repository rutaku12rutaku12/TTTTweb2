/*
    퍼시스턴스 : 로컬/세션 스토리지 에 상태 유지하는 방법
    설치 : npm i redux-persist
*/
import { configureStore } from "@reduxjs/toolkit";
import userSlice from './userSlice.jsx'

const store = configureStore({
    reducer: {
        user: userSlice
    }
})
export default store;
