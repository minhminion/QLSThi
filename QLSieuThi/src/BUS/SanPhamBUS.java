/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.SanPhamDAO;
import DTO.SanPham;
import java.util.ArrayList;

/**
 *
 * @author Minh Minion
 */
public class SanPhamBUS {
    private ArrayList<SanPham> dssp ;
    public SanPhamBUS()
    {
        
    }
    public void listSP()
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        dssp = new ArrayList<>();
        dssp = spDAO.listSP();
    }
    public void addSP(SanPham sp)
    {
        dssp.add(sp);
        SanPhamDAO spDAO = new SanPhamDAO();
        spDAO.addSP(sp);
    }

    public ArrayList<SanPham> getDssp() {
        return dssp;
    }
    
}
