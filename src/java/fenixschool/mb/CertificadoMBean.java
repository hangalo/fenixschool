/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.AnoCurricularDAO;
import fenixschool.dao.CertificadoDAO;
import fenixschool.dao.FuncionarioDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.Certificado;
import fenixschool.modelo.Funcionario;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aisha Lubadika
 */
@ManagedBean(name = "certificadoMBean")
@SessionScoped
public class CertificadoMBean implements Serializable{

     private static final long serialVersionUID = 1L;
    
    private Certificado certificado;
    private CertificadoDAO certificadoDAO;
    private List<Certificado> certificados;
    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;
    private FuncionarioDAO funcionarioDAO;
    private List <Funcionario> funcionarios;
    private AnoCurricularDAO anoCurricularDAO;
    private List <AnoCurricular> anoCurriculares;
    
    public CertificadoMBean() {
    }

    @PostConstruct
    public void inicializar() {
        certificado = new Certificado();
        certificadoDAO = new CertificadoDAO();
        certificados = new ArrayList<>();
        alunoDAO = new AlunoDAO();
        funcionarios = new ArrayList<>();
        alunos = new ArrayList<>();
        funcionarioDAO = new FuncionarioDAO();
        funcionarios = new ArrayList<>();
        anoCurricularDAO = new AnoCurricularDAO();
        anoCurriculares = new ArrayList<>();
        
 
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
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

    public AnoCurricularDAO getAnoCurricularDAO() {
        return anoCurricularDAO;
    }

    public void setAnoCurricularDAO(AnoCurricularDAO anoCurricularDAO) {
        this.anoCurricularDAO = anoCurricularDAO;
    }

    public List<AnoCurricular> getAnoCurriculares() {
        anoCurriculares = anoCurricularDAO.findAll();
        return anoCurriculares;
    }

    public void setAnoCurriculares(List<AnoCurricular> anoCurriculares) {
        this.anoCurriculares = anoCurriculares;
    }
    
    
    public CertificadoDAO getCertificadoDAO() {
        return certificadoDAO;
    }

    public void setCertificadoDAO(CertificadoDAO certificadoDAO) {
        this.certificadoDAO = certificadoDAO;
    }

    public List<Certificado> getCertificados() {
        certificados = certificadoDAO.findAll();
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }
    
    public String newSave() {
        certificado = new Certificado();
        return null;
    }
    
    public void guardar(ActionEvent evt) {
        certificadoDAO.save(certificado);
        certificado = new Certificado();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Certificado guardado com sucesso"));
    }
    public String startEdit() {
        return "certificado_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        certificadoDAO.update(certificado);
        certificados = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("certificado_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CertificadoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        certificadoDAO.delete(certificado);
        certificados = null;
        return "certificado_listar?faces-redirect=true";
    }   
}
