package P;

//查书

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Book_Find extends JFrame {
    public Book_Find() {
        setTitle("查找图书");
        setSize(400, 300);
        setLocationRelativeTo(Windows_Login.frame);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ab1, ab2, ab0;
        ab0 = new JLabel("查找图书");
        ab0.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ab0.setBounds(130, 20, 200, 30);

        JTextField tx1, tx2, tx3;
        ab1 = new JLabel("ISBN 或 书名:");
        ab1.setBounds(35, 90, 200, 30);

        tx1 = new JTextField();
        tx1.setBounds(125, 90, 200, 30);


        add(ab0);
        add(tx1);
        add(ab1);
        JButton jb1;

        JButton b1 = new JButton("查找");
        b1.setBounds(140, 150, 100, 40);
        add(b1);

        //Vector vector = new Vector();
        //JList jlist = new JList(vector);
        //jlist.setBounds(50, 170, 300, 100);
        //add(jlist);

        //add(scrollPane);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c = tx1.getText();
                //System.out.println(c);
                try{
                    Connection conn = Conn.conn();
                    Statement stmt = conn.createStatement();
                    String sql = "select * from book";
                    ResultSet rs = stmt.executeQuery(sql);

                    Object[][] rowData = new Object[2000][7];

                    int cnt = 0;
                    int flag = 0;
                    //System.out.println(c + c);
                    while(rs.next()){
                        String ISBN = rs.getString("ISBN");
                        String Bname = rs.getString("Bname");
                        int Bpublish = rs.getInt("Bpublish");
                        String Bauthor = rs.getString("Bauthor");
                        String Bpress = rs.getString("Bpress");
                        int Bnumber = rs.getInt("Bnumber");
                        String Kind = rs.getString("Kind");
                        if(ISBN.equals(c)){
                            flag = 1;
                            rowData[cnt][0] = ISBN;
                            rowData[cnt][1] = Bname;
                            rowData[cnt][2] = Bpublish;
                            rowData[cnt][3] = Bauthor;
                            rowData[cnt][4] = Bpress;
                            rowData[cnt][5] = Bnumber;
                            rowData[cnt][6] = Kind;
                            cnt++;
                            //vector.add(b);
                        }
                        else if(Bname.equals(c)){
                            flag = 1;
                            //vector.add(a);

                            rowData[cnt][0] = ISBN;
                            rowData[cnt][1] = Bname;
                            rowData[cnt][2] = Bpublish;
                            rowData[cnt][3] = Bauthor;
                            rowData[cnt][4] = Bpress;
                            rowData[cnt][5] = Bnumber;
                            rowData[cnt][6] = Kind;
                            cnt++;
                            //System.out.println("1");
                        }
                    }

                    if(flag == 0){

                        JLabel jb0 = new JLabel("  图书不存在!");
                        jb0.setForeground(Color.red);
                        jb0.setFont(new Font("微软雅黑", Font.BOLD, 18));
                        JFrame aa1 = new JFrame();
                        aa1.add(jb0);
                        aa1.setVisible(true);
                        aa1.setResizable(false);
                        aa1.setSize( 200, 150);
                        aa1.setLocationRelativeTo(Windows_Login.frame);

                        System.out.println("图书不存在");
                    }
                    else {
                        JFrame frame = new JFrame();
                        frame.setVisible(true);
                        frame.setSize(700,600);
                        //frame.setLocationRelativeTo(Windows_Login.frame);

                        JPanel panel = new JPanel();

                        //表头
                        String[] columnNames = {"ISBN", "书名", "出版日期", "作者", "出版社", "数量", "种类"};

                        //所有行数据

                        JTable table = new JTable(rowData, columnNames);

                        table.setRowHeight(40);
                        table.getColumnModel().getColumn(0).setPreferredWidth(60);
                        table.setPreferredScrollableViewportSize(new Dimension(600, 500));

                        JScrollPane scrollPane = new JScrollPane(table);

                        panel.add(scrollPane);
                        frame.add(panel);

                        frame.setContentPane(panel);
                    }
                    //add(jlist);

                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException x){

                }catch(ClassNotFoundException x){

                }finally {

                }
            }
        });

    }
    public static void main(String[] args){

    }
}
