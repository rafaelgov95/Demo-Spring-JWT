package br.ufms.estagio.server.service;


import br.ufms.estagio.server.repository.CursoRepository;
import br.ufms.estagio.server.resource.entity.Curso;
import br.ufms.estagio.springbootlib.service.ReadWriteService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@RestController
public class CursoService extends ReadWriteService<Curso, Short, CursoRepository> {

}
