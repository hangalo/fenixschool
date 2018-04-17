/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Andar;
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
public class AndarDAO implements GenericoDAOLogico<Andar> {
    
        
    private static final String INSERIR = "INSERT INTO andar_edificio(nome_andar_edificio)VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE andar_edificio SET id_andar_edificio=?, nome_andar_edificio=? WHERE id_andar_edificio=?";
    private static final String ELIMINAR = "DELETE FROM andar_edificio WHERE id_andar_edificio=?";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM andar_edificio WHERE id_andar_edificio=?";
    private static final String LISTAR_TUDO ="SELECT * FROM andar:edificio  ORDER BY id_andar_edificio ASC";
    

    @Override
    public boolean save(Andar andar) {
          PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (andar == null) {
            System.err.println("O valor passado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
           ps.setString(1, andar.getNomeAndar());
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
    public boolean update(Andar andar) {
           PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (andar == null) {
            System.err.println("O valor oassado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
          
            ps.setString(1, andar.getNomeAndar());
            ps.setInt(2, andar.getIdAndar());
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
    public boolean delete(Andar andar) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (andar == null) {
            System.err.println("O valor oassado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

            ps.setInt(1, andar.getIdAndar());
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
    public Andar findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;

        ResultSet rs = null;
        Andar andar = new Andar();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(andar, rs);

        } catch (Exception e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
         
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return andar;
    }

    @Override
    public List<Andar> findAll() {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Andar> andares = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Andar andar = new Andar();
                popularComDados(andar, rs);
                andares.add(andar);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return andares;
    }

    @Override
    public void popularComDados(Andar andar, ResultSet rs) {
        try {
            andar.setIdAndar(rs.getInt("id_andar_edificio"));
            andar.setNomeAndar(rs.getString("nome_andar_edificio"));
        } catch (Exception ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }
        
    }
    

  
    
}
