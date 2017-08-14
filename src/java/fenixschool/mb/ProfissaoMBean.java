/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.Profissao;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@Named(value = "profissaoMBean")
@ViewScoped
public class ProfissaoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Profissao profissao;
    private ProfissaoDAO profissaoDAO;
    private List<Profissao> profissoes;

    public ProfissaoMBean() {
    }

    @PostConstruct
    public void inicializar() {
        profissao = new Profissao();
        profissaoDAO = new ProfissaoDAO();
        profissoes = new ArrayList<>();

    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getProfissoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public void guardar(ActionEvent evt) {
        profissaoDAO.save(profissao);
        profissao = new Profissao();
    }

     public void edit(java.awt.event.ActionEvent event) {
        profissaoDAO.update(profissao);
        profissoes = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("profissao_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfissaoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public String delete() {
        profissaoDAO.delete(profissao);
        profissoes = null;
        return "profissao_listar?faces-redirect=true";
    }
}
