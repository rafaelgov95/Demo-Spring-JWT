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
package br.ufms.estagio.springbootlib.endpoint;


import br.ufms.estagio.server.resource.entity.Cao;
import br.ufms.estagio.server.resource.entity.Concedente;
import br.ufms.estagio.server.resource.entity.PessoaJuridica;
import br.ufms.estagio.springbootlib.repository.GenericEntity;
import br.ufms.estagio.springbootlib.repository.ReadOnlyBaseRepository;
import br.ufms.estagio.springbootlib.service.ReadOnlyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 * @param <E>
 * @param <ID>
 * @param <S>
 */
public class ReadOnlyEndPoint<E extends GenericEntity<ID>, ID extends Serializable, S extends ReadOnlyService<E, ID, ? extends ReadOnlyBaseRepository<E, ID>>> {
    @Autowired
    private S service;

    private static final Logger LOG = LoggerFactory.getLogger(ReadOnlyEndPoint.class);

        @GetMapping( path = "/{id}")
        public ResponseEntity findOne(@PathVariable("id") ID id) {
        LOG.info("Entidades encontrads com findOne(" + 1 + ")");
        LOG.info("-------------------------------");
            E entity;
            entity = getService().findOne(id);
//            Class<?> enclosingClass = entity.getClass().getEnclosingClass();
//            if (enclosingClass != null) {
//                LOG.info(enclosingClass.);
//            } else {
//                LOG.info(entity.getClass().getName());
//            }

        return ResponseEntity.ok(entity);

    }

    @GetMapping
    public ResponseEntity findAll()  {
        LOG.info("Entidades encontrads com findAll():");
        LOG.info("-------------------------------");
        service.findAll().forEach((entity) -> {
            if (entity instanceof Concedente) {
                Concedente<PessoaJuridica> c = (Concedente) entity;
                LOG.info(c.getDados().getNome());
            }
            LOG.info(entity.toString());
        });
        LOG.info("-------------------------------\n");

        return ResponseEntity.ok(getService().findAll());
    }


    public S getService() {
        return service;
    }

}
