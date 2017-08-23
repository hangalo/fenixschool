/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author PENA
 */
public class BoletimNotas {
    
    private int idBoletimNotas;
    private Date dataBoletimNotas;
    private Aluno aluno;

    public BoletimNotas() {
    }

    public BoletimNotas(int idBoletimNotas, Date dataBoletimNotas, Aluno aluno) {
        this.idBoletimNotas = idBoletimNotas;
        this.dataBoletimNotas = dataBoletimNotas;
        this.aluno = aluno;
    }

    

    public int getIdBoletimNotas() {
        return idBoletimNotas;
    }

    public void setIdBoletimNotas(int idBoletimNotas) {
        this.idBoletimNotas = idBoletimNotas;
    }

    public Date getDataBoletimNotas() {
        return dataBoletimNotas;
    }

    public void setDataBoletimNotas(Date dataBoletimNotas) {
        this.dataBoletimNotas = dataBoletimNotas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idBoletimNotas;
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
        final BoletimNotas other = (BoletimNotas) obj;
        if (this.idBoletimNotas != other.idBoletimNotas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BoletimNotas{" + "data_boletin_notas=" + dataBoletimNotas + '}';
    }
    
    
}
