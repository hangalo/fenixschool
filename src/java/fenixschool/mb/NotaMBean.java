/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.AnoCurricularDAO;
import fenixschool.dao.AnoLectivoDAO;
import fenixschool.dao.CicloLectivoDAO;
import fenixschool.dao.ClassificacaoNotaDAO;
import fenixschool.dao.CursoDAO;
import fenixschool.dao.DepartamentoDAO;
import fenixschool.dao.DisciplinaDAO;
import fenixschool.dao.NotaDAO;
import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.dao.TurmaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.ClassificacaoNota;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Nota;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Turma;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "notaMBean")
@SessionScoped
public class NotaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Nota nota;
    private NotaDAO notaDAO;
    private List<Nota> notas;
    private PeriodoLectivoDAO periodoLectivoDAO;
    private List<PeriodoLectivo> periodoLectivos;
    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;
    private CursoDAO cursoDAO;
    private List<Curso> cursos;
    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;
    private AnoLectivoDAO anoLectivoDAO;
    private List<AnoLectivo> anoLectivos;
    private CicloLectivoDAO cicloLectivoDAO;
    private List<CicloLectivo> cicloLectivos;
    private ClassificacaoNotaDAO classificacaoNotaDAO;
    private List<ClassificacaoNota> classificacaoNotas;
    private DepartamentoDAO departamentoDAO;
    private List<Departamento> departamentos;
    private TurmaDAO turmaDAO;
    private List<Turma> turmas;
    private AnoCurricularDAO anoCurricularDAO;
    private List<AnoCurricular> anoCurriculares;

    public NotaMBean() {
    }

    @PostConstruct
    public void inicializar() {
        nota = new Nota();
        notaDAO = new NotaDAO();
        notas = new ArrayList<>();
        periodoLectivoDAO = new PeriodoLectivoDAO();
        periodoLectivos = new ArrayList<>();
        alunoDAO = new AlunoDAO();
        alunos = new ArrayList<>();
        cursoDAO = new CursoDAO();
        cursos = new ArrayList<>();
        disciplinaDAO = new DisciplinaDAO();
        disciplinas = new ArrayList<>();
        anoLectivoDAO = new AnoLectivoDAO();
        anoLectivos = new ArrayList<>();
        cicloLectivoDAO = new CicloLectivoDAO();
        cicloLectivos = new ArrayList<>();
        classificacaoNotaDAO = new ClassificacaoNotaDAO();
        classificacaoNotas = new ArrayList<>();
        departamentoDAO = new DepartamentoDAO();
        departamentos = new ArrayList<>();
        turmaDAO = new TurmaDAO();
        turmas = new ArrayList<>();
        anoCurricularDAO = new AnoCurricularDAO();
        anoCurriculares = new ArrayList<>();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public List<Nota> getNotas() {
        notas = notaDAO.findAll();
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<PeriodoLectivo> getPeriodoLectivos() {
        periodoLectivos = periodoLectivoDAO.findAll();
        return periodoLectivos;
    }

    public void setPeriodoLectivos(List<PeriodoLectivo> periodoLectivos) {
        this.periodoLectivos = periodoLectivos;
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

    public List<Disciplina> getDisciplinas() {
        disciplinas = disciplinaDAO.findAll();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<AnoLectivo> getAnoLectivos() {
        anoLectivos = anoLectivoDAO.findAll();
        return anoLectivos;
    }

    public void setAnoLectivos(List<AnoLectivo> anoLectivos) {
        this.anoLectivos = anoLectivos;
    }

    public List<CicloLectivo> getCicloLectivos() {
        cicloLectivos = cicloLectivoDAO.findAll();
        return cicloLectivos;
    }

    public void setCicloLectivos(List<CicloLectivo> cicloLectivos) {
        this.cicloLectivos = cicloLectivos;
    }

    public List<ClassificacaoNota> getClassificacaoNotas() {
        classificacaoNotas = classificacaoNotaDAO.findAll();
        return classificacaoNotas;
    }

    public void setClassificacaoNotas(List<ClassificacaoNota> classificacaoNotas) {
        this.classificacaoNotas = classificacaoNotas;
    }

    public List<AnoCurricular> getAnoCurriculares() {
        anoCurriculares = anoCurricularDAO.findAll();
        return anoCurriculares;
    }

    public void setAnoCurriculares(List<AnoCurricular> anoCurriculares) {
        this.anoCurriculares = anoCurriculares;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        departamentos = departamentoDAO.findAll();
        this.departamentos = departamentos;
    }

    public List<Turma> getTurmas() {
        turmas = turmaDAO.findAll();
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void guardar(ActionEvent event) {
        notaDAO.save(nota);
        nota = new Nota();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void edit(ActionEvent event) {
        notaDAO.update(nota);
        nota = null;

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("nota_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(NotaMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        notaDAO.delete(nota);
        nota = null;
        return "nota_listar?faces-redirect=true";
    }

}
