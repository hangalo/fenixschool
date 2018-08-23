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
import java.io.Serializable;
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
public class PeriodoLectivoMBean implements Serializable{
private static final long serialVersionUID = 1L;

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
        if (periodoLectivoDAO.save(periodoLectivo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado registado com sucesso"));
            periodoLectivo = new PeriodoLectivo();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));

        }

    }

    public String startEdit() {
        return "periodolectivo_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (periodoLectivoDAO.update(periodoLectivo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            periodoLectivos = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("periodolectivo_gestao.jsf");
            } catch (IOException ex) {
                Logger.getLogger(PeriodoLectivoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));

        }

    }

    public String delete() {
        if (periodoLectivoDAO.delete(periodoLectivo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            periodoLectivos = null;

            return "periodolectivo_gestao?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;

        }

    }

}
