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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade Municipio.
 * 
 * @author Kleber Kruger
 */
@Entity
@Table(name = "tb_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT t FROM Municipio t")
    , @NamedQuery(name = "Municipio.findByCodigo", query = "SELECT t FROM Municipio t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Municipio.findByNome", query = "SELECT t FROM Municipio t WHERE t.nome = :nome")
    , @NamedQuery(name = "Municipio.findByUf", query = "SELECT t FROM Municipio t WHERE t.uf = :uf")})
public class Municipio extends GenericEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mun_codigo_ibge")
    private Integer codigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mun_nome")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "mun_uf")
    private String uf;

    /**
     * @return the codigo
     */
    @Override
    public Integer getId() {
        return getCodigo();
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[codigoIBGE=" + getCodigo() + "]";
    }
    
}
