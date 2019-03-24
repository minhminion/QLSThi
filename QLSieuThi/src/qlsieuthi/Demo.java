/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsieuthi;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Shadow
 */
public class Demo extends JFrame{
    public static void main(String []args)
    {
        Demo demo = new Demo();
    }
    public Demo()
    {
        init();
    }
    public void init()
    {
        JFileChooser file = new JFileChooser();
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(file);
        
        setVisible(true);
        
    }
}
