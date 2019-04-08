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
    
//    public boolean checkAcc(String user,String password)
//    {
//        boolean kq = false;
//        try {
//            Connect();
//            String sql = "SELECT * FROM user WHERE user='"+user+"' "
//                    + "AND pass='"+password+"'";
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            kq = rs.next();
//            rs.close();
//            disConnect();  
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return kq;
//    }
    public ArrayList<SanPhamDTO> listSP()
    {
        ArrayList<SanPhamDTO> sp = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sanpham WHERE 1";
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
    public void addSP(SanPhamDTO sp)
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

    public void deleteSP(String idSP)
    {
        String sql = "DELETE FROM sanpham WHERE MaSP='"+idSP+"'";
        mySQL.executeUpdate(sql);
    }
    
    public void setSP(SanPhamDTO sp)
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
