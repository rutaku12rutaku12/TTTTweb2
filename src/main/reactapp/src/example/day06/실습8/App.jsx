import { BrowserRouter, Route, Routes } from "react-router-dom";
import Hedaer from "./components/Header";
import HomePage from "./pages/HomePage";
import MenuPage from "./pages/MenuPage";
import CartPage from "./pages/CartPage";

export default function App(props){
    return(<> 
            <BrowserRouter>
                <Hedaer></Hedaer>
                <Routes>
                    <Route path="/" element={<HomePage></HomePage>}></Route>
                    <Route path="/menu" element={<MenuPage/>}></Route>
                    <Route path="/cart" element={<CartPage/>}></Route>
                </Routes>
            </BrowserRouter>
    </>)
}