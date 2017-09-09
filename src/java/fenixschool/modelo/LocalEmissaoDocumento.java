/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HACKER
 */
public class LocalEmissaoDocumento {
    private int idLocalEmissaoDocumento;
    private String localEmissaoDocumento;

    public LocalEmissaoDocumento() {
    }

    public LocalEmissaoDocumento(int idLocalEmissaoDocumento, String localEmissaoDocumento) {
        this.idLocalEmissaoDocumento = idLocalEmissaoDocumento;
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    public int getIdLocalEmissaoDocumento() {
        return idLocalEmissaoDocumento;
    }
 
    public void setIdLocalEmissaoDocumento(int idLocalEmissaoDocumento) {
        this.idLocalEmissaoDocumento = idLocalEmissaoDocumento;
    }

    public String getLocalEmissaoDocumento() {
        return localEmissaoDocumento;
    }

    public void setLocalEmissaoDocumento(String localEmissaoDocumento) {
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idLocalEmissaoDocumento;
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
        final LocalEmissaoDocumento other = (LocalEmissaoDocumento) obj;
        if (this.idLocalEmissaoDocumento != other.idLocalEmissaoDocumento) {
            return false;
        }
        return true;
    }

    
    
    
    
    @Override
    public String toString() {
        return this.localEmissaoDocumento;
    }

  
    
    
}
