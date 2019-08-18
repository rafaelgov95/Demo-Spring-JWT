package br.ufms.estagio.config.login;

//import br.ufms.estagio.server.service.PedidoService;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(path = "/login")
public class LoginEndpoint {


    @PostMapping(path = "")
    public ResponseEntity get(@RequestBody String dados) {
        return ResponseEntity.ok(dados);
    }

}