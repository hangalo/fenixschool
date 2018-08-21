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
public class SemestreLectivo {

    private Integer idSemestreLectivo;
    private String semestreLectivo;
    private Date dataInicio;
    private Date dataFim;
    private String observacoes;

    public SemestreLectivo() {
    }

    public SemestreLectivo(Integer idSemestreLectivo, String semestreLectivo, Date dataInicio, Date dataFim, String observacoes) {
        this.idSemestreLectivo = idSemestreLectivo;
        this.semestreLectivo = semestreLectivo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.observacoes = observacoes;
    }

    public Integer getIdSemestreLectivo() {
        return idSemestreLectivo;
    }

    public void setIdSemestreLectivo(Integer idSemestreLectivo) {
        this.idSemestreLectivo = idSemestreLectivo;
    }

    public String getSemestreLectivo() {
        return semestreLectivo;
    }

    public void setSemestreLectivo(String semestreLectivo) {
        this.semestreLectivo = semestreLectivo;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idSemestreLectivo);
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
        final SemestreLectivo other = (SemestreLectivo) obj;
        if (!Objects.equals(this.idSemestreLectivo, other.idSemestreLectivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SemestreLectivo{" + "semestreLectivo=" + semestreLectivo + '}';
    }
    
    
}
