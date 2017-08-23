/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ObjetivoDeclaracaoDAO;
import fenixschool.modelo.ObjetivoDeclaracao;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kulley
 */

@ManagedBean(name = "objetivoDeclaracaoMBean")
@SessionScoped
public class ObjetivoDeclaracaoMBean {
    
    public static final long serialVersionUID = 1L;
    private ObjetivoDeclaracao objetivoDeclaracao;
    private ObjetivoDeclaracaoDAO objetivoDeclaracaoDAO;
    private List<ObjetivoDeclaracao> objetivodeclaracoes;
    
    @PostConstruct
    public void inicializar(){
        objetivoDeclaracao = new ObjetivoDeclaracao();
        objetivoDeclaracaoDAO = new ObjetivoDeclaracaoDAO();
        objetivodeclaracoes = new ArrayList<>();
    }

    public ObjetivoDeclaracaoMBean() {
    }

    public ObjetivoDeclaracao getObjetivoDeclaracao() {
        return objetivoDeclaracao;
    }

    public void setObjetivoDeclaracao(ObjetivoDeclaracao objetivoDeclaracao) {
        this.objetivoDeclaracao = objetivoDeclaracao;
    }

    public ObjetivoDeclaracaoDAO getObjetivoDeclaracaoDAO() {
        return objetivoDeclaracaoDAO;
    }

    public void setObjetivoDeclaracaoDAO(ObjetivoDeclaracaoDAO objetivoDeclaracaoDAO) {
        this.objetivoDeclaracaoDAO = objetivoDeclaracaoDAO;
    }

    public List<ObjetivoDeclaracao> getObjetivodeclaracoes() {
        objetivodeclaracoes = objetivoDeclaracaoDAO.findAll();
        return objetivodeclaracoes;
    }

    public void setObjetivodeclaracoes(List<ObjetivoDeclaracao> objetivodeclaracoes) {
        this.objetivodeclaracoes = objetivodeclaracoes;
    }
    
    public void guardar (ActionEvent evt){
        objetivoDeclaracaoDAO.save(objetivoDeclaracao);
        objetivoDeclaracao = new ObjetivoDeclaracao();
    }
    
    public void edit (java.awt.event.ActionEvent event){
        objetivoDeclaracaoDAO.update(objetivoDeclaracao);
        objetivodeclaracoes = null;
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("objetivo_declaracao_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfissaoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String delete(){
        objetivoDeclaracaoDAO.delete(objetivoDeclaracao);
        objetivodeclaracoes = null;
        return "objetivo_declaracao_listar?faces-redirect=true";
    }
    
    
    
}
