/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.AnoLectivoDAO;
import fenixschool.dao.CicloLectivoDAO;
import fenixschool.dao.CursoDAO;
import fenixschool.dao.DepartamentoDAO;
import fenixschool.dao.MensalidadeDAO;
import fenixschool.dao.MesDAO;
import fenixschool.dao.TurmaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Mensalidade;
import fenixschool.modelo.Mes;
import fenixschool.modelo.Turma;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Elísio Kavaimunwa
 */
@ManagedBean(name = "mensalidadeMBean")
@SessionScoped
public class MensalidadeMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Mensalidade mensalidade;
    private MensalidadeDAO mensalidadeDAO;
    private AnoLectivoDAO anoletivoDAO;
    private DepartamentoDAO departamentoDAO;
    private TurmaDAO turmaDAO;
    private CicloLectivoDAO cicloLectivoDAO;
    private MesDAO mesDAO;
    private AlunoDAO alunoDAO;
    private CursoDAO cursoDAO;
    private List<Mensalidade> mensalidades;
    private List<AnoLectivo> anoletivos;
    private List<Departamento> departamentos;
    private List<Turma> turmas;
    private List<CicloLectivo> cicloLetivos;
    private List<Mes> meses;
    private List<Aluno> alunos;
    private List<Curso> cursos;

    public MensalidadeMBean() {
    }

    @PostConstruct
    public void inicializar() {
        mensalidade = new Mensalidade();
        mensalidadeDAO = new MensalidadeDAO();
        anoletivoDAO = new AnoLectivoDAO();
        departamentoDAO = new DepartamentoDAO();
        turmaDAO = new TurmaDAO();
        cicloLectivoDAO = new CicloLectivoDAO();
        mesDAO = new MesDAO();
        alunoDAO = new AlunoDAO();
        cursoDAO = new CursoDAO();

        mensalidades = new ArrayList<>();
        anoletivos = new ArrayList<>();
        departamentos = new ArrayList<>();
        turmas = new ArrayList<>();
        cicloLetivos = new ArrayList<>();
        meses = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    public List<Mensalidade> getMensalidades() {
        mensalidades = mensalidadeDAO.findAll();
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    public List<AnoLectivo> getAnoletivos() {
        anoletivos = anoletivoDAO.findAll();
        return anoletivos;
    }

    public void setAnoletivos(List<AnoLectivo> anoletivos) {
        this.anoletivos = anoletivos;
    }

    public List<Departamento> getDepartamentos() {
        departamentos = departamentoDAO.findAll();
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Turma> getTurmas() {
        turmas = turmaDAO.findAll();
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<CicloLectivo> getCicloLetivos() {
        cicloLetivos = cicloLectivoDAO.findAll();
        return cicloLetivos;
    }

    public void setCicloLetivos(List<CicloLectivo> cicloLetivos) {
        this.cicloLetivos = cicloLetivos;
    }

    public List<Mes> getMeses() {
        meses = mesDAO.findAll();
        return meses;
    }

    public void setMeses(List<Mes> meses) {
        this.meses = meses;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.findAll();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String newSave() {
        mensalidade = new Mensalidade();
        return "mensalidade_listar?faces-redirect=true";
    }

    public void guardar(ActionEvent evt) {
        if (mensalidadeDAO.save(mensalidade)) {
            mensalidade = new Mensalidade();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }

    public String startEdit() {
        return "mensalidade_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (mensalidadeDAO.update(mensalidade)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            mensalidades = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("mensalidade_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(MensalidadeMBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }

    }

    public String delete() {
        if (mensalidadeDAO.delete(mensalidade)) {
            mensalidades = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            
            return "mensalidade_listar?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;
        }

    }

}
