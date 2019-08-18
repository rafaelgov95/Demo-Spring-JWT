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
package br.ufms.estagio.springbootlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * JpaRepository somente-leitura genérico.
 *
 * @author Kleber Kruger
 * @author Rafael Viana
 * @param <E>
 * @param <ID>
 */
@NoRepositoryBean
@Transactional(readOnly = true)
public interface ReadOnlyBaseRepository<E extends GenericEntity<ID>, ID extends Serializable>
        extends JpaRepository<E, ID>/*, QueryDslPredicateExecutor<E>*/ {

}
