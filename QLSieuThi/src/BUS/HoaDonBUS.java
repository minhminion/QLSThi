/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Shadow
 */
public class HoaDonBUS {
    private ArrayList<HoaDonDTO> dsHD ;
    public HoaDonBUS()
    {
        
    }
    public void list()
    {
        HoaDonDAO hdDAO = new HoaDonDAO();
        dsHD = new ArrayList<>();
        dsHD = hdDAO.list();
    }
    public void add(HoaDonDTO hd)
    {
        dsHD.add(hd);
        HoaDonDAO hdDAO = new HoaDonDAO();
        hdDAO.add(hd);
    }

    public void delete(String idChiTietHD)
    {
        for(HoaDonDTO hd : dsHD )
        {
            if(hd.getMaHD().equals(idChiTietHD))
            {
                dsHD.remove(hd);
                HoaDonDAO hdDAO = new HoaDonDAO();
                hdDAO.delete(idChiTietHD);
                return;
            }
        }
    }
    public void set(HoaDonDTO s)
    {
        for(int i = 0 ; i < dsHD.size() ; i++)
        {
            if(dsHD.get(i).getMaHD().equals(s.getMaHD()))
            {
                dsHD.set(i, s);
//                HoaDonDAO hdDAO = new HoaDonDAO();
//                hdDAO.setChiTietHD(s);
                return;
            }
        }
    }
    public boolean check(String maHD)
    {
        for(HoaDonDTO hd : dsHD)
        {
            if( hd.getMaHD().equals(maHD))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<HoaDonDTO> getList() {
        return dsHD;
    }
}
