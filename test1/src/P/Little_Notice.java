package P;

import javax.swing.*;
import java.awt.*;

public class Little_Notice {
    public static void puts(String sx) {
        JFrame jf = new JFrame();
        jf.setSize(350, 200);
        //setLocationRelativeTo(Windows_Login.frame);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab0;
        ab0 = new JLabel(sx);
        //ab0.setForeground(Color.red);
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 15));
        ab0.setBounds(5, 30, 300, 40);
        jf.add(ab0);
    }
}
