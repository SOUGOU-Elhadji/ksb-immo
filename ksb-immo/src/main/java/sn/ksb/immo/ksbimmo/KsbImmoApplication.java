package sn.ksb.immo.ksbimmo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "sn.ksb.immo.ksbimmo.application")
public class KsbImmoApplication {
    public static void main(String[] args) {
        SpringApplication.run(KsbImmoApplication.class, args);
    }


}
