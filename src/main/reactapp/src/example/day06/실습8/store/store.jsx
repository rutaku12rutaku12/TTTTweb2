import { configureStore } from "@reduxjs/toolkit";
import countReducer from './cartSlice.jsx'

const store = configureStore({
    reducer : {
        count : countReducer
    }
});

export default store;