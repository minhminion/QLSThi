/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author anhkhoa
 */
public class NhaCungCapBUS {
    public ArrayList<NhaCungCapDTO> dsncc;
    public NhaCungCapBUS(){}
    
    public void listNCC(){
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        dsncc = new ArrayList<>();
        dsncc = nccDAO.listNCC();
    }
    
       public void addNCC(NhaCungCapDTO ncc)
    {
        dsncc.add(ncc);
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        nccDAO.addNCC(ncc);
    }

    public void deleteNCC(String MaNCC)
    {
        for(NhaCungCapDTO ncc : dsncc )
        {
            if(ncc.getMaNCC().equals(MaNCC))
            {
                dsncc.remove(ncc);
                NhaCungCapDAO nccDAO = new NhaCungCapDAO();
                nccDAO.deleteNCC(MaNCC);
                return;
            }
        }
    }
    public void setNCC(NhaCungCapDTO s)
    {
        for(int i = 0 ; i < dsncc.size() ; i++)
        {
            if(dsncc.get(i).getMaNCC().equals(s.getMaNCC()))
            {
                dsncc.set(i, s);
                NhaCungCapDAO nccDAO = new NhaCungCapDAO();
                nccDAO.setNCC(s);
                return;
            }
        }
    }
       public boolean checkMancc(String MaNCC)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equals(MaNCC))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<NhaCungCapDTO> getList() {
        return dsncc;
    }
}
