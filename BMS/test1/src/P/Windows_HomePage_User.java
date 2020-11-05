package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Windows_HomePage_User extends JFrame {
    private JLabel ab1, ab2, ab3, ab4, ab0;
    private JTextField test1, test2, test3, test4;
    private JButton bu1, bu2, bu3, bu4, bu5, bu6, bu7;
    int cout;
    Windows_HomePage_User() {
        setTitle("LOGIN UP");
        setSize(500, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLayout(null);

        ab0 = new JLabel("注册");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(230, 0, 300, 40);

        ab1 = new JLabel("ID: ");
        ab1.setBounds(110, 50, 200, 30);

        test1 = new JTextField(15);
        test1.setBounds(160, 50, 100, 30);

        ab2 = new JLabel("姓名: ");
        ab2.setBounds(110, 100, 200, 30);

        test2 = new JTextField(25);
        test2.setBounds(160, 100, 200, 30);

        ab3 = new JLabel("性别: ");
        ab3.setBounds(110, 150, 200, 30);

        test3 = new JTextField(25);
        test3.setBounds(160, 150, 200, 30);

        ab4 = new JLabel("年龄: ");
        ab4.setBounds(110, 200, 200, 30);

        test4 = new JTextField(25);
        test4.setBounds(160, 200, 200, 30);

        bu2 = new JButton("增加");
        bu2.setBounds(300, 280, 100, 30);
        //bu2.addActionListener(this);

        bu3 = new JButton("删除");
        //bu3.addActionListener(this);
        bu3.setBounds(100, 280, 100, 30);

        bu4 = new JButton("更新");
        //bu4.addActionListener(this);
        bu4.setBounds(100, 340, 100, 30);

        bu1 = new JButton("查询");
        bu1.setBounds(300, 340, 100, 30);
        //bu1.addActionListener(this);

        bu5 = new JButton("上一条");
        bu5.setBounds(100, 295, 100, 30);
        bu5.setVisible(false);
        //bu5.addActionListener(this);

        bu6 = new JButton("下一条");
        bu6.setBounds(300, 295, 100, 30);
        bu6.setVisible(false);
        //bu6.addActionListener(this);

        bu7 = new JButton("返回");
        bu7.setBounds(200, 295, 100, 30);
        bu7.setVisible(false);
        //bu7.addActionListener(this);
        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);
        add(ab4);
        add(test1);
        add(test2);
        add(test3);
        add(test4);
        add(bu1);
        add(bu2);
        add(bu3);
        add(bu4);
        add(bu5);
        add(bu6);
        add(bu7);
        setVisible(true);
    }
    public static void main(String[] args){
        new Windows_HomePage_User();
    }
}
