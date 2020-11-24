package P;

import java.awt.print.Book;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
insert 语句直接 添加
 */

public class Book_Add {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static final CallableStatement cs = null;

    /**
     * Insert方法封装
     * @param stu 传入参数
     */
    public static void Insert(Boook stu) throws SQLException, ClassNotFoundException {

        conn = Conn.conn();		//调用 DBconnection 类的 conn() 方法连接数据库

        String sql = "INSERT INTO Book (ISBN, Bname, Bpublish, Bauthor, Bpress, Bnumber, Kind) VALUES(?,?,?,?,?,?,?)";		//插入sql语句
        try {
            ps = conn.prepareStatement(sql);

            /**
             * 调用实体StuInfo类,获取需要插入的各个字段的值
             * 注意参数占位的位置
             * 通过set方法设置参数的位置
             * 通过get方法取参数的值
             */
            /*
            ISBN string;
            Bname string;
            Bpublish int;
            Bauthor string;
            Bpress string;
            Bnumber int;
            Kind string;
             */
            ps.setString(1, stu.getISBN());
            ps.setString(2, stu.getBname());
            ps.setInt(3, stu.getBpublish());
            ps.setString(4, stu.getBauthor());
            ps.setString(5, stu.getBpress());
            ps.setInt(6, stu.getBnumber());
            ps.setString(7, stu.getKind());

            ps.executeUpdate();			//执行sql语句

            System.out.println("插入成功(*￣︶￣)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conn.close();
        }
    }

}
