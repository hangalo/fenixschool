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
public class Mes{
    private Integer idMes;
    private String nomeMes;

    public Mes() {
    }

    public Mes(Integer idMes, String nomeMes) {
        this.idMes = idMes;
        this.nomeMes = nomeMes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idMes);
        hash = 67 * hash + Objects.hashCode(this.nomeMes);
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
        final Mes other = (Mes) obj;
        if (!Objects.equals(this.nomeMes, other.nomeMes)) {
            return false;
        }
        if (!Objects.equals(this.idMes, other.idMes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mes{" + "idMes=" + idMes + ", nomeMes=" + nomeMes + '}';
    }

    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    public String getNomeMes() {
        return nomeMes;
    }

    public void setNomeMes(String nomeMes) {
        this.nomeMes = nomeMes;
    }
    
    
}