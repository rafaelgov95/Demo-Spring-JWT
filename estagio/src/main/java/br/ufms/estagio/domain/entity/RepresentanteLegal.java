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

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade RepresentanteLegal.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_representante_legal")
@PrimaryKeyJoinColumn(name = "rep_id", referencedColumnName = "pf_id")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepresentanteLegal.findAll", query = "SELECT t FROM RepresentanteLegal t")
    , @NamedQuery(name = "RepresentanteLegal.findById", query = "SELECT t FROM RepresentanteLegal t WHERE t.id = :id")
    , @NamedQuery(name = "RepresentanteLegal.findByFuncao", query = "SELECT t FROM RepresentanteLegal t WHERE t.funcao = :funcao")})
public class RepresentanteLegal extends PessoaFisica {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "rep_funcao")
    private String funcao;

    @JoinColumn(name = "rep_id", referencedColumnName = "pf_id", insertable = false, updatable = false)
    @OneToOne(targetEntity = PessoaFisica.class, optional = false)
    private PessoaFisica dados;

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the dados
     */
    @JsonIgnore
    public PessoaFisica getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(PessoaFisica dados) {
        this.dados = dados;
    }

}
