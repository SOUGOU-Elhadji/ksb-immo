package sn.ksb.immo.ksbimmo.generatecontract.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestBody;
import sn.ksb.immo.ksbimmo.generatecontract.model.Form;
import sn.ksb.immo.ksbimmo.generatecontract.repository.FormRepository;

import sn.ksb.immo.ksbimmo.generatecontract.service.GenerateReceipt;
import sn.ksb.immo.ksbimmo.generatecontract.service.GenerateContratService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GenerateContractController {


    private final GenerateContratService contract;
    private final FormRepository repo;
    private final GenerateReceipt receipt;







    public GenerateContractController(GenerateContratService contract, GenerateContratService contract1, FormRepository repo, GenerateReceipt receipt) {
        this.contract = contract1;
        this.repo = repo;


        this.receipt = receipt;
    }


   @PostMapping("/generateSimple")
   public void generateSimpleContract(HttpServletResponse response, @RequestBody Form form) throws IOException {
       response.setContentType("application/pdf");
       DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
       String currentDateTime = dateFormatter.format(new Date());

       String headerKey = "Content-Disposition";
       String headerValue = "attachment; filename=contrat-simple.pdf";
       response.setHeader(headerKey, headerValue);

       this.contract.simpleContract(response, form);

   }

    @PostMapping("/generateBail")
    public void generateBailContract(HttpServletResponse response,@RequestBody Form form) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrat-bail.pdf";
        response.setHeader(headerKey, headerValue);



        this.contract.bailContract(response,form);


    }


    @PostMapping("/generateGli")
    public void generateGliContract(HttpServletResponse response,@RequestBody Form form) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrat-gli.pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.gliContract(response,form);

    }

    @PostMapping("/generateBM")
    public void generateBailMeubleContract(HttpServletResponse response,@RequestBody Form form) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrat-bail-meuble.pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.bailMeubleContrat(response,form);

    }

    @PostMapping("/generateReceipt")
    public void generateReceipt(HttpServletResponse response,@RequestBody Form form) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=receipt.pdf";
        response.setHeader(headerKey, headerValue);

        this.receipt.receipt(response,form);

    }




    /*@PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            contrat.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }*/






}
