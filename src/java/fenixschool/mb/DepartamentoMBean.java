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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;

/**
 *
 * @author PENA
 */
@Named(value = "departamentoMBean")
@ViewScoped
public class DepartamentoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Departamento departamento;
    private DepartamentoDAO departamentoDAO;
    private List<Departamento> departamentos;

    public DepartamentoMBean() {
    }

    @PostConstruct
    public void inicializar() {
        departamento = new Departamento();
        departamentoDAO = new DepartamentoDAO();
        departamentos = new ArrayList<>();

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
        departamentos = departamentoDAO.findAll();
        return departamentos;
    }

    public String newSave() {
        departamento = new Departamento();
        return "departamento_guardar?faces-redirect=true";
    }

    public String startEdit() {
        return "departamento_editar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
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
