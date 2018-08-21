/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author PENA
 */
public class NotaCertificado {

    private Integer idNotaCertificado;
    private Certificado certificado;
    private Double notaCertificado;
    private Nota nota;

    public NotaCertificado() {
    }

    public NotaCertificado(Integer idNotaCertificado, Certificado certificado, Double notaCertificado, Nota nota) {
        this.idNotaCertificado = idNotaCertificado;
        this.certificado = certificado;
        this.notaCertificado = notaCertificado;
        this.nota = nota;
    }

    public Integer getIdNotaCertificado() {
        return idNotaCertificado;
    }

    public void setIdNotaCertificado(Integer idNotaCertificado) {
        this.idNotaCertificado = idNotaCertificado;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public Double getNotaCertificado() {
        return notaCertificado;
    }

    public void setNotaCertificado(Double notaCertificado) {
        this.notaCertificado = notaCertificado;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idNotaCertificado);
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
        final NotaCertificado other = (NotaCertificado) obj;
        if (!Objects.equals(this.idNotaCertificado, other.idNotaCertificado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaCertificado{" + "nota=" + nota + '}';
    }

    

    
}
