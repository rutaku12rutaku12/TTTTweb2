import { useSelector } from "react-redux"

export default function CartPage(props){
    const { cartcount } = useSelector( (state) =>state.count )

    return(<> 장바구니 페이지 <br/><br/>
    
    제품명 : {menuInfo} <br/>
    수량 : {cartcount}  <br/><br/>

    총 합계 : {cartcount}

    </>)
}