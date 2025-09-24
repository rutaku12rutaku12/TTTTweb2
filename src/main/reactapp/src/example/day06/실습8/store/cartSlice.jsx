import { createSlice } from "@reduxjs/toolkit"

const menu = [
    { id: 1, name: "아메리카노", price: 3000 , cartcount:0 }, 
    { id: 2, name: "카페라떼", price: 4000 , cartcount:0 },
    { id: 3, name: "카푸치노", price: 4500 , cartcount:0 },
];
const initialState = { menu };


const cartSlice = createSlice({
    name : "count",
    initialState,
    reducers: {
        plus : ( state , action ) => { state.menu.forEach((i)=>{if(i.id == action.payload) i.cartcount+=1;})
         },
        minus : ( state , action ) => { state.menu.forEach((i)=>{if(i.id == action.payload) i.cartcount-=1;})
         }
    }
});

export default cartSlice.reducer;

export const { plus , minus } = cartSlice.actions;