/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.MunicipioDAO;

import fenixschool.modelo.Municipio;
import fenixschool.modelo.Provincia;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "municipioMBean")
@RequestScoped
public class MunicipioMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Municipio municipio;
    private MunicipioDAO municipioDAO;
    private List<Municipio> municipios;
    private Provincia provincia;

    public MunicipioMBean() {
    }

    @PostConstruct
    public void inicializar() {
        municipio = new Municipio();
        provincia = new Provincia();
        municipioDAO = new MunicipioDAO();
        municipios = new ArrayList<>();

    }

    public void guardar(ActionEvent evt) {
        municipioDAO.save(municipio);
        municipio = new Municipio();
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioDAO.findAll();
        return municipios;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public void carregaMunicipiosDaProvincia() {

        municipios = municipioDAO.findByIdProvincia(provincia);
    }

    
    
    
    public String newSave() {
        municipio = new Municipio();
        return "municipio_gestao?faces-redirect=true";
    }

    public String startEdit() {
        return "municipio_gestao?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        municipioDAO.update(municipio);
        municipios = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("municipio_gestao.jsf");
        } catch (IOException ex) {
            Logger.getLogger(MunicipioMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        municipioDAO.delete(municipio);
        municipios = null;
        return "municipio_gestao?faces-redirect=true";
    }

}
