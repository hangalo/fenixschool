/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author informatica
 */
public class UsuarioDAO implements GenericoDAO<Usuario>{
    
    
     private static final String INSERIR = "INSERT INTO usuario(nome_usuario, password_usuario)VALUES(?,?) ";
    private static final String ACTUALIZAR = " UPDATE usuario SET nome_usuario = ?, password_usuario = ? WHERE id_usuario = ?";
    private static final String ELIMINAR = "DELETE FROM fenixschoolem.usuario WHERE id_usuario = ?";
    private static final String BUSCAR_POR_CODIGO = " SELECT usuario.id_usuario, usuario.nome_usuario,usuario.password_usuario FROM fenixschoolem.usuario WHERE id_usuario = ?";
    private static final String LISTAR_TUDO = " SELECT usuario.id_usuario, usuario.nome_usuario, usuario.password_usuario FROM fenixschoolem.usuario";

    @Override
    public void save(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(Usuario t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
  
    
}
