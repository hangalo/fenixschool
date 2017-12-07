/*
 *  Pawered by Finix Innovation
 *  www.fenixinnovation.com
 *  fenixinovation@gmail.com
 *  Copyrigth (C) 2017
 */
package fenixschool.mb;

import fenixschool.dao.CursoDAO;
import fenixschool.dao.DisciplinaDAO;
import fenixschool.dao.DisciplinasDoCursoDAO;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.DisciplinasDoCurso;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "disciplinasDoCursoMBean")
@ViewScoped
public class DisciplinasDoCursoMBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private DisciplinasDoCurso disciplinasDoCurso;
    private DisciplinasDoCursoDAO disciplinasDoCursoDAO;
    private List<DisciplinasDoCurso> disciplinasDoCursos;

    private CursoDAO cursoDAO;
    private List<Curso> cursos;

    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;

    public DisciplinasDoCursoMBean() {
    }

    @PostConstruct
    public void init() {

        disciplinasDoCurso = new DisciplinasDoCurso();
        disciplinasDoCursoDAO = new DisciplinasDoCursoDAO();
        disciplinasDoCursos = new ArrayList<>();

        cursoDAO = new CursoDAO();
        cursos = cursoDAO.findAll();

        disciplinaDAO = new DisciplinaDAO();
        disciplinas = disciplinaDAO.findAll();
    }

    public DisciplinasDoCurso getDisciplinasDoCurso() {
        return disciplinasDoCurso;
    }

    public void setDisciplinasDoCurso(DisciplinasDoCurso disciplinasDoCurso) {
        this.disciplinasDoCurso = disciplinasDoCurso;
    }

    public List<DisciplinasDoCurso> getDisciplinasDoCursos() {
        disciplinasDoCursos = disciplinasDoCursoDAO.findAll();
        return disciplinasDoCursos;
    }

    public void setDisciplinasDoCursos(List<DisciplinasDoCurso> disciplinasDoCursos) {
        this.disciplinasDoCursos = disciplinasDoCursos;
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.findAll();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Disciplina> getDisciplinas() {
        disciplinas = disciplinaDAO.findAll();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void save(ActionEvent event) {
        int controlo = 0;
        disciplinasDoCursoDAO.save(disciplinasDoCurso);
        if (controlo > 0) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            disciplinasDoCurso = new DisciplinasDoCurso();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Erro ao guardar com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void edit(ActionEvent event) {
        int controlo = 0;
        disciplinasDoCursoDAO.update(disciplinasDoCurso);
        disciplinasDoCurso = null;
        if (controlo > 0) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("disciplina_do_curso_listar.jsf");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (IOException e) {
                java.util.logging.Logger.getLogger(DisciplinasDoCursoMBean.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Erro ao actualizar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String delete() {
        disciplinasDoCursoDAO.delete(disciplinasDoCurso);
        disciplinasDoCurso = null;
        return "disciplina_do_curso_listar?faces-redirect=true";
    }

}
