/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ArtigoDAO;
import fenixschool.modelo.Artigo;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rei Santo Hangalo
 */
@Named(value = "artigoBean")
@SessionScoped
public class ArtigoBean implements Serializable {
    private Artigo artigo;
    private ArtigoDAO artigoDAO;
    private List<Artigo> artigos;
    public ArtigoBean() {
    }   
    public void inicializar() {
    artigoDAO = new ArtigoDAO();
        artigos = new ArrayList<>();
    artigo= new Artigo();   
    }
    public List<Artigo> getArtigos() {
        artigos= artigoDAO.findAll();
        return artigos;
        
    }   
     public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

   public Artigo getArtigo() {
        return artigo;
    }
    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }
    public ArtigoDAO getArtigoDAO() {
        return artigoDAO;
    }
    public void setArtigoDAO(ArtigoDAO artigoDAO) {
        this.artigoDAO = artigoDAO;
    }
    public void guardar(ActionEvent evt) {
       artigoDAO.save(artigo);
       artigo = new Artigo();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Artigo Guardado com Sucesso"));  
    }
    public void edit(ActionEvent event) {
        artigoDAO.update(artigo);
        artigo= new Artigo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Artigo Actualizado com Sucesso"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("lisatr_artigo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(TurmaMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String delete() {
        artigoDAO.delete(artigo);
        artigos = null;
        return "listar_turma?faces-redirect=true";
    }

    
    
}
