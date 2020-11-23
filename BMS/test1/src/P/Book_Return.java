package P;

import javax.swing.*;
import java.awt.*;

public class Book_Return extends JFrame {
    public Book_Return() {
        setTitle("归还图书");
        setSize(280, 240);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab1, ab2, ab0;
        ab0 = new JLabel("归还图书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(110, 10, 200, 40);
    }
    public static void main(String[] args){

    }
}
