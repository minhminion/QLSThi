/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsieuthi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import model.Item;
import model.Page404;
import model.QLSP;
import model.QLSP1;
import model.header;
import model.navItem;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Shadow
 */
public class QLSieuThi extends JFrame implements MouseListener{
    private JPanel header,nav,main;
    private int DEFAULT_HEIGHT = 730,DEFALUT_WIDTH = 1300 ;
    private ArrayList<navItem> navObj = new ArrayList<>();
    public QLSieuThi()
    {
        Toolkit screen = Toolkit.getDefaultToolkit();
//        this.DEFAULT_HEIGHT = (int) screen.getScreenSize().getHeight();
//        this.DEFALUT_WIDTH = (int) screen.getScreenSize().getWidth();
        init();
    }
    public void init()
    {
        setTitle("Quản Lý siêu thị ");
        ImageIcon logo = new ImageIcon(getClass().getResource("/image/SystemIcon_60px.png"));
        setIconImage(logo.getImage());
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH,DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        
        header = new JPanel(null);
        header.setBackground(new Color(30, 30, 30));
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH,60));
        header.add(new header(DEFALUT_WIDTH,60));
        
        nav = new JPanel(null);
        nav.setBackground(new Color(30, 30, 30));
        nav.setPreferredSize(new Dimension(220,DEFAULT_HEIGHT));
        
        //Thêm item vào thanh menu (Tên item : hình)
        ArrayList<String> navItem = new ArrayList<>();
        navItem.add("Quản lý Sản Phẩm:QLSP_20px.png:QLSP_20px_active.png");
        navItem.add("Quản lý nhân viên:NhanVien_20px.png:NhanVien_20px_active.png");
        navItem.add("Quản lý Khách Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
        navItem.add("Thống kê:ThongKe_20px.png:ThongKe_20px_active.png");
        navItem.add("Công Cụ:CongCu_20px.png:CongCu_20px_active.png");
        navItem.add("Cái đặt:CaiDat_20px.png:CaiDat_20px_active.png");
        //
        
        for(int i = 0 ; i < navItem.size() ; i++)
        {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0,50*i,220,50),icon,iconActive));
            navObj.get(i).addMouseListener(this);
            nav.add(navObj.get(i));
        }
        
        //Thêm item vào thanh menu (Tên San Pham : hình)
        ArrayList<String> SanPham = new ArrayList<>();
        SanPham.add("CoCa Cola");
        
        
        main = new JPanel(null);
        main.setBackground(Color.WHITE);
        
        
//        JPanel ItemView = new JPanel(null);
//        ItemView.setBounds(new Rectangle(30, 50, this.DEFALUT_WIDTH - 220 , 1000));
//        ItemView.setBackground(Color.WHITE);
//        for(int i = 0; i < 2; i ++)
//        {
//            for(int j = 0 ; j <= 5 ;j++)
//            {
//                ItemView.add(new Item(240*j,330*i,"Nước giải khát","CocaCola.jpg"));
//            }
//        }
//        
//        JPanel pn = new JPanel(null);
//        pn.setBackground(null);
//        pn.setBounds(new Rectangle(0, 180, this.DEFALUT_WIDTH - 220, 1000));
//        
//        JButton btnAddImg = new JButton("Add Image");
//        JButton btnAddVd = new JButton("Add Video");
//        JButton btnAddYtu = new JButton("Add Youtube");
//        JButton btnAddVit = new JButton("Add Vimeo");
//        
//        btnAddImg.setBounds(new Rectangle(30, 0, 120, 25));
//        btnAddVd.setBounds(new Rectangle(170, 0, 120, 25));
//        btnAddYtu.setBounds(new Rectangle(310, 0, 120, 25));
//        btnAddVit.setBounds(new Rectangle(450, 0, 120, 25));
//        
//        pn.add(btnAddImg);
//        pn.add(btnAddVd);
//        pn.add(btnAddYtu);
//        pn.add(btnAddVit);
//        pn.add(ItemView);
//        
//        main.add(pn);
        
        add(header,BorderLayout.NORTH);
        add(nav,BorderLayout.WEST);
        add(main,BorderLayout.CENTER);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e)
        {
            
        }
        // TODO code application logic here
        QLSieuThi ql = new QLSieuThi();
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for(int i  = 0 ; i<navObj.size();i++)
        {
            navItem item = navObj.get(i);
            if(e.getSource()== item)
            {
                item.doActive();
                changeMainInfo(i);
            }
            else
            {
                item.noActive();
            }
        }
    }

    public void changeMainInfo(int i)
    {
        switch(i)
        {
            case 0: // QUẢN LÝ SẢN PHẨM
                main.removeAll();
                main.add(new QLSP1(DEFALUT_WIDTH));
                main.repaint();
            break;

            case 1: // QUẢN LÝ NHÂN VIÊN
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 2: // QUẢN LÝ KHÁCH HÀNG
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 3: //THỐNG KÊ
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 4: //CÔNG CỤ
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 5: //CÀI ĐẶT
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            default:
        }
    }
            
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
    
}
