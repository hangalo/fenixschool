/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ParentescoDAO;
import fenixschool.modelo.Parentesco;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
@ManagedBean(name = "parentescoMBean")
@ViewScoped
public class ParentescoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ParentescoDAO parentescoDAO;

    private List<Parentesco> parentescos;

    private Parentesco parentesco;

    public ParentescoMBean() {
    }

    @PostConstruct
    public void inicializar() {

        parentescoDAO = new ParentescoDAO();
        parentescos = new ArrayList<>();
        parentesco = new Parentesco();
    }

    public List<Parentesco> getParentescos() {
        parentescos = parentescoDAO.findAll();
        return parentescos;
    }

    public void setParentescos(List<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public void guardar(ActionEvent event) {
        parentescoDAO.save(parentesco);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        parentesco = new Parentesco();
    }
    
    public void edit(ActionEvent event){
        parentescoDAO.update(parentesco);
        parentesco = null;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("parentesco_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(ParentescoMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String delete(){
        parentescoDAO.delete(parentesco);
        parentesco = null;
        return "parentesco_listar?faces-redirect=true";
    }
}
