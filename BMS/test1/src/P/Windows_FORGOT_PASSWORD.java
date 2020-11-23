package P;


import javax.swing.*;
import java.awt.*;

public class Windows_FORGOT_PASSWORD extends JFrame {

    private JLabel ab0, ab1, ab2, ab3, ab4;
    private JTextField tx1, tx2, tx3, tx4;
    private JButton bu1;
    public Windows_FORGOT_PASSWORD(){
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
        ab1.setBounds(120, 50, 200, 30);

        tx1 = new JTextField(15);
        tx1.setBounds(170, 50, 200, 30);

        //Uname string
        ab2 = new JLabel("名字: ");
        ab2.setBounds(120, 100, 200, 30);

        tx2 = new JTextField(15);
        tx2.setBounds(170, 100, 200, 30);

        //Uphone string
        ab3 = new JLabel("手机号: ");
        ab3.setBounds(120, 150, 200, 30);

        tx3 = new JTextField(15);
        tx3.setBounds(170, 150, 200, 30);

        //Upassword2 string
        ab4 = new JLabel("ID: ");
        ab4.setBounds(120, 200, 200, 30);

        tx4 = new JTextField(15);
        tx4.setBounds(170, 200, 200, 30);

        bu1 = new JButton("确认找回");
        bu1.setBounds(152, 250, 180, 40);
        bu1.setVisible(true);

        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);
        add(ab4);

        add(tx1);
        add(tx2);
        add(tx3);
        add(tx4);

        add(bu1);
    }
    public static void main(String[] args){

    }
}
