/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shadow
 */
public class KhachHangGUI extends JPanel{        
//    private NhanVienBUS khBUS = new NhanVienBUS();
    private JTable tbl;
    private JTextField txtMaKH,txtHoKH,txtTenKH,txtDiaChi,txtSDT;
    private JTextField sortMaKH,sortHoKH,sortTenKH;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
    public KhachHangGUI (int width)
    {
        DEFALUT_WIDTH = width;
        init();
    }
    public void init()
    {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/****************************** PHẦN HIỂN THỊ THÔNG TIN ******************************************/

        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 220 , 250));
        itemView.setBackground(null);
        
        /******** Tao Cac Label & TextField ************************/
        JLabel lbMaKH = new JLabel("Mă khách hàng");
        txtMaKH = new JTextField("");
        lbMaKH.setBounds(new Rectangle(50,0,200,30));
        lbMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(150,0,220,30));
        
        JLabel lbHoKH = new JLabel("Họ");
        txtHoKH = new JTextField("");
        lbHoKH.setBounds(new Rectangle(50,50,200,30));
        lbHoKH.setFont(font0);
        txtHoKH.setBounds(new Rectangle(150,50,220,30));
     
        JLabel lbTenKH = new JLabel("Tên");
        txtTenKH = new JTextField("");
        lbTenKH.setBounds(new Rectangle(50,100,200,30));
        lbTenKH.setFont(font0);
        txtTenKH.setBounds(new Rectangle(150,100,220,30));
        
        JLabel lbDiaChi = new JLabel("Địa chỉ");
        txtDiaChi = new JTextField("");
        lbDiaChi.setBounds(new Rectangle(50,150,200,30));
        lbDiaChi.setFont(font0);
        txtDiaChi.setBounds(new Rectangle(150,150,220,30));
       
        JLabel lbSDT = new JLabel("Số điện thoại");
        txtSDT = new JTextField("");
        lbSDT.setBounds(new Rectangle(50,200,200,30));
        lbSDT.setFont(font0);
        txtSDT.setBounds(new Rectangle(150,200,220,30));
        
        // THÊM VÀO PHẦN HIỂN THỊ
        itemView.add(lbMaKH);
        itemView.add(txtMaKH);
        itemView.add(lbHoKH);
        itemView.add(txtHoKH);
        itemView.add(lbTenKH);
        itemView.add(txtTenKH);
        itemView.add(lbDiaChi);
        itemView.add(txtDiaChi);
        itemView.add(lbSDT);
        itemView.add(txtSDT);
        
        add(itemView);
        
        /**************** TẠO CÁC BTN THÊM ,XÓA, SỬA ********************/
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(500,0,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(500,90,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(500,180,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        
        
        
        JLabel btnCofirm= new JLabel(new ImageIcon("./src/image/btnCofirm.png"));
        btnCofirm.setVisible(false);
        btnCofirm.setBounds(new Rectangle(700,10,200,50));
        btnCofirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(700,110,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnCofirm);
        itemView.add(btnBack);
/***************************************************************/
/************************************************************************************************************/       

/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mă KH");
        header.add("Họ KH");
        header.add("Tên KH");
        header.add("Địa chỉ");
        header.add("SĐT");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(60);


        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 450, this.DEFALUT_WIDTH - 400 , 210));
        scroll.setBackground(null);
        
        add(scroll);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                txtMaKH.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtHoKH.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtTenKH.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtDiaChi.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtSDT.setText( tbl.getModel().getValueAt(i, 4).toString());        
             }
        });
/*********************** SEARCH TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,300,this.DEFALUT_WIDTH - 400,140);
        
        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------ TÌM KIẾM THÔNG TIN ------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 78 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);
        
        /******** SORT MAKH **************/
        JLabel lbSortMaKH = new JLabel("Mă KH :");
        lbSortMaKH.setFont(font0);
        lbSortMaKH.setBounds(0,40,60,30);
        sort.add(lbSortMaKH);
        
        sortMaKH = new JTextField();
        sortMaKH.setBounds(new Rectangle(60,42,100,30));
        sort.add(sortMaKH);
        /*************************************/
        
        /******** SORT HOKH **************/
        JLabel lbSortHoKH = new JLabel("Họ KH :");
        lbSortHoKH.setFont(font0);
        lbSortHoKH.setBounds(200,40,60,30);
        sort.add(lbSortHoKH);
        
        sortHoKH = new JTextField();
        sortHoKH.setBounds(new Rectangle(260,42,100,30));
        sort.add(sortHoKH);
        /*************************************/
        
        /******** SORT TENKH **************/
        JLabel lbSortTenKH = new JLabel("Tên KH :");
        lbSortTenKH.setFont(font0);
        lbSortTenKH.setBounds(400,40,60,30);
        sort.add(lbSortTenKH);
        
        sortTenKH = new JTextField();
        sortTenKH.setBounds(new Rectangle(460,42,200,30));
        sort.add(sortTenKH);
        /*************************************/
        
        add(sort);
/******************************************************************/
    }
}

