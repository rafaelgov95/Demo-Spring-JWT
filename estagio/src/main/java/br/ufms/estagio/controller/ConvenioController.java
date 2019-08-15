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
package br.ufms.estagio.controller;

import br.ufms.estagio.domain.entity.Convenio;
import br.ufms.estagio.domain.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/convenios")
public class ConvenioController {
    
    @Autowired
    private ConvenioRepository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Convenio findOne(@PathVariable("id") Long id) {
        return repository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Convenio> findAll() {
        return repository.findAll();
    }
    
}