/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.SemestreLectivoDAO;
import fenixschool.modelo.SemestreLectivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "semestreLectivoMbean")
@ViewScoped
public class SemestreLectivoMbean implements Serializable {

    private static final long serialVersionUID = 1L;
    private SemestreLectivoDAO semestreLectivoDAO;
    private SemestreLectivo semestre;
    private List<SemestreLectivo> lista;

    public SemestreLectivoMbean() {
    }

    @PostConstruct
    public void initialize() {
        semestreLectivoDAO = new SemestreLectivoDAO();
        lista = new ArrayList<>();
        semestre = new SemestreLectivo();
    }

    public SemestreLectivoDAO getSemestreLectivoDAO() {
        return semestreLectivoDAO;
    }

    public void setSemestreLectivoDAO(SemestreLectivoDAO semestreLectivoDAO) {
        this.semestreLectivoDAO = semestreLectivoDAO;
    }

    public SemestreLectivo getSemestre() {
        return semestre;
    }

    public void setSemestre(SemestreLectivo semestre) {
        this.semestre = semestre;
    }

    public List<SemestreLectivo> getLista() {
        lista = semestreLectivoDAO.findAll();
        return lista;
    }

    public void setLista(List<SemestreLectivo> lista) {
        this.lista = lista;
    }

    public void save(ActionEvent event) {
        if (semestreLectivoDAO.existe(semestre)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Guardar", "O "+semestre.getSemestreLectivo()+" já existe!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (semestreLectivoDAO.save(semestre)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Guardar","Informação guardada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            semestre = new SemestreLectivo();
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Guardar", "Erro ao guardar informação.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(ActionEvent event) {
        if (semestreLectivoDAO.update(semestre)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Actualizar", "Informação actualizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            semestre = null;
            return "semestre_letivo_listar?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Actualizar", "Erro ao actualizar informação.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }

    }

    public String delete() {
        if (semestreLectivoDAO.delete(semestre)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação eliminada com sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            semestre = null;
            return "semestre_letivo_listar?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar informação.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }

    }
}
