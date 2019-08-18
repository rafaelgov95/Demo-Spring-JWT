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

import br.ufms.estagio.springbootlib.repository.GenericEntity;
import br.ufms.estagio.springbootlib.repository.ReadWriteBaseRepository;
import br.ufms.estagio.springbootlib.service.ReadWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
  * @author Kleber Kruger
 * @author Rafael Viana
 */
@MappedSuperclass
public class ReadWriteEndPoint<E extends GenericEntity<ID>, ID extends Serializable, S extends ReadWriteService<E, ID, ? extends ReadWriteBaseRepository<E, ID>>>
        extends ReadOnlyEndPoint<E, ID, S> {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<E> save(@RequestBody E entity) {
        return ResponseEntity.ok(getService().save(entity));
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity) {
        return ResponseEntity.ok(getService().save(entity));
    }


    @DeleteMapping
    public ResponseEntity delete (@RequestBody E entity) {
        getService().delete(entity);
        return ResponseEntity.ok("Apagado");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable("id") ID id) {
        getService().delete(id);
        return ResponseEntity.ok("Apagado");
    }

}
