/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.FuncionarioDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Sexo;
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
 * @author Aisha Lubadika
 */
@ManagedBean
@ViewScoped
public class FuncionarioMBean implements Serializable{

    /**
     * Creates a new instance of FuncionarioMBean
     */
    
    private static final long serialVersionUID = 1L;

    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    private List<Funcionario> funcionarios;
     private MunicipioDAO municipioDAO;
  
    private List<Municipio> municipios;
    public FuncionarioMBean() {
    }

    @PostConstruct
    public void inicializar() {
        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();
        funcionarios = new ArrayList<>();
        municipios = new ArrayList<>();
        municipioDAO = new MunicipioDAO();
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
    
    public List<Municipio> getMunicipios() {
            
            municipios = municipioDAO.findAll();
        
        return municipios;
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
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
           File file = new File("C://fotos//" + arq.getFileName());
           
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
    
    public String newSave() {
        funcionario = new Funcionario();
        return "funcionario_listar?faces-redirect=true";
    }

      public void guardar(ActionEvent evt) {
        funcionarioDAO.save(funcionario);
        funcionario = new Funcionario();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Funcionario registado com sucesso"));
    }
    public String startEdit() {
        return "funcionario_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        funcionarioDAO.update(funcionario);
        funcionarios = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("funcionario_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProfessorMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String delete() {
        funcionarioDAO.delete(funcionario);
        funcionarios = null;
        return "funcionario_listar?faces-redirect=true";
    }   
    
    
}
