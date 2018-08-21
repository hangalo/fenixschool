/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.DepartamentoDAO;
import fenixschool.dao.ProfessorDepartamentoDAO;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Docencia;
import fenixschool.modelo.Professor;
import fenixschool.modelo.ProfessorDepartamento;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author informatica
 */
@ManagedBean(name = "professorDepartamentoMBean")
@ViewScoped
public class ProfessorDepartamentoMBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private ProfessorDepartamento professorDepartamento;
    private List<ProfessorDepartamento> professorDepartamentos;
    private List<Departamento> departamentos;
    private ProfessorDepartamentoDAO professorDepartamentoDAO;
    private DepartamentoDAO departamentoDAO;

    /**
     * Creates a new instance of ProfessorDepartamentoMBean
     */
    public ProfessorDepartamentoMBean() {
    }

    @PostConstruct
    public void init() {
        professorDepartamento = new ProfessorDepartamento();
        professorDepartamentoDAO = new ProfessorDepartamentoDAO();
        departamentoDAO = new DepartamentoDAO();
        professorDepartamentos = professorDepartamentoDAO.findAll();
        departamentos = new ArrayList<>();
    }

    public ProfessorDepartamento getProfessorDepartamento() {
        return professorDepartamento;
    }

    public void setProfessorDepartamento(ProfessorDepartamento professorDepartamento) {
        this.professorDepartamento = professorDepartamento;
    }

    public List<ProfessorDepartamento> getProfessorDepartamentos() {
        return professorDepartamentos;
    }

    public void setProfessorDepartamentos(List<ProfessorDepartamento> professorDepartamentos) {
        this.professorDepartamentos = professorDepartamentos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public void newSave(ActionEvent evt) {
        professorDepartamento = new ProfessorDepartamento();

    }

    public void guardar(ActionEvent evt) {
        boolean controlo = false;
        for (Departamento departamentoLido : departamentos) {
            Departamento departamento = departamentoDAO.findById(departamentoLido.getIdDepartamento());
            professorDepartamento.setDepartamento(departamento);
            controlo = professorDepartamentoDAO.save(professorDepartamento);
        }
        if (controlo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado registado com sucesso"));
            professorDepartamento = new ProfessorDepartamento();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));

        }
    }

    public String startEdit() {
        return "colocacao_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        boolean controlo = false;
        for (Departamento departamentoLido : departamentos) {
            Departamento departamento = departamentoDAO.findById(departamentoLido.getIdDepartamento());
            professorDepartamento.setDepartamento(departamento);
            controlo = professorDepartamentoDAO.save(professorDepartamento);
        }

        if (controlo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            professorDepartamentos = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("colocacao_gestao.jsf");
            } catch (IOException ex) {
                Logger.getLogger(DocenciaMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));

        }
    }

    public String delete() {
        if (professorDepartamentoDAO.delete(professorDepartamento)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            professorDepartamentos = null;

            return "colocacao_gestao?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;

        }

    }

}
