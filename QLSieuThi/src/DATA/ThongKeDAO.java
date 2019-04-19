/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DTO.HoaDonDTO;
import DTO.NhapHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shadow
 */
public class ThongKeDAO {
    public ThongKeDAO()
    {
        
    }
    public String Statistic( ArrayList<HoaDonDTO> listHd, ArrayList<NhapHangDTO> listNH,String MaSP)
    {
        String s = "";
        int slOut=0,sumOut = 0;
        int slIn=0,sumIn = 0;
        try {
            MySQLConnect mySQL = new MySQLConnect();
            // BÁN
            String sql1 = "SELECT SUM(SOLUONG) AS SL,SUM(SOLUONG*DONGIA) AS TONGTIEN FROM chitiethd WHERE (";
            for(int i = 0 ; i < listHd.size() ; i++)
            {
                String mahd = listHd.get(i).getMaHD();
                if(i == (listHd.size() - 1))
                {
                    sql1 += "MAHD ='"+ mahd +"') ";
                    break;
                }
                sql1 += "MAHD ='"+ mahd +"' OR ";
            }
            sql1+= "AND MASP = '"+MaSP+"' ";
            sql1 += "GROUP BY MAHD";
            System.out.println(sql1);
            ResultSet rs1 = mySQL.executeQuery(sql1);
            while(rs1.next())
            {
                slOut += rs1.getInt("SL");
                sumOut += rs1.getInt("TONGTIEN");
            }
            
            // NHẬP
            String sql2 = "SELECT SUM(SOLUONG) AS SL,SUM(TONGTIEN) AS TONGTIEN FROM phieunhaphang WHERE (";
            for(int i = 0 ; i < listNH.size() ; i++)
            {
                String idNhap = listNH.get(i).getIdNH();
                if(i == (listNH.size() - 1))
                {
                    sql2 += "IDNHAP = '"+ idNhap +"') ";
                    break;
                }
                sql2 += "IDNHAP = '"+ idNhap +"' OR ";
            }
            sql2+= "AND MASP = '"+MaSP+"' ";
            sql2 += "GROUP BY IDNHAP";
            System.out.println(sql2);
            ResultSet rs2 = mySQL.executeQuery(sql2);
            while(rs2.next())
            {
                slIn += rs2.getInt("SL");
                sumIn += rs2.getInt("TONGTIEN");
            }
            
            s += "Số lượng bán : "+slOut+"\t"+"Số lượng nhập : "+slIn+"\n";
            s += "Tổng tiền : "+sumOut+"đ"+"\t"+"Tổng tiền nhập : "+sumIn+"đ"+"\n";
            s += "--------------------------------------------------- \n";
            s += "TỔNG THU NHẬP : "+(sumOut-sumIn)+"VNĐ"+"\n";      
            System.out.print(s);
            
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
