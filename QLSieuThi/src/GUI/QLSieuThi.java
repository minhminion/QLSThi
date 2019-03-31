/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import GUI.model.Page404;
import GUI.model.header;
import GUI.model.navItem;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author Shadow
 */
public class QLSieuThi extends JFrame implements MouseListener{
    private boolean flag = true;
    private JPanel header,nav,main;
    private int DEFAULT_HEIGHT = 730,DEFALUT_WIDTH = 1300 ;
    private ArrayList<String> navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>();  //Chứa cái button trên thanh menu
    public QLSieuThi()
    {
        Toolkit screen = Toolkit.getDefaultToolkit();
        init();
    }
    public void init()
    {
        setTitle("Quản Lý siêu thị ");
        ImageIcon logo = new ImageIcon(getClass().getResource("/image/SieuThi_25px.png"));
        setIconImage(logo.getImage());
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH,DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        //setShape(new RoundRectangle2D.Double(0, 0, DEFALUT_WIDTH, DEFAULT_HEIGHT, 30, 30)); //Bo khung Frame
        
        
/************ PHẦN HEADER *************************************/      
        header = new JPanel(null);
        header.setBackground(new Color(27, 27, 30));
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH,40));
        
        header hmain = new header(DEFALUT_WIDTH,40);
        
        //Tạo btn EXIT & MINIMIZE
        navItem exit = new navItem("", new Rectangle(DEFALUT_WIDTH-50, -8, 50, 50), "exit_25px.png", "exit_25px.png", "exit_hover_25px.png", new Color(240, 71, 74));
        navItem minimize = new navItem("", new Rectangle(DEFALUT_WIDTH-100, -8, 50, 50), "minimize_25px.png", "minimize_25px.png", "minimize_hover_25px.png" ,new Color(80,80,80));
        
        hmain.add(exit.isButton());
        hmain.add(minimize.isButton());
        
        exit.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
              System.exit(0);
           }
        });
        
        minimize.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
              setState(Frame.ICONIFIED);
           }
        });
        
        header.add(hmain);
        
/****************************************************************/    


/************ PHẦN NAVIGATION ( MENU ) **************************/  
        nav = new JPanel(null);
        nav.setBackground(new Color(55, 63, 81));
        nav.setPreferredSize(new Dimension(220,DEFAULT_HEIGHT));
        
        //Thêm item vào thanh menu (Tên item : icon : icon hover)
        navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm ( Tên btn : icon : icon hover )
        navItem.add("Quản lý Sản Phẩm:QLSP_20px.png:QLSP_20px_active.png");
        navItem.add("Quản lý nhân viên:NhanVien_20px.png:NhanVien_20px_active.png");
        navItem.add("Quản lý Khách Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
        navItem.add("Thống kê:ThongKe_20px.png:ThongKe_20px_active.png");
        navItem.add("Công Cụ:CongCu_20px.png:CongCu_20px_active.png");
        navItem.add("Cái đặt:CaiDat_20px.png:CaiDat_20px_active.png");
        
        outNav();
        
/************ PHẦN MAIN ( HIỂN THỊ ) **************************/        
        main = new JPanel(null);
        main.setBackground(Color.WHITE);
/**************************************************************/   

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
        QLSieuThi ql = new QLSieuThi();
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for(int i  = 0 ; i<navObj.size();i++)
        {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if(e.getSource()== item)
            {
                item.doActive(); // Active NavItem đc chọn 
                changeMainInfo(i); // Hiển thị ra phần main
            }
            else
            {
                item.noActive();
            }
        }
    }

    public void changeMainInfo(int i) //Đổi Phần hiển thị khi bấm btn trên menu
    {
        if(flag && i>3 && i<6) // Thay đổi nếu Thông kế đang dropdown
        {
            i = i + 2;
        }
        switch(i)
        {
            case 0: // QUẢN LÝ SẢN PHẨM
                main.removeAll();
                main.add(new SanPhamGUI(DEFALUT_WIDTH));
                main.repaint();
            break;

            case 1: // QUẢN LÝ NHÂN VIÊN
                main.removeAll();
                main.add(new NhanVienGUI(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 2: // QUẢN LÝ KHÁCH HÀNG
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 3: //THỐNG KÊ
                if(flag)
                {
                    // Thêm 2 btn vào dưới thống kê
                    navItem.add(4, "Bán Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(5, "Nhập Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
                    
                    flag = false; // Thông báo là đang Dropdown thống kê
                }
                else
                {
                    // Xóa 2 btn của thống kê
                    navItem.remove(4);
                    navItem.remove(4);
                    
                    flag = true;  // Thông báo là Dropdown thống kê đă ẩn
                }
                outNav(); //Load lại phần Navigation
            break;
            case 4: //THÔNG KÊ - BÁN HÀNG
                main.removeAll();
                main.add(new HoaDonGUI(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 5: //THÔNG KÊ - NHẬP HÀNG
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH, "THỐNG KÊ - NHẬP HÀNG"));
                main.repaint();
            break;
            case 6: //CÔNG CỤ
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            case 7: //CÀI ĐẶT
                main.removeAll();
                main.add(new Page404(DEFALUT_WIDTH));
                main.repaint();
            break;
            default:
            break;
        }
    }
      
    public void outNav()
    {
        //Gắn cái NavItem vào NavOBJ
        navObj.clear();
        for(int i = 0 ; i < navItem.size() ; i++)
        {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0,50*i,220,50),icon,iconActive));
            navObj.get(i).addMouseListener(this);
        }
        if(!flag && navObj.size() > 6) //Đổi màu phần DropDown của thống kê
        {
            navObj.get(4).setColorNormal(new Color(86, 94, 127));
            navObj.get(5).setColorNormal(new Color(86, 94, 127));
        }
        
        //Xuất ra Naigation
        nav.removeAll();
        for(navItem n : navObj)
        {
            nav.add(n); 
        }
        repaint();
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
