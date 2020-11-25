package P;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Look_borrowed extends JFrame {
    public Look_borrowed() {
        setTitle("所有借阅");
        setSize(600, 500);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Connection conn5 = Conn.conn();
            Statement stmt = conn5.createStatement();
            String sql = "select * from borrowed";
            ResultSet rs = stmt.executeQuery(sql);

            Object[][] rowData = new Object[8200][4];

            int cnt = 0;
            int flag = 0;

            SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
            sdf.applyPattern("yyyy年MM月dd日");

            //System.out.println(c + c);
            while (rs.next()) {
                int id = rs.getInt("ID");
                System.out.println(id);
                String isbn = rs.getString("ISBN");
                long btime = rs.getLong("Bdate");
                int bid = rs.getInt("BID");

                rowData[cnt][0] = id;
                rowData[cnt][1] = isbn;
                rowData[cnt][2] = bid;
                rowData[cnt][3] = sdf.format(btime);
                cnt++;

                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ID", "ISBN", "图书编号", "归还日期"};

            JTable table = new JTable(rowData, columnNames);

            table.setRowHeight(40);
            table.getColumnModel().getColumn(0).setPreferredWidth(60);
            table.setPreferredScrollableViewportSize(new Dimension(400, 300));

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
    public Look_borrowed(int ID) {
        setTitle("我的历史借阅");
        setSize(600, 500);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Connection conn5 = Conn.conn();
            Statement stmt = conn5.createStatement();
            String sql = "select * from borrowed";
            ResultSet rs = stmt.executeQuery(sql);

            Object[][] rowData = new Object[8200][4];

            int cnt = 0;
            int flag = 0;

            SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
            sdf.applyPattern("yyyy年MM月dd日");

            //System.out.println(c + c);
            while (rs.next()) {
                int id = rs.getInt("ID");
                //System.out.println(id);
                if(id != ID)
                    continue;
                String isbn = rs.getString("ISBN");
                long btime = rs.getLong("Bdate");
                int bid = rs.getInt("BID");

                rowData[cnt][0] = id;
                rowData[cnt][1] = isbn;
                rowData[cnt][2] = bid;
                rowData[cnt][3] = sdf.format(btime);
                cnt++;

                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ID", "ISBN", "图书编号", "归还日期"};

            JTable table = new JTable(rowData, columnNames);

            table.setRowHeight(40);
            table.getColumnModel().getColumn(0).setPreferredWidth(60);
            table.setPreferredScrollableViewportSize(new Dimension(400, 300));

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
