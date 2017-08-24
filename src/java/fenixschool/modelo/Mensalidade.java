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
    private double valorJuro;
    private String observacaoMensalidade;
    private AnoLectivo anoLetivo;
    private Departamento departamento;
    private Turma turma;
    private CicloLectivo cicloLectivo;
    private Mes mes;
    private Aluno aluno;
    private Curso curso;

    public Mensalidade() {
    }

    public Mensalidade(Integer idMensalidade, String descricaoMensalidade, Date dataPagamento, double valorPago, double valorJuro, String observacaoMensalidade, AnoLectivo anoLetivo, Departamento departamento, Turma turma, CicloLectivo cicloLectivo, Mes mes, Aluno aluno, Curso curso) {
        this.idMensalidade = idMensalidade;
        this.descricaoMensalidade = descricaoMensalidade;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.valorJuro = valorJuro;
        this.observacaoMensalidade = observacaoMensalidade;
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

    public double getValorJuro() {
        return valorJuro;
    }

    public void setValorJuro(double valorJuro) {
        this.valorJuro = valorJuro;
    }

    public String getObservacaoMensalidade() {
        return observacaoMensalidade;
    }

    public void setObservacaoMensalidade(String observacaoMensalidade) {
        this.observacaoMensalidade = observacaoMensalidade;
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
    public String toString() {
        return "Mensalidade{" + "idMensalidade=" + idMensalidade + ", descricaoMensalidade=" + descricaoMensalidade + ", dataPagamento=" + dataPagamento + ", valorPago=" + valorPago + ", valorJuro=" + valorJuro + ", observacaoMensalidade=" + observacaoMensalidade + ", anoLetivo=" + anoLetivo + ", departamento=" + departamento + ", turma=" + turma + ", cicloLectivo=" + cicloLectivo + ", mes=" + mes + ", aluno=" + aluno + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idMensalidade);
        hash = 47 * hash + Objects.hashCode(this.descricaoMensalidade);
        hash = 47 * hash + Objects.hashCode(this.dataPagamento);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorPago) ^ (Double.doubleToLongBits(this.valorPago) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorJuro) ^ (Double.doubleToLongBits(this.valorJuro) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.observacaoMensalidade);
        hash = 47 * hash + Objects.hashCode(this.anoLetivo);
        hash = 47 * hash + Objects.hashCode(this.departamento);
        hash = 47 * hash + Objects.hashCode(this.turma);
        hash = 47 * hash + Objects.hashCode(this.cicloLectivo);
        hash = 47 * hash + Objects.hashCode(this.mes);
        hash = 47 * hash + Objects.hashCode(this.aluno);
        hash = 47 * hash + Objects.hashCode(this.curso);
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
        if (Double.doubleToLongBits(this.valorPago) != Double.doubleToLongBits(other.valorPago)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorJuro) != Double.doubleToLongBits(other.valorJuro)) {
            return false;
        }
        if (!Objects.equals(this.descricaoMensalidade, other.descricaoMensalidade)) {
            return false;
        }
        if (!Objects.equals(this.observacaoMensalidade, other.observacaoMensalidade)) {
            return false;
        }
        if (!Objects.equals(this.idMensalidade, other.idMensalidade)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.anoLetivo, other.anoLetivo)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        if (!Objects.equals(this.cicloLectivo, other.cicloLectivo)) {
            return false;
        }
        if (!Objects.equals(this.mes, other.mes)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    
    

    
    
           
    
    
}
