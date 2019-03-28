/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DTO.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shadow
 */
public class SanPhamDAO {
    private String user = "root";
    private String password="";
    private String url="jdbc:mysql://localhost/qlsieuthi";
    private Connection conn;
    private Statement st ;
    public SanPhamDAO(String user , String pass,String url)
    {
        this.user = user;
        this.password = pass;
        this.url = url;
    }

    public SanPhamDAO() {
       
    }
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void disConnect()
    { 
        try{
            conn.close();
        }catch (SQLException E){}
    }
    public boolean checkAcc(String user,String password)
    {
        boolean kq = false;
        try {
            Connect();
            String sql = "SELECT * FROM TaiKhoan WHERE user='"+user+"' "
                    + "AND pass='"+password+"'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            kq = rs.next();
            disConnect();  
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public ArrayList<SanPham> listSP()
    {
        ArrayList<SanPham> sp = new ArrayList<>();
        try {
            Connect();
            String sql = "SELECT * FROM sanpham WHERE 1";
            st = this.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
//            System.out.println(rs.getInt("dongiaSP"));
                String idSP = rs.getString("idSP");
                String idNSX = rs.getString("idNSX");
                String nameSP = rs.getString("nameSP");
                String loaiSP = rs.getString("loaiSP");
                int price = rs.getInt("dongiaSP");
                String DVT = rs.getString("DVT");
                String IMG = rs.getString("IMG");
//            System.out.println(price);
                SanPham s = new SanPham(idSP, idNSX, nameSP, loaiSP, price, DVT, IMG);
                sp.add(s);
            }
            disConnect();
//        for(SanPham s:sp)
//        {
//            System.out.print(s.getPrice());
//        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch(NullPointerException ex)
//        {
//            System.out.println("Lỗi");
//        }
        return sp;
    }
    public void addSP(SanPham sp)
    {
        try {
            Connect();
            st = conn.createStatement();
            String sql = "INSERT INTO sanpham VALUES (";
                   sql += "'"+sp.getIdSP()+"',";
                   sql += "'"+sp.getIdNSX()+"',";
                   sql += "'"+sp.getName()+"',";
                   sql += "'"+sp.getCetegory()+"',";
                   sql += "'"+sp.getPrice()+"',";
                   sql += "'"+sp.getDVT()+"',";
                   sql += "'"+sp.getImg()+"')";
            disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public addSP(String )
    
}
