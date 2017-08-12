/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CursoDAO;
import fenixschool.dao.DepartamentoDAO;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
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
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author informatica
 */



@ManagedBean(name = "cursoMBean")
@ViewScoped
public class CursoMBean implements  Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of CursoMBean
     */
    public CursoMBean() {
    }
    
    
    
    private Curso curso;
    private CursoDAO cursoDAO;
    private List<Curso> cursos;

   

    @PostConstruct
    public void inicializar() {
        curso = new Curso();
        cursoDAO = new CursoDAO();
        cursos = new ArrayList<>();

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    

  

    public List<Curso> getCursos() {
        cursos = cursoDAO.findAll();
        return cursos;
    }

    public String newSave() {
        curso = new Curso();
        return "curso_guardar?faces-redirect=true";
    }

      public void guardar(ActionEvent evt) {
        cursoDAO.save(curso);
        curso = new Curso();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Curso registado com sucesso"));
    }
    public String startEdit() {
        return "curso_editar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        cursoDAO.update(curso);
        cursos = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("curso_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CursoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        cursoDAO.delete(curso);
        cursos = null;
        return "curso_listar?faces-redirect=true";
    }
    
}
