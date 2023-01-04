package sn.ksb.immo.ksbimmo.generatecontract.service;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;

import com.itextpdf.layout.element.Table;
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
        PageSize PageSize = new PageSize(400,300);
        // Creating a Document
        Document document = new Document(pdf, PageSize);

        float twcol=285f;
        float twcol150= twcol +150f;
        float twcolumnWith[]={twcol150,twcol150};
        float threecol= 285f;
         float threecolumnWith[] = {twcol150,twcol};
         float fullwidth[]= {threecol*3};

         Paragraph onesp = new Paragraph("\n");

        document.add(createParagraph("Quittance de Loyer").setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(12));


        Table table = new Table(twcolumnWith);



        /*Table nestedtable1 =new Table(new float []{twcol/2}).setFontSize(8f).setBorderRight(Border.NO_BORDER);
        nestedtable1.addCell(new Cell().add("Nom de la société: ").setBold().setBorder(Border.NO_BORDER));
        nestedtable1.addCell(new Cell().add("Adresse :").setBold().setBorder(Border.NO_BORDER));
        nestedtable1.addCell(new Cell().add("Ville").setBold().setBorder(Border.NO_BORDER));*/



       Table nestedtable1 =new Table(new float []{twcol/2}).setFontSize(8f).setBorderLeft(Border.NO_BORDER);









        Table nestedtable2 =new Table(new float []{threecol/2}).setFontSize(8f);

        nestedtable2.addCell(new Cell().add("Nom du locataire :").setBold().setBorder(Border.NO_BORDER));
        nestedtable2.addCell(new Cell().add("Téléphone du locataire:").setBold().setBorder(Border.NO_BORDER));



       // table.addCell(new Cell().add(nestedtable1.setBorder(Border.NO_BORDER)));
        //table.addCell(new Cell().add(nestedtable2.setBorder(Border.NO_BORDER)));

        table.addCell(new Cell().add("Nom de la sociéte: _____________").setFontSize(8f).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add("Reçu N°:_______________").setFontSize(8f).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add("Adresse:______________").setFontSize(8f).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add("Date: ___________________ \n\n ").setFontSize(8f).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add("Ville: _______________").setFontSize(8f).setBorder(Border.NO_BORDER));





        //table.addCell(new Cell().add("Locataire").setFontSize(10f).setBorder(Border.NO_BORDER));

       // table.addCell(new Cell().add(nestedtable1.setBorder(Border.NO_BORDER)));

        table.addCell(new Cell().add(nestedtable2.setBorder(Border.NO_BORDER)));



        //Border gb = new SolidBorder(Color.GRAY,2f);
        //Table divider = new Table(fullwidth);
       // divider.setBorder(gb);
        document.add(table);
        document.add(onesp);
        //document.add(divider);




        document.add(createParagraph("la somme de  ____________________________________\n"+
                          "pour la location à _________________________________  \n" +
                "le   __________________________________________").setFontSize(8f));

document.add(createParagraph("Signature du bailleur"));




        // Closing the document
        document.close();
        System.out.println("Paragraph added");
    }

    private static Paragraph createParagraph(String text) throws IOException {


        Paragraph paragraph = new Paragraph(text).setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));


        return paragraph;
    }


}
