package P;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Borrow_my extends JFrame {
    public Borrow_my(int ID) {
        setTitle("归还图书");
        setSize(500, 400);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Connection conn4 = Conn.conn();
            Statement stmt = conn4.createStatement();
            String sqlx = "select * from borrowing";
            ResultSet rs = stmt.executeQuery(sqlx);

            Object[][] rowData = new Object[2200][3];

            int cnt = 0;
            int flag = 0;
            //System.out.println(c + c);
            while (rs.next()) {
                int id = rs.getInt("ID");
                System.out.println(id);
                if(ID != id)
                    continue;
                String isbn = rs.getString("ISBN");
                Long btime = rs.getLong("BTime");
                rowData[cnt][0] = id;
                rowData[cnt][1] = isbn;
                rowData[cnt][2] = btime;
                cnt++;

                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ID", "ISBN", "结束时间"};

            //所有行数据

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
    public Borrow_my() {
        setTitle("归还图书");
        setSize(700, 500);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Connection conn5 = Conn.conn();
            Statement stmt = conn5.createStatement();
            String sql = "select * from borrowing";
            ResultSet rs = stmt.executeQuery(sql);

            Object[][] rowData = new Object[2200][3];

            int cnt = 0;
            int flag = 0;
            //System.out.println(c + c);
            while (rs.next()) {
                int id = rs.getInt("ID");
                System.out.println(id);
                String isbn = rs.getString("ISBN");
                int btime = rs.getInt("BTime");
                rowData[cnt][0] = id;
                rowData[cnt][1] = isbn;
                rowData[cnt][2] = btime;
                cnt++;

                //System.out.println(ISBN);
            }
            JPanel panel = new JPanel();

            String[] columnNames = {"ID", "ISBN", "结束时间"};

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
