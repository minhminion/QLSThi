/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class BanHangGUI extends JPanel implements ActionListener,KeyListener{
    private String userID;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS(1);
    private ChiTietHDBUS ctBUS = new ChiTietHDBUS(1);
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
    private JButton btnConfirm;
    private DefaultTableModel model;
    private JTable tbl;
    private JLabel imgSP;
    private JPanel chiTietView;
    private JButton btnDeleteHD;
    private JButton btnEdit;
    private JButton btnRemove;
    
     public BanHangGUI(int width,String userID)
    {
        this.userID = userID;
        DEFALUT_WIDTH = width;
        hdBUS.list();
        spBUS.listSP();
        init();
    }
    public BanHangGUI(int width)
    {
        DEFALUT_WIDTH = width;
        hdBUS.list();
        spBUS.listSP();
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
        txtMaHD.addKeyListener(this);
        hdView.add(lbMaHD);
        hdView.add(txtMaHD);

        JLabel lbMaKH = new JLabel("Mã KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(195,0,60,30);
        txtMaKH = new JTextField();
        txtMaKH.setHorizontalAlignment(JTextField.CENTER);
        txtMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(255,0,120,30));
        txtMaKH.addKeyListener(this);
        hdView.add(lbMaKH);
        hdView.add(txtMaKH);

        JLabel lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(395,0,60,30);
        txtMaNV = new JTextField();
        if( userID != null ) txtMaNV.setText(userID);
        txtMaNV.setHorizontalAlignment(JTextField.CENTER);
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(455,0,120,30));
        txtMaNV.addKeyListener(this);
        hdView.add(lbMaNV);
        hdView.add(txtMaNV);
        btnMaNV = new JButton("...");
        btnMaNV.setBounds(new Rectangle(575,0,30,30));
        btnMaNV.addActionListener(this);
        hdView.add(btnMaNV);
        
        JLabel lbTongTien = new JLabel("Tổng Tiền (VNĐ)");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(625,0,120,30);
        txtTongTien = new JTextField("0");
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
        
        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setFont(font0);
        btnConfirm.addActionListener(this);
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(500,50,150,30));
        hdView.add(btnConfirm);
        
        btnDeleteHD = new JButton("Xóa");
        btnDeleteHD.setFont(font0);
        btnDeleteHD.setBounds(new Rectangle(700,50,150,30));
        btnDeleteHD.addActionListener(this);
        btnDeleteHD.setVisible(false);
        hdView.add(btnDeleteHD);
        
        JSeparator sepHD = new JSeparator(0);
        sepHD.setBounds(new Rectangle(0,120,this.DEFALUT_WIDTH - 350,3));
        hdView.add(sepHD);      
                
        add(hdView);
