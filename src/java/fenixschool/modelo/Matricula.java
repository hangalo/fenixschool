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
 * @author HACKER
 */
public class Matricula implements Serializable{
    private int idMatricula;
    private Date dataMatricula;
    private Aluno aluno;
    private Funcionario funcionario;
    private Curso curso;
    private AnoLectivo anoLetivo;
    private boolean estadoMatricula;
    private Turma turma;
    private TipoDocumentoIdentidade tipoDocumentoIdentidade;
    private Date dataEmissaoDocumento;
    private LocalEmissaoDocumento localEmissaoDocumento;
    private String numeroDocumento;
    private CicloLectivo cicloLectivo;
    private AnoCurricular anoCurricular;
    private Lingua linguaOpcao;
    private Lingua linguaEstudada;
    private SituacaoAlunoMatricula situacaoAlunoMatricula;
    private String observacao;

    public Matricula() {
    }

    public Matricula(int idMatricula, Date dataMatricula, Aluno aluno, Funcionario funcionario, Curso curso, AnoLectivo anoLetivo, boolean estadoMatricula, Turma turma, TipoDocumentoIdentidade tipoDocumentoIdentidade, Date dataEmissaoDocumento, LocalEmissaoDocumento localEmissaoDocumento, String numeroDocumento, CicloLectivo cicloLectivo, AnoCurricular anoCurricular, Lingua lingua, SituacaoAlunoMatricula situacaoAlunoMatricula, String observacao) {
        this.idMatricula = idMatricula;
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.curso = curso;
        this.anoLetivo = anoLetivo;
        this.estadoMatricula = estadoMatricula;
        this.turma = turma;
        this.tipoDocumentoIdentidade = tipoDocumentoIdentidade;
        this.dataEmissaoDocumento = dataEmissaoDocumento;
        this.localEmissaoDocumento = localEmissaoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.cicloLectivo = cicloLectivo;
        this.anoCurricular = anoCurricular;
        this.linguaOpcao = lingua;
        this.situacaoAlunoMatricula = situacaoAlunoMatricula;
        this.observacao = observacao;
    }

   

   

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public AnoLectivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLectivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public boolean isEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(boolean estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

   

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public TipoDocumentoIdentidade getTipoDocumentoIdentidade() {
        return tipoDocumentoIdentidade;
    }

    public void setTipoDocumentoIdentidade(TipoDocumentoIdentidade tipoDocumentoIdentidade) {
        this.tipoDocumentoIdentidade = tipoDocumentoIdentidade;
    }

    public Date getDataEmissaoDocumento() {
        return dataEmissaoDocumento;
    }

    public void setDataEmissaoDocumento(Date dataEmissaoDocumento) {
        this.dataEmissaoDocumento = dataEmissaoDocumento;
    }

    public LocalEmissaoDocumento getLocalEmissaoDocumento() {
        return localEmissaoDocumento;
    }

    public void setLocalEmissaoDocumento(LocalEmissaoDocumento localEmissaoDocumento) {
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
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

    public Lingua getLinguaOpcao() {
        return linguaOpcao;
    }

    public void setLinguaOpcao(Lingua linguaOpcao) {
        this.linguaOpcao = linguaOpcao;
    }

   
    public SituacaoAlunoMatricula getSituacaoAlunoMatricula() {
        return situacaoAlunoMatricula;
    }

    public void setSituacaoAlunoMatricula(SituacaoAlunoMatricula situacaoAlunoMatricula) {
        this.situacaoAlunoMatricula = situacaoAlunoMatricula;
    }

    public Lingua getLinguaEstudada() {
        return linguaEstudada;
    }

    public void setLinguaEstudada(Lingua linguaEstudada) {
        this.linguaEstudada = linguaEstudada;
    }

    
    
    @Override
    public String toString() {
        return "Matricula{" + "aluno=" + aluno + '}';
    }
   
}
