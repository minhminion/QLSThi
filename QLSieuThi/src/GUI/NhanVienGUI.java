/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class NhanVienGUI extends JPanel{
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtMaNV,txtHoNV,txtTenNV,txtNamSinh,txtPhai,txtMucLuong,txtDiaChi,txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JTextField sortMaNV;
    private JTextField sortHoNV;
    private JTextField sortTenNV;
    private Choice sortPhai;
    public NhanVienGUI(int width)
    {
        DEFALUT_WIDTH = width;
        try {
            init();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void init() throws ClassNotFoundException, SQLException
    {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/****************************** PHẦN HIỂN THỊ THÔNG TIN ******************************************/

        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 20, this.DEFALUT_WIDTH - 220 , 300));
        ItemView.setBackground(Color.WHITE);
        
        /******** Tao Cac Label & TextField ************************/
        JLabel lbMaNV = new JLabel("Mă nhân viên");
        txtMaNV = new JTextField("");
        lbMaNV.setBounds(new Rectangle(300,0,200,30));
        lbMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(400,0,220,30));
        
        JLabel lbHoNV = new JLabel("Họ");
        txtHoNV = new JTextField("");
        lbHoNV.setBounds(new Rectangle(300,50,200,30));
        lbHoNV.setFont(font0);
        txtHoNV.setBounds(new Rectangle(400,50,220,30));
        
        JLabel lbTenNV = new JLabel("Tên nhân viên");
        txtTenNV = new JTextField("");
        lbTenNV.setBounds(new Rectangle(300,100,200,30));
        lbTenNV.setFont(font0);
        txtTenNV.setBounds(new Rectangle(400,100,220,30)); 
  
        JLabel lbMucLuong = new JLabel("Mức lương");
        txtMucLuong = new JTextField("");
        lbMucLuong.setBounds(new Rectangle(300,150,200,30));
        lbMucLuong.setFont(font0);
        txtMucLuong.setBounds(new Rectangle(400,150,220,30));
        
        JLabel lbDiaChi = new JLabel("Địa chỉ");
        txtDiaChi = new JTextField("");
        lbDiaChi.setBounds(new Rectangle(300,200,200,30));
        lbDiaChi.setFont(font0);
        txtDiaChi.setBounds(new Rectangle(400,200,220,30));
        
        JLabel lbNamSinh = new JLabel("Năm sinh");
        txtNamSinh = new JTextField("");
        lbNamSinh.setBounds(new Rectangle(460,250,80,30));
        lbNamSinh.setFont(font0);
        txtNamSinh.setBounds(new Rectangle(540,250,80,30));
        
        JLabel lbPhai = new JLabel("Phái");
        txtPhai= new JTextField("");
        lbPhai.setBounds(new Rectangle(300,250,30,30));
        lbPhai.setFont(font0);
        txtPhai.setBounds(new Rectangle(360,250,80,30));
        
        img = new JLabel("Image");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0,0,270,300));
        
        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbMaNV);
        ItemView.add(txtMaNV);
        ItemView.add(lbHoNV);
        ItemView.add(txtHoNV);
        ItemView.add(lbTenNV);
        ItemView.add(txtTenNV);
        ItemView.add(lbNamSinh);
        ItemView.add(txtNamSinh);
        ItemView.add(lbPhai);
        ItemView.add(txtPhai);
        ItemView.add(lbMucLuong);
        ItemView.add(txtMucLuong);
        ItemView.add(lbDiaChi);
        ItemView.add(txtDiaChi);
        /************************************************************/
        
        /**************** TẠO CÁC BTN THÊM ,XÓA, SỬA ********************/
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(700,10,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(700,110,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(700,210,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);
        
        
        
        JLabel btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(700,10,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(700,110,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnFile = new JLabel(new ImageIcon("./src/image/btnFile.png"));
        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(700,210,200,50));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);
        
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
                btnFile.setVisible(true);
                
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
                    nvBUS.deleteNV(txtMaNV.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, nvBUS.getList());
                }
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                
                if(txtMaNV.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                
                
                txtMaNV.setEditable(false);
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);
                
//                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });
        
        // MouseClick btnFile
        btnFile.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtMaNV.getText().concat(".jpg"); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(270, 300, Image.SCALE_DEFAULT)));
                        
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
                btnFile.setVisible(false);
                
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
                        String maNV = txtMaNV.getText();
                        String hoNV = txtHoNV.getText();
                        String tenNV = txtTenNV.getText();
                        int namSinh = Integer.parseInt(txtNamSinh.getText());
                        String phai = txtPhai.getText();
                        int mucLuong = Integer.parseInt(txtMucLuong.getText());
                        String diaChi = txtDiaChi.getText();
                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        NhanVienDTO sp = new NhanVienDTO(maNV, hoNV, tenNV, namSinh, phai, mucLuong, diaChi, IMG);
                        nvBUS.addNV(sp);

                        outModel(model, nvBUS.getList());// Load lại table

                        saveIMG();// Lưu hình ảnh 

                        cleanView();
                    }
                }
                else    // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String maNV = txtMaNV.getText();
                        String hoNV = txtHoNV.getText();
                        String tenNV = txtTenNV.getText();
                        int namSinh = Integer.parseInt(txtNamSinh.getText());
                        String phai = txtPhai.getText();
                        int mucLuong = Integer.parseInt(txtMucLuong.getText());
                        String diaChi = txtDiaChi.getText();
                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        NhanVienDTO sp = new NhanVienDTO(maNV, hoNV, tenNV, namSinh, phai, mucLuong, diaChi, IMG);
                        nvBUS.setNV(sp);
                        
                        outModel(model, nvBUS.getList());// Load lại table
                        
                        saveIMG();// Lưu hình ảnh 
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
                
            }
        });
        
        /****************************************************************/
        
