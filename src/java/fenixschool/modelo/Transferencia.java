/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idTransferencia;
    private Date dataTransferencia;
    private String textoTransferencia;
    private Aluno aluno;
    private Funcionario funcionario;
    private SituacaoTransferencia situacaoTransferencia;
    private String observacoes;

    public Transferencia() {
    }

    public Transferencia(Integer idTransferencia, Date dataTransferencia, String textoTransferencia, Aluno aluno, Funcionario funcionario, SituacaoTransferencia situacaoTransferencia, String observacoes) {
        this.idTransferencia = idTransferencia;
        this.dataTransferencia = dataTransferencia;
        this.textoTransferencia = textoTransferencia;
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.situacaoTransferencia = situacaoTransferencia;
        this.observacoes = observacoes;
    }

    public Integer getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public String getTextoTransferencia() {
        return textoTransferencia;
    }

    public void setTextoTransferencia(String textoTransferencia) {
        this.textoTransferencia = textoTransferencia;
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

    public SituacaoTransferencia getSituacaoTransferencia() {
        return situacaoTransferencia;
    }

    public void setSituacaoTransferencia(SituacaoTransferencia situacaoTransferencia) {
        this.situacaoTransferencia = situacaoTransferencia;
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
        hash = 61 * hash + Objects.hashCode(this.idTransferencia);
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
        final Transferencia other = (Transferencia) obj;
        if (!Objects.equals(this.idTransferencia, other.idTransferencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", aluno=" + aluno + '}';
    }

}
