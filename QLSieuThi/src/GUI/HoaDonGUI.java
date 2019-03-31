/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SanPhamBUS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtId,txtHoNV,txtSl,txtGia,txtDVT,txtNSX,txtLoai,txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
    public HoaDonGUI(int width)
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
       Font font0 = new Font("Segoe UI",Font.PLAIN,13);
       Font font1 = new Font("Segoe UI",Font.BOLD,13);
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
//        listSP(); //Đọc từ database lên table 
        
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
        scroll.setBounds(new Rectangle(30, 350, this.DEFALUT_WIDTH - 400 , 320));
        scroll.setBackground(null);
        
        add(scroll);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                imgName = tbl.getModel().getValueAt(i, 7).toString();
                Image newImage ;
                try{
                    newImage = new ImageIcon(getClass().getResource("/image/SanPham/"+imgName)).getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT);
                }catch(NullPointerException E)
                {
                    newImage = new ImageIcon(getClass().getResource("/image/SanPham/NoImage")).getImage().getScaledInstance(270, 300, Image.SCALE_DEFAULT); 
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
    }
}
