/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.InstituicaoDAO;
import fenixschool.modelo.Instituicao;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author PENA
 */


 @ManagedBean(name = "instituicaoMBean")
@RequestScoped
public class InstituicaoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instituicao instituicao;
    private InstituicaoDAO instituicaoDAO;
    private List<Instituicao> instituicoes;

    public InstituicaoMBean() {
    }

    @PostConstruct
    public void inicializar() {

        instituicao = new Instituicao();
        instituicaoDAO = new InstituicaoDAO();
        instituicoes = new ArrayList<>();
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Instituicao> getInstituicoes() {
        instituicoes = instituicaoDAO.findAll();
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public void guardar(ActionEvent event) {
        instituicaoDAO.save(instituicao);
        instituicao = new Instituicao();

        FacesMessage msg = new FacesMessage("Guardar", "Instituição guardada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void edit(ActionEvent event) {
        instituicaoDAO.update(instituicao);
        instituicoes = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("instituicao_listar.jsf");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(InstituicaoMBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        instituicaoDAO.delete(instituicao);
        instituicoes = null;
        return "instituicao_listar?faces-redirect=true";
    }

    public void fileUpload(FileUploadEvent event) {
        try {

            UploadedFile arquivo = event.getFile();

            byte[] foto = IOUtils.toByteArray(arquivo.getInputstream());

            instituicao.setLogoTipoInstituicao(foto);
            instituicao.setUrlLogoInstituicao(arquivo.getFileName());

            InputStream in = new BufferedInputStream(arquivo.getInputstream());

            File file = new File("C://fotos//" + arquivo.getFileName());

            //Guarda num disco de rede
            //   File file = new File("\\\\192.168.0.18\\photo\\fratiofmcap\\" + arq.getFileName());
            FileOutputStream fout = new FileOutputStream(file);

            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
            FacesMessage msg = new FacesMessage("Foto: " + arquivo.getFileName() + " Carregada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
