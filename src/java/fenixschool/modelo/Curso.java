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
    private String codigoCurso;
    private String nomeCurso;
    private String abreviaturaCurso;
    private String codigoMinisterioDaEducação;
    private Date dataCriacao;
    private Departamento idDepartamento;
    private String descricaoCurso;
    private String conteudoProgramaticoCurso;

    public Curso() {
    }

    public Curso(String codigoCurso, String nomeCurso, String abreviaturaCurso, String codigoMinisterioDaEducação, Date dataCriacao, Departamento idDepartamento, String descricaoCurso, String conteudoProgramaticoCurso) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.abreviaturaCurso = abreviaturaCurso;
        this.codigoMinisterioDaEducação = codigoMinisterioDaEducação;
        this.dataCriacao = dataCriacao;
        this.idDepartamento = idDepartamento;
        this.descricaoCurso = descricaoCurso;
        this.conteudoProgramaticoCurso = conteudoProgramaticoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
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

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public String getConteudoProgramaticoCurso() {
        return conteudoProgramaticoCurso;
    }

    public void setConteudoProgramaticoCurso(String conteudoProgramaticoCurso) {
        this.conteudoProgramaticoCurso = conteudoProgramaticoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigoCurso);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.codigoCurso, other.codigoCurso)) {
            return false;
        }
        return true;
    }

    
    
   

   


   

    @Override
    public String toString() {
        return this.nomeCurso ;
    }

    
    
    
    
    
    
}
