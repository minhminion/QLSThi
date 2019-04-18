/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Shadow
 */
public class ThongKeGUI extends JPanel implements ActionListener,ItemListener{
    private JPanel paneTime = new JPanel() ;
    private JPanel paneTrimester = new JPanel() ;
    private JPanel panePeriod = new JPanel();
    private JRadioButton ckMaSP, ckMaNV, ckMaKH ,ckDate, ckTrimester, ckPeriod;
    private JLabel lbMa = new JLabel();
    private JTextField txtMa = new JTextField();
    private JTextArea viewStatistic;
    private JButton btnStatistic ;
    private int DEFALUT_WIDTH;
    private JPanel form;
    private JLabel lbFromDate;
    private JLabel lbToDate;
    
    private JComboBox<String> cmbFromDate = new JComboBox<>();
    private JComboBox<String> cmbFromMonth = new JComboBox<>();
    private JComboBox<String> cmbFromYear = new JComboBox<>();
    private JComboBox<String> cmbToDate = new JComboBox<>();
    private JComboBox<String> cmbToMonth = new JComboBox<>();
    private JComboBox<String> cmbToYear = new JComboBox<>();
    private JComboBox<String> cmbTrimester = new JComboBox<>();
    private JComboBox<String> cmbPeriod = new JComboBox<>();
    private JLabel lbTrimester;
    public ThongKeGUI(int width)
    {
        DEFALUT_WIDTH = width;
        init();
    }
    public void init()
    {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 730));
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
/************** PHẦN KIỄM KÊ *****************************************/
        JPanel control = new JPanel(null);
        control.setBackground(null);
        control.setBounds(new Rectangle(0,0,(DEFALUT_WIDTH - 220)/2,730));
        
        // Chuyển đổi giữa 2 panel
        JTabbedPane controlTab = new JTabbedPane();
        controlTab.setBounds(new Rectangle(0,20,(DEFALUT_WIDTH - 220)/2 - 10,150));
        
        JPanel controlAll = new JPanel(new GridLayout(2,4));
        controlAll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // CHỌN MÃ CẦN THỐNG KÊ
        ButtonGroup id = new ButtonGroup();
        ckMaSP = new JRadioButton("Sản Phẩm");
        ckMaSP.setFont(font0);
        ckMaSP.setSelected(true);
        ckMaSP.addItemListener(this);
        id.add(ckMaSP);
        ckMaNV = new JRadioButton("Nhân viên");
        ckMaNV.addItemListener(this);
        ckMaNV.setFont(font0);
        id.add(ckMaNV);
        ckMaKH = new JRadioButton("Khách hàng");
        ckMaKH.addItemListener(this);
        ckMaKH.setFont(font0);
        id.add(ckMaKH);
        
        // CHỌN KIỂU THỜI GIAN
        ButtonGroup Time = new ButtonGroup();
        ckDate = new JRadioButton("DD/MM/YYY");
        ckDate.addItemListener(this);
        ckDate.setFont(font0);
        ckDate.setSelected(true);
        Time.add(ckDate);
        ckTrimester = new JRadioButton("Quý");
        ckTrimester.setFont(font0);
        ckTrimester.addItemListener(this);
        Time.add(ckTrimester);
        ckPeriod = new JRadioButton("Kỳ(4 tháng)");
        ckPeriod.setFont(font0);
        ckPeriod.addItemListener(this);
        Time.add(ckPeriod);
        
        JLabel lbId = new JLabel("Chọn mã");
        lbId.setFont(font1);
        controlAll.add(lbId);
        controlAll.add(ckMaSP);
        controlAll.add(ckMaNV);
        controlAll.add(ckMaKH);
        
        JLabel lbTime = new JLabel("Chọn thời gian");
        lbTime.setFont(font1);
        controlAll.add(lbTime);
        controlAll.add(ckDate);
        controlAll.add(ckTrimester);
        controlAll.add(ckPeriod);
        
        JPanel controlTop = new JPanel(new GridLayout(2,4));
        controlTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        controlTab.add(controlAll,"Tất cả");
        controlTab.add(controlTop,"Top");
        control.add(controlTab);
        
        //Panel điền thông tin 
        form = new JPanel(null);
        form.setBounds(new Rectangle(0,200,(DEFALUT_WIDTH - 220)/2 - 10,300));
        
        lbMa.setBounds(new Rectangle(0,0,100,30));
        lbMa.setFont(font0);
        txtMa.setBounds(new Rectangle(110,0,280,30));
        txtMa.setFont(font0);
        form.add(lbMa);
        form.add(txtMa);
        
        /**************** CHỌN TIME ********************************/
        paneTime = new JPanel(null);
        paneTime.setBounds(new Rectangle(0,40,(DEFALUT_WIDTH - 220)/2 - 10,260));
        
        // FROM
        lbFromDate = new JLabel("Từ ngày");
        lbFromDate.setFont(font0);
        lbFromDate.setBounds(new Rectangle(0,0,100,30));
        
        cmbFromDate.setBounds(new Rectangle(110,0,80,30));
        cmbFromDate.setFont(font0);
        listDate(cmbFromDate,true);
        JLabel sepTime0 = new JLabel("/");
        sepTime0.setFont(font0);
        sepTime0.setBounds(new Rectangle(195,0,10,30));
        
        cmbFromMonth.addActionListener(this);
        cmbFromMonth.setBounds(new Rectangle(205,0,80,30));
        cmbFromMonth.setFont(font0);
        listMonth(cmbFromMonth);
        JLabel sepTime1 = new JLabel("/");
        sepTime1.setFont(font0);
        sepTime1.setBounds(new Rectangle(290,0,10,30));
        
        cmbFromYear.addActionListener(this);
        cmbFromYear.setBounds(new Rectangle(300,0,80,30));
        cmbFromYear.setFont(font0);
        listYear(cmbFromYear);
        
        System.out.print(cmbFromYear.getSelectedIndex());
        
        paneTime.add(lbFromDate);
        paneTime.add(cmbFromDate);
        paneTime.add(sepTime0);
        paneTime.add(cmbFromMonth);
        paneTime.add(sepTime1);
        paneTime.add(cmbFromYear);
        
        // TO
        lbToDate = new JLabel("Đến ngày");
        lbToDate.setFont(font0);
        lbToDate.setBounds(new Rectangle(0,40,100,30));
        
        cmbToDate.setBounds(new Rectangle(110,40,80,30));
        cmbToDate.setFont(font0);
        listDate(cmbToDate,false);
        JLabel sepTime2 = new JLabel("/");
        sepTime2.setFont(font0);
        sepTime2.setBounds(new Rectangle(195,40,10,30));
        
        cmbToMonth.addActionListener(this);
        cmbToMonth.setBounds(new Rectangle(205,40,80,30));
        cmbToMonth.setFont(font0);
        listMonth(cmbToMonth);
        JLabel sepTime3 = new JLabel("/");
        sepTime3.setFont(font0);
        sepTime3.setBounds(new Rectangle(290,40,10,30));
        
        cmbToYear.addActionListener(this);
        cmbToYear.setBounds(new Rectangle(300,40,80,30));
        cmbToYear.setFont(font0);
        listYear(cmbToYear);
        
        
        paneTime.add(lbFromDate);
        paneTime.add(cmbFromDate);
        paneTime.add(sepTime0);
        paneTime.add(cmbFromMonth);
        paneTime.add(sepTime1);
        paneTime.add(cmbFromYear);
        
        paneTime.add(lbToDate);
        paneTime.add(cmbToDate);
        paneTime.add(sepTime2);
        paneTime.add(cmbToMonth);
        paneTime.add(sepTime3);
        paneTime.add(cmbToYear);
        
        form.add(paneTime);
        /***********************************************************/   
        
        /*************** CHỌN THEO QUÝ *****************************/
        paneTrimester = new JPanel(null);
        paneTrimester.setBounds(new Rectangle(0,40,(DEFALUT_WIDTH - 220)/2 - 10,260));
        
        lbTrimester = new JLabel("Quý");
        lbTrimester.setFont(font0);
        lbTrimester.setBounds(new Rectangle(0,0,100,30));
        
        cmbTrimester.setBounds(new Rectangle(110,0,200,30));
        cmbTrimester.setFont(font0);
        for(int i = 1 ; i <=4  ; i++)
        {
            cmbTrimester.addItem("Quý "+i+"");
        }
        
        paneTrimester.add(lbTrimester);
        paneTrimester.add(cmbTrimester);
        
        paneTrimester.setVisible(false);
        form.add(paneTrimester);
        /***********************************************************/
        
        control.add(form);
        
        btnStatistic = new JButton("Thống kê");
        btnStatistic.setFont(font0);
        btnStatistic.setBounds(new Rectangle(50,500,(DEFALUT_WIDTH - 220)/2 - 100,30));
        control.add(btnStatistic);
        
        add(control);
