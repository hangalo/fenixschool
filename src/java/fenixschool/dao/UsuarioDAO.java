/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Usuario;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class UsuarioDAO implements GenericoDAOLogico<Usuario> {

    private static final String INSERIR = "INSERT INTO usuario(nome_usuario, password_usuario)VALUES(?,?) ";
    private static final String ACTUALIZAR = " UPDATE usuario SET nome_usuario = ?, password_usuario = ? WHERE id_usuario = ?";
    private static final String ELIMINAR = "DELETE FROM fenixschoolem.usuario WHERE id_usuario = ?";
    private static final String BUSCAR_POR_CODIGO = " SELECT usuario.id_usuario, usuario.nome_usuario,usuario.password_usuario FROM fenixschoolem.usuario WHERE id_usuario = ?";
    private static final String LISTAR_TUDO = " SELECT usuario.id_usuario, usuario.nome_usuario, usuario.password_usuario FROM fenixschoolem.usuario";

    @Override
    public boolean save(Usuario usuario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (usuario == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getPasswordUsuario());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Usuario usuario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (usuario == null) {
            System.err.println("O valor oassado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getPasswordUsuario());
            ps.setInt(3, usuario.getIdUsuario());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception e) {
            System.out.println("Erro ao actualizar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Usuario usuario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (usuario == null) {
            System.err.println("O valor oassado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

            ps.setInt(1, usuario.getIdUsuario());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eleiminar com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception e) {
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Usuario findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;

        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(usuario, rs);

        } catch (Exception e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
         
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                popularComDados(usuario, rs);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return usuarios;
    }

    @Override
    public void popularComDados(Usuario usuario, ResultSet rs) {
        try {
            usuario.setIdUsuario(rs.getInt("id_usuario"));
            usuario.setNomeUsuario(rs.getString("nome_usuario"));
            usuario.setPasswordUsuario(rs.getString("password_usuario"));
            
        } catch (Exception ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }
    }

}
