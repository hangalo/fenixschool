/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Andar implements Serializable{
    private Integer idAndar;
    private String nomeAndar;

    public Andar() {
    }

    public Andar(Integer idAndar, String nomeAndar) {
        this.idAndar = idAndar;
        this.nomeAndar = nomeAndar;
    }

    public Integer getIdAndar() {
        return idAndar;
    }

    public void setIdAndar(Integer idAndar) {
        this.idAndar = idAndar;
    }

    public String getNomeAndar() {
        return nomeAndar;
    }

    public void setNomeAndar(String nomeAndar) {
        this.nomeAndar = nomeAndar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idAndar);
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
        final Andar other = (Andar) obj;
        if (!Objects.equals(this.idAndar, other.idAndar)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeAndar;
    }
    
    
    
    
}
