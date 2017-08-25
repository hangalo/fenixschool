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
 * @author Aisha Lubadika
 */
public class Certificado {
    private Integer idCertificado;
    private Date dataCertificado;
    private Funcionario idFuncionario;
    private Aluno idAluno;
    private AnoCurricular idAnoCurricilar;
    private String textoCertificado;

    public Certificado() {
    }

    public Certificado(Integer idCertificado, Date dataCertificado, Funcionario idFuncionario, Aluno idAluno, AnoCurricular idAnoCurricilar, String textoCertificado) {
        this.idCertificado = idCertificado;
        this.dataCertificado = dataCertificado;
        this.idFuncionario = idFuncionario;
        this.idAluno = idAluno;
        this.idAnoCurricilar = idAnoCurricilar;
        this.textoCertificado = textoCertificado;
    }

    public Integer getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public Date getDataCertificado() {
        return dataCertificado;
    }

    public void setDataCertificado(Date dataCertificado) {
        this.dataCertificado = dataCertificado;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public AnoCurricular getIdAnoCurricilar() {
        return idAnoCurricilar;
    }

    public void setIdAnoCurricilar(AnoCurricular idAnoCurricilar) {
        this.idAnoCurricilar = idAnoCurricilar;
    }

    public String getTextoCertificado() {
        return textoCertificado;
    }

    public void setTextoCertificado(String textoCertificado) {
        this.textoCertificado = textoCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idCertificado);
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
        final Certificado other = (Certificado) obj;
        if (!Objects.equals(this.idCertificado, other.idCertificado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certificado{" + "idCertificado=" + idCertificado + ", dataCertificado=" + dataCertificado + ", idFuncionario=" + idFuncionario + ", idAluno=" + idAluno + ", idAnoCurricilar=" + idAnoCurricilar + ", textoCertificado=" + textoCertificado + '}';
    }
    
    

  
    
    
    
    
    
    
    
    
    
}
