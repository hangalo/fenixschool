/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.InstituicaoDAO;
import fenixschool.dao.MunicipioDAO;
import fenixschool.dao.ProfessorDAO;
import fenixschool.dao.ProvinciaDAO;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Professor;
import fenixschool.modelo.ProfessorDepartamento;
import fenixschool.modelo.Provincia;
import fenixschool.modelo.Sexo;
import fenixschool.util.DateUtil;
import fenixschool.util.FicheiroUtil;
import fenixschool.util.GestorImpressao;
import java.awt.event.ActionEvent;
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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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

    private ProfessorDAO professorDAO;
    private MunicipioDAO municipioDAO;
    private ProvinciaDAO provinciaDAO;
    private InstituicaoDAO instituicaoDAO;

    private List<Professor> professores;
    private List<Municipio> municipios;
    private List<Provincia> provincias;
    List<ProfessorDepartamento> professorDepartamentos;

    private Professor professor;
    private Provincia provincia;
    private Municipio municipio;
    private Departamento departamento;
    private ProfessorDepartamento professorDepartamento;

    // Variaveis para as consultas
    private String nome;
    private String sobrenome;
    private String numeroBI;
    private int anosServico;

    private Date inicioIntervalo;
    private Date fimIntervalo;

    public ProfessorMBean() {
    }

    @ManagedProperty(value = "#{gestorImpressao}")
    private GestorImpressao gestorImpressao;

    @PostConstruct
    public void inicializar() {

        professorDAO = new ProfessorDAO();
        provinciaDAO = new ProvinciaDAO();
        municipioDAO = new MunicipioDAO();
        instituicaoDAO = new InstituicaoDAO();

        professores = new ArrayList<>();
        municipios = new ArrayList<>();
        provincias = new ArrayList<>();
        professorDepartamentos = new ArrayList<>();

        professor = new Professor();
        municipio = new Municipio();
        departamento = new Departamento();
        professorDepartamento = new ProfessorDepartamento();

        provincias = provinciaDAO.findAll();

    }

    public Professor getProfessor() {
        return professor;
    }

    public GestorImpressao getGestorImpressao() {
        return gestorImpressao;
    }

    public void setGestorImpressao(GestorImpressao gestorImpressao) {
        this.gestorImpressao = gestorImpressao;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Date getInicioIntervalo() {
        return inicioIntervalo;
    }

    public void setInicioIntervalo(Date inicioIntervalo) {
        this.inicioIntervalo = inicioIntervalo;
    }

    public Date getFimIntervalo() {
        return fimIntervalo;
    }

    public void setFimIntervalo(Date fimIntervalo) {
        this.fimIntervalo = fimIntervalo;
    }

    public ProfessorDepartamento getProfessorDepartamento() {
        return professorDepartamento;
    }

    public void setProfessorDepartamento(ProfessorDepartamento professorDepartamento) {
        this.professorDepartamento = professorDepartamento;
    }

    public List<ProfessorDepartamento> getProfessorDepartamentos() {
        return professorDepartamentos;
    }

    public void setProfessorDepartamentos(List<ProfessorDepartamento> professorDepartamentos) {
        this.professorDepartamentos = professorDepartamentos;
    }

    public int getAnosServico() {
        return anosServico;
    }

    public void setAnosServico(int anosServico) {
        this.anosServico = anosServico;
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

    //Upload de ficheiros
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

    }

    public void guardar(ActionEvent evt) {

        if (professorDAO.save(professor)) {
            professor = new Professor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));
        }

    }

    public String startEdit() {
        return "professor_listar?faces-redirect=true";
    }

    public void edit(ActionEvent event) {
        if (professorDAO.update(professor)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado alterado com sucesso"));
            professores = null;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("professor_listar.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ProfessorMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Editar\t", "\tErro ao editar dados"));
        }

    }

    public String delete() {

        if (professorDAO.delete(professor)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso"));
            professores = null;
            return "professor_listar?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tErro ao eliminar dados"));
            return null;
        }
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

    public String pesquisaPorDepartamento() {

        Departamento depParamentro = professorDepartamento.getDepartamento();

        professorDepartamentos = professorDAO.findProfessorPorDepartamento(depParamentro, DateUtil.formataData(inicioIntervalo), DateUtil.formataData(fimIntervalo));

        return null;
    }

    public String imprimirCartaoProfessor() {

        String relatorio = "cartao_professor.jasper";
        HashMap parametros = new HashMap();
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

    public String imprimirListaProfessores() {
        String relatorio = "professores_lista_todos.jasper";
        HashMap parametros = new HashMap();
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

    public String imprimirProfessoresPorDepartamento() {
        Departamento dep = professorDepartamento.getDepartamento();
        String relatorio = "professores_por_departamento.jasper";
        HashMap parametros = new HashMap();
        parametros.put("departamento", dep.getNomeDepartamento());
        gestorImpressao.imprimirPDF(relatorio, parametros);

        return null;

    }

}
