/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shadow
 */
public class outBill {
    private String file = "./report/test.pdf";
    private ArrayList<ChiTietHDDTO> cthd = new ArrayList<ChiTietHDDTO>();
    private HoaDonDTO hd;
    public outBill()
    {
                
    }

    public outBill(HoaDonDTO hd,ArrayList<ChiTietHDDTO> cthd) 
    {
        this.hd = hd;
        file = "./report/bill"+hd.getMaHD()+".pdf";
        this.cthd = cthd;
    }
    public void print()
    {
        String uderline = "*";
        try {
            //Tạo Font
            BaseFont bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            
            // Tạo tài liệu
            Document bill = new Document(PageSize.A4, 10, 10, 10, 10);
            
            String line = "";
            for(int i = 0 ; i < bill.getPageSize().getWidth()/5; i++)
            {
                line += uderline;
            }
            //Tạo đối tượng writter
            PdfWriter.getInstance(bill, new FileOutputStream(file));
            
            //Mở document
            bill.open();
            
            Paragraph header = new Paragraph("Hóa đơn :"+hd.getMaHD(),new Font(bf,25));
            header.setAlignment(1);
            bill.add(header);
            Paragraph l = new Paragraph(line);
            l.setAlignment(1);
            bill.add(l);
            
            String[] cellHeader = {"Mã SP","Tên SP","SL","Đơn Giá (VNĐ)"};
            
            PdfPTable t = new PdfPTable(cellHeader.length);
            t.setSpacingAfter(25);
            t.setSpacingBefore(5);
            int[] relativeWidths = {20,80,10,40};
            t.setWidths(relativeWidths);
            
            for(String s : cellHeader)
            {
                t.addCell(createCell(s, new Font(bf,13)));
            }    
            for(ChiTietHDDTO ct : cthd)
            {
                t.addCell( createCell(ct.getMaSP()) );
                t.addCell( createCell(ct.getTenSP()) );
                t.addCell( createCell(String.valueOf(ct.getSl())) );
                t.addCell( createCell(String.valueOf(ct.getGia())) );
            }
            
            
            bill.add(t);
            
            
            
            bill.close();
            System.out.println("Done");
            
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(outBill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(outBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    public PdfPCell createCell(String s)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
    public PdfPCell createCell(String s,Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
}
