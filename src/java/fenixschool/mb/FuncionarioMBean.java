/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.FuncionarioDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.Municipio;
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
 * @author Aisha Lubadika
 */
@ManagedBean(name = "funcionarioMBean")
@SessionScoped
public class FuncionarioMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Funcionario funcionario;
    private List<Provincia> provincias;
    private FuncionarioDAO funcionarioDAO;
    private ProvinciaDAO provinciaDAO;
    private List<Funcionario> funcionarios;
    private MunicipioDAO municipioDAO;
    private Municipio municipio;
    private List<Municipio> municipios;

    /*variaveis para as consultas*/
    private String nome;
    private String sobrenome;
    private Date dataDeNascimento;

   
    private Provincia provincia;
    private Departamento departamento;
    private List<Funcionario> findBydataNascimento;
    

    public FuncionarioMBean() {
    }

    @PostConstruct
    public void inicializar() {
        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();
        funcionarios = new ArrayList<>();
        municipios = new ArrayList<>();
        provinciaDAO = new ProvinciaDAO();
        municipio = new Municipio();
        municipioDAO = new MunicipioDAO();
        findBydataNascimento = new ArrayList<>();
        provincias = new ArrayList<>();
        provincias = provinciaDAO.findAll();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
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

    public List<Municipio> getMunicipios() {
        return municipios;
    }
     public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /*Metodos*/
    //carregar provincias
    public List<Provincia> getProvincias() {
        return provincias;
    }

    // carrega municipios em função da provincia
    public void carregaMunicipiosDaProvincia() {
        System.out.println("Provncia >>>>>" + provincia);
        municipios = municipioDAO.findByIdProvincia2(provincia);
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
    }

    public List<Funcionario> getFindBydataNascimento() {
        findBydataNascimento = funcionarioDAO.findByDataNascimento((java.sql.Date) dataDeNascimento);
       
        return findBydataNascimento;
    }

    public void setFindBydataNascimento(List<Funcionario> findBydataNascimento) {
        this.findBydataNascimento = findBydataNascimento;
    }

    public void fileUpload(FileUploadEvent event) {
        try {

            //Cria um objeto do tipo UploadedFile, para receber o ficheiro do evento
            UploadedFile arq = event.getFile();

            //transformar a imagem em bytes para guardar na base de dados  
            byte[] foto = IOUtils.toByteArray(arq.getInputstream());

            funcionario.setFotoFuncionario(foto);
            funcionario.setUrlfotoFuncionario(arq.getFileName());

            //para guardar o ficheiro num pasta local (no disco duro)
            InputStream in = new BufferedInputStream(arq.getInputstream());
            File file = new File(FicheiroUtil.getPathPastaAplicacaoJSF() + arq.getFileName());

            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();

            FacesMessage msg = new FacesMessage("Foto:\t", arq.getFileName() + "\tCarregada com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public String newSave() {
        funcionario = new Funcionario();
        return "funcionario_listar?faces-redirect=true";
    }

    public void guardar(ActionEvent evt) {
        if (funcionarioDAO.save(funcionario)) {
            funcionario = new Funcionario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));

        }
        
       

    }

    public String startEdit() {
        return "funcionario_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (funcionarioDAO.update(funcionario)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            funcionarios = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("funcionario_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));

        }

    }

    public String delete() {
        if (funcionarioDAO.delete(funcionario)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            funcionarios = null;
            return "funcionario_listar?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;
        }
    }

    public Funcionario getByNomeSobrenome() {

        if ((getNome() == null || getNome().isEmpty()) && (getSobrenome() == null)) {
            return null;

        } else if (((getSobrenome() == null) || (getSobrenome().isEmpty())) && ((getNome() != null || !getNome().isEmpty()))) {
            funcionario = funcionarioDAO.findBySobrenome(sobrenome);
            return funcionario;
        } else if ((getNome() == null || getNome().isEmpty() && getSobrenome() != null)) {
            funcionario = funcionarioDAO.findBySobrenome(sobrenome);

            return funcionario;
        } else if ((getNome() != null || !getNome().isEmpty()) && (getSobrenome() != null || !getSobrenome().isEmpty())) {
            funcionario = funcionarioDAO.findByNomeSobrenome(nome, sobrenome);
            return funcionario;
        }
        return null;
    }
    
    
            

    public static String getPathPastaAplicacaoJSF() {
        String separador = System.getProperty("file.separator");
        String pasta = "fotos" + separador;
        String raizAplicacao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        return raizAplicacao + pasta;
    }

}
