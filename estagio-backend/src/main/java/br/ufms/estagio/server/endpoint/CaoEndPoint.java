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
package br.ufms.estagio.server.endpoint;

import br.ufms.estagio.server.resource.entity.Cao;
import br.ufms.estagio.server.service.CaoService;
import br.ufms.estagio.springbootlib.endpoint.ReadWriteEndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kleber Kruger
 * @author Rafael Viana
 */


@RestController
@RequestMapping(path = "/cao")
public class CaoEndPoint extends ReadWriteEndPoint<Cao, Short, CaoService> {

    @PostMapping(path = "/amor")
    public ResponseEntity<Cao> insert(@RequestBody Cao entity) {
        return ResponseEntity.ok(getService().save(entity));
    }
//    public String teste (){
//        getService().criarcao();
//        return "";
//    }
}
