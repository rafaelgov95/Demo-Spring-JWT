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


import br.ufms.estagio.server.resource.enumerate.TipoUsuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "u_id", referencedColumnName = "pf_id")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Usuario.findAll", query = "SELECT t FROM Usuario t")
//    , @NamedQuery(name = "Usuario.findById", query = "SELECT t FROM Usuario t WHERE t.id = :id")
//    , @NamedQuery(name = "Usuario.findByTipo", query = "SELECT t FROM Usuario t WHERE t.tipoUsuario = :tipoUsuario")
//    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT t FROM Usuario t WHERE t.senha = :senha")
//    , @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT t FROM Usuario t WHERE t.ativo = :ativo")})
public class Usuario extends PessoaFisica {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "u_senha")
    private String senha;

    @Basic(optional = false)
    @NotNull
    @Column(name = "u_ativo")
    private Boolean ativo;

    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 10)
    @Column(name = "u_tipo")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the tipo
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipo to set
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
