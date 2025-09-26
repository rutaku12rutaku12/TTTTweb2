import * as React from 'react';
import Table from '@mui/joy/Table';

import { useSelector } from "react-redux"

export default function CartPage(props){
    const { menu } = useSelector( (state) =>state.count )

    return(<> 
    <Table borderAxis="both">
      <caption>총 장바구니 목록</caption>
      <thead>
        <tr>
          <th style={{ width: '20%' }}>제품명</th>
          <th>수량</th>
          <th>가격</th>
        </tr>
      </thead>
      <tbody>
        {menu.map((e) => (
          <tr key={e.id}>
            <td>{e.name}</td>
            <td>{e.cartcount}</td>
            <td>{e.price}</td>
          </tr>
        ))}
      </tbody>
      <tfoot>
        <tr>
          <th scope="row">총 금액</th>
          <td></td>
          <td>{}</td>
        </tr>
      </tfoot>
    </Table>
    </>)
}
