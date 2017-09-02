/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Turma {
    private Integer idTurma;
    private String nomeTurma;
    
    private AnoLectivo idAnoLetivo;
    private PeriodoLectivo idPeriodoLetivo;
    
    private Integer numeroMaximoInscritos;
    
    public Turma(){}

    public Turma(Integer idTurma, String nomeTurma, AnoLectivo idAnoLetivo, PeriodoLectivo idPeriodoLetivo, Integer numeroMaximoInscritos) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.idAnoLetivo = idAnoLetivo;
        this.idPeriodoLetivo = idPeriodoLetivo;
        this.numeroMaximoInscritos = numeroMaximoInscritos;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public AnoLectivo getIdAnoLetivo() {
        return idAnoLetivo;
    }

    public void setIdAnoLetivo(AnoLectivo idAnoLetivo) {
        this.idAnoLetivo = idAnoLetivo;
    }

    public PeriodoLectivo getIdPeriodoLetivo() {
        return idPeriodoLetivo;
    }

    public void setIdPeriodoLetivo(PeriodoLectivo idPeriodoLetivo) {
        this.idPeriodoLetivo = idPeriodoLetivo;
    }

    public Integer getNumeroMaximoInscritos() {
        return numeroMaximoInscritos;
    }

    public void setNumeroMaximoInscritos(Integer numeroMaximoInscritos) {
        this.numeroMaximoInscritos = numeroMaximoInscritos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idTurma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.idTurma, other.idTurma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){ 
        return this.nomeTurma;
    
    }  
   
}

