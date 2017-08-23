/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author kulley
 */

public class Declaracao {
    private int idDeclaracao;
    private String textoDeclaracao;
    private Date dataDeclaracao;
    private Funcionario idFuncionario;
    private ObjetivoDeclaracao idObjetivoDeclaracao;
    private Aluno idAluno;

    public Declaracao() {
    }

    public Declaracao(int idDeclaracao, String textoDeclaracao, Date dataDeclaracao, Funcionario idFuncionario, ObjetivoDeclaracao idObjetivoDeclaracao, Aluno idAluno) {
        this.idDeclaracao = idDeclaracao;
        this.textoDeclaracao = textoDeclaracao;
        this.dataDeclaracao = dataDeclaracao;
        this.idFuncionario = idFuncionario;
        this.idObjetivoDeclaracao = idObjetivoDeclaracao;
        this.idAluno = idAluno;
    }

    public int getIdDeclaracao() {
        return idDeclaracao;
    }

    public void setIdDeclaracao(int idDeclaracao) {
        this.idDeclaracao = idDeclaracao;
    }

    public String getTextoDeclaracao() {
        return textoDeclaracao;
    }

    public void setTextoDeclaracao(String textoDeclaracao) {
        this.textoDeclaracao = textoDeclaracao;
    }

    public Date getDataDeclaracao() {
        return dataDeclaracao;
    }

    public void setDataDeclaracao(Date dataDeclaracao) {
        this.dataDeclaracao = dataDeclaracao;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public ObjetivoDeclaracao getIdObjetivoDeclaracao() {
        return idObjetivoDeclaracao;
    }

    public void setIdObjetivoDeclaracao(ObjetivoDeclaracao idObjetivoDeclaracao) {
        this.idObjetivoDeclaracao = idObjetivoDeclaracao;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idDeclaracao;
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
        final Declaracao other = (Declaracao) obj;
        if (this.idDeclaracao != other.idDeclaracao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Declaracao{" + "textoDeclaracao=" + textoDeclaracao + '}';
    }
    
    
    
}
