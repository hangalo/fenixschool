/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CertificadoDAO;
import fenixschool.dao.NotaCertificadoDAO;
import fenixschool.dao.NotaDAO;
import fenixschool.modelo.Certificado;
import fenixschool.modelo.Nota;
import fenixschool.modelo.NotaCertificado;
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
@ManagedBean(name = "notaCertificadoMBean")
@ViewScoped
public class NotaCertificadoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<NotaCertificado> itens;
    private NotaCertificado notaCertificado;
    private NotaCertificadoDAO notaCertificadoDAO;

    private List<Certificado> certificados;
    private CertificadoDAO certificadoDAO;

    private List<Nota> notas;
    private NotaDAO notaDAO;

    public NotaCertificadoMBean() {
    }

    @PostConstruct
    public void initialize() {
        itens = new ArrayList<>();
        notaCertificado = new NotaCertificado();
        notaCertificadoDAO = new NotaCertificadoDAO();

        certificados = new ArrayList<>();
        certificadoDAO = new CertificadoDAO();

        notas = new ArrayList<>();
        notaDAO = new NotaDAO();
    }

    public List<NotaCertificado> getItens() {
        itens = notaCertificadoDAO.findAll();
        return itens;
    }

    public void setItens(List<NotaCertificado> itens) {
        this.itens = itens;
    }

    public NotaCertificado getNotaCertificado() {
        return notaCertificado;
    }

    public void setNotaCertificado(NotaCertificado notaCertificado) {
        this.notaCertificado = notaCertificado;
    }

    public List<Certificado> getCertificados() {
        certificadoDAO.findAll();
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public List<Nota> getNotas() {
        notaDAO.findAll();
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void save(ActionEvent event) {
        capturarNotasAluno();
        if (notaCertificadoDAO.findWhere(notaCertificado)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! O registo fornecido já existe!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaCertificado = new NotaCertificado();
        } else if (notaCertificadoDAO.save(notaCertificado)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaCertificado = new NotaCertificado();
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public String update(RowEditEvent event) {
        notaCertificado = (NotaCertificado) event.getObject();
        if (notaCertificadoDAO.update(notaCertificado)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaCertificado = null;
            return "nota_para_certificadao_listar?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar", "Ops! Ocorreu um erro inesperado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }

    public String delete() {
        if (notaCertificadoDAO.delete(notaCertificado)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluir", "Operação realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            notaCertificado = null;
            return "nota_para_certificadao_listar?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Excluir", "Ops! Ocorreu um erro inesperado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }

    public void capturarNotasAluno() {

        Nota nota = new Nota();
        FacesContext context = FacesContext.getCurrentInstance();
        String idNota = (String) context.getExternalContext().getRequestParameterMap().get("idNota");

        if (idNota != null) {
            System.out.println("Numero capturado >>>>>>>>> " + idNota);
            nota.setIdnota(Integer.parseInt(idNota));
            notaCertificado.setNota(nota);
        }
    }
}
