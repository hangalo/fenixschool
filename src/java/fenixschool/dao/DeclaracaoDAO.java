/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Declaracao;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.ObjetivoDeclaracao;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kulley
 */


public class DeclaracaoDAO implements GenericoDAO <Declaracao> {
    private static final String INSERT = "INSERT INTO delcaracao (texto_teclaracao, data_declaracao, id_funcionario, id_objetivo_declaracao, id_aluno) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE delcaracao SET texto_teclaracao = ?, data_declaracao = ?, id_funcionario = ?, id_objetivo_declaracao = ?, id_aluno = ? WHERE id_delcaracao = ?";
    private static final String DELETE = "DELETE FROM delcaracao WHERE id_delcaracao = ?";
    private static final String SELECT_BY_ID = "SELECT d.id_delcaracao, d.texto_teclaracao, d.data_declaracao, f.nome_funcionario, o.objetivo_declaracao, a.nome_aluno"
            + "FROM delcaracao d"
            + "INNER JOIN funcionario f on f.id_funcionario=d.id_funcionario"
            + "INNER JOIN objetivo_declaracao o on o.id_objetivo_declaracao=d.id_objetivo_declaracao"
            + "INNER JOIN aluno a on a.id_aluno=d.id_aluno"
            + "WHERE id_delcaracao = ?"
            + ";";
    private static final String SELECT_ALL = "SELECT d.id_delcaracao, d.texto_teclaracao, d.data_declaracao, f.nome_funcionario, o.objetivo_declaracao, a.nome_aluno"
            + "FROM delcaracao d"
            + "INNER JOIN funcionario f on f.id_funcionario=d.id_funcionario"
            + "INNER JOIN objetivo_declaracao o on o.id_objetivo_declaracao=d.id_objetivo_declaracao"
            + "INNER JOIN aluno a on a.id_aluno=d.id_aluno"
            + ";";

    @Override
    public void save(Declaracao declaracao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (declaracao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, declaracao.getTextoDeclaracao());
            ps.setDate(2, new java.sql.Date(declaracao.getDataDeclaracao().getTime()));
            ps.setInt(3, declaracao.getIdFuncionario().getIdFuncionario());
            ps.setInt(4,declaracao.getIdObjetivoDeclaracao().getIdObjetivoDeclaracao());
            ps.setInt(5, declaracao.getIdAluno().getIdAluno());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    }

    @Override
    public void update(Declaracao declaracao) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        if (declaracao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, declaracao.getTextoDeclaracao());
            ps.setDate(2, new java.sql.Date(declaracao.getDataDeclaracao().getTime()));
            ps.setInt(3, declaracao.getIdFuncionario().getIdFuncionario());
            ps.setInt(4,declaracao.getIdObjetivoDeclaracao().getIdObjetivoDeclaracao());
            ps.setInt(5, declaracao.getIdAluno().getIdAluno());
            ps.setInt(6, declaracao.getIdDeclaracao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao actualizar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    }

    @Override
    public void delete(Declaracao declaracao) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        if (declaracao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);            
            ps.setInt(1, declaracao.getIdDeclaracao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        System.out.println("Erro ao eliminar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        }

    @Override
    public Declaracao findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Declaracao declaracao = new Declaracao();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(declaracao, rs);
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return declaracao;
    }

    @Override
    public List<Declaracao> findAll() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Declaracao> declaracaos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Declaracao declaracao = new Declaracao();
                popularComDados(declaracao, rs);
                declaracaos.add(declaracao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return declaracaos;
    }

    @Override
    public void popularComDados(Declaracao declaracao, ResultSet rs) {
        Aluno aluno = new Aluno();
        Funcionario funcionario = new Funcionario();
        ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
        
        try {
            aluno.setIdAluno(rs.getInt("id_aluno"));
            objetivoDeclaracao.setIdObjetivoDeclaracao(rs.getInt("id_objetivo_declaracao"));
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            
            declaracao.setIdDeclaracao(rs.getInt("id_delcaracao"));
            declaracao.setTextoDeclaracao(rs.getString("texto_teclaracao"));
            declaracao.setDataDeclaracao(rs.getDate("data_declaracao"));
            declaracao.setIdFuncionario(funcionario);
            declaracao.setIdObjetivoDeclaracao(objetivoDeclaracao);
            declaracao.setIdAluno(aluno);
            
            
        } catch (SQLException e) {
            System.err.println("Erro ao carregar dados: " + e.getLocalizedMessage());
        }
        
        
        
    }
    
}
