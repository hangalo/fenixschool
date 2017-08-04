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
 * @author HACKER
 */
public class Curso {
    private int codigoCurso;
    private String nomeCurso;
    private String abreviaturaCurso;
    private String codigoMinisterioDaEducação;
    private Date dataCriacao;
    private Departamento id_Departamento;

    public Curso() {
    }

    public Curso(int codigoCurso, String nomeCurso, String abreviaturaCurso, String codigoMinisterioDaEducação, Date dataCriacao, Departamento id_Departamento) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.abreviaturaCurso = abreviaturaCurso;
        this.codigoMinisterioDaEducação = codigoMinisterioDaEducação;
        this.dataCriacao = dataCriacao;
        this.id_Departamento = id_Departamento;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getAbreviaturaCurso() {
        return abreviaturaCurso;
    }

    public void setAbreviaturaCurso(String abreviaturaCurso) {
        this.abreviaturaCurso = abreviaturaCurso;
    }

    public String getCodigoMinisterioDaEducação() {
        return codigoMinisterioDaEducação;
    }

    public void setCodigoMinisterioDaEducação(String codigoMinisterioDaEducação) {
        this.codigoMinisterioDaEducação = codigoMinisterioDaEducação;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Departamento getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(Departamento id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.codigoCurso;
        hash = 79 * hash + Objects.hashCode(this.nomeCurso);
        hash = 79 * hash + Objects.hashCode(this.abreviaturaCurso);
        hash = 79 * hash + Objects.hashCode(this.codigoMinisterioDaEducação);
        hash = 79 * hash + Objects.hashCode(this.dataCriacao);
        hash = 79 * hash + Objects.hashCode(this.id_Departamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (!Objects.equals(this.nomeCurso, other.nomeCurso)) {
            return false;
        }
        if (!Objects.equals(this.abreviaturaCurso, other.abreviaturaCurso)) {
            return false;
        }
        if (!Objects.equals(this.codigoMinisterioDaEducação, other.codigoMinisterioDaEducação)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.id_Departamento, other.id_Departamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "nomeCurso=" + nomeCurso + '}';
    }

    
    
    
    
    
    
}
