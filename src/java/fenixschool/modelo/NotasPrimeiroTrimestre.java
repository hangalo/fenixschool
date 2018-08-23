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
public class NotasPrimeiroTrimestre{

    
    private int idNota;
    private PeriodoLectivo periodoLetivo;
    private Aluno aluno;
    private Curso curso;
    private Date dataLancamento;
    /*variaveis acrescentada a entidade notas*/
    private double notaPrimeiraProva;
    private double notaSegundaProva;
    private AnoLectivo anoLetivo;
    private CicloLectivo cicloLetivo;
    private Disciplina disciplina;
    private Turma turma;
    private AnoCurricular anoCurricular;

    public NotasPrimeiroTrimestre() {
    }

    public NotasPrimeiroTrimestre(int idNota, PeriodoLectivo periodoLetivo, Aluno aluno, Curso curso, Date dataLancamento, double notaPrimeiraProva, double notaSegundaProva, AnoLectivo anoLetivo, CicloLectivo cicloLetivo, Disciplina disciplina, Turma turma, AnoCurricular anoCurricular) {
        this.idNota = idNota;
        this.periodoLetivo = periodoLetivo;
        this.aluno = aluno;
        this.curso = curso;
        this.dataLancamento = dataLancamento;
        this.notaPrimeiraProva = notaPrimeiraProva;
        this.notaSegundaProva = notaSegundaProva;
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

    public double getNotaPrimeiraProva() {
        return notaPrimeiraProva;
    }

    public void setNotaPrimeiraProva(double notaPrimeiraProva) {
        this.notaPrimeiraProva = notaPrimeiraProva;
    }

    public double getNotaSegundaProva() {
        return notaSegundaProva;
    }

    public void setNotaSegundaProva(double notaSegundaProva) {
        this.notaSegundaProva = notaSegundaProva;
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
        int hash = 5;
        hash = 83 * hash + this.idNota;
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
        final NotasPrimeiroTrimestre other = (NotasPrimeiroTrimestre) obj;
        if (this.idNota != other.idNota) {
            return false;
        }
        return true;
    }

   
    
    

    @Override
    public String toString() {
        return "NotasTrimestre{" + "idNota=" + idNota + '}';
    }
    
    
}
