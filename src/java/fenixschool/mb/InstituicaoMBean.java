/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.InstituicaoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.Instituicao;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Provincia;
import fenixschool.util.FicheiroUtil;
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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "instituicaoMBean")
@SessionScoped
public class InstituicaoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instituicao instituicao;
    private Municipio municipio;
    private Provincia provincia;
    private InstituicaoDAO instituicaoDAO;
    private ProvinciaDAO provinciaDAO;
    private MunicipioDAO municipioDAO;
    private List<Instituicao> instituicoes;
    private List<Provincia> provincias;
    private List<Municipio> municipios;

    public InstituicaoMBean() {
    }

    @PostConstruct
    public void inicializar() {

        instituicao = new Instituicao();
        municipio = new Municipio();
        instituicaoDAO = new InstituicaoDAO();
        provinciaDAO = new ProvinciaDAO();
        municipioDAO = new MunicipioDAO();
     
        instituicoes = instituicaoDAO.findAll(); 
        
      
       
        municipios = new ArrayList<>();
        provincias = new ArrayList<>();
        municipio = new Municipio();
        provincias = provinciaDAO.findAll();


    

    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Instituicao> getInstituicoes() {
              return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getProvincias() {
         provincias = provinciaDAO.findAll();
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    // carrega municipios em função da provincia
    public void carregaMunicipiosDaProvincia() {
        System.out.println("Provncia >>>>>" + provincia);
        municipios = municipioDAO.findByIdProvincia2(provincia);
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

         //   File file = new File("C://fotos//" + arquivo.getFileName());
            File file = new File(FicheiroUtil.getPathPastaAplicacaoJSF() + arquivo.getFileName());

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
