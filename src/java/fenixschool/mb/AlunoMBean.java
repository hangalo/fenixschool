/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kulley
 */
@ManagedBean(name = "alunoMBean")
@SessionScoped

public class AlunoMBean implements Serializable {

    public static final long serialVersionUID = 1L;

    private Aluno aluno = new Aluno();
    private AlunoDAO alunoDAO;
    private ProfissaoDAO profissaoDAO;
    private MunicipioDAO municipioDAO;
    private List<Aluno> alunos;
    private List<Profissao> profissoes;

    @PostConstruct
    public void inicializar() {
        //  aluno = new Aluno();
        alunoDAO = new AlunoDAO();
        profissaoDAO = new ProfissaoDAO();
        municipioDAO = new MunicipioDAO();
        alunos = new ArrayList<>();
        profissoes = new ArrayList<>();
    }

    public AlunoMBean() {
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public ProfissaoDAO getProfissaoDAO() {
        return profissaoDAO;
    }

    public void setProfissaoDAO(ProfissaoDAO profissaoDAO) {
        this.profissaoDAO = profissaoDAO;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    private List<Municipio> municipios = new ArrayList<>();

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioDAO.findAll();
        return municipios;
    }

    public List<Profissao> getProfissoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

   public void fileUpload(FileUploadEvent event) {
        try {
            //Cria um objeto do tipo UploadedFile, para receber o ficheiro do evento
            UploadedFile arq = event.getFile();
        
            //transformar a imagem em bytes para guardar na base de dados  
            byte[] foto = IOUtils.toByteArray(arq.getInputstream());
            aluno.setFotoAluno(foto);
            aluno.setUrlfotoAluno(arq.getFileName());

            //para guardar o ficheiro num pasta local
            InputStream in = new BufferedInputStream(arq.getInputstream());

            File file = new File(FicheiroUtil.getPathPastaAplicacaoJSF() + arq.getFileName());

           

            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();

            FacesMessage msg = new FacesMessage("Ficheiro:\t", arq.getFileName() + "\tCarregado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    
   
    public void guardar(ActionEvent evt) {
        alunoDAO.save(aluno);
        aluno = new Aluno();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Aluno Registado com sucesso"));

    }

    public String newSave() {
        Aluno aluno = new Aluno();
        return "aluno_guardar?faces-redirect=true";
    }

    public String startEdit() {
        return "aluno_editar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        alunoDAO.update(aluno);
        alunos = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("aluno_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        alunoDAO.delete(aluno);
        alunos = null;
        return "aluno_listar?faces-redirect=true";
    }

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;

    }
    
    
    
      public static String getPathPastaAplicacaoJSF() {
        String separador = System.getProperty("file.separator");
        String pasta = "fotos"+ separador;
        String raizAplicacao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
       return raizAplicacao + pasta;
    }

}
