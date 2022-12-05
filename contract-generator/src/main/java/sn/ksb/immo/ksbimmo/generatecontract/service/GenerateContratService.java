package sn.ksb.immo.ksbimmo.generatecontract.service;



import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.awt.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GenerateContratService {
 
    private Document document;
    
    private final Font titleFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD, Color.BLACK);
    private final Font chapterFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD, Color.BLACK);
    private final Font subTitleFont = new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE, Color.BLACK);
    private final Font textFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.BLACK);
    private final Font boldFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLACK);
    private final Font italicFont = new Font(Font.TIMES_ROMAN, 12, Font.ITALIC, Color.BLACK);
    private final Font boldItalicFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC, Color.BLACK);

    private final Font fontSignature = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);

    Table table = new Table(2);

    public void simpleContract(HttpServletResponse response) throws IOException {
        document = new Document(PageSize.A4, 70, 70, 70, 70);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Paragraph paragraph = new Paragraph("MANDAT DE GESTION LOCATIVE SIMPLE", titleFont);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(100);


        /*Paragraph paragraphB = new Paragraph("Conformément à la loi, aux règlements et usages en vigueur au Sénégal notamment les\n" +
                "dispositions du COCC (Code des Obligations Civiles et Commerciales) et des actes uniformes de\n" +
                "l’OHAD", textFont);
        paragraphB.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraphB.setSpacingAfter (10);*/






       // paragraph.setBorder(new SolidBorder(1));


        Paragraph paragraph2 = new Paragraph("- Monsieur ………………, né le ………… à DAKAR, es-qualité de ……. et titulaire de la CNI N°………………… " +
                "du ……… ; ci-après désigné le « Mandant » d’une part,", textFont);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);;
        paragraph2.setSpacingAfter(10);



        Paragraph paragraph3 = new Paragraph("- D'une part", textFont);
        paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph3.setSpacingAfter(10);



        Paragraph paragraph4 = new Paragraph("- L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-PIKINE,\n" +
                "représentant le propriétaire Monsieur ou Madame ………, ci - après désigné le « Mandataire »,\n" +
                "d’autre part,", textFont);
        paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph4.setSpacingAfter (10);


        Paragraph paragraph5 = new Paragraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :", textFont);
        paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph5.setSpacingAfter (10);
        

        Paragraph paragraph6 = new Paragraph("Article 1: Objet", subTitleFont);
        paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph6.setSpacingAfter (10);

        Paragraph paragraph7 = new Paragraph("Le propriétaire confie en exclusivité à l’agence K.S.B Immobilier de son immeuble sis à………. Lot N°………. Par conséquent, ni le propriétaire, ni aucune autre personne physique ou morale n’est habilitée à faire rentrer un client sans pour autant passer par l’agence. Le gestionnaire accepte la mission qui lui est confié et s’engage à tout mettre en œuvre pour labonne gestion et la satisfaction du propriétaire.", textFont);
        paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph.setSpacingAfter (10);


        Paragraph paragraph8 = new Paragraph("Article 2: Loyer", subTitleFont);
        paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph8.setSpacingAfter (10);




        Paragraph paragraph9 = new Paragraph(
                "Le loyer est arrêté à la somme de ……………………………\nLe propriétaire a la possibilité de modifier à tout moment les prix fixés tant que le bien n’est pas loué ou que des négociations entamées avec un locataire. Mais il lui faut envoyer au gestionnaire un mail ou un courrier signé dans ce sens. Les loyers perçus seront versés au propriétaire au plus tard le 10 ou 15 de chaque fin de mois, par virement bancaire (joindre RIB ou IBAN), chèque ou en espèce selon ce qui a été convenu.", textFont);
        paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph9.setSpacingAfter (10);




        Paragraph paragraph10 = new Paragraph("Chapitre I: Les obligations du mandataire", chapterFont);
        paragraph10.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph10.setSpacingAfter(10);




        Paragraph paragraph11 = new Paragraph("Article 3: Missions du mandataire", subTitleFont);
        paragraph11.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph11.setSpacingAfter(10);




        Paragraph paragraph12 = new Paragraph(
                "En conséquence du présent mandat, le propriétaire autorise le gestionnaire à accomplir pour son\n" +
                        "compte et en son nom tout acte d’administration notamment:", textFont);
        paragraph12.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph12.setSpacingAfter(10);




        List list = new List();
        list.setListSymbol("\u2022");
        list.setIndentationLeft(20);
        list.setSymbolIndent(10);
        //set indentation after symbol
        list.setSymbolIndent(10);
        list.add((new ListItem("\tReprésenter le propriétaire pour tous les aspects de la gérance de l’immeuble,",textFont)));
        list.add((new ListItem("\tRédiger les contrats de location ou leur renouvellement, les signer suivant les conditions\n arrêtées avec le propriétaire,",textFont)));

        list.add((new ListItem("\tEncaisser, percevoir tous les loyers cautions et autres charges relatives au bien géré,",textFont)));
        list.add((new ListItem("\tDonner quittance, reçu et décharges",textFont)));
        list.add((new ListItem("\tVerser mensuellement dans le compte du propriétaire les loyers perçus,",textFont)));
        list.add((new ListItem("\tProcéder à la révision du loyer suivant les indications du propriétaire et du contrat,",textFont)));
        list.add((new ListItem("\tInformer le propriétaire sur les travaux lui incombant, dans les lieux loués, les effectuer\n" +
                "sur accord entre le propriétaire et le gestionnaire,",textFont)));
        list.add((new ListItem("\tRechercher activement des locataires, louer les biens après avoir avisé le propriétaire de\n" +
                "leurs vacances,",textFont)));
        list.add((new ListItem("\tFaire les versements aux impôts de la TOM et toutes les autres taxes relatives à la location\n" +
                "de biens immobiliers (sur demande du propriétaire et validation par le gestionnaire).",textFont)));
        list.add((new ListItem("\tIntervenir auprès des compagnies d’assurance en cas de sinistre,",textFont)));
        list.add((new ListItem("\tDresser ou faire les constats avec le support d’huissiers (frais à la charge du propriétaire);", textFont)));


        Paragraph paragraph13 = new Paragraph(
                "Le gestionnaire informera le propriétaire des loyers impayés et un document sur la\n" +
                        "situation financière qui sera présenté tous les mois depuis son espace extranet.", textFont);
        paragraph13.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph13.setSpacingAfter(10);

        Paragraph paragraph14 = new Paragraph(
                "De même en cas de difficultés, ou de non-paiement de loyer, le propriétaire donne mandat exprès\n" +
                        "au gestionnaire qui l’accepte, le temps de diligenter tant en demande qu’en défense toutes\n" +
                        "actions judiciaires, tous commandements, sommations, assignations et citations devant tous\n" +
                        "tribunaux et toutes commissions administratives, se concilier ou requérir au jugement, les faire\n" +
                        "signer et exécuter, se faire remettre tous les titres ou pièces, le tout dans le respect des\n" +
                        "dispositions légales.", textFont);
        paragraph14.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph14.setSpacingAfter(10);



        Paragraph paragraph15 = new Paragraph("Article 4: Gestion de bonne foi", subTitleFont);
        paragraph15.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph15.setSpacingAfter(10);

        Paragraph paragraph16 = new Paragraph(
                "Le gestionnaire promet de gérer la propriété qui lui est confiée en bon père de famille, suivant les\n" +
                        "usages en la matière. Il répondra de ses obligations du fait du présent mandat vis-à-vis des tiers\n" +
                        "que du propriétaire.", textFont);
        paragraph16.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph16.setSpacingAfter(10);

        Paragraph paragraph17 = new Paragraph("Chapitre II: Les obligations du Mandant", titleFont);
        paragraph17.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph17.setSpacingAfter(10);


        Paragraph paragraph18 = new Paragraph("Article 5 : les engagements du propriétaire", subTitleFont);
        paragraph18.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph18.setSpacingAfter(10);


        Paragraph paragraph19 = new Paragraph(
                "Il s’interdit toutes actions directes pour la gestion de la propriété sauf en informer le gestionnaire\n" +
                        "par écrit et d’avance il demeurera dans ce cas seul responsable de ses actes. Il ne pourra pendant\n" +
                        "toute la durée de gérance recouvrer directement les loyers, charges, clés ou contracter\n" +
                        "directement avec une tierce personne. Le propriétaire s’engage à ne pas confier aucune autre\n" +
                        "personne physique ou morale la location ou la gestion des biens immobiliers pendant toute la\n" +
                        "durée du mandat.", textFont);
        paragraph19.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph19.setSpacingAfter(10);


        Paragraph paragraph20 = new Paragraph("Chapitre III: disposions générales", titleFont);
        paragraph20.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph20.setSpacingAfter(10);

        Paragraph paragraph21 = new Paragraph("Article 6 : durée", subTitleFont);
        paragraph21.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph21.setSpacingAfter(10);


        Paragraph paragraph22 = new Paragraph(
                "Le contrat est consenti pour une durée d’un (03) ans renouvelables par tacite reconduction et\n" +
                        "prendra effet à la date de sa signature par les deux parties.", textFont);
        paragraph22.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph22.setSpacingAfter(10);


        Paragraph paragraph23 = new Paragraph("Article 7 : Condition de location", subTitleFont);
        paragraph23.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph23.setSpacingAfter(10);


        Paragraph paragraph24 = new Paragraph(
                "Chaque locataire devra verser d’avance hormis les frais d’agence, deux mois représentant\n" +
                        "le premier mois de loyer et la caution, ainsi les commissions à versé à l’agence.\n" +
                        "Le locataire devra fournir des documents justificatifs financiers.\n" +
                        "En cas de rupture du présent mandat de gérance, le gestionnaire s’engage à transférer tous les\n" +
                        "contrats en cours.", textFont);
        paragraph24.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph24.setSpacingAfter(10);



        Paragraph paragraph25 = new Paragraph("Article 8: Frais de gestion de l’immeuble", subTitleFont);
        paragraph25.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph25.setSpacingAfter(10);



        Paragraph paragraph26 = new Paragraph(
                "Les frais de gestion de l’immeuble sont d’un forfait mensuel de 1O% des recettes du bien objet du\n" +
                        "contrat de mandat.\n", textFont);
        paragraph26.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph26.setSpacingAfter(10);




        Paragraph paragraph27 = new Paragraph("Chapitre IV: Gestion de litiges", subTitleFont);
        paragraph27.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph27.setSpacingAfter(10);


        Paragraph paragraph28 = new Paragraph("Article 9 : Résiliation du mandat", subTitleFont);
        paragraph28.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph28.setSpacingAfter(10);


        Paragraph paragraph29 = new Paragraph(
                "Moyennant un préavis de trois (06) mois envoyé par lettre recommandé les deux parties peuvent\n" +
                        "résilier le présent contrat.", textFont);
        paragraph29.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph29.setSpacingAfter(10);


        Paragraph paragraph30 = new Paragraph(" Article 10 Clause Résolutoire", subTitleFont);
        paragraph30.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph30.setSpacingAfter(10);

        Paragraph paragraph31 = new Paragraph(
                "En cas de mise en vente du bien objet du présent protocole, le propriétaire pourrait mettre fin au\n" +
                        "mandat avec un préavis de 3 mois. Dans ce cas de figure, l’agence aurait la primauté sur la vente\n" +
                        "en tant qu’agent du bailleur.", textFont);
        paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph31.setSpacingAfter(10);



        Paragraph paragraph32 = new Paragraph(" Article 11 : Non-respect des engagements", subTitleFont);
        paragraph32.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph32.setSpacingAfter(10);


        Paragraph paragraph33 = new Paragraph(
                "Le non-respect des engagements de ce contrat sera porté au tribunal de commerce.", textFont);
        paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph33.setSpacingAfter(10);

        Paragraph paragraph34 = new Paragraph(" Article 12 : Election de domicile", subTitleFont);
        paragraph34.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph34.setSpacingAfter(10);


        Paragraph paragraph35 = new Paragraph(
                "Pour l’exécution des présentes, les parties élisent domicile :", textFont);
        paragraph35.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph35.setSpacingAfter(5);


        Paragraph paragraph36 = new Paragraph(
                "Le gestionnaire dans ses locaux sis à la cité Lobatt Fall villa n°25,\n" +
                        "Le propriétaire à son adresse ci- dessus nommée", textFont);
        paragraph36.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph36.setSpacingAfter(30);




        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());
        //create a text line
        Phrase phrase = new Phrase("Fait à Dakar le : \t \t ", textFont);
        Phrase phrase1 = new Phrase(currentDateTime, boldItalicFont);
        //combine the phrases
        Phrase phrase2 = new Phrase();
        phrase2.add(phrase);
        phrase2.add(phrase1);

        Paragraph paragraph37 = new Paragraph(phrase2);
        paragraph37.setAlignment(Paragraph.ALIGN_RIGHT);
        paragraph37.setSpacingAfter(10);


        document.add(paragraph);
        //document.add(paragraphB);
        document.add(paragraph2);

        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);
        document.add(paragraph12);
        document.add(list);
        document.add(paragraph13);
        document.add(paragraph14);
        document.add(paragraph15);
        document.add(paragraph16);
        document.add(paragraph17);
        document.add(paragraph18);
        document.add(paragraph19);
        document.add(paragraph20);
        document.add(paragraph21);
        document.add(paragraph22);
        document.add(paragraph23);
        document.add(paragraph24);
        document.add(paragraph25);
        document.add(paragraph26);
        document.add(paragraph27);
        document.add(paragraph28);
        document.add(paragraph29);
        document.add(paragraph30);
        document.add(paragraph31);
        document.add(paragraph32);
        document.add(paragraph33);
        document.add(paragraph34);
        document.add(paragraph35);
        document.add(paragraph36);
        document.add(paragraph37);
        document.add(createSignature("LE MANDANT", "LE MANDATAIRE"));



        document.close();
    }

    public void simpleContractRefactored(HttpServletResponse response) throws IOException {
        document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();


        document.add(createParagraph("MANDAT DE GESTION LOCATIVE SIMPLE", titleFont, Paragraph.ALIGN_CENTER, 10));

        document.add(createParagraph("- Monsieur ………………, né le ………… à DAKAR, es-qualité de ……. et titulaire de la CNI N°………………… " +
                "du ……… ; ci-après désigné le « Mandant » d’une part,", textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("- D'une part", textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("- L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-PIKINE,\n" +
                "représentant le propriétaire Monsieur ou Madame ………, ci - après désigné le « Mandataire »,\n" +
                "d’autre part,", textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :", textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("Article 1 : Objet", subTitleFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("Le propriétaire confie en exclusivité à l’agence K.S.B Immobilier de son immeuble sis à………. Lot N°………. Par conséquent, ni le propriétaire, ni aucune autre personne physique ou morale n’est habilitée à faire rentrer un client sans pour autant passer par l’agence. Le gestionnaire accepte la mission qui lui est confié et s’engage à tout mettre en œuvre pour labonne gestion et la satisfaction du propriétaire."
                , textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("Article 2 : Loyer", subTitleFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("Le loyer est arrêté à la somme de ……………………………\nLe propriétaire a la possibilité de modifier à tout moment les prix fixés tant que le bien n’est pas loué ou que des négociations entamées avec un locataire. Mais il lui faut envoyer au gestionnaire un mail ou un courrier signé dans ce sens. Les loyers perçus seront versés au propriétaire au plus tard le 10 ou 15 de chaque fin de mois, par virement bancaire (joindre RIB ou IBAN), chèque ou en espèce selon ce qui a été convenu.",
                textFont, Paragraph.ALIGN_JUSTIFIED, 10));

        document.add(createParagraph("Chapitre I: Les obligations du mandataire",chapterFont, Paragraph.ALIGN_JUSTIFIED, 10));



        document.close();
    }

    public void bailContract(HttpServletResponse response) throws IOException {
        document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();
        com.lowagie.text.Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        subTitleFont.setSize(18);

        Paragraph paragraph = new Paragraph("ENTRE LES SOUSSIGNÉS :", subTitleFont);
       paragraph.
     setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.

     setSpacingAfter(40);





        com.lowagie.text.Font textFont = FontFactory.getFont(FontFactory.HELVETICA);
        textFont.setSize(10);








        // paragraph.setBorder(new SolidBorder(1));


        Paragraph paragraph2 = new Paragraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur ………, ci - après désigné le\n" +
                "« Bailleur », d’une part,", textFont);
        paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph2.setSpacingAfter(10);



        Paragraph paragraph3 = new Paragraph("ET", subTitleFont);
        paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph3.setSpacingAfter(10);



        Paragraph paragraph4 = new Paragraph("-Monsieur………………, né le ………… à DAKAR, es-qualité de ……. et titulaire de la\n" +
                "CNI N°…………………. Du……… ; ci-après désigné le « Preneur », d’autre part,", textFont);
        paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph4.setSpacingAfter(10);



        Paragraph paragraph5 = new Paragraph("ET", subTitleFont);
        paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph5.setSpacingAfter(10);



        subTitleFont.setSize(12);

        Paragraph paragraph6 = new Paragraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :", subTitleFont);
        paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph6.setSpacingAfter(10);

        Paragraph paragraph7 = new Paragraph("Article 1: DÉSIGNATION", subTitleFont);
        paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph7.setSpacingAfter(10);





        Paragraph paragraph8 = new Paragraph(
                "Le Bailleur donne en location, au Preneur qui accepte, un local A USAGE D’HABITATION\n" +
                        "sis ……………………… ……………………. et comprenant :", textFont);
        paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph8.setSpacingAfter(10);



        List list = new List();


        com.lowagie.text.Font fontList = FontFactory.getFont(FontFactory.HELVETICA,10);
        list.add("………………………………………………");
        list.add("………………………………………………");
        list.add("………………………………………………");





        Paragraph paragraph9 = new Paragraph(
                "Un état des lieux contradictoire sera fait avant l’occupation effective des locaux. A défaut le\n" +
                        "preneur est réputé avoir accepté les locaux en l’état.", textFont);
        paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph9.setSpacingAfter(50);




        Paragraph paragraph10 = new Paragraph("Article 2 : DURÉE DU BAIL", subTitleFont);
        paragraph10.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph10.

     setSpacingAfter(10);


        Paragraph paragraph11 = new Paragraph(
                "Le présent bail est consenti pour une durée de trois (03) ans renouvelables par tacite\n" +
                        "reconduction et prend effet à compter du ……………………", textFont);
        paragraph11.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph11.

     setSpacingAfter(10);

        Paragraph paragraph12 = new Paragraph(
                "En cas de dénonciation du présent contrat, le Bailleur est tenu de donner un préavis de six\n" +
                        "(06) mois et le Preneur un préavis écrit de deux (03) mois.", textFont);
        paragraph12.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph12.

     setSpacingAfter(10);






        Paragraph paragraph13 = new Paragraph("Article 3 : LOYER", subTitleFont);
        paragraph13.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph13.

     setSpacingAfter(10);


        Paragraph paragraph14 = new Paragraph(
                "La présente location est consentie et acceptée pour un loyer mensuel de\n" +
                        "…………………francs CFA tous taxes et charges.", textFont);
        paragraph14.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph14.

     setSpacingAfter(10);


        Paragraph paragraph15 = new Paragraph(
                "Le loyer est payable à la fin de chaque mois et au plus tard le 05 du mois suivant.", textFont);
        paragraph15.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph15.

     setSpacingAfter(10);





        Paragraph paragraph16 = new Paragraph(
                "Tout mois commencé est dû. Le loyer est portable et non quérable et les frais liés aux retards\n" +
                        "de paiement sont à la charge du Preneur. Tous les paiements devront être effectués, soit en\n" +
                        "espèces, soit par chèques bancaires entre les mains du bailleur, soit par virements bancaires\n" +
                        "au numéro de compte que le bailleur indiquera au Preneur.", textFont);
        paragraph16.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph16.

     setSpacingAfter(10);

        Paragraph paragraph17 = new Paragraph("Article 4 : CAUTION", subTitleFont);
        paragraph17.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph17.

     setSpacingAfter(10);



        Paragraph paragraph18 = new Paragraph(
                " Avant l’entrée en jouissance, le Preneur devra verser, à titre d’avance, la somme de ……….\n" +
                        "Francs CFA (0.00 FCFA), à titre de caution détenue par l’Agence. Cette somme non\n" +
                        "productive d’intérêts ne sera restituée au Preneur qu’après remise des lieux en parfait état\n" +
                        "locatif.\n" +
                        "Il sera prélevé sur cette caution, les sommes correspondantes aux frais éventuels de remise en\n" +
                        "état des lieux, ainsi toutes les charges que le preneur pourrait devoir comme charge locative.\n", textFont);
        paragraph18.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph18.

     setSpacingAfter(10);


        Paragraph paragraph19 = new Paragraph("Article 5: CHARGES ET CONDITIONS", subTitleFont);
        paragraph19.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph19.

     setSpacingAfter(10);


        Paragraph paragraph20 = new Paragraph(
                "Le présent bail est consenti et accepté aux charges et conditions ordinaires de droit ci-après\n" +
                        "stipulées :", textFont);
        paragraph20.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph20.

     setSpacingAfter(10);


        Paragraph paragraph21 = new Paragraph(
                "5.1 - Le Preneur garnira les lieux et les tiendra constamment fournis de mobiliers et matériels\n" +
                        "en qualité et valeur suffisantes, pour garantir le paiement des loyers et charges.", textFont);
        paragraph21.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph21.

     setSpacingAfter(10);





        Paragraph paragraph22 = new Paragraph(
                "5.2. - Le preneur s’engage à faire assurer tous les objets mobiliers contenus dans les locaux\n" +
                        "loués contre l’incendie, les risques locatifs et le recours des voisins, auprès d’une Compagnie\n" +
                        "d’assurance dûment agrée au Sénégal et notoirement solvable.", textFont);
        paragraph22.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph22.

     setSpacingAfter(10);

        Paragraph paragraph23 = new Paragraph(
                "5.3. - Le preneur acquittera la Taxe d’enlèvement des ordures ménagères et toutes\n" +
                        "contributions résultant de son occupation, ainsi que les consommations d’eau et d’électricité,\n" +
                        "afin que le Bailleur ne soit nullement inquiété pendant la durée du contrat ou à l’expiration de\n" +
                        "celui-ci.\n" +
                        "En cas de paiement par chèques, le loyer ne sera considéré comme réglé qu’après son\n" +
                        "encaissement, nonobstant la remise de la quittance. La clause résolutoire pourra être acquise.", textFont);
        paragraph23.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph23.

     setSpacingAfter(10);




        Paragraph paragraph24 = new Paragraph(
                "5.4 - Le preneur ne pourra sous-louer tout ou partie des lieux sans l’autorisation écrite du\n" +
                        "bailleur.", textFont);
        paragraph24.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph24.

     setSpacingAfter(10);


        Paragraph paragraph25 = new Paragraph(
                "5.5 - Le preneur ne pourra faire aucune modification ou transformation dans l’état ou la\n" +
                        "disposition des locaux sans l’autorisation préalable, par écrit, du bailleur.", textFont);
        paragraph25.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph25.

     setSpacingAfter(10);



        Paragraph paragraph26 = new Paragraph(
                "Tous aménagements, embellissements ou améliorations bénéficieront au Bailleur à la fin du\n" +
                        "bail, s’ils ne sont pas susceptibles d’être détachés du local sans dommages pour celui-ci.", textFont);
        paragraph26.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph26.

     setSpacingAfter(10);


        Paragraph paragraph27 = new Paragraph(
                "5.6 - Le preneur ne sera tenu qu’aux réparations locatives, le bailleur étant tenu aux grosses\n" +
                        "réparations. Le Preneur entretiendra les lieux en bon état et les restituera en bon état. Il sera\n" +
                        "tenu de refaire les peintures intérieures avant de quitter les lieux, quelle qu’ait été la durée de\n" +
                        "l’occupation.", textFont);
        paragraph27.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph27.

     setSpacingAfter(10);



        Paragraph paragraph28 = new Paragraph("Article 6: FRAIS DE RECOUVREMENT", subTitleFont);
        paragraph28.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph28.

     setSpacingAfter(10);


        Paragraph paragraph29 = new Paragraph(
                "Tous frais pour des diligences tendant au recouvrement des loyers non payés à l’échéance\n" +
                        "convenue, suite à un commandement, seront à la charge du Preneur en sus des intérêts de\n" +
                        "droit et des frais répétables.", textFont);
        paragraph29.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph29.

     setSpacingAfter(10);


        Paragraph paragraph30 = new Paragraph("Article 7 : CLAUSE RÉSOLUTOIRE", subTitleFont);
        paragraph30.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph30.

     setSpacingAfter(10);

        Paragraph paragraph31 = new Paragraph(
                "A défaut de paiement d’un seul terme de loyer à son échéance ou d’inexécution d’une\n" +
                        "quelconque des clauses et conditions du bail, celui-ci sera résilié de plein droit, si bon semble\n" +
                        "au bailleur, 30 jours après une simple mise en demeure restée sans effet.\n" +
                        "Le juge saisi constatera la résiliation du bail et, si nécessaire, prononcera l’expulsion du\n" +
                        "Preneur par simple ordonnance de référé.", textFont);
        paragraph31.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph31.

     setSpacingAfter(10);



        Paragraph paragraph32 = new Paragraph("Article 8 : ENREGISTREMENT", subTitleFont);
        paragraph32.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph32.

     setSpacingAfter(10);


        Paragraph paragraph33 = new Paragraph(
                "Les frais du présent contrat, ainsi que les droits de timbre et d’enregistrement sont à la charge\n" +
                        "exclusive du Preneur. L’enregistrement est requis pour la durée du bail et, en cas de\n" +
                        "reconduction, le Preneur le requiert pour les périodes ultérieures.", textFont);
        paragraph33.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph33.

     setSpacingAfter(10);

        Paragraph paragraph34 = new Paragraph("Article 9 : LITIGES", subTitleFont);
        paragraph34.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph34.

     setSpacingAfter(10);


        Paragraph paragraph35 = new Paragraph(
                "Le présent contrat est soumis aux dispositions du Code des obligations civiles et\n" +
                        "commerciales en la matière. En cas de litige, la solution amiable est privilégiée. A défaut\n" +
                        "d’accord entre les parties, il sera fait recours au Tribunal compétent selon l’objet du litige.", textFont);
        paragraph35.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph35.

     setSpacingAfter(10);

        Paragraph paragraph36 = new Paragraph("Article 10 : ÉLECTION DE DOMICILE\n", subTitleFont);
        paragraph36.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph36.

     setSpacingAfter(10);



        Paragraph paragraph37 = new Paragraph(
                "Pour l’exécution des présentes et de leurs suites, les parties font élection de domicile :", textFont);
        paragraph37.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph37.

     setSpacingAfter(10);




        List listTwo = new List();

        listTwo.add((new ListItem("Le Bailleur : au 570 C sis ………………………...",fontList)));
        listTwo.add((new ListItem("Le Preneur : au 570 C sis ………………………....",fontList)));



        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        Paragraph paragraph38 = new Paragraph(
                "FAIT A DAKAR EN DEUX (03) ORIGINAUX LE :" + currentDateTime, textFont);
        paragraph38.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph38.

     setSpacingAfter(10);

        Paragraph paragraph39 = new Paragraph(
                "LE MANDANT                                                     LE MANDATAIRE", textFont);
        paragraph39.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph39.

     setSpacingAfter(10);





        document.add(paragraph);
        //document.add(paragraphB);
        document.add(paragraph2);

        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(list);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);
        document.add(paragraph12);
        document.add(paragraph13);
        document.add(paragraph14);
        document.add(paragraph15);
        document.add(paragraph16);
        document.add(paragraph17);
        document.add(paragraph18);
        document.add(paragraph19);
        document.add(paragraph20);
        document.add(paragraph21);
        document.add(paragraph22);
        document.add(paragraph23);
        document.add(paragraph24);
        document.add(paragraph25);
        document.add(paragraph26);
        document.add(paragraph27);
        document.add(paragraph28);
        document.add(paragraph29);
        document.add(paragraph30);
        document.add(paragraph31);
        document.add(paragraph32);
        document.add(paragraph33);
        document.add(paragraph34);
        document.add(paragraph35);
        document.add(paragraph36);
        document.add(paragraph37);
        document.add(listTwo);
        document.add(paragraph38);
        document.add(paragraph39);




        document.close();
    }



    public void gliContract(HttpServletResponse response) throws IOException {
        document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();
        com.lowagie.text.Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        subTitleFont.setSize(18);

        Paragraph paragraph = new Paragraph("MANDAT DE GESTION LOCATIVE SURETE GLI", subTitleFont);
       paragraph.
     setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.

     setSpacingAfter(50);





        com.lowagie.text.Font textFont = FontFactory.getFont(FontFactory.HELVETICA);
        textFont.setSize(10);

        /*Paragraph paragraphB = new Paragraph("Conformément à la loi, aux règlements et usages en vigueur au Sénégal notamment les\n" +
                "dispositions du COCC (Code des Obligations Civiles et Commerciales) et des actes uniformes de\n" +
                "l’OHAD", textFont);
        paragraphB.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraphB.

     setSpacingAfter(10);*/






        // paragraph.setBorder(new SolidBorder(1));


        Paragraph paragraph2 = new Paragraph("ENTRE-LES soussignés", textFont);
        paragraph2.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph2.

     setSpacingAfter(10);



        Paragraph paragraph3 = new Paragraph("-Monsieur………………, né le ………… à DAKAR, es-qualité de ……. Et titulaire de la\n" +
                "CNI N°…………………. Du……… ; ci-après désigné le « Mandant » d’une part,", textFont);
        paragraph3.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph3.

     setSpacingAfter(10);



        Paragraph paragraph4 = new Paragraph("D’UNE part", textFont);
        paragraph4.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph4.

     setSpacingAfter(10);


        Paragraph paragraph5 = new Paragraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur ou Madame ………, ci - après désigné le\n" +
                "« Mandataire », d’autre part,", textFont);
        paragraph5.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph5.

     setSpacingAfter(10);


        subTitleFont.setSize(12);

        Paragraph paragraph6 = new Paragraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :", subTitleFont);
        paragraph6.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph6.

     setSpacingAfter(10);


        Paragraph paragraph7 = new Paragraph("Article 1: Objet", subTitleFont);
        paragraph7.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph7.

     setSpacingAfter(10);


        Paragraph paragraph77 = new Paragraph(
                "Le propriétaire confie en exclusivité à l’agence K.S.B Immobilier de son immeuble sis à……….\n" +
                        "Lot N°………. Par conséquent, ni le propriétaire, ni aucune autre personne physique ou\n" +
                        "morale n’est habilitée à faire rentrer un client sans pour autant passer par l’agence.\n" +
                        "Le gestionnaire accepte la mission qui lui est confié et s’engage à tout mettre en œuvre\n" +
                        "pour la bonne gestion et la satisfaction du propriétaire.", textFont);
        paragraph77.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph77.

     setSpacingAfter(50);






        Paragraph paragraph8 = new Paragraph("Article 2: Loyer", subTitleFont);
        paragraph8.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph8.

     setSpacingAfter(10);





        Paragraph paragraph9 = new Paragraph(
                "Le loyer est arrêté à la somme de ……………………………………………………………………….Le propriétaire a la possibilité de modifier à tout moment les prix fixés tant que le bien n’est pas loué ou que des négociations entamées avec un locataire. Mais il lui faut envoyer au gestionnaire un mail ou un courrier signé dans ce sens. Les loyers perçus seront versés au propriétaire au plus tard le 10 ou 15 de chaque fin de mois, par virement bancaire (joindre RIB ou IBAN), chèque ou en espèce selon ce qui a été convenu.", textFont);
        paragraph9.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph9.setSpacingAfter(50);




        Paragraph paragraph10 = new Paragraph("Chapitre I: Les obligations du mandataire", subTitleFont);
        paragraph10.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph10.setSpacingAfter(10);




        Paragraph paragraph11 = new Paragraph("Article 3: Missions du mandataire", subTitleFont);
        paragraph11.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph11.setSpacingAfter(10);




        Paragraph paragraph12 = new Paragraph(
                "En conséquence du présent mandat, le propriétaire autorise le gestionnaire à accomplir pour son\n" +
                        "compte et en son nom tout acte d’administration notamment:", textFont);
        paragraph12.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph12.setSpacingAfter(10);




        List list = new List();
        com.lowagie.text.Font fontList = FontFactory.getFont(FontFactory.HELVETICA,10);


        list.add((new ListItem("Représenter le propriétaire pour tous les aspects de la gérance de l’immeuble,",fontList)));

        list.add((new ListItem("Rédiger les contrats de location ou leur renouvellement, les signer suivant les conditions\n" +
                "arrêtées avec le propriétaire,",fontList)));
        list.add((new ListItem("Encaisser, percevoir tous les loyers cautions et autres charges relatives au bien géré,",fontList)));
        list.add((new ListItem("Donner quittance, reçu et décharges",fontList)));
        list.add((new ListItem("Verser mensuellement dans le compte du propriétaire les loyers perçus,",fontList)));
        list.add((new ListItem("Procéder à la révision du loyer suivant les indications du propriétaire et du contrat,",fontList)));
        list.add((new ListItem("Informer le propriétaire sur les travaux lui incombant, dans les lieux loués, les effectuer\n" +
                "sur accord entre le propriétaire et le gestionnaire,",fontList)));
        list.add((new ListItem("Rechercher activement des locataires, louer les biens après avoir avisé le propriétaire de\n" +
                "leurs vacances,",fontList)));
        list.add((new ListItem("Faire les versements aux impôts de la TOM et toutes les autres taxes relatives à la location\n" +
                "de biens immobiliers (sur demande du propriétaire et validation par le gestionnaire).",fontList)));
        list.add((new ListItem("Intervenir auprès des compagnies d’assurance en cas de sinistre,",fontList)));
        list.add((new ListItem("Dresser ou faire les constats avec le support d’huissiers (frais à la charge du propriétaire);", fontList)));


        Paragraph paragraph13 = new Paragraph(
                "Le gestionnaire informera le propriétaire des loyers impayés et un document sur la\n" +
                        "situation financière qui sera présenté tous les mois depuis son espace extranet.", textFont);
        paragraph13.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph13.setSpacingAfter(10);

        Paragraph paragraph14 = new Paragraph(
                "De même en cas de difficultés, ou de non-paiement de loyer, le propriétaire donne mandat exprès\n" +
                        "au gestionnaire qui l’accepte, le temps de diligenter tant en demande qu’en défense toutes\n" +
                        "actions judiciaires, tous commandements, sommations, assignations et citations devant tous\n" +
                        "tribunaux et toutes commissions administratives, se concilier ou requérir au jugement, les faire\n" +
                        "signer et exécuter, se faire remettre tous les titres ou pièces, le tout dans le respect des\n" +
                        "dispositions légales.", textFont);
        paragraph14.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph14.setSpacingAfter(10);

        Paragraph paragraph144 = new Paragraph("Article 4: Garantie du prix du loyer", subTitleFont);
        paragraph144.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph144.setSpacingAfter(10);


        Paragraph paragraph1444 = new Paragraph(
                "Le gestionnaire s’engage au paiement du loyer nonobstant la cessation du paiement du\n" +
                        "locataire dans les cinq (5) mois qui suit.", textFont);
        paragraph1444.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph1444.setSpacingAfter(10);




        Paragraph paragraph15 = new Paragraph("Article 5: Gestion de bonne foi", subTitleFont);
        paragraph15.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph15.setSpacingAfter(10);

        Paragraph paragraph16 = new Paragraph(
                "Le gestionnaire promet de gérer la propriété qui lui est confiée en bon père de famille, suivant les\n" +
                        "usages en la matière. Il répondra de ses obligations du fait du présent mandat vis-à-vis des tiers\n" +
                        "que du propriétaire.", textFont);
        paragraph16.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph16.setSpacingAfter(10);

        Paragraph paragraph17 = new Paragraph("Chapitre II: Les obligations du Mandant", subTitleFont);
        paragraph17.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph17.setSpacingAfter(10);


        Paragraph paragraph18 = new Paragraph("Article 6 : les engagements du propriétaire", subTitleFont);
        paragraph18.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph18.setSpacingAfter(10);


        Paragraph paragraph19 = new Paragraph(
                "Il s’interdit toutes actions directes pour la gestion de la propriété sauf en informer le gestionnaire\n" +
                        "par écrit et d’avance il demeurera dans ce cas seul responsable de ses actes. Il ne pourra pendant\n" +
                        "toute la durée de gérance recouvrer directement les loyers, charges, clés ou contracter\n" +
                        "directement avec une tierce personne. Le propriétaire s’engage à ne pas confier aucune autre\n" +
                        "personne physique ou morale la location ou la gestion des biens immobiliers pendant toute la\n" +
                        "durée du mandat.", textFont);
        paragraph19.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph19.setSpacingAfter(10);


        Paragraph paragraph20 = new Paragraph("Chapitre III: disposions générales", subTitleFont);
        paragraph20.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph20.setSpacingAfter(10);

        Paragraph paragraph21 = new Paragraph("Article 7 : durée", subTitleFont);
        paragraph21.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph21.setSpacingAfter(10);


        Paragraph paragraph22 = new Paragraph(
                "Le contrat est consenti pour une durée d’un (03) ans renouvelables par tacite reconduction et\n" +
                        "prendra effet à la date de sa signature par les deux parties.", textFont);
        paragraph22.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph22.setSpacingAfter(10);


        Paragraph paragraph23 = new Paragraph("Article 8 : Condition de location", subTitleFont);
        paragraph23.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph23.setSpacingAfter(10);


        Paragraph paragraph24 = new Paragraph(
                "Chaque locataire devra verser d’avance hormis les frais d’agence, deux mois représentant\n" +
                        "le premier mois de loyer et la caution, ainsi les commissions à versé à l’agence.\n" +
                        "Le locataire devra fournir des documents justificatifs financiers.\n" +
                        "En cas de rupture du présent mandat de gérance, le gestionnaire s’engage à transférer tous les\n" +
                        "contrats en cours.", textFont);
        paragraph24.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph24.setSpacingAfter(10);



        Paragraph paragraph25 = new Paragraph("Article 9: Frais de gestion de l’immeuble", subTitleFont);
        paragraph25.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph25.setSpacingAfter(10);



        Paragraph paragraph26 = new Paragraph(
                "Les frais de gestion de l’immeuble sont d’un forfait mensuel de 1O% des recettes du bien objet du\n" +
                        "contrat de mandat.\n", textFont);
        paragraph26.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph26.setSpacingAfter(10);




        Paragraph paragraph27 = new Paragraph("Chapitre IV: Gestion de litiges", subTitleFont);
        paragraph27.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph27.setSpacingAfter(10);


        Paragraph paragraph28 = new Paragraph("Article 10 : Résiliation du mandat", subTitleFont);
        paragraph28.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph28.setSpacingAfter(10);


        Paragraph paragraph29 = new Paragraph(
                "Moyennant un préavis de trois (06) mois envoyé par lettre recommandé les deux parties peuvent\n" +
                        "résilier le présent contrat.", textFont);
        paragraph29.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph29.setSpacingAfter(10);


        Paragraph paragraph30 = new Paragraph(" Article 11 : Clause Résolutoire", subTitleFont);
        paragraph30.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph30.setSpacingAfter(10);

        Paragraph paragraph31 = new Paragraph(
                "En cas de mise en vente du bien objet du présent protocole, le propriétaire pourrait mettre fin au\n" +
                        "mandat avec un préavis de 3 mois. Dans ce cas de figure, l’agence aurait la primauté sur la vente\n" +
                        "en tant qu’agent du bailleur.", textFont);
        paragraph31.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph31.setSpacingAfter(10);



        Paragraph paragraph32 = new Paragraph(" Article 12 : Non-respect des engagements", subTitleFont);
        paragraph32.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph32.setSpacingAfter(10);


        Paragraph paragraph33 = new Paragraph(
                "Le non-respect des engagements de ce contrat sera porté au tribunal de commerce.", textFont);
        paragraph33.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph33.setSpacingAfter(10);

        Paragraph paragraph34 = new Paragraph(" Article 13 : Election de domicile", subTitleFont);
        paragraph34.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph34.setSpacingAfter(10);


        Paragraph paragraph35 = new Paragraph(
                "Pour l’exécution des présentes, les parties élisent domicile :", textFont);
        paragraph35.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph35.setSpacingAfter(10);


        Paragraph paragraph36 = new Paragraph(
                "Le gestionnaire dans ses locaux sis à la cité Lobatt Fall villa n°25,\n" +
                        "Le propriétaire à son adresse ci- dessus nommée", textFont);
        paragraph36.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph36.setSpacingAfter(10);




        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());
        Paragraph paragraph37 = new Paragraph(
                " FAIT A DAKAR EN DEUX (02) ORIGINAUX LE :" + currentDateTime, textFont);
        paragraph37.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph37.setSpacingAfter(10);



        Paragraph paragraph38 = new Paragraph(
                "LE MANDANT                                        LE MANDATAIRE", textFont);
        paragraph38.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph38.setSpacingAfter(10);





        document.add(paragraph);
        //document.add(paragraphB);
        document.add(paragraph2);

        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph77);
        document.add(paragraph8);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);
        document.add(paragraph12);
        document.add(list);
        document.add(paragraph13);
        document.add(paragraph14);
        document.add(paragraph144);
        document.add(paragraph1444);

        document.add(paragraph15);
        document.add(paragraph16);
        document.add(paragraph17);
        document.add(paragraph18);
        document.add(paragraph19);
        document.add(paragraph20);
        document.add(paragraph21);
        document.add(paragraph22);
        document.add(paragraph23);
        document.add(paragraph24);
        document.add(paragraph25);
        document.add(paragraph26);
        document.add(paragraph27);
        document.add(paragraph28);
        document.add(paragraph29);
        document.add(paragraph30);
        document.add(paragraph31);
        document.add(paragraph32);
        document.add(paragraph33);
        document.add(paragraph34);
        document.add(paragraph35);
        document.add(paragraph36);
        document.add(paragraph37);
        document.add(paragraph38);




        document.close();
    }



    public void bailMeubleContrat(HttpServletResponse response) throws IOException {
        document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();
        com.lowagie.text.Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        subTitleFont.setSize(18);

        Paragraph paragraph0 = new Paragraph("CONTRAT DE BAIL MEUBLE :", subTitleFont);
        paragraph0.
     setAlignment(Paragraph.ALIGN_CENTER);
        paragraph0.setSpacingAfter(40);



        Paragraph paragraph = new Paragraph("ENTRE LES SOUSSIGNÉS :", subTitleFont);
        paragraph.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph.setSpacingAfter(40);





        com.lowagie.text.Font textFont = FontFactory.getFont(FontFactory.HELVETICA);
        textFont.setSize(10);








        // paragraph.setBorder(new SolidBorder(1));


        Paragraph paragraph2 = new Paragraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur ………, ci - après désigné le\n" +
                "« Bailleur », d’une part,", textFont);
        paragraph2.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph2.setSpacingAfter(10);



        Paragraph paragraph3 = new Paragraph("ET", subTitleFont);
        paragraph3.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph3.setSpacingAfter(10);



        Paragraph paragraph4 = new Paragraph("Monsieur………………, né le 00/00/1900 à Dakar, titulaire du Passeport N°00000000000 du\n" +
                "0/00/2000, ci-après désigné le «Preneur», d’autre part,", textFont);
        paragraph4.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph4.setSpacingAfter(10);



        Paragraph paragraph5 = new Paragraph("IL EST PRÉALABLEMENT RAPPELÉ CE QUI SUIT", subTitleFont);
        paragraph5.
     setAlignment(Paragraph.ALIGN_CENTER);
        paragraph5.setSpacingAfter(10);


        Paragraph paragraph55 = new Paragraph("Le présent contrat a pour objet la location d’un Studio meublé à usage d’habitation exclusive.", textFont);
        paragraph55.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph55.setSpacingAfter(10);







        subTitleFont.setSize(12);

        Paragraph paragraph6 = new Paragraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :", subTitleFont);
        paragraph6.
     setAlignment(Paragraph.ALIGN_CENTER);
        paragraph6.setSpacingAfter(10);

        Paragraph paragraph7 = new Paragraph("Article 1: DÉSIGNATION", subTitleFont);
        paragraph7.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph7.setSpacingAfter(10);





        Paragraph paragraph8 = new Paragraph(
                "Le Bailleur donne en location et ce A USAGE D’HABITATION exclusive au Preneur qui accepte :", textFont);
        paragraph8.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph8.setSpacingAfter(10);



        List list = new List();


        Font fontList = FontFactory.getFont(FontFactory.HELVETICA,10);
        list.add("………………………………………………");
        list.add("………………………………………………");
        list.add("………………………………………………");





        Paragraph paragraph9 = new Paragraph(
                "Un état des lieux contradictoire sera fait avant l’occupation effective des locaux si nécessaire. Le cas\n" +
                        "échéant le Preneur déclare bien connaître les lieux qu’il accepte dans leur état actuel sans aucune\n" +
                        "réserve. Il dispense le Bailleur d’une plus ample désignation.", textFont);
        paragraph9.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph9.setSpacingAfter(50);


        Paragraph paragraph99 = new Paragraph("Article 2 : ELEMENTS D’EQUIPEMENTS DU LOGEMENT", subTitleFont);
        paragraph99.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph99.setSpacingAfter(10);

        Paragraph paragraph10 = new Paragraph(
                "Le studio est composé des équipements et biens, ci-après:", textFont);
        paragraph10.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph10.setSpacingAfter(10);






        Paragraph paragraph11 = new Paragraph(
                "1-\n" +
                        "2-\n" +
                        "3-\n" +
                        "4-\n" +
                        "5-\n" +
                        "6-", textFont);
        paragraph11.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph11.setSpacingAfter(10);




        Paragraph paragraph12 = new Paragraph(
                "Une vérification de l’état des biens et un inventaire contradictoire sera fait avant l’occupation effective des\n" +
                        "locaux si nécessaire avec prise de photos annexés au présent contrat.\n" +
                        "A défaut il sera considéré que le preneur accepte les meubles dans leur état actuel sans aucune réserve. Il\n" +
                        "dispense le Bailleur d’une plus ample vérification.", textFont);
        paragraph12.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph12.setSpacingAfter(10);

        Paragraph paragraph13 = new Paragraph(" Article 3: DUREE DU CONTRAT", subTitleFont);
        paragraph13.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph13.setSpacingAfter(10);


        Paragraph paragraph14 = new Paragraph(
                "Le présent bail est consenti pour une durée ……………non renouvelable sauf sollicitation par le\n" +
                        "preneur.\n" +
                        "Le présent bail prend effet à compter du …/…/…. pour prendre fin le …/…/….", textFont);
        paragraph14.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph14.setSpacingAfter(10);





        Paragraph paragraph15 = new Paragraph("Article 4: MONTANT DU LOYER", subTitleFont);
        paragraph15.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph15.setSpacingAfter(10);



        Paragraph paragraph16 = new Paragraph(
                "La présente location est consentie et acceptée pour un loyer journalier de ……………. francs CFA\n" +
                        "(……… FCFA), payable à l’avance avant l’entrée en jouissance.\n" +
                        " La présente location est consentie toutes charges comprises (eau et l’électricité).", textFont);
        paragraph16.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph16.setSpacingAfter(10);


        Paragraph paragraph17 = new Paragraph("Article 5 : DEPOT DE GARANTIE", subTitleFont);
        paragraph17.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph17.setSpacingAfter(10);


        Paragraph paragraph18 = new Paragraph(
                "La somme de …… sera versée à titre de caution avant l’entrée en jouissance. Toutes fois le Preneur\n" +
                        "ne peut quitter les lieux et restituer les clés qu’après remise des lieux en parfait état locatif et après\n" +
                        "inventaire et vérification des biens donnés en location. En cas de dégradation les sommes\n" +
                        "correspondantes aux frais éventuels de remise en état, de réparation des biens et équipements\n" +
                        "énumérés à l’article 2 resterons à la charge de celui-ci.", textFont);
        paragraph18.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph18.setSpacingAfter(10);

        Paragraph paragraph19 = new Paragraph("    Article 6: CHARGES ET CONDITONS", subTitleFont);
        paragraph19.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph19.setSpacingAfter(10);




        Paragraph paragraph20 = new Paragraph(
                "Le présent bail est consenti et accepté aux charges et conditions ordinaires de droit ci-après :", textFont);
        paragraph20.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph20.setSpacingAfter(10);


        Paragraph paragraph21 = new Paragraph(
                "Le preneur s’engage à faire assurer tous les objets mobiliers contenus dans les locaux loués contre\n" +
                        "l’incendie, les risques locatifs et le recours des voisins, auprès d’une Compagnie d’assurance dûment\n" +
                        "agrée au Sénégal et notoirement solvable.", textFont);
        paragraph21.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph21.setSpacingAfter(10);

        Paragraph paragraph22 = new Paragraph(
                "Le Preneur devra satisfaire à toutes les prescriptions des Services de voierie et d’hygiène, afin que le\n" +
                        "bailleur ne soit nullement inquiété à ce sujet.", textFont);
        paragraph22.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph22.setSpacingAfter(10);





        Paragraph paragraph23 = new Paragraph(
                "Le preneur ne pourra sous-louer tout ou partie des lieux sans l’autorisation écrite du bailleur.", textFont);
        paragraph23.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph23.
     setSpacingAfter(10);


        Paragraph paragraph24 = new Paragraph(
                "Le preneur ne pourra faire aucune modification ou transformation dans l’état ou la disposition des\n" +
                        "locaux sans l’autorisation préalable, par écrit, du bailleur.\n" +
                        "Tous aménagements, embellissements ou améliorations bénéficieront au Bailleur à la fin du bail,\n" +
                        "s’ils ne sont pas susceptibles d’être détachés du local sans dommages pour celui-ci.", textFont);
        paragraph24.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph24.setSpacingAfter(10);





        Paragraph paragraph25 = new Paragraph("Article 6: FRAIS DE RECOUVREMENT", subTitleFont);
        paragraph25.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph25.

     setSpacingAfter(10);


        Paragraph paragraph26 = new Paragraph(
                "Tous frais d’huissier et d’avocat pour des diligences tendant au recouvrement les sommes correspondantes\n" +
                        "aux frais éventuels de remise en état des lieux, de réparation des biens et équipements énumérés à l’article\n" +
                        "2 resterons à la charge du Preneur en sus des intérêts de droit et des frais répétables.", textFont);
        paragraph26.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph26.

     setSpacingAfter(10);


        Paragraph paragraph27 = new Paragraph(" Article 8: POLICE D’ASSURANCE", subTitleFont);
        paragraph27.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph27.

     setSpacingAfter(10);

        Paragraph paragraph28 = new Paragraph(
                " Le preneur s’engage à souscrire à une police d’assurance contre les risques locatifs. Si le preneur\n" +
                        "n’est pas assuré, il sera tenu d’indemniser personnellement les victimes que ce soit les voisins et les\n" +
                        "tiers, ou les dommages envers la copropriété sans que le locataire puisse être mise en cause.", textFont);
        paragraph28.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph28.

     setSpacingAfter(10);




        Paragraph paragraph29 = new Paragraph("Article 9 : CLAUSE RÉSOLUTOIRE", subTitleFont);
        paragraph29.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph29.

     setSpacingAfter(10);

        Paragraph paragraph30 = new Paragraph(
                "A défaut de paiement d’un seul terme de loyer à son échéance ou d’inexécution d’une quelconque\n" +
                        "des clauses et conditions du bail, celui-ci sera résilié de plein droit, après une simple mise en\n" +
                        "demeure restée sans effet;", textFont);
        paragraph30.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph30.

     setSpacingAfter(10);



        Paragraph paragraph31 = new Paragraph("Article 10: LITIGES", subTitleFont);
        paragraph31.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph31.

     setSpacingAfter(10);


        Paragraph paragraph32 = new Paragraph(
                "Le présent contrat est soumis aux dispositions du Code des obligations civiles et commerciales en la\n" +
                        "matière. En cas de litige, la solution amiable est privilégiée. A défaut d’accord entre les parties, il\n" +
                        "sera fait recours au Tribunal compétent selon l’objet du litige.", textFont);
        paragraph32.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph32.

     setSpacingAfter(10);




        Paragraph paragraph33 = new Paragraph("Article 10 : ÉLECTION DE DOMICILE", subTitleFont);
        paragraph33.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph33.

     setSpacingAfter(10);



        Paragraph paragraph34 = new Paragraph(
                "Pour l’exécution des présentes et de leurs suites, les parties font élection de domicile :", textFont);
        paragraph34.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph34.

     setSpacingAfter(10);




        List listTwo = new List();

        listTwo.add((new ListItem("Le Bailleur: K.S.B Immobilier, ……………..",fontList)));
        listTwo.add((new ListItem("Le Preneur: ….……………",fontList)));



        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        Paragraph paragraph35 = new Paragraph(
                "Fait à Dakar, le :" + currentDateTime + "\n"+
                "En deux (02) exemplaires", textFont);
        paragraph35.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph35.

     setSpacingAfter(10);

        Paragraph paragraph36 = new Paragraph(
                "Le Preneur                                                    Le Bailleur", textFont);
        paragraph36.
     setAlignment(Paragraph.ALIGN_JUSTIFIED);
        paragraph36.

     setSpacingAfter(10);
























        document.add(paragraph0);

        document.add(paragraph);
        //document.add(paragraphB);
        document.add(paragraph2);

        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph55);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(list);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);
        document.add(paragraph12);
        document.add(paragraph13);
        document.add(paragraph14);
        document.add(paragraph15);
        document.add(paragraph16);
        document.add(paragraph17);
        document.add(paragraph18);
        document.add(paragraph19);
        document.add(paragraph20);
        document.add(paragraph21);
        document.add(paragraph22);
        document.add(paragraph23);
        document.add(paragraph24);
        document.add(paragraph25);
        document.add(paragraph26);
        document.add(paragraph27);
        document.add(paragraph28);
        document.add(paragraph29);
        document.add(paragraph30);
        document.add(paragraph31);
        document.add(paragraph32);
        document.add(paragraph33);
        document.add(paragraph34);
        document.add(paragraph35);
        document.add(paragraph36);







        document.close();
    }


    private static Paragraph createParagraph(String text, Font font, int alignment, float spacingAfter) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(alignment);
        paragraph.setSpacingAfter(spacingAfter);
        return paragraph;
    }

    private Table createSignature(String text1, String text2) throws IOException {
        Table table = new Table(2);
        Paragraph textSignatureLeft = new Paragraph(
                text1, this.fontSignature);
        textSignatureLeft.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph textSignatureRight = new Paragraph(
                text2, this.fontSignature);
        textSignatureRight.setAlignment(Paragraph.ALIGN_RIGHT);
        textSignatureRight.setIndentationLeft(120);

        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setBorder(Rectangle.NO_BORDER);
        table.setWidth(100);
        table.addCell(textSignatureLeft);
        table.addCell(textSignatureRight);

        return table;
    }

}
