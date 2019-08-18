package br.ufms.estagio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApplicationStart {


    public static void main(String[] args) {

        SpringApplication.run(ApplicationStart.class, args);

    }

}
