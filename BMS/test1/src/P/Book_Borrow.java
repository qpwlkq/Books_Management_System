package P;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/*

select 语句选择出来
if 判断是否满足条件
update 修改
 */

public class Book_Borrow extends JFrame {

    public Book_Borrow() {
        /*
        String URL = "jdbc:mysql://127.0.0.1:3306/book?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String USER = "root";
        String PASSWORD = "072534";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

         */
        /*
        Connection conn = Conn.conn();

        System.out.println("数据库加载成功...");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from book");


        String sql = "update book set Bnumber=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, b.getBnumber());
        ps.setString(2, b.getBpress());


        //4.处理数据库的返回结果(使用ResultSet类)

        //while(rs.next()){
        //    System.out.println(rs.getString("Bname")+" "
        //            +rs.getString("Bauthor"));
        //}

        System.out.println("数据库关闭...");

        //关闭资源
        rs.close();
        st.close();
        conn.close();

         */
        setTitle("借书");
        setSize(280, 240);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab1, ab2, ab0;
        ab0 = new JLabel("借书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(110, 10, 200, 40);
    }
    public static void main(String[] args){

    }
}
