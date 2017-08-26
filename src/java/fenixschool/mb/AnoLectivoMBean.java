/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AnoLectivoDAO;
import fenixschool.modelo.AnoLectivo;
import java.io.IOException;
import java.io.Serializable;
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
@ManagedBean(name = "anoLectivoMBean")
@SessionScoped
public class AnoLectivoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private AnoLectivo anoLectivo;
    private AnoLectivoDAO anoLectivoDAO;
    private List<AnoLectivo> anoLectivos;

    public AnoLectivoMBean() {
    }

    @PostConstruct
    public void inicializar() {

        anoLectivo = new AnoLectivo();
        anoLectivoDAO = new AnoLectivoDAO();
        anoLectivos = new ArrayList<>();
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public List<AnoLectivo> getAnoLectivos() {
        anoLectivos = anoLectivoDAO.findAll();
        return anoLectivos;
    }

    public void setAnoLectivos(List<AnoLectivo> anoLectivos) {
        this.anoLectivos = anoLectivos;
    }

    public void guardar(ActionEvent event) {
        anoLectivoDAO.save(anoLectivo);
        anoLectivo = new AnoLectivo();

        FacesMessage msg = new FacesMessage("Guardar", " Guardado comsucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void edit(ActionEvent event) {
        anoLectivoDAO.update(anoLectivo);
        anoLectivo = null;

        FacesMessage msg = new FacesMessage("Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("anolectivo_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(AnoLectivoMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        anoLectivoDAO.delete(anoLectivo);
        anoLectivo = null;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluir","Excluido com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "anolectivo_listar?faces-redirect=true";
    }
}
