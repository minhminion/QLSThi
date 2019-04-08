/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.SanPhamDAO;
import DTO.LoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Shadow
 */
public class LoaiBUS {
    private ArrayList<LoaiDTO> dsLoai ;
    public LoaiBUS()
    {
        
    }
    public void listSP()
    {
        SanPhamDAO loaiDAO = new SanPhamDAO();
        dsLoai = new ArrayList<>();
        dsLoai = loaiDAO.listSP();
    }
    public void addSP(LoaiDTO loai)
    {
        dsLoai.add(loai);
        SanPhamDAO loaiDAO = new SanPhamDAO();
        loaiDAO.addSP(loai);
    }

    public void deleteSP(String idSP)
    {
        for(LoaiDTO loai : dsLoai )
        {
            if(loai.getMaSP().equals(idSP))
            {
                dsLoai.remove(loai);
                SanPhamDAO loaiDAO = new SanPhamDAO();
                loaiDAO.deleteSP(idSP);
                return;
            }
        }
    }
    public void setSP(LoaiDTO s)
    {
        for(int i = 0 ; i < dsLoai.size() ; i++)
        {
            if(dsLoai.get(i).getMaLoai().equals(s.getMaLoai()))
            {
                dsLoai.set(i, s);
                SanPhamDAO loaiDAO = new SanPhamDAO();
                loaiDAO.setSP(s);
                return;
            }
        }
    }
    public ArrayList<LoaiDTO> searchSP(String maloai,String maloai,String mansx,int max,int min)
    {
        ArrayList<LoaiDTO> search = new ArrayList<>();
        maloai = maloai.isEmpty()?maloai = "": maloai;
        maloai = maloai.isEmpty()?maloai = "": maloai;
        mansx = mansx.isEmpty()?mansx = "": mansx;
        for(LoaiDTO loai : dsLoai)
        {
            if( loai.getMaSP().contains(maloai) && 
                loai.getMaLoai().contains(maloai) &&
                loai.getMaNsx().contains(mansx) &&
                loai.getGia() >= min && 
                loai.getGia() <= max)
            {
                search.add(loai);
            }
        }
        return search;
    }
    public ArrayList<LoaiDTO> getDsloai() {
        return dsLoai;
    }
}
