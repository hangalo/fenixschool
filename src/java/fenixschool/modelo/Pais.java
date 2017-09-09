/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Pais {
    private String codigoISOAlpha2Pais;
    private String codigoISOAlph3Pais;
    private String nomePais;

    public Pais() {
    }

    public String getCodigoISOAlpha2Pais() {
        return codigoISOAlpha2Pais;
    }

    public void setCodigoISOAlpha2Pais(String codigoISOAlpha2Pais) {
        this.codigoISOAlpha2Pais = codigoISOAlpha2Pais;
    }

    public String getCodigoISOAlph3Pais() {
        return codigoISOAlph3Pais;
    }

    public void setCodigoISOAlph3Pais(String codigoISOAlph3Pais) {
        this.codigoISOAlph3Pais = codigoISOAlph3Pais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoISOAlpha2Pais);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.codigoISOAlpha2Pais, other.codigoISOAlpha2Pais)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "nomePais=" + nomePais + '}';
    }

   
    
    
}
