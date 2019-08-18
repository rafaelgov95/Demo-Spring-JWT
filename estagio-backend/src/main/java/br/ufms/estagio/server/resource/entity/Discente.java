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
import java.util.Date;
/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@Entity
@Table(name = "tb_discente")
@PrimaryKeyJoinColumn(name = "dis_id", referencedColumnName = "u_id")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Discente.findAll", query = "SELECT t FROM Discente t")
//    , @NamedQuery(name = "Discente.findById", query = "SELECT t FROM Discente t WHERE t.id = :id")
//    , @NamedQuery(name = "Discente.findByRga", query = "SELECT t FROM Discente t WHERE t.rga = :rga")
//    , @NamedQuery(name = "Discente.findByDataIngresso", query = "SELECT t FROM Discente t WHERE t.dataIngresso = :dataIngresso")})
public class Discente extends Usuario {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "dis_rga")
    private String rga;

    @JoinColumn(name = "cs_codigo", referencedColumnName = "cs_codigo")
    @ManyToOne(optional = false)
    private Curso curso;

    @Column(name = "dis_ingresso_em")
    @Temporal(TemporalType.DATE)
    private Date dataIngresso;

    /**
     * @return the rga
     */
    public String getRga() {
        return rga;
    }

    /**
     * @param rga the rga to set
     */
    public void setRga(String rga) {
        this.rga = rga;
    }

    /**
     * @return the curso
     */
    @JsonIgnore
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the dataIngresso
     */
    public Date getDataIngresso() {
        return dataIngresso;
    }

    /**
     * @param dataIngresso the dataIngresso to set
     */
    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
