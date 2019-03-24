/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsieuthi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.random;
import static java.lang.Short.SIZE;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.Caret;
import keeptoo.KGradientPanel;
import keeptoo.KButton;
import model.header;


/**
 *
 * @author Shadow
 */
public class Login extends JFrame{
    private JTextField user;
    private JPasswordField pass;
    private int DEFAULT_HEIGHT = 600 ,DEFAULT_WIDTH = 400;
    public Login()
    {
        init();
    }
    public void init()
    {
       
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        header hd = new header(400, 60);
        hd.setBackground(new Color(0,0,0,0));
        hd.setBounds(50,80,300,60);
        
        Font font = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,15);
        
        KGradientPanel background = new KGradientPanel();
        background.setLayout(null);
        background.setkStartColor(new Color(31, 45, 68));
        background.setkEndColor(new Color(92,133,148));
        background.setkGradientFocus(1200);
        background.setBounds(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        
        KButton btnLogin = new KButton();
        btnLogin.setBorder(null);
        btnLogin.setOpaque(false);
        btnLogin.setText("Đăng nhập");
        btnLogin.setFont(font1);
        btnLogin.setkStartColor(new Color(90,204,193));
        btnLogin.setkEndColor(new Color(11,191,214));
        btnLogin.setkHoverForeGround(Color.WHITE);
        btnLogin.setkHoverStartColor(new Color(11,191,214));
        btnLogin.setkHoverEndColor(new Color(90,204,193));
        btnLogin.setkBorderRadius(20); 
        btnLogin.setkSelectedColor(null);
        btnLogin.setkAllowTab(false);
        btnLogin.setBounds(100, 400, 200, 40);
        
        JLabel exit = new JLabel(new ImageIcon(getClass().getResource("/image/exit_25px.png")),JLabel.CENTER);
        exit.setBounds(DEFAULT_WIDTH - 40, 10, 30, 30);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel lbUser = new JLabel(new ImageIcon(getClass().getResource("/image/user_30px.png")),JLabel.CENTER);
        lbUser.setBounds(80, 197, 30, 30);
        JLabel lbPass = new JLabel(new ImageIcon(getClass().getResource("/image/pwd_30px.png")),JLabel.CENTER);
        lbPass.setBounds(80, 277, 30, 30);
        
        user = new JTextField("Username");
        user.setFont(font);
        user.setForeground(Color.WHITE);
        user.setCaretColor(Color.WHITE);
        user.setBounds(120,200,180,30);
        user.setBorder(null);
        user.setOpaque(false);
        
        pass = new JPasswordField("Password");
        pass.setFont(font);
        pass.setForeground(Color.WHITE);
        pass.setCaretColor(Color.WHITE);
        pass.setBorder(null);
        pass.setBounds(120,280,150,30);
        pass.setOpaque(false);    
        
        JSeparator sp1 = new JSeparator();
        sp1.setBounds(80,230,220,10);
        
        JSeparator sp2 = new JSeparator();
        sp2.setBounds(80,310,220,10);

        setUndecorated(true);
        background.add(exit);
        background.add(hd);
        background.add(lbUser);
        background.add(user);
        background.add(sp1);
        background.add(lbPass);
        background.add(pass);
        background.add(sp2);
        background.add(btnLogin);
        add(background);
        
        btnLogin.requestFocus();
        
        setSize(DEFAULT_WIDTH ,DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
         
        QLSieuThi qlst = new QLSieuThi();
        qlst.setVisible(false);
        
        exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
        
        user.addMouseListener((new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                user.setText("");
            }
        }));
        pass.addMouseListener((new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                pass.setText("");
            }
        }));
        
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MySQLConnection mysql = new MySQLConnection("root","","jdbc:mysql://localhost/qlsieuthi");
                    if(mysql.checkAcc(user.getText(),"admin"))
                    {
                        qlst.setVisible(true);
                        setVisible(false);
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "Sai mat khau");
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   
    public static void main(String[]args)
    {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e)
        {
            
        }
        Login lg = new Login();
    }
}
