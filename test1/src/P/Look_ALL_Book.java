package P;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Look_ALL_Book extends JFrame {
    public Look_ALL_Book() {
        setTitle("查看所有图书");
        setSize(750, 600);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try {
            Connection conn = Conn.conn();
            Statement stmt = conn.createStatement();
            String sql = "select * from users";
            ResultSet rs = stmt.executeQuery(sql);

            Object[][] rowData = new Object[2200][6];

            int cnt = 0;
            int flag = 0;
            //System.out.println(c + c);
            while (rs.next()) {
                int id = rs.getInt("ID");
                //String Upassword1 = rs.getString("Upassword1");
                String Uname = rs.getString("Uname");
                int Uage = rs.getInt("Uage");
                String Usex = rs.getString("Usex");
                String Umarjor = rs.getString("Umarjor");
                String Uphone = rs.getString("Uphone");
                //String Upassword2 = rs.getString("Upassword2");
                rowData[cnt][0] = id;
                rowData[cnt][1] = Uname;
                rowData[cnt][2] = Uage;
                rowData[cnt][3] = Usex;
                rowData[cnt][4] = Umarjor;
                rowData[cnt][5] = Uphone;
                cnt++;//vector.add(b);
                //表头
                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ID", "名字", "年龄", "性别", "专业", "手机号"};

            //所有行数据

            JTable table = new JTable(rowData, columnNames);

            table.setRowHeight(40);
            table.getColumnModel().getColumn(0).setPreferredWidth(60);
            table.setPreferredScrollableViewportSize(new Dimension(700, 520));

            JScrollPane scrollPane = new JScrollPane(table);

            panel.add(scrollPane);
            add(panel);
            setContentPane(panel);
        }
        catch (SQLException x){

        }
        catch(ClassNotFoundException x){

        }
    }
    public static void main(String[] args){

    }
}
