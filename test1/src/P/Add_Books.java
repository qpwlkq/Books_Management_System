package P;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add_Books extends JFrame {
    private JLabel ab1, ab2, ab3, ab4, ab0;
    private JLabel ab5, ab6, ab7, ab8;
    private JTextField test1, test2, test3, test4;
    private JTextField test5, test6, test7, test8;
    private JButton bu1, bu2, bu3, bu4, bu5, bu6, bu7;
    private int ID, Uage;
    private String Upassword1, Uname, Usex, Umarjor, Uphone, Upassword2;
    int cout;
    public Add_Books(){
        setLocationRelativeTo(Windows_Login.frame);
        setTitle("添加图书");
        setSize(500, 580);
        setLocation(200, 200);
        setVisible(true);
        //setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLayout(null);

        ab0 = new JLabel("添加图书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(200, 10, 300, 40);

        //ISBN string
        ab1 = new JLabel("ISBN: ");
        ab1.setBounds(100, 60, 200, 30);

        test1 = new JTextField();
        test1.setBounds(160, 60, 200, 30);

        //Bname string
        ab2 = new JLabel("书名: ");
        ab2.setBounds(100, 110, 200, 30);

        test2 = new JTextField();
        test2.setBounds(160, 110, 200, 30);

        //Bpublish int
        ab3 = new JLabel("出版日期: ");
        ab3.setBounds(100, 160, 200, 30);

        test3 = new JTextField();
        test3.setBounds(160, 160, 200, 30);

        //Bauthor string
        ab4 = new JLabel("作者: ");
        ab4.setBounds(100, 210, 200, 30);

        test4 = new JTextField();
        test4.setBounds(160, 210, 200, 30);

        //Bpress string
        ab5 = new JLabel("出版社: ");
        ab5.setBounds(100, 260, 200,30);

        test5 = new JTextField();
        test5.setBounds(160, 260, 200, 30);

        //Bnumber int
        ab6 = new JLabel("库存量: ");
        ab6.setBounds(100, 310, 200,30);

        test6 = new JTextField();
        test6.setBounds(160, 310, 200, 30);

        //kind string
        ab7 = new JLabel("书类: ");
        ab7.setBounds(100, 360, 200,30);

        test7 = new JTextField();
        test7.setBounds(160, 360, 200, 30);

        bu1 = new JButton("添加");
        bu1.setBounds(200, 450, 100, 40);

        add(ab0);
        add(ab1);
        add(ab2);
        add(ab3);
        add(ab4);
        add(ab5);
        add(ab6);
        add(ab7);


        add(test1);
        add(test2);
        add(test3);
        add(test4);
        add(test5);
        add(test6);
        add(test7);

        add(bu1);
        bu1.setVisible(true);

        bu1.addActionListener(new ActionListener ()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了10号事件: 添加图书");

                String isbn = test1.getText();
                String bname = test2.getText();
                int bpublish = Integer.parseInt(test3.getText());
                String bauthor = test4.getText();
                String bpress = test5.getText();
                int bnumber = Integer.parseInt(test6.getText());
                String kind = test7.getText();

                try{
                    Boook b = new Boook();
                    b.setBauthor(bauthor);
                    b.setBname(bname);
                    b.setBnumber(bnumber);
                    b.setBpress(bpress);
                    b.setBpublish(bpublish);
                    b.setISBN(isbn);
                    b.setKind(kind);
                    //Book_Add c = new Book_Add();
                    Book_Add.Insert(b);
                    Little_Notice.puts("插入成功!");
                }
                catch(SQLException x){

                }
                catch(ClassNotFoundException x){

                }
            }
        });
    }
    public static void main(String[] args) {
        //new Windows_HomePage_User();
    }
}
