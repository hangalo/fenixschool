/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.AlunoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.Aluno;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
import fenixschool.modelo.Provincia;
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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

public class AlunoMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String sobrenome;
    private String numeroBi;
    private String sexo;
    private Date dataDeNascimento;
    
    private Aluno aluno;
    private Provincia provincia;
    private Municipio municipio;
    private AlunoDAO alunoDAO;
    private MunicipioDAO municipioDAO;
    private ProfissaoDAO profissaoDAO;
    private ProvinciaDAO provinciaDAO;
    private List<Aluno> alunos;
    private List<Provincia> provincias;
    private List<Municipio> municipios;
    private List<Profissao> profissoes;
    
    
    private List <Aluno> findByNomeSobrenome;
    private List <Aluno> findByNome;
    private List <Aluno> findBySobrenome;
    private List <Aluno> findBySexo;
    private List <Aluno> findByDataNascimento;

    public AlunoMBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        aluno = new Aluno();
        alunoDAO = new AlunoDAO();
        
        profissaoDAO = new ProfissaoDAO();
        municipioDAO = new MunicipioDAO();
        provinciaDAO = new ProvinciaDAO();
        municipios = new ArrayList<>();
        profissoes = new ArrayList<>();
        municipio = new Municipio();
        provincia = new Provincia();
        provincias = new ArrayList<>();
        provincias = provinciaDAO.findAll();
        findByNomeSobrenome = new ArrayList<>();
        findByNome = new ArrayList<>();
        findBySobrenome = new ArrayList<>();
        findBySexo = new ArrayList<>();
        findByDataNascimento = new ArrayList<>();
    }

    public Aluno getAluno() {
        return aluno;
    }


    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public MunicipioDAO getMunicipioDAO() {
        return municipioDAO;
    }

    public void setMunicipioDAO(MunicipioDAO municipioDAO) {
        this.municipioDAO = municipioDAO;
    }

    public ProfissaoDAO getProfissaoDAO() {
        return profissaoDAO;
    }

    public void setProfissaoDAO(ProfissaoDAO profissaoDAO) {
        this.profissaoDAO = profissaoDAO;
    }

    public ProvinciaDAO getProvinciaDAO() {
        return provinciaDAO;
    }

    public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
        this.provinciaDAO = provinciaDAO;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO.findAll();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Provincia> getProvincias() {
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

    public List<Profissao> getProfissoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public List<Aluno> getFindByNomeSobrenome() {
        return findByNomeSobrenome;
    }

    public void setFindByNomeSobrenome(List<Aluno> findByNomeSobrenome) {
        this.findByNomeSobrenome = findByNomeSobrenome;
    }

    public List<Aluno> getFindByNome() {
        return findByNome;
    }

    public void setFindByNome(List<Aluno> findByNome) {
        this.findByNome = findByNome;
    }

    public List<Aluno> getFindBySobrenome() {
        return findBySobrenome;
    }

    public void setFindBySobrenome(List<Aluno> findBySobrenome) {
        this.findBySobrenome = findBySobrenome;
    }

    public List<Aluno> getFindBySexo() {
        return findBySexo;
    }

    public void setFindBySexo(List<Aluno> findBySexo) {
        this.findBySexo = findBySexo;
    }

    public List<Aluno> getFindByDataNascimento() {
        return findByDataNascimento;
    }

    public void setFindByDataNascimento(List<Aluno> findByDataNascimento) {
        this.findByDataNascimento = findByDataNascimento;
    }

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

    public String getNumeroBi() {
        return numeroBi;
    }

    public void setNumeroBi(String numeroBi) {
        this.numeroBi = numeroBi;
    }

    

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
    
    
    
    
    // carrega municipios em função da provincia
    public void carregaMunicipiosDaProvincia() {
        System.out.println("Provncia >>>>>" + provincia);
        municipios = municipioDAO.findByIdProvincia2(provincia);
    }
    
    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
        }
        return list;
    }

    
    
    public void fileUpload(FileUploadEvent event) {
        try {

            //Cria um objeto do tipo UploadedFile, para receber o ficheiro do evento
            UploadedFile arquivo = event.getFile();

            //transformar a imagem em bytes para guardar na base de dados  
            byte[] foto = IOUtils.toByteArray(arquivo.getInputstream());
            aluno.setFotoAluno(foto);
            aluno.setUrlfotoAluno(arquivo.getFileName());

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
            System.out.println("Erro ao carregar foto. ");
            e.printStackTrace(System.out);
        }
    }
    
    public String newSave(){
        aluno = new Aluno();
        return "aluno_listar?faces-redirect=true";
    }
    
    public void guardar (javafx.event.ActionEvent evt){
        if(alunoDAO.save(aluno)){
            aluno = new Aluno();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }
    
    public String startEdit() {
        return "aluno_listar?faces-redirect=true";
    }
    
    public void edit (ActionEvent event){
        if(alunoDAO.update(aluno)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            alunos = null;
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("aluno_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CandidatoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }
    }
    
    public String delete(){
        if (alunoDAO.delete(aluno)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            alunos = null;
            return "aluno_listar?faces-redirect=true";
        }
        else {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;}
    }
    
    public static String getPathPastaAplicacaoJSF() {
        String separador = System.getProperty("file.separator");
        String pasta = "fotos" + separador;
        String raizAplicacao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        return raizAplicacao + pasta;
    }
    
    public List<Aluno> getByNomeSobrenome(){

        if ((getNome() == null || getNome().isEmpty()) && (getSobrenome() == null)) {
            return null;

        } else if (((getSobrenome() == null) || (getSobrenome().isEmpty())) && ((getNome() != null || !getNome().isEmpty()))) {
            findByNome = alunoDAO.findByNome(nome);
            return findByNome;
        } else if ((getNome() == null || getNome().isEmpty() && getSobrenome() != null)) {
            findBySobrenome = alunoDAO.findBySobrenome(sobrenome);
            return findBySobrenome;
        } else if ((getNome() != null || !getNome().isEmpty()) && (getSobrenome() != null || !getSobrenome().isEmpty())) {
            findByNomeSobrenome = alunoDAO.findByNomeSobrenome(nome, sobrenome);
            return findByNomeSobrenome;
        }
        return null;
    }

    public Aluno getByNumeroBi() {
        aluno = alunoDAO.findByNumeroBi(numeroBi);
        return aluno;
    }
    
    public List<Aluno> getBySexo() {
        findBySexo = alunoDAO.findBySexo(sexo);
        return findBySexo;
    }
    
    public List<Aluno> getByDataNascimento() {
        findByDataNascimento = alunoDAO.findByDataDeNascimento((java.sql.Date) dataDeNascimento);
        return findByDataNascimento;
    }
    
    
}