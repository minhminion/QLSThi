/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DTO.SanPhamDTO;
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
    private String url="jdbc:mysql://localhost/sieuthimini";
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
            String sql = "SELECT * FROM user WHERE user='"+user+"' "
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
    public ArrayList<SanPhamDTO> listSP()
    {
        ArrayList<SanPhamDTO> sp = new ArrayList<>();
        try {
            Connect();
            String sql = "SELECT * FROM sanpham WHERE 1";
            st = this.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
//            System.out.println(rs.getInt("dongiaSP"));
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                int sl = rs.getInt("SOLUONG");
                int gia = rs.getInt("GIA");
                String DVT = rs.getString("DONVITINH");
                String maLoai = rs.getString("MALOAI");
                String maNsx = rs.getString("MANSX");
                String IMG = rs.getString("IMG");
//            System.out.println(price);
                SanPhamDTO s = new SanPhamDTO(maSP, tenSP, DVT, maLoai, maNsx, IMG, sl, gia);
                sp.add(s);
            }
            disConnect();
//        for(SanPhamDTO s:sp)
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
    public void addSP(SanPhamDTO sp)
    {
        try {
            Connect();
            st = conn.createStatement();
            String sql = "INSERT INTO sanpham VALUES (";
                   sql += "'"+sp.getMaSP()+"',";
                   sql += "'"+sp.getTenSP()+"',";
                   sql += "'"+sp.getSl()+"',";
                   sql += "'"+sp.getGia()+"',";
                   sql += "'"+sp.getDvt()+"',";
                   sql += "'"+sp.getMaLoai()+"',";
                   sql += "'"+sp.getMaNsx()+"',";
                   sql += "'"+sp.getImg()+"')";
            disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public addSP(String )
    
}
