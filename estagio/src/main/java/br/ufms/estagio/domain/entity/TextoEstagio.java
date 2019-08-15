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
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade TextoEstagio.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_texto_estagio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TextoEstagio.findAll", query = "SELECT t FROM TextoEstagio t")
    , @NamedQuery(name = "TextoEstagio.findById", query = "SELECT t FROM TextoEstagio t WHERE t.id = :id")})
public class TextoEstagio extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tex_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tex_plano_atividades")
    private String planoAtividades;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tex_resumo")
    private String resumo;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tex_objetivo")
    private String objetivo;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tex_metodologia")
    private String metodologia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tex_id", referencedColumnName = "est_id")
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
     * @return the planoAtividades
     */
    public String getPlanoAtividades() {
        return planoAtividades;
    }

    /**
     * @param planoAtividades the planoAtividades to set
     */
    public void setPlanoAtividades(String planoAtividades) {
        this.planoAtividades = planoAtividades;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the metodologia
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
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
