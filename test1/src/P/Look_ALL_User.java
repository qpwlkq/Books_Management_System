package P;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Look_ALL_User extends JFrame {
    public Look_ALL_User() {
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
            String sql = "select * from book";
            ResultSet rs = stmt.executeQuery(sql);

            Object[][] rowData = new Object[2200][7];

            int cnt = 0;
            int flag = 0;
            //System.out.println(c + c);
            while (rs.next()) {
                String ISBN = rs.getString("ISBN");
                String Bname = rs.getString("Bname");
                int Bpublish = rs.getInt("Bpublish");
                String Bauthor = rs.getString("Bauthor");
                String Bpress = rs.getString("Bpress");
                int Bnumber = rs.getInt("Bnumber");
                String Kind = rs.getString("Kind");
                rowData[cnt][0] = ISBN;
                rowData[cnt][1] = Bname;
                rowData[cnt][2] = Bpublish;
                rowData[cnt][3] = Bauthor;
                rowData[cnt][4] = Bpress;
                rowData[cnt][5] = Bnumber;
                rowData[cnt][6] = Kind;
                cnt++;//vector.add(b);
                //表头
                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ISBN", "书名", "出版日期", "作者", "出版社", "数量", "种类"};

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
