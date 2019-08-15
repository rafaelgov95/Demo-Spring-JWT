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

import br.ufms.estagio.domain.enumerate.ModalidadeEstagio;
import br.ufms.estagio.domain.enumerate.ModalidadeOrientacao;
import br.ufms.springbootlib.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Classe que mapeia a entidade Estagio.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_estagio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estagio.findAll", query = "SELECT t FROM Estagio t")
    , @NamedQuery(name = "Estagio.findById", query = "SELECT t FROM Estagio t WHERE t.id = :id")
    , @NamedQuery(name = "Estagio.findByModalidade", query = "SELECT t FROM Estagio t WHERE t.modalidade = :modalidade")
    , @NamedQuery(name = "Estagio.findByDataInicio", query = "SELECT t FROM Estagio t WHERE t.dataInicio = :dataInicio")
    , @NamedQuery(name = "Estagio.findByDataTermino", query = "SELECT t FROM Estagio t WHERE t.dataTermino = :dataTermino")
    , @NamedQuery(name = "Estagio.findByModalidadeOrientacao", query = "SELECT t FROM Estagio t WHERE t.modalidadeOrientacao = :modalidadeOrientacao")
    , @NamedQuery(name = "Estagio.findByValorBolsa", query = "SELECT t FROM Estagio t WHERE t.valorBolsa = :valorBolsa")
    , @NamedQuery(name = "Estagio.findByValorAuxilioTransporte", query = "SELECT t FROM Estagio t WHERE t.valorAuxilioTransporte = :valorAuxilioTransporte")})
public class Estagio extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "est_modalidade")
    @Enumerated(EnumType.STRING)
    private ModalidadeEstagio modalidade;

    @Basic(optional = false)
    @NotNull
    @Column(name = "est_data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "est_data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "est_modalidade_orientacao")
    @Enumerated(EnumType.STRING)
    private ModalidadeOrientacao modalidadeOrientacao;

    // @Max(value=?)  @Min(value=?) // if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "est_valor_bolsa")
    private Double valorBolsa;

    @Column(name = "est_valor_auxilio_transporte")
    private Double valorAuxilioTransporte;

    @JoinColumn(name = "ar_id_area", referencedColumnName = "ar_id")
    @ManyToOne(optional = false)
    private AreaEstagio area;

    @JoinColumn(name = "dis_id_estagiario", referencedColumnName = "dis_id")
    @ManyToOne(optional = false)
    private Discente estagiario;

    @JoinColumn(name = "doc_id_orientador", referencedColumnName = "doc_id")
    @ManyToOne(optional = false)
    private Docente orientador;

    @JoinColumn(name = "sup_id_supervisor", referencedColumnName = "sup_id")
    @ManyToOne(optional = false)
    private Supervisor supervisor;

    @OneToOne(mappedBy = "estagio", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ConcedenteInfo concedente;

    @OneToOne(mappedBy = "estagio", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private TextoEstagio texto;

    @OneToOne(mappedBy = "estagio", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private StatusEstagio status;

    @JoinColumn(name = "seg_id_seguro", referencedColumnName = "seg_id")
    @ManyToOne(optional = false)
    private Seguro seguro;
    
    @OneToMany(mappedBy = "estagio", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("hor_id")
    private Collection<HorarioEstagiario> horarios;

    public Estagio() {
        this.horarios = new HashSet<>();
    }

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
     * @return the modalidade
     */
    public ModalidadeEstagio getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(ModalidadeEstagio modalidade) {
        this.modalidade = modalidade;
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
     * @return the modalidadeOrientacao
     */
    public ModalidadeOrientacao getModalidadeOrientacao() {
        return modalidadeOrientacao;
    }

    /**
     * @param orientacao the modalidadeOrientacao to set
     */
    public void setModalidadeOrientacao(ModalidadeOrientacao orientacao) {
        this.modalidadeOrientacao = orientacao;
    }

    /**
     * @return the valorBolsa
     */
    public Double getValorBolsa() {
        return valorBolsa;
    }

    /**
     * @param bolsa the valorBolsa to set
     */
    public void setValorBolsa(Double bolsa) {
        this.valorBolsa = bolsa;
    }

    /**
     * @return the valorAuxilioTransporte
     */
    public Double getValorAuxilioTransporte() {
        return valorAuxilioTransporte;
    }

    /**
     * @param auxilioTransporte the valorAuxilioTransporte to set
     */
    public void setValorAuxilioTransporte(Double auxilioTransporte) {
        this.valorAuxilioTransporte = auxilioTransporte;
    }

    /**
     * @return the area
     */
    @JsonIgnore
    public AreaEstagio getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(AreaEstagio area) {
        this.area = area;
    }

    /**
     * @return the estagiario
     */
    @JsonIgnore
    public Discente getEstagiario() {
        return estagiario;
    }

    /**
     * @param estagiario the estagiario to set
     */
    public void setEstagiario(Discente estagiario) {
        this.estagiario = estagiario;
    }

    /**
     * @return the orientador
     */
    @JsonIgnore
    public Docente getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(Docente orientador) {
        this.orientador = orientador;
    }

    /**
     * @return the supervisor
     */
    @JsonIgnore
    public Supervisor getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the concedente
     */
    @JsonIgnore
    public ConcedenteInfo getConcedente() {
        return concedente;
    }

    /**
     * @param concedente the concedente to set
     */
    public void setConcedente(ConcedenteInfo concedente) {
        this.concedente = concedente;
    }

    /**
     * @return the texto
     */
    @JsonIgnore
    public TextoEstagio getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(TextoEstagio texto) {
        this.texto = texto;
    }

    /**
     * @return the status
     */
    @JsonIgnore
    public StatusEstagio getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusEstagio status) {
        this.status = status;
    }

    /**
     * @return the seguro
     */
    @JsonIgnore
    public Seguro getSeguro() {
        return seguro;
    }

    /**
     * @param seguro the seguro to set
     */
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
    /**
     * @return the horarios
     */
    @JsonIgnore
    public Collection<HorarioEstagiario> getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(Collection<HorarioEstagiario> horarios) {
        this.horarios = horarios;
    }

    /**
     * Adiciona um horário a este estágio.
     *
     * @param horario
     */
    public void addHorario(HorarioEstagiario horario) {
        horarios.add(horario);
        horario.setEstagio(this);
    }

    /**
     * Remove um horário deste estágio.
     *
     * @param horario
     */
    public void removeHorario(HorarioEstagiario horario) {
        horarios.remove(horario);
        horario.setEstagio(null);
    }

}
