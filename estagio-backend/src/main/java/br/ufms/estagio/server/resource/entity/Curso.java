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

import br.ufms.estagio.server.resource.enumerate.ModalidadeCurso;
import br.ufms.estagio.server.resource.enumerate.Periodo;
import br.ufms.estagio.springbootlib.repository.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que mapeia a entidade Curso.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_curso")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Curso.findAll", query = "SELECT t FROM Curso t")
//    , @NamedQuery(name = "Curso.findByCodigo", query = "SELECT t FROM Curso t WHERE t.codigo = :codigo")
//    , @NamedQuery(name = "Curso.findByNome", query = "SELECT t FROM Curso t WHERE t.nome = :nome")
//    , @NamedQuery(name = "Curso.findBySigla", query = "SELECT t FROM Curso t WHERE t.sigla = :sigla")
//    , @NamedQuery(name = "Curso.findByPeriodo", query = "SELECT t FROM Curso t WHERE t.periodo = :periodo")
//    , @NamedQuery(name = "Curso.findByModalidade", query = "SELECT t FROM Curso t WHERE t.modalidade = :modalidade")
//    , @NamedQuery(name = "Curso.findByAtivo", query = "SELECT t FROM Curso t WHERE t.ativo = :ativo")})
public class Curso extends GenericEntity<Short> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cs_codigo")
    private Short codigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cs_nome")
    private String nome;

    @Size(max = 32)
    @Column(name = "cs_sigla")
    private String sigla;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cs_periodo")
    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cs_modalidade")
    @Enumerated(EnumType.STRING)
    private ModalidadeCurso modalidade;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cs_ativo")
    private Boolean ativo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_curso_area_estagio", joinColumns = @JoinColumn(name = "cs_codigo"),
            inverseJoinColumns = @JoinColumn(name = "ar_id"))
    private Set<AreaEstagio> areasEstagio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_curso_docente", joinColumns = @JoinColumn(name = "cs_codigo"),
            inverseJoinColumns = @JoinColumn(name = "doc_id"))
    private Set<Docente> docentes;

    @JoinColumn(name = "doc_id_presidente_coe", referencedColumnName = "doc_id")
    @ManyToOne
    private Docente presidenteCoe;

    @JoinColumn(name = "doc_id_coordenador", referencedColumnName = "doc_id")
    @ManyToOne(optional = false)
    private Docente coordenador;

    @JoinColumn(name = "uni_id_unidade", referencedColumnName = "uni_id")
    @ManyToOne(optional = false)
    private Unidade unidade;

    /**
     * Cria um objeto Curso.
     */
    public Curso() {
        this.docentes = new HashSet<>();
        this.areasEstagio = new HashSet<>();
    }

    @Override
    public Short getId() {
        return getCodigo();
    }

    /**
     * @return the codigo
     */
    public Short getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the modalidade
     */
    public ModalidadeCurso getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(ModalidadeCurso modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the ativo
     */
    public Boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the presidenteCoe
     */
    @JsonIgnore
    public Docente getPresidenteCoe() {
        return presidenteCoe;
    }

    /**
     * @param presidenteCoe the presidenteCoe to set
     */
    public void setPresidenteCoe(Docente presidenteCoe) {
        this.presidenteCoe = presidenteCoe;
    }

    /**
     * @return the coordenador
     */
    @JsonIgnore
    public Docente getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(Docente coordenador) {
        this.coordenador = coordenador;
    }

    /**
     * @return the unidade
     */
    @JsonIgnore
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the docentes
     */
    @JsonIgnore
    public Set<Docente> getDocentes() {
        return docentes;
    }

    /**
     * @param docentes the docentes to set
     */
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }

    /**
     * @return the areasEstagio
     */
    @JsonIgnore
    public Set<AreaEstagio> getAreasEstagio() {
        return areasEstagio;
    }

    /**
     * @param areasEstagio the areasEstagio to set
     */
    public void setAreasEstagio(Set<AreaEstagio> areasEstagio) {
        this.areasEstagio = areasEstagio;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[codigo=" + getCodigo() + "]";
    }

}
