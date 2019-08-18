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

import br.ufms.estagio.server.resource.enumerate.GrauAcademico;
import br.ufms.estagio.springbootlib.repository.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe que mapeia a entidade FormacaoAcademica.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_formacao_academica")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "FormacaoAcademica.findAll", query = "SELECT t FROM FormacaoAcademica t")
//    , @NamedQuery(name = "FormacaoAcademica.findById", query = "SELECT t FROM FormacaoAcademica t WHERE t.id = :id")
//    , @NamedQuery(name = "FormacaoAcademica.findByGrauAcademico", query = "SELECT t FROM FormacaoAcademica t WHERE t.grauAcademico = :grauAcademico")
//    , @NamedQuery(name = "FormacaoAcademica.findByTitulo", query = "SELECT t FROM FormacaoAcademica t WHERE t.titulo = :titulo")
//    , @NamedQuery(name = "FormacaoAcademica.findByArea", query = "SELECT t FROM FormacaoAcademica t WHERE t.area = :area")
//    , @NamedQuery(name = "FormacaoAcademica.findByInstituicao", query = "SELECT t FROM FormacaoAcademica t WHERE t.instituicao = :instituicao")
//    , @NamedQuery(name = "FormacaoAcademica.findByAnoConclusao", query = "SELECT t FROM FormacaoAcademica t WHERE t.anoConclusao = :anoConclusao")})
public class FormacaoAcademica extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "form_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "form_grau_academico")
    @Enumerated(EnumType.STRING)
    private GrauAcademico grauAcademico;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "form_titulo")
    private String titulo;

    @Size(max = 255)
    @Column(name = "form_area")
    private String area;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "form_instituicao")
    private String instituicao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "form_ano_conclusao")
    private Short anoConclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sup_id")
    private Supervisor supervisor;

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
     * @return the grauAcademico
     */
    public GrauAcademico getGrauAcademico() {
        return grauAcademico;
    }

    /**
     * @param grauAcademico the grauAcademico to set
     */
    public void setGrauAcademico(GrauAcademico grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the anoConclusao
     */
    public Short getAnoConclusao() {
        return anoConclusao;
    }

    /**
     * @param anoConclusao the anoConclusao to set
     */
    public void setAnoConclusao(Short anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    /**
     * @return the supervisor
     */
    public Supervisor getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

}