/**********************************************************************************/
     
/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mă NV");
        header.add("Họ NV");
        header.add("Tên NV");
        header.add("Năm sinh");
        header.add("Phái");
        header.add("Mức lương");
        header.add("Địa chỉ");
        header.add("IMG"); 
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(20);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(100);

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
        scroll.setBounds(new Rectangle(30, 430, this.DEFALUT_WIDTH - 400 , 210));
        scroll.setBackground(null);
        
        add(scroll);
        add(ItemView);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                imgName = tbl.getModel().getValueAt(i, 7).toString();
                Image newImage ;
                try{
                    newImage = new ImageIcon("./src/image/NhanVien/"+imgName).getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT);
                }catch(NullPointerException E)
                {
                    newImage = new ImageIcon("./src/image/NhanVien/NoImage.jpg").getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT); 
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtHoNV.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtTenNV.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtNamSinh.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtPhai.setText( tbl.getModel().getValueAt(i, 4).toString());
                txtMucLuong.setText(tbl.getModel().getValueAt(i, 5).toString()); 
                txtDiaChi.setText(tbl.getModel().getValueAt(i, 6).toString()); 
                img.setText("");
                img.setIcon(new ImageIcon(newImage));
                
             }
        });
        /*********************** PHẦN SEARCH TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,330,this.DEFALUT_WIDTH - 400,100);

        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------ TÌM KIẾM THÔNG TIN ------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 78 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);

        /******** SORT MAKH **************/
        JLabel lbSortMaNV = new JLabel("Mă NV :");
        lbSortMaNV.setFont(font0);
        lbSortMaNV.setBounds(0,40,50,30);
        sort.add(lbSortMaNV);

        sortMaNV = new JTextField();
        sortMaNV.setFont(font0);
        sortMaNV.setBounds(new Rectangle(50,42,100,30));
        sort.add(sortMaNV);
        /*************************************/

        /******** SORT HONV **************/
        JLabel lbSortHoNV = new JLabel("Họ :");
        lbSortHoNV.setFont(font0);
        lbSortHoNV.setBounds(170,40,30,30);
        sort.add(lbSortHoNV);

        sortHoNV = new JTextField();
        sortHoNV.setFont(font0);
        sortHoNV.setBounds(new Rectangle(200,42,100,30));
        sort.add(sortHoNV);
        /*************************************/
        
        /******** SORT TEN NV **************/
        JLabel lbSortTenNV = new JLabel("Tên :");
        lbSortTenNV.setFont(font0);
        lbSortTenNV.setBounds(320,40,30,30);
        sort.add(lbSortTenNV);

        sortTenNV = new JTextField();
        sortTenNV.setFont(font0);
        sortTenNV.setBounds(new Rectangle(350,42,100,30));
        sort.add(sortTenNV);
        /*************************************/
        /************ SORT PHÁI **************/
        JLabel lbSortPhai = new JLabel("Phái :");
        lbSortPhai.setFont(font0);
        lbSortPhai.setBounds(470,40,35,30);
        sort.add(lbSortPhai);
        
        sortPhai = new Choice();
        sortPhai.addItem("Tất cả");
        sortPhai.addItem("Nam");
        sortPhai.addItem("Nữ");
        sortPhai.setFont(font0);
        sortPhai.setBounds(new Rectangle(505,43,100,30));
        sort.add(sortPhai);
        /*************************************/
        /******************************************/

        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_200px.png"));
        btnSearch.setBounds(new Rectangle(840,30,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
               System.out.println(sortPhai.getSelectedItem());
               System.out.println(sortPhai.getSelectedIndex());
               String manv = sortMaNV.getText();
               String ho = sortHoNV.getText();
               String ten = sortTenNV.getText();
               String phai = sortPhai.getSelectedIndex()!= 0 ? sortPhai.getSelectedItem() : "";
               
               outModel(model, nvBUS.searchNV(manv, ho, ten, phai));
           }
        });
        sort.add(btnSearch);
        
        add(sort);
/*******************************************************************/
    }
    public void saveIMG()
    {
        try {
            if(i != null)
            {
                File save = new File("src/image/NhanVien/"+ imgName);// Tạo file
                ImageIO.write(i,"jpg",save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cleanView() //Xóa trắng các TextField
    {
        txtMaNV.setEditable(true);

        txtMaNV.setText("");
        txtHoNV.setText("");
        txtTenNV.setText("");
        txtNamSinh.setText("");
        txtPhai.setText("");
        txtMucLuong.setText("");
        txtDiaChi.setText("");
        
        img.setIcon(null);
        img.setText("Image");
        
        imgName = "null";
    }
    public void outModel(DefaultTableModel model , ArrayList<NhanVienDTO> nv) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(NhanVienDTO n:nv)
        {
            data = new Vector();
            data.add(n.getMaNV());
            data.add(n.getHoNV());
            data.add(n.getTenNV());
            data.add(n.getNamSinh());
            data.add(n.getPhai());
            data.add(n.getMucLuong());
            data.add(n.getDiaChi());
            data.add(n.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void listSP() // Chép ArrayList lên table
    {
        if(nvBUS.getList()== null)nvBUS.listNV();
        ArrayList<NhanVienDTO> nv = nvBUS.getList();
//        model.setRowCount(0);
        outModel(model,nv);
    }
}
