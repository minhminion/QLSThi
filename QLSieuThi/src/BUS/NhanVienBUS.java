/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author Shadow
 */
public class NhanVienBUS {
    private ArrayList<NhanVienDTO> dsnv ;
    public NhanVienBUS()
    {
        
    }
    public void listSP()
    {
        NhanVienDAO spDAO = new NhanVienDAO();
        dsnv = new ArrayList<>();
        dsnv = spDAO.listNV();
    }
    public void addSP(NhanVienDTO sp)
    {
        dsnv.add(sp);
        NhanVienDAO spDAO = new NhanVienDAO();
        spDAO.addNV(sp);
    }

    public void deleteNV(String MaNV)
    {
        for(NhanVienDTO sp : dsnv )
        {
            if(sp.getMaNV().equals(MaNV))
            {
                dsnv.remove(sp);
                NhanVienDAO spDAO = new NhanVienDAO();
                spDAO.deleteNV(MaNV);
                return;
            }
        }
    }
    public void setSP(NhanVienDTO s)
    {
        for(int i = 0 ; i < dsnv.size() ; i++)
        {
            if(dsnv.get(i).getMaNV().equals(s.getMaNV()))
            {
                dsnv.set(i, s);
                NhanVienDAO spDAO = new NhanVienDAO();
                spDAO.setSP(s);
                return;
            }
        }
    }
    public ArrayList<NhanVienDTO> searchSP(String manv,String ho,String ten,String phai)
    {
        ArrayList<NhanVienDTO> search = new ArrayList<>();
        manv = manv.isEmpty()?manv = "": manv;
        ho = ho.isEmpty()?ho = "": ho;
        ten = ten.isEmpty()?ten = "": ten;
        for(NhanVienDTO nv : dsnv)
        {
            if( nv.getMaNV().contains(manv) && 
                nv.getHoNV().contains(ho) &&
                nv.getTenNV().contains(ten) &&
                nv.getPhai().contains(phai))
            {
                search.add(nv);
            }
        }
        return search;
    }
    public ArrayList<NhanVienDTO> getDssp() {
        return dsnv;
    }
}
