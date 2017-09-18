/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.TipoDocumentoIdentidadeDAO;
import fenixschool.modelo.TipoDocumentoIdentidade;
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
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

/**
 *
 * @author Elísio Kavaimunwa
 */
@ManagedBean(name = "tipoDocumentoIdentidadeMBean")
@SessionScoped
public class TipoDocumentoIdentidadeMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    TipoDocumentoIdentidade tipoDocumentoIdentidade;
    private TipoDocumentoIdentidadeDAO tipoDocumentoIdentidadeDAO;
    private List<TipoDocumentoIdentidade> tipoDeDocumentos;

    public TipoDocumentoIdentidadeMBean() {

    }

    @PostConstruct
    public void inicializar() {
        tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
        tipoDocumentoIdentidadeDAO = new TipoDocumentoIdentidadeDAO();
        tipoDeDocumentos = new ArrayList<>();
    }

    public String newSave() {
        tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
        return "tipo_documento_identidade_listar?faces-redirect=true";
    }

    public void guardar(ActionEvent evt) {
        if (tipoDocumentoIdentidadeDAO.save(tipoDocumentoIdentidade)) {
            tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }

    public void edit(java.awt.event.ActionEvent event) {
        if (tipoDocumentoIdentidadeDAO.update(tipoDocumentoIdentidade)) {
            tipoDeDocumentos = null;
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("tipo_documento_identidade_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(TipoDocumentoIdentidadeMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }

    }

    public String delete() {
        if (tipoDocumentoIdentidadeDAO.delete(tipoDocumentoIdentidade)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            tipoDeDocumentos = null;
            return "tipo_documento_identidade_listar?faces-redirect=true";
        } else {
            return null;
        }

    }

    public TipoDocumentoIdentidade getTipoDocumentoIdentidade() {
        return tipoDocumentoIdentidade;
    }

    public void setTipoDocumentoIdentidade(TipoDocumentoIdentidade tipoDocumentoIdentidade) {
        this.tipoDocumentoIdentidade = tipoDocumentoIdentidade;
    }

    public List<TipoDocumentoIdentidade> getTipoDeDocumentos() {
        tipoDeDocumentos = tipoDocumentoIdentidadeDAO.findAll();
        return tipoDeDocumentos;
    }

    public void setTipoDeDocumentos(List<TipoDocumentoIdentidade> tipoDeDocumentos) {
        this.tipoDeDocumentos = tipoDeDocumentos;
    }

}
