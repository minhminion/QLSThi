/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsieuthi;

/**
 *
 * @author Shadow
 */
public class SanPham {
    private String idSP,idNSX,name,cetegory,DVT,Img;
    private int price;
    public SanPham()
    {
        
    }
    public SanPham(String idSP, String idNSX, String name, String cetegory, int price , String DVT, String Img) {
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.name = name;
        this.cetegory = cetegory;
        this.DVT = DVT;
        this.Img = Img;
        this.price = price;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCetegory() {
        return cetegory;
    }

    public void setCetegory(String cetegory) {
        this.cetegory = cetegory;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
