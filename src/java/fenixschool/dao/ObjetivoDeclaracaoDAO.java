/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.ObjetivoDeclaracao;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulley
 */


public class ObjetivoDeclaracaoDAO implements GenericoDAO <ObjetivoDeclaracao>{
    
    private static final String INSERT = "INSERT INTO objetivo_declaracao (objetivo_declaracao) VALUES (?)";
    private static final String UPDATE = "UPDATE objetivo_declaracao SET objetivo_declaracao = ? WHERE id_objetivo_declaracao = ?";
    private static final String DELETE = "DELETE FROM objetivo_declaracao WHERE id_objetivo_declaracao = ?";
    private static final String SELECT_BY_ID= "SELECT id_objetivo_declaracao, objetivo_declaracao FROM objetivo_declaracao WHERE id_objetivo_declaracao = ?";
    private static final String SELECT_ALL = "SELECT id_objetivo_declaracao, objetivo_declaracao FROM objetivo_declaracao";

    @Override
    public void save(ObjetivoDeclaracao objetivoDeclaracao) {
        
    
        PreparedStatement ps = null;
        Connection conn = null;
        if (objetivoDeclaracao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, objetivoDeclaracao.getObjectivoDeclaracao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(ObjetivoDeclaracao objetivoDeclaracao) {
         
    
        PreparedStatement ps = null;
        Connection conn = null;
        if (objetivoDeclaracao == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, objetivoDeclaracao.getObjectivoDeclaracao());
            ps.setInt(2, objetivoDeclaracao.getIdObjetivoDeclaracao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao actualizar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(ObjetivoDeclaracao objetivoDeclaracao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (objetivoDeclaracao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, objetivoDeclaracao.getIdObjetivoDeclaracao());
            ps.executeUpdate();
        } catch (SQLException e) {
            
            System.err.println("Erro ao eliminar dados: " + e.getLocalizedMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
            
        }
    }

    @Override
    public ObjetivoDeclaracao findById(Integer id) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(objetivoDeclaracao, rs);
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return objetivoDeclaracao;
    }

    @Override
    public List<ObjetivoDeclaracao> findAll() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ObjetivoDeclaracao> objetivoDeclaracaos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
                popularComDados(objetivoDeclaracao, rs);
                objetivoDeclaracaos.add(objetivoDeclaracao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return objetivoDeclaracaos;
    }

    @Override
    public void popularComDados(ObjetivoDeclaracao objetivoDeclaracao, ResultSet rs) {
        try {
            objetivoDeclaracao.setIdObjetivoDeclaracao(rs.getInt("id_objetivo_declaracao"));
            objetivoDeclaracao.setObjectivoDeclaracao(rs.getString("objetivo_declaracao"));
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados: " + e.getLocalizedMessage());
        }
        
    }
}
    

