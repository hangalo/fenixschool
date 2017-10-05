/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author Aisha Lubadika
 */
public class Turma {
private int idTurma;
private String nomeTurma;
private AnoLectivo anoLectivo;
private PeriodoLectivo periodoLectivo;
private int numeroMaximoInscritos;

    public Turma() {
    }

    public Turma(int idTurma, String nomeTurma, AnoLectivo anoLectivo, PeriodoLectivo periodoLectivo, int numeroMaximoInscritos) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.anoLectivo = anoLectivo;
        this.periodoLectivo = periodoLectivo;
        this.numeroMaximoInscritos = numeroMaximoInscritos;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public int getNumeroMaximoInscritos() {
        return numeroMaximoInscritos;
    }

    public void setNumeroMaximoInscritos(int numeroMaximoInscritos) {
        this.numeroMaximoInscritos = numeroMaximoInscritos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idTurma;
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
        if (this.idTurma != other.idTurma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeTurma;
    }
    

    


   
}

