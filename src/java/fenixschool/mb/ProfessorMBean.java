/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfessorDAO;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Professor;
import fenixschool.modelo.Sexo;
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
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author informatica
 */
@ManagedBean(name = "professorMBean")
@ViewScoped
public class ProfessorMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Professor professor;
    private ProfessorDAO professorDAO;
    private List<Professor> professores;
    private MunicipioDAO municipioDAO;
    private List<Municipio> municipios;

    // Variaveis para as consultas
    private String nome;
    private String sobrenome;
    private String numeroBI;

    public ProfessorMBean() {
    }

    @PostConstruct
    public void inicializar() {
        professor = new Professor();
        professorDAO = new ProfessorDAO();
        professores = new ArrayList<>();
        municipios = new ArrayList<>();
        municipioDAO = new MunicipioDAO();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }

    public List<Municipio> getMunicipios() {

        municipios = municipioDAO.findAll();

        return municipios;
    }

    public List<Professor> getProfessores() {
        professores = professorDAO.findAll();
        return professores;
    }

    /*Variaveis para as consultas*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumeroBI() {
        return numeroBI;
    }

    public void setNumeroBI(String numeroBI) {
        this.numeroBI = numeroBI;
    }

    
    
    /*Metodos*/
    public void fileUpload(FileUploadEvent event) {
        try {

            //Cria um objeto do tipo UploadedFile, para receber o ficheiro do evento
            UploadedFile arq = event.getFile();

            //transformar a imagem em bytes para guardar na base de dados  
            byte[] foto = IOUtils.toByteArray(arq.getInputstream());

            professor.setFotoProfessor(foto);
            professor.setUrlFotoProfessor(arq.getFileName());

            //para guardar o ficheiro num pasta local (no disco duro)
            InputStream in = new BufferedInputStream(arq.getInputstream());
            File file = new File(FicheiroUtil.getPathPastaAplicacaoJSF() + arq.getFileName());

            //Guarda num disco de rede
            //   File file = new File("\\\\192.168.0.18\\photo\\fratiofmcap\\" + arq.getFileName());
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();

            FacesMessage msg = new FacesMessage("Foto:", arq.getFileName() + "Carregada com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public String getRealPath() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    }

    public void newSave(ActionEvent evt) {
        professor = new Professor();
        //return "professor_listar?faces-redirect=true";
    }

    public void guardar(ActionEvent evt) {
        professorDAO.save(professor);
        professor = new Professor();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Professor registado com sucesso"));
    }

    public String startEdit() {
        return "professor_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        professorDAO.update(professor);
        professores = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("professor_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfessorMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        professorDAO.delete(professor);
        professores = null;
        return "professor_listar?faces-redirect=true";
    }

    public Professor getByNomeSobrenome() {

        if ((getNome() == null || getNome().isEmpty()) && (getSobrenome() == null)) {
            return null;

        } else if (((getSobrenome() == null) || (getSobrenome().isEmpty())) && ((getNome() != null || !getNome().isEmpty()))) {
            professor = professorDAO.findByNome(nome);
            return professor;
        } else if ((getNome() == null || getNome().isEmpty() && getSobrenome() != null)) {
            professor = professorDAO.findBySobrenome(sobrenome);

            return professor;
        } else if ((getNome() != null || !getNome().isEmpty()) && (getSobrenome() != null || !getSobrenome().isEmpty())) {
            professor = professorDAO.findByNomeSobrenome(nome, sobrenome);
            return professor;
        }
        return null;
    }
    
    
      public Professor getByNumeroBI() {   
      
            professor = professorDAO.findByNumeroBI(numeroBI);
            return professor;
      
    }


}
