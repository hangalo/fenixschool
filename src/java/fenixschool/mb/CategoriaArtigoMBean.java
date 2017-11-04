/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CategoriaArtigoDAO;
import fenixschool.dao.TipoDocumentoIdentidadeDAO;
import fenixschool.modelo.CategoriaArtigo;
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
import javax.faces.context.FacesContext;

/**
 *
 * @author Elísio Kavaimunwa
 */
@Named(value = "categoriaArtigoMBean")
@SessionScoped
public class CategoriaArtigoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private CategoriaArtigo categoriaArtigo;
    private CategoriaArtigoDAO categoriaArtigoDAO;
    private List<CategoriaArtigo> categorias;
    
    public CategoriaArtigoMBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        categoriaArtigo = new CategoriaArtigo();
        categoriaArtigoDAO = new CategoriaArtigoDAO();
        categorias = new ArrayList<>();
    }
    
    public String newSave() {
        categoriaArtigo = new CategoriaArtigo();
        return "categoria_artigo_listar?faces-redirect=true";
    }
    
    public void guardar(ActionEvent evt) {
        if (categoriaArtigoDAO.save(categoriaArtigo)) {
            categoriaArtigo = new CategoriaArtigo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }
    
    public void edit(java.awt.event.ActionEvent event) {
        if (categoriaArtigoDAO.update(categoriaArtigo)) {
            categorias = null;
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("categoria_artigo_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CategoriaArtigoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }

    }
    
     public String delete() {
        if (categoriaArtigoDAO.delete(categoriaArtigo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            categorias = null;
            return "categria_artigo_listar?faces-redirect=true";
        } else {
            return null;
        }

    }

    public CategoriaArtigo getCategoriaArtigo() {
        return categoriaArtigo;
    }

    public void setCategoriaArtigo(CategoriaArtigo categoriaArtigo) {
        this.categoriaArtigo = categoriaArtigo;
    }

    public List<CategoriaArtigo> getCategorias() {
        categorias = categoriaArtigoDAO.findAll();
        return categorias;
    }

    public void setCategorias(List<CategoriaArtigo> categorias) {
        this.categorias = categorias;
    }
     
     
}

