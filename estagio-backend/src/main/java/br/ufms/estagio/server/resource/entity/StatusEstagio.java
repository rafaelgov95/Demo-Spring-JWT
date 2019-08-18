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
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */

@Entity
@Table(name = "tb_status_estagio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusEstagio.findAll", query = "SELECT t FROM StatusEstagio t")
    , @NamedQuery(name = "StatusEstagio.findById", query = "SELECT t FROM StatusEstagio t WHERE t.id = :id")
    , @NamedQuery(name = "StatusEstagio.findByLocalAprovado", query = "SELECT t FROM StatusEstagio t WHERE t.localAprovado = :localAprovado")
    , @NamedQuery(name = "StatusEstagio.findByLocalAprovadoEm", query = "SELECT t FROM StatusEstagio t WHERE t.localAprovadoEm = :localAprovadoEm")
    , @NamedQuery(name = "StatusEstagio.findByEstagioAprovado", query = "SELECT t FROM StatusEstagio t WHERE t.estagioAprovado = :estagioAprovado")
    , @NamedQuery(name = "StatusEstagio.findByEstagioAprovadoEm", query = "SELECT t FROM StatusEstagio t WHERE t.estagioAprovadoEm = :estagioAprovadoEm")
    , @NamedQuery(name = "StatusEstagio.findByRelatorioFinalAprovado", query = "SELECT t FROM StatusEstagio t WHERE t.relatorioFinalAprovado = :relatorioFinalAprovado")
    , @NamedQuery(name = "StatusEstagio.findByRelatorioFinalAprovadoEm", query = "SELECT t FROM StatusEstagio t WHERE t.relatorioFinalAprovadoEm = :relatorioFinalAprovadoEm")})
public class StatusEstagio extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sta_id")
    private Long id;

    @Column(name = "sta_local_aprovado")
    private Boolean localAprovado;

    @Column(name = "sta_local_aprovado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date localAprovadoEm;

    @Column(name = "sta_estagio_aprovado")
    private Boolean estagioAprovado;

    @Column(name = "sta_estagio_aprovado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estagioAprovadoEm;

    @Column(name = "sta_relatorio_final_aprovado")
    private Boolean relatorioFinalAprovado;

    @Column(name = "sta_relatorio_final_aprovado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date relatorioFinalAprovadoEm;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sta_id", referencedColumnName = "est_id")
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
     * @return the localAprovado
     */
    public Boolean getLocalAprovado() {
        return localAprovado;
    }

    /**
     * @param localAprovado the localAprovado to set
     */
    public void setLocalAprovado(Boolean localAprovado) {
        this.localAprovado = localAprovado;
    }

    /**
     * @return the localAprovadoEm
     */
    public Date getLocalAprovadoEm() {
        return localAprovadoEm;
    }

    /**
     * @param localAprovadoEm the localAprovadoEm to set
     */
    public void setLocalAprovadoEm(Date localAprovadoEm) {
        this.localAprovadoEm = localAprovadoEm;
    }

    /**
     * @return the estagioAprovado
     */
    public Boolean getEstagioAprovado() {
        return estagioAprovado;
    }

    /**
     * @param estagioAprovado the estagioAprovado to set
     */
    public void setEstagioAprovado(Boolean estagioAprovado) {
        this.estagioAprovado = estagioAprovado;
    }

    /**
     * @return the estagioAprovadoEm
     */
    public Date getEstagioAprovadoEm() {
        return estagioAprovadoEm;
    }

    /**
     * @param estagioAprovadoEm the estagioAprovadoEm to set
     */
    public void setEstagioAprovadoEm(Date estagioAprovadoEm) {
        this.estagioAprovadoEm = estagioAprovadoEm;
    }

    /**
     * @return the relatorioFinalAprovado
     */
    public Boolean getRelatorioFinalAprovado() {
        return relatorioFinalAprovado;
    }

    /**
     * @param relatorioFinalAprovado the relatorioFinalAprovado to set
     */
    public void setRelatorioFinalAprovado(Boolean relatorioFinalAprovado) {
        this.relatorioFinalAprovado = relatorioFinalAprovado;
    }

    /**
     * @return the relatorioFinalAprovadoEm
     */
    public Date getRelatorioFinalAprovadoEm() {
        return relatorioFinalAprovadoEm;
    }

    /**
     * @param relatorioFinalAprovadoEm the relatorioFinalAprovadoEm to set
     */
    public void setRelatorioFinalAprovadoEm(Date relatorioFinalAprovadoEm) {
        this.relatorioFinalAprovadoEm = relatorioFinalAprovadoEm;
    }

    /**
     * @return the estagio
     */
    @JsonIgnore
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
