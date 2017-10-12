/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author Rei Santo Hangalo
 */
public class CategoriaArtigo {
    private int idCategoriaArtigo;
    private String categoriaArtigo;

    public CategoriaArtigo() {
    }

    public CategoriaArtigo(int idCategoriaArtigo, String categoriaArtigo) {
        this.idCategoriaArtigo = idCategoriaArtigo;
        this.categoriaArtigo = categoriaArtigo;
    }

    public String getCategoriaArtigo() {
        return categoriaArtigo;
    }

    public void setCategoriaArtigo(String categoriaArtigo) {
        this.categoriaArtigo = categoriaArtigo;
    }

    public int getIdCategoriaArtigo() {
        return idCategoriaArtigo;
    }

    public void setIdCategoriaArtigo(int idCategoriaArtigo) {
        this.idCategoriaArtigo = idCategoriaArtigo;
    }

    @Override
    public String toString() {
        return "CategoriaArtigo{" + "categoriaArtigo=" + categoriaArtigo + '}';
    }
    
    
}
