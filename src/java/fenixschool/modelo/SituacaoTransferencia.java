/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author informatica
 */
public class SituacaoTransferencia {
    private Integer idSituacaoTransferencia;
    private String situacaoTransferencia;

    public SituacaoTransferencia() {
    }

    public SituacaoTransferencia(Integer idSituacaoTransferencia, String situacaoTransferencia) {
        this.idSituacaoTransferencia = idSituacaoTransferencia;
        this.situacaoTransferencia = situacaoTransferencia;
    }

    public Integer getIdSituacaoTransferencia() {
        return idSituacaoTransferencia;
    }

    public void setIdSituacaoTransferencia(Integer idSituacaoTransferencia) {
        this.idSituacaoTransferencia = idSituacaoTransferencia;
    }

    public String getSituacaoTransferencia() {
        return situacaoTransferencia;
    }

    public void setSituacaoTransferencia(String situacaoTransferencia) {
        this.situacaoTransferencia = situacaoTransferencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idSituacaoTransferencia);
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
        final SituacaoTransferencia other = (SituacaoTransferencia) obj;
        if (!Objects.equals(this.idSituacaoTransferencia, other.idSituacaoTransferencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SituacaoTransferencia{" + "situacaoTransferencia=" + situacaoTransferencia + '}';
    }
    
    
}
