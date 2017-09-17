/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AnoLectivoDAO;
import fenixschool.dao.CicloLectivoDAO;
import fenixschool.dao.CursoDAO;
import fenixschool.dao.DisciplinaDAO;
import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.dao.TipoDisciplinaDAO;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.TipoDisciplina;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "disciplinaMBean")
@SessionScoped
public class DisciplinaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Disciplina disciplina;
    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;

    private CursoDAO cursoDAO;
    private List<Curso> cursos;

    private AnoLectivoDAO anoLectivoDAO;
    private List<AnoLectivo> anoLectivos;

    private PeriodoLectivoDAO periodoLectivoDAO;
    private List<PeriodoLectivo> periodoLectivos;

    private CicloLectivoDAO cicloLectivoDAO;
    private List<CicloLectivo> cicloLectivos;

    private TipoDisciplinaDAO tipoDisciplinaDAO;
    private List<TipoDisciplina> tipoDisciplinas;

    public DisciplinaMBean() {
    }

    @PostConstruct
    public void inicializar() {

        disciplina = new Disciplina();
        disciplinaDAO = new DisciplinaDAO();
        disciplinas = new ArrayList<>();

        cursoDAO = new CursoDAO();
        cursos = new ArrayList<>();

        anoLectivoDAO = new AnoLectivoDAO();
        anoLectivos = new ArrayList<>();

        periodoLectivoDAO = new PeriodoLectivoDAO();
        periodoLectivos = new ArrayList<>();

        cicloLectivoDAO = new CicloLectivoDAO();
        cicloLectivos = new ArrayList<>();

        tipoDisciplinaDAO = new TipoDisciplinaDAO();
        tipoDisciplinas = new ArrayList<>();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        disciplinas = disciplinaDAO.findAll();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.findAll();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<AnoLectivo> getAnoLectivos() {
        anoLectivos = anoLectivoDAO.findAll();
        return anoLectivos;
    }

    public void setAnoLectivos(List<AnoLectivo> anoLectivos) {
        this.anoLectivos = anoLectivos;
    }
    
    

    public List<PeriodoLectivo> getPeriodoLectivos() {
        periodoLectivos = periodoLectivoDAO.findAll();
        return periodoLectivos;
    }

    public void setPeriodoLectivos(List<PeriodoLectivo> periodoLectivos) {
        this.periodoLectivos = periodoLectivos;
    }

    public List<CicloLectivo> getCicloLectivos() {
        cicloLectivos = cicloLectivoDAO.findAll();
        return cicloLectivos;
    }

    public void setCicloLectivos(List<CicloLectivo> cicloLectivos) {
        this.cicloLectivos = cicloLectivos;
    }

    public List<TipoDisciplina> getTipoDisciplinas() {
        tipoDisciplinas = tipoDisciplinaDAO.findAll();
        return tipoDisciplinas;
    }

    public void setTipoDisciplinas(List<TipoDisciplina> tipoDisciplinas) {
        this.tipoDisciplinas = tipoDisciplinas;
    }

    public void guardar(ActionEvent event) {
        disciplinaDAO.save(disciplina);
        disciplina = new Disciplina();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Guardar","Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void edit(ActionEvent event) {
        disciplinaDAO.update(disciplina);
        disciplina = null;

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("disciplina_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(DisciplinaMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String delete(){
        disciplinaDAO.delete(disciplina);
        disciplina = null;
        return "disciplina_listar?faces-redirect=true";
    }
}
