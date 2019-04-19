/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhapHangBUS;
import DTO.NhapHangDTO;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class NhapHangGUI extends JPanel{
    private NhapHangBUS nhBUS = new NhapHangBUS();
    
    private int DWIDTH;
    private JTextField txtMaNCC;
    private JTextField txtMaSP;
    private JTextField txtNgayNhap;
    
    private DefaultTableModel model;
    private JTable tbl;
    private JTextField txtGiaNhap;
    private JTextField txtSoLuong;
    private JTextField txtTongTien;
    public NhapHangGUI(int width)
    {
        this.DWIDTH = width;
        init();
    }
    public void init()
    {
        setSize(DWIDTH,700);
        setLayout(null);
        
        Font ftitle = new Font("Segoe UI",Font.BOLD,25);
        Font font0 = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        
        //HEADER
/***************** PHẦN HIỂN THỊ THÔNG TIN ***************************/
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 0,this.DWIDTH, 700));
        itemView.setBackground(Color.WHITE);
        
        JLabel lbMaNCC = new JLabel("Mã nhà cung cấp ");
        lbMaNCC.setFont(font0);
        lbMaNCC.setBounds(20,20,100,30);
        txtMaNCC = new JTextField();
        txtMaNCC.setBounds(new Rectangle(120,20,250,30));
        itemView.add(lbMaNCC);
        itemView.add(txtMaNCC);
        
        JLabel lbMaSP = new JLabel("Mã sản phẩm");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(20,70,100,30);
        txtMaSP = new JTextField();
        txtMaSP.setBounds(new Rectangle(120,70,250,30));
        itemView.add(lbMaSP);
        itemView.add(txtMaSP);
        
        JLabel lbNgayNhap = new JLabel("Ngày Nhập");
        lbNgayNhap.setFont(font0);
        lbNgayNhap.setBounds(20,120,100,30);
        txtNgayNhap = new JTextField();
        txtNgayNhap.setBounds(new Rectangle(120,120,250,30));
        itemView.add(lbNgayNhap);
        itemView.add(txtNgayNhap);
        
        JLabel lbGiaNhap = new JLabel("Giá nhập");
        lbGiaNhap.setFont(font0);
        lbGiaNhap.setBounds(20,170,100,30);
        txtGiaNhap = new JTextField();
        txtGiaNhap.setBounds(new Rectangle(120,170,250,30));
        itemView.add(lbGiaNhap);
        itemView.add(txtGiaNhap);
        
        JLabel lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setFont(font0);
        lbSoLuong.setBounds(20,220,100,30);
        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(new Rectangle(120,220,250,30));
        itemView.add(lbSoLuong);
        itemView.add(txtSoLuong);
        
        JLabel lbTongTien = new JLabel("Tổng tiền");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(20,270,100,30);
        txtTongTien = new JTextField();
        txtTongTien.setBounds(new Rectangle(120,270,250,30));
        itemView.add(lbTongTien);
        itemView.add(txtTongTien);
        
/**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/

        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm_150px.png"));
        btnConfirm.setBounds(new Rectangle(20,330,150,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirm.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                
            }
        });
              
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack_150px.png"));
        btnBack.setBounds(new Rectangle(180,330,150,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        btnBack.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
/*************************************************************************/
/**************** TẠO TABLE ************************************************************/

    /************** TẠO MODEL VÀ HEADER *********************************/
        Vector header = new Vector();
        header.add("Mă NCC");
        header.add("Mã SP");
        header.add("Ngày nhập");
        header.add("Giá nhập");
        header.add("Số lượng");
        header.add("Tổng tiền");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list();
        
    /*******************************************************************/
        

    /******** CUSTOM TABLE ****************/
    
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
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
        scroll.setBounds(new Rectangle(400, 20, DWIDTH - 650 , 500));
        scroll.setBackground(null);
        
        itemView.add(scroll);
        
        add(itemView);
    /**************************************/
/*****************************************************************************************/
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                txtMaNCC.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtMaSP.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtNgayNhap.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtGiaNhap.setText(tbl.getModel().getValueAt(i, 3).toString()); 
                txtSoLuong.setText(tbl.getModel().getValueAt(i, 4).toString()); 
                txtTongTien.setText(tbl.getModel().getValueAt(i, 5).toString());             
             }
        });
/*********************************************************************/
    }
    public void outModel(DefaultTableModel model , ArrayList<NhapHangDTO> nhaphang) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(NhapHangDTO nh : nhaphang)
        {
            data = new Vector();
            data.add(nh.getMaNCC());
            data.add(nh.getMaSP());
            data.add(nh.getNgayNhap());
            data.add(nh.getDonGiaNhap());
            data.add(nh.getSoLuong());
            data.add(nh.getTongTien());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void list() // Chép ArrayList lên table
    {
        if(nhBUS.getList() == null)nhBUS.list();
        ArrayList<NhapHangDTO> nh = nhBUS.getList();
//        model.setRowCount(0);
        outModel(model,nh);
    }
}
