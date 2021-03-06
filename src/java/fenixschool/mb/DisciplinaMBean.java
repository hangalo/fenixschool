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
import fenixschool.util.GestorImpressao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    

    //Variaveis auxiliares
    private List<Disciplina> findByCilclo;
    private Integer ciclo;

    

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
        findByCilclo = new ArrayList<>();
        //gestorImpressao = new GestorImpressao();
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

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public List<Disciplina> getFindByCilclo() {
        if (ciclo != null) {
            findByCilclo = disciplinaDAO.findByCiclo(ciclo);
            return findByCilclo;
        }
        return null;

    }

    public void setFindByCilclo(List<Disciplina> findByCilclo) {
        this.findByCilclo = findByCilclo;
    }

    public void guardar(ActionEvent event) {
        for (CicloLectivo cicloLectivoLido : cicloLectivos) {
            CicloLectivo cicloLectivo = cicloLectivoDAO.findById(cicloLectivoLido.getIdCicloLectivo());
            disciplina.setCicloLectivo(cicloLectivo);
        }
        if (disciplinaDAO.save(disciplina)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Guardado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            disciplina = new Disciplina();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Erro ao guardar com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String edit(ActionEvent event) {
        for (CicloLectivo cicloLectivoLido : cicloLectivos) {
            CicloLectivo cicloLectivo = cicloLectivoDAO.findById(cicloLectivoLido.getIdCicloLectivo());
            disciplina.setCicloLectivo(cicloLectivo);
        }
        if (disciplinaDAO.update(disciplina)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Actualizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            disciplina = null;
            return "disciplina_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Erro ao actualizar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

    public String delete() {
        if (disciplinaDAO.delete(disciplina)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Eliminado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            disciplina = null;
            return "disciplina_listar?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Erro ao eliminar com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

 
}
