/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AlunoEncarregadoEducacao;
import fenixschool.modelo.EncarregadoEducacao;
import fenixschool.modelo.Parentesco;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PENA
 */
public class AlunoEncarregadoDAO implements GenericoDAO<AlunoEncarregadoEducacao> {

    private static final String INSERT = "INSERT INTO aluno_encarregado_educacao (id_encarregado,id_aluno,id_parentesco,inicio_responsabilidade,fim_responsabilidade,observacoes) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE aluno_encarregado_educacao SET id_encarregado = ?,id_aluno = ?,id_parentesco = ?,inicio_responsabilidade = ?,fim_responsabilidade = ?,observacoes = ? WHERE id_aluno_encarregado_educacao = ?";
    private static final String DELETE = "DELETE FROM aluno_encarregado_educacao WHERE id_aluno_encarregado_educacao = ? ";
    private static final String SELECT_BY_ID = "SELECT alen.id_aluno_encarregado_educacao, a.id_aluno,a.numero_BI, a.nome_aluno, a.sobrenome_aluno, a.url_foto_aluno, par.parentesco,enc.nome_encarregado, enc.sobrenome_encarregado, enc.url_foto_encarregado,alen.inicio_responsabilidade,alen.fim_responsabilidade,alen.observacoes FROM aluno_encarregado_educacao alen INNER JOIN aluno a ON alen.id_aluno=a.id_aluno INNER JOIN encarregado_educacao enc ON alen.id_encarregado = enc.id_encarregado INNER JOIN parentesco par ON alen.id_parentesco = par.id_parentesco WHERE alen.id_aluno_encarregado_educacao =?";
    private static final String SELECT_ALL = "SELECT alen.id_aluno_encarregado_educacao,a.id_aluno,a.numero_BI, a.nome_aluno, a.sobrenome_aluno, a.url_foto_aluno, par.parentesco,enc.nome_encarregado, enc.sobrenome_encarregado, enc.url_foto_encarregado,alen.inicio_responsabilidade,alen.fim_responsabilidade,alen.observacoes FROM aluno_encarregado_educacao alen INNER JOIN aluno a ON alen.id_aluno=a.id_aluno INNER JOIN encarregado_educacao enc ON alen.id_encarregado = enc.id_encarregado INNER JOIN parentesco par ON alen.id_parentesco = par.id_parentesco ORDER BY alen.id_aluno_encarregado_educacao";
    private static final String SELECT_BY_BI = "SELECT alen.id_aluno_encarregado_educacao,a.id_aluno,a.numero_BI, a.nome_aluno, a.sobrenome_aluno, a.url_foto_aluno, par.parentesco,enc.nome_encarregado, enc.sobrenome_encarregado, enc.url_foto_encarregado,alen.inicio_responsabilidade,alen.fim_responsabilidade,alen.observacoes FROM aluno_encarregado_educacao alen INNER JOIN aluno a ON alen.id_aluno=a.id_aluno INNER JOIN encarregado_educacao enc ON alen.id_encarregado = enc.id_encarregado INNER JOIN parentesco par ON alen.id_parentesco = par.id_parentesco WHERE a.numero_BI=?";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public AlunoEncarregadoDAO() {
    }

    public AlunoEncarregadoDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public void save(AlunoEncarregadoEducacao alunoEncarregado) {
        if (alunoEncarregado == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, alunoEncarregado.getEncarregado().getIdEncarregadoEducacao());
            ps.setInt(2, alunoEncarregado.getAluno().getIdAluno());
            ps.setInt(3, alunoEncarregado.getParentesco().getIdParentesco());
            ps.setDate(4, new java.sql.Date(alunoEncarregado.getInicioResponsabilidade().getTime()));
            ps.setDate(5, new java.sql.Date(alunoEncarregado.getFimResponsabilidade().getTime()));
            ps.setString(6, alunoEncarregado.getObservacoes());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(AlunoEncarregadoEducacao alunoEncarregado) {

        if (alunoEncarregado == null) {
            System.out.println("O parametro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, alunoEncarregado.getEncarregado().getIdEncarregadoEducacao());
            ps.setInt(2, alunoEncarregado.getAluno().getIdAluno());
            ps.setInt(3, alunoEncarregado.getParentesco().getIdParentesco());
            ps.setDate(4, new java.sql.Date(alunoEncarregado.getInicioResponsabilidade().getTime()));
            ps.setDate(5, new java.sql.Date(alunoEncarregado.getFimResponsabilidade().getTime()));
            ps.setString(6, alunoEncarregado.getObservacoes());
            ps.setInt(7, alunoEncarregado.getIdAlunoEncarregado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao actualizar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(AlunoEncarregadoEducacao alunoEncarregado) {
        if (alunoEncarregado == null) {
            System.out.println("O parametro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, alunoEncarregado.getIdAlunoEncarregado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao apagar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public AlunoEncarregadoEducacao findById(Integer id) {

        AlunoEncarregadoEducacao alunoEncarregadoEducacao = new AlunoEncarregadoEducacao();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com id: " + id);

            }
            popularComDados(alunoEncarregadoEducacao, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunoEncarregadoEducacao;
    }

    @Override
    public List<AlunoEncarregadoEducacao> findAll() {
        List<AlunoEncarregadoEducacao> listaAlunosEncarregados = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                AlunoEncarregadoEducacao alunoEncarregadoEducacao = new AlunoEncarregadoEducacao();
                popularComDados(alunoEncarregadoEducacao, rs);
                listaAlunosEncarregados.add(alunoEncarregadoEducacao);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return listaAlunosEncarregados;
    }

    
    public List<AlunoEncarregadoEducacao> findByBI(String numeroBI) {
        List<AlunoEncarregadoEducacao> listaAlunosEncarregados = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_BI);
            ps.setString(1, numeroBI);
            rs = ps.executeQuery();
            while (rs.next()) {
                AlunoEncarregadoEducacao alunoEncarregadoEducacao = new AlunoEncarregadoEducacao();
                popularComDados(alunoEncarregadoEducacao, rs);
                listaAlunosEncarregados.add(alunoEncarregadoEducacao);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return listaAlunosEncarregados;
    }
    
    
    @Override
    public void popularComDados(AlunoEncarregadoEducacao alunoEncarregado, ResultSet rs) {
        Aluno aluno = new Aluno();
        Parentesco parentesco = new Parentesco();
        EncarregadoEducacao encarregado = new EncarregadoEducacao();

        try {
            alunoEncarregado.setIdAlunoEncarregado(rs.getInt("id_aluno_encarregado_educacao"));
            encarregado.setNomeEncarregado(rs.getString("nome_encarregado"));
            encarregado.setSobrenomeEncarregado(rs.getString("sobrenome_encarregado"));
            encarregado.setUrlFotoEncarregado(rs.getString("url_foto_encarregado"));
            alunoEncarregado.setEncarregado(encarregado);

            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));
            aluno.setBiAluno(rs.getString("numero_BI"));
            alunoEncarregado.setAluno(aluno);

            parentesco.setParentesco(rs.getString("parentesco"));
            alunoEncarregado.setParentesco(parentesco);

            alunoEncarregado.setInicioResponsabilidade(rs.getDate("inicio_responsabilidade"));
            alunoEncarregado.setFimResponsabilidade(rs.getDate("fim_responsabilidade"));
            alunoEncarregado.setObservacoes(rs.getString("observacoes"));

        } catch (SQLException ex) {
            System.err.println("Erro ao popular com dados! " + ex);
        }
    }

}
