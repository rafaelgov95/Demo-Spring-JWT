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
@Table(name = "tb_convenio")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Convenio.findAll", query = "SELECT t FROM Convenio t")
//    , @NamedQuery(name = "Convenio.findById", query = "SELECT t FROM Convenio t WHERE t.id = :id")
//    , @NamedQuery(name = "Convenio.findByNumero", query = "SELECT t FROM Convenio t WHERE t.numero = :numero")
//    , @NamedQuery(name = "Convenio.findByDataInicio", query = "SELECT t FROM Convenio t WHERE t.dataInicio = :dataInicio")
//    , @NamedQuery(name = "Convenio.findByDataTermino", query = "SELECT t FROM Convenio t WHERE t.dataTermino = :dataTermino")})
public class Convenio extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "conv_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "conv_numero")
    private String numero;

    @Basic(optional = false)
    @NotNull
    @Column(name = "conv_data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "conv_data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conv_id", referencedColumnName = "con_id")
    @MapsId
    private Concedente concedente;

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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the concedente
     */
    @JsonIgnore
    public Concedente getConcedente() {
        return concedente;
    }

    /**
     * @param concedente the concedente to set
     */
    public void setConcedente(Concedente concedente) {
        this.concedente = concedente;
    }

}
