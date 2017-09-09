/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class PeriodoLectivo {
    private Integer idPeriodoLectivo;
    private String periodoLectivo;
    
    public PeriodoLectivo(){}

    public PeriodoLectivo(Integer idPeriodoLectivo, String periodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
        this.periodoLectivo = periodoLectivo;
    }

    public Integer getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(Integer idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public String getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(String periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idPeriodoLectivo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeriodoLectivo other = (PeriodoLectivo) obj;
        if (!Objects.equals(this.idPeriodoLectivo, other.idPeriodoLectivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.periodoLectivo;
    }
    
    
    
}
