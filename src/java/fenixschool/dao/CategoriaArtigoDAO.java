/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Candidato;
import fenixschool.modelo.CategoriaArtigo;
import java.sql.Connection;
import fenixschool.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rei Santo Hangalo
 */
public class CategoriaArtigoDAO implements GenericoDAOLogico<CategoriaArtigo> {

    private static final String INSERIR = "INSERT INTO categoria_artigo (categoria_artigo)VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE categoria_artigo SET categoria_artigo=? WHERE id_categoria_artigo=?";
    private static final String ELIMINAR = "DELETE FROM categoria_artigo WHERE id_categoria_artigo=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT *FROM categoria_artigo WHERE id_categoria_artigo=?";
    private static final String LISTAR_TUDO = "SELECT * FROM categoria_artigo";

    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    @Override
    public boolean save(CategoriaArtigo categoriaArtigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaArtigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, categoriaArtigo.getCategoriaArtigo());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(CategoriaArtigo categoriaArtigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaArtigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, categoriaArtigo.getCategoriaArtigo());
            ps.setInt(2, categoriaArtigo.getIdCategoriaArtigo());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(CategoriaArtigo categoriaArtigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaArtigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoriaArtigo.getIdCategoriaArtigo());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public CategoriaArtigo findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CategoriaArtigo categoriaArtigo = new CategoriaArtigo();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o id:  " + id);
            }
            popularComDados(categoriaArtigo, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return categoriaArtigo;

    }

    @Override
    public List<CategoriaArtigo> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoriaArtigo> categorias = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaArtigo categoriaArtigo = new CategoriaArtigo();
                popularComDados(categoriaArtigo, rs);
                categorias.add(categoriaArtigo);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn);
        }

        return categorias;
    }

    @Override
    public void popularComDados(CategoriaArtigo categoriaArtigo, ResultSet rs) {
        try {
            categoriaArtigo.setIdCategoriaArtigo(rs.getInt("id_categoria_artigo"));
            categoriaArtigo.setCategoriaArtigo(rs.getString("categoria_artigo"));
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados"+ex.getLocalizedMessage());
        }
    
    }
}
