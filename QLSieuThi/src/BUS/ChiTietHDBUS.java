/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.ChiTietHDDAO;
import DTO.ChiTietHDDTO;
import java.util.ArrayList;

/**
 *
 * @author Minh Minion
 */
public class ChiTietHDBUS {
    private ArrayList<ChiTietHDDTO> dsChiTietHD ;
    public ChiTietHDBUS()
    {
        
    }
    public void listChiTietHD()
    {
        ChiTietHDDAO loaiDAO = new ChiTietHDDAO();
        dsChiTietHD = new ArrayList<>();
        dsChiTietHD = loaiDAO.listChiTietHD();
    }
    public void addChiTietHD(ChiTietHDDTO loai)
    {
        dsChiTietHD.add(loai);
        ChiTietHDDAO loaiDAO = new ChiTietHDDAO();
        loaiDAO.addChiTietHD(loai);
    }

    public void deleteChiTietHD(String idChiTietHD)
    {
        for(ChiTietHDDTO ct : dsChiTietHD )
        {
            if(ct.getMaHD().equals(idChiTietHD))
            {
                dsChiTietHD.remove(ct);
                ChiTietHDDAO loaiDAO = new ChiTietHDDAO();
                loaiDAO.deleteChiTietHD(idChiTietHD);
                return;
            }
        }
    }
    public void setChiTietHD(ChiTietHDDTO s)
    {
        for(int i = 0 ; i < dsChiTietHD.size() ; i++)
        {
            if(dsChiTietHD.get(i).getMaHD().equals(s.getMaHD()))
            {
                dsChiTietHD.set(i, s);
//                ChiTietHDDAO loaiDAO = new ChiTietHDDAO();
//                loaiDAO.setChiTietHD(s);
                return;
            }
        }
    }
    public ChiTietHDDTO searchMaChiTietHD(String maHD)
    {
        for(ChiTietHDDTO ct : dsChiTietHD)
        {
            if( ct.getMaHD().equals(maHD))
            {
                return ct;
            }
        }
        return null;
    }
    public ArrayList<ChiTietHDDTO> getList() {
        return dsChiTietHD;
    }
}
