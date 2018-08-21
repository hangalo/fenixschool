/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AndarDAO;
import fenixschool.dao.SalaDAO;
import fenixschool.modelo.Andar;
import fenixschool.modelo.Sala;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
@ManagedBean(name = "salaMBean")
@ViewScoped
public class SalaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Sala sala = new Sala();
    private SalaDAO salaDAO;
    private AndarDAO andarDAO;
    private List<Sala> salas;
    private List<Andar> andares;
    
   
    public SalaMBean() {
    }
    
    @PostConstruct
    public void inicializar() {
    salaDAO = new SalaDAO();
    andarDAO = new AndarDAO();
    salas= new ArrayList<>();
    andares = new ArrayList<>();
    
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public SalaDAO getSalaDAO() {
        return salaDAO;
    }

    public void setSalaDAO(SalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    public AndarDAO getAndarDAO() {
        return andarDAO;
    }

    public void setAndarDAO(AndarDAO andarDAO) {
        this.andarDAO = andarDAO;
    }

    public List<Sala> getSalas() {
        salas= salaDAO.findAll();
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Andar> getAndares() {
        andares= andarDAO.findAll();
        return andares;
    }

    public void setAndares(List<Andar> andares) {
        this.andares = andares;
    }
    
       
     public void guardar(ActionEvent evt) {
       salaDAO.save(sala);
       sala = new Sala();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Turma Registado com sucesso"));  

    }

    

    public void edit(ActionEvent event) {
        salaDAO.update(sala);
        salas = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("sala_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SalaMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        salaDAO.delete(sala);
        salas = null;
        return "sala_listar?faces-redirect=true";
    }
    
    
}
