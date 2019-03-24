/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import qlsieuthi.MySQLConnection;
import qlsieuthi.SanPham;

/**
 *
 * @author Shadow
 */
public class QLSP1 extends JPanel{
    private JTable tbl;
    private JTextField txtSearch;
    private ArrayList<SanPham> sp = new ArrayList<>();
    private int DEFALUT_WIDTH;
    //        

    public QLSP1(int width)
    {
        DEFALUT_WIDTH = width;
        try {
            init();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSP1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void init() throws ClassNotFoundException, SQLException
    {
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        /**************************************************/
        //Tao Cac Label & TextField
        JLabel lbId = new JLabel("Mă Sản Phẩm");
        JTextField txtId = new JTextField("");
        lbId.setBounds(new Rectangle(300,0,200,30));
        lbId.setFont(font0);
        txtId.setBounds(new Rectangle(400,0,220,30));
        
        JLabel lbNSX = new JLabel("Mă NSX");
        JTextField txtNSX = new JTextField("");
        lbNSX.setBounds(new Rectangle(300,50,200,30));
        lbNSX.setFont(font0);
        txtNSX.setBounds(new Rectangle(400,50,220,30));
        
        JLabel lbName = new JLabel("Tên Sản Phẩm");
        JTextField txtName = new JTextField("");
        lbName.setBounds(new Rectangle(300,100,200,30));
        lbName.setFont(font0);
        txtName.setBounds(new Rectangle(400,100,220,30));
        
        JLabel lbLoai = new JLabel("Loại");
        JTextField txtLoai = new JTextField("");
        lbLoai.setBounds(new Rectangle(300,150,200,30));
        lbLoai.setFont(font0);
        txtLoai.setBounds(new Rectangle(400,150,220,30));
        
        JLabel lbPrice = new JLabel("Đơn Giá (VNĐ)");
        JTextField txtPrice= new JTextField("");
        lbPrice.setBounds(new Rectangle(300,200,200,30));
        lbPrice.setFont(font0);
        txtPrice.setBounds(new Rectangle(400,200,220,30));
  
        JLabel lbDV = new JLabel("Đơn Vị Tính");
        JTextField txtDV = new JTextField("");
        lbDV.setBounds(new Rectangle(300,250,200,30));
        lbDV.setFont(font0);
        txtDV.setBounds(new Rectangle(400,250,220,30));
        
        JLabel a = new JLabel("Image");
        a.setBorder(createLineBorder(Color.BLACK));
        a.setBounds(new Rectangle(0,0,250,300));
        /************************************************************/
        
        /**********************************************/
//        Image newImage = new ImageIcon(getClass().getResource("/image/Asset 1.png").getImage().getScaledInstance(230, 250, Image.SCALE_DEFAULT);
        JLabel btnAdd = new JLabel(new ImageIcon(getClass().getResource("/image/btnAdd.png")));
        btnAdd.setBounds(new Rectangle(700,10,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null,"Thêm");
            }
        });
        
        JLabel btnEdit = new JLabel(new ImageIcon(getClass().getResource("/image/btnEdit.png")));
        btnEdit.setBounds(new Rectangle(700,110,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null,"Sửa");
            }
        });
        
        JLabel btnDelete = new JLabel(new ImageIcon(getClass().getResource("/image/btnDelete.png")));
        btnDelete.setBounds(new Rectangle(700,210,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null,"Xóa");
            }
        });
        /**********************************************/
        
        
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 220 , 300));
        ItemView.setBackground(Color.WHITE);
