/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.AlunoEncarregadoDAO;
import fenixschool.dao.EncarregadoEducacaoDAO;
import fenixschool.dao.ParentescoDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.AlunoEncarregadoEducacao;
import fenixschool.modelo.EncarregadoEducacao;
import fenixschool.modelo.Parentesco;
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
@ManagedBean(name = "alunoEncarregadoMBean")
@ViewScoped
public class AlunoEncarregadoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AlunoEncarregadoDAO alunoEncarregadoDAO;
    private AlunoEncarregadoEducacao alunoEncarregado;
    private List<AlunoEncarregadoEducacao> alunoEncarregadoEducacaos;

    private EncarregadoEducacaoDAO encarredaoEducacaoDAO;
    private List<EncarregadoEducacao> encarregadoEducacaos;

    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;

    private ParentescoDAO parentescoDAO;
    private List<Parentesco> parentescos;

    public AlunoEncarregadoMBean() {
    }

    @PostConstruct
    public void initialize() {

        alunoEncarregadoDAO = new AlunoEncarregadoDAO();
        alunoEncarregado = new AlunoEncarregadoEducacao();
        alunoEncarregadoEducacaos = new ArrayList<>();

        encarredaoEducacaoDAO = new EncarregadoEducacaoDAO();
        encarregadoEducacaos = new ArrayList<>();

        alunoDAO = new AlunoDAO();
        alunos = new ArrayList<>();

        parentescoDAO = new ParentescoDAO();
        parentescos = new ArrayList<>();
    }

    public AlunoEncarregadoEducacao getAlunoEncarregado() {
        return alunoEncarregado;
    }

    public void setAlunoEncarregado(AlunoEncarregadoEducacao alunoEncarregado) {
        this.alunoEncarregado = alunoEncarregado;
    }

    public List<AlunoEncarregadoEducacao> getAlunoEncarregadoEducacaos() {
        alunoEncarregadoEducacaos = alunoEncarregadoDAO.findAll();
        return alunoEncarregadoEducacaos;
    }

    public void setAlunoEncarregadoEducacaos(List<AlunoEncarregadoEducacao> alunoEncarregadoEducacaos) {
        this.alunoEncarregadoEducacaos = alunoEncarregadoEducacaos;
    }

    public List<EncarregadoEducacao> getEncarregadoEducacaos() {
        encarregadoEducacaos = encarredaoEducacaoDAO.findAll();
        return encarregadoEducacaos;
    }

    public void setEncarregadoEducacaos(List<EncarregadoEducacao> encarregadoEducacaos) {
        this.encarregadoEducacaos = encarregadoEducacaos;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Parentesco> getParentescos() {
        parentescos = parentescoDAO.findAll();
        return parentescos;
    }

    public void setParentescos(List<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public void save(ActionEvent event) {
        Aluno aluno = new Aluno();
        FacesContext faceCont = FacesContext.getCurrentInstance();
        String numeroAluno = (String) faceCont.getExternalContext().getRequestParameterMap().get("numeroAluno");
        if (numeroAluno != null) {
            System.out.println(">>>>>>>>>>>>>>>Número do aluno armazenado " + numeroAluno);
            aluno.setIdAluno(Integer.parseInt(numeroAluno));
            alunoEncarregado.setAluno(aluno);
            alunoEncarregadoDAO.save(alunoEncarregado);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Registro guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            alunoEncarregado = new AlunoEncarregadoEducacao();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Guardar", "Erro ao guardar registro");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void edit(ActionEvent event) {
        Aluno aluno = new Aluno();
        FacesContext faceCont = FacesContext.getCurrentInstance();
        String numeroAluno = (String) faceCont.getExternalContext().getRequestParameterMap().get("numeroAluno");
        if (numeroAluno != null) {
            System.out.println(">>>>>>>>>>>>>>>Número do aluno armazenado " + numeroAluno);
            aluno.setIdAluno(Integer.parseInt(numeroAluno));
            alunoEncarregado.setAluno(aluno);
            alunoEncarregadoDAO.update(alunoEncarregado);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", alunoEncarregado.getAluno().getNomeAluno() + " Actualizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            alunoEncarregado = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("alunoEncarregado_listar.jsf");
            } catch (IOException e) {
                java.util.logging.Logger.getLogger(AlunoEncarregadoMBean.class.getName()).log(Level.SEVERE, null, e);
            }

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Actualizar", "Erro ao actualizar " + alunoEncarregado.getAluno().getNomeAluno() + "!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String delete() {
        alunoEncarregadoDAO.delete(alunoEncarregado);
        alunoEncarregado = null;
        return "alunoEncarregado_listar?faces-redirect=true";
    }

}
