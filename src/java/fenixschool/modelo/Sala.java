/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable{
    private Integer idSala;
    private String nomeSala;
    private String localizacaoSala;
    private Andar andar;

    public Sala() {
    }

    public Sala(Integer idSala, String nomeSala, String localizacaoSala, Andar andar) {
        this.idSala = idSala;
        this.nomeSala = nomeSala;
        this.localizacaoSala = localizacaoSala;
        this.andar = andar;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getLocalizacaoSala() {
        return localizacaoSala;
    }

    public void setLocalizacaoSala(String localizacaoSala) {
        this.localizacaoSala = localizacaoSala;
    }

    public Andar getAndar() {
        return andar;
    }

    public void setAndar(Andar andar) {
        this.andar = andar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idSala);
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.idSala, other.idSala)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeSala ;
    }
    
    
    
    
}