//        ItemView.setBorder(createLineBorder(new java.awt.Color(0, 0, 0)));
//        ItemView.add(new Item(0,0,"Nước giải khát","CocaCola.jpg"));
//        System.out.println(getClass().getResource("/image/SanPham/bp1.jpg"));
//        ImageIcon img = new ImageIcon(getClass().getResource("/image/SanPham/bp1.jpg"));
//        Image newImage = new ImageIcon(getClass().getResource("/image/SanPham/bp1.jpg")).getImage().getScaledInstance(250, 350, Image.SCALE_DEFAULT);
        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);

        ItemView.add(a);
        
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbNSX);
        ItemView.add(txtNSX);
        ItemView.add(lbName);
        ItemView.add(txtName);
        ItemView.add(lbLoai);
        ItemView.add(txtLoai);
        ItemView.add(lbPrice);
        ItemView.add(txtPrice);
        ItemView.add(lbDV);
        ItemView.add(txtDV);
        
        /****************************************************/
        // Thanh SEARCH
        JPanel searchBox = new JPanel(null);
        txtSearch = new JTextField();
        JLabel searchIcon = new JLabel(new ImageIcon(getClass().getResource("/image/search_25px.png")));
        
        txtSearch.setBounds(new Rectangle(5,0,400,30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));
        
        searchIcon.setBounds(new Rectangle(400,-9,50,50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);
        searchBox.setBackground(null);
        
        searchBox.setBounds(new Rectangle(30, 350,450, 30));
        searchBox.setBorder(createLineBorder(Color.BLACK));
        txtSearch.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e)
            {
                searchIcon.setIcon(new ImageIcon(getClass().getResource("/image/search_25px_focus.png")));
                searchBox.setBorder(createLineBorder(new Color(52,152,219)));
            }
            public void focusLost(FocusEvent e)
            {
                searchIcon.setIcon(new ImageIcon(getClass().getResource("/image/search_25px.png")));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        txtSearch.addKeyListener(new KeyAdapter (){
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    txtSearchKeyPressed();
                }
            }
        } );
        
        
        add(searchBox);
        
        /****************************************************/
        
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        
        //Tạo model
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Mă NSX");
        header.add("Tên Sản Phẩm");
        header.add("Loại");
        header.add("Đơn Giá");
        header.add("Đơn Vị Tính");
        header.add("IMG");
        
        loadDataSP();
        
        DefaultTableModel model = new DefaultTableModel(header,5);
        
        Vector data;
        model.setRowCount(0);
        
        for(SanPham s:sp)    
        {
            data = new Vector();
            data.add(s.getIdSP());
            data.add(s.getIdNSX());
            data.add(s.getName());
            data.add(s.getCetegory());
            data.add(s.getPrice());
            data.add(s.getDVT());
            data.add(s.getImg());
            model.addRow(data);
        }
        tbl = new JTable(model);
        
        //Tạo Table
        
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(25);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(30);

        
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));
        
//        tbl.getTableHeader().setReorderingAllowed(false);
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
                
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        
        
        //System.out.println(tbl.getTableHeader().getHeight());
        //System.out.println(tbl.getRowHeight(2));
        
        JScrollPane scroll = new JScrollPane(tbl);
        
        scroll.setBounds(new Rectangle(30, 390, this.DEFALUT_WIDTH - 400 , 210));
        scroll.setBackground(null);
        
        add(scroll);
        add(ItemView);
        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                //System.out.println(i);
                Image newImage = new ImageIcon(getClass().getResource("/image/SanPham/"+tbl.getModel().getValueAt(i, 6))).getImage().getScaledInstance(230, 250, Image.SCALE_DEFAULT);
                txtId.setText((String) tbl.getModel().getValueAt(i, 0));
                txtNSX.setText((String) tbl.getModel().getValueAt(i, 1));
                txtName.setText((String)tbl.getModel().getValueAt(i, 2)); 
                txtLoai.setText((String) tbl.getModel().getValueAt(i, 3));
                txtPrice.setText( tbl.getModel().getValueAt(i, 4).toString());
                txtDV.setText((String)tbl.getModel().getValueAt(i, 5)); 
                a.setText("");
                a.setIcon(new ImageIcon(newImage));
             }
        });
    }
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
        
        for(SanPham sp:sp)
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
    public void outModel(DefaultTableModel model , ArrayList<SanPham> sp)
    {
        Vector data; 
        for(SanPham s:sp)
        {
            data = new Vector();
            data.add(s.getIdSP());
            data.add(s.getIdNSX());
            data.add(s.getName());
            data.add(s.getCetegory());
            data.add(s.getPrice());
            data.add(s.getDVT());
            data.add(s.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void loadDataSP() 
    {
        System.out.print("Chay");
        try{
            MySQLConnection consql = new MySQLConnection("root", "", "jdbc:mysql://localhost/qlsieuthi");
            sp = consql.listSP();
        }catch(SQLException E){}
        catch(ClassNotFoundException E){};
    }
}
