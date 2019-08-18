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

import br.ufms.estagio.server.resource.enumerate.Atividade;
import br.ufms.estagio.springbootlib.repository.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.DayOfWeek;
import java.util.Date;
/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@Entity
@Table(name = "tb_horario_estagiario")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "HorarioEstagiario.findAll", query = "SELECT t FROM HorarioEstagiario t")
//    , @NamedQuery(name = "HorarioEstagiario.findById", query = "SELECT t FROM HorarioEstagiario t WHERE t.id = :id")
//    , @NamedQuery(name = "HorarioEstagiario.findByDiaSemana", query = "SELECT t FROM HorarioEstagiario t WHERE t.diaSemana = :diaSemana")
//    , @NamedQuery(name = "HorarioEstagiario.findByInicio", query = "SELECT t FROM HorarioEstagiario t WHERE t.inicio = :inicio")
//    , @NamedQuery(name = "HorarioEstagiario.findByTermino", query = "SELECT t FROM HorarioEstagiario t WHERE t.termino = :termino")
//    , @NamedQuery(name = "HorarioEstagiario.findByAtividade", query = "SELECT t FROM HorarioEstagiario t WHERE t.atividade = :atividade")})
public class HorarioEstagiario extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "hor_dia_semana")
    private DayOfWeek diaSemana;

    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_termino")
    @Temporal(TemporalType.TIME)
    private Date termino;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "hor_atividade")
    @Enumerated(EnumType.STRING)
    private Atividade atividade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "est_id_estagio")
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
     * @return the diaSemana
     */
    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    /**
     * @param diaSemana the diaSemana to set
     */
    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the termino
     */
    public Date getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(Date termino) {
        this.termino = termino;
    }

    /**
     * @return the atividade
     */
    public Atividade getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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
