/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HACKER
 */
public class Profissao {
    private int idProfissao;
    private String nomeProfissao;

    public Profissao() {
    }

    public Profissao(int idProfissao, String nomeProfissao) {
        this.idProfissao = idProfissao;
        this.nomeProfissao = nomeProfissao;
    }

    public int getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(int idProfissao) {
        this.idProfissao = idProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idProfissao;
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
        final Profissao other = (Profissao) obj;
        if (this.idProfissao != other.idProfissao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profissao{" + "nomeProfissao=" + nomeProfissao + '}';
    }
    
    
    
}
