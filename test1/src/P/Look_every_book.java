package P;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Look_every_book extends JFrame {
    public Look_every_book() {
        setTitle("查看每本书借阅情况");
        setSize(750, 600);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try {
            Connection conn6 = Conn.conn();
            Statement stmt = conn6.createStatement();
            String sql = "select * from everybook";
            ResultSet rs3 = stmt.executeQuery(sql);

            Object[][] rowData = new Object[5200][5];

            int cnt = 0;
            int flag = 0;
            //System.out.println(c + c);
            while (rs3.next()) {
                String ISBN = rs3.getString("ISBN");
                //System.out.println(ISBN);
                String Bname = rs3.getString("Bname");
                int Bnumber = rs3.getInt("Bnumber");
                int BID = rs3.getInt("BID");
                int ZT = rs3.getInt("ZT");
                //System.out.println(BID);
                rowData[cnt][0] = ISBN;
                rowData[cnt][1] = Bname;
                rowData[cnt][2] = Bnumber;
                rowData[cnt][3] = BID;
                if(ZT == 1)
                    rowData[cnt][4] = "未借出";
                else
                    rowData[cnt][4] = "已借出";
                cnt++;
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ISBN", "书名", "总数", "图书编号", "借阅状态"};

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