/*********************************************************************/

/*************** PHẦN HIỆN THÔNG TIN *********************************/
        JPanel view = new JPanel(null);
        view.setBounds(new Rectangle((DEFALUT_WIDTH - 220)/2,0,(DEFALUT_WIDTH - 220)/2,730));
        
        viewStatistic = new JTextArea();
        viewStatistic.setEditable(false);
//        viewStatistic.setBounds(new Rectangle(0,20,(DEFALUT_WIDTH - 220)/2 - 20 ,730));
        JScrollPane scroll = new JScrollPane(viewStatistic);
        scroll.setBounds(new Rectangle(0,20,(DEFALUT_WIDTH - 220)/2 - 100 ,500));
        view.add(scroll);
        
        add(view);
/*********************************************************************/
    }
    public static void main(String[]args)
    {
        JFrame frame = new JFrame();
        frame.setSize(1080, 730);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ThongKeGUI(1300));
        frame.setVisible(true);
    }
    public void listDate(JComboBox cmb,boolean flag) // TRUE is FROM - FALSE is TO
    {
        cmb.addItem("Không");
        int thisMonth = 12 , thisDate = 31 ,thisYear = Calendar.getInstance().get(Calendar.YEAR);
        if( cmbFromYear.getSelectedIndex() > 0 || cmbToYear.getSelectedIndex() > 0)
        {
            thisYear = flag?Integer.parseInt(cmbFromYear.getSelectedItem().toString()):Integer.parseInt(cmbToYear.getSelectedItem().toString());
//            System.out.println(thisYear);
        }
        if( cmbFromMonth.getSelectedIndex() > 0 || cmbToMonth.getSelectedIndex() > 0)
        {
            thisMonth = flag?cmbFromMonth.getSelectedIndex():cmbToMonth.getSelectedIndex();
//            System.out.println(thisMonth);
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(thisYear, thisMonth - 1, 1);
        System.out.println(calendar.getTime());
        thisDate = calendar.getActualMaximum(Calendar.DATE);
//        System.out.println(thisDate);
        
        for(int i = 1 ; i <= thisDate ; i++)
        {
            cmb.addItem(i);
        }
    }
    public void listMonth(JComboBox cmb)
    {
        cmb.addItem("Không");
        for(int i = 1 ; i <= 12 ; i++ )
        {
            cmb.addItem(i);
        }
    }
    public void listYear(JComboBox cmb)
    {
        cmb.addItem("Không");
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = thisYear ; i >= thisYear - 20 ; i-- )
        {
            cmb.addItem(i);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj.equals(cmbFromMonth) || obj.equals(cmbFromYear))
        {
            cmbFromDate.removeAllItems();
            listDate(cmbFromDate,true);
        }
        if(obj.equals(cmbToMonth) || obj.equals(cmbToYear))
        {
            cmbToDate.removeAllItems();
            listDate(cmbToDate,false);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(ckDate.isSelected())
        {
            paneTime.setVisible(true);
            paneTrimester.setVisible(false);
        }
        else if(ckTrimester.isSelected())
        {
            paneTime.setVisible(false);
            paneTrimester.setVisible(true);
        }
        
        if(ckMaSP.isSelected())
        {
            lbMa.setText("Mă sản phẩm");
        }
        else if(ckMaNV.isSelected())
        {
            lbMa.setText("Mã nhân viên");
        }
        else if(ckMaKH.isSelected())
        {
            lbMa.setText("Mã khách hàng");
        }
   
    }
}
