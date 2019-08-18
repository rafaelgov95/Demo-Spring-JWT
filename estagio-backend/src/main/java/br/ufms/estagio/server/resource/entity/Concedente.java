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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */

@Entity
@Table(name = "tb_concedente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concedente.findAll", query = "SELECT t FROM Concedente t")
    , @NamedQuery(name = "Concedente.findById", query = "SELECT t FROM Concedente t WHERE t.id = :id")
    , @NamedQuery(name = "Concedente.findByConveniado", query = "SELECT t FROM Concedente t WHERE t.conveniado = :conveniado")})
public class Concedente<P extends Pessoa> extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_id")
    private Long id;

    @JoinColumn(name = "con_id", referencedColumnName = "p_id", insertable = false, updatable = false)
    @OneToOne(targetEntity = Pessoa.class, optional = false)
    private P dados;

    @JoinColumn(name = "rep_id_representante_legal", referencedColumnName = "rep_id")
    @ManyToOne(optional = false)
    private RepresentanteLegal representanteLegal;

    @Column(name = "con_conveniado")
    private Boolean conveniado;

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
     * @param <S>
     * @return the dados
     */
    @JsonIgnore
    public <S extends P> S getDados() {
        return (S) dados;
    }

    /**
     * @param <S>
     * @param dados the dados to set
     */
    public <S extends P> void setDados(S dados) {
        this.dados = dados;
    }

    /**
     * @return the representanteLegal
     */
    @JsonIgnore
    public RepresentanteLegal getRepresentanteLegal() {
        return representanteLegal;
    }

    /**
     * @param representanteLegal the representanteLegal to set
     */
    public void setRepresentanteLegal(RepresentanteLegal representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    /**
     * @return the conveniado
     */
    public Boolean getConveniado() {
        return conveniado;
    }

    /**
     * @param conveniado the conveniado to set
     */
    public void setConveniado(Boolean conveniado) {
        this.conveniado = conveniado;
    }

}
