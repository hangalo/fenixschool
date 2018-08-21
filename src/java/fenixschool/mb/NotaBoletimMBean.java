/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.BoletimNotaDAO;
import fenixschool.dao.NotaBoletimDAO;
import fenixschool.dao.NotaDAO;
import fenixschool.modelo.BoletimNota;
import fenixschool.modelo.Nota;
import fenixschool.modelo.NotaBoletim;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "notaBoletimMBean")
@ViewScoped
public class NotaBoletimMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<NotaBoletim> itens;
    private NotaBoletim notaBoletim;
    private NotaBoletimDAO notaBoletimDAO;

    private List<BoletimNota> boletimNotas;
    private BoletimNotaDAO boletimNotaDAO;

    private List<Nota> notas;
    private NotaDAO notaDAO;

    public NotaBoletimMBean() {
    }

    @PostConstruct
    public void initialize() {
        itens = new ArrayList<>();
        notaBoletim = new NotaBoletim();
        notaBoletimDAO = new NotaBoletimDAO();

        boletimNotas = new ArrayList<>();
        boletimNotaDAO = new BoletimNotaDAO();

        notas = new ArrayList<>();
        notaDAO = new NotaDAO();
    }

    public List<NotaBoletim> getItens() {
        itens = notaBoletimDAO.findAll();
        return itens;
    }

    public void setItens(List<NotaBoletim> itens) {
        this.itens = itens;
    }

    public NotaBoletim getNotaBoletim() {
        return notaBoletim;
    }

    public void setNotaBoletim(NotaBoletim notaBoletim) {
        this.notaBoletim = notaBoletim;
    }

    public List<BoletimNota> getBoletimNotas() {
        boletimNotas = boletimNotaDAO.findAll();
        return boletimNotas;
    }

    public void setBoletimNotas(List<BoletimNota> boletimNotas) {
        this.boletimNotas = boletimNotas;
    }

    public List<Nota> getNotas() {
        notas = notaDAO.findAll();
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void save(ActionEvent event) {
        if (notaBoletimDAO.existe(notaBoletim)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! A informação que deseja inserir já existe.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (notaBoletimDAO.save(notaBoletim)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaBoletim = new NotaBoletim();
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String update(RowEditEvent event) {
        notaBoletim = (NotaBoletim) event.getObject();
        if (notaBoletimDAO.update(notaBoletim)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Operação realizada com sucesso!!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaBoletim = null;
            return "nota_para_boletim_listar?faces-redirect=true;";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }

    }

    public String delete() {
        if (notaBoletimDAO.delete(notaBoletim)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluir", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaBoletim = null;
            return "nota_para_boletim_listar?faces-redirect=true;";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Excluir", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }
 
}
