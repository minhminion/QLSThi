/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DTO.NhanVienDTO;
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
public class NhanVienDAO {
    private String user = "root";
    private String password="";
    private String url="jdbc:mysql://localhost/sieuthimini?useUnicode=true&characterEncoding=UTF-8";
    private Connection conn;
    private Statement st ;
    private ResultSet rs = null;

    public NhanVienDAO() {
    }
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void disConnect()
    { 
        try{
            st.close();
            conn.close();
        }catch (SQLException E){}
    }
    
    public ArrayList<NhanVienDTO> listNV()
    {
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        try {
            Connect();
            String sql = "SELECT * FROM nhanvien WHERE 1";
            st = this.conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next())
            {

                String maNV = rs.getString("MANV");
                String hoNV = rs.getString("HONV");
                String tenNV = rs.getString("TENNV");
                int namsinh = rs.getInt("NAMSINH");
                String phai = rs.getString("PHAI");
                int mucLuong = rs.getInt("MUCLUONG");
                String diaChi = rs.getString("DIACHI");
                String IMG = rs.getString("IMG");

                NhanVienDTO nv = new NhanVienDTO(maNV, hoNV, tenNV, namsinh, phai, mucLuong, diaChi, IMG);
                dsnv.add(nv);
            }
            rs.close();
            disConnect();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsnv;
    }

    public void setSP(NhanVienDTO nv) {
        try {
            Connect();
            st = conn.createStatement();
            String sql = "UPDATE nhanvien SET ";
            sql += "HONV='"+nv.getHoNV()+"', ";
            sql += "TENNV='"+nv.getTenNV()+"', ";
            sql += "NAMSINH='"+nv.getNamSinh()+"', ";
            sql += "PHAI='"+nv.getPhai()+"', ";
            sql += "MUCLUONG='"+nv.getMucLuong()+"', ";
            sql += "DIACHI='"+nv.getDiaChi()+"', ";
            sql += "IMG='"+nv.getImg()+"' ";
            sql += "WHERE MANV='"+nv.getMaNV()+"'";
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
