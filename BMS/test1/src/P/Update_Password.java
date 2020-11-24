package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update_Password extends JFrame {
    public Update_Password() {
        setTitle("更改密码");
        setSize(400, 400);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab3, ab1, ab2, ab0, ab4;
        ab0 = new JLabel("更改密码");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(130, 10, 200, 40);

        ab1 = new JLabel("ID: ");
        ab1.setBounds(40,60,200,30);

        ab2 = new JLabel("旧密码(二级): ");
        ab2.setBounds(40,110,200,30);

        ab3 = new JLabel("新密码");
        ab3.setBounds(40, 160, 200,30);

        ab4 = new JLabel("新二级密码");
        ab4.setBounds(40, 210, 200,30);

        JTextField jx1, jx2, jx3, jx4;
        jx1 = new JTextField();
        jx1.setBounds(120,60,200,30);

        jx2 = new JTextField();
        jx2.setBounds(120,110,200,30);

        jx3 = new JTextField();
        jx3.setBounds(120,160,200,30);

        jx4 = new JTextField();
        jx4.setBounds(120,210,200,30);


        JButton b1 = new JButton("确认修改");
        b1.setBounds(105, 280, 200, 40);


        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);
        add(ab4);

        add(jx1);
        add(jx2);
        add(jx3);
        add(jx4);
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(jx1.getText());
                    String b = jx2.getText();
                    String c = jx3.getText();
                    String d = jx4.getText();

                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select ID, Upassword1, Upassword2 from users";
                    ResultSet rs = stmt.executeQuery(sql);

                    int flag = 1;
                    while(rs.next()){
                        int id = rs.getInt("ID");
                        String ps1 = rs.getString("Upassword1");
                        String ps2 = rs.getString("Upassword2");
                        if(id == a && (ps1.equals(b) || ps2.equals(b))){
                            flag = 0;
                            String sql2 = "UPDATE users set Upassword1 = ?, Upassword2 = ? where id = ?";
                            try {
                                /*
                                User us = new User();
                                us.setID(id);
                                us.setUpassword1(c);
                                us.setUpassword2(d);
                                 */

                                Connection conn2 = Conn.conn();
                                PreparedStatement ps = conn2.prepareStatement(sql2);
                                ps.setString(1, c);
                                ps.setString(2, d);
                                ps.setInt(3, a);
                                ps.executeUpdate();
                            }
                            catch(SQLException x){

                            }
                        }
                    }
                    if(flag == 1){
                        //没找到
                        JFrame jf = new JFrame("失败");
                        jf.setSize(200,150);
                        jf.setVisible(true);
                        jf.setLocationRelativeTo(Windows_Login.frame);

                        JLabel jl = new JLabel("修改失败!请检查密码是否输入正确");
                        jf.add(jl);
                    }
                    else{
                        JFrame jf = new JFrame("失败");
                        jf.setSize(200,150);
                        jf.setVisible(true);
                        jf.setLocationRelativeTo(Windows_Login.frame);
                        JLabel jl = new JLabel("修改成功!");
                        jf.add(jl);
                    }
                }
                catch (SQLException x){

                }
                catch(ClassNotFoundException x){

                }
            }
        });
    }
    public static void main(String[] args){

    }
}
