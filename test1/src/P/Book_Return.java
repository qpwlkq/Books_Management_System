package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//update book number + 1 && insert borrow id, ISBN

public class Book_Return extends JFrame {
    public Book_Return(int ID) {
        setTitle("还书");
        setSize(400, 260);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab0, ab1, ab2, ab3;
        JTextField jx1, jx2, jx3, jx4;

        ab0 = new JLabel("还书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(170, 10, 200, 40);

        ab1 = new JLabel("ISBN:");
        ab1.setBounds(50, 70, 200, 30);

        jx1 = new JTextField();
        jx1.setBounds(110,70,200,30);

        ab2 = new JLabel("图书ID:");
        ab2.setBounds(50, 120, 200, 30);

        jx2 = new JTextField();
        jx2.setBounds(110,120,200,30);

        JButton jb = new JButton("确认");
        jb.setBounds(100, 170, 200, 40);

        add(ab0);
        add(ab1);
        add(jx1);
        add(ab2);
        add(jx2);
        add(jb);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String str = jx1.getText();
                    int bid = Integer.parseInt(jx2.getText());


                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select * from everybook";
                    ResultSet rs = stmt.executeQuery(sql);



                    while(rs.next()){
                        if(bid == rs.getInt("BID")) {
                            int bnumber = rs.getInt("Bnumber");
                                //借书成功, 请规定时间内归还
                            Little_Notice.puts("还书成功!有借有还,再借不难!");
                            String sql2 = "UPDATE everybook set ZT = ? where BID = ?";
                            try {
                                Connection conn2 = Conn.conn();
                                PreparedStatement ps = conn2.prepareStatement(sql2);
                                ps.setInt(1, 1);
                                ps.setInt(2, bid);
                                ps.executeUpdate();
                            }
                            catch(SQLException x){

                            }
                            try {
                                String sql3 = "DELETE from borrowing where ID = ? AND BID = ?";
                                Connection conn3 = Conn.conn();
                                PreparedStatement ps2 = conn3.prepareStatement(sql3);
                                String isbn = str;

                                ps2.setInt(1, ID);
                                ps2.setInt(2, bid);
                                ps2.executeUpdate();

                            }
                            catch(SQLException x){

                            }
                            break;
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
