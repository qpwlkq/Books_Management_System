package P;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Windows_Forgot_Password extends JFrame {

    private JLabel ab0, ab1, ab2, ab3, ab4;
    private JTextField tx1, tx2, tx3, tx4;
    private JButton bu1;
    public Windows_Forgot_Password(){
        setTitle("找回密码");
        setSize(500, 380);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        //setLocation(200, 200);
        setLayout(null);


        ab0 = new JLabel("找回密码");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(180, 0, 300, 40);

        //ID Int > 10000 & < 99999
        ab1 = new JLabel("ID: ");
        ab1.setBounds(120, 70, 200, 30);

        tx1 = new JTextField(15);
        tx1.setBounds(170, 70, 200, 30);

        //Uname string
        ab2 = new JLabel("名字: ");
        ab2.setBounds(120, 120, 200, 30);

        tx2 = new JTextField(15);
        tx2.setBounds(170, 120, 200, 30);

        //Uphone string
        ab3 = new JLabel("手机号: ");
        ab3.setBounds(120, 170, 200, 30);

        tx3 = new JTextField(15);
        tx3.setBounds(170, 170, 200, 30);

        //Upassword2 string

        bu1 = new JButton("确认找回");
        bu1.setBounds(150, 260, 200, 40);

        bu1.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(tx1.getText());
                System.out.println(ID);
                String Uname = tx2.getText();
                String Uphone = tx3.getText();
                try{

                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select * from users";
                    ResultSet rs = stmt.executeQuery(sql);


                    while(rs.next()){
                        int id = rs.getInt("ID");
                        String uname = rs.getString("Uname");
                        String uphone = rs.getString("Uphone");

                        System.out.println(uname + uphone + id);
                        if(uname.equals(Uname) && id == ID && uphone.equals(Uphone)){
                            System.out.println(1);
                            String ps = rs.getString("Upassword1");
                            String ps2 = rs.getString("Upassword2");
                            JFrame jf = new JFrame();
                            jf.setVisible(true);
                            jf.setSize(300, 200);

                            JLabel jl = new JLabel("密码/二重密码:");
                            jl.setBounds(20,30,200,30);

                            JTextField jt = new JTextField("勿忘: " + ps + "/" + ps2);
                            jt.setBounds(50,60,200,30);

                            jf.add(jl);
                            jf.add(jt);
                        }
                    }

                }catch(SQLException x){

                }catch(ClassNotFoundException x){

                }
            }
        });

        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);

        add(tx1);
        add(tx2);
        add(tx3);

        add(bu1);
    }
    public static void main(String[] args){

    }
}
