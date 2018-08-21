/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.SituacaoTransferenciaDAO;
import fenixschool.modelo.SituacaoTransferencia;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "situacaoTransferenciaMBean")
@ViewScoped
public class SituacaoTransferenciaMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SituacaoTransferencia situacaoTransferencia;
    private SituacaoTransferenciaDAO situacaoTransferenciaDAO;
    private List<SituacaoTransferencia> situacaoTransferencias;

    public SituacaoTransferenciaMBean() {
    }

    @PostConstruct
    public void inicializar() {
        situacaoTransferencia = new SituacaoTransferencia();
        situacaoTransferenciaDAO = new SituacaoTransferenciaDAO();
        situacaoTransferencias = new ArrayList<>();
    }

    public SituacaoTransferencia getSituacaoTransferencia() {
        return situacaoTransferencia;
    }

    public void setSituacaoTransferencia(SituacaoTransferencia situacaoTransferencia) {
        this.situacaoTransferencia = situacaoTransferencia;
    }

    public List<SituacaoTransferencia> getSituacaoTransferencias() {
        situacaoTransferencias = situacaoTransferenciaDAO.findAll();
        return situacaoTransferencias;
    }

    public void setSituacaoTransferencias(List<SituacaoTransferencia> situacaoTransferencias) {
        this.situacaoTransferencias = situacaoTransferencias;
    }

    public void guardar(ActionEvent event) {

        situacaoTransferenciaDAO.save(situacaoTransferencia);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        situacaoTransferencia = new SituacaoTransferencia();

    }

    public void edit(ActionEvent event) {
        situacaoTransferenciaDAO.update(situacaoTransferencia);
        situacaoTransferencia = null;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("situacaoTransferencia_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(SituacaoTransferenciaMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        situacaoTransferenciaDAO.delete(situacaoTransferencia);
        situacaoTransferencia = null;
        return "situacaoTransferencia_listar?faces-redirect=true";
    }

}
