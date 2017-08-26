/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import fenixschool.dao.AnoCurricularDAO;
import fenixschool.modelo.AnoCurricular;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "anoCurricularMBean")
@SessionScoped
public class AnoCurricularMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AnoCurricular anoCurricular;
    private AnoCurricularDAO anoCurricularDAO;
    private List<AnoCurricular> anoCurriculares;

    public AnoCurricularMBean() {
    }

    @PostConstruct
    public void inicializar() {

        anoCurricular = new AnoCurricular();
        anoCurricularDAO = new AnoCurricularDAO();
        anoCurriculares = new VirtualFlow.ArrayLinkedList<>();
    }

    public AnoCurricular getAnoCurricular() {
        return anoCurricular;
    }

    public void setAnoCurricular(AnoCurricular anoCurricular) {
        this.anoCurricular = anoCurricular;
    }

    public List<AnoCurricular> getAnoCurriculares() {
        anoCurriculares = anoCurricularDAO.findAll();
        return anoCurriculares;
    }

    public void setAnoCurriculares(List<AnoCurricular> anoCurriculares) {
        this.anoCurriculares = anoCurriculares;
    }

    public void guardar(ActionEvent event) {
        anoCurricularDAO.save(anoCurricular);
        anoCurricular = new AnoCurricular();

        FacesMessage msg = new FacesMessage("Ano Curricular", " Guardado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void edit(ActionEvent event) {
        anoCurricularDAO.update(anoCurricular);
        anoCurricular = null;

        FacesMessage msg = new FacesMessage("Ano Curricular", "Actualizado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("anocurricular_listar.jsf");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AnoCurricularMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        anoCurricularDAO.delete(anoCurricular);
        anoCurricular = null;
        return "anocurricular_listar?faces-redirect=true";
    }

}
