package P;

import javax.swing.*;
import java.awt.*;

//Add_Book 类写的是窗口, 然后调用Book_Add添加图书

public class Add_Books extends JFrame{
    public Add_Books() {
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
