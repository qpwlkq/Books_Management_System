package P;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

public class Windows_HomePage_User{
    static JFrame frame;
    public Windows_HomePage_User(int ID){
        ImageIcon icon = new ImageIcon("C:/Users/DELL/Desktop/BMS/photo/2.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        frame = new JFrame("图书管理系统BMS");

        frame.setBounds(450, 170, icon.getIconWidth(),icon.getIconHeight());
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //frame.setLocationRelativeTo(Windows_Login.frame);

        JPanel j = (JPanel)frame.getContentPane();
        j.setOpaque(false);

        JPanel panel = new JPanel();

        JTextField jta = new JTextField(10);
        //JTextArea jta = new JTextArea(10,60);
        JButton jb = new JButton("更改密码");
        JButton jb2 = new JButton("查书");
        JButton jb3 = new JButton("还书");
        JButton jb4 = new JButton("借书");
        JButton jb5 = new JButton("退出系统");
        JButton jb6 = new JButton("查看所有图书");
        JButton jb7 = new JButton("我的借阅");
        JButton jb8 = new JButton("我的历史借阅");

        JFrame jf2 = new JFrame();

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了1号事件: 更改密码");
                Update_Password x1 = new Update_Password();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了2号事件: 查书");
                Book_Find x2 = new Book_Find();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了3号事件: 还书");
                Book_Return x1 = new Book_Return(ID);
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了4号事件: 借书");
                Book_Borrow x1 = new Book_Borrow(ID);
            }
        });

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了5号事件: 退出系统");
                frame.dispose();
            }
        });

        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了6号事件: 查看所有图书");
                Look_ALL_User x1 = new Look_ALL_User();
            }
        });

        jb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了7号事件: 我的借阅");
                Borrow_my x1 = new Borrow_my(ID);
            }
        });
        jb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Look_borrowed x1 = new Look_borrowed(ID);
            }
        });

        //frame.add(jb);
        //panel.add(jb0);
        panel.add(jb);
        panel.add(jb2);
        panel.add(jb6);
        panel.add(jb8);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb7);
        panel.add(jb5);
        panel.setOpaque(false);

        frame.setSize(icon.getIconWidth(),icon.getIconHeight());
        frame.setVisible(true);
        frame.add(panel);
    }
    public static void main(String[] args){
        //new Windows_HomePage_User();
    }
}