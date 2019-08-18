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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */

@Entity
@Table(name = "tb_endereco_eletronico")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "EnderecoEletronico.findAll", query = "SELECT t FROM EnderecoEletronico t")
//    , @NamedQuery(name = "EnderecoEletronico.findById", query = "SELECT t FROM EnderecoEletronico t WHERE t.id = :id")
//    , @NamedQuery(name = "EnderecoEletronico.findByTipo", query = "SELECT t FROM EnderecoEletronico t WHERE t.tipo = :tipo")
//    , @NamedQuery(name = "EnderecoEletronico.findByEndereco", query = "SELECT t FROM EnderecoEletronico t WHERE t.endereco = :endereco")
//    , @NamedQuery(name = "EnderecoEletronico.findByPrioridade", query = "SELECT t FROM EnderecoEletronico t WHERE t.prioridade = :prioridade")})
public class EnderecoEletronico extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endel_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "endel_tipo")
    private String tipo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endel_endereco")
    private String endereco;

    @Column(name = "endel_prioridade")
    private Short prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Pessoa pessoa;

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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the prioridade
     */
    public Short getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(Short prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the pessoa
     */
    @JsonIgnore
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
