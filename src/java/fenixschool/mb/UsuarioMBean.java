/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import fenixschool.dao.UsuarioDAO;
import fenixschool.modelo.Usuario;
import java.awt.event.ActionEvent;
import java.io.IOException;
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

/**
 *
 * @author Aisha Lubadika
 */
@ManagedBean(name = "usuarioMBean")
@ViewScoped
public class UsuarioMBean implements Serializable {

    public static final long serialVersionUID = 1L;
    private Usuario  usuario= new Usuario();
    private UsuarioDAO usuarioDAO;
    private List<Usuario> usuarios;
    
    
    public UsuarioMBean() {
    }
    @PostConstruct
    public void inicializar() {
    
        usuarioDAO = new UsuarioDAO();
        usuarios= new ArrayList<>();   
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    

    public List<Usuario> getUsuarios() {
        usuarios= usuarioDAO.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
      public void guardar(ActionEvent evt) {
       usuarioDAO.save(usuario);
       usuario = new Usuario();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Turma Registado com sucesso"));  

    }

    

    public void edit(ActionEvent event) {
        usuarioDAO.update(usuario);
        usuarios = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("usuario_listar.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String delete() {
        usuarioDAO.delete(usuario);
        usuarios = null;
        return "usuario_listar?faces-redirect=true";
    }
    
    
}
