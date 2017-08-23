/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author kulley
 */


public class ObjetivoDeclaracao {
    
    int idObjetivoDeclaracao;
    String ObjectivoDeclaracao;

    public ObjetivoDeclaracao() {
    }

    public ObjetivoDeclaracao(int idObjetivoDeclaracao, String ObjectivoDeclaracao) {
        this.idObjetivoDeclaracao = idObjetivoDeclaracao;
        this.ObjectivoDeclaracao = ObjectivoDeclaracao;
    }

    public int getIdObjetivoDeclaracao() {
        return idObjetivoDeclaracao;
    }

    public void setIdObjetivoDeclaracao(int idObjetivoDeclaracao) {
        this.idObjetivoDeclaracao = idObjetivoDeclaracao;
    }

    public String getObjectivoDeclaracao() {
        return ObjectivoDeclaracao;
    }

    public void setObjectivoDeclaracao(String ObjectivoDeclaracao) {
        this.ObjectivoDeclaracao = ObjectivoDeclaracao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idObjetivoDeclaracao;
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
        final ObjetivoDeclaracao other = (ObjetivoDeclaracao) obj;
        if (this.idObjetivoDeclaracao != other.idObjetivoDeclaracao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObjetivoDeclaracao{" + "ObjectivoDeclaracao=" + ObjectivoDeclaracao + '}';
    }
    
    
    
}
