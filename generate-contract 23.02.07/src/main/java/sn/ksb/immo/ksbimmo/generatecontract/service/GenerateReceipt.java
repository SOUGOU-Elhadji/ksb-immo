package sn.ksb.immo.ksbimmo.generatecontract.service;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Paragraph;

import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sn.ksb.immo.ksbimmo.generatecontract.model.Form;


import java.io.IOException;

@Service
public class GenerateReceipt {

    public void receipt(HttpServletResponse response ,@RequestBody Form formRequest) throws IOException {
        String dest = "/Users/macbookpro/Documents/contrats/receipt";


        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);
        PageSize PageSize = new PageSize(150,100);
        // Creating a Document
        Document document = new Document(pdf, PageSize);


        Paragraph paragraph = new Paragraph();
        Text text1 = new Text("la somme de :").setFontSize(8).setBorder(new SolidBorder(1));
        Text text2 = new Text("pour--------------").setFontSize(8);
        Text text3 = new Text("à------------").setFontSize(8);
        Text text4 = new Text(" le---------").setFontSize(8);
        paragraph.add(text1);
        paragraph.add(text2);
        paragraph.add(text3);
        paragraph.add(text4);


        document.add(paragraph);



        // Closing the document
        document.close();
        System.out.println("Paragraph added");
    }


}
