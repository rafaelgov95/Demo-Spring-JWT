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
package br.ufms.springbootlib.service;

import br.ufms.springbootlib.domain.GenericEntity;
import br.ufms.springbootlib.domain.ReadOnlyBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kleber Kruger
 *
 * @param <E>
 * @param <ID>
 * @param <R>
 */
public class ReadOnlyService<E extends GenericEntity<ID>, ID extends Serializable, R extends ReadOnlyBaseRepository<E, ID>> {

    @Autowired
    private R repository;

    public E findOne(ID id) {
        return getRepository().getOne(id);
    }

    public List<E> findAll() {
        return getRepository().findAll();
    }

    /**
     * @return the repository
     */
    public R getRepository() {
        return repository;
    }

}
