package P;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows_LoginIN extends JFrame {
    public Windows_LoginIN() {
        setTitle("LOGIN IN");
        setSize(180, 130);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();

        JTextField jt1 = new JTextField(10);
        jt1.setText("USER ID");
        jt1.scrollRectToVisible(new Rectangle(4,4));
        jt1.setScrollOffset(4);
        jt1.setHorizontalAlignment(JTextField.CENTER);

        JTextField jt2 = new JTextField(10);
        jt2.setText("PASSWORD");
        jt2.setHorizontalAlignment(JTextField.CENTER);

        jp.add(jt1);
        jp.add(jt2);

        JButton b1 = new JButton("登入");

        jp.add(b1);

        this.add(jp);

        JFrame aa1 = new JFrame();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = jt1.getText();
                //System.out.println(s1);

                String s2 = jt2.getText();
                System.out.println(s2);



                if(s2.equals("PASSWORD") && s1.equals("USER ID")) {
                    Windows_Login.frame.dispose();
                    dispose();
                    Windows_HomePage_User n = new Windows_HomePage_User();
                }
                else {
                    JLabel jb0 = new JLabel("           登录失败!");
                    jb0.setForeground(Color.red);
                    jb0.setFont(new Font("微软雅黑", Font.BOLD, 18));

                    aa1.add(jb0);
                    aa1.setVisible(true);
                    aa1.setResizable(false);
                    aa1.setSize( 200, 150);
                    aa1.setLocationRelativeTo(Windows_Login.frame);

                    System.out.println(s2);
                }

            }
        });

    }
    public static void main(String[] args){

    }
}
