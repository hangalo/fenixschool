/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.BoletimNotaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.BoletimNota;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@ManagedBean(name = "boletimMBean")
@ViewScoped
public class BoletimNotaMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BoletimNota boletim;
    private BoletimNotaDAO boletimDAO;
    private List<BoletimNota> lista;

    private List<Aluno> alunos;
    private AlunoDAO alunoDAO;

    public BoletimNotaMBean() {
    }

    @PostConstruct
    public void init() {
        boletim = new BoletimNota();
        boletimDAO = new BoletimNotaDAO();
        lista = new ArrayList<>();

        alunos = new ArrayList<>();
        alunoDAO = new AlunoDAO();

    }

    public BoletimNota getBoletim() {
        return boletim;
    }

    public void setBoletim(BoletimNota boletim) {
        this.boletim = boletim;
    }

    public List<BoletimNota> getLista() {
        lista = boletimDAO.findAll();
        return lista;
    }

    public void setLista(List<BoletimNota> lista) {
        this.lista = lista;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void save(ActionEvent event) {
        if (boletimDAO.save(boletim)) {
            FacesMessage successfull = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Registo guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, successfull);
            boletim = new BoletimNota();
        } else {
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Erro inexperado. Não guardado.");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }

    public void update(ActionEvent event) {
        if (boletimDAO.update(boletim)) {
            FacesMessage successfull = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Registo actualizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, successfull);
            boletim = null;

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("boletimnotas_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(BoletimNotaMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar", "Erro inexperado. Não actualizar.");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }

    public String delete() {
        if (boletimDAO.delete(boletim)) {
            FacesMessage successfull = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluir", "Registo excluido com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, successfull);
            boletim = null;
            return "boletimnotas_listar?faces-redirect=true";
        } else {
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Excluir", "Erro inexperado. Não excluir.");
            FacesContext.getCurrentInstance().addMessage(null, error);
            return null;
        }
    }
}
