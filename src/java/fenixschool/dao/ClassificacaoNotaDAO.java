/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.ClassificacaoNota;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ClassificacaoNotaDAO implements GenericoDAO <ClassificacaoNota>{
    
    private static final String INSERT = "INSERT INTO classificacao_nota (classificacao_nota) VALUES (?)";
    private static final String UPDATE = "UPDATE classificacao_nota SET classificacao_nota = ? WHERE id_classificacao_nota = ?";
    private static final String DELETE = "DELETE FROM classificacao_nota WHERE id_classificacao_nota = ?";
    private static final String SELECT_BY_ID= "SELECT id_classificacao_nota, classificacao_nota FROM classificacao_nota WHERE id_classificacao_nota = ?";
    private static final String SELECT_ALL = "SELECT id_classificacao_nota, classificacao_nota FROM classificacao_nota";
    

    @Override
    public void save(ClassificacaoNota classificacaoNota) {
    
        PreparedStatement ps = null;
        Connection conn = null;
        if (classificacaoNota == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, classificacaoNota.getClassificacaoNota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
        
    }

    @Override
    public void update(ClassificacaoNota classificacaoNota) {   
    
        PreparedStatement ps = null;
        Connection conn = null;
        if (classificacaoNota == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, classificacaoNota.getClassificacaoNota());
            ps.setInt(2, classificacaoNota.getIdClassificacaoNota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao actualizar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    @Override
    public void delete(ClassificacaoNota classificacaoNota) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (classificacaoNota == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, classificacaoNota.getIdClassificacaoNota());
            ps.executeUpdate();
        } catch (SQLException e) {
            
            System.err.println("Erro ao eliminar dados: " + e.getLocalizedMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
            
        }
    }

    @Override
    public ClassificacaoNota findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        ClassificacaoNota classificacaoNota = new ClassificacaoNota();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(classificacaoNota, rs);
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return classificacaoNota;}

    @Override
    public List<ClassificacaoNota> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ClassificacaoNota> classificacaoNotas = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassificacaoNota classificacaoNota = new ClassificacaoNota();
                popularComDados(classificacaoNota, rs);
                classificacaoNotas.add(classificacaoNota);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return classificacaoNotas;}

    @Override
    public void popularComDados(ClassificacaoNota classificacaoNota, ResultSet rs) {
    
        try {
            classificacaoNota.setIdClassificacaoNota(rs.getInt("id_classificacao_nota"));
            classificacaoNota.setClassificacaoNota(rs.getString("classificacao_nota"));
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados: " + e.getLocalizedMessage());
        }
        
    }

    
    
}
