/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shadow
 */
public class KhachHangGUI extends JPanel{        
    private KhachHangBUS khBUS = new KhachHangBUS();
    
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
        itemView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 220 , 170));
        itemView.setBackground(null);
        
        /******** Tao Cac Label & TextField ************************/
        JLabel lbMaKH = new JLabel("Mă khách hàng");
        txtMaKH = new JTextField("");
        lbMaKH.setBounds(new Rectangle(50,0,200,30));
        lbMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(150,0,220,30));
        
        JLabel lbHoKH = new JLabel("Họ");
        txtHoKH = new JTextField("");
        lbHoKH.setBounds(new Rectangle(50,40,200,30));
        lbHoKH.setFont(font0);
        txtHoKH.setBounds(new Rectangle(150,40,220,30));
     
        JLabel lbTenKH = new JLabel("Tên");
        txtTenKH = new JTextField("");
        lbTenKH.setBounds(new Rectangle(50,80,200,30));
        lbTenKH.setFont(font0);
        txtTenKH.setBounds(new Rectangle(150,80,220,30));
        
        JLabel lbDiaChi = new JLabel("Địa chỉ");
        txtDiaChi = new JTextField("");
        lbDiaChi.setBounds(new Rectangle(400,0,100,30));
        lbDiaChi.setFont(font0);
        txtDiaChi.setBounds(new Rectangle(500,0,220,30));
       
        JLabel lbSDT = new JLabel("Số điện thoại");
        txtSDT = new JTextField("");
        lbSDT.setBounds(new Rectangle(400,40,200,30));
        lbSDT.setFont(font0);
        txtSDT.setBounds(new Rectangle(500,40,220,30));
        
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
        btnAdd.setBounds(new Rectangle(750,0,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(750,55,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(750,110,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        
        
        
        JLabel btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(750,10,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(750,55,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
        
        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                EditOrAdd = true;
                
                cleanView();
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
//                btnFile.setVisible(true);
                
                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });
        
        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {   
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    khBUS.delete(txtMaKH.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, khBUS.getList());
                }
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                
                if(txtMaKH.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                
                
                txtMaKH.setEditable(false);
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
//                btnFile.setVisible(true);
                
//                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });
        
        
        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                cleanView();
                
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
//                btnFile.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        
        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i;
                if(EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String maKH = txtMaKH.getText();
                        String hoKH = txtHoKH.getText();
                        String tenKH = txtTenKH.getText();
                        String diaChi = txtDiaChi.getText();
                        int dienThoai = Integer.parseInt(txtSDT.getText());
                        if(khBUS.check(maKH))
                        {
                            JOptionPane.showMessageDialog(null, "Mã nhân viên đă tồn tại !!!");
                            return;
                        }
                        //Upload sản phẩm lên DAO và BUS
                        KhachHangDTO ncc = new KhachHangDTO(maKH, hoKH, tenKH, diaChi, dienThoai);
                        khBUS.add(ncc);

                        outModel(model, khBUS.getList());// Load lại table

//                        saveIMG();// Lưu hình ảnh 

                        cleanView();
                    }
                }
                else    // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa Khách hàng","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String maKH = txtMaKH.getText();
                        String hoKH = txtHoKH.getText();
                        String tenKH = txtTenKH.getText();
                        String diaChi = txtDiaChi.getText();
                        int sdt = Integer.parseInt(txtSDT.getText());

                        //Upload sản phẩm lên DAO và BUS
                        KhachHangDTO kh = new KhachHangDTO(maKH, hoKH, tenKH, diaChi, sdt);
                        khBUS.set(kh);
                        
                        outModel(model, khBUS.getList());// Load lại table
                        
//                        saveIMG();// Lưu hình ảnh 
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
                
            }
        });
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
        list(); //Đọc từ database lên table 
        
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
        scroll.setBounds(new Rectangle(30, 300, this.DEFALUT_WIDTH - 400 , 360));
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
/*********************** SORT TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,200,this.DEFALUT_WIDTH - 400,140);
        
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
    public void cleanView() //Xóa trắng các TextField
    {
        txtMaKH.setEditable(true);

        txtMaKH.setText("");
        txtHoKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        
    }
    public void outModel(DefaultTableModel model , ArrayList<KhachHangDTO> nv) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(KhachHangDTO n:nv)
        {
            data = new Vector();
            data.add(n.getMaKH());
            data.add(n.getHoKH());
            data.add(n.getTenKH());
            data.add(n.getDiaChi());
            data.add(n.getSdt());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void list() // Chép ArrayList lên table
    {
        if(khBUS.getList()== null)khBUS.list();
        ArrayList<KhachHangDTO> nv = khBUS.getList();
//        model.setRowCount(0);
        outModel(model,nv);
    }
}

