/*
 * Copyright (C) 2017 Kleber Kruger
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
package br.ufms.estagio.domain.enumerate;

/**
 * @author Kleber Kruger
 */
public enum GrauAcademico {

    GRADUACAO, ESPECIALIZACAO, MESTRADO, DOUTORADO, POS_DOUTORADO;

    @Override
    public String toString() {
        switch (this) {
            case GRADUACAO:
                return "Graduação";
            case ESPECIALIZACAO:
                return "Especialização";
            case MESTRADO:
                return "Mestrado";
            case DOUTORADO:
                return "Doutorado";
            case POS_DOUTORADO:
                return "Pós-Doutorado";
        }
        return super.toString();
    }

}
