/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.ThongKeDAO;
import DTO.HoaDonDTO;
import DTO.NhapHangDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Shadow
 */
public class ThongKeBUS {
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private NhapHangBUS nhBUS = new NhapHangBUS();
    public ThongKeBUS()
    {
        hdBUS.list();
        nhBUS.list();
    }
    public String Statistic(String Id,Calendar from,Calendar to)
    {
        ArrayList<HoaDonDTO> dsHD = new ArrayList<> ();
        dsHD = hdBUS.ListTime(from, to);
        
        ArrayList<NhapHangDTO> dsNhap = new ArrayList<> ();
        dsNhap = nhBUS.ListTime(from, to);
        if(dsNhap.isEmpty())return "Không sp được bán !!";
        
        ThongKeDAO tkDAO = new ThongKeDAO();
        return tkDAO.Statistic(dsHD,dsNhap, Id);
    }
}
