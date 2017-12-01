/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.ArtigoDAO;
import fenixschool.dao.CategoriaArtigoDAO;
import fenixschool.modelo.Artigo;
import fenixschool.modelo.CategoriaArtigo;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rei Santo Hangalo
 */
@Named(value = "artigoBean")
@SessionScoped
public class ArtigoBean implements Serializable {

    public static final long serialVersionUID = 1L;

    private Artigo artigo;
    private ArtigoDAO artigoDAO;
    private List<Artigo> artigos;
    private CategoriaArtigoDAO categoriaArtigoDAO;
    private List<CategoriaArtigo> categorias;

    private String codigo;
    private String codigoBarras;
    private String nome;
    private double preco;
    private String nomeCategoria;
    
    private List<Artigo> findByCodigo;
    private List<Artigo> findByCodigoBarras;
    private List<Artigo> findByNome;
    private List<Artigo> findByPreco;
    private List<Artigo> findByIdCategoria;

    public ArtigoBean() {
    }

    @PostConstruct
    public void inicializar() {
        artigo = new Artigo();
        artigoDAO = new ArtigoDAO();
        categoriaArtigoDAO = new CategoriaArtigoDAO();
        artigos = new ArrayList<>();
        categorias = new ArrayList<>();
        
        findByCodigo = new ArrayList<>();
        findByCodigoBarras = new ArrayList<>();
        findByNome = new ArrayList<>();
        findByPreco = new ArrayList<>();
        findByIdCategoria = new ArrayList<>();
        
    }
    
   

    public List<Artigo> getArtigos() {
        artigos = artigoDAO.findAll();
        return artigos;

    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public ArtigoDAO getArtigoDAO() {
        return artigoDAO;
    }

    public void setArtigoDAO(ArtigoDAO artigoDAO) {
        this.artigoDAO = artigoDAO;
    }

    public List<CategoriaArtigo> getCategorias() {
        return categorias = categoriaArtigoDAO.findAll();
    }

    public void setCategorias(List<CategoriaArtigo> categorias) {
        this.categorias = categorias;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
    
     public List<Artigo> getFindByCodigo() {
        findByCodigo = artigoDAO.buscarPorCodigo(codigo);
        return findByCodigo;
    }

    public void setFindByCodigo(List<Artigo> findByCodigo) {
        this.findByCodigo = findByCodigo;
    }

    public List<Artigo> getFindByCodigoBarras() {
        findByCodigoBarras = artigoDAO.buscarPorCodigoBarras(codigoBarras);
        return findByCodigoBarras;
    }

    public void setFindByCodigoBarras(List<Artigo> findByCodigoBarras) {
        this.findByCodigoBarras = findByCodigoBarras;
    }

    public List<Artigo> getFindByNome() {
        findByNome = artigoDAO.buscarNome(nome);
        return findByNome;
    }

    public void setFindByNome(List<Artigo> findByNome) {
        this.findByNome = findByNome;
    }

    public List<Artigo> getFindByPreco() {
        findByPreco = artigoDAO.buscarPreco(preco);
        return findByPreco;
    }

    public void setFindByPreco(List<Artigo> findByPreco) {
        this.findByPreco = findByPreco;
    }

     public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Artigo> getFindByIdCategoria() {
        findByIdCategoria = artigoDAO.buscarNomeCategoria(nomeCategoria);
        return findByIdCategoria;
    }

    public void setFindByIdCategoria(List<Artigo> findByIdCategoria) {
        this.findByIdCategoria = findByIdCategoria;
    }

    
    
    
    
    
    
    

    public void guardar(ActionEvent evt) {
        artigoDAO.save(artigo);
        artigo = new Artigo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Artigo Guardado com Sucesso"));
    }

    public void edit(ActionEvent event) {
        artigoDAO.update(artigo);
        artigos = null;
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar", "Artigo Actualizado com Sucesso"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("artigo_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ArtigoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        artigoDAO.delete(artigo);
        artigos = null;
        return "artigo_listar?faces-redirect=true";
    }

   
   
}
