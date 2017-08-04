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
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer idUsuario;
    private String nomeUsario;
    private String passwordUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nomeUsario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsario = nomeUsario;
        this.passwordUsuario = passwordUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsario() {
        return nomeUsario;
    }

    public void setNomeUsario(String nomeUsario) {
        this.nomeUsario = nomeUsario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nomeUsario=" + nomeUsario + '}';
    }
    
    
    
    
}
