package br.ufms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootHelloWorlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorlApplication.class, args);

    }
    @RestController
    public class IndexController implements ErrorController {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        private static final String PATH = "/error";

        @RequestMapping(method = RequestMethod.POST, path = "/token")
        public String salvar(@RequestBody String categoria) {
            logger.error("OLHA AQUI");
            return categoria;
        }
        @RequestMapping("/")
        public String render() {
            return "API DA UFMS-CPCX";
        }

        @RequestMapping("/error")
        public String renderError() {
            return "ERRO NA API";
        }

        @Override
        public String getErrorPath() {
            return PATH;
        }
}
}