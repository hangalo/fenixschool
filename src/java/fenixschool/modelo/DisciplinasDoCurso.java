/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.io.Serializable;

/**
 *
 * @author PENA
 */
public class DisciplinasDoCurso {


    private int idCursoDisciplina;
    private Curso curso;
    private Disciplina disciplina;

    public DisciplinasDoCurso() {
    }

    public DisciplinasDoCurso(int idCursoDisciplina, Curso curso, Disciplina disciplina) {
        this.idCursoDisciplina = idCursoDisciplina;
        this.curso = curso;
        this.disciplina = disciplina;
    }

    public int getIdCursoDisciplina() {
        return idCursoDisciplina;
    }

    public void setIdCursoDisciplina(int idCursoDisciplina) {
        this.idCursoDisciplina = idCursoDisciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idCursoDisciplina;
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
        final DisciplinasDoCurso other = (DisciplinasDoCurso) obj;
        if (this.idCursoDisciplina != other.idCursoDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CursoDisciplina{" + "curso=" + curso + '}';
    }
    
    
}
