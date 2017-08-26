/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;


import fenixschool.dao.TipoDisciplinaDAO;
import fenixschool.modelo.TipoDisciplina;
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
@ManagedBean(name ="tipoDisciplinaMBean")
@SessionScoped
public class TipoDisciplinaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private TipoDisciplina tipoDisciplina;
    private TipoDisciplinaDAO tipoDisciplinaDAO;
    private List<TipoDisciplina> tipoDisciplinas;
    
    public TipoDisciplinaMBean(){
    }
    
    @PostConstruct
    public void inicializar(){
        tipoDisciplina = new TipoDisciplina();
        tipoDisciplinaDAO = new TipoDisciplinaDAO();
        tipoDisciplinas = new ArrayList<>();
    }

    
    
    
    
    public List<TipoDisciplina> getTipoDisciplinas() {
        tipoDisciplinas = tipoDisciplinaDAO.findAll();
        return tipoDisciplinas;
    }
    public void guardar(ActionEvent evt) {
        tipoDisciplinaDAO.save(tipoDisciplina);
        tipoDisciplina = new TipoDisciplina();
        
        FacesMessage msg = new FacesMessage("Guardar", "Tipo de disciplina registada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void edit(java.awt.event.ActionEvent event) {
        tipoDisciplinaDAO.update(tipoDisciplina);
        tipoDisciplinas = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("tipo_disciplina_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(TipoDisciplinaMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public String delete() {
        tipoDisciplinaDAO.delete(tipoDisciplina);
        tipoDisciplinas = null;
        return "tipo_disciplina_listar?faces-redirect=true";
    }

    public TipoDisciplina getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(TipoDisciplina tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    public void setTipoDisciplinas(List<TipoDisciplina> tipoDisciplinas) {
        this.tipoDisciplinas = tipoDisciplinas;
    }

    
    
    
    
    
    
}
