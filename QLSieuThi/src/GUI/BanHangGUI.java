/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ChiTietHDDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class BanHangGUI extends JPanel implements ActionListener{
    private ArrayList<ChiTietHDDTO> dsct = new ArrayList<>();
    private int DEFALUT_WIDTH;
    private JTextField txtMaHD;
    private JTextField txtMaKH;
    private JTextField txtMaNV;
    private JTextField txtNgayHD;
    private JTextField txtTongTien;
    private JButton btnMaNV;
    private JTextField txtMaSP;
    private JTextField txtCTSL;
    private JButton btnMaSP;
    private JTextField txtCTGia;
    private JTextField txtCTTenSP;
    private JButton btnAddCT;
    private JButton btnNewHD;
    private DefaultTableModel model;
    private JTable tbl;
    
    public BanHangGUI(int width)
    {
        DEFALUT_WIDTH = width;
        init();
    }
    public void init()
    {   
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/*********************** PHẦN VIEW THÔNG TIN HD *****************************/
        JPanel hdView = new JPanel(null);
        hdView.setBackground(null);
        hdView.setBounds(new Rectangle(30,40,this.DEFALUT_WIDTH - 350,150));

        JLabel lbMaHD = new JLabel("Mã HD");
        lbMaHD.setFont(font0);
        lbMaHD.setBounds(0,0,55,30);
        txtMaHD = new JTextField();
        txtMaHD.setHorizontalAlignment(JTextField.CENTER);
        txtMaHD.setFont(font0);
        txtMaHD.setBounds(new Rectangle(55,0,120,30));
        hdView.add(lbMaHD);
        hdView.add(txtMaHD);

        JLabel lbMaKH = new JLabel("Mã KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(195,0,60,30);
        txtMaKH = new JTextField();
        txtMaKH.setHorizontalAlignment(JTextField.CENTER);
        txtMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(255,0,120,30));
        hdView.add(lbMaKH);
        hdView.add(txtMaKH);

        JLabel lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(395,0,60,30);
        txtMaNV = new JTextField();
        txtMaNV.setHorizontalAlignment(JTextField.CENTER);
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(455,0,120,30));
        hdView.add(lbMaNV);
        hdView.add(txtMaNV);
        btnMaNV = new JButton("...");
        btnMaNV.setBounds(new Rectangle(575,0,30,30));
        btnMaNV.addActionListener(this);
        hdView.add(btnMaNV);
        
        JLabel lbTongTien = new JLabel("Tổng Tiền (VNĐ)");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(625,0,120,30);
        txtTongTien = new JTextField();
        txtTongTien.setEditable(false);
        txtTongTien.setHorizontalAlignment(JTextField.CENTER);
        txtTongTien.setFont(font0);
        txtTongTien.setBounds(new Rectangle(745,0,150,30));
        hdView.add(lbTongTien);
        hdView.add(txtTongTien);

        JLabel lbNgayHD = new JLabel("Ngày HD");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0,50,60,30);
        txtNgayHD = new JTextField();
        txtNgayHD.setHorizontalAlignment(JTextField.CENTER);
        txtNgayHD.setFont(font0);
        txtNgayHD.setBounds(new Rectangle(80,50,350,30));
        hdView.add(lbNgayHD);
        hdView.add(txtNgayHD);
        
        btnNewHD = new JButton("Tạo hóa đơn");
        btnNewHD.setFont(font0);
        btnNewHD.setBounds(new Rectangle(500,50,200,30));
        btnNewHD.addActionListener(this);
        hdView.add(btnNewHD);
        
        JSeparator sepHD = new JSeparator(0);
        sepHD.setBounds(new Rectangle(0,120,this.DEFALUT_WIDTH - 350,3));
        hdView.add(sepHD);      
                
        add(hdView);
