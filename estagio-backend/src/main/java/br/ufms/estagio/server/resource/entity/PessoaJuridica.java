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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe que mapeia a entidade PessoaJuridica.
 * 
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_pessoa_juridica")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "pj_id", referencedColumnName = "p_id")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT t FROM PessoaJuridica t")
//    , @NamedQuery(name = "PessoaJuridica.findById", query = "SELECT t FROM PessoaJuridica t WHERE t.id = :id")
//    , @NamedQuery(name = "PessoaJuridica.findByRazaoSocial", query = "SELECT t FROM PessoaJuridica t WHERE t.razaoSocial = :razaoSocial")})
public class PessoaJuridica extends Pessoa {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pj_id")
    private Long id;

    @Size(max = 255)
    @Column(name = "pj_razao_social")
    private String razaoSocial;
    
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
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
