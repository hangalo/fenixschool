/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.DisciplinaDAO;
import fenixschool.dao.DocenciaDAO;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Docencia;
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
@ManagedBean(name = "docenciaMBean")
@ViewScoped
public class DocenciaMBean implements Serializable {

    /**
     * Creates a new instance of DocenciaMBean
     */
    private Docencia docencia;
    private List<Docencia> docencias;
    private DocenciaDAO docenciaDAO;
    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;

    public DocenciaMBean() {
    }

    @PostConstruct
    public void init() {
        docencia = new Docencia();
        docenciaDAO = new DocenciaDAO();
        disciplinaDAO = new DisciplinaDAO();
        docencias = docenciaDAO.findAll();
        disciplinas = new ArrayList<>();
    }

    public Docencia getDocencia() {
        return docencia;
    }

    public void setDocencia(Docencia docencia) {
        this.docencia = docencia;
    }

    public List<Docencia> getDocencias() {
        return docencias;
    }

    public void setDocencias(List<Docencia> docencias) {
        this.docencias = docencias;
    }

    public void newSave(ActionEvent evt) {
        docencia = new Docencia();

    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    

    public void guardar(ActionEvent evt) {
         boolean controlo = false;
        for (Disciplina disciplinaLida : disciplinas) {
            Disciplina disciplina = disciplinaDAO.findById(disciplinaLida.getIdDisciplina());
            docencia.setDisciplina(disciplina);
            controlo = docenciaDAO.save(docencia);
        }
        
          if (controlo) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado registado com sucesso"));
                docencia = new Docencia();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));

            }

    }

    public String startEdit() {
        return "docencia_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
           boolean controlo = false;
        for (Disciplina disciplinaLida : disciplinas) {
            Disciplina disciplina = disciplinaDAO.findById(disciplinaLida.getIdDisciplina());
            docencia.setDisciplina(disciplina);
            controlo = docenciaDAO.update(docencia);
        }
               
        if (controlo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            docencias = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("docencia_gestao.jsf");
            } catch (IOException ex) {
                Logger.getLogger(DocenciaMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));

        }

    }

    public String delete() {
        if (docenciaDAO.delete(docencia)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            docencias = null;

            return "docencia_gestao?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;

        }

    }

}
