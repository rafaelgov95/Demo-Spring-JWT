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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Kleber Kruger
 * @author Rafael Viana
 */
@Entity
@Table(name = "tb_rati")
public class Rati extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long id;

    @Column(name = "p_nome")
    @NotNull
    private String nome;

    @Column(name = "p_cpf")
    @NotNull
    private String cpf;

    @Column(name = "p_tipo")
    @NotNull
    @Size(max = 255)
    private String tipo;

    @Column(name = "p_email")
    @NotNull
    private String email;

    @Column(name = "r_titulo")
    @NotNull
    @Size(max = 255)
    private String titulo;

    @Column(name = "r_prioridade")
    @NotNull
    private String prioridade;

    @Column(name = "r_mensagem")
    @NotNull
    private String mensagem;

    @Column(name = "r_nome_ti")
    private String nome_ti;

    @Column(name = "r_resposta")
    private String resposta;

    @Column(name = "r_resposta_data_at")
    private String resposta_data_at;

    @Column(name = "r_data_at")
    @NotNull
    private String data_at;


    @Column(name = "r_situacao")
    @NotNull
    private String situacao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome_ti() {
        return nome_ti;
    }

    public void setNome_ti(String nome_ti) {
        this.nome_ti = nome_ti;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta_data_at() {
            return resposta_data_at;
    }

    public void setResposta_data_at(String resposta_data_at) {
        this.resposta_data_at = resposta_data_at;
    }

    public String getData_at() {
        return data_at;
    }

    public void setData_at(String data_at) {
        this.data_at = data_at;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
