package P;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;


public class Conn {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/book?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="072534";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        System.out.println("数据库加载成功...");

        //增
        //String sql = "insert into books(书名)" + "values(' " + "')";

        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from book");

        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("Bname")+" "
                    +rs.getString("Bauthor"));
        }

        System.out.println("数据库关闭...");

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}

