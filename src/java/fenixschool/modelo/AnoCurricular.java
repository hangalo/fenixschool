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
public class AnoCurricular {
    private int idAnoCurricular;
    private String anoCurricular;
    private CicloLectivo cicloLectivo;

    public AnoCurricular() {
    }

    public AnoCurricular(int idAnoCurricular, String anoCurricular) {
        this.idAnoCurricular = idAnoCurricular;
        this.anoCurricular = anoCurricular;
    }

    public int getIdAnoCurricular() {
        return idAnoCurricular;
    }

    public void setIdAnoCurricular(int idAnoCurricular) {
        this.idAnoCurricular = idAnoCurricular;
    }

    public String getAnoCurricular() {
        return anoCurricular;
    }

    public void setAnoCurricular(String anoCurricular) {
        this.anoCurricular = anoCurricular;
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idAnoCurricular;
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
        final AnoCurricular other = (AnoCurricular) obj;
        if (this.idAnoCurricular != other.idAnoCurricular) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.anoCurricular ;
    }
    
    
    
}
