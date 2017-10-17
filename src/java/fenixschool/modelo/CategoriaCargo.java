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
public class CategoriaCargo implements Serializable{
   private Integer idCategoriaCargo;
   private String categoriaCargo;
   
   
   
   

    public CategoriaCargo() {
    }
    
    
     public CategoriaCargo(Integer idCategoriaCargo, String categoriaCargo) {
        this.idCategoriaCargo = idCategoriaCargo;
        this.categoriaCargo = categoriaCargo;
    }

    public Integer getIdCategoriaCargo() {
        return idCategoriaCargo;
    }

    public void setIdCategoriaCargo(Integer idCategoriaCargo) {
        this.idCategoriaCargo = idCategoriaCargo;
    }

    public String getCategoriaCargo() {
        return categoriaCargo;
    }

    public void setCategoriaCargo(String categoriaCargo) {
        this.categoriaCargo = categoriaCargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idCategoriaCargo);
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
        final CategoriaCargo other = (CategoriaCargo) obj;
        if (!Objects.equals(this.idCategoriaCargo, other.idCategoriaCargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaCargo{" + "categoriaCargo=" + categoriaCargo + '}';
    }
   
    
    
}
