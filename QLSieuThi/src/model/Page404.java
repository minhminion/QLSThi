/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Shadow
 */
public class Page404 extends JPanel{
    private int DEFALUT_WIDTH;
    
    public Page404(int width)
    {
        DEFALUT_WIDTH = width;
        init();
    }
    public void init()
    {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(100, 0, this.DEFALUT_WIDTH - 220, 1000));
        
        JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/image/404.png")));
        icon.setBounds(0,300,100,100);
       
        Font font = new Font("Segoe UI",Font.BOLD,60);
        JLabel lb = new JLabel("HỆ THỐNG ĐANG BẢO TRÌ");
        lb.setForeground(new Color(52,152,219));
        lb.setFont(font);
        lb.setBounds(new Rectangle(100,280,800,100));
        
        
        JSeparator sep = new JSeparator();
        sep.setBackground(new Color(52,152,219));
        sep.setBounds(new Rectangle(100,380,800,10));
        
        add(icon);
        add(lb);
        add(sep);
        
        
    }
}