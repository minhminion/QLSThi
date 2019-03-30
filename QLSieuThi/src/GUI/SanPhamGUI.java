/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DTO.SanPhamDTO;
import BUS.SanPhamBUS;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Shadow
 */
public class SanPhamGUI extends JPanel{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private JTable tbl;
    private JLabel img;
    private JTextField txtId,txtName,txtSl,txtGia,txtDVT,txtNSX,txtLoai,txtSearch;
    private String imgName;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    
    //        

    public SanPhamGUI(int width)
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
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/****************************** PHẦN HIỂN THỊ THÔNG TIN ******************************************/

        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 220 , 300));
        ItemView.setBackground(Color.WHITE);
        
        /******** Tao Cac Label & TextField ************************/
        JLabel lbId = new JLabel("Mă Sản Phẩm");
        txtId = new JTextField("");
        lbId.setBounds(new Rectangle(300,0,200,30));
        lbId.setFont(font0);
        txtId.setBounds(new Rectangle(400,0,220,30));
        
        JLabel lbName = new JLabel("Tên Sản Phẩm");
        txtName = new JTextField("");
        lbName.setBounds(new Rectangle(300,50,200,30));
        lbName.setFont(font0);
        txtName.setBounds(new Rectangle(400,50,220,30));
        
        JLabel lbSl = new JLabel("Số lượng");
        txtSl = new JTextField("");
        lbSl.setBounds(new Rectangle(300,100,200,30));
        lbSl.setFont(font0);
        txtSl.setBounds(new Rectangle(400,100,220,30));
        
        JLabel lbGia = new JLabel("Đơn giá (VNĐ)");
        txtGia = new JTextField("");
        lbGia.setBounds(new Rectangle(300,150,200,30));
        lbGia.setFont(font0);
        txtGia.setBounds(new Rectangle(400,150,220,30));
        
        JLabel lbDVT = new JLabel("Đơn Vị Tính");
        txtDVT= new JTextField("");
        lbDVT.setBounds(new Rectangle(300,200,200,30));
        lbDVT.setFont(font0);
        txtDVT.setBounds(new Rectangle(400,200,220,30));
  
        JLabel lbNSX = new JLabel("Mă NSX");
        txtNSX = new JTextField("");
        lbNSX.setBounds(new Rectangle(300,250,50,30));
        lbNSX.setFont(font0);
        txtNSX.setBounds(new Rectangle(370,250,80,30));
        
        JLabel lbLoai = new JLabel("Mă Loại");
        txtLoai = new JTextField("");
        lbLoai.setBounds(new Rectangle(470,250,50,30));
        lbLoai.setFont(font0);
        txtLoai.setBounds(new Rectangle(540,250,80,30));
        
        img = new JLabel("Image");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0,0,250,300));
        
        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbName);
        ItemView.add(txtName);
        ItemView.add(lbSl);
        ItemView.add(txtSl);
        ItemView.add(lbGia);
        ItemView.add(txtGia);
        ItemView.add(lbDVT);
        ItemView.add(txtDVT);
        ItemView.add(lbNSX);
        ItemView.add(txtNSX);
        ItemView.add(lbLoai);
        ItemView.add(txtLoai);
        /************************************************************/
        
        /**************** TẠO CÁC BTN THÊM ,XÓA, SỬA ********************/
        JLabel btnAdd = new JLabel(new ImageIcon(getClass().getResource("/image/btnAdd.png")));
        btnAdd.setBounds(new Rectangle(700,10,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        JLabel btnEdit = new JLabel(new ImageIcon(getClass().getResource("/image/btnEdit.png")));
        btnEdit.setBounds(new Rectangle(700,110,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        JLabel btnDelete = new JLabel(new ImageIcon(getClass().getResource("/image/btnDelete.png")));
        btnDelete.setBounds(new Rectangle(700,210,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);
        
        
        
        JLabel btnCofirm= new JLabel(new ImageIcon(getClass().getResource("/image/btnCofirm.png")));
        btnCofirm.setVisible(false);
        btnCofirm.setBounds(new Rectangle(700,10,200,50));
        btnCofirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon(getClass().getResource("/image/btnBack.png")));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(700,110,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnFile = new JLabel(new ImageIcon(getClass().getResource("/image/btnFile.png")));
        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(700,210,200,50));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ItemView.add(btnCofirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);
        
        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                cleanView();
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnCofirm.setVisible(true);
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
                    spBUS.deleteSP(txtId.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, spBUS.getDssp());
                }
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null,"Sửa");
            }
        });
        
        //MouseClick btnFile
        btnFile.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        BufferedImage i = ImageIO.read(file); // Lấy hình
                        imgName = file.getName(); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(230, 250, Image.SCALE_DEFAULT)));

                        URL saveURL = getClass().getResource("/image/SanPham"); //Lấy URL Project (../build/classes/image/SanPham)
  
                        File save = new File(saveURL.getPath()+"\\"+imgName); //Tạo File
                        ImageIO.write(i,"jpg",save); // Lưu hình i vào đường dẫn file save

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
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                
                btnCofirm.setVisible(false);
                btnBack.setVisible(false);
                btnFile.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        
        //MouseClick btnCofirm
        btnCofirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm","",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    String maSP = txtId.getText();
                    String tenSP = txtName.getText();
                    int sl = Integer.parseInt(txtSl.getText());
                    int gia = Integer.parseInt(txtGia.getText());
                    String DVT = txtDVT.getText();
                    String maLoai = txtLoai.getText();
                    String maNsx = txtNSX.getText();
                    String IMG = imgName;
                    SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, DVT, maLoai, maNsx, IMG, sl, gia);
                    spBUS.addSP(sp);
                    outModel(model, spBUS.getDssp());
                }
            }
        });
        
        /****************************************************************/
        
