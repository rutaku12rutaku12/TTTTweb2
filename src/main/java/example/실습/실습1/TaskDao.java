package example.실습.실습1;

import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDao extends Dao {


    public void method1(int qty){
        try{// 1. SQL 작성
            String sql = "update products set stock_quantity = stock_quantity + ? ";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,(qty));
            // 4. SQL 실행
            ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
        }catch (Exception e){System.out.println(e);}

    }
    public void method2(){
        List <Map<String,String>> list = new ArrayList<>();
        try{// 1. SQL 작성
            String sql = "select * from products";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while ( rs.next() ){
                Map<String , String> map = new HashMap<>();
                map.put("product_id", rs.getString("product_id"));
                map.put("product_name", rs.getString("product_name"));
                map.put("stock_quantity", rs.getString("stock_quantity"));
                list.add(map);
                System.out.println(map);
            }
        }catch (Exception e){System.out.println(e);}
    }

    public void method3(){
        try{// 1. SQL 작성
            String sql = "update products set stock_quantity = stock_quantity + 20 where stock_quantity <= 10";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
        }catch (Exception e){System.out.println(e);}

    }
}
