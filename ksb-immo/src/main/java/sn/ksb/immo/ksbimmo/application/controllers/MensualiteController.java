package sn.ksb.immo.ksbimmo.application.controllers;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@OpenAPIDefinition(tags = {@Tag(name = "Mensualité", description = "Mensualité API")})
@RequestMapping("/api/mensualite")
public class MensualiteController {

}
