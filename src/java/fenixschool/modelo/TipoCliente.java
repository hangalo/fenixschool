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
public class TipoCliente {
    
    private Integer idTipoCliente;
    private String nomeTipoCliente;

    public TipoCliente() {
    }

    public TipoCliente(Integer idTipoCliente, String nomeTipoCliente) {
        this.idTipoCliente = idTipoCliente;
        this.nomeTipoCliente = nomeTipoCliente;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNomeTipoCliente() {
        return nomeTipoCliente;
    }

    public void setNomeTipoCliente(String nomeTipoCliente) {
        this.nomeTipoCliente = nomeTipoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idTipoCliente);
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
        final TipoCliente other = (TipoCliente) obj;
        if (!Objects.equals(this.idTipoCliente, other.idTipoCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCliente{" + "nomeTipoCliente=" + nomeTipoCliente + '}';
    }
  
    
    
}
