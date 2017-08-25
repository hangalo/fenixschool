/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.BoletimNotasDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.BoletimNotas;
import java.io.IOException;
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
@ManagedBean(name = "boletimNotasMBean")
@SessionScoped
public class BoletimNotasMBean {

    private BoletimNotas boletimNota;
    private BoletimNotasDAO boletimNotaDAO;
    private List<BoletimNotas> boletinsNotas;
    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;

    public BoletimNotasMBean() {
    }

    @PostConstruct
    public void inicializar() {

        boletimNota = new BoletimNotas();
        boletimNotaDAO = new BoletimNotasDAO();
        boletinsNotas = new ArrayList<>();
        alunoDAO = new AlunoDAO();
        alunos = new ArrayList<>();
    }

    public BoletimNotas getBoletimNota() {
        return boletimNota;
    }

    public void setBoletimNota(BoletimNotas boletimNota) {
        this.boletimNota = boletimNota;
    }

    public List<BoletimNotas> getBoletinsNotas() {
        boletinsNotas = boletimNotaDAO.findAll();
        return boletinsNotas;
    }

    public void setBoletinsNotas(List<BoletimNotas> boletinsNotas) {
        this.boletinsNotas = boletinsNotas;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void guardar(ActionEvent event) {

        boletimNotaDAO.save(boletimNota);
        boletimNota = new BoletimNotas();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guadar", "Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void edit(ActionEvent event) {

        boletimNotaDAO.update(boletimNota);
        boletimNota = null;

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("boletimnotas_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(BoletimNotasMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        boletimNotaDAO.delete(boletimNota);
        boletimNota = null;
        return "boletimnotas_listar?faces-redirect=true";
    }
}
