/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CicloLectivoDAO;
import fenixschool.dao.DisciplinaDAO;
import fenixschool.dao.TipoDisciplinaDAO;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.TipoDisciplina;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "disciplinaMBean")
@ViewScoped
public class DisciplinaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Disciplina disciplina;
    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;

    private CicloLectivoDAO cicloLectivoDAO;
    private List<CicloLectivo> cicloLectivos;

    private TipoDisciplinaDAO tipoDisciplinaDAO;
    private List<TipoDisciplina> tipoDisciplinas;

    public DisciplinaMBean() {
    }

    @PostConstruct
    public void inicializar() {

        disciplina = new Disciplina();
        disciplinaDAO = new DisciplinaDAO();
        disciplinas = new ArrayList<>();

        cicloLectivoDAO = new CicloLectivoDAO();
        cicloLectivos = new ArrayList<>();

        tipoDisciplinaDAO = new TipoDisciplinaDAO();
        tipoDisciplinas = new ArrayList<>();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        disciplinas = disciplinaDAO.findAll();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<CicloLectivo> getCicloLectivos() {
        //cicloLectivos = cicloLectivoDAO.findAll();
        return cicloLectivos;
    }

    public void setCicloLectivos(List<CicloLectivo> cicloLectivos) {
        this.cicloLectivos = cicloLectivos;
    }

    public List<TipoDisciplina> getTipoDisciplinas() {
        tipoDisciplinas = tipoDisciplinaDAO.findAll();
        return tipoDisciplinas;
    }

    public void setTipoDisciplinas(List<TipoDisciplina> tipoDisciplinas) {
        this.tipoDisciplinas = tipoDisciplinas;
    }

    public void guardar(ActionEvent event) {
        boolean controlo = false;
        for (CicloLectivo cicloLectivoLido : cicloLectivos) {
            CicloLectivo cicloLectivo = cicloLectivoDAO.findById(cicloLectivoLido.getIdCicloLectivo());
            disciplina.setCicloLectivo(cicloLectivo);
            controlo = disciplinaDAO.save(disciplina);
        }
        if (controlo) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            disciplina = new Disciplina();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Erro ao guardar com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void edit(ActionEvent event) {
        boolean controlo = false;
        for (CicloLectivo cicloLectivoLido : cicloLectivos) {
            CicloLectivo cicloLectivo = cicloLectivoDAO.findById(cicloLectivoLido.getIdCicloLectivo());
            disciplina.setCicloLectivo(cicloLectivo);
            controlo = disciplinaDAO.update(disciplina);
            disciplina = null;
        }
        if (controlo) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("disciplina_listar.jsf");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (IOException e) {
                java.util.logging.Logger.getLogger(DisciplinaMBean.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Erro ao actualizar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String delete() {
        disciplinaDAO.delete(disciplina);
        disciplina = null;
        return "disciplina_listar?faces-redirect=true";
    }
}
