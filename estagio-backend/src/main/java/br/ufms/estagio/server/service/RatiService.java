package br.ufms.estagio.server.service;

import br.ufms.estagio.server.repository.RatiRepository;
import br.ufms.estagio.server.resource.entity.Rati;
//import br.ufms.estagio.server.resource.repository.RatiRepository;
import br.ufms.estagio.springbootlib.service.ReadWriteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatiService extends ReadWriteService<Rati, Long, RatiRepository> {


}