/**********************************************************************************/

/********************* THANH SEARCH ***********************************************/
        
        // Tạo Search Box
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(30, 350,450, 30)); 
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền 
        
        //Phần TextField 
        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(5,0,400,30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));
        
        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon(getClass().getResource("/image/search_25px.png")));
        searchIcon.setBounds(new Rectangle(400,-9,50,50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add tất cả vào search box
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) 
            {
                searchIcon.setIcon(new ImageIcon(getClass().getResource("/image/search_25px_focus.png"))); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52,152,219))); // Đổi màu viền 
            }
            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon(getClass().getResource("/image/search_25px.png")));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        
        // Khi nhấn phím ở search box
        txtSearch.addKeyListener(new KeyAdapter (){
            public void keyPressed(KeyEvent e) 
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) //Khi nhất Enter
                {
//                    txtSearchKeyPressed();
                }
            }
        } ); 
        add(searchBox);
        
/**********************************************************************************************/
        
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        
/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Số lượng");
        header.add("Đơn Giá");
        header.add("Đơn Vị Tính");
        header.add("Mă NSX");
        header.add("Loại");
        header.add("IMG"); 
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(40);

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
        add(ItemView);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                //System.out.println(i);
                Image newImage = new ImageIcon(getClass().getResource("/image/SanPham/"+tbl.getModel().getValueAt(i, 7))).getImage().getScaledInstance(230, 250, Image.SCALE_DEFAULT);
                txtId.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtName.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtSl.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtGia.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtDVT.setText( tbl.getModel().getValueAt(i, 4).toString());
                txtNSX.setText(tbl.getModel().getValueAt(i, 5).toString()); 
                txtLoai.setText(tbl.getModel().getValueAt(i, 6).toString()); 
                img.setText("");
                img.setIcon(new ImageIcon(newImage));
             }
        });
    }
/*
    public void txtSearchKeyPressed()
    {
        ArrayList<SanPham> Sdata = new ArrayList<>();
        String s = txtSearch.getText();
//        System.out.println(tbl.getModel().getRowCount());
        DefaultTableModel m = new DefaultTableModel();
        m = (DefaultTableModel) tbl.getModel();
        m.setRowCount(0);
        if(s.isEmpty())
        {
            outModel(m,sp);
            return;
        }
        
        for(SanPhamDTO sp:sp)
        {
            String info = sp.getName();
            //System.out.println(sp.getName());
            //System.out.println(s.indexOf(sp.getName()));
            if(info.indexOf(s) >= 0)
            {
                Sdata.add(sp);
                System.out.println(sp.getName());
            }
        }

        outModel(m,Sdata);
    }
*/
    public void cleanView() //Xóa trắng các TextField
    {
        txtId.setText("");
        txtName.setText("");
        txtSl.setText("");
        txtGia.setText("");
        txtDVT.setText("");
        txtNSX.setText("");
        txtLoai.setText("");
        
        img.setIcon(null);
        img.setText("Image");
    }
    public void outModel(DefaultTableModel model , ArrayList<SanPhamDTO> sp) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(SanPhamDTO s:sp)
        {
            data = new Vector();
            data.add(s.getMaSP());
            data.add(s.getTenSP());
            data.add(s.getSl());
            data.add(s.getGia());
            data.add(s.getDvt());
            data.add(s.getMaLoai());
            data.add(s.getMaNsx());
            data.add(s.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void listSP() // Chép ArrayList lên table
    {
        if(spBUS.getDssp()== null)spBUS.listSP();
        ArrayList<SanPhamDTO> sp = spBUS.getDssp();
        model.setRowCount(0);
        outModel(model,sp);
    }
}
