/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;


import fenixschool.dao.CicloLectivoDAO;
import fenixschool.modelo.CicloLectivo;
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
 * @author Aisha Lubadika
 */

@ManagedBean(name = "cicloLectivoMBean")
@SessionScoped
public class CicloLectivoMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private CicloLectivo cicloLectivo = new CicloLectivo();
    private CicloLectivoDAO cicloLectivoDAO;
    private List<CicloLectivo> cicloLectivos;
    public CicloLectivoMBean() {
    }
    
    @PostConstruct
    public void inicializar(){
     cicloLectivo = new CicloLectivo();
     cicloLectivoDAO = new CicloLectivoDAO();
     cicloLectivos= new ArrayList<>();
    
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public CicloLectivoDAO getCicloLectivoDAO() {
        return cicloLectivoDAO;
    }

    public void setCicloLectivoDAO(CicloLectivoDAO cicloLectivoDAO) {
        this.cicloLectivoDAO = cicloLectivoDAO;
    }

    public List<CicloLectivo> getCicloLectivos() {
        cicloLectivos= cicloLectivoDAO.findAll();
        return cicloLectivos;
    }

    public void setCicloLectivos(List<CicloLectivo> cicloLectivos) {
        this.cicloLectivos = cicloLectivos;
    }
     public String newSave() {
        cicloLectivo= new CicloLectivo();
        return "ciclolectivo_listar?faces-redirect=true";
    }

      public void guardar(ActionEvent evt) {
       cicloLectivoDAO.save(cicloLectivo);
       cicloLectivo= new CicloLectivo();

           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Ciclo Lectivo registado com sucesso"));
    }
    public String startEdit() {
        return "ciclolectivo_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
       cicloLectivoDAO.update(cicloLectivo);
        cicloLectivos = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("ciclolectivo_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CicloLectivoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
               cicloLectivoDAO.delete(cicloLectivo);
               cicloLectivos = null;
        return "ciclolectivo_listar?faces-redirect=true";
    }   
    
    
}
