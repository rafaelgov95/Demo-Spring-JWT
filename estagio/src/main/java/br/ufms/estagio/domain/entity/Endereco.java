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
 * Classe que mapeia a entidade Endereco.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT t FROM Endereco t")
    , @NamedQuery(name = "Endereco.findById", query = "SELECT t FROM Endereco t WHERE t.id = :id")
    , @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT t FROM Endereco t WHERE t.logradouro = :logradouro")
    , @NamedQuery(name = "Endereco.findByNumero", query = "SELECT t FROM Endereco t WHERE t.numero = :numero")
    , @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT t FROM Endereco t WHERE t.complemento = :complemento")
    , @NamedQuery(name = "Endereco.findByBairro", query = "SELECT t FROM Endereco t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "Endereco.findByCep", query = "SELECT t FROM Endereco t WHERE t.cep = :cep")
    , @NamedQuery(name = "Endereco.findByReferencia", query = "SELECT t FROM Endereco t WHERE t.referencia = :referencia")})
public class Endereco extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "end_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "end_logradouro")
    private String logradouro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "end_numero")
    private Short numero;

    @Size(max = 255)
    @Column(name = "end_complemento")
    private String complemento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "end_bairro")
    private String bairro;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "end_cep")
        private String cep;

    @Size(max = 255)
    @Column(name = "end_referencia")
    private String referencia;

    @JoinColumn(name = "mun_codigo_ibge", referencedColumnName = "mun_codigo_ibge")
    @ManyToOne(optional = false)
    private Municipio municipio;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "end_id", referencedColumnName = "p_id")
    @MapsId
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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Short getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Short numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the municipio
     */
    @JsonIgnore
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
