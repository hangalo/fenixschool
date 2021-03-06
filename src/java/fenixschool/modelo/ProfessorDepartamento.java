/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import fenixschool.util.DateUtil;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author informatica
 */
public class ProfessorDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idProfessorDepartamento;
    private Professor professor;
    private Departamento departamento;
    private Date dataInicio;
    private Date dataFim;
    private int anosDeServico;
    private String observacoes;
    private ProfessorCategoriaCargo professorCategoriaCargo;

    public ProfessorDepartamento() {
    }

    public ProfessorDepartamento(int idProfessorDepartamento, Professor professor, Departamento departamento, Date dataInicio, Date dataFim, int anosDeServico, String observacoes, ProfessorCategoriaCargo professorCategoriaCargo) {
        this.idProfessorDepartamento = idProfessorDepartamento;
        this.professor = professor;
        this.departamento = departamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.anosDeServico = anosDeServico;
        this.observacoes = observacoes;
        this.professorCategoriaCargo = professorCategoriaCargo;
    }

 

    public int getIdProfessorDepartamento() {
        return idProfessorDepartamento;
    }

    public void setIdProfessorDepartamento(int idProfessorDepartamento) {
        this.idProfessorDepartamento = idProfessorDepartamento;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getAnosDeServico() {
        anosDeServico = DateUtil.calculaIdade(dataInicio);
        return anosDeServico;
    }

    public void setAnosDeServico(int anosDeServico) {
        this.anosDeServico = anosDeServico;
    }

    public ProfessorCategoriaCargo getProfessorCategoriaCargo() {
        return professorCategoriaCargo;
    }

    public void setProfessorCategoriaCargo(ProfessorCategoriaCargo professorCategoriaCargo) {
        this.professorCategoriaCargo = professorCategoriaCargo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idProfessorDepartamento;
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
        final ProfessorDepartamento other = (ProfessorDepartamento) obj;
        if (this.idProfessorDepartamento != other.idProfessorDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "professor=" + professor + ", departamento=" + departamento;
    }

}
