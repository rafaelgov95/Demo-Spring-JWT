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

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade PessoaFisica.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "pf_id", referencedColumnName = "p_id")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT t FROM PessoaFisica t")
    , @NamedQuery(name = "PessoaFisica.findById", query = "SELECT t FROM PessoaFisica t WHERE t.id = :id")
    , @NamedQuery(name = "PessoaFisica.findByRgNumero", query = "SELECT t FROM PessoaFisica t WHERE t.rgNumero = :rgNumero")
    , @NamedQuery(name = "PessoaFisica.findByRgOrgaoExpedidor", query = "SELECT t FROM PessoaFisica t WHERE t.rgOrgaoExpedidor = :rgOrgaoExpedidor")
    , @NamedQuery(name = "PessoaFisica.findByNacionalidade", query = "SELECT t FROM PessoaFisica t WHERE t.nacionalidade = :nacionalidade")})
public class PessoaFisica extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Column(name = "pf_rg_numero")
    private Integer rgNumero;

    @Size(max = 128)
    @Column(name = "pf_rg_orgao_expedidor")
    private String rgOrgaoExpedidor;

    @Size(max = 64)
    @Column(name = "pf_nacionalidade")
    private String nacionalidade;

    /**
     * @return the rgNumero
     */
    public Integer getRgNumero() {
        return rgNumero;
    }

    /**
     * @param rgNumero the rgNumero to set
     */
    public void setRgNumero(Integer rgNumero) {
        this.rgNumero = rgNumero;
    }

    /**
     * @return the rgOrgaoExpedidor
     */
    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    /**
     * @param rgOrgaoExpedidor the rgOrgaoExpedidor to set
     */
    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
