package P;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.nio.channels.ClosedSelectorException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Windows_LoginIN extends JFrame {
    public Windows_LoginIN() {
        setTitle("LOGIN IN");
        setSize(280, 240);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab1, ab2, ab0;
        ab0 = new JLabel("登入");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(110, 10, 200, 40);

        ab1 = new JLabel("User ID: ");
        ab1.setBounds(40, 60, 100, 30);

        ab2 = new JLabel("Password: ");
        ab2.setBounds(40, 100, 100, 30);

        JTextField jt1 = new JTextField(10);
        jt1.setText("12345");
        jt1.setBounds(110, 60, 100, 30);

        JTextField jt2 = new JTextField(10);
        jt2.setText("qinpeng");
        jt2.setBounds(110, 100, 100, 30);

        add(ab0);
        add(ab1);
        add(ab2);
        add(jt1);
        add(jt2);

        JButton b1 = new JButton("登入");
        b1.setBounds(90, 150, 100, 40);
        add(b1);

        JFrame aa1 = new JFrame();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = jt1.getText();
                //System.out.println(s1);
                int c = Integer.parseInt(s1);

                String s2 = jt2.getText();
                System.out.println(s2);

                try{
                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select * from users";
                    ResultSet rs = stmt.executeQuery(sql);

                    int flag = 0;

                    while(rs.next()){
                        int a = rs.getInt("ID");
                        String b = rs.getString("Upassword1");
                        String d = rs.getString("Upassword2");
                        if(a == c){
                            if(s2.equals(b) || s2.equals(d)){
                                if(a == 11111){
                                    //管理员
                                    flag = 1;
                                    Windows_Login.frame.dispose();
                                    dispose();
                                    Windows_HomePage_Admin n = new Windows_HomePage_Admin(a);
                                }
                                else{
                                    flag = 1;
                                    Windows_Login.frame.dispose();
                                    dispose();
                                    Windows_HomePage_User n = new Windows_HomePage_User(a);
                                }
                            }
                            break;
                        }
                    }
                    if(flag == 0){
                        //登录失败
                        JLabel jb0 = new JLabel("用户不存在或密码错误!");
                        jb0.setForeground(Color.red);
                        jb0.setFont(new Font("微软雅黑", Font.BOLD, 18));

                        aa1.add(jb0);
                        aa1.setVisible(true);
                        aa1.setResizable(false);
                        aa1.setSize( 200, 150);
                        aa1.setLocationRelativeTo(Windows_Login.frame);

                        System.out.println(s2);
                    }

                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException x){

                }catch(ClassNotFoundException x){

                }finally {

                }
            }
        });

    }
    public static void main(String[] args){

    }
}
