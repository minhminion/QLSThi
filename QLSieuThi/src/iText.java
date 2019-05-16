
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class iText {
    public static void main(String[] args) {
                
		// Tạo đối tượng tài liệu       
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {

			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("./report/iText.pdf"));

			// Mở file để thực hiện ghi
			document.open();

                        BaseFont bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// Thêm nội dung sử dụng add function
			document.add(new Paragraph("Hóa đơn",new Font(bf,25)));

                        
                        PdfPTable t = new PdfPTable(3);
                        t.setSpacingBefore(25);
                        t.setSpacingAfter(25);

                        PdfPCell c1 = new PdfPCell(new Phrase("Header1"));
                        t.addCell(c1);
                        PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
                        t.addCell(c2);
                        PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
                        t.addCell(c3);

                        for(int aw = 0; aw < 16; aw++)
                        {
                            t.addCell(String.valueOf(aw));
                        }

                        document.add(t);
                        
			// Đóng File
			document.close();
			System.out.println("Write file succes!");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException ex) {
            Logger.getLogger(iText.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
