/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class TipoDocumentoIdentidade {
    private Integer idTipoDocumentoIdentidade;
    private String tipoDOcumentoIdentidade;
    
    public TipoDocumentoIdentidade(){}

    public TipoDocumentoIdentidade(Integer idTipoDocumentoIdentidade, String tipoDOcumentoIdentidade) {
        this.idTipoDocumentoIdentidade = idTipoDocumentoIdentidade;
        this.tipoDOcumentoIdentidade = tipoDOcumentoIdentidade;
    }

    public Integer getIdTipoDocumentoIdentidade() {
        return idTipoDocumentoIdentidade;
    }

    public void setIdTipoDocumentoIdentidade(Integer idTipoDocumentoIdentidade) {
        this.idTipoDocumentoIdentidade = idTipoDocumentoIdentidade;
    }

    public String getTipoDOcumentoIdentidade() {
        return tipoDOcumentoIdentidade;
    }

    public void setTipoDOcumentoIdentidade(String tipoDOcumentoIdentidade) {
        this.tipoDOcumentoIdentidade = tipoDOcumentoIdentidade;
    }

    @Override
    public String toString() {
        return "TipoDocumentoIdentidade{" + "idTipoDocumentoIdentidade=" + idTipoDocumentoIdentidade + ", tipoDOcumentoIdentidade=" + tipoDOcumentoIdentidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idTipoDocumentoIdentidade);
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
        final TipoDocumentoIdentidade other = (TipoDocumentoIdentidade) obj;
        if (!Objects.equals(this.idTipoDocumentoIdentidade, other.idTipoDocumentoIdentidade)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
