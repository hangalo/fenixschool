/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ClassificacaoNotaDAO;
import fenixschool.modelo.ClassificacaoNota;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */

@ManagedBean(name = "classificacaoNotaMBean")
@ViewScoped

public class ClassificacaoNotaMBean implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    private ClassificacaoNota classificacaoNota ;
    private ClassificacaoNotaDAO classificacaoNotaDAO;
    private List<ClassificacaoNota> classificacaoNotas;
    
    @PostConstruct
    public void inicializar(){
        classificacaoNota = new ClassificacaoNota();
        classificacaoNotaDAO = new ClassificacaoNotaDAO();
        classificacaoNotas = new ArrayList<>();
    }

    public ClassificacaoNotaMBean() {
    }

    public ClassificacaoNota getClassificacaoNota() {
        return classificacaoNota;
    }

    public void setClassificacaoNota(ClassificacaoNota classificacaoNota) {
        this.classificacaoNota = classificacaoNota;
    }

    public List<ClassificacaoNota> getClassificacaoNotas(){
        classificacaoNotas = classificacaoNotaDAO.findAll();
        return classificacaoNotas;
    }
    
    public void setClassificacaoNotas(List<ClassificacaoNota> classificacaoNotas){
        this.classificacaoNotas = classificacaoNotas;
    }
    
    public void guardar(ActionEvent evt) {
        classificacaoNotaDAO.save(classificacaoNota);
        classificacaoNota = new ClassificacaoNota();
        
    }
    
    public void edit(java.awt.event.ActionEvent event) {
        classificacaoNotaDAO.update(classificacaoNota);
        classificacaoNotas = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("classificacao_nota_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfissaoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     public String delete() {
        classificacaoNotaDAO.delete(classificacaoNota);
        classificacaoNotas = null;
        return "classificacao_nota_listar?faces-redirect=true";

}

}
