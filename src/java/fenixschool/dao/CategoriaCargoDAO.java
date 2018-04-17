/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CategoriaCargo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aisha Lubadika
 */
public class CategoriaCargoDAO implements GenericoDAOLogico<CategoriaCargo>{
    
     private static final String INSERIR = "INSERT INTO categoria_cargo (categoria_cargo)VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE categoria_cargo SET categoria_cargo=? WHERE id_categoria_cargo=?";
    private static final String ELIMINAR = "DELETE FROM categoria_cargo WHERE id_categoria_cargo=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM categoria_cargo WHERE id_categoria_cargo=?";
    private static final String LISTAR_TUDO = "SELECT * FROM categoria_cargo";

    
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    public boolean save(CategoriaCargo categoriaCargo) {
         Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaCargo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, categoriaCargo.getCategoriaCargo());

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
    public boolean update(CategoriaCargo categoriaCargo) {
      Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaCargo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, categoriaCargo.getCategoriaCargo());
            ps.setInt(2, categoriaCargo.getIdCategoriaCargo());

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
    public boolean delete(CategoriaCargo categoriaCargo) {
          Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (categoriaCargo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoriaCargo.getIdCategoriaCargo());

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
    public CategoriaCargo findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CategoriaCargo categoriaCargo = new CategoriaCargo();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o id:  " + id);
            }
            popularComDados(categoriaCargo, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return categoriaCargo;
    }

    @Override
    public List<CategoriaCargo> findAll() {
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoriaCargo> categoriaCargos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaCargo categoriaCargo = new CategoriaCargo();
                popularComDados(categoriaCargo, rs);
                categoriaCargos.add(categoriaCargo);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn);
        }

        return categoriaCargos;
    }

    @Override
    public void popularComDados(CategoriaCargo categoriaCargo, ResultSet rs) {
       try {
            categoriaCargo.setIdCategoriaCargo(rs.getInt("id_categoria_cargo"));
            categoriaCargo.setCategoriaCargo(rs.getString("categoria_cargo"));
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados"+ex.getLocalizedMessage());
        }
    }
    
}
