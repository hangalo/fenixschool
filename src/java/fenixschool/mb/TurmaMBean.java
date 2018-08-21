/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AnoLectivoDAO;
import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.dao.SalaDAO;
import fenixschool.dao.TurmaDAO;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Sala;
import fenixschool.modelo.Turma;
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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aisha Lubadika
 */
@ManagedBean(name = "turmaMBean")
@ViewScoped
public class TurmaMBean implements Serializable  {
    
 public static final long serialVersionUID = 1L;
     
     private  Turma turma = new Turma();
     private TurmaDAO turmaDAO;
     private AnoLectivoDAO anoLectivoDAO;
     private PeriodoLectivoDAO periodoLectivoDAO;
     private SalaDAO salaDAO;
     private List<Turma> turmas;
     private List<AnoLectivo> anoLectivos;
     private List<PeriodoLectivo> periodoLectivos;
     private List<Sala> salas;
   
     public TurmaMBean() {
    }
     
     @PostConstruct
    public void inicializar() {
    turmaDAO = new TurmaDAO();
    anoLectivoDAO = new AnoLectivoDAO();
    periodoLectivoDAO= new PeriodoLectivoDAO();
    salaDAO = new SalaDAO();
    turmas = new ArrayList<>();
    anoLectivos= new ArrayList<>();
    periodoLectivos= new ArrayList<>();
    salas= new ArrayList<>();
    
    
    
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

    public AnoLectivoDAO getAnoLectivoDAO() {
        return anoLectivoDAO;
    }

    public void setAnoLectivoDAO(AnoLectivoDAO anoLectivoDAO) {
        this.anoLectivoDAO = anoLectivoDAO;
    }

    public PeriodoLectivoDAO getPeriodoLectivoDAO() {
        return periodoLectivoDAO;
    }

    public void setPeriodoLectivoDAO(PeriodoLectivoDAO periodoLectivoDAO) {
        this.periodoLectivoDAO = periodoLectivoDAO;
    }

    public SalaDAO getSalaDAO() {
        return salaDAO;
    }

    public void setSalaDAO(SalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    public List<Turma> getTurmas() {
        turmas= turmaDAO.findAll();
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<AnoLectivo> getAnoLectivos() {
        anoLectivos= anoLectivoDAO.findAll();
        return anoLectivos;
    }

    public void setAnoLectivos(List<AnoLectivo> anoLectivos) {
        this.anoLectivos = anoLectivos;
    }

    public List<PeriodoLectivo> getPeriodoLectivos() {
        periodoLectivos= periodoLectivoDAO.findAll();
        return periodoLectivos;
    }

    public void setPeriodoLectivos(List<PeriodoLectivo> periodoLectivos) {
        this.periodoLectivos = periodoLectivos;
    }

    public List<Sala> getSalas() {
        salas = salaDAO.findAll();
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
     public void guardar(ActionEvent evt) {
       turmaDAO.save(turma);
       turma = new Turma();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Turma Registado com sucesso"));  

    }

    

    public void edit(ActionEvent event) {
        turmaDAO.update(turma);
        turmas = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("turma_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(TurmaMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        turmaDAO.delete(turma);
        turmas = null;
        return "turma_listar?faces-redirect=true";
    }
}