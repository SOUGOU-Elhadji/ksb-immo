package sn.ksb.immo.ksbimmo.generatecontract.service;
import com.itextpdf.io.codec.Base64;
import com.itextpdf.io.font.FontConstants;


import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;


import com.itextpdf.layout.border.SolidBorder;


import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.ListSymbolAlignment;
import com.itextpdf.layout.property.TextAlignment;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import sn.ksb.immo.ksbimmo.generatecontract.model.Form;
import sn.ksb.immo.ksbimmo.generatecontract.repository.FileRepo;
import sn.ksb.immo.ksbimmo.generatecontract.repository.FormRepository;


import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GenerateContratService {
    private final FormRepository repo;
    private final FileRepo fileRepo;


    private Document document;
  PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
  Font listFont = new Font(FontConstants.TIMES_ROMAN,10, Font.BOLD);

/* Font titleFont = new Font(FontConstants.TIMES_ROMAN,18, Font.BOLD);
  Font textFont = new Font(FontConstants.TIMES_ROMAN,12, Font.ITALIC );
  Font chapterFont= new Font(FontConstants.TIMES_ROMAN, 13,Font.BOLD);
  Font subTitleFont = new Font(FontConstants.TIMES_ROMAN,12, Font.BOLD);
  Font boldFont = new Font(FontConstants.TIMES_ROMAN,12, Font.BOLD);
  Font italicFont =new Font(FontConstants.TIMES_ROMAN,12, Font.BOLD);
  Font boldItalicFont = new Font(FontConstants.TIMES_ROMAN,12, Font.BOLD);*/







    Table table = new Table(2);


    public GenerateContratService(FormRepository repo, FileRepo fileRepo) throws IOException, FontFormatException, IOException {
        this.repo = repo;
        this.fileRepo = fileRepo;
    }




  private static Paragraph createParagraph(String text) throws IOException {


    Paragraph paragraph = new Paragraph(text).setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));


    return paragraph;
  }



  //subTitleFont.setStyle(Font.BOLD);
 // PdfFont subTitleFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

    
    

    public void simpleContract(HttpServletResponse response,@RequestBody Form formRequest) throws IOException {


      String dest = "/Users/macbookpro/Documents/contrats/contrat-simple";

      PdfWriter writer = new PdfWriter(dest);
      // Creating a PdfDocument
      PdfDocument pdf = new PdfDocument(writer);
      // Creating a Document
      Document document = new Document(pdf, PageSize.A4);

      /*String imFile = "/Users/macbookpro/Documents/kbs-immo-contrats/logo.png";
      ImageData data = ImageDataFactory.create(imFile);

      // Creating an Image object
      Image image = new Image(data);
      document.add(image);*/
      Form form = repo.save(formRequest);


      document.add(createParagraph("MANDAT DE GESTION LOCATIVE SIMPLE").setFontSize(18).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setUnderline());



       document.add(createParagraph("Conformément à la loi, aux règlements et usages en vigueur au Sénégal notamment les\n" +
                "dispositions du COCC (Code des Obligations Civiles et Commerciales) et des actes uniformes de\n" +
                "l’OHAD").setFontSize(10).setMarginBottom(10).setBorder(new SolidBorder(1)) );



        document.add(createParagraph("- Monsieur "+form.getNom()+ ", né le "+ form.getNaissance() + " à DAKAR, es-qualité de "+ form.getProfession()+ ". et titulaire de la CNI N° "+ form.getCni()+
                " du "+form.getDateDelivrance()+ " ; ci-après désigné le « Mandant » d’une part,").setFontSize(10).setTextAlignment(TextAlignment.LEFT).setMarginBottom(10));

        document.add(createParagraph("- D'une part").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

        document.add(createParagraph("- L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-PIKINE,\n" +
                "représentant le propriétaire Monsieur ou Madame"+ form.getProprietaire()+", ci - après désigné le « Mandataire »,\n" +
                "d’autre part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Article 1: Objet").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("Le propriétaire confie en exclusivité à l’agence K.S.B Immobilier de son immeuble sis à "+ form.getProprieteLieu()+". Lot N°………. Par conséquent, ni le propriétaire, ni aucune autre personne physique ou morale n’est habilitée à faire rentrer un client sans pour autant passer par l’agence. Le gestionnaire accepte la mission qui lui est confié et s’engage à tout mettre en œuvre pour labonne gestion et la satisfaction du propriétaire.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("Article 2: Loyer").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline());
      document.add(createParagraph("Le loyer est arrêté à la somme de"+form.getPrix() +" \nLe propriétaire a la possibilité de modifier à tout moment les prix fixés tant que le bien n’est pas loué ou que des négociations entamées avec un locataire. Mais il lui faut envoyer au gestionnaire un mail ou un courrier signé dans ce sens. Les loyers perçus seront versés au propriétaire au plus tard le 10 ou 15 de chaque fin de mois, par virement bancaire (joindre RIB ou IBAN), chèque ou en espèce selon ce qui a été convenu.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("Chapitre I: Les obligations du mandataire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph("Article 3: Missions du mandataire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());
      document.add(createParagraph("En conséquence du présent mandat, le propriétaire autorise le gestionnaire à accomplir pour son\n" +
                        "compte et en son nom tout acte d’administration notamment:").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
        List list = new List();
        list.setListSymbol("\u2022");
        list.setListSymbolAlignment(ListSymbolAlignment.LEFT);
        list.setSymbolIndent(10);
        list.setFontSize(9);

        //set indentation after symbol
      list.setSymbolIndent(10);









        list.add(new ListItem("\tReprésenter le propriétaire pour tous les aspects de la gérance de l’immeuble,"));

        list.add("\tRédiger les contrats de location ou leur renouvellement, les signer suivant les conditions\n arrêtées avec le propriétaire,");

        list.add("\tEncaisser, percevoir tous les loyers cautions et autres charges relatives au bien géré,");
        list.add("\tDonner quittance, reçu et décharges");
        list.add("\tVerser mensuellement dans le compte du propriétaire les loyers perçus,");
        list.add("\tProcéder à la révision du loyer suivant les indications du propriétaire et du contrat,");
        list.add("\tInformer le propriétaire sur les travaux lui incombant, dans les lieux loués, les effectuer\n" +
                "sur accord entre le propriétaire et le gestionnaire,");
        list.add("\tRechercher activement des locataires, louer les biens après avoir avisé le propriétaire de\n" +
                "leurs vacances,");
        list.add("\tFaire les versements aux impôts de la TOM et toutes les autres taxes relatives à la location\n" +
                "de biens immobiliers (sur demande du propriétaire et validation par le gestionnaire).");
        list.add("\tIntervenir auprès des compagnies d’assurance en cas de sinistre,");
        list.add("\tDresser ou faire les constats avec le support d’huissiers (frais à la charge du propriétaire);");
        document.add( list);


      document.add(createParagraph("Le gestionnaire informera le propriétaire des loyers impayés et un document sur la\n" +
                        "situation financière qui sera présenté tous les mois depuis son espace extranet.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("De même en cas de difficultés, ou de non-paiement de loyer, le propriétaire donne mandat exprès\n" +
                        "au gestionnaire qui l’accepte, le temps de diligenter tant en demande qu’en défense toutes\n" +
                        "actions judiciaires, tous commandements, sommations, assignations et citations devant tous\n" +
                        "tribunaux et toutes commissions administratives, se concilier ou requérir au jugement, les faire\n" +
                        "signer et exécuter, se faire remettre tous les titres ou pièces, le tout dans le respect des\n" +
                        "dispositions légales.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 4: Gestion de bonne foi").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("Le gestionnaire promet de gérer la propriété qui lui est confiée en bon père de famille, suivant les\n" +
                        "usages en la matière. Il répondra de ses obligations du fait du présent mandat vis-à-vis des tiers\n" +
                        "que du propriétaire.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Chapitre II: Les obligations du Mandant").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Article 5 : les engagements du propriétaire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());
      document.add(createParagraph("Il s’interdit toutes actions directes pour la gestion de la propriété sauf en informer le gestionnaire\n" +
                        "par écrit et d’avance il demeurera dans ce cas seul responsable de ses actes. Il ne pourra pendant\n" +
                        "toute la durée de gérance recouvrer directement les loyers, charges, clés ou contracter\n" +
                        "directement avec une tierce personne. Le propriétaire s’engage à ne pas confier aucune autre\n" +
                        "personne physique ou morale la location ou la gestion des biens immobiliers pendant toute la\n" +
                        "durée du mandat.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Chapitre III: disposions générales").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph("Article 6 : durée").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("Le contrat est consenti pour une durée d’un (03) ans renouvelables par tacite reconduction et\n" +
                        "prendra effet à la date de sa signature par les deux parties.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("Article 7 : Condition de location").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());
      document.add(createParagraph("Chaque locataire devra verser d’avance hormis les frais d’agence, deux mois représentant\n" +
                        "le premier mois de loyer et la caution, ainsi les commissions à versé à l’agence.\n" +
                        "Le locataire devra fournir des documents justificatifs financiers.\n" +
                        "En cas de rupture du présent mandat de gérance, le gestionnaire s’engage à transférer tous les\n" +
                        "contrats en cours." ).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 8: Frais de gestion de l’immeuble").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("Les frais de gestion de l’immeuble sont d’un forfait mensuel de 1O% des recettes du bien objet du\n" +
                        "contrat de mandat.\n").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Chapitre IV: Gestion de litiges").setFontSize(13).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());


      document.add(createParagraph( "Moyennant un préavis de trois (06) mois envoyé par lettre recommandé les deux parties peuvent\n" +
                        "résilier le présent contrat.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 10 Clause Résolutoire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("En cas de mise en vente du bien objet du présent protocole, le propriétaire pourrait mettre fin au\n" +
                        "mandat avec un préavis de 3 mois. Dans ce cas de figure, l’agence aurait la primauté sur la vente\n" +
                        "en tant qu’agent du bailleur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 11 : Non-respect des engagements"  ).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());

      document.add(createParagraph("Le non-respect des engagements de ce contrat sera porté au tribunal de commerce.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 12 : Election de domicile").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline().setBold());
      document.add(createParagraph("Pour l’exécution des présentes, les parties élisent domicile :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph( "Le gestionnaire dans ses locaux sis à la cité Lobatt Fall villa n°25,\n" +
                        "Le propriétaire à son adresse ci- dessus nommée").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());
 document.add((createParagraph("Fait à Dakar le : \t \t "+currentDateTime).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10)));
      document.add(createParagraph("LE MANDANT"+ "                                                                            LE MANDATAIRE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

        //create a text line
       // Phrase phrase = new Phrase("Fait à Dakar le : \t \t ", textFont);

        //Phrase phrase1 = new Phrase(currentDateTime, boldItalicFont);
        //combine the phrases
        //Phrase phrase2 = new Phrase();
       // phrase2.add(phrase);
       // phrase2.add(phrase1);

       // Paragraph paragraph37 = new Paragraph(phrase2);
       // document.add(createSignature("LE MANDANT", "LE MANDATAIRE"));
        document.close();
      System.out.println("Paragraph added");
    }


    public void bailContract(HttpServletResponse response,@RequestBody Form formRequest) throws IOException {
        Form form = repo.save(formRequest);


        String dest ="/Users/macbookpro/Documents/contrats/contrat-bail";

      PdfWriter writer = new PdfWriter(dest);


      //Ajout du header au document sur toutes les pages

      // Creating a PdfDocument
      PdfDocument pdf = new PdfDocument(writer);
      // Creating a Document
      Document document = new Document(pdf, PageSize.A4);



      document.add(createParagraph("CONTRAT DE BAIL").setFontSize(18).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setBorder(new SolidBorder(1)));


      document.add(createParagraph("ENTRE LES SOUSSIGNÉS :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

         document.add(createParagraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur"+form.getProprietaire() +", ci - après désigné le\n" +
                "« Bailleur », d’une part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

         document.add(createParagraph("ET").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
       document.add(createParagraph("-Monsieur" + form.getNom()+", né le" +form.getNaissance()+ "à DAKAR, es-qualité de"+ form.getProfession()+". et titulaire de la\n" +
                "CNI N°"+form.getCni()+". Du "+form.getDateDelivrance() +"; ci-après désigné le « Preneur », d’autre part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));




      document.add(createParagraph("ET"));

      document.add(createParagraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph("Article 1: DÉSIGNATION").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph( "Le Bailleur donne en location, au Preneur qui accepte, un local A USAGE D’HABITATION\n" +
                        "sis ……………………… ……………………. et comprenant :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

        List list = new List();
      list.setListSymbol("\u2022");
      list.setListSymbolAlignment(ListSymbolAlignment.LEFT);
      list.setSymbolIndent(10);
      list.setFontSize(10);
      list.setBold();
      //set indentation after symbol
      list.setSymbolIndent(10);

        list.add("………………………………………………");
        list.add("………………………………………………");
        list.add("………………………………………………");
       document.add( list);   // Add elements to the list




      document.add(createParagraph("Un état des lieux contradictoire sera fait avant l’occupation effective des locaux. A défaut le\n" +
                        "preneur est réputé avoir accepté les locaux en l’état.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 2 : DURÉE DU BAIL").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Le présent bail est consenti pour une durée de trois (03) ans renouvelables par tacite\n" +
                        "reconduction et prend effet à compter du ……………………").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph(
                "En cas de dénonciation du présent contrat, le Bailleur est tenu de donner un préavis de six\n" +
                        "(06) mois et le Preneur un préavis écrit de deux (03) mois.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 3 : LOYER").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("La présente location est consentie et acceptée pour un loyer mensuel de\n" +
                        "…………………francs CFA tous taxes et charges.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Le loyer est payable à la fin de chaque mois et au plus tard le 05 du mois suivant.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("Tout mois commencé est dû. Le loyer est portable et non quérable et les frais liés aux retards\n" +
                        "de paiement sont à la charge du Preneur. Tous les paiements devront être effectués, soit en\n" +
                        "espèces, soit par chèques bancaires entre les mains du bailleur, soit par virements bancaires\n" +
                        "au numéro de compte que le bailleur indiquera au Preneur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 4 : CAUTION").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph( " Avant l’entrée en jouissance, le Preneur devra verser, à titre d’avance, la somme de ……….\n" +
                        "Francs CFA (0.00 FCFA), à titre de caution détenue par l’Agence. Cette somme non\n" +
                        "productive d’intérêts ne sera restituée au Preneur qu’après remise des lieux en parfait état\n" +
                        "locatif.\n" +
                        "Il sera prélevé sur cette caution, les sommes correspondantes aux frais éventuels de remise en\n" +
                        "état des lieux, ainsi toutes les charges que le preneur pourrait devoir comme charge locative.\n").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));



      document.add(createParagraph("Article 5: CHARGES ET CONDITIONS").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Le présent bail est consenti et accepté aux charges et conditions ordinaires de droit ci-après\n" +
                        "stipulées :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("5.1 - Le Preneur garnira les lieux et les tiendra constamment fournis de mobiliers et matériels\n" +
                        "en qualité et valeur suffisantes, pour garantir le paiement des loyers et charges.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("5.2. - Le preneur s’engage à faire assurer tous les objets mobiliers contenus dans les locaux\n" +
                        "loués contre l’incendie, les risques locatifs et le recours des voisins, auprès d’une Compagnie\n" +
                        "d’assurance dûment agrée au Sénégal et notoirement solvable.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph( "5.3. - Le preneur acquittera la Taxe d’enlèvement des ordures ménagères et toutes\n" +
                        "contributions résultant de son occupation, ainsi que les consommations d’eau et d’électricité,\n" +
                        "afin que le Bailleur ne soit nullement inquiété pendant la durée du contrat ou à l’expiration de\n" +
                        "celui-ci.\n" +
                        "En cas de paiement par chèques, le loyer ne sera considéré comme réglé qu’après son\n" +
                        "encaissement, nonobstant la remise de la quittance. La clause résolutoire pourra être acquise.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph(
                "5.4 - Le preneur ne pourra sous-louer tout ou partie des lieux sans l’autorisation écrite du\n" +
                        "bailleur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("5.5 - Le preneur ne pourra faire aucune modification ou transformation dans l’état ou la\n" +
                        "disposition des locaux sans l’autorisation préalable, par écrit, du bailleur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("Tous aménagements, embellissements ou améliorations bénéficieront au Bailleur à la fin du\n" +
                        "bail, s’ils ne sont pas susceptibles d’être détachés du local sans dommages pour celui-ci.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("5.6 - Le preneur ne sera tenu qu’aux réparations locatives, le bailleur étant tenu aux grosses\n" +
                        "réparations. Le Preneur entretiendra les lieux en bon état et les restituera en bon état. Il sera\n" +
                        "tenu de refaire les peintures intérieures avant de quitter les lieux, quelle qu’ait été la durée de\n" +
                        "l’occupation.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 6: FRAIS DE RECOUVREMENT").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Tous frais pour des diligences tendant au recouvrement des loyers non payés à l’échéance\n" +
                        "convenue, suite à un commandement, seront à la charge du Preneur en sus des intérêts de\n" +
                        "droit et des frais répétables.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 7 : CLAUSE RÉSOLUTOIRE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("A défaut de paiement d’un seul terme de loyer à son échéance ou d’inexécution d’une\n" +
                        "quelconque des clauses et conditions du bail, celui-ci sera résilié de plein droit, si bon semble\n" +
                        "au bailleur, 30 jours après une simple mise en demeure restée sans effet.\n" +
                        "Le juge saisi constatera la résiliation du bail et, si nécessaire, prononcera l’expulsion du\n" +
                        "Preneur par simple ordonnance de référé.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 8 : ENREGISTREMENT").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph( "Les frais du présent contrat, ainsi que les droits de timbre et d’enregistrement sont à la charge\n" +
                        "exclusive du Preneur. L’enregistrement est requis pour la durée du bail et, en cas de\n" +
                        "reconduction, le Preneur le requiert pour les périodes ultérieures.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 9 : LITIGES").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Le présent contrat est soumis aux dispositions du Code des obligations civiles et\n" +
                        "commerciales en la matière. En cas de litige, la solution amiable est privilégiée. A défaut\n" +
                        "d’accord entre les parties, il sera fait recours au Tribunal compétent selon l’objet du litige."));
      document.add(createParagraph("Article 10 : ÉLECTION DE DOMICILE\n").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Pour l’exécution des présentes et de leurs suites, les parties font élection de domicile :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


        List listTwo = new List();
      listTwo.setListSymbol("\u2022");
      listTwo.setListSymbolAlignment(ListSymbolAlignment.LEFT);
      listTwo.setSymbolIndent(10);
      listTwo.setFontSize(10);
      listTwo.setBold();
      //set indentation after symbol
      listTwo.setSymbolIndent(10);


        listTwo.add((new ListItem("Le Bailleur : au 570 C sis ………………………...")));
        listTwo.add((new ListItem("Le Preneur : au 570 C sis ………………………....")));



        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());

      document.add(createParagraph("FAIT A DAKAR EN DEUX (03) ORIGINAUX LE :" + currentDateTime).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("LE MANDANT                                                     LE MANDATAIRE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

        document.close();
    }



    public void gliContract(HttpServletResponse response,@RequestBody Form formRequest) throws IOException {

      String dest ="/Users/macbookpro/Documents/contrats/contrat-gli";

      PdfWriter writer = new PdfWriter(dest);
      // Creating a PdfDocument
      PdfDocument pdf = new PdfDocument(writer);
      // Creating a Document
      Document document = new Document(pdf, PageSize.A4);

        Form form = repo.save(formRequest);


      document.add(createParagraph("MANDAT DE GESTION LOCATIVE SURETE GLI").setFontSize(18).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setBold());



      document.add(createParagraph ("Conformément à la loi, aux règlements et usages en vigueur au Sénégal notamment les\n" +
                "dispositions du COCC (Code des Obligations Civiles et Commerciales) et des actes uniformes de\n" +
                "l’OHAD").setFontSize(10).setMarginBottom(10).setBorder(new SolidBorder(1)));




      document.add(createParagraph("ENTRE-LES soussignés").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline());



      document.add(createParagraph("-Monsieur"+form.getNom()+", né le"+ form.getNaissance() +" à DAKAR, es-qualité de"+ form.getProfession()+". Et titulaire de la\n" +
                "CNI N°"+form.getCni()+". Du"+form.getDateDelivrance()+" ; ci-après désigné le « Mandant » d’une part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));




      document.add(createParagraph("D’UNE part").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setUnderline());



      document.add(createParagraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur ou Madame ………, ci - après désigné le\n" +
                "« Mandataire », d’autre part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());



      document.add(createParagraph("Article 1: Objet").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le propriétaire confie en exclusivité à l’agence K.S.B Immobilier de son immeuble sis à "+form.getProprieteLieu()+".\n" +
                        "Lot N°"+form.getNumLot()+". Par conséquent, ni le propriétaire, ni aucune autre personne physique ou\n" +
                        "morale n’est habilitée à faire rentrer un client sans pour autant passer par l’agence.\n" +
                        "Le gestionnaire accepte la mission qui lui est confié et s’engage à tout mettre en œuvre\n" +
                        "pour la bonne gestion et la satisfaction du propriétaire.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 2: Loyer").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());


      document.add(createParagraph("Le loyer est arrêté à la somme de"+form.getPrix()+".Le propriétaire a la possibilité de modifier à tout moment les prix fixés tant que le bien n’est pas loué ou que des négociations entamées avec un locataire. Mais il lui faut envoyer au gestionnaire un mail ou un courrier signé dans ce sens. Les loyers perçus seront versés au propriétaire au plus tard le 10 ou 15 de chaque fin de mois, par virement bancaire (joindre RIB ou IBAN), chèque ou en espèce selon ce qui a été convenu.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Chapitre I: Les obligations du mandataire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Article 3: Missions du mandataire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("En conséquence du présent mandat, le propriétaire autorise le gestionnaire à accomplir pour son\n" +
                        "compte et en son nom tout acte d’administration notamment:").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

        List list = new List();

      list.setListSymbol("\u2022");
      list.setListSymbolAlignment(ListSymbolAlignment.LEFT);
      list.setSymbolIndent(10);
      list.setFontSize(10);
      list.setBold();
      //set indentation after symbol
      list.setSymbolIndent(10);

        list.add("Représenter le propriétaire pour tous les aspects de la gérance de l’immeuble,");

        list.add("Rédiger les contrats de location ou leur renouvellement, les signer suivant les conditions\n" +
                "arrêtées avec le propriétaire,");
        list.add("Encaisser, percevoir tous les loyers cautions et autres charges relatives au bien géré,");
        list.add("Donner quittance, reçu et décharges");
        list.add("Verser mensuellement dans le compte du propriétaire les loyers perçus,");
        list.add("Procéder à la révision du loyer suivant les indications du propriétaire et du contrat,");
        list.add("Informer le propriétaire sur les travaux lui incombant, dans les lieux loués, les effectuer\n" +
                "sur accord entre le propriétaire et le gestionnaire,");
        list.add("Rechercher activement des locataires, louer les biens après avoir avisé le propriétaire de\n" +
                "leurs vacances,");
        list.add("Faire les versements aux impôts de la TOM et toutes les autres taxes relatives à la location\n" +
                "de biens immobiliers (sur demande du propriétaire et validation par le gestionnaire).");
        list.add("Intervenir auprès des compagnies d’assurance en cas de sinistre,");
        list.add("Dresser ou faire les constats avec le support d’huissiers (frais à la charge du propriétaire);");

      document.add(createParagraph( "Le gestionnaire informera le propriétaire des loyers impayés et un document sur la\n" +
                        "situation financière qui sera présenté tous les mois depuis son espace extranet.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("De même en cas de difficultés, ou de non-paiement de loyer, le propriétaire donne mandat exprès\n" +
                        "au gestionnaire qui l’accepte, le temps de diligenter tant en demande qu’en défense toutes\n" +
                        "actions judiciaires, tous commandements, sommations, assignations et citations devant tous\n" +
                        "tribunaux et toutes commissions administratives, se concilier ou requérir au jugement, les faire\n" +
                        "signer et exécuter, se faire remettre tous les titres ou pièces, le tout dans le respect des\n" +
                        "dispositions légales.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 4: Garantie du prix du loyer").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le gestionnaire s’engage au paiement du loyer nonobstant la cessation du paiement du\n" +
                        "locataire dans les cinq (5) mois qui suit.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));




      document.add(createParagraph("Article 5: Gestion de bonne foi").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());


      document.add(createParagraph("Le gestionnaire promet de gérer la propriété qui lui est confiée en bon père de famille, suivant les\n" +
                        "usages en la matière. Il répondra de ses obligations du fait du présent mandat vis-à-vis des tiers\n" +
                        "que du propriétaire.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

         document.add(createParagraph("Chapitre II: Les obligations du Mandant").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());



      document.add(createParagraph("Article 6 : les engagements du propriétaire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Il s’interdit toutes actions directes pour la gestion de la propriété sauf en informer le gestionnaire\n" +
                        "par écrit et d’avance il demeurera dans ce cas seul responsable de ses actes. Il ne pourra pendant\n" +
                        "toute la durée de gérance recouvrer directement les loyers, charges, clés ou contracter\n" +
                        "directement avec une tierce personne. Le propriétaire s’engage à ne pas confier aucune autre\n" +
                        "personne physique ou morale la location ou la gestion des biens immobiliers pendant toute la\n" +
                        "durée du mandat.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));



      document.add(createParagraph("Chapitre III: disposions générales").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph("Article 7 : durée").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());
      document.add(createParagraph("Le contrat est consenti pour une durée d’un (03) ans renouvelables par tacite reconduction et\n" +
                        "prendra effet à la date de sa signature par les deux parties.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 8 : Condition de location").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());


      document.add(createParagraph("Chaque locataire devra verser d’avance hormis les frais d’agence, deux mois représentant\n" +
                        "le premier mois de loyer et la caution, ainsi les commissions à versé à l’agence.\n" +
                        "Le locataire devra fournir des documents justificatifs financiers.\n" +
                        "En cas de rupture du présent mandat de gérance, le gestionnaire s’engage à transférer tous les\n" +
                        "contrats en cours.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 9: Frais de gestion de l’immeuble").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Les frais de gestion de l’immeuble sont d’un forfait mensuel de 1O% des recettes du bien objet du\n" +
                        "contrat de mandat.\n").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Chapitre IV: Gestion de litiges").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());

      document.add(createParagraph("Article 10 : Résiliation du mandat").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Moyennant un préavis de trois (06) mois envoyé par lettre recommandé les deux parties peuvent\n" +
                        "résilier le présent contrat.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 11 : Clause Résolutoire").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("En cas de mise en vente du bien objet du présent protocole, le propriétaire pourrait mettre fin au\n" +
                        "mandat avec un préavis de 3 mois. Dans ce cas de figure, l’agence aurait la primauté sur la vente\n" +
                        "en tant qu’agent du bailleur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 12 : Non-respect des engagements").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le non-respect des engagements de ce contrat sera porté au tribunal de commerce.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 13 : Election de domicile").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Pour l’exécution des présentes, les parties élisent domicile :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Le gestionnaire dans ses locaux sis à la cité Lobatt Fall villa n°25,\n" +
                        "Le propriétaire à son adresse ci- dessus nommée").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));



        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());
      document.add(createParagraph(" FAIT A DAKAR EN DEUX (02) ORIGINAUX LE :" + currentDateTime).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("LE MANDANT                                        LE MANDATAIRE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());



        document.close();
    }



    public void bailMeubleContrat(HttpServletResponse response, @RequestBody Form formRequest) throws IOException {
      String dest ="/Users/macbookpro/Documents/contrats/contrat-bail-meuble";

      PdfWriter writer = new PdfWriter(dest);
      // Creating a PdfDocument
      PdfDocument pdf = new PdfDocument(writer);
      // Creating a Document
      Document document = new Document(pdf, PageSize.A4);

        Form form = repo.save(formRequest);
      document.add(createParagraph("CONTRAT DE BAIL MEUBLE :").setFontSize(18).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setBorder(new SolidBorder(1)));




      document.add(createParagraph("ENTRE LES SOUSSIGNÉS :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());



      document.add(createParagraph("-L’Agence « K.S.B Immobilier », ayant son siège social à Cité Lobatt Fall-villa n°25-\n" +
                "PIKINE, représentant le propriétaire Monsieur"+form.getProprietaire() +", ci - après désigné le\n" +
                "« Bailleur », d’une part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("ET").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph("Monsieur"+form.getNom()+", né le"+form.getNaissance()+ " à Dakar, titulaire du Passeport N°"+form.getNumPassport()+ " du\n" +
                "0/00/2000, ci-après désigné le «Preneur», d’autre part,").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("IL EST PRÉALABLEMENT RAPPELÉ CE QUI SUIT").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le présent contrat a pour objet la location d’un Studio meublé à usage d’habitation exclusive.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));
      document.add(createParagraph("IL A ÉTÉ CONVENU ET ARRÊTÉ CE QUI SUIT :").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Article 1: DÉSIGNATION").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph( "Le Bailleur donne en location et ce A USAGE D’HABITATION exclusive au Preneur qui accepte :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


        List list = new List();

      list.setListSymbol("\u2022");
      list.setListSymbolAlignment(ListSymbolAlignment.LEFT);
      list.setSymbolIndent(10);
      list.setFontSize(10);
      list.setBold();
      //set indentation after symbol
      list.setSymbolIndent(10);
        list.add("………………………………………………");
        list.add("………………………………………………");
        list.add("………………………………………………");

      document.add(createParagraph("Un état des lieux contradictoire sera fait avant l’occupation effective des locaux si nécessaire. Le cas\n" +
                        "échéant le Preneur déclare bien connaître les lieux qu’il accepte dans leur état actuel sans aucune\n" +
                        "réserve. Il dispense le Bailleur d’une plus ample désignation.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));



      document.add(createParagraph("Article 2 : ELEMENTS D’EQUIPEMENTS DU LOGEMENT").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());


      document.add(createParagraph("Le studio est composé des équipements et biens, ci-après:").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph(
                "1-\n" +
                        "2-\n" +
                        "3-\n" +
                        "4-\n" +
                        "5-\n" +
                        "6-").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph( "Une vérification de l’état des biens et un inventaire contradictoire sera fait avant l’occupation effective des\n" +
                        "locaux si nécessaire avec prise de photos annexés au présent contrat.\n" +
                        "A défaut il sera considéré que le preneur accepte les meubles dans leur état actuel sans aucune réserve. Il\n" +
                        "dispense le Bailleur d’une plus ample vérification.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 3: DUREE DU CONTRAT").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le présent bail est consenti pour une durée ……………non renouvelable sauf sollicitation par le\n" +
                        "preneur.\n" +
                        "Le présent bail prend effet à compter du …/…/…. pour prendre fin le …/…/….").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 4: MONTANT DU LOYER").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph(
                "La présente location est consentie et acceptée pour un loyer journalier de ……………. francs CFA\n" +
                        "(……… FCFA), payable à l’avance avant l’entrée en jouissance.\n" +
                        " La présente location est consentie toutes charges comprises (eau et l’électricité).").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 5 : DEPOT DE GARANTIE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph(
                "La somme de …… sera versée à titre de caution avant l’entrée en jouissance. Toutes fois le Preneur\n" +
                        "ne peut quitter les lieux et restituer les clés qu’après remise des lieux en parfait état locatif et après\n" +
                        "inventaire et vérification des biens donnés en location. En cas de dégradation les sommes\n" +
                        "correspondantes aux frais éventuels de remise en état, de réparation des biens et équipements\n" +
                        "énumérés à l’article 2 resterons à la charge de celui-ci.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("    Article 6: CHARGES ET CONDITONS").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph( "Le présent bail est consenti et accepté aux charges et conditions ordinaires de droit ci-après :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph( "Le preneur s’engage à faire assurer tous les objets mobiliers contenus dans les locaux loués contre\n" +
                        "l’incendie, les risques locatifs et le recours des voisins, auprès d’une Compagnie d’assurance dûment\n" +
                        "agrée au Sénégal et notoirement solvable.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Le Preneur devra satisfaire à toutes les prescriptions des Services de voierie et d’hygiène, afin que le\n" +
                        "bailleur ne soit nullement inquiété à ce sujet.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Le preneur ne pourra sous-louer tout ou partie des lieux sans l’autorisation écrite du bailleur.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph( "Le preneur ne pourra faire aucune modification ou transformation dans l’état ou la disposition des\n" +
                        "locaux sans l’autorisation préalable, par écrit, du bailleur.\n" +
                        "Tous aménagements, embellissements ou améliorations bénéficieront au Bailleur à la fin du bail,\n" +
                        "s’ils ne sont pas susceptibles d’être détachés du local sans dommages pour celui-ci.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 7: FRAIS DE RECOUVREMENT").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Tous frais d’huissier et d’avocat pour des diligences tendant au recouvrement les sommes correspondantes\n" +
                        "aux frais éventuels de remise en état des lieux, de réparation des biens et équipements énumérés à l’article\n" +
                        "2 resterons à la charge du Preneur en sus des intérêts de droit et des frais répétables." ).setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph(" Article 8: POLICE D’ASSURANCE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());
      document.add(createParagraph(" Le preneur s’engage à souscrire à une police d’assurance contre les risques locatifs. Si le preneur\n" +
                        "n’est pas assuré, il sera tenu d’indemniser personnellement les victimes que ce soit les voisins et les\n" +
                        "tiers, ou les dommages envers la copropriété sans que le locataire puisse être mise en cause.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));


      document.add(createParagraph("Article 9 : CLAUSE RÉSOLUTOIRE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());
      document.add(createParagraph( "A défaut de paiement d’un seul terme de loyer à son échéance ou d’inexécution d’une quelconque\n" +
                        "des clauses et conditions du bail, celui-ci sera résilié de plein droit, après une simple mise en\n" +
                        "demeure restée sans effet;").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 10: LITIGES").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Le présent contrat est soumis aux dispositions du Code des obligations civiles et commerciales en la\n" +
                        "matière. En cas de litige, la solution amiable est privilégiée. A défaut d’accord entre les parties, il\n" +
                        "sera fait recours au Tribunal compétent selon l’objet du litige.").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

      document.add(createParagraph("Article 11 : ÉLECTION DE DOMICILE").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold().setUnderline());

      document.add(createParagraph("Pour l’exécution des présentes et de leurs suites, les parties font élection de domicile :").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10));

        List listTwo = new List();
      listTwo.setListSymbol("\u2022");
      listTwo.setListSymbolAlignment(ListSymbolAlignment.LEFT);
      listTwo.setSymbolIndent(10);
      listTwo.setFontSize(10);
      listTwo.setBold();
      //set indentation after symbol
      listTwo.setSymbolIndent(10);

        listTwo.add((new ListItem("Le Bailleur: K.S.B Immobilier, ……………..")));
        listTwo.add((new ListItem("Le Preneur: ….……………")));



        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormatter.format(new Date());

      document.add(createParagraph("Fait à Dakar, le :" + currentDateTime + "\n"+
                        "En deux (02) exemplaires").setFontSize(10).setTextAlignment(TextAlignment.RIGHT).setMarginBottom(10));

      document.add(createParagraph("Le Preneur        Le Bailleur").setFontSize(10).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(10).setBold());


        document.close();
    }







   /*private Table createSignature(String text1, String text2) throws IOException {
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
    }*/







}