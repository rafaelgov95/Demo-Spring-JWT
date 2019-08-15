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
 * Classe que mapeia a entidade Telefone.
 *
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")
    , @NamedQuery(name = "Telefone.findById", query = "SELECT t FROM Telefone t WHERE t.id = :id")
    , @NamedQuery(name = "Telefone.findByNumero", query = "SELECT t FROM Telefone t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefone.findByRamal", query = "SELECT t FROM Telefone t WHERE t.ramal = :ramal")
    , @NamedQuery(name = "Telefone.findByUso", query = "SELECT t FROM Telefone t WHERE t.uso = :uso")
    , @NamedQuery(name = "Telefone.findByContato", query = "SELECT t FROM Telefone t WHERE t.contato = :contato")
    , @NamedQuery(name = "Telefone.findByOperadora", query = "SELECT t FROM Telefone t WHERE t.operadora = :operadora")
    , @NamedQuery(name = "Telefone.findByMensageiro", query = "SELECT t FROM Telefone t WHERE t.mensageiro = :mensageiro")
    , @NamedQuery(name = "Telefone.findByPrioridade", query = "SELECT t FROM Telefone t WHERE t.prioridade = :prioridade")})
public class Telefone extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tel_id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tel_numero")
    private String numero;

    @Size(max = 5)
    @Column(name = "tel_ramal")
    private String ramal;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tel_uso")
    private String uso;

    @Size(max = 255)
    @Column(name = "tel_contato")
    private String contato;

    @Size(max = 32)
    @Column(name = "tel_operadora")
    private String operadora;

    @Column(name = "tel_mensageiro")
    private Boolean mensageiro;

    @Column(name = "tel_prioridade")
    private Short prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Pessoa pessoa;

    /**
     *
     */
    public Telefone() {
    }

    /**
     *
     * @param id
     */
    public Telefone(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param numero
     * @param uso
     */
    public Telefone(Long id, String numero, String uso) {
        this.id = id;
        this.numero = numero;
        this.uso = uso;
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the ramal
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * @param ramal the ramal to set
     */
    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    /**
     * @return the uso
     */
    public String getUso() {
        return uso;
    }

    /**
     * @param uso the uso to set
     */
    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the operadora
     */
    public String getOperadora() {
        return operadora;
    }

    /**
     * @param operadora the operadora to set
     */
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    /**
     * @return the mensageiro
     */
    public Boolean getMensageiro() {
        return mensageiro;
    }

    /**
     * @param mensageiro the mensageiro to set
     */
    public void setMensageiro(Boolean mensageiro) {
        this.mensageiro = mensageiro;
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
