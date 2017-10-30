/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.FuncionarioDAO;
import fenixschool.dao.SituacaoTransferenciaDAO;
import fenixschool.dao.TransferenciaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.SituacaoTransferencia;
import fenixschool.modelo.Transferencia;
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
@ManagedBean(name = "transferenciaMBean")
@ViewScoped
public class TransferenciaMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Transferencia transferencia;
    private TransferenciaDAO transferenciaDAO;
    private List<Transferencia> transferencias;

    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;

    private FuncionarioDAO funcionarioDAO;
    private List<Funcionario> funcionarios;

    private SituacaoTransferenciaDAO situacaoTransferenciaDAO;
    private List<SituacaoTransferencia> situacaoTransferencias;

    public TransferenciaMBean() {
    }

    @PostConstruct
    public void inicializar() {
        transferencia = new Transferencia();
        transferenciaDAO = new TransferenciaDAO();
        transferencias = new ArrayList<>();

        alunoDAO = new AlunoDAO();
        alunos = new ArrayList<>();

        funcionarioDAO = new FuncionarioDAO();
        funcionarios = new ArrayList<>();

        situacaoTransferenciaDAO = new SituacaoTransferenciaDAO();
        situacaoTransferencias = new ArrayList<>();
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public List<Transferencia> getTransferencias() {
        transferencias = transferenciaDAO.findAll();
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<SituacaoTransferencia> getSituacaoTransferencias() {
        situacaoTransferencias = situacaoTransferenciaDAO.findAll();
        return situacaoTransferencias;
    }

    public void setSituacaoTransferencias(List<SituacaoTransferencia> situacaoTransferencias) {
        this.situacaoTransferencias = situacaoTransferencias;
    }

    public void guardar(ActionEvent event) {

        Aluno aluno = new Aluno();
        FacesContext facesConte = FacesContext.getCurrentInstance();
        String numeroDoALuno = (String) facesConte.getExternalContext().getRequestParameterMap().get("numeroAluno");
        if (numeroDoALuno != null) {

            System.out.println(">>>>>>>>>>>>>Numero Armazenado:\t" + numeroDoALuno);
            aluno.setIdAluno(Integer.parseInt(numeroDoALuno));
            transferencia.setAluno(aluno);
            transferenciaDAO.save(transferencia);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", transferencia.getAluno().getNomeAluno() + " Guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            transferencia = new Transferencia();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Guardar", "Erro ao guardar " + transferencia.getAluno().getNomeAluno() + "!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void edit(ActionEvent event) {
        Aluno aluno = new Aluno();
        FacesContext facesConte = FacesContext.getCurrentInstance();
        String numeroDoALuno = (String) facesConte.getExternalContext().getRequestParameterMap().get("numeroAluno");
        if (numeroDoALuno != null) {

            System.out.println(">>>>>>>>>>>>>Numero Armazenado:\t" + numeroDoALuno);
            aluno.setIdAluno(Integer.parseInt(numeroDoALuno));
            transferencia.setAluno(aluno);
            transferenciaDAO.update(transferencia);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", transferencia.getAluno().getNomeAluno() + " Actualizado  com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            transferencia = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("transferencia_listar.jsf");
            } catch (IOException e) {
                java.util.logging.Logger.getLogger(TransferenciaMBean.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Actualizar", "Erro ao actualizar " + transferencia.getAluno().getNomeAluno() + "!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String delete() {
        transferenciaDAO.delete(transferencia);
        transferencia = null;
        return "transferencia_listar?faces-redirect=true";
    }

}
