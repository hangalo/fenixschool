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
 * @author PENA
 */
public class AlunoEncarregadoEducacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAlunoEncarregado;
    private EncarregadoEducacao encarregado;
    private Aluno aluno;
    private Parentesco parentesco;
    private Date inicioResponsabilidade;
    private Date fimResponsabilidade;
    private String observacoes;

    public AlunoEncarregadoEducacao() {
    }

    public AlunoEncarregadoEducacao(Integer idAlunoEncarregado, EncarregadoEducacao encarregado, Aluno aluno, Parentesco parentesco, Date inicioResponsabilidade, Date fimResponsabilidade, String observacoes) {
        this.idAlunoEncarregado = idAlunoEncarregado;
        this.encarregado = encarregado;
        this.aluno = aluno;
        this.parentesco = parentesco;
        this.inicioResponsabilidade = inicioResponsabilidade;
        this.fimResponsabilidade = fimResponsabilidade;
        this.observacoes = observacoes;
    }

    /**
     * @return the idAlunoEncarregado
     */
    public Integer getIdAlunoEncarregado() {
        return idAlunoEncarregado;
    }

    /**
     * @param idAlunoEncarregado the idAlunoEncarregado to set
     */
    public void setIdAlunoEncarregado(Integer idAlunoEncarregado) {
        this.idAlunoEncarregado = idAlunoEncarregado;
    }

    /**
     * @return the encarregado
     */
    public EncarregadoEducacao getEncarregado() {
        return encarregado;
    }

    /**
     * @param encarregado the encarregado to set
     */
    public void setEncarregado(EncarregadoEducacao encarregado) {
        this.encarregado = encarregado;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the parentesco
     */
    public Parentesco getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * @return the inicioResponsabilidade
     */
    public Date getInicioResponsabilidade() {
        return inicioResponsabilidade;
    }

    /**
     * @param inicioResponsabilidade the inicioResponsabilidade to set
     */
    public void setInicioResponsabilidade(Date inicioResponsabilidade) {
        this.inicioResponsabilidade = inicioResponsabilidade;
    }

    /**
     * @return the fimResponsabilidade
     */
    public Date getFimResponsabilidade() {
        return fimResponsabilidade;
    }

    /**
     * @param fimResponsabilidade the fimResponsabilidade to set
     */
    public void setFimResponsabilidade(Date fimResponsabilidade) {
        this.fimResponsabilidade = fimResponsabilidade;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idAlunoEncarregado);
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
        final AlunoEncarregadoEducacao other = (AlunoEncarregadoEducacao) obj;
        if (!Objects.equals(this.idAlunoEncarregado, other.idAlunoEncarregado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlunoEncarregadoEducacao{" + "encarregado=" + encarregado + ", aluno=" + aluno + '}';
    }

    
}
