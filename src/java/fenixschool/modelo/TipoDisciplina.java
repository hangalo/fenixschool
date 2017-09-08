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
public class TipoDisciplina {
    private Integer idTipoDisciplina;
    private String tipoDisciplina;
    
    public TipoDisciplina(){}

    public TipoDisciplina(Integer idTipoDisciplina, String tipoDisciplina) {
        this.idTipoDisciplina = idTipoDisciplina;
        this.tipoDisciplina = tipoDisciplina;
    }

    public Integer getIdTipoDisciplina() {
        return idTipoDisciplina;
    }

    public void setIdTipoDisciplina(Integer idTipoDisciplina) {
        this.idTipoDisciplina = idTipoDisciplina;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(String tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    @Override
    public String toString() {
        return "TipoDisciplina{" + "idTipoDisciplina=" + idTipoDisciplina + ", tipoDisciplina=" + tipoDisciplina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idTipoDisciplina);
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
        final TipoDisciplina other = (TipoDisciplina) obj;
        if (!Objects.equals(this.idTipoDisciplina, other.idTipoDisciplina)) {
            return false;
        }
        return true;
    }

    
    
    
}
