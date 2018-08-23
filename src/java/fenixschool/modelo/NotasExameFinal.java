/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author HACKER
 */
public class NotasExameFinal {
    private int idNota;
    private PeriodoLectivo periodoLetivo;
    private Aluno aluno;
    private Curso curso;
    private Date dataLancamento;
    /*variaveis acrescentada a entidade notas*/
    private double notaExameFinal;
    private double notaExameRecurso;
    private double notaExameEspecial;
    private AnoLectivo anoLetivo;
    private CicloLectivo cicloLetivo;
    private Disciplina disciplina;
    private Turma turma;
    private AnoCurricular anoCurricular;

    public NotasExameFinal() {
    }

    public NotasExameFinal(int idNota, PeriodoLectivo periodoLetivo, Aluno aluno, Curso curso, Date dataLancamento, double notaExameFinal, double notaExameRecurso, double notaExameEspecial, AnoLectivo anoLetivo, CicloLectivo cicloLetivo, Disciplina disciplina, Turma turma, AnoCurricular anoCurricular) {
        this.idNota = idNota;
        this.periodoLetivo = periodoLetivo;
        this.aluno = aluno;
        this.curso = curso;
        this.dataLancamento = dataLancamento;
        this.notaExameFinal = notaExameFinal;
        this.notaExameRecurso = notaExameRecurso;
        this.notaExameEspecial = notaExameEspecial;
        this.anoLetivo = anoLetivo;
        this.cicloLetivo = cicloLetivo;
        this.disciplina = disciplina;
        this.turma = turma;
        this.anoCurricular = anoCurricular;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public PeriodoLectivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(PeriodoLectivo periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getNotaExameFinal() {
        return notaExameFinal;
    }

    public void setNotaExameFinal(double notaExameFinal) {
        this.notaExameFinal = notaExameFinal;
    }

    public double getNotaExameRecurso() {
        return notaExameRecurso;
    }

    public void setNotaExameRecurso(double notaExameRecurso) {
        this.notaExameRecurso = notaExameRecurso;
    }

    public double getNotaExameEspecial() {
        return notaExameEspecial;
    }

    public void setNotaExameEspecial(double notaExameEspecial) {
        this.notaExameEspecial = notaExameEspecial;
    }

    public AnoLectivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLectivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public CicloLectivo getCicloLetivo() {
        return cicloLetivo;
    }

    public void setCicloLetivo(CicloLectivo cicloLetivo) {
        this.cicloLetivo = cicloLetivo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public AnoCurricular getAnoCurricular() {
        return anoCurricular;
    }

    public void setAnoCurricular(AnoCurricular anoCurricular) {
        this.anoCurricular = anoCurricular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idNota;
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
        final NotasExameFinal other = (NotasExameFinal) obj;
        if (this.idNota != other.idNota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotasExameFinal{" + "aluno=" + aluno + '}';
    }
    
    
}
