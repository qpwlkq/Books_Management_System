package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//update book number - 1 && insert borrow id, ISBN

public class Book_Borrow extends JFrame {
    public Book_Borrow(int id) {
        setTitle("借书");
        setSize(400, 260);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab0, ab1, ab2, ab3;
        JTextField jx1, jx2, jx3, jx4;

        ab0 = new JLabel("借书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(170, 10, 200, 40);

        ab1 = new JLabel("ISBN:");
        ab1.setBounds(50, 70, 200, 30);

        jx1 = new JTextField();
        jx1.setBounds(110,70,200,30);

        JButton jb = new JButton("借书");
        jb.setBounds(125, 130, 150, 40);

        add(ab0);
        add(ab1);
        add(jx1);
        add(jb);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String str = jx1.getText();

                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select ISBN, Bnumber from book";
                    ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next()){
                        if(rs.getString("ISBN").equals(str)) {
                            int bnumber = rs.getInt("Bnumber");
                            if(bnumber <= 0){
                                //此书库存为 0 !
                                Little_Notice.puts("此书库存为0!");
                            }
                            else{
                                //借书成功, 请规定时间内归还
                                Little_Notice.puts("借书成功! 请在规定时间内归还!");
                                String sql2 = "UPDATE book set Bnumber = ? where ISBN = ?";
                                try {
                                    Connection conn2 = Conn.conn();
                                    PreparedStatement ps = conn2.prepareStatement(sql2);
                                    ps.setInt(1, bnumber - 1);
                                    ps.setString(2, str);
                                    ps.executeUpdate();
                                    //conn2.close();
                                }
                                catch(SQLException x){

                                }
                                try {
                                    String sql3 = "INSERT INTO borrowing (ID, ISBN, BTime) VALUES(?,?,?)";
                                    Connection conn3 = Conn.conn();
                                    PreparedStatement ps2 = conn3.prepareStatement(sql3);

                                    String isbn = str;
                                    long bt = System.currentTimeMillis();
                                    ps2.setInt(1, id);
                                    ps2.setString(2, isbn);
                                    ps2.setLong(3, bt);
                                    ps2.executeUpdate();
                                }
                                catch(SQLException x){

                                }
                            }
                        }
                    }
                }
                catch(SQLException x){

                }
                catch(ClassNotFoundException x){

                }
            }
        });
    }
    public static void main(String[] args){

    }
}