/****************************************************************************/
/*********************** PHẦN VIEW THÔNG TIN CHI TIẾT *****************************/
        JPanel chiTietView = new JPanel(null);
        chiTietView.setBackground(null);
        chiTietView.setBounds(new Rectangle(30,190,this.DEFALUT_WIDTH - 350,50));

        JLabel lbMaSP = new JLabel("Mã SP");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(0,0,55,30);
        txtMaSP = new JTextField();
        txtMaSP.setHorizontalAlignment(JTextField.CENTER);
        txtMaSP.setFont(font0);
        txtMaSP.setBounds(new Rectangle(55,0,70,30));
        chiTietView.add(lbMaSP);
        chiTietView.add(txtMaSP);
        btnMaSP = new JButton("...");
        btnMaSP.setBounds(new Rectangle(125,0,30,30));
        btnMaSP.addActionListener(this);
        chiTietView.add(btnMaSP);
        
        JLabel lbCTTenSP = new JLabel("Tên SP");
        lbCTTenSP.setFont(font0);
        lbCTTenSP.setBounds(185,0,50,30);
        txtCTTenSP = new JTextField();
        txtCTTenSP.setHorizontalAlignment(JTextField.CENTER);
        txtCTTenSP.setFont(font0);
        txtCTTenSP.setBounds(new Rectangle(235,0,220,30));
        chiTietView.add(lbCTTenSP);
        chiTietView.add(txtCTTenSP);

        JLabel lbCTGia = new JLabel("Đơn giá");
        lbCTGia.setFont(font0);
        lbCTGia.setBounds(470,0,60,30);
        txtCTGia = new JTextField();
        txtCTGia.setHorizontalAlignment(JTextField.CENTER);
        txtCTGia.setFont(font0);
        txtCTGia.setBounds(new Rectangle(525,0,150,30));
        chiTietView.add(lbCTGia);
        chiTietView.add(txtCTGia);

        JLabel lbCTSL = new JLabel("Số lượng");
        lbCTSL.setFont(font0);
        lbCTSL.setBounds(695,0,60,30);
        txtCTSL = new JTextField();
        txtCTSL.setHorizontalAlignment(JTextField.CENTER);
        txtCTSL.setFont(font0);
        txtCTSL.setBounds(new Rectangle(755,0,70,30));
        chiTietView.add(lbCTSL);
        chiTietView.add(txtCTSL);
        
        btnAddCT = new JButton("Thêm");
        btnAddCT.setFont(font0);
        btnAddCT.addActionListener(this);
        btnAddCT.setBounds(new Rectangle(855,0,80,30));
        chiTietView.add(btnAddCT);
        
        add(chiTietView);
/************************* PHẦN TABLE *************************************/
/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Đơn Giá");
        header.add("Số lượng");
        model = new DefaultTableModel(header,0);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);

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
        scroll.setBounds(new Rectangle(30, 250, this.DEFALUT_WIDTH - 350 , 350));
        scroll.setBackground(null);
        
        add(scroll);
/*****************************************************************************************/
/****************************************************************************/
        setVisible(true);
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnMaNV) // Suggest Nhan Vien
        {
            SuggestNhanVien rm = new SuggestNhanVien();
            String s = rm.getTextFieldContent();
            txtMaNV.setText(s);
        }
        if(e.getSource().equals(btnMaSP)) // Suggest San Pham
        {
            SuggestSanPham rm = new SuggestSanPham();
            String[] s = rm.getTextFieldContent().split("%");
            txtMaSP.setText(s[0]);
            txtCTTenSP.setText(s[1]);
            txtCTGia.setText(s[2]);
        }
        if(e.getSource().equals(btnAddCT)) // Thêm Sản Phẩm
        {
            int sl = 0;
            try{
                sl = Integer.parseInt(txtCTSL.getText()); 
            }catch(NumberFormatException E)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai số lượng");
                return;
            }
            int gia = Integer.parseInt(txtCTGia.getText());
            System.out.println(sl);
            boolean flag = true;
            for(ChiTietHDDTO sp : dsct )
            {
                System.out.println(sp.getMaSP()+" "+txtMaSP.getText());
                if(sp.getMaSP().equals(txtMaSP.getText()))
                {
                    int old = sp.getSl();
                    sp.setSl(sl + old);
                    flag = false ;
                    break;
                }
            }
            if(flag)
            {
               dsct.add(new ChiTietHDDTO(txtMaHD.getText(),txtMaSP.getText(),txtCTTenSP.getText(), gia, sl)); 
            }
            outModel(model, dsct);
            txtTongTien.setText(String.valueOf(sumHD()));
        }
        
        if(e.getSource().equals(btnNewHD))
        {
            Date date = Calendar.getInstance().getTime();
            txtNgayHD.setText(date.toString());
        }
    }
    public void outModel(DefaultTableModel model , ArrayList<ChiTietHDDTO> ds) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(ChiTietHDDTO sp:ds)
        {
            data = new Vector();
            data.add(sp.getMaSP());
            data.add(sp.getTenSP());
            data.add(sp.getGia());
            data.add(sp.getSl());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public int sumHD()
    {   
        int sum = 0;
        for(ChiTietHDDTO sp : dsct)
        {
            int sl = sp.getSl();
            int gia = sp.getGia();
            sum += sl*gia;
        }
        return sum;
    }
}
