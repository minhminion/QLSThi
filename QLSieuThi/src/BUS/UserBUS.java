/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.UserDAO;
import DTO.UserDTO;
import java.util.ArrayList;

/**
 *
 * @author Shadow
 */
public class UserBUS {
    private ArrayList<UserDTO> dsHD ;
    public UserBUS()
    {
        
    }
    public void list()
    {
        UserDAO usDAO = new UserDAO();
        dsHD = new ArrayList<>();
        dsHD = usDAO.list();
    }
    public void add(UserDTO hd)
    {
        dsHD.add(hd);
        UserDAO usDAO = new UserDAO();
        usDAO.add(hd);
    }

    public void add(UserDTO hd,int i)
    {
//        dsHD.add(hd);
        UserDAO usDAO = new UserDAO();
        usDAO.add(hd);
    }
    
    public void delete(String userID)
    {
        for(UserDTO hd : dsHD )
        {
            if(hd.getUserID().equals(userID))
            {
                dsHD.remove(hd);
                UserDAO usDAO = new UserDAO();
                usDAO.delete(userID);
                return;
            }
        }
    }
    public void set(UserDTO s)
    {
        for(int i = 0 ; i < dsHD.size() ; i++)
        {
            if(dsHD.get(i).getUserID().equals(s.getUserID()))
            {
                dsHD.set(i, s);
//                UserDAO usDAO = new UserDAO();
//                usDAO.setChiTietHD(s);
                return;
            }
        }
    }
    public boolean check(String userID,String pass)
    {
        for(UserDTO hd : dsHD)
        {
            if( hd.getUserID().equals(userID) && hd.getPass().equals(pass))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<UserDTO> getList() {
        return dsHD;
    }
}
