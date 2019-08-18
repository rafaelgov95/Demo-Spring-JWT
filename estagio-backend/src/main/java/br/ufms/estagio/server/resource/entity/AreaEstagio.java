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
package br.ufms.estagio.server.resource.entity;


import br.ufms.estagio.springbootlib.repository.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */

@Entity
@Table(name = "tb_area_estagio")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "AreaEstagio.findAll", query = "SELECT t FROM AreaEstagio t")
//    , @NamedQuery(name = "AreaEstagio.findById", query = "SELECT t FROM AreaEstagio t WHERE t.id = :id")
//    , @NamedQuery(name = "AreaEstagio.findByNome", query = "SELECT t FROM AreaEstagio t WHERE t.nome = :nome")
//    , @NamedQuery(name = "AreaEstagio.findByDescricao", query = "SELECT t FROM AreaEstagio t WHERE t.descricao = :descricao")})
public class AreaEstagio extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ar_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ar_nome")
    private String nome;

    @Size(max = 255)
    @Column(name = "ar_descricao")
    private String descricao;

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
