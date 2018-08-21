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
import fenixschool.util.GestorImpressao;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;



/**
 *
 * @author PENA
 */
@ManagedBean(name = "disciplinasDoCursoMBean")
@ViewScoped
public class DisciplinasDoCursoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private DisciplinasDoCurso disciplinasDoCurso;
    private DisciplinasDoCursoDAO disciplinasDoCursoDAO;
    private List<DisciplinasDoCurso> disciplinasDoCursos;

    private CursoDAO cursoDAO;
    private List<Curso> cursos;

    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;
    private List<DisciplinasDoCurso> discipCursos;

    private String curso;

    @ManagedProperty(value = "#{gestorImpressao}")
    private GestorImpressao gestorImpressao;

    public DisciplinasDoCursoMBean() {
    }

    @PostConstruct
    public void init() {

        disciplinasDoCurso = new DisciplinasDoCurso();
        disciplinasDoCursoDAO = new DisciplinasDoCursoDAO();
        discipCursos = disciplinasDoCursoDAO.findByCurso(curso);
        disciplinasDoCursos = disciplinasDoCursoDAO.findAll();
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
        // if (!curso.isEmpty()) {
        disciplinasDoCursos = disciplinasDoCursoDAO.findAll();
        return disciplinasDoCursos;
        // }

        //return null;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<DisciplinasDoCurso> getDiscipCursos() {
        if (curso != null) {
            discipCursos = disciplinasDoCursoDAO.findByCurso(curso);
            return discipCursos;
        }
        return null;
    }

    public void setDiscipCursos(List<DisciplinasDoCurso> discipCursos) {
        this.discipCursos = discipCursos;
    }

    public GestorImpressao getGestorImpressao() {
        return gestorImpressao;
    }

    public void setGestorImpressao(GestorImpressao gestorImpressao) {
        this.gestorImpressao = gestorImpressao;
    }

    public void save(ActionEvent event) {
        disciplinasDoCursoDAO.save(disciplinasDoCurso);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        disciplinasDoCurso = new DisciplinasDoCurso();
    }

    public void edit(ActionEvent event) {
        disciplinasDoCursoDAO.update(disciplinasDoCurso);
        disciplinasDoCurso = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("disciplina_do_curso_listar.jsf");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(DisciplinasDoCursoMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        disciplinasDoCursoDAO.delete(disciplinasDoCurso);
        disciplinasDoCurso = null;
        return "disciplina_do_curso_listar?faces-redirect=true";
    }

    public String imprimirDisciplinaPorCurso() {
        String relatorio = "disciplina_curso.jasper";
        HashMap parametro = new HashMap();
        parametro.put("codigo_curso", disciplinasDoCurso.getCurso().getCodigoCurso());
        gestorImpressao.imprimirPDF(relatorio, parametro);
        return null;
    }

}
