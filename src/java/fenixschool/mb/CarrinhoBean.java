/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;


import fenixschool.dao.VendaDAO;
import fenixschool.dao.VendaDetalhesDAO;
import fenixschool.modelo.Artigo;
import fenixschool.modelo.Cliente;
import fenixschool.modelo.Venda;
import fenixschool.modelo.VendaDetalhe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@ManagedBean(name = "carrinhoBean")
@ViewScoped
public class CarrinhoBean implements Serializable {

    private static final long serialVersionUID = 1L;
  
    
    private VendaDAO vendaDAO;

   
    private VendaDetalhesDAO vendaDetalhesDAO;

   @Inject
    VendaMBean vendaMBean;

    private List<VendaDetalhe> carrinho = new ArrayList<>();
    private List<Cliente> clientes;

    private Cliente cliente;
    private Venda venda;

    private float total;

    @PostConstruct
    public void inti() {
        vendaDAO = new VendaDAO();
        vendaDetalhesDAO = new VendaDetalhesDAO();
        cliente = new Cliente();
        venda = new Venda();

        clientes = new ArrayList<>();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

 

    public CarrinhoBean() {
    }

    private int isExisting(Artigo artigo) {
        for (int i = 0; i < this.carrinho.size(); i++) {
            if (this.carrinho.get(i).getArtigo().getIdArtigo()== artigo.getIdArtigo()) {
                return i;
            }
        }
        return -1;

    }

    public long suma() {
        long s = 0;
        for (VendaDetalhe it : this.carrinho) {
            s += it.getQuantidadeVendaDetalhe()* it.getArtigo().getPrecoArtigo();
        }
        return s;
    }

    public void delete(VendaDetalhe it) {
        System.out.println("Delelte >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        if (this.carrinho != null && !this.carrinho.isEmpty()) {
            if (it != null) {
                this.carrinho.remove(it);
            }
        }

    }

    public String addicionarProdutoCarrinho(Artigo artigo) {
        int index = isExisting(artigo);
        if (index == -1) {
            this.carrinho.add(new VendaDetalhe(artigo, artigo.getPrecoArtigo(), 1));
        } else {
            int quantidade = this.carrinho.get(index).getQuantidadeVendaDetalhe()+ 1;
            this.carrinho.get(index).setQuantidadeVendaDetalhe(quantidade);
        }
        // return "carrinho?face-redirect=true";
        return null;
    }

    public List<VendaDetalhe> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<VendaDetalhe> carrinho) {
        this.carrinho = carrinho;
    }

    public void registarCompra() {
        // guarda a factura -> busca a ultima factura

        double totalFactura = suma();
        // define o total da factura actual
       vendaMBean.getVenda().setTotalVenda(totalFactura);

        //chamada do metodo que regista a factura actual
        vendaMBean.registarFactura();

        //busca a ultima factura registada
        Integer numeroFatura = vendaDAO.buscaUltimaFactura();
        //define o nunmeo da factura actual
        venda.setIdVenda(numeroFatura);
        //percorre o carrinho e regista cada item
        for (VendaDetalhe item : carrinho) {
            item.setVenda(venda);
            vendaDetalhesDAO.save(item);
        }
        carrinho.clear();
    }

}
