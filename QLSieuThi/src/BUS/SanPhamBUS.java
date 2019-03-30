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
    public ArrayList<SanPhamDTO> getDssp() {
        return dssp;
    }
    
}
