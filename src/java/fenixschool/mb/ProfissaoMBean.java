/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.Profissao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "profissaoMBean")
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
        if (profissaoDAO.save(profissao)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profissão guardada com sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            profissao = new Profissao();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao guardar profissão.", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String edit(ActionEvent event) {
        if (profissaoDAO.update(profissao)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profissão actualizada com sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            profissoes = null;
            return "profissao_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao actualizar profissão.", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

    public String delete() {
        if (profissaoDAO.delete(profissao)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profissão eliminada com sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            profissoes = null;
            return "profissao_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar profissão.", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }

}
