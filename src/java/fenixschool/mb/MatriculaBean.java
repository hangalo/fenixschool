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
import fenixschool.dao.CursoDAO;
import fenixschool.dao.FuncionarioDAO;
import fenixschool.dao.LocalEmissaoDocumentoDAO;
import fenixschool.dao.MatriculaDAO;
import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.dao.TipoDocumentoIdentidadeDAO;
import fenixschool.dao.TurmaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.Lingua;
import fenixschool.modelo.LocalEmissaoDocumento;
import fenixschool.modelo.Matricula;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.SituacaoAlunoMatricula;
import fenixschool.modelo.TipoDocumentoIdentidade;
import fenixschool.modelo.Turma;
import fenixschool.util.DateUtil;
import fenixschool.util.GestorImpressao;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author HACKER
 */
@ManagedBean(name = "matriculaBean")
@ViewScoped
public class MatriculaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Matricula matricula;
    private MatriculaDAO matriculaDAO;
    private List<Matricula> matriculas;

    private Aluno aluno;
    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;

    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    private List<Funcionario> funcionarios;

    private Curso curso;
    private CursoDAO cursoDAO;
    private List<Curso> cursos;

    private AnoLectivo anoLetivo;
    private AnoLectivoDAO anoLectivoDAO;
    private List<AnoLectivo> anoLectivos;

    private Turma turma;
    private TurmaDAO turmaDAO;
    private List<Turma> turmas;

    private TipoDocumentoIdentidade tipoDocumentoIdentidade;
    private TipoDocumentoIdentidadeDAO tipoDocumentoIdentidadeDAO;
    private List<TipoDocumentoIdentidade> tipoDocumentoIdentidades;

    private LocalEmissaoDocumento localEmissaoDocumento;
    private LocalEmissaoDocumentoDAO localEmissaoDocumentoDAO;
    private List<LocalEmissaoDocumento> localEmissaoDocumentos;

    private CicloLectivo cicloLectivo;
    private CicloLectivoDAO cicloLectivoDAO;
    private List<CicloLectivo> cicloLectivos;

    private AnoCurricular anoCurricular;
    private AnoCurricularDAO anoCurricularDAO;
    private List<AnoCurricular> anoCurriculars;

    private PeriodoLectivo periodoLectivo;
    private PeriodoLectivoDAO periodoLectivoDAO;
    private List<PeriodoLectivo> periodoLectivos;

    private List<Matricula> listaTurmasAnoLectivo;
    private List<Matricula> listaTurmasAnoLectivoAnoCurricular;
    private List<Matricula> listaTurmasAnoLectivoAnoCurricularCurso;
    private List<Matricula> listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo;

    private String byTurma;

    private String vagasNaTurma;

    @ManagedProperty(value = "#{gestorImpressao}")
    private GestorImpressao gestorImpressao;

    public MatriculaBean() {

    }

    @PostConstruct
    public void inicializar() {
        matricula = new Matricula();
        matriculaDAO = new MatriculaDAO();
        matriculas = new ArrayList<>();

        aluno = new Aluno();
        alunoDAO = new AlunoDAO();
        alunos = new ArrayList<>();

        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();
        funcionarios = new ArrayList<>();

        curso = new Curso();
        cursoDAO = new CursoDAO();
        cursos = new ArrayList<>();

        anoLetivo = new AnoLectivo();
        anoLectivoDAO = new AnoLectivoDAO();
        anoLectivos = new ArrayList<>();

        turma = new Turma();
        turmaDAO = new TurmaDAO();
        turmas = new ArrayList<>();

        tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
        tipoDocumentoIdentidadeDAO = new TipoDocumentoIdentidadeDAO();
        tipoDocumentoIdentidades = new ArrayList<>();

        localEmissaoDocumento = new LocalEmissaoDocumento();
        localEmissaoDocumentoDAO = new LocalEmissaoDocumentoDAO();
        localEmissaoDocumentos = new ArrayList<>();

        cicloLectivo = new CicloLectivo();
        cicloLectivoDAO = new CicloLectivoDAO();
        cicloLectivos = new ArrayList<>();

        anoCurricular = new AnoCurricular();
        anoCurricularDAO = new AnoCurricularDAO();
        anoCurriculars = new ArrayList<>();
        listaTurmasAnoLectivo = new ArrayList<>();
        matricula.setDataMatricula(DateUtil.getDataActual());
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Matricula> getMatriculas() {

        matriculas = matriculaDAO.findAll();
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.findAll();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public AnoLectivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLectivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public AnoLectivoDAO getAnoLectivoDAO() {
        return anoLectivoDAO;
    }

    public void setAnoLectivoDAO(AnoLectivoDAO anoLectivoDAO) {
        this.anoLectivoDAO = anoLectivoDAO;
    }

    public List<AnoLectivo> getAnoLectivos() {
        anoLectivos = anoLectivoDAO.findAll();
        return anoLectivos;
    }

    public void setAnoLectivos(List<AnoLectivo> anoLectivos) {
        this.anoLectivos = anoLectivos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public TurmaDAO getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public List<Turma> getTurmas() {
        turmas = turmaDAO.findAll();
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public TipoDocumentoIdentidade getTipoDocumentoIdentidade() {
        return tipoDocumentoIdentidade;
    }

    public void setTipoDocumentoIdentidade(TipoDocumentoIdentidade tipoDocumentoIdentidade) {
        this.tipoDocumentoIdentidade = tipoDocumentoIdentidade;
    }

    public TipoDocumentoIdentidadeDAO getTipoDocumentoIdentidadeDAO() {
        return tipoDocumentoIdentidadeDAO;
    }

    public void setTipoDocumentoIdentidadeDAO(TipoDocumentoIdentidadeDAO tipoDocumentoIdentidadeDAO) {
        this.tipoDocumentoIdentidadeDAO = tipoDocumentoIdentidadeDAO;
    }

    public List<TipoDocumentoIdentidade> getTipoDocumentoIdentidades() {
        tipoDocumentoIdentidades = tipoDocumentoIdentidadeDAO.findAll();
        return tipoDocumentoIdentidades;
    }

    public void setTipoDocumentoIdentidades(List<TipoDocumentoIdentidade> tipoDocumentoIdentidades) {
        this.tipoDocumentoIdentidades = tipoDocumentoIdentidades;
    }

    public LocalEmissaoDocumento getLocalEmissaoDocumento() {
        return localEmissaoDocumento;
    }

    public void setLocalEmissaoDocumento(LocalEmissaoDocumento localEmissaoDocumento) {
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    public LocalEmissaoDocumentoDAO getLocalEmissaoDocumentoDAO() {
        return localEmissaoDocumentoDAO;
    }

    public void setLocalEmissaoDocumentoDAO(LocalEmissaoDocumentoDAO localEmissaoDocumentoDAO) {
        this.localEmissaoDocumentoDAO = localEmissaoDocumentoDAO;
    }

    public List<LocalEmissaoDocumento> getLocalEmissaoDocumentos() {
        localEmissaoDocumentos = localEmissaoDocumentoDAO.findAll();
        return localEmissaoDocumentos;
    }

    public void setLocalEmissaoDocumentos(List<LocalEmissaoDocumento> localEmissaoDocumentos) {
        this.localEmissaoDocumentos = localEmissaoDocumentos;
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public CicloLectivoDAO getCicloLectivoDAO() {
        return cicloLectivoDAO;
    }

    public void setCicloLectivoDAO(CicloLectivoDAO cicloLectivoDAO) {
        this.cicloLectivoDAO = cicloLectivoDAO;
    }

    public List<CicloLectivo> getCicloLectivos() {
        cicloLectivos = cicloLectivoDAO.findAll();
        return cicloLectivos;
    }

    public void setCicloLectivos(List<CicloLectivo> cicloLectivos) {
        this.cicloLectivos = cicloLectivos;
    }

    public AnoCurricular getAnoCurricular() {
        return anoCurricular;
    }

    public void setAnoCurricular(AnoCurricular anoCurricular) {
        this.anoCurricular = anoCurricular;
    }

    public AnoCurricularDAO getAnoCurricularDAO() {
        return anoCurricularDAO;
    }

    public void setAnoCurricularDAO(AnoCurricularDAO anoCurricularDAO) {
        this.anoCurricularDAO = anoCurricularDAO;
    }

    public List<AnoCurricular> getAnoCurriculars() {
        anoCurriculars = anoCurricularDAO.findAll();
        return anoCurriculars;
    }

    public void setAnoCurriculars(List<AnoCurricular> anoCurriculars) {
        this.anoCurriculars = anoCurriculars;
    }

    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public PeriodoLectivoDAO getPeriodoLectivoDAO() {
        return periodoLectivoDAO;
    }

    public void setPeriodoLectivoDAO(PeriodoLectivoDAO periodoLectivoDAO) {
        this.periodoLectivoDAO = periodoLectivoDAO;
    }

    public List<PeriodoLectivo> getPeriodoLectivos() {
        return periodoLectivos = periodoLectivoDAO.findAll();
    }

    public void setPeriodoLectivos(List<PeriodoLectivo> periodoLectivos) {
        this.periodoLectivos = periodoLectivos;
    }

    public String getVagasNaTurma() {
        return vagasNaTurma;
    }

    public void setVagasNaTurma(String vagasNaTurma) {
        this.vagasNaTurma = vagasNaTurma;
    }

    public GestorImpressao getGestorImpressao() {
        return gestorImpressao;
    }

    public void setGestorImpressao(GestorImpressao gestorImpressao) {
        this.gestorImpressao = gestorImpressao;
    }

    public List<Matricula> getListaTurmasAnoLectivo() {
        return listaTurmasAnoLectivo;
    }

    public void setListaTurmasAnoLectivo(List<Matricula> listaTurmasAnoLectivo) {
        this.listaTurmasAnoLectivo = listaTurmasAnoLectivo;
    }

    public List<Matricula> getListaTurmasAnoLectivoAnoCurricular() {
        return listaTurmasAnoLectivoAnoCurricular;
    }

    public void setListaTurmasAnoLectivoAnoCurricular(List<Matricula> listaTurmasAnoLectivoAnoCurricular) {
        this.listaTurmasAnoLectivoAnoCurricular = listaTurmasAnoLectivoAnoCurricular;
    }

    public List<Matricula> getListaTurmasAnoLectivoAnoCurricularCurso() {
        return listaTurmasAnoLectivoAnoCurricularCurso;
    }

    public void setListaTurmasAnoLectivoAnoCurricularCurso(List<Matricula> listaTurmasAnoLectivoAnoCurricularCurso) {
        this.listaTurmasAnoLectivoAnoCurricularCurso = listaTurmasAnoLectivoAnoCurricularCurso;
    }

    public List<Matricula> getListaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo() {
        return listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo;
    }

    public void setListaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo(List<Matricula> listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo) {
        this.listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo = listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo;
    }

    public List<SelectItem> getOpcaoLingua() {
        List<SelectItem> list = new ArrayList<>();
        for (Lingua lingua : Lingua.values()) {
            list.add(new SelectItem(lingua, lingua.getExtensao()));
        }
        return list;
    }

    public List<SelectItem> getOpcaoSituacaoAlunoMatricula() {
        List<SelectItem> list = new ArrayList<>();
        for (SituacaoAlunoMatricula situacao : SituacaoAlunoMatricula.values()) {
            list.add(new SelectItem(situacao, situacao.getExtensao()));
        }
        return list;
    }

    public void newSave(ActionEvent evt) {
        matricula = new Matricula();
        //return "professor_listar?faces-redirect=true";
    }

    public void carregaVagasDaTurma() {
        Turma turmaCarregada = matricula.getTurma();
        setVagasNaTurma(turmaCarregada.getNumeroMaximoInscritos().toString());
    }

    public void guardar(ActionEvent evt) {

        Aluno alunoNovo = new Aluno();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String numeroAlunoParametro = (String) facesContext.getExternalContext().getRequestParameterMap().get("numeroAluno");

        Turma turmaActual = matricula.getTurma();

        if (numeroAlunoParametro != null) {

            System.out.println(">>>>>>>>>>>>>Id Truma recuperada:\t" + turmaActual.getIdTurma());

            alunoNovo.setIdAluno(Integer.parseInt(numeroAlunoParametro));

            matricula.setAluno(alunoNovo);

            matriculaDAO.save(matricula);

            // decrementa o numero de vagas na turma
            matriculaDAO.decrementaVagas(turmaActual.getIdTurma());

            matricula = new Matricula();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Matricula efectuada com sucesso"));
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Guardar", "Erro ao gravar Matricula"));
        }

        // Depois de guardar a matricula - imprime o boletim de matricula
        imprimirFichaMatricula();

    }

    public String delete() {
        matriculaDAO.delete(matricula);
        matriculas = null;
        return "matricula_gestao?faces-redirect=true";
    }

    public String startEdit() {
        return "matricula_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {

        Aluno alunoNovo = new Aluno();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String numeroAlunoParametro = (String) facesContext.getExternalContext().getRequestParameterMap().get("numeroAluno");

        if (numeroAlunoParametro != null) {

            System.out.println(">>>>>>>>>>>>>Numero Armazenado:\t" + numeroAlunoParametro);

            alunoNovo.setIdAluno(Integer.parseInt(numeroAlunoParametro));

            matricula.setAluno(alunoNovo);
            matriculaDAO.update(matricula);
            matriculas = null;

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("matricula_gestao.jsf");
            } catch (IOException ex) {
                Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Editar", "Erro ao gravar Matricula"));

        }

    }

    public List<Matricula> getMatriculaByTurmaAnoLectivo() {
        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();

        listaTurmasAnoLectivo = matriculaDAO.findByTurmaAnoLectivo(turmaPesquisa.getNomeTurma(), anoLectivoPesquisa.getAnoLectivo());
        return listaTurmasAnoLectivo;
    }

    /*metods adicionados por mim DEU, para imprimir outras listas de turmas com varios parametros*/
    public List<Matricula> getMatriculaByTurmaAnoLectivoAnoCurricular() {
        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();
        AnoCurricular anoCurricularPesquisa = matricula.getAnoCurricular();

        listaTurmasAnoLectivoAnoCurricular = matriculaDAO.findByTurmaAnoLectivoAnoCurricular(turmaPesquisa.getNomeTurma(), anoLectivoPesquisa.getAnoLectivo(), anoCurricularPesquisa.getAnoCurricular());
        return listaTurmasAnoLectivoAnoCurricular;
    }

    public List<Matricula> getMatriculaByTurmaAnoLectivoAnoCurricularCurso() {
        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();
        AnoCurricular anoCurricularPesquisa = matricula.getAnoCurricular();
        Curso cursoPesquisa = matricula.getCurso();

        listaTurmasAnoLectivoAnoCurricularCurso = matriculaDAO.findByTurmaAnoLectivoAnoCurricularCurso(turmaPesquisa.getNomeTurma(), anoLectivoPesquisa.getAnoLectivo(), anoCurricularPesquisa.getAnoCurricular(), cursoPesquisa.getNomeCurso());
        return listaTurmasAnoLectivoAnoCurricularCurso;
    }

    public List<Matricula> getMatriculaByTurmaAnoLectivoAnoCurricularCursoPeriodoLetivo() {
        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();
        AnoCurricular anoCurricularPesquisa = matricula.getAnoCurricular();
        Curso cursoPesquisa = matricula.getCurso();
        PeriodoLectivo periodoLectivoPesquisa = turma.getPeriodoLectivo();
        turma.setPeriodoLectivo(periodoLectivo);
        matricula.setTurma(turma);
        listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo = matriculaDAO.findByTurmaAnoLectivoAnoCurricularCursoPeriodoLetivo(turmaPesquisa.getNomeTurma(), anoLectivoPesquisa.getAnoLectivo(), anoCurricularPesquisa.getAnoCurricular(), cursoPesquisa.getNomeCurso(), periodoLectivoPesquisa.getPeriodoLectivo());
        return listaTurmasAnoLectivoAnoCurricularCursoPeriodoLetivo;
    }

    /*fim*/
    public List<Matricula> getMatriculaByTurma() {

        matriculas = matriculaDAO.findByTurma(byTurma);
        return matriculas;
    }

    public String getByTurma() {
        return byTurma;
    }

    public void setByTurma(String byTurma) {
        this.byTurma = byTurma;
    }

    public String imprimirFichaMatricula() {

        Integer ultimaMatricula = matriculaDAO.buscaUltimaMatriculaFeita();
        System.out.println(">>>>>>>>imprimirFichaMatricula()" + ultimaMatricula);
        String relatorio = "matricula_ficha.jasper";
        HashMap parametros = new HashMap();
        parametros.put("numeroMatricula", ultimaMatricula);
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

    public String imprimirListaTurma() {

        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();

        System.out.println(">>>>>>>>Ano Lectivo()" + anoLectivoPesquisa.getAnoLectivo());

        System.out.println(">>>>>>>>Ano Lectivo()" + turmaPesquisa.getNomeTurma());
        String relatorio = "alunos_por_turma.jasper";
        HashMap parametros = new HashMap();
        parametros.put("anoLectivo", anoLectivoPesquisa.getAnoLectivo());
        parametros.put("turma", turmaPesquisa.getNomeTurma());
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

    public String imprimirCartoesTurma() {

        Turma turmaPesquisa = matricula.getTurma();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();

        System.out.println(">>>>>>>>Ano Lectivo()" + anoLectivoPesquisa.getAnoLectivo());

        System.out.println(">>>>>>>>Ano Lectivo()" + turmaPesquisa.getNomeTurma());
        String relatorio = "cartao_aluno.jasper";
        HashMap parametros = new HashMap();
        parametros.put("anoLectivo", anoLectivoPesquisa.getAnoLectivo());
        parametros.put("turma", turmaPesquisa.getNomeTurma());
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

    /*metods adicionados por mim DEU, para imprimir outras listas de turmas dos relatorios pdf*/
    public String imprimirListaTurmaAnoLetivoAnoCurricularCurso() {

        AnoCurricular anoCurricularPesquisa = matricula.getAnoCurricular();
        Turma turmaPesquisa = matricula.getTurma();
        Curso cursoPesquisa = matricula.getCurso();
        AnoLectivo anoLectivoPesquisa = matricula.getAnoLetivo();

        System.out.println(">>>>>>>>Ano Curricular()" + anoCurricularPesquisa.getAnoCurricular());
        System.out.println(">>>>>>>>Turma()" + turmaPesquisa.getNomeTurma());
        System.out.println(">>>>>>>>Curso()" + cursoPesquisa.getNomeCurso());
        System.out.println(">>>>>>>>Ano Lectivo()" + anoLectivoPesquisa.getAnoLectivo());

        String relatorio = "alunosMatriculadosBuscarPorClasseTurmaCursoAnoLetivo.jasper";
        HashMap parametros = new HashMap();

     
        parametros.put("anoCurricularPesquisa", anoCurricularPesquisa.getAnoCurricular());
        parametros.put("turmaPesquisa", turmaPesquisa.getNomeTurma());
        parametros.put("cursoPesquisa", cursoPesquisa.getNomeCurso());
        parametros.put("anoLectivoPesquisa", anoLectivoPesquisa.getAnoLectivo());

        gestorImpressao.imprimirPDF(relatorio, parametros);
       
        return null;

    }
}
