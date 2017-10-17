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
public class ProfessorCategoriaCargo implements Serializable{
    private Integer idProfessorCategoriaCargo;
    private CategoriaCargo categoriaCargo;
    private Professor professor;
    private Date dataNomeacao;
    private Date dataFimNomeacao;
    private String observacoes;

    public ProfessorCategoriaCargo() {
    }

    public ProfessorCategoriaCargo(Integer idProfessorCategoriaCargo, CategoriaCargo categoriaCargo, Professor professor, Date dataNomeacao, Date dataFimNomeacao, String observacoes) {
        this.idProfessorCategoriaCargo = idProfessorCategoriaCargo;
        this.categoriaCargo = categoriaCargo;
        this.professor = professor;
        this.dataNomeacao = dataNomeacao;
        this.dataFimNomeacao = dataFimNomeacao;
        this.observacoes = observacoes;
    }

    public Integer getIdProfessorCategoriaCargo() {
        return idProfessorCategoriaCargo;
    }

    public void setIdProfessorCategoriaCargo(Integer idProfessorCategoriaCargo) {
        this.idProfessorCategoriaCargo = idProfessorCategoriaCargo;
    }

    public CategoriaCargo getCategoriaCargo() {
        return categoriaCargo;
    }

    public void setCategoriaCargo(CategoriaCargo categoriaCargo) {
        this.categoriaCargo = categoriaCargo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Date getDataNomeacao() {
        return dataNomeacao;
    }

    public void setDataNomeacao(Date dataNomeacao) {
        this.dataNomeacao = dataNomeacao;
    }

    public Date getDataFimNomeacao() {
        return dataFimNomeacao;
    }

    public void setDataFimNomeacao(Date dataFimNomeacao) {
        this.dataFimNomeacao = dataFimNomeacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idProfessorCategoriaCargo);
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
        final ProfessorCategoriaCargo other = (ProfessorCategoriaCargo) obj;
        if (!Objects.equals(this.idProfessorCategoriaCargo, other.idProfessorCategoriaCargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfessorCategoriaCargo{" + "categoriaCargo=" + categoriaCargo + ", professor=" + professor + '}';
    }
    
    
   
}
