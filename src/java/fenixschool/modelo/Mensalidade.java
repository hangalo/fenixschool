/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class Mensalidade {
    private Integer idMensalidade;
    private String descricaoMensalidade;
    private Date dataPagamento;
    private double valorPago;
    private double valorMulta;
    private String observacaoMensalidade;
    private Double descontoMensalidade;
    private AnoLectivo anoLetivo;
    private Departamento departamento;
    private Turma turma;
    private CicloLectivo cicloLectivo;
    private Mes mes;
    private Aluno aluno;
    private Curso curso;

    public Mensalidade() {
    }

    public Mensalidade(Integer idMensalidade, String descricaoMensalidade, Date dataPagamento, double valorPago, double valorMulta, String observacaoMensalidade, Double descontoMensalidade, AnoLectivo anoLetivo, Departamento departamento, Turma turma, CicloLectivo cicloLectivo, Mes mes, Aluno aluno, Curso curso) {
        this.idMensalidade = idMensalidade;
        this.descricaoMensalidade = descricaoMensalidade;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.valorMulta = valorMulta;
        this.observacaoMensalidade = observacaoMensalidade;
        this.descontoMensalidade = descontoMensalidade;
        this.anoLetivo = anoLetivo;
        this.departamento = departamento;
        this.turma = turma;
        this.cicloLectivo = cicloLectivo;
        this.mes = mes;
        this.aluno = aluno;
        this.curso = curso;
    }

    public Integer getIdMensalidade() {
        return idMensalidade;
    }

    public void setIdMensalidade(Integer idMensalidade) {
        this.idMensalidade = idMensalidade;
    }

    public String getDescricaoMensalidade() {
        return descricaoMensalidade;
    }

    public void setDescricaoMensalidade(String descricaoMensalidade) {
        this.descricaoMensalidade = descricaoMensalidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String getObservacaoMensalidade() {
        return observacaoMensalidade;
    }

    public void setObservacaoMensalidade(String observacaoMensalidade) {
        this.observacaoMensalidade = observacaoMensalidade;
    }

    public Double getDescontoMensalidade() {
        return descontoMensalidade;
    }

    public void setDescontoMensalidade(Double descontoMensalidade) {
        this.descontoMensalidade = descontoMensalidade;
    }

    public AnoLectivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLectivo anoLetivo) {
        this.anoLetivo = anoLetivo;
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

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idMensalidade);
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
        final Mensalidade other = (Mensalidade) obj;
        if (!Objects.equals(this.idMensalidade, other.idMensalidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensalidade{" + "idMensalidade=" + idMensalidade + ", descricaoMensalidade=" + descricaoMensalidade + ", dataPagamento=" + dataPagamento + ", valorPago=" + valorPago + ", valorMulta=" + valorMulta + ", observacaoMensalidade=" + observacaoMensalidade + ", descontoMensalidade=" + descontoMensalidade + ", anoLetivo=" + anoLetivo + ", departamento=" + departamento + ", turma=" + turma + ", cicloLectivo=" + cicloLectivo + ", mes=" + mes + ", aluno=" + aluno + ", curso=" + curso + '}';
    }

    
    
    
           
    
    
}
