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
public class Nota {
    
    private int idNota;
    private PeriodoLectivo periodoLectivo;
    private Aluno aluno;
    private Curso curso;
    private Disciplina disciplina;
    private String descricao;
    private Date dataLancamento;
    private double nota;
    private double peso;
    private AnoLectivo anoLectivo;
    private CicloLectivo cicloLectivo;
    private ClassificacaoNota classificacaoNota;
    private Departamento departamento;
    private Turma turma;
    private AnoCurricular anoCurricular;
    private String observacao;

    public Nota() {
    }

    public Nota(int idNota, PeriodoLectivo periodoLectivo, Aluno aluno, Curso curso, Disciplina disciplina, String descricao, Date dataLancamento, double nota, double peso, AnoLectivo anoLectivo, CicloLectivo cicloLectivo, ClassificacaoNota classificacaoNota, Departamento departamento, Turma turma, AnoCurricular anoCurricular, String observacao) {
        this.idNota = idNota;
        this.periodoLectivo = periodoLectivo;
        this.aluno = aluno;
        this.curso = curso;
        this.disciplina = disciplina;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.nota = nota;
        this.peso = peso;
        this.anoLectivo = anoLectivo;
        this.cicloLectivo = cicloLectivo;
        this.classificacaoNota = classificacaoNota;
        this.departamento = departamento;
        this.turma = turma;
        this.anoCurricular = anoCurricular;
        this.observacao = observacao;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public ClassificacaoNota getClassificacaoNota() {
        return classificacaoNota;
    }

    public void setClassificacaoNota(ClassificacaoNota classificacaoNota) {
        this.classificacaoNota = classificacaoNota;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idNota;
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
        final Nota other = (Nota) obj;
        if (this.idNota != other.idNota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "descricao=" + descricao + '}';
    }
    
    
}
