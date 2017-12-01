/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Objects;

/**
 *
 * @author Rei Santo Hangalo
 */
public class CategoriaArtigo {
    private Integer idCategoriaArtigo;
    private String categoriaArtigo;

    public CategoriaArtigo() {
    }

    public CategoriaArtigo(Integer idCategoriaArtigo, String categoriaArtigo) {
        this.idCategoriaArtigo = idCategoriaArtigo;
        this.categoriaArtigo = categoriaArtigo;
    }
    
    

    public Integer getIdCategoriaArtigo() {
        return idCategoriaArtigo;
    }

    public void setIdCategoriaArtigo(Integer idCategoriaArtigo) {
        this.idCategoriaArtigo = idCategoriaArtigo;
    }

    public String getCategoriaArtigo() {
        return categoriaArtigo;
    }

    public void setCategoriaArtigo(String categoriaArtigo) {
        this.categoriaArtigo = categoriaArtigo;
    }

    @Override
    public String toString() {
        return "CategoriaArtigo{" + "idCategoriaArtigo=" + idCategoriaArtigo + ", categoriaArtigo=" + categoriaArtigo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idCategoriaArtigo);
        hash = 17 * hash + Objects.hashCode(this.categoriaArtigo);
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
        final CategoriaArtigo other = (CategoriaArtigo) obj;
        if (!Objects.equals(this.categoriaArtigo, other.categoriaArtigo)) {
            return false;
        }
        if (!Objects.equals(this.idCategoriaArtigo, other.idCategoriaArtigo)) {
            return false;
        }
        return true;
    }

    
    
    
}
