/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HP
 */
public class ClassificacaoNota {
    int idClassificacaoNota;
    String classificacaoNota;

    public ClassificacaoNota() {
    }

    public ClassificacaoNota(int idClassificacaoNota, String classificacaoNota) {
        this.idClassificacaoNota = idClassificacaoNota;
        this.classificacaoNota = classificacaoNota;
    }

    public int getIdClassificacaoNota() {
        return idClassificacaoNota;
    }

    public void setIdClassificacaoNota(int idClassificacaoNota) {
        this.idClassificacaoNota = idClassificacaoNota;
    }

    public String getClassificacaoNota() {
        return classificacaoNota;
    }

    public void setClassificacaoNota(String classificacaoNota) {
        this.classificacaoNota = classificacaoNota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idClassificacaoNota;
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
        final ClassificacaoNota other = (ClassificacaoNota) obj;
        if (this.idClassificacaoNota != other.idClassificacaoNota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassificacaoNota{" + "classificacaoNota=" + classificacaoNota + '}';
    }
    
    
}