/****************************************************************************/
/*********************** PHẦN VIEW THÔNG TIN CHI TIẾT *****************************/
        chiTietView = new JPanel(null);
        chiTietView.setVisible(false);
        chiTietView.setBackground(null);
        chiTietView.setBounds(new Rectangle(30,190,DEFALUT_WIDTH - 60,500));
        
        imgSP = new JLabel();
        imgSP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(155,155,155)));
        imgSP.setBounds(new Rectangle(0,0,280,230));
        imgSP.setHorizontalAlignment(JLabel.CENTER);
        chiTietView.add(imgSP);

        JLabel lbMaSP = new JLabel("Mã SP");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(0,240,55,30);
        txtMaSP = new JTextField();
        txtMaSP.setHorizontalAlignment(JTextField.CENTER);
        txtMaSP.setFont(font0);
        txtMaSP.setBounds(new Rectangle(60,240,70,30));
        txtMaSP.addKeyListener(this);
        chiTietView.add(lbMaSP);
        chiTietView.add(txtMaSP);
        btnMaSP = new JButton("...");
        btnMaSP.setBounds(new Rectangle(130,240,30,30));
        btnMaSP.addActionListener(this);
        chiTietView.add(btnMaSP);
        
        JLabel lbCTTenSP = new JLabel("Tên SP");
        lbCTTenSP.setFont(font0);
        lbCTTenSP.setBounds(0,280,50,30);
        txtCTTenSP = new JTextField();
        txtCTTenSP.setEditable(false);
        txtCTTenSP.setHorizontalAlignment(JTextField.CENTER);
        txtCTTenSP.setFont(font0);
        txtCTTenSP.setBounds(new Rectangle(60,280,220,30));
        chiTietView.add(lbCTTenSP);
        chiTietView.add(txtCTTenSP);

        JLabel lbCTGia = new JLabel("Đơn giá");
        lbCTGia.setFont(font0);
        lbCTGia.setBounds(0,320,60,30);
        txtCTGia = new JTextField();
        txtCTGia.setEditable(false);
        txtCTGia.setHorizontalAlignment(JTextField.CENTER);
        txtCTGia.setFont(font0);
        txtCTGia.setBounds(new Rectangle(60,320,220,30));
        chiTietView.add(lbCTGia);
        chiTietView.add(txtCTGia);

        JLabel lbCTSL = new JLabel("Số lượng");
        lbCTSL.setFont(font0);
        lbCTSL.setBounds(170,240,60,30);
        txtCTSL = new JTextField();
        txtCTSL.setHorizontalAlignment(JTextField.CENTER);
        txtCTSL.setFont(font0);
        txtCTSL.addKeyListener(this);
        txtCTSL.setBounds(new Rectangle(230,240,50,30));
        chiTietView.add(lbCTSL);
        chiTietView.add(txtCTSL);
        
        btnAddCT = new JButton("Thêm");
        btnAddCT.setFont(font0);
        btnAddCT.addActionListener(this);
        btnAddCT.setBounds(new Rectangle(0,360,80,30));
        chiTietView.add(btnAddCT);
        
        btnEdit = new JButton("Sửa");
        btnEdit.setFont(font0);
        btnEdit.addActionListener(this);
        btnEdit.setBounds(new Rectangle(250,420,150,40));
        chiTietView.add(btnEdit);
        
        btnRemove = new JButton("Xóa");
        btnRemove.setFont(font0);
        btnRemove.addActionListener(this);
        btnRemove.setBounds(new Rectangle(400,420,150,40));
        chiTietView.add(btnRemove);
        
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
        scroll.setBounds(new Rectangle(300, 0, this.DEFALUT_WIDTH - 650 , 400));
        scroll.setBackground(null);
        
        chiTietView.add(scroll);
