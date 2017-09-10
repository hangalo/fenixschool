/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author informatica
 */
public class Docencia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int idDocencia;
    private Professor professor;
    private Disciplina disciplina;
    private AnoLectivo anoLectivo;
    private Date dataIncio;
    private Date dataFim;
    private String observacoes;

    public Docencia() {
    }

    public Docencia(int idDocencia, Professor professor, Disciplina disciplina, AnoLectivo anoLectivo, Date dataIncio, Date dataFim, String observacoes) {
        this.idDocencia = idDocencia;
        this.professor = professor;
        this.disciplina = disciplina;
        this.anoLectivo = anoLectivo;
        this.dataIncio = dataIncio;
        this.dataFim = dataFim;
        this.observacoes = observacoes;
    }

   

    public int getIdDocencia() {
        return idDocencia;
    }

    public void setIdDocencia(int idDocencia) {
        this.idDocencia = idDocencia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public Date getDataIncio() {
        return dataIncio;
    }

    public void setDataIncio(Date dataIncio) {
        this.dataIncio = dataIncio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idDocencia;
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
        final Docencia other = (Docencia) obj;
        if (this.idDocencia != other.idDocencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.professor + ", " + this.disciplina + '}';
    }
    
    
}
