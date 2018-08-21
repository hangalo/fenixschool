/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.DeclaracaoDAO;
import fenixschool.dao.FuncionarioDAO;
import fenixschool.dao.ObjetivoDeclaracaoDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.Declaracao;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.ObjetivoDeclaracao;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
 * @author kulley
 */

@ManagedBean(name = "declaracaoMBean")
@ViewScoped
public class DeclaracaoMBean {
    
    public static final long serialVersionUID = 1L;
    private Declaracao declaracao;
    private DeclaracaoDAO declaracaoDAO;
    private FuncionarioDAO funcionarioDAO;
    private ObjetivoDeclaracaoDAO objetivoDeclaracaoDAO;
    private AlunoDAO alunoDAO;
    private List <Funcionario> funcionarios;
    public List<ObjetivoDeclaracao> objetivoDeclaracaos;
    private List<Aluno> alunos;
    public List<Declaracao> declaracaos;
    
    @PostConstruct
    public void inicializar(){
        declaracao = new Declaracao();
        declaracaoDAO = new DeclaracaoDAO();
        funcionarioDAO = new FuncionarioDAO();
        objetivoDeclaracaoDAO = new ObjetivoDeclaracaoDAO();
        alunoDAO = new AlunoDAO();
        funcionarios = new ArrayList<>();
        objetivoDeclaracaos = new ArrayList<>();
        alunos = new ArrayList<>();
        declaracaos = new ArrayList<>();     
    }

    public DeclaracaoMBean() {
    }

    public Declaracao getDeclaracao() {
        return declaracao;
    }

    public void setDeclaracao(Declaracao declaracao) {
        this.declaracao = declaracao;
    }

    public DeclaracaoDAO getDeclaracaoDAO() {
        return declaracaoDAO;
    }

    public void setDeclaracaoDAO(DeclaracaoDAO declaracaoDAO) {
        this.declaracaoDAO = declaracaoDAO;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public ObjetivoDeclaracaoDAO getObjetivoDeclaracaoDAO() {
        return objetivoDeclaracaoDAO;
    }

    public void setObjetivoDeclaracaoDAO(ObjetivoDeclaracaoDAO objetivoDeclaracaoDAO) {
        this.objetivoDeclaracaoDAO = objetivoDeclaracaoDAO;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<ObjetivoDeclaracao> getObjetivoDeclaracaos() {
        objetivoDeclaracaos = objetivoDeclaracaoDAO.findAll();
        return objetivoDeclaracaos;
    }

    public void setObjetivoDeclaracaos(List<ObjetivoDeclaracao> objetivoDeclaracaos) {
        this.objetivoDeclaracaos = objetivoDeclaracaos;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Declaracao> getDeclaracaos() {
        declaracaos = declaracaoDAO.findAll();
        return declaracaos;
    }

    public void setDeclaracaos(List<Declaracao> declaracaos) {
        this.declaracaos = declaracaos;
    }
    
    public void guardar(ActionEvent evt){
        declaracaoDAO.save(declaracao);
        declaracao = new Declaracao();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Registado com sucesso"));
    }
    
    public void edit (java.awt.event.ActionEvent event){
        declaracaoDAO.update(declaracao);
        declaracaos = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("declaracao_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfissaoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String delete(){
        declaracaoDAO.delete(declaracao);
        declaracaos = null;
        return "declaracao_listar?faces-redirect=true";
    }
    
    
}
