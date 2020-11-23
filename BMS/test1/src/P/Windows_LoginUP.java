package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Windows_LoginUP extends JFrame {
    private JLabel ab1, ab2, ab3, ab4, ab0;
    private JLabel ab5, ab6, ab7, ab8;
    private JTextField test1, test2, test3, test4;
    private JTextField test5, test6, test7, test8;
    private JButton bu1, bu2, bu3, bu4, bu5, bu6, bu7;
    private int ID, Uage;
    private String Upassword1, Uname, Usex, Umarjor, Uphone, Upassword2;
    int cout;
    Windows_LoginUP(){
        setTitle("LOGIN UP");
        setSize(500, 580);
        setLocation(200, 200);
        setVisible(true);
        //setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLayout(null);

        ab0 = new JLabel("注册");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(230, 0, 300, 40);

        //ID int
        ab1 = new JLabel("I D : ");
        ab1.setBounds(110, 50, 200, 30);

        test1 = new JTextField(15);
        test1.setBounds(160, 50, 200, 30);

        //Upassword1 string
        ab2 = new JLabel("密码: ");
        ab2.setBounds(110, 100, 200, 30);

        test2 = new JTextField(25);
        test2.setBounds(160, 100, 200, 30);

        //Uname string
        ab3 = new JLabel("名字: ");
        ab3.setBounds(110, 150, 200, 30);

        test3 = new JTextField(25);
        test3.setBounds(160, 150, 200, 30);

        //Uage int
        ab4 = new JLabel("年龄: ");
        ab4.setBounds(110, 200, 200, 30);


        test4 = new JTextField(25);
        test4.setBounds(160, 200, 200, 30);

        //Usex string
        ab5 = new JLabel("性别: ");
        ab5.setBounds(110, 250, 200,30);

        test5 = new JTextField(15);
        test5.setBounds(160, 250, 200, 30);

        //Umarjor string
        ab6 = new JLabel("专业: ");
        ab6.setBounds(110, 300, 200,30);

        test6 = new JTextField(15);
        test6.setBounds(160, 300, 200, 30);

        //Uphone string
        ab7 = new JLabel("电话号码: ");
        ab7.setBounds(100, 350, 200,30);

        test7 = new JTextField(15);
        test7.setBounds(160, 350, 200, 30);

        //Upassword2 string
        ab8 = new JLabel("二重密码: ");
        ab8.setBounds(100, 400, 200,30);

        test8 = new JTextField(15);
        test8.setBounds(160, 400, 200, 30);

        bu1 = new JButton("注册");
        bu1.setBounds(200, 450, 100, 40);

        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);
        add(ab4);
        /*

        add(bu1);
        add(bu2);
        add(bu3);
        add(bu4);
        add(bu5);
        add(bu6);
        add(bu7);

         */
        add(ab5);
        add(ab6);
        add(ab7);
        add(ab8);

        add(test1);
        add(test2);
        add(test3);
        add(test4);

        add(test5);
        add(test6);
        add(test7);
        add(test8);

        add(bu1);
        bu1.setVisible(true);



        bu1.addActionListener(new ActionListener ()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了9号事件: ");
                String str = test1.getText();
                ID = Integer.parseInt(str);
                System.out.println(str);

                Upassword1 = test2.getText();
                Uname = test3.getText();
                System.out.println(Upassword1);
                System.out.println(Uname);

                str = test4.getText();
                Uage = Integer.parseInt(str);

                Usex = test5.getText();
                Umarjor = test6.getText();
                Uphone = test7.getText();
                Upassword2 = test8.getText();

                User stu = new User();
                stu.setID(ID); //1
                stu.setUage(Uage); //2
                stu.setUname(Uname); //3
                stu.setUmarjor(Umarjor); //4
                stu.setUpassword1(Upassword1); //5
                stu.setUpassword2(Upassword2); //6
                stu.setUphone(Uphone); //7
                stu.setUsex(Usex); //8

                try{
                    Create_Account_Students.Insert(stu);
                    JFrame aa1 = new JFrame();
                    JLabel jb0 = new JLabel("              注册成功!");
                    jb0.setForeground(Color.red);
                    jb0.setFont(new Font("微软雅黑", Font.BOLD, 18));

                    aa1.add(jb0);
                    aa1.setVisible(true);
                    aa1.setResizable(false);
                    aa1.setSize( 200, 150);
                    aa1.setLocationRelativeTo(Windows_Login.frame);
                    dispose();
                }
                catch(SQLException s) {
                    s.printStackTrace();
                }
                catch(ClassNotFoundException ss){
                    ss.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        //new Windows_HomePage_User();
    }
}
