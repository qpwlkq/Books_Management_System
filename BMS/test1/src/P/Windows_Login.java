package P;



/*
import java.awt.*;
import javax.swing.*;

public class Windows_Login extends JFrame{
    public Windows_Login(){
        setTitle("图书管理系统");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jl = new JLabel("欢迎");
        Container c = getContentPane();
        c.add(jl);
        setVisible(true);
    }
    public static void main(String[] args){
        new Windows_Login();
    }
}*/



import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Windows_Login{
    static JFrame frame;
    public Windows_Login(){
        ImageIcon icon = new ImageIcon("C:/Users/DELL/Desktop/BMS/photo/1.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        frame = new JFrame("图书管理系统BMS");

        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        JPanel j = (JPanel)frame.getContentPane();
        j.setOpaque(false);

        JPanel panel = new JPanel();

        JTextField jta = new JTextField(10);
        //JTextArea jta = new JTextArea(10,60);

        /*String strMsg1 = "第一行";
        String strMsg2 = "第二行";
        String strMsg = "<html><body>" + strMsg1 + "<br>" + strMsg2 + "<body></html>";
        JLabel label = new JLabel(strMsg);*/

        /*JLabel jb0 = new JLabel("图书管理系统");
        jb0.setForeground(Color.white);
        jb0.setFont(new Font("微软雅黑", Font.BOLD, 24));*/

        JButton jb = new JButton("LOGIN IN");
        JButton jb2 = new JButton("LOGIN UP");
        JButton jb3 = new JButton("FORGOT PASSWORD?");

        JFrame jf2 = new JFrame();

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了1号事件: LOGIN IN");
                /*jf2.setTitle("LOGIN IN");
                jf2.setSize(500, 400);
                jf2.setLocationRelativeTo(frame);
                jf2.setVisible(true);*/
                Windows_LoginIN x1 = new Windows_LoginIN();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了2号事件: LOHIN UP");
                /*jf2.setTitle("LOGIN UP");
                jf2.setSize(500, 400);
                jf2.setLocationRelativeTo(frame);
                jf2.setVisible(true);*/
                Windows_LoginUP x2 = new Windows_LoginUP();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了3号事件: 忘记密码");
                /*jf2.setTitle("找回密码");
                jf2.setSize(500, 400);
                jf2.setLocationRelativeTo(frame);
                jf2.setVisible(true);*/
                Windows_FORGOT_PASSWORD x1 = new Windows_FORGOT_PASSWORD();
            }
        });


        //frame.add(jb);


        //panel.add(jb0);
        panel.add(jb);
        panel.add(jb2);
        panel.add(jb3);
        panel.setOpaque(false);

        frame.setSize(icon.getIconWidth(),icon.getIconHeight());
        frame.setVisible(true);
        frame.add(panel);

    }

    public static void main(String[] args) {
        new Windows_Login();
    }
/*    public static void main(String[] args) {
        JFrame jf = new JFrame("事件监听测试");
        jf.setVisible(true);
        jf.setSize(100, 200);

        JButton jb = new JButton("触发事件");
        jf.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                System.out.println("触发了事件");
            }
        });

    }*/

}
