/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.NhaCungCapDTO;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class NhaCungCapGUI extends JPanel{        
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JTable tbl;
    private JTextField txtMaNCC,txtTenNCC,txtDiaChi,txtDienThoai,txtSoFax;
    private JTextField sortMaNCC,sortTenNCC;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
    public NhaCungCapGUI (int width)
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
        JLabel lbMaNCC = new JLabel("Mă NCC");
        txtMaNCC = new JTextField("");
        lbMaNCC.setBounds(new Rectangle(50,0,200,30));
        lbMaNCC.setFont(font0);
        txtMaNCC.setBounds(new Rectangle(150,0,220,30));
        
        JLabel lbTenNCC = new JLabel("Tên NCC");
        txtTenNCC = new JTextField("");
        lbTenNCC.setBounds(new Rectangle(50,50,200,30));
        lbTenNCC.setFont(font0);
        txtTenNCC.setBounds(new Rectangle(150,50,220,30));
     
        JLabel lbDiaChi = new JLabel("Địa chỉ");
        txtDiaChi = new JTextField("");
        lbDiaChi.setBounds(new Rectangle(50,100,200,30));
        lbDiaChi.setFont(font0);
        txtDiaChi.setBounds(new Rectangle(150,100,220,30));
        
        JLabel lbDienThoai = new JLabel("Số Điện thoại");
        txtDienThoai = new JTextField("");
        lbDienThoai.setBounds(new Rectangle(50,150,200,30));
        lbDienThoai.setFont(font0);
        txtDienThoai.setBounds(new Rectangle(150,150,220,30));
       
        JLabel lbSoFax = new JLabel("Số Fax");
        txtSoFax = new JTextField("");
        lbSoFax.setBounds(new Rectangle(50,200,200,30));
        lbSoFax.setFont(font0);
        txtSoFax.setBounds(new Rectangle(150,200,220,30));
        
        // THÊM VÀO PHẦN HIỂN THỊ
        itemView.add(lbMaNCC);
        itemView.add(txtMaNCC);
        itemView.add(lbTenNCC);
        itemView.add(txtTenNCC);
        itemView.add(lbDiaChi);
        itemView.add(txtDiaChi);
        itemView.add(lbDienThoai);
        itemView.add(txtDienThoai);
        itemView.add(lbSoFax);
        itemView.add(txtSoFax);
        
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
        
        
        
        JLabel btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(700,10,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(700,110,200,50));
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
                    nccBUS.deleteNCC(txtMaNCC.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, nccBUS.getList());
                }
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                
                if(txtMaNCC.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                
                
                txtMaNCC.setEditable(false);
                
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
                        String maNCC = txtMaNCC.getText();
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String dienThoai = txtDienThoai.getText();
                        String soFax = txtSoFax.getText();
                        if(nccBUS.checkMancc(maNCC))
                        {
                            JOptionPane.showMessageDialog(null, "Mã nhân viên đă tồn tại !!!");
                            return;
                        }
                        //Upload sản phẩm lên DAO và BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai, soFax);
                        nccBUS.addNCC(ncc);

                        outModel(model, nccBUS.getList());// Load lại table

//                        saveIMG();// Lưu hình ảnh 

                        cleanView();
                    }
                }
                else    // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String maNCC = txtMaNCC.getText();
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String dienThoai = txtDienThoai.getText();
                        String soFax = txtSoFax.getText();

                        //Upload sản phẩm lên DAO và BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai, soFax);
                        nccBUS.setNCC(ncc);
                        
                        outModel(model, nccBUS.getList());// Load lại table
                        
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
        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Số Fax");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        listNCC(); //Đọc từ database lên table 
        
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
                txtMaNCC.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtTenNCC.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtDiaChi.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtDienThoai.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtSoFax.setText( tbl.getModel().getValueAt(i, 4).toString());        
             }
        });
        
        
/*********************** SORT TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,300,this.DEFALUT_WIDTH - 400,140);
        
        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------ TÌM KIẾM THÔNG TIN ------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 78 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);
        
        /******** SORT MANCC **************/
        JLabel lbSortMaNCC = new JLabel("Mă NCC :");
        lbSortMaNCC.setFont(font0);
        lbSortMaNCC.setBounds(0,40,60,30);
        sort.add(lbSortMaNCC);
        
        sortMaNCC = new JTextField();
        sortMaNCC.setBounds(new Rectangle(60,42,100,30));
        sort.add(sortMaNCC);
        /*************************************/
        
        /******** SORT TENNCC **************/
        JLabel lbSortTenNCC = new JLabel("Tên NCC :");
        lbSortTenNCC.setFont(font0);
        lbSortTenNCC.setBounds(200,40,60,30);
        sort.add(lbSortTenNCC);
        
        sortTenNCC = new JTextField();
        sortTenNCC.setBounds(new Rectangle(260,42,100,30));
        sort.add(sortTenNCC);
        /*************************************/
        
//        /******** SORT TENKH **************/
//        JLabel lbSortTenKH = new JLabel("Tên KH :");
//        lbSortTenKH.setFont(font0);
//        lbSortTenKH.setBounds(400,40,60,30);
//        sort.add(lbSortTenKH);
//        
//        sortTenKH = new JTextField();
//        sortTenKH.setBounds(new Rectangle(460,42,200,30));
//        sort.add(sortTenKH);
        /*************************************/
        
        add(sort);
/******************************************************************/
    }
    public void cleanView() //Xóa trắng các TextField
    {
        txtMaNCC.setEditable(true);

        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
        txtSoFax.setText("");
        
        
    }
    public void outModel(DefaultTableModel model , ArrayList<NhaCungCapDTO> ncc) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(NhaCungCapDTO n:ncc)
        {
            data = new Vector();
            data.add(n.getMaNCC());
            data.add(n.getTenNCC());
            data.add(n.getDiaChi());
            data.add(n.getDienThoai());
            data.add(n.getSoFax());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void listNCC() // Chép ArrayList lên table
    {
        if(nccBUS.getList()== null)nccBUS.listNCC();
        ArrayList<NhaCungCapDTO> ncc = nccBUS.getList();
//        model.setRowCount(0);
        outModel(model,ncc);
    }
}

