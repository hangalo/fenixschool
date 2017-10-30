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
 * @author PENA
 */
public class Parentesco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idParentesco;
    private String parentesco;

    public Parentesco() {
    }

    public Parentesco(Integer idParentesco, String parentesco) {
        this.idParentesco = idParentesco;
        this.parentesco = parentesco;
    }

    public Integer getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Integer idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idParentesco);
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
        final Parentesco other = (Parentesco) obj;
        if (!Objects.equals(this.idParentesco, other.idParentesco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parentesco{" + "parentesco=" + parentesco + '}';
    }
    
    
}
