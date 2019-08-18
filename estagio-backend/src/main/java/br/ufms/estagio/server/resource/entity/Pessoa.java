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

import br.ufms.estagio.server.resource.enumerate.TipoPessoa;
import br.ufms.estagio.springbootlib.repository.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public abstract class Pessoa extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "p_nome")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "p_cpf_cnpj")
    private String cpfCnpj;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("tel_prioridade")
    private Collection<Telefone> telefones;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("endel_prioridade")
    private Collection<EnderecoEletronico> enderecosEletronicos;

    @Basic(optional = false)
    @NotNull
    @Column(name = "p_criado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

//    @Basic(optional = false)
////    @NotNull
////    @Column(name = "p_atualizado_em")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dataAtualizacao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "p_atualizado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAt;



    @Basic(optional = false)
    @NotNull
//    @Size(min = 0, max = 200)
    @Column(name = "p_tipo")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public Pessoa() {
        this.telefones = new HashSet<>();
        this.enderecosEletronicos = new HashSet<>();
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
     * @return the cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj the cpfCnpj to set
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return the endereco
     */
    @JsonIgnore
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefones
     */
//    @JsonIgnore
    public Collection<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(Collection<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the enderecosEletronicos
     */
    @JsonIgnore
    public Collection<EnderecoEletronico> getEnderecosEletronicos() {
        return enderecosEletronicos;
    }

    /**
     * @param enderecosEletronicos the enderecosEletronicos to set
     */
    public void setEnderecosEletronicos(Collection<EnderecoEletronico> enderecosEletronicos) {
        this.enderecosEletronicos = enderecosEletronicos;
    }

    /**
     * @return the dataCriacao
     */
    public Date getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the dataAtualizacao
     */
//    public Date getDataAtualizacao() {
//        return dataAtualizacao;
//    }
//
//    /**
//     * @param dataAtualizacao the dataAtualizacao to set
//     */
//    public void setDataAtualizacao(Date dataAtualizacao) {
//        this.dataAtualizacao = dataAtualizacao;
//    }

    /**
     * @return the tipoPessoa
     */
    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * Adiciona um telefone a esta pessoa.
     *
     * @param telefone
     */
    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
        telefone.setPessoa(this);
    }

    /**
     * Remove um telefone desta pessoa.
     *
     * @param telefone
     */
    public void removeTelefone(Telefone telefone) {
        telefones.remove(telefone);
        telefone.setPessoa(null);
    }

    /**
     * Adiciona um endereço eletrônico a esta pessoa.
     *
     * @param enderecoEletronico
     */
    public void addEnderecoEletronico(EnderecoEletronico enderecoEletronico) {
        enderecosEletronicos.add(enderecoEletronico);
        enderecoEletronico.setPessoa(this);
    }

    /**
     * Remove um endereço eletrônico desta pessoa.
     *
     * @param horario
     */
    public void removeEnderecoEletronico(EnderecoEletronico horario) {
        enderecosEletronicos.remove(horario);
        horario.setPessoa(null);
    }

    public Date getDataAt() {
        return dataAt;
    }

    public void setDataAt(Date dataAt) {
        this.dataAt = dataAt;
    }

}
