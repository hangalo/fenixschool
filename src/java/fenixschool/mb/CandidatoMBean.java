/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.CandidatoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.Candidato;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
import fenixschool.modelo.Provincia;
import fenixschool.modelo.Sexo;
import fenixschool.util.DateUtil;
import fenixschool.util.FicheiroUtil;
import fenixschool.util.GestorImpressao;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Elísio Kavaimunwa
 */
@ManagedBean(name = "candidatoMBean")
@ViewScoped

public class CandidatoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Candidato candidato;
    private Provincia provincia; // utilizado no metodo findByIdProvincia do municipio
    private Municipio municipio;
    private String nome;
    private String sobrenome;
    private Date dataDeNascimento;
    private String sexo;
    private String Bi;
    private String numero;
    
    private Date inicioIntervalo;
    private Date fimIntervalo;

    private List<Candidato> candidatos;
    private List<Municipio> municipios;
    private List<Profissao> profissoes;
    private CandidatoDAO candidatoDAO;
    private MunicipioDAO municipioDAO;
    private ProfissaoDAO profissaoDAO;
    private List<Provincia> provincias;
    private ProvinciaDAO provinciaDAO;

    private List<Candidato> findByNomeSobrenome;
    private List<Candidato> findByNome;
    private List<Candidato> findBySobrenome;
    private List<Candidato> findBySexo;
    private List<Candidato> findBydataNascimento;

    public CandidatoMBean() {
    }
    
    @ManagedProperty(value = "#{gestorImpressao}")
    private GestorImpressao gestorImpressao;
    

    @PostConstruct
    public void inicializar() {
        candidato = new Candidato();
        candidatoDAO = new CandidatoDAO();
        profissaoDAO = new ProfissaoDAO();
        municipioDAO = new MunicipioDAO();
        provinciaDAO = new ProvinciaDAO();
        candidatos = new ArrayList<>();
        municipios = new ArrayList<>();
        profissoes = new ArrayList<>();
        municipio = new Municipio();
        findByNomeSobrenome = new ArrayList<>();
        findByNome = new ArrayList<>();
        findBySobrenome = new ArrayList<>();
        findBySexo = new ArrayList<>();
        findBydataNascimento = new ArrayList<>();
        provincias = provinciaDAO.findAll();

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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getBi() {
        return Bi;
    }

    public void setBi(String Bi) {
        this.Bi = Bi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Date getFimIntervalo() {
        return fimIntervalo;
    }

    public void setFimIntervalo(Date fimIntervalo) {
        this.fimIntervalo = fimIntervalo;
    }
    
    public Date getInicioIntervalo() {
        return inicioIntervalo;
    }

    public void setInicioIntervalo(Date inicioIntervalo) {
        this.inicioIntervalo = inicioIntervalo;
    }

    public GestorImpressao getGestorImpressao() {
        return gestorImpressao;
    }

    public void setGestorImpressao(GestorImpressao gestorImpressao) {
        this.gestorImpressao = gestorImpressao;
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
        if (candidatoDAO.save(candidato)){
            candidato = new Candidato();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }
    }

    public String startEdit() {
        return "candidato_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (candidatoDAO.update(candidato)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            candidatos = null;

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("candidato_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CandidatoMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }

    }

    public String delete() {
        if (candidatoDAO.delete(candidato)) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso!"));
             candidatos = null;
             return "candidato_listar?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados!"));
            return null;
        }      
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
        return municipios;
    }

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
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

    public Candidato getByNumero() {
        candidato = candidatoDAO.findByNumero(numero);
        return candidato;
    }

    public List<Candidato> getByDataNascimento() {
        /*String inicioDataFormatada = DateUtil.formataData(inicioIntervalo);
        String fimDataFormatada = DateUtil.formataData(fimIntervalo);
        findBydataNascimento = candidatoDAO.findByDataDeNascimento(inicioDataFormatada, fimDataFormatada);
        return findBydataNascimento;*/
        
        return null;
                
       
    }

    public List<Candidato> getBySexo() {
        findBySexo = candidatoDAO.findBySexo(sexo);
        return findBySexo;
    }

    public List<Candidato> getByNomeSobrenome(){

        if ((getNome() == null || getNome().isEmpty()) && (getSobrenome() == null)) {
            return null;

        } else if (((getSobrenome() == null) || (getSobrenome().isEmpty())) && ((getNome() != null || !getNome().isEmpty()))) {
            findByNome = candidatoDAO.findByNome(nome);
            return findByNome;
        } else if ((getNome() == null || getNome().isEmpty() && getSobrenome() != null)) {
            findBySobrenome = candidatoDAO.findBySobrenome(sobrenome);
            return findBySobrenome;
        } else if ((getNome() != null || !getNome().isEmpty()) && (getSobrenome() != null || !getSobrenome().isEmpty())) {
            findByNomeSobrenome = candidatoDAO.findByNomeSobrenome(nome, sobrenome);
            return findByNomeSobrenome;
        }
        return null;
    }

     public String imprimirListaArtigo() {
        String relatorio = "candidato_lista.jasper";
        HashMap parametros = new HashMap();
        gestorImpressao = new GestorImpressao(); // Analisar essa instrução. 
        gestorImpressao.imprimirPDF(relatorio, parametros);
        return null;

    }
    


    
}
