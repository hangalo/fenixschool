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
public class CicloLectivo {

    private Integer idCicloLectivo;
    private String CicloLectivo;

    public CicloLectivo() {
    }

    public CicloLectivo(Integer idCicloLectivo, String CicloLectivo) {
        this.idCicloLectivo = idCicloLectivo;
        this.CicloLectivo = CicloLectivo;
    }

    public Integer getIdCicloLectivo() {
        return idCicloLectivo;
    }

    public void setIdCicloLectivo(Integer idCicloLectivo) {
        this.idCicloLectivo = idCicloLectivo;
    }

    public String getCicloLectivo() {
        return CicloLectivo;
    }

    public void setCicloLectivo(String CicloLectivo) {
        this.CicloLectivo = CicloLectivo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idCicloLectivo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CicloLectivo other = (CicloLectivo) obj;
        if (!Objects.equals(this.idCicloLectivo, other.idCicloLectivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CicloLectivo{" + "CicloLectivo=" + CicloLectivo + '}';
    }

        
}