/*****************************************************************************************/
/****************************************************************************/
        
        add(chiTietView); 
        setVisible(true);
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
    public void blockHD(boolean flag)
    {
        txtMaHD.setEditable(flag);
        txtMaKH.setEditable(flag);
        txtMaNV.setEditable(flag);
        txtNgayHD.setEditable(flag);
        btnMaNV.setEnabled(flag);
    }
    public void clear()
    {
        // PHẦN HÓA ĐƠN
        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtTongTien.setText("0");
        txtNgayHD.setText("");
        
        //PHẦN CHITIET
        dsct.removeAll(dsct);
        txtMaSP.setText("");
        txtCTTenSP.setText("");
        txtCTSL.setText("");
        txtCTGia.setText("");
        imgSP.setIcon(null);
        
        model.getDataVector().removeAllElements(); //Xóa trằng table
    }
    public void reset()
    {
        btnNewHD.setVisible(true);
        btnConfirm.setVisible(false);
        btnDeleteHD.setVisible(false);
        clear();
        blockHD(true);

        chiTietView.setVisible(false);
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
            // Lấy data và gắn lên TextField vs Hình
            SuggestSanPham rm = new SuggestSanPham(txtMaSP.getText());
            String[] s = rm.getTextFieldContent().split("%");
            txtMaSP.setText(s[0]);
            txtCTTenSP.setText(s[1]);
            txtCTGia.setText(s[2]);
            Image newImage ;
            try{
                newImage = new ImageIcon("./src/image/SanPham/"+s[3]).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
            }catch(NullPointerException E)
            {
                newImage = new ImageIcon("./src/image/SanPham/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT); 
            }
            imgSP.setIcon(new ImageIcon(newImage));
            
            //Chỉnh Focus vào txtCTSL
            txtCTSL.requestFocus();
        }
        if(e.getSource().equals(btnAddCT)) // Thêm Sản Phẩm
        {
            int sl = 0;
            try{
                sl = Integer.parseInt(txtCTSL.getText()); 
            }catch(NumberFormatException E)
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
                return;
            }
            // Kiểm tra số lượng
            if(!spBUS.updateSL(txtMaSP.getText(), sl))
            {
                return;
            }
            int gia = Integer.parseInt(txtCTGia.getText());
            System.out.println(sl);
            
            //Kiểm tra đã có trong giỏ chưa
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
        
        if(e.getSource().equals(btnNewHD))  // Tạo hóa đơn
        {
            Date date = Timestamp.valueOf(LocalDateTime.now());
            if(txtMaHD.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hóa đơn");
                txtMaHD.requestFocus();
                return;
            }
            else if(hdBUS.check(txtMaHD.getText()))
            {
                JOptionPane.showMessageDialog(null, "Mã hóa đơn đă tồn tại");
                txtMaHD.requestFocus();
                return;
            }
            System.out.println(txtMaNV.getText());
            System.out.println(nvBUS.getList().size());
            if(txtMaNV.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên");
                txtMaNV.requestFocus();
                return;
            }
            else if(!nvBUS.check(txtMaNV.getText()))
            {
                JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại");
                txtMaNV.requestFocus();
                return;
            }
            txtNgayHD.setText(date.toString());
            blockHD(false);
            btnNewHD.setVisible(false);
            btnConfirm.setVisible(true);
            btnDeleteHD.setVisible(true);
            chiTietView.setVisible(true);
            
            txtMaSP.requestFocus();
        }
        if(e.getSource().equals(btnDeleteHD)) //Xóa HD 
        {
            reset();
        }
        if(e.getSource().equals(btnConfirm)) //Xác nhận
        {
            if(dsct.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập sản phẩm");
                return;
            }
            String maHD = txtMaHD.getText();
            String maKH = txtMaKH.getText();
            String maNV = txtMaNV.getText();
            String ngayHD = txtNgayHD.getText();
            int tongTien = Integer.parseInt(txtTongTien.getText());
            HoaDonDTO hd = new HoaDonDTO(maHD, maKH, maNV, ngayHD, tongTien);
            hdBUS.add(hd);
            for(ChiTietHDDTO ct : dsct)
            {
                ctBUS.add(ct);
            }
            
            reset();
        }
        if(e.getSource().equals(btnEdit)) //Sửa sl trong Chitiet sp
        {
            
        }
        if(e.getSource().equals(btnRemove)) // Xóa SP trong CT SP
        {
            try
            {
                int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                dsct.remove(i);
                model.removeRow(i);
                txtTongTien.setText(String.valueOf(sumHD()));
            }catch(Exception ex){}
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Object a = e.getSource();
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(a.equals(txtMaHD) || a.equals(txtMaKH) || a.equals(txtMaNV)) //Enter TXT ở Hóa Đơn
            {
                btnNewHD.doClick();
            }
            else if(a.equals(txtMaSP)) //Enter MASP
            {
                try
                {
                    SanPhamDTO sp = spBUS.getSP(txtMaSP.getText());
                    Image img = new ImageIcon("./src/image/SanPham/"+sp.getImg()).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                    imgSP.setIcon(new ImageIcon(img));
                    txtCTTenSP.setText(sp.getTenSP());
                    txtCTGia.setText(String.valueOf(sp.getGia()));
                }catch(NullPointerException ex)
                {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại !!");
                }
            }
            else if(a.equals(txtCTSL)) //Enter SL
            {
                btnAddCT.doClick();
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
