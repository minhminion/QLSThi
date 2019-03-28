/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Shadow
 */
public class header extends JPanel{
    private int height,width;
    public header(int h,int w)
    {
        height = h;
        width = w;
        init();
    }
    public void init()
    {
        setLayout(null);
        setSize(height,width);
        setBackground(null);
        
        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/image/SystemIcon_60px.png")));
        logo.setBounds(new Rectangle(10, 0, 60, 60));
        Font font = new Font("Tahoma",Font.BOLD,20);
        JLabel name = new JLabel("QUẢN LÝ SIÊU THỊ");
        name.setFont(font);
        name.setForeground(Color.white);
        name.setBounds(new Rectangle(80, 0, 200, 60));
        
        add(logo);
        add(name);
    }
}
