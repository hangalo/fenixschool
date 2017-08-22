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
    
    private int id_boletin_notas;
    private Date data_boletin_notas;
    private Aluno aluno;

    public BoletimNotas() {
    }

    public BoletimNotas(int id_boletin_notas, Date data_boletin_notas, Aluno aluno) {
        this.id_boletin_notas = id_boletin_notas;
        this.data_boletin_notas = data_boletin_notas;
        this.aluno = aluno;
    }

    public int getId_boletin_notas() {
        return id_boletin_notas;
    }

    public void setId_boletin_notas(int id_boletin_notas) {
        this.id_boletin_notas = id_boletin_notas;
    }

    public Date getData_boletin_notas() {
        return data_boletin_notas;
    }

    public void setData_boletin_notas(Date data_boletin_notas) {
        this.data_boletin_notas = data_boletin_notas;
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
        hash = 37 * hash + this.id_boletin_notas;
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
        if (this.id_boletin_notas != other.id_boletin_notas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BoletimNotas{" + "data_boletin_notas=" + data_boletin_notas + '}';
    }
    
    
}
