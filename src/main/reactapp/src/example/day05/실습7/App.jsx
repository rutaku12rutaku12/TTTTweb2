import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import ProfilePage from "./pages/ProfilePage";
import Header from "./components/Header";

export default function App(props){
    return(<>
        <BrowserRouter>
        <Header></Header>
            <h3> 루트 페이지 </h3>
            
            <Routes>
                <Route path="/" element={<HomePage></HomePage>} />
                <Route path="/login" element={<LoginPage></LoginPage>} />
                <Route path="/profile" element={<ProfilePage></ProfilePage>} />
            </Routes>
        </BrowserRouter>
    </>)
}