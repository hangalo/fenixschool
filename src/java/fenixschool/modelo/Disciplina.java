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
 * @author PENA
 */
public class Disciplina {

    private String idDisciplina;
    private String nomeDisciplina;
    private String abreviatura;
    private String descricaoDisplina;
    private String sumarioDisciplina;
    private Date dataCriacao;
    private CicloLectivo cicloLectivo;
    private TipoDisciplina tipoDisciplina;

    public Disciplina() {
    }

    public Disciplina(String idDisciplina, String nomeDisciplina, String abreviatura, String descricaoDisplina, String sumarioDisciplina, Date dataCriacao, CicloLectivo cicloLectivo, TipoDisciplina tipoDisciplina) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.abreviatura = abreviatura;
        this.descricaoDisplina = descricaoDisplina;
        this.sumarioDisciplina = sumarioDisciplina;
        this.dataCriacao = dataCriacao;
        this.cicloLectivo = cicloLectivo;
        this.tipoDisciplina = tipoDisciplina;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
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

    public String getSumarioDisciplina() {
        return sumarioDisciplina;
    }

    public void setSumarioDisciplina(String sumarioDisciplina) {
        this.sumarioDisciplina = sumarioDisciplina;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public TipoDisciplina getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(TipoDisciplina tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idDisciplina);
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
        if (!Objects.equals(this.idDisciplina, other.idDisciplina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nomeDisciplina=" + nomeDisciplina + '}';
    }

    
}
