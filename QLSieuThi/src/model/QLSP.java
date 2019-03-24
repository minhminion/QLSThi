/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Rectangle;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Shadow
 */
public class QLSP extends JPanel{

    private int DEFALUT_WIDTH;
    //        

    public QLSP(int width)
    {
        DEFALUT_WIDTH = width;
        init();
    }
    public void init()
    {
        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 50, this.DEFALUT_WIDTH - 220 , 1000));
        ItemView.setBackground(Color.WHITE);
        for(int i = 0; i < 2; i ++)
        {
            for(int j = 0 ; j <= 4 ;j++)
            {
                ItemView.add(new Item(240*j,330*i,"Nước giải khát","CocaCola.jpg"));
            }
        }
        
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 50, this.DEFALUT_WIDTH - 220, 1000));
        
        JButton btnAddImg = new JButton("Add Image");
        JButton btnAddVd = new JButton("Add Video");
        JButton btnAddYtu = new JButton("Add Youtube");
        JButton btnAddVit = new JButton("Add Vimeo");
        
        btnAddImg.setBounds(new Rectangle(30, 0, 120, 25));
        btnAddVd.setBounds(new Rectangle(170, 0, 120, 25));
        btnAddYtu.setBounds(new Rectangle(310, 0, 120, 25));
        btnAddVit.setBounds(new Rectangle(450, 0, 120, 25));
        
        add(btnAddImg);
        add(btnAddVd);
        add(btnAddYtu);
        add(btnAddVit);
        add(ItemView);
    }
}
