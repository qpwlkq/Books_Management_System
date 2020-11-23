package P;

import java.sql.*;

public class Create_Account_Students {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static final CallableStatement cs = null;

    /**
     * Insert方法封装
     * @param stu 传入参数
     */
    public static void Insert(User stu) throws SQLException, ClassNotFoundException {

        conn = Conn.conn();
        String sql = "INSERT INTO users (ID, Upassword1, Uname, Uage, Usex, Umarjor, Uphone, Upassword2) VALUES(?,?,?,?,?,?,?,?)";		//插入sql语句
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, stu.getID());
            ps.setString(2, stu.getUpassword1());
            ps.setString(3, stu.getUname());
            ps.setInt(4, stu.getUage());
            ps.setString(5, stu.getUsex());
            ps.setString(6, stu.getUmarjor());
            ps.setString(7, stu.getUphone());
            ps.setString(8, stu.getUpassword2());

            ps.executeUpdate();			//执行sql语句

            System.out.println("注册成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conn.close();
        }
    }

}
