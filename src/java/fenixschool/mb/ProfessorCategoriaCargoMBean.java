/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CategoriaCargoDAO;
import fenixschool.dao.ProfessorCategoriaCargoDAO;
import fenixschool.modelo.CategoriaCargo;
import fenixschool.modelo.ProfessorCategoriaCargo;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Aisha Lubadika
 */
@Named(value = "professorCategoriaCargoMBean")
@ViewScoped
public class ProfessorCategoriaCargoMBean {

   private ProfessorCategoriaCargo professorCategoriaCargo;
   private List<ProfessorCategoriaCargo> professorCategoriaCargos;
   private List<CategoriaCargo> categoriaCargos;
   private ProfessorCategoriaCargoDAO professorCategoriaCargoDAO;
   private CategoriaCargoDAO categoriaCargoDAO;
    
  
    public ProfessorCategoriaCargoMBean() {
    }
    
     @PostConstruct
    public void init() {
        professorCategoriaCargo = new ProfessorCategoriaCargo();
        professorCategoriaCargoDAO = new ProfessorCategoriaCargoDAO();
        categoriaCargoDAO = new CategoriaCargoDAO();
        professorCategoriaCargos = professorCategoriaCargoDAO.findAll();
        categoriaCargos = new ArrayList<>();
    }

    public ProfessorCategoriaCargo getProfessorCategoriaCargo() {
        return professorCategoriaCargo;
    }

    public void setProfessorCategoriaCargo(ProfessorCategoriaCargo professorCategoriaCargo) {
        this.professorCategoriaCargo = professorCategoriaCargo;
    }

    public List<ProfessorCategoriaCargo> getProfessorCategoriaCargos() {
        return professorCategoriaCargos;
    }

    public void setProfessorCategoriaCargos(List<ProfessorCategoriaCargo> professorCategoriaCargos) {
        this.professorCategoriaCargos = professorCategoriaCargos;
    }

    public List<CategoriaCargo> getCategoriaCargos() {
        return categoriaCargos;
    }

    public void setCategoriaCargos(List<CategoriaCargo> categoriaCargos) {
        this.categoriaCargos = categoriaCargos;
    }

    public ProfessorCategoriaCargoDAO getProfessorCategoriaCargoDAO() {
        return professorCategoriaCargoDAO;
    }

    public void setProfessorCategoriaCargoDAO(ProfessorCategoriaCargoDAO professorCategoriaCargoDAO) {
        this.professorCategoriaCargoDAO = professorCategoriaCargoDAO;
    }

    public CategoriaCargoDAO getCategoriaCargoDAO() {
        return categoriaCargoDAO;
    }

    public void setCategoriaCargoDAO(CategoriaCargoDAO categoriaCargoDAO) {
        this.categoriaCargoDAO = categoriaCargoDAO;
    }
    

    public void guardar(javafx.event.ActionEvent evt) {
        if (professorCategoriaCargoDAO.save(professorCategoriaCargo)) {
            professorCategoriaCargo = new ProfessorCategoriaCargo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }

    public String startEdit() {
        return "professor_categoria_cargo_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (professorCategoriaCargoDAO.update(professorCategoriaCargo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            professorCategoriaCargos = null;

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("professor_categoria_cargo_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ProfessorCategoriaCargoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }
    }

    public String delete() {
        if (professorCategoriaCargoDAO.delete(professorCategoriaCargo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            professorCategoriaCargos = null;
            return "professor_categoria_cargo_listar?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;
        }
    }


}
    

