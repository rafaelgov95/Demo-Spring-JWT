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


import br.ufms.estagio.server.resource.entity.Pessoa;
import br.ufms.estagio.springbootlib.repository.ReadWriteBaseRepository;
import br.ufms.estagio.springbootlib.service.ReadWriteService;
import br.ufms.estagio.springbootlib.endpoint.ReadWriteEndPoint;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
public abstract class PessoaBaseEndPoint<P extends Pessoa>
        extends ReadWriteEndPoint<P, Long, ReadWriteService<P, Long, ? extends ReadWriteBaseRepository<P, Long>>> {

}
