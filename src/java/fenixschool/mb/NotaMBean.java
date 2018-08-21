/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.AnoCurricularDAO;
import fenixschool.dao.AnoLectivoDAO;
import fenixschool.dao.BoletimNotaDAO;
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
import fenixschool.modelo.BoletimNota;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.ClassificacaoNota;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Nota;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Turma;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "notaMBean")
@ViewScoped
public class NotaMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Nota nota;
    private NotaDAO notaDAO;
    private List<Nota> notas;
    private List<Nota> listOfAlunos;
    private List<Nota> emitirBoletins;//Para emissao de Boletins de notas do alunos

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

    //variaveis auxiliares
    private String curso;
    private String disciplina;
    private Integer classe;
    private Integer turma;
    private Integer anoLetivo;
    private Integer peridoLetivo;
    private Integer cicloLetivo;
    //------------------------

    //Para editar tabela
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

        listOfAlunos = new ArrayList<>();

        emitirBoletins = new ArrayList<>();
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

    public List<AnoCurricular> getAnoCurriculares() {
        anoCurriculares = anoCurricularDAO.findAll();
        return anoCurriculares;
    }

    public void setAnoCurriculares(List<AnoCurricular> anoCurriculares) {
        this.anoCurriculares = anoCurriculares;
    }

    public void guardar(ActionEvent event) {
        guardarBoletimNotas();
        capturarAluno();
        if (notaDAO.existe(nota)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! A informação que deseja inserir já existe.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            nota = new Nota();
        } else if (notaDAO.save(nota)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            nota = new Nota();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String edit(ActionEvent event) {
        capturarAluno();
        if (notaDAO.update(nota)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            nota = null;
            return "nota_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

    public String delete() {
        if (notaDAO.delete(nota)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluir", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            nota = null;
            return "nota_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

    public void capturarAluno() {

        Aluno aluno = new Aluno();
        FacesContext context = FacesContext.getCurrentInstance();
        String idAluno = (String) context.getExternalContext().getRequestParameterMap().get("idAluno");

        if (idAluno != null) {
            System.out.println("Numero capturado >>>>>>>>> " + idAluno);
            aluno.setIdAluno(Integer.parseInt(idAluno));
            nota.setAluno(aluno);
        }
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getClasse() {
        return classe;
    }

    public void setClasse(Integer classe) {
        this.classe = classe;
    }

    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Integer getPeridoLetivo() {
        return peridoLetivo;
    }

    public void setPeridoLetivo(Integer peridoLetivo) {
        this.peridoLetivo = peridoLetivo;
    }

    public Integer getCicloLetivo() {
        return cicloLetivo;
    }

    public void setCicloLetivo(Integer cicloLetivo) {
        this.cicloLetivo = cicloLetivo;
    }

    public List<Nota> getListOfAlunos() {
        if (curso != null && disciplina != null && classe != null && turma != null && anoLetivo != null && peridoLetivo != null && cicloLetivo != null) {
            listOfAlunos = notaDAO.findAllOfTurmas(curso, disciplina, classe, turma, anoLetivo, peridoLetivo, cicloLetivo);

        }
        return listOfAlunos;
    }

    public void setListOfAlunos(List<Nota> listOfAlunos) {
        this.listOfAlunos = listOfAlunos;
    }

    public List<Nota> getEmitirBoletins() {
        if (peridoLetivo != null && turma != null && anoLetivo != null && classe != null) {
            System.out.println("perido lectivo:(" + peridoLetivo + ") Turma:(" + turma + ") Ano lectivo:(" + anoLetivo + ") Classe:(" + classe + ")");
            emitirBoletins = notaDAO.findTumaPeridodo(peridoLetivo, turma, anoLetivo, classe);
            return emitirBoletins;
        } else {
            return null;
        }
    }

    public void setEmitirBoletins(List<Nota> emitirBoletins) {
        this.emitirBoletins = emitirBoletins;
    }

    //Metodo para inserir dados na tabela boletim de notas
    public void guardarBoletimNotas() {
        Aluno aluno = new Aluno();
        BoletimNota boletim = new BoletimNota();
        FacesContext context = FacesContext.getCurrentInstance();
        String idAluno = (String) context.getExternalContext().getRequestParameterMap().get("idAluno");

        if (idAluno != null) {
            System.out.println("Numero capturado para Boletim >>>>>>>>> " + idAluno);
            aluno.setIdAluno(Integer.parseInt(idAluno));
            boletim.setAluno(aluno);
            boletim.setDataBoletim(LocalDate.now());
        }

        BoletimNotaDAO boletimDAO = new BoletimNotaDAO();
        boletimDAO.save(boletim);
    }

}
