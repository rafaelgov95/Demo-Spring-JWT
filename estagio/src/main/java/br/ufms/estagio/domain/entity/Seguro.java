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
package br.ufms.estagio.domain.entity;

import br.ufms.springbootlib.domain.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade Seguro.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_seguro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguro.findAll", query = "SELECT t FROM Seguro t")
    , @NamedQuery(name = "Seguro.findById", query = "SELECT t FROM Seguro t WHERE t.id = :id")
    , @NamedQuery(name = "Seguro.findByNumeroApolice", query = "SELECT t FROM Seguro t WHERE t.numeroApolice = :numeroApolice")
    , @NamedQuery(name = "Seguro.findBySeguradora", query = "SELECT t FROM Seguro t WHERE t.seguradora = :seguradora")})
public class Seguro extends GenericEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seg_id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "seg_numero_apolice")
    private Long numeroApolice;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "seg_seguradora")
    private String seguradora;

    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the numeroApolice
     */
    public Long getNumeroApolice() {
        return numeroApolice;
    }

    /**
     * @param numeroApolice the numeroApolice to set
     */
    public void setNumeroApolice(Long numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    /**
     * @return the seguradora
     */
    public String getSeguradora() {
        return seguradora;
    }

    /**
     * @param seguradora the seguradora to set
     */
    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }

}
