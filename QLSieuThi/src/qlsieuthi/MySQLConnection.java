/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsieuthi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Shadow
 */
public class MySQLConnection {
    private String user,password,url;
    private Connection conn;
    public MySQLConnection(String user , String pass,String url)
    {
        this.user = user;
        this.password = pass;
        this.url = url;
    }
    private void Connect() throws ClassNotFoundException
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e) {}
    }
    private void disConnect() throws SQLException
    { 
        conn.close();
    }
    public boolean checkAcc(String user,String password) throws SQLException, ClassNotFoundException
    {
        Connect();
        String sql = "SELECT * FROM TaiKhoan WHERE user='"+user+"' "
                        + "AND pass='"+password+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean kq = rs.next();
        disConnect();
        return kq;
    }
    public ArrayList<SanPham> listSP() throws ClassNotFoundException, SQLException
    {
        ArrayList<SanPham> sp = new ArrayList<SanPham>();
        Connect();
        String sql = "SELECT * FROM sanpham WHERE 1";
        Statement st = conn.createStatement();
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
        return sp;
    }
//    public addSP(String )
    
}
