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
public class Artigo {
    private int idArtigo;
    private String codigoArgito;
    private String codigoBarraArtigo;
    private String nomeArtigo;
    private Double precoArtigo;
    private CategoriaArtigo categoriaArtigo;

    public Artigo() {
    }

    public Artigo(int idArtigo, String codigoArgito, String codigoBarraArtigo, String nomeArtigo, Double precoArtigo, CategoriaArtigo categoriaArtigo) {
        this.idArtigo = idArtigo;
        this.codigoArgito = codigoArgito;
        this.codigoBarraArtigo = codigoBarraArtigo;
        this.nomeArtigo = nomeArtigo;
        this.precoArtigo = precoArtigo;
        this.categoriaArtigo = categoriaArtigo;
    }

    public CategoriaArtigo getCategoriaArtigo() {
        return categoriaArtigo;
    }

    public void setCategoriaArtigo(CategoriaArtigo categoriaArtigo) {
        this.categoriaArtigo = categoriaArtigo;
    }

    public int getIdArtigo() {
        return idArtigo;
    }

    public void setIdArtigo(int idaArtigo) {
        this.idArtigo = idaArtigo;
    }

    public String getCodigoArgito() {
        return codigoArgito;
    }

    public void setCodigoArgito(String codigoArgito) {
        this.codigoArgito = codigoArgito;
    }

    public String getCodigoBarraArtigo() {
        return codigoBarraArtigo;
    }

    public void setCodigoBarraArtigo(String codigoBarraArtigo) {
        this.codigoBarraArtigo = codigoBarraArtigo;
    }

    public String getNomeArtigo() {
        return nomeArtigo;
    }

    public void setNomeArtigo(String nomeArtigo) {
        this.nomeArtigo = nomeArtigo;
    }

    public Double getPrecoArtigo() {
        return precoArtigo;
    }

    public void setPrecoArtigo(Double precoArtigo) {
        this.precoArtigo = precoArtigo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nomeArtigo);
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
        final Artigo other = (Artigo) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Artigo{" + "codigoArgito=" + codigoArgito + ", codigoBarraArtigo=" + codigoBarraArtigo + ", nomeArtigo=" + nomeArtigo + ", precoArtigo=" + precoArtigo + ", categoriaArtigo=" + categoriaArtigo + '}';
    }
    
    
}
