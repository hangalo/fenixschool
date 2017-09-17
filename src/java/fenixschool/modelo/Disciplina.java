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

    private int idDisciplina;
    private String nomeDisciplina;
    private String abreviatura;
    private String descricaoDisplina;
    private String sumarioDisciplina;
    private Date dataCriacao;
    private Curso codigoCurso;
    private AnoLectivo anoLetivo;
    private PeriodoLectivo periodoLetivo;
    private CicloLectivo cicloLetivo;
    private TipoDisciplina tipoDisciplina;

    public Disciplina() {
    }

    public Disciplina(int idDisciplina, String nomeDisciplina, String abreviatura, String descricaoDisplina, String sumarioDisciplina, Date dataCriacao, Curso codigoCurso, AnoLectivo anoLetivo, PeriodoLectivo periodoLetivo, CicloLectivo cicloLetivo, TipoDisciplina tipoDisciplina) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.abreviatura = abreviatura;
        this.descricaoDisplina = descricaoDisplina;
        this.sumarioDisciplina = sumarioDisciplina;
        this.dataCriacao = dataCriacao;
        this.codigoCurso = codigoCurso;
        this.anoLetivo = anoLetivo;
        this.periodoLetivo = periodoLetivo;
        this.cicloLetivo = cicloLetivo;
        this.tipoDisciplina = tipoDisciplina;
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

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public AnoLectivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLectivo anoLetivo) {
        this.anoLetivo = anoLetivo;
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
        hash = 83 * hash + this.idDisciplina;
        hash = 83 * hash + Objects.hashCode(this.nomeDisciplina);
        hash = 83 * hash + Objects.hashCode(this.abreviatura);
        hash = 83 * hash + Objects.hashCode(this.descricaoDisplina);
        hash = 83 * hash + Objects.hashCode(this.sumarioDisciplina);
        hash = 83 * hash + Objects.hashCode(this.dataCriacao);
        hash = 83 * hash + Objects.hashCode(this.codigoCurso);
        hash = 83 * hash + Objects.hashCode(this.anoLetivo);
        hash = 83 * hash + Objects.hashCode(this.periodoLetivo);
        hash = 83 * hash + Objects.hashCode(this.cicloLetivo);
        hash = 83 * hash + Objects.hashCode(this.tipoDisciplina);
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
        if (!Objects.equals(this.nomeDisciplina, other.nomeDisciplina)) {
            return false;
        }
        if (!Objects.equals(this.abreviatura, other.abreviatura)) {
            return false;
        }
        if (!Objects.equals(this.descricaoDisplina, other.descricaoDisplina)) {
            return false;
        }
        if (!Objects.equals(this.sumarioDisciplina, other.sumarioDisciplina)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.codigoCurso, other.codigoCurso)) {
            return false;
        }
        if (!Objects.equals(this.anoLetivo, other.anoLetivo)) {
            return false;
        }
        if (!Objects.equals(this.periodoLetivo, other.periodoLetivo)) {
            return false;
        }
        if (!Objects.equals(this.cicloLetivo, other.cicloLetivo)) {
            return false;
        }
        if (!Objects.equals(this.tipoDisciplina, other.tipoDisciplina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nomeDisciplina=" + nomeDisciplina + '}';
    }

    
}
