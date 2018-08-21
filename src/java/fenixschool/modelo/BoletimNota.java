/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.time.LocalDate;

/**
 *
 * @author PENA
 */
public class BoletimNota {
    
    private int idBoletim;
    private LocalDate dataBoletim;
    private Aluno aluno;

    public BoletimNota() {
    }

    public BoletimNota(int idBoletim, LocalDate dataBoletim, Aluno aluno) {
        this.idBoletim = idBoletim;
        this.dataBoletim = dataBoletim;
        this.aluno = aluno;
    }

    public int getIdBoletim() {
        return idBoletim;
    }

    public void setIdBoletim(int idBoletim) {
        this.idBoletim = idBoletim;
    }

    public LocalDate getDataBoletim() {
        return dataBoletim;
    }

    public void setDataBoletim(LocalDate dataBoletim) {
        this.dataBoletim = dataBoletim;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idBoletim;
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
        final BoletimNota other = (BoletimNota) obj;
        if (this.idBoletim != other.idBoletim) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BoletimNota{" + "dataBoletim=" + dataBoletim + '}';
    }

 
    
}
