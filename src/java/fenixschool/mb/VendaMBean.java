/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;



import fenixschool.dao.VendaDAO;
import fenixschool.modelo.Venda;
import fenixschool.util.DateUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author informatica
 */
@ManagedBean(name = "facturaMBean")
@ViewScoped
public class VendaMBean implements Serializable{
private static final long serialVersionUID = 1L;

    private VendaDAO vendaDAO;

    private Venda venda;

    public VendaMBean() {
    }

    @PostConstruct
    public void init() {
        vendaDAO = new VendaDAO();
        venda = new Venda();
        venda.setDataVenda(DateUtil.getDataActual());
    }

    public void registarFactura() {
       
        vendaDAO.save(venda);

    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

   

    public void definirValorTotal(Double valor) {
        venda.setTotalVenda(valor);
    }

   

}
