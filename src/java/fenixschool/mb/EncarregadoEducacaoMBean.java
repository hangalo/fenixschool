/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.EncarregadoEducacaoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfissaoDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.EncarregadoEducacao;
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
 * @author PENA
 */
@ManagedBean(name = "encarregadoEducacaoMBean")
@SessionScoped

public class EncarregadoEducacaoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private EncarregadoEducacao encarregadoEducacao;

    private List<EncarregadoEducacao> encarregadoEducacoes;
    private List<Profissao> profissoes;
    private ProfissaoDAO profissaoDAO;
    private EncarregadoEducacaoDAO encarregadoEducacaoDAO;
    private List<Municipio> municipios;
    private MunicipioDAO municipioDAO;
    private ProvinciaDAO provinciaDAO;
    private List<Provincia> provincias;

    //variaveis auxiliar para localizar um determinando encarregado em funcao
    //do parametro fornecido
    private String nome;
    private String sobrenome;
    private List<EncarregadoEducacao> listaEncarregadoBySexo;
    private List<EncarregadoEducacao> buscarEncarregagoByNomeSobrenome;
    private List<EncarregadoEducacao> buscarEncarregadoByNome;
    private Provincia provincia;
    private String sexo;

    @PostConstruct
    public void inicializar() {
        encarregadoEducacao = new EncarregadoEducacao();
        encarregadoEducacaoDAO = new EncarregadoEducacaoDAO();
        encarregadoEducacoes = new ArrayList<>();
        profissaoDAO = new ProfissaoDAO();
        profissoes = new ArrayList<>();
        provinciaDAO = new ProvinciaDAO();
        provincias = provinciaDAO.findAll();
        municipioDAO = new MunicipioDAO();
        municipios = new ArrayList<>();
    }

    public EncarregadoEducacao getEncarregadoEducacao() {
        return encarregadoEducacao;
    }

    public void setEncarregadoEducacao(EncarregadoEducacao encarregadoEducacao) {
        this.encarregadoEducacao = encarregadoEducacao;
    }

    public List<EncarregadoEducacao> getEncarregadoEducacoes() {
        encarregadoEducacoes = encarregadoEducacaoDAO.findAll();
        return encarregadoEducacoes;
    }

    public void setEncarregadoEducacoes(List<EncarregadoEducacao> encarregadoEducacoes) {
        this.encarregadoEducacoes = encarregadoEducacoes;
    }

    public void guardar(ActionEvent evt) {

        encarregadoEducacaoDAO.save(encarregadoEducacao);
        encarregadoEducacao = new EncarregadoEducacao();
        FacesMessage msg = new FacesMessage("Guardar", "Encarregado registado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Profissao> getProssifoes() {
        profissoes = profissaoDAO.findAll();
        return profissoes;
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

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //Retorna lista de encarregados por Encarregados por sexo
    public List<EncarregadoEducacao> getListaEncarregadoBySexo() {
        listaEncarregadoBySexo = encarregadoEducacaoDAO.findBySexo(sexo);
        return listaEncarregadoBySexo;
    }

    public void setListaEncarregadoBySexo(List<EncarregadoEducacao> listaEncarregadoBySexo) {
        this.listaEncarregadoBySexo = listaEncarregadoBySexo;
    }

    //Retorna lista de encarregados com nomes e sobrenomes digtados
    public List<EncarregadoEducacao> getBuscarEncarregagoByNomeSobrenome() {
        buscarEncarregagoByNomeSobrenome = encarregadoEducacaoDAO.findByNomeSobrenome(nome, sobrenome);
        return buscarEncarregagoByNomeSobrenome;
    }

    public void setBuscarEncarregagoByNomeSobrenome(List<EncarregadoEducacao> buscarEncarregagoByNomeSobrenome) {
        this.buscarEncarregagoByNomeSobrenome = buscarEncarregagoByNomeSobrenome;
    }

    public List<EncarregadoEducacao> getBuscarEncarregadoByNome() {
        buscarEncarregadoByNome = encarregadoEducacaoDAO.findByNome(nome);
        return buscarEncarregadoByNome;
    }

    public void setBuscarEncarregadoByNome(List<EncarregadoEducacao> buscarEncarregadoByNome) {
        this.buscarEncarregadoByNome = buscarEncarregadoByNome;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    //Carrega municipios de cada provincia
    public void carregarMunicipiosDaProvincia() {
        System.out.println("Provincias >>>>>" + provincia);
        municipios = municipioDAO.findByIdProvincia2(provincia);
    }

    public void fileUpload(FileUploadEvent event) {

        try {

            //cria um objecto do tipo UploadedFile para receber o objecto
            UploadedFile arquivo = event.getFile();

            //Transforma o objecto em Byte para ser guardado no banco de dados
            byte[] foto = IOUtils.toByteArray(arquivo.getInputstream());
            encarregadoEducacao.setFotoEncarregado(foto);
            encarregadoEducacao.setUrlFotoEncarregado(arquivo.getFileName());

            //comandos para guardar o objecto numa pasta local ou num disco duro
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
            e.printStackTrace(System.out);
        }

    }

    public void edit(java.awt.Event event) {
        encarregadoEducacaoDAO.update(encarregadoEducacao);
        encarregadoEducacao = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Encarregado actualizado com sucesso!"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("encarregado_educacao_listar.jsf");

        } catch (IOException e) {
            java.util.logging.Logger.getLogger(EncarregadoEducacaoMBean.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public String delete() {
        encarregadoEducacaoDAO.delete(encarregadoEducacao);
        encarregadoEducacao = null;
        return "encarregado_educacao_listar?faces-redirect=true";
    }

    /*
    public EncarregadoEducacao getEncarregadoByNomeSobrenome() {

        if ((getNome().isEmpty() || getNome() == null) && (getSobrenome().isEmpty() || getSobrenome() == null)) {
            return null;
        } else if ((!getNome().isEmpty() || getNome() != null) && (!getSobrenome().isEmpty() || getSobrenome() != null)) {
            encarregadoEducacao = encarregadoEducacaoDAO.findByNomeSobrenome(nome, sobrenome);
            return encarregadoEducacao;
        }
        return null;
    }*/
}
