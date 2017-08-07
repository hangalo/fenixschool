/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.DepartamentoDAO;
import fenixschool.modelo.Departamento;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PENA
 */
@Named(value = "departamentoMBean")
@RequestScoped
public class DepartamentoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Departamento departamento = new Departamento();
     DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private List<Departamento> departamentos = new ArrayList<>();

    public DepartamentoMBean() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void guardar(ActionEvent evt) {
        departamentoDAO.save(departamento);
        departamento = new Departamento();
    }

    public List<Departamento> getDepartamentos() {
        departamentos=departamentoDAO.findAll();
        return departamentos;
    }

   public String newSave() {
        departamento = new Departamento();
        return "departamento_guardar?faces-redirect=true";
    }

     public String startEdit() {
        return "departamento_editar?faces-redirect=true";
    }

    public void edit(javax.faces.event.ActionEvent event) {
        departamentoDAO.update(departamento);
        departamentos = null;
        try {
         FacesContext.getCurrentInstance().getExternalContext().redirect("departamento_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(DepartamentoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public String delete() {
        departamentoDAO.delete(departamento);
        departamentos = null;
        return "departamento_listar?faces-redirect=true";
    }
    
}
