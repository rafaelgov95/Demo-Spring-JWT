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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Classe que mapeia a entidade ConcedenteInfo.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_estagio_concedente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConcedenteInfo.findAll", query = "SELECT t FROM ConcedenteInfo t")
    , @NamedQuery(name = "ConcedenteInfo.findById", query = "SELECT t FROM ConcedenteInfo t WHERE t.id = :id")
    , @NamedQuery(name = "ConcedenteInfo.findByContato", query = "SELECT t FROM ConcedenteInfo t WHERE t.contato = :contato")
    , @NamedQuery(name = "ConcedenteInfo.findByConveniada", query = "SELECT t FROM ConcedenteInfo t WHERE t.conveniada = :conveniada")
    , @NamedQuery(name = "ConcedenteInfo.findByConvenioInicio", query = "SELECT t FROM ConcedenteInfo t WHERE t.convenioInicio = :convenioInicio")
    , @NamedQuery(name = "ConcedenteInfo.findByConvenioTermino", query = "SELECT t FROM ConcedenteInfo t WHERE t.convenioTermino = :convenioTermino")})
public class ConcedenteInfo extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estcon_id")
    private Long id;

    @JoinColumn(name = "con_id_concedente", referencedColumnName = "con_id")
    @ManyToOne(optional = false)
    private Concedente concedente;

    @JoinColumn(name = "rep_id_representante_legal", referencedColumnName = "rep_id")
    @ManyToOne(optional = false)
    private RepresentanteLegal representanteLegal;

    @Size(max = 255)
    @Column(name = "estcon_contato")
    private String contato;

    @Column(name = "estcon_conveniada")
    private Boolean conveniada;

    @Column(name = "estcon_convenio_inicio")
    @Temporal(TemporalType.DATE)
    private Date convenioInicio;

    @Column(name = "estcon_convenio_termino")
    @Temporal(TemporalType.DATE)
    private Date convenioTermino;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estcon_id", referencedColumnName = "est_id")
    @MapsId
    private Estagio estagio;

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
     * @return the concedente
     */
    public Concedente getConcedente() {
        return concedente;
    }

    /**
     * @param concedente the concedente to set
     */
    public void setConcedente(Concedente concedente) {
        this.concedente = concedente;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the representanteLegal
     */
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
     * @return the conveniada
     */
    public Boolean getConveniada() {
        return conveniada;
    }

    /**
     * @param conveniada the conveniada to set
     */
    public void setConveniada(Boolean conveniada) {
        this.conveniada = conveniada;
    }

    /**
     * @return the convenioInicio
     */
    public Date getConvenioInicio() {
        return convenioInicio;
    }

    /**
     * @param convenioInicio the convenioInicio to set
     */
    public void setConvenioInicio(Date convenioInicio) {
        this.convenioInicio = convenioInicio;
    }

    /**
     * @return the convenioTermino
     */
    public Date getConvenioTermino() {
        return convenioTermino;
    }

    /**
     * @param convenioTermino the convenioTermino to set
     */
    public void setConvenioTermino(Date convenioTermino) {
        this.convenioTermino = convenioTermino;
    }

    /**
     * @return the estagio
     */
    public Estagio getEstagio() {
        return estagio;
    }

    /**
     * @param estagio the estagio to set
     */
    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

}
