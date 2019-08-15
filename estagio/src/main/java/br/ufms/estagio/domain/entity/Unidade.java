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
 * Classe que mapeia a entidade Unidade.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_unidade")
@PrimaryKeyJoinColumn(name = "uni_id", referencedColumnName = "pj_id")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT t FROM Unidade t")
    , @NamedQuery(name = "Unidade.findById", query = "SELECT t FROM Unidade t WHERE t.id = :id")
    , @NamedQuery(name = "Unidade.findBySigla", query = "SELECT t FROM Unidade t WHERE t.sigla = :sigla")})
public class Unidade extends PessoaJuridica {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uni_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "uni_sigla")
    private String sigla;

    @JoinColumn(name = "doc_id_responsavel", referencedColumnName = "doc_id")
    @ManyToOne(optional = false)
    private Docente responsavel;
    
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
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the responsavel
     */
    @JsonIgnore
    public Docente getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

}
