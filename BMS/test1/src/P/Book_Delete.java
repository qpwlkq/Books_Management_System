package P;

/*
不直接将记录删除,
update 将书数量改为0
 */

import javax.swing.*;
import java.awt.*;

public class Book_Delete extends JFrame{
    public Book_Delete() {
        setTitle("删除图书");
        setSize(280, 240);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab1, ab2, ab0;
        ab0 = new JLabel("删除图书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(110, 10, 200, 40);
    }
    public static void main(String[] args){

    }
}
