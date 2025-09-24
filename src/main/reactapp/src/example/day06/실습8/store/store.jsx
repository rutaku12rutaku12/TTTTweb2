import { configureStore } from "@reduxjs/toolkit";
import cartSlice from './cartSlice.jsx'

import storage from 'redux-persist/lib/storage';
const persistConfig = { key : 'cartcount' , storage }

import { persistStore, persistReducer } from 'redux-persist';
const persistedReducer = persistRedcuer( persistConfig, cartSlice);


// [1] 스토어 만들기
const store = configureStore({
    reducer : {
        count : persistReducer
    }
});

export default store;

export const persistor = persistStore( store );