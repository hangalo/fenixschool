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
 * @author PENA
 */
public class Disciplina implements Serializable{

    private int idDisciplina;
    private String nomeDisciplina;
    private String abreviatura;
    private String descricaoDisplina;
    private String sumarioDdisciplina;
    private Date dataCriacao;
    private Curso curso;
    private AnoLectivo anoLectivo;
    private PeriodoLectivo periodoLetivo;
    private CicloLectivo cicloLetivo;
    private TipoDisciplina tipoDisciplina;

    public Disciplina() {
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescricaoDisplina() {
        return descricaoDisplina;
    }

    public void setDescricaoDisplina(String descricaoDisplina) {
        this.descricaoDisplina = descricaoDisplina;
    }

    public String getSumarioDdisciplina() {
        return sumarioDdisciplina;
    }

    public void setSumarioDdisciplina(String sumarioDdisciplina) {
        this.sumarioDdisciplina = sumarioDdisciplina;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public PeriodoLectivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(PeriodoLectivo periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public CicloLectivo getCicloLetivo() {
        return cicloLetivo;
    }

    public void setCicloLetivo(CicloLectivo cicloLetivo) {
        this.cicloLetivo = cicloLetivo;
    }

    public TipoDisciplina getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(TipoDisciplina tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idDisciplina;
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
        final Disciplina other = (Disciplina) obj;
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nomeDisciplina=" + nomeDisciplina + ", abreviatura=" + abreviatura + '}';
    }

    
    
}
