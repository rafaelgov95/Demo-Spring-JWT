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

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@Entity
@Table(name = "tb_supervisor")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "sup_id", referencedColumnName = "u_id")
@XmlRootElement
public class Supervisor extends Usuario {

    private static final long serialVersionUID = 1L;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "sup_cargo")
    private String cargo;

    @Size(max = 255)
    @Column(name = "sup_lattes_url")
    private String lattesUrl;

    @Column(name = "sup_aprovado")
    private Boolean aprovado;

    @Column(name = "sup_aprovado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprovadoEm;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("form_id")
    private Collection<FormacaoAcademica> formacoesAcademicas;

    public Supervisor() {
        this.formacoesAcademicas = new HashSet<>();
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the lattesUrl
     */
    public String getLattesUrl() {
        return lattesUrl;
    }

    /**
     * @param lattesUrl the lattesUrl to set
     */
    public void setLattesUrl(String lattesUrl) {
        this.lattesUrl = lattesUrl;
    }

    /**
     * @return the aprovado
     */
    public Boolean getAprovado() {
        return aprovado;
    }

    /**
     * @param aprovado the aprovado to set
     */
    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    /**
     * @return the aprovadoEm
     */
    public Date getAprovadoEm() {
        return aprovadoEm;
    }

    /**
     * @param aprovadoEm the aprovadoEm to set
     */
    public void setAprovadoEm(Date aprovadoEm) {
        this.aprovadoEm = aprovadoEm;
    }

    /**
     * @return the formacoesAcademicas
     */
    @JsonIgnore
    public Collection<FormacaoAcademica> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    /**
     * @param formacoesAcademicas the formacoesAcademicas to set
     */
    public void setFormacoesAcademicas(Collection<FormacaoAcademica> formacoesAcademicas) {
        this.formacoesAcademicas = formacoesAcademicas;
    }

    /**
     * Adiciona uma formação acadêmica a este supervisor.
     *
     * @param formacao
     */
    public void addFormacaoAcademica(FormacaoAcademica formacao) {
        formacoesAcademicas.add(formacao);
        formacao.setSupervisor(this);
    }

    /**
     * Remove uma formação acadêmica deste supervisor.
     *
     * @param formacao
     */
    public void removeFormacaoAcademica(FormacaoAcademica formacao) {
        formacoesAcademicas.remove(formacao);
        formacao.setSupervisor(null);
    }

}
