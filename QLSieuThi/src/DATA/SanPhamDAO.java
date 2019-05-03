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
    private  MySQLConnect mySQL = new MySQLConnect();
    public SanPhamDAO() {
       
    }
    public ArrayList<SanPhamDTO> list()
    {
        ArrayList<SanPhamDTO> sp = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sanpham WHERE enable = 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                int sl = rs.getInt("SOLUONG");
                int gia = rs.getInt("GIA");
                String DVT = rs.getString("DONVITINH");
                String maLoai = rs.getString("MALOAI");
                String maNsx = rs.getString("MANSX");
                String IMG = rs.getString("IMG");
                SanPhamDTO s = new SanPhamDTO(maSP, tenSP, DVT, maLoai, maNsx, IMG, sl, gia);
                sp.add(s);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sp;
    }
    public void add(SanPhamDTO sp)
    {
        String sql = "INSERT INTO sanpham VALUES (";
        sql += "'"+sp.getMaSP()+"',";
        sql += "N'"+sp.getTenSP()+"',";
        sql += "'"+sp.getSl()+"',";
        sql += "'"+sp.getGia()+"',";
        sql += "N'"+sp.getDvt()+"',";
        sql += "'"+sp.getMaLoai()+"',";
        sql += "'"+sp.getMaNsx()+"',";
        sql += "'"+sp.getImg()+"')";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void delete(String idSP)
    {
        String sql = "UPDATE sanpham SET enable = 0 WHERE MaSP='"+idSP+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
        
    }
    
    public void set(SanPhamDTO sp)
    {
        String sql = "UPDATE sanpham SET ";
        sql += "TENSP='"+sp.getTenSP()+"', ";
        sql += "SOLUONG='"+sp.getSl()+"', ";
        sql += "GIA='"+sp.getGia()+"', ";
        sql += "DONVITINH='"+sp.getDvt()+"', ";
        sql += "MALOAI='"+sp.getMaLoai()+"', ";
        sql += "MANSX='"+sp.getMaNsx()+"', ";
        sql += "IMG='"+sp.getImg()+"' ";
        sql += "WHERE MASP='"+sp.getMaSP()+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
