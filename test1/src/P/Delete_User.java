package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Delete_User extends JFrame {
    public Delete_User() {
        setTitle("删除用户");
        setSize(400, 300);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab0, ab1, ab2, ab3;
        JTextField jx1, jx2, jx3, jx4;

        ab0 = new JLabel("删除用户");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(140, 10, 200, 40);

        ab1 = new JLabel("ID:");
        ab1.setBounds(50, 70, 200, 30);

        jx1 = new JTextField();
        jx1.setBounds(110,70,200,30);

        JButton jb = new JButton("确认");
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
                    int ID = Integer.parseInt(str);

                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select * from borrowing";
                    ResultSet rs = stmt.executeQuery(sql);

                    int flag = 0;
                    while(rs.next()){
                        if(rs.getString("ID").equals(str)) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        Little_Notice.puts("该用户有书未还, 无法删除!");
                    }
                    else{
                        Little_Notice.puts("删除成功!");
                        String sql3 = "DELETE from users where ID = ?";
                        Connection conn3 = Conn.conn();
                        PreparedStatement ps2 = conn3.prepareStatement(sql3);

                        ps2.setInt(1, ID);
                        ps2.executeUpdate();
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
