/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CandidatoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.Candidato;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
import fenixschool.modelo.Provincia;
import fenixschool.modelo.Sexo;
import fenixschool.util.FicheiroUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Elísio Kavaimunwa
 */
@ManagedBean(name = "candidatoMBean")
@SessionScoped

public class CandidatoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Candidato candidato;
    private Provincia provincia; // utilizado no metodo findByIdProvincia do municipio
    private Municipio municipio;
    
    private List<Candidato> candidatos;
    private List<Municipio> municipios;
    private List<Profissao> profissoes;
    private CandidatoDAO candidatoDAO;
    private MunicipioDAO municipioDAO;
    private ProfissaoDAO profissaoDAO;
    

    public CandidatoMBean() {
    }

    @PostConstruct
    public void inicializar() {
        candidato = new Candidato();
        candidatoDAO = new CandidatoDAO();
        profissaoDAO = new ProfissaoDAO();
        municipioDAO = new MunicipioDAO();
        candidatos = new ArrayList<>();
        municipios = new ArrayList<>();
        profissoes = new ArrayList<>();
        municipio = new Municipio();

    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List<Candidato> getCandidatos() {
        candidatos = candidatoDAO.findAll();
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
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
    
    public void fileUpload(FileUploadEvent event) {
        try {

            //Cria um objeto do tipo UploadedFile, para receber o ficheiro do evento
            UploadedFile arquivo = event.getFile();

            //transformar a imagem em bytes para guardar na base de dados  
            byte[] foto = IOUtils.toByteArray(arquivo.getInputstream());
            candidato.setFotoCandidato(foto);
            candidato.setUrlFotoCandidato(arquivo.getFileName());

            //para guardar o ficheiro num pasta local (no disco duro)
            InputStream in = new BufferedInputStream(arquivo.getInputstream());
            File file = new File(FicheiroUtil.getPathPastaAplicacaoJSF() + arquivo.getFileName());
           
            //Comandos para guardar no disco em rede
            // File file = new File("\\\\192.168.0.18\\photo\\fratiofmcpa"+arquivo.getFileName());
            
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
          
            FacesMessage msg = new FacesMessage("Foto: ", arquivo.getFileName() + " carregada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            System.out.println("Errom ao carregar foto. ");
            e.printStackTrace(System.out);
        }
    }

    public String newSave() {
        candidato = new Candidato();
        return "candidato_listar?faces-redirect=true";
    }

    public void guardar(ActionEvent evt) {
        candidatoDAO.save(candidato);
        candidato = new Candidato();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Candidato registado com sucesso"));
    }

    public String startEdit() {
        return "candidato_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        candidatoDAO.update(candidato);
        candidatos = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("candidato_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CandidatoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        candidatoDAO.delete(candidato);
        candidatos = null;
        return "candidato_listar?faces-redirect=true";
    }

    public List<Profissao> getProssifoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }
    
    // metodo novo. Ainda esta em análise.
    public void carregaMunicipiosDaProvincia() {
        municipios = municipioDAO.findByIdProvincia2(provincia);
    }
    

    public List<Municipio> getMunicipios() {
       // municipios = municipioDAO.findAll(); Agora não preciso de listar todos os municipios
        return municipios;
    }
    

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }

    public void setProssifoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public static String getPathPastaAplicacaoJSF() {
        String separador = System.getProperty("file.separator");
        String pasta = "fotos" + separador;
        String raizAplicacao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        return raizAplicacao + pasta;
    }

    

    
    

}
