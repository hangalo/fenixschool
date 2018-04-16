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
public class VendaDetalhe {
    
    private Integer idVendaDetalhe;
    private Venda venda;
    private Artigo artigo;
    private Integer quantidadeVendaDetalhe;
    private Double descontoIVAVendaDetalhe;
    private Double precoVendaDetalhe;

    public VendaDetalhe() {
    }

    public VendaDetalhe(Integer idVendaDetalhe, Venda venda, Artigo artigo, Integer quantidadeVendaDetalhe, Double descontoIVAVendaDetalhe, Double precoVendaDetalhe) {
        this.idVendaDetalhe = idVendaDetalhe;
        this.venda = venda;
        this.artigo = artigo;
        this.quantidadeVendaDetalhe = quantidadeVendaDetalhe;
        this.descontoIVAVendaDetalhe = descontoIVAVendaDetalhe;
        this.precoVendaDetalhe = precoVendaDetalhe;
    }

    
     public VendaDetalhe(Artigo artigo, Double precoVendaDetalhe, Integer quantidadeVendaDetalhe) {
        
        this.artigo = artigo;
        
        this.precoVendaDetalhe = precoVendaDetalhe;
        this.quantidadeVendaDetalhe = quantidadeVendaDetalhe;
     
    }
 
    
    public Integer getIdVendaDetalhe() {
        return idVendaDetalhe;
    }

    public void setIdVendaDetalhe(Integer idVendaDetalhe) {
        this.idVendaDetalhe = idVendaDetalhe;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public Integer getQuantidadeVendaDetalhe() {
        return quantidadeVendaDetalhe;
    }

    public void setQuantidadeVendaDetalhe(Integer quantidadeVendaDetalhe) {
        this.quantidadeVendaDetalhe = quantidadeVendaDetalhe;
    }

    public Double getDescontoIVAVendaDetalhe() {
        return descontoIVAVendaDetalhe;
    }

    public void setDescontoIVAVendaDetalhe(Double descontoIVAVendaDetalhe) {
        this.descontoIVAVendaDetalhe = descontoIVAVendaDetalhe;
    }

    public Double getPrecoVendaDetalhe() {
        return precoVendaDetalhe;
    }

    public void setPrecoVendaDetalhe(Double precoVendaDetalhe) {
        this.precoVendaDetalhe = precoVendaDetalhe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idVendaDetalhe);
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
        final VendaDetalhe other = (VendaDetalhe) obj;
        if (!Objects.equals(this.idVendaDetalhe, other.idVendaDetalhe)) {
            return false;
        }
        return true;
    }
    
    
   
}
