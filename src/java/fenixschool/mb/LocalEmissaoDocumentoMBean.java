/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.LocalEmissaoDocumentoDAO;
import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.modelo.LocalEmissaoDocumento;
import fenixschool.modelo.PeriodoLectivo;
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
@ManagedBean(name = "localEmissaoDocumentoMBean")
@ViewScoped
public class LocalEmissaoDocumentoMBean implements Serializable {

    /**
     * Creates a new instance of LocalEmissaoDocumentoMBean
     */
    private LocalEmissaoDocumento localEmissaoDocumento;
    private LocalEmissaoDocumentoDAO localEmissaoDocumentoDAO;
    private List<LocalEmissaoDocumento> localEmissaoDocumentos;

    public LocalEmissaoDocumentoMBean() {
    }

    @PostConstruct
    public void init() {
        localEmissaoDocumento = new LocalEmissaoDocumento();
        localEmissaoDocumentoDAO = new LocalEmissaoDocumentoDAO();
        localEmissaoDocumentos = localEmissaoDocumentoDAO.findAll();
    }

    public LocalEmissaoDocumento getLocalEmissaoDocumento() {
        return localEmissaoDocumento;
    }

    public void setLocalEmissaoDocumento(LocalEmissaoDocumento localEmissaoDocumento) {
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    public List<LocalEmissaoDocumento> getLocalEmissaoDocumentos() {
        return localEmissaoDocumentos;
    }

    public void setLocalEmissaoDocumentos(List<LocalEmissaoDocumento> localEmissaoDocumentos) {
        this.localEmissaoDocumentos = localEmissaoDocumentos;
    }

    public void newSave(ActionEvent evt) {
        localEmissaoDocumento = new LocalEmissaoDocumento();

    }

    public void guardar(ActionEvent evt) {
        if (localEmissaoDocumentoDAO.save(localEmissaoDocumento)) {

            localEmissaoDocumento = new LocalEmissaoDocumento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado registado com sucesso"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar:\t", "\t Falha ao registar os dados"));
        }

    }

    public String startEdit() {
        return "localemissaodocumento_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (localEmissaoDocumentoDAO.update(localEmissaoDocumento)) {
            localEmissaoDocumentos = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar:\t", "\tDado alterado com sucesso"));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("localemissaodocumento_gestao.jsf");
            } catch (IOException ex) {
                Logger.getLogger(PeriodoLectivoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));

        }

    }

    public String delete() {

        if (localEmissaoDocumentoDAO.delete(localEmissaoDocumento)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            localEmissaoDocumentos = null;
            return "localemissaodocumento_gestao?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;

        }

    }

}
