import { useDispatch, useSelector } from "react-redux"
import { minus, plus } from "../store/cartSlice";
import ButtonGroup from "@mui/material/ButtonGroup";
import Button from "@mui/material/Button";
import * as React from 'react';
import Avatar from '@mui/joy/Avatar';
import List from '@mui/joy/List';
import ListDivider from '@mui/joy/ListDivider';
import ListItem from '@mui/joy/ListItem';
import ListItemDecorator from '@mui/joy/ListItemDecorator';

export default function MenuPage(props){

    const { menu } = useSelector((state)=>state.count)
    console.log(menu);

    // [1] 액션(상태변경) 하기위한 dispatch 함수 가져오기
    const dispatch = useDispatch();
    // 담기 함수 정의 : axios 생략
    const onPlus = async (id) => {
        alert('담기 성공'); 
        dispatch(plus(id));console.log("아이디번호:"+id);
    }
    // 빼기 함수 정의 : axios 생략
    const onMinus = async (id) => {
        alert('빼기 성공');
        dispatch(minus(id));console.log("아이디번호:"+id);

    }
    
                                           
    return(<> 제품 페이지 
        { menu.map( (e) =>{
            return <div key={e.id}><ButtonGroup aria-label="outlined primary button group">
                <ul>
                    { e.cartcount >= 1 ?
                    <li>{e.name} : {e.price}원 <Button onClick={()=>{onPlus(e.id)}}> 담기 </Button><Button onClick={()=>{onMinus(e.id)}}>빼기</Button></li>
                    :<li>{e.name} : {e.price}원 <Button onClick={()=>{onPlus(e.id)}}> 담기 </Button></li>
                    }
                </ul>
                </ButtonGroup>
            </div>
            })
        }
    <List
      orientation="horizontal"
      variant="outlined"
      sx={{
        flexGrow: 0,
        mx: 'auto',
        '--ListItemDecorator-size': '48px',
        '--ListItem-paddingY': '1rem',
        borderRadius: 'sm',
      }}
    >
      <ListItem>
        <ListItemDecorator>
          <Avatar size="sm" src="/static/images/avatar/1.jpg" />
        </ListItemDecorator>
        Mabel Boyle
      </ListItem>
      <ListDivider inset="gutter" />
      <ListItem>
        <ListItemDecorator>
          <Avatar size="sm" src="/static/images/avatar/2.jpg" />
        </ListItemDecorator>
        Boyd Burt
      </ListItem>
      <ListDivider inset="gutter" />
      <ListItem>
        <ListItemDecorator>
          <Avatar size="sm" src="/static/images/avatar/3.jpg" />
        </ListItemDecorator>
        Adam Tris
      </ListItem>
    </List>
    </>)
    
}