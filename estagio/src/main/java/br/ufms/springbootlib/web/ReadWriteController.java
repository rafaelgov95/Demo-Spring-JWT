/*
 * Copyright (C) 2017 Universidade Federal de Mato Grosso do Sul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.springbootlib.web;

import br.ufms.estagio.domain.entity.Discente;
import br.ufms.estagio.domain.entity.Telefone;
import br.ufms.springbootlib.domain.GenericEntity;
import br.ufms.springbootlib.domain.ReadWriteBaseRepository;
import br.ufms.springbootlib.service.ReadWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 *
 * @author Kleber Kruger
 *
 * @param <E>
 * @param <ID>
 * @param <S>
 */
//@CrossOrigin(origins = "http://localhost:8080")
@MappedSuperclass
public class ReadWriteController<E extends GenericEntity<ID>, ID extends Serializable, S extends ReadWriteService<E, ID, ? extends ReadWriteBaseRepository<E, ID>>>
        extends ReadOnlyController<E, ID, S> {
    Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     *
//   * @param <S>
     * @param entity
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
        public <S extends E> S insert(@RequestBody S entity) {

        if(entity instanceof Discente) {
            Discente d = (Discente) entity;
            log.error("Porra 1: "+d.getId());
            log.error("Porra 2: "+d.getNome());
            log.error("Porra 3: "+d.getDataCriacao());
            log.error("Porra 6: "+d.getDataAt());
            log.error("Porra 4: "+d.getRga());
            log.error("Porra 5: "+d.getTipoUsuario());
            log.error("Porra 6: "+d.getTipoPessoa());
            for(Telefone t : d.getTelefones()){
                log.error("Telefone: "+t.getNumero());
            }
        }
        log.error(entity.toString());
        return getService().save(entity);
    }

    /**
     *
     * @param <S>
     * @param entity
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public <S extends E> S update(@RequestBody S entity) {
        log.error("Teste: ERRO");
        return getService().save(entity);
    }

    /**
     *
     * @param entity
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody E entity) {
        getService().delete(entity);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

}
