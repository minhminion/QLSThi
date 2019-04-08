/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SanPhamBUS;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.ImageIcon;
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
public class HoaDonGUI extends JPanel{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private JTable tbl;
    private JTextField txtMaHD,txtMaKH,txtMaNV,txtNgayHD,txtTongTien;
    private JTextField txtMinPrice,txtMaxPrice;
    private DefaultTableModel model;
    private Choice yearChoice,monthChoice,AD;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
    public HoaDonGUI(int width)
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
       
/*********************** PHẦN VIEW THÔNG TIN *****************************/
        JPanel itemView = new JPanel(null);
        itemView.setBackground(null);
        itemView.setBounds(new Rectangle(30,40,this.DEFALUT_WIDTH - 200,150));

        JLabel lbMaHD = new JLabel("Mã HD");
        lbMaHD.setFont(font0);
        lbMaHD.setBounds(0,0,55,30);
        txtMaHD = new JTextField();
        txtMaHD.setBounds(new Rectangle(55,0,80,30));
        itemView.add(lbMaHD);
        itemView.add(txtMaHD);

        JLabel lbMaKH = new JLabel("Mã KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(155,0,60,30);
        txtMaKH = new JTextField();
        txtMaKH.setBounds(new Rectangle(215,0,80,30));
        itemView.add(lbMaKH);
        itemView.add(txtMaKH);

        JLabel lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(315,0,60,30);
        txtMaNV = new JTextField();
        txtMaNV.setBounds(new Rectangle(375,0,80,30));
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);

        JLabel lbNgayHD = new JLabel("Ngày HD");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0,50,60,30);
        txtNgayHD = new JTextField();
        txtNgayHD.setBounds(new Rectangle(80,50,375,30));
        itemView.add(lbNgayHD);
        itemView.add(txtNgayHD);

        JLabel lbTongTien = new JLabel("Tổng Tiền");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(0,100,60,30);
        txtTongTien = new JTextField();
        txtTongTien.setBounds(new Rectangle(80,100,375,30));
        itemView.add(lbTongTien);
        itemView.add(txtTongTien);

        add(itemView);
        /**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/

        JLabel btnEdit = new JLabel(new ImageIcon(getClass().getResource("/image/btnEdit.png")));
        btnEdit.setBounds(new Rectangle(500,0,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon(getClass().getResource("/image/btnDelete.png")));
        btnDelete.setBounds(new Rectangle(500,70,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnView = new JLabel(new ImageIcon(getClass().getResource("/image/btnView.png")));
        btnView.setBounds(new Rectangle(730,0,200,50));
        btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBill = new JLabel(new ImageIcon(getClass().getResource("/image/btnBill.png")));
        btnBill.setBounds(new Rectangle(730,70,200,50));
        btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        itemView.add(btnView);
        itemView.add(btnBill);
        
        btnView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ChiTietHDGUI chitiet = new ChiTietHDGUI();
            }
        });
        
        /*************************************************************************/
/****************** TẠO MODEL VÀ HEADER *********************************************/
        Vector header = new Vector();
        header.add("Mă Hóa Đơn");
        header.add("Mă KH");
        header.add("Mã NV");
        header.add("Ngay Hóa Đơn");
        header.add("Tổng Tiền");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);

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
        scroll.setBounds(new Rectangle(30, 350, this.DEFALUT_WIDTH - 400 , 320));
        scroll.setBackground(null);
        
        add(scroll);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                txtMaHD.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtMaHD.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtMaNV.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtNgayHD.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtTongTien.setText( tbl.getModel().getValueAt(i, 4).toString());
             }
        });
/*********************** SORT TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,190,this.DEFALUT_WIDTH - 400,140);
        
        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------------ BỘ LỌC ------------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 84 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);
        
        /******** SORT THỜI GIAN **************/
        JLabel sortTime = new JLabel("Thời gian :");
        sortTime.setFont(font0);
        sortTime.setBounds(0,40,80,30);
        sort.add(sortTime);
        // Choice Tháng
        int month = Calendar.getInstance().get(Calendar.MONTH);// Lấy tháng hiện tại
        monthChoice = new Choice();
        monthChoice.setFont(font0);
        for(int i = 1 ; i <= 12 ; i++ )
        {
            monthChoice.add("Tháng "+i);
        }
        monthChoice.select(month);
        monthChoice.setBounds(new Rectangle(80,42,80,40));
        sort.add(monthChoice);
        // Choice Năm
        int year = Calendar.getInstance().get(Calendar.YEAR);//Lấy năm hiện tại
        yearChoice = new Choice();
        yearChoice.setFont(font0);
        for(int i = year ; i >= 1999 ; i--)
        {
            yearChoice.add(String.valueOf(i));
        }
        yearChoice.select(0);
        yearChoice.setBounds(new Rectangle(170,42,80,40));
        sort.add(yearChoice);
        /*************************************/
        
        /************ SORT THEO GIÁ ***************/
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(300,40,80,30);
        sort.add(sortPrice);
        
        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(380,42,100,26));
        sort.add(txtMinPrice);
        
        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(490, 56, 10, 6);
        sort.add(sepPrice);
        
        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(510,42,100,26));
        sort.add(txtMaxPrice);
          
        /******************************************/
        /************ SORT ASC-DESC ***************/
        JLabel sortAD = new JLabel("Sắp xếp theo :");
        sortAD.setFont(font0);
        sortAD.setBounds(650,40,100,30);
        sort.add(sortAD);
        AD = new Choice();
        AD.setFont(font0);
        String[]itemAD ={"Mới nhất","Giá cao - thấp","Giá thấp - cao"};
        for(String s:itemAD)
        {
            AD.add(s);
        }
        AD.setBounds(750, 40, 150, 40);
        sort.add(AD);
        /******************************************/
        add(sort);

/****************************************************************/
        
    }

}
