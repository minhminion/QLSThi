/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Minh Minion
 */
public class SanPhamBUS {
    private ArrayList<SanPhamDTO> dssp ;
    public SanPhamBUS()
    {
        
    }
    public void listSP()
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        dssp = new ArrayList<>();
        dssp = spDAO.listSP();
    }
    public void addSP(SanPhamDTO sp)
    {
        dssp.add(sp);
        SanPhamDAO spDAO = new SanPhamDAO();
        spDAO.addSP(sp);
    }

    public void deleteSP(String idSP)
    {
        for(SanPhamDTO sp : dssp )
        {
            if(sp.getMaSP().equals(idSP))
            {
                dssp.remove(sp);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.deleteSP(idSP);
                return;
            }
        }
    }
    public void setSP(SanPhamDTO s)
    {
        for(int i = 0 ; i < dssp.size() ; i++)
        {
            if(dssp.get(i).getMaSP().equals(s.getMaSP()))
            {
                dssp.set(i, s);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.setSP(s);
                return;
            }
        }
    }
    public boolean checkMasp(String masp)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMaSP().equals(masp))
            {
                return true;
            }
        }
        return false;
    }
    public void updateSL(String masp,int sl)
    {
         for(SanPhamDTO sp : dssp)
         {
             if(sp.getMaSP().equals(masp))
             {
                 System.out.println("RUN");
                int old = sp.getSl()-sl;
                sp.setSl(old);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.setSP(sp);
                System.out.println(sp.getSl());
                return;
             }
         }
    }
    public ArrayList<SanPhamDTO> searchSP(String masp,String maloai,String mansx,int max,int min)
    {
        ArrayList<SanPhamDTO> search = new ArrayList<>();
        masp = masp.isEmpty()?masp = "": masp;
        maloai = maloai.isEmpty()?maloai = "": maloai;
        mansx = mansx.isEmpty()?mansx = "": mansx;
        for(SanPhamDTO sp : dssp)
        {
            if( sp.getMaSP().contains(masp) && 
                sp.getMaLoai().contains(maloai) &&
                sp.getMaNsx().contains(mansx) &&
                sp.getGia() >= min && 
                sp.getGia() <= max)
            {
                search.add(sp);
            }
        }
        return search;
    }
    public ArrayList<SanPhamDTO> getList() {
        return dssp;
    }
    
}
