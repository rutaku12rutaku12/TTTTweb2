import { useSelector } from "react-redux"

export default function CartPage(props){
    const { menu } = useSelector( (state) =>state.count )

    return(<> 장바구니 페이지 <br/><br/>
    {
        menu.map((e)=>{
            return <div key={e.id}>
                        제품명 : {e.name} <br/>
                        수량 : {e.cartcount}  <br/><br/>

                        총 합계 : {(e.price)*(e.cartcount)}원<br/><br/>
                    </div>
        }
        )
        
    }
    </>)
}