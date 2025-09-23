import { createSlice } from "@reduxjs/toolkit"

const initialState = { cartcount : 0 , menuInfo : null }

const menuInfo = [
    { id: 1, name: "아메리카노", price: 3000 }, 
    { id: 2, name: "카페라떼", price: 4000 },
    { id: 3, name: "카푸치노", price: 4500 },
];

const cartSlice = createSlice({
    name : "count",
    initialState,
    reducers: {
        plus : ( state , action ) => { state.cartcount = state.cartcount+1;
            state.menuInfo=action.payload;
         },
        minus : ( state , action ) => { state.cartcount = state.cartcount-1;
            state.menuInfo=action.payload;
         }
    }
});

export default cartSlice.reducer;

export const { plus , minus } = cartSlice.actions;