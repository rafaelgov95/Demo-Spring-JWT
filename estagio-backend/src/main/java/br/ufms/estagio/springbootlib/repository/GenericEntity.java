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
package br.ufms.estagio.springbootlib.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe base para qualquer objeto serializável.
 *
 * @author Kleber Kruger
 * @author Rafael Viana
 * @param <T> o tipo do atributo id
 */
//@MappedSuperclass

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class GenericEntity<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return o id
     */

    public abstract T getId();

    /**
     * Indica quando outro objeto é igual a este. Nesta implementação, qualquer objeto derivado de
     * GenericEntity é igual a este desde que seja exatamente da mesma classe e tenha o mesmo ID.
     * Caso precise de outra lógica, sobrescreva este método.
     *
     * @param obj o objeto a comparar com este
     * @return {@code true} se este objeto é igual ao do argumento; {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (getId() != null && obj instanceof GenericEntity) {
            GenericEntity x = (GenericEntity) obj;
            return getClass() == x.getClass() && getId().equals(x.getId());
        }
        return super.equals(obj);
    }

    /**
     * Retorna um valor de hash code para este objeto. Nesta implementação, este valor é gerado por
     * uma combinação do hash code da classe (getClass().hashCode()) somado ao hash code do atributo
     * id (id.hashCode()).
     *
     * Classes semelhantes terão o mesmo valor base de hash code, que quando somado ao hash code do
     * id, terá o valor: valorBaseHashCodeClasse + idHashCode. Por exemplo, se o valor base do hash
     * code da classe {@code Cachorro} é 300 e o objeto {@code Cachorro c1} tem o id = 1, o retorno
     * deste método será 301.
     *
     * @return um valor de hash code para este objeto
     */
    @Override
    public int hashCode() {
        if (getId() != null) {
            return 43 * 7 + Objects.hashCode(getClass().hashCode() + getId().hashCode());
        }
        return super.hashCode();
    }

//    @Override
//    public String toString() {
//        return getClass().getName() + "[id=" + getId() + "]";
//    }

}
