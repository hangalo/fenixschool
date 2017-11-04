/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ArtigoDAO;
import fenixschool.dao.CategoriaArtigoDAO;
import fenixschool.modelo.Artigo;
import fenixschool.modelo.CategoriaArtigo;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Elísio Kavaimunwa
 */
@Named(value = "artigoMBean")
@SessionScoped
public class ArtigoMBean implements Serializable {

   
    private static final long serialVersionUID = 1L;
    
    private Artigo artigo;
    ArtigoDAO artigoDAO;
    private List<Artigo> artigos;
    
    CategoriaArtigoDAO categoriaArtigoDAO;
    private List<CategoriaArtigo> categorias;
    
    public ArtigoMBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        artigo = new Artigo();
        artigoDAO = new ArtigoDAO();
        artigos = new ArrayList<>();
        
        categoriaArtigoDAO = new CategoriaArtigoDAO();
        categorias = new ArrayList<>();
    
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public List<Artigo> getArtigos() {
        return artigos = artigoDAO.findAll();
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public List<CategoriaArtigo> getCategorias() {
        return categorias = categoriaArtigoDAO.findAll();
    }

    public void setCategorias(List<CategoriaArtigo> categorias) {
        this.categorias = categorias;
    }
    
    public void guardar(ActionEvent event) {
        boolean controlo = false;
        for (CategoriaArtigo categoriaArtigoLido : categorias) {
            CategoriaArtigo categoriaArtigo = categoriaArtigoDAO.findById(categoriaArtigoLido.getIdCategoriaArtigo());
            artigo.setCategoriaArtigo(categoriaArtigo);
            controlo = artigoDAO.save(artigo);
        }
        if (controlo) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            artigo = new Artigo();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Erro ao guardar com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void edit(ActionEvent event) {
        boolean controlo = false;
       for (CategoriaArtigo categoriaArtigoLido : categorias) {
            CategoriaArtigo categoriaArtigo = categoriaArtigoDAO.findById(categoriaArtigoLido.getIdCategoriaArtigo());
            artigo.setCategoriaArtigo(categoriaArtigo);
            controlo = artigoDAO.save(artigo);
        }
        if (controlo) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("artigo_listar.jsf");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (IOException e) {
                java.util.logging.Logger.getLogger(ArtigoMBean.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Erro ao actualizar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    public String delete() {
        artigoDAO.delete(artigo);
        artigo = null;
        return "artigo_listar?faces-redirect=true";
    }
    
    
}
