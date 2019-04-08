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

    public NhanVienDAO() {
    }
    public ArrayList<NhanVienDTO> listNV()
    {
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        try {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "SELECT * FROM nhanvien WHERE 1";
            ResultSet rs = mySQL.executeQuery(sql);
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

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsnv;
    }

    public void setSP(NhanVienDTO nv) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE nhanvien SET ";
            sql += "HONV='"+nv.getHoNV()+"', ";
            sql += "TENNV='"+nv.getTenNV()+"', ";
            sql += "NAMSINH='"+nv.getNamSinh()+"', ";
            sql += "PHAI='"+nv.getPhai()+"', ";
            sql += "MUCLUONG='"+nv.getMucLuong()+"', ";
            sql += "DIACHI='"+nv.getDiaChi()+"', ";
            sql += "IMG='"+nv.getImg()+"' ";
            sql += " WHERE MANV='"+nv.getMaNV()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addNV(NhanVienDTO nv) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO nhanvien VALUES (";
                sql += "'"+nv.getMaNV()+"',";
                sql += "'"+nv.getHoNV()+"',";
                sql += "'"+nv.getTenNV()+"',";
                sql += "'"+nv.getNamSinh()+"',";
                sql += "'"+nv.getPhai()+"',";
                sql += "'"+nv.getMucLuong()+"',";
                sql += "'"+nv.getDiaChi()+"',";
                sql += "'"+nv.getImg()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deleteNV(String MaNV)
    {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM nhanvien WHERE MANV='"+MaNV+"'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }
}