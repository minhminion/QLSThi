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
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class SanPhamGUI extends JPanel{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtId,txtHoNV,txtSl,txtGia,txtDVT,txtNSX,txtLoai,txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JTextField sortTenSP;
    private JTextField txtMaxPrice;
    private JTextField sortMaSP;
    private JTextField txtMinPrice;
    
    //        

    public SanPhamGUI(int width)
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
                txtId.setFont(font0);

        JLabel lbName = new JLabel("Tên Sản Phẩm");
        txtHoNV = new JTextField("");
        lbName.setBounds(new Rectangle(300,50,200,30));
        lbName.setFont(font0);
        txtHoNV.setBounds(new Rectangle(400,50,220,30));
        txtHoNV.setFont(font0);

        JLabel lbSl = new JLabel("Số lượng");
        txtSl = new JTextField("");
        lbSl.setBounds(new Rectangle(300,100,200,30));
        lbSl.setFont(font0);
        txtSl.setBounds(new Rectangle(400,100,220,30));
        txtSl.setFont(font0);

        JLabel lbGia = new JLabel("Đơn giá (VNĐ)");
        txtGia = new JTextField("");
        lbGia.setBounds(new Rectangle(300,150,200,30));
        lbGia.setFont(font0);
        txtGia.setBounds(new Rectangle(400,150,220,30));
        txtGia.setFont(font0);

        JLabel lbDVT = new JLabel("Đơn Vị Tính");
        txtDVT= new JTextField("");
        lbDVT.setBounds(new Rectangle(300,200,200,30));
        lbDVT.setFont(font0);
        txtDVT.setBounds(new Rectangle(400,200,220,30));
        txtDVT.setFont(font0);

        JLabel lbNSX = new JLabel("Mă NSX");
        txtNSX = new JTextField("");
        lbNSX.setBounds(new Rectangle(300,250,50,30));
        lbNSX.setFont(font0);
        txtNSX.setBounds(new Rectangle(370,250,80,30));
        txtNSX.setFont(font0);

        JLabel lbLoai = new JLabel("Mă Loại");
        txtLoai = new JTextField("");
        lbLoai.setBounds(new Rectangle(470,250,50,30));
        lbLoai.setFont(font0);
        txtLoai.setBounds(new Rectangle(540,250,80,30));
        txtLoai.setFont(font0);
        
        img = new JLabel("Image");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0,0,270,300));
        
        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbName);
        ItemView.add(txtHoNV);
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
        
        
        
        JLabel btnCofirm= new JLabel(new ImageIcon("./src/image/btnCofirm.png"));
        btnCofirm.setVisible(false);
        btnCofirm.setBounds(new Rectangle(700,10,200,50));
        btnCofirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(700,110,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnFile = new JLabel(new ImageIcon("./src/image/btnFile.png"));
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
                EditOrAdd = true;
                
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
                if(txtId.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                
                
                txtId.setEditable(false);
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnCofirm.setVisible(true);
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
                        imgName = txtId.getText().concat(".jpg"); //Tên hình
                        
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
                int i;
                if(EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        String maSP = txtId.getText();
                        String tenSP = txtHoNV.getText();
                        int sl = Integer.parseInt(txtSl.getText());
                        int gia = Integer.parseInt(txtGia.getText());
                        String DVT = txtDVT.getText();
                        String maLoai = txtLoai.getText();
                        String maNsx = txtNSX.getText();
                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, DVT, maLoai, maNsx, IMG, sl, gia);
                        spBUS.addSP(sp);

                        outModel(model, spBUS.getDssp());// Load lại table

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
                        String maSP = txtId.getText();
                        String tenSP = txtHoNV.getText();
                        int sl = Integer.parseInt(txtSl.getText());
                        int gia = Integer.parseInt(txtGia.getText());
                        String DVT = txtDVT.getText();
                        String maLoai = txtLoai.getText();
                        String maNsx = txtNSX.getText();
                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, DVT, maLoai, maNsx, IMG, sl, gia);
                        spBUS.setSP(sp);
                        
                        outModel(model, spBUS.getDssp());// Load lại table
                        
                        saveIMG();// Lưu hình ảnh 
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
                
            }

            private void outModel(DefaultTableModel model, ArrayList<SanPhamDTO> dssp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void saveIMG() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        /****************************************************************/
        
/**********************************************************************************/
/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Số lượng");
        header.add("Đơn Giá");
        header.add("Đơn Vị Tính");
        header.add("Loại");
        header.add("Mă NSX");
        header.add("IMG"); 
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(140);
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
                imgName = tbl.getModel().getValueAt(i, 7).toString();
                Image newImage ;
                try{
                    newImage = new ImageIcon("./src/image/SanPham/"+imgName).getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT);
                }catch(NullPointerException E)
                {
                    newImage = new ImageIcon("./src/image/SanPham/NoImage.jpg").getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT); 
                }
                txtId.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtHoNV.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtSl.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtGia.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtDVT.setText( tbl.getModel().getValueAt(i, 4).toString());
                txtLoai.setText(tbl.getModel().getValueAt(i, 5).toString()); 
                txtNSX.setText(tbl.getModel().getValueAt(i, 6).toString()); 
                img.setText("");
                img.setIcon(new ImageIcon(newImage));
                
             }
        });
/*********************** SEARCH TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,350,this.DEFALUT_WIDTH - 400,100);

        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------ TÌM KIẾM THÔNG TIN ------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 78 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);

        /******** SORT MAKH **************/
        JLabel lbSortMaSP = new JLabel("Mă SP :");
        lbSortMaSP.setFont(font0);
        lbSortMaSP.setBounds(0,40,60,30);
        sort.add(lbSortMaSP);

        sortMaSP = new JTextField();
        sortMaSP.setBounds(new Rectangle(60,42,100,30));
        sort.add(sortMaSP);
        sortMaSP.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = sortMaSP.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text, 0));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = sortMaSP.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,0));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        /*************************************/

        /************ SORT THEO GIÁ ***************/
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(180,40,80,30);
        sort.add(sortPrice);

        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(260,42,100,26));
        sort.add(txtMinPrice);

        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(370, 56, 10, 6);
        sort.add(sepPrice);

        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(390,42,100,26));
        sort.add(txtMaxPrice);

        /******************************************/

        /******** SORT TENSP **************/
        JLabel lbSortTenSP = new JLabel("Tên SP :");
        lbSortTenSP.setFont(font0);
        lbSortTenSP.setBounds(510,40,50,30);
        sort.add(lbSortTenSP);

        sortTenSP = new JTextField();
        sortTenSP.setBounds(new Rectangle(570,42,240,30));
        sort.add(sortTenSP);
        sortTenSP.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = sortTenSP.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text, 1));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = sortTenSP.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        /*************************************/

        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_200px.png"));
        btnSearch.setBounds(new Rectangle(820,30,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sort.add(btnSearch);

        add(sort);
/*******************************************************************/

    }

    public void saveIMG()
    {
        try {
            if(i != null)
            {
                File save = new File("src/image/SanPham/"+ imgName);//Ta5o file
                ImageIO.write(i,"jpg",save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cleanView() //Xóa trắng các TextField
    {
        txtId.setEditable(true);

        txtId.setText("");
        txtHoNV.setText("");
        txtSl.setText("");
        txtGia.setText("");
        txtDVT.setText("");
        txtNSX.setText("");
        txtLoai.setText("");
        
        img.setIcon(null);
        img.setText("Image");
        
        imgName = "null";
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
