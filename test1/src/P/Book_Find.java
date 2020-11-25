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
                    String sql = "select * from everybook left join book on book.ISBN = everybook.ISBN"; //连接!
                    ResultSet rs = stmt.executeQuery(sql);

                    Object[][] rowData = new Object[8000][9];

                    int cnt = 0;
                    int flag = 0;
                    System.out.println(c + c);
                    while(rs.next()){
                        //System.out.println("123");
                        String ISBN = rs.getString("ISBN");
                        String Bname = rs.getString("Bname");
                        int Bpublish = rs.getInt("Bpublish");
                        String Bauthor = rs.getString("Bauthor");
                        String Bpress = rs.getString("Bpress");
                        int Bnumber = rs.getInt("Bnumber");
                        String Kind = rs.getString("Kind");
                        int BID = rs.getInt("BID");
                        int ZT = rs.getInt("ZT");
                        //System.out.println(ZT);
                        if(ISBN.equals(c)){
                            flag = 1;
                            rowData[cnt][0] = ISBN;
                            rowData[cnt][1] = Bname;
                            rowData[cnt][2] = Bpublish;
                            rowData[cnt][3] = Bauthor;
                            rowData[cnt][4] = Bpress;
                            rowData[cnt][5] = Bnumber;
                            rowData[cnt][6] = Kind;
                            rowData[cnt][7] = BID;
                            if(ZT == 1)
                                rowData[cnt][8] = "未借出";
                            else
                                rowData[cnt][8] = "已借出";
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
                            rowData[cnt][7] = BID;
                            if(ZT == 1)
                                rowData[cnt][8] = "未借出";
                            else
                                rowData[cnt][8] = "已借出";
                            cnt++;
                            //System.out.println("+1");
                        }
                    }

                    if(flag == 0){
                        Little_Notice.puts("图书不存在!");
                    }
                    else {
                        JFrame frame = new JFrame();
                        frame.setVisible(true);
                        frame.setSize(800,600);
                        //frame.setLocationRelativeTo(Windows_Login.frame);

                        JPanel panel = new JPanel();

                        //表头
                        String[] columnNames = {"ISBN", "书名", "出版日期", "作者", "出版社", "数量", "种类", "图书编号", "是否借出(0/1)"};

                        //所有行数据

                        JTable table = new JTable(rowData, columnNames);

                        table.setRowHeight(40);
                        table.getColumnModel().getColumn(0).setPreferredWidth(80);
                        table.setPreferredScrollableViewportSize(new Dimension(700, 500));

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
