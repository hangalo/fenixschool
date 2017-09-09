/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Professor;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
 * @author informatica
 */
@ManagedBean(name = "periodoLectivoMBean")
@ViewScoped
public class PeriodoLectivoMBean {

    /**
     * Creates a new instance of PeriodoLectivoMBean
     */
    private PeriodoLectivo periodoLectivo;
    private PeriodoLectivoDAO periodoLectivoDAO;
    private List<PeriodoLectivo> periodoLectivos;

    public PeriodoLectivoMBean() {
    }

    @PostConstruct
    public void init() {
        periodoLectivo = new PeriodoLectivo();
        periodoLectivoDAO = new PeriodoLectivoDAO();
        periodoLectivos = periodoLectivoDAO.findAll();
    }

    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public List<PeriodoLectivo> getPeriodoLectivos() {
        return periodoLectivos;
    }

    public void setPeriodoLectivos(List<PeriodoLectivo> periodoLectivos) {
        this.periodoLectivos = periodoLectivos;
    }

    public void newSave(ActionEvent evt) {
        periodoLectivo = new PeriodoLectivo();
      
    }
    
    public void guardar(ActionEvent evt) {
        periodoLectivoDAO.save(periodoLectivo);
        periodoLectivo = new PeriodoLectivo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDadoregistado com sucesso"));
    }

    public String startEdit() {
        return "periodolectivo_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        periodoLectivoDAO.update(periodoLectivo);
        periodoLectivos = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("periodolectivo_gestao.jsf");
        } catch (IOException ex) {
            Logger.getLogger(PeriodoLectivoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        periodoLectivoDAO.delete(periodoLectivo);
        periodoLectivos = null;
        return "periodolectivo_gestao?faces-redirect=true";
    }

}
