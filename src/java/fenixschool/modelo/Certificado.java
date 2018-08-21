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
    private Funcionario funcionarioCertificado;
    private Aluno alunoCertificado;
    private AnoCurricular anocertificado;
    private String textoCertificado;

    public Certificado() {
    }

    public Certificado(Integer idCertificado, Date dataCertificado, Funcionario funcionarioCertificado, Aluno alunoCertificado, AnoCurricular anocertificado, String textoCertificado) {
        this.idCertificado = idCertificado;
        this.dataCertificado = dataCertificado;
        this.funcionarioCertificado = funcionarioCertificado;
        this.alunoCertificado = alunoCertificado;
        this.anocertificado = anocertificado;
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

    public Funcionario getFuncionarioCertificado() {
        return funcionarioCertificado;
    }

    public void setFuncionarioCertificado(Funcionario funcionarioCertificado) {
        this.funcionarioCertificado = funcionarioCertificado;
    }

    public Aluno getAlunoCertificado() {
        return alunoCertificado;
    }

    public void setAlunoCertificado(Aluno alunoCertificado) {
        this.alunoCertificado = alunoCertificado;
    }

    public AnoCurricular getAnocertificado() {
        return anocertificado;
    }

    public void setAnocertificado(AnoCurricular anocertificado) {
        this.anocertificado = anocertificado;
    }

    public String getTextoCertificado() {
        return textoCertificado;
    }

    public void setTextoCertificado(String textoCertificado) {
        this.textoCertificado = textoCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idCertificado);
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
        return "Certificado{" + "alunoCertificado=" + alunoCertificado + '}';
    }

    
    
    
}
