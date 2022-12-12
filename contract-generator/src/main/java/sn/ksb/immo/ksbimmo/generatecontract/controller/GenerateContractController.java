package sn.ksb.immo.ksbimmo.generatecontract.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sn.ksb.immo.ksbimmo.generatecontract.service.GenerateContratService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GenerateContractController {


    private final GenerateContratService contract;

    public GenerateContractController(GenerateContratService contract) {
        this.contract = contract;
    }


    @GetMapping("/generateSimple")
    public void generateSimpleContract(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.simpleContract(response);

    }

    @GetMapping("/generateBail")
    public void generateBailContract(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.bailContract(response);

    }


    @GetMapping("/generateGli")
    public void generateGliContract(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrat Gli " + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.gliContract(response);

    }

    @GetMapping("/generateBM")
    public void generateBailMeubleContract(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=contrat de bail meuble " + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.contract.bailMeubleContrat(response);

    }
}
