/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.BoletimNota;
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
public class BoletimNotaDAO implements GenericoDAOLogico<BoletimNota> {

    private static final String INSERT = "INSERT INTO boletim_notas (data_boletin_notas, id_aluno) VALUES (?,?)";
    private static final String UPDATE = "UPDATE boletim_notas SET data_boletin_notas = ?, id_aluno = ? WHERE id_boletin_notas = ?";
    private static final String DELETE = "DELETE FROM boletim_notas WHERE id_boletin_notas=?";
    private static final String SELECT_BY_ID = " SELECT b.id_boletin_notas, b.data_boletin_notas, a.nome_aluno, a.sobrenome_aluno FROM boletim_notas b INNER JOIN aluno a ON (b.id_aluno=a.id_aluno) WHERE b.id_boletin_notas=?";
    private static final String SELECT_ALL = "SELECT b.id_boletin_notas, b.data_boletin_notas, a.nome_aluno, a.sobrenome_aluno FROM boletim_notas b INNER JOIN aluno a ON (b.id_aluno=a.id_aluno)";

    @Override
    public boolean save(BoletimNota boletim) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean retorno = false;
        if (boletim == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            
            ps.setDate(1, new java.sql.Date(boletim.getDataBoletim().getTime()));
            ps.setInt(2, boletim.getAluno().getIdAluno());
            
            int controlador = ps.executeUpdate();
            if (controlador > 0) {
                System.out.println("Dados inseridos com sucesso! " + ps.getUpdateCount());
                retorno = true;
            }
            return retorno;
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(BoletimNota boletim) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean retorno = false;
        if (boletim == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setDate(1, new java.sql.Date(boletim.getDataBoletim().getTime()));
            ps.setInt(2, boletim.getAluno().getIdAluno());
            ps.setInt(3, boletim.getIdBoletim());

            int controlador = ps.executeUpdate();
            if (controlador > 0) {
                System.out.println("Dados actualizado com sucesso! " + ps.getUpdateCount());
                retorno = true;
            }
            return retorno;
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(BoletimNota boletim) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean retorno = false;
        if (boletim == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);

            ps.setInt(1, boletim.getIdBoletim());

            int controlador = ps.executeUpdate();
            if (controlador > 0) {
                System.out.println("Dados excluido com sucesso! " + ps.getUpdateCount());
                retorno = true;
            }
            return retorno;
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public BoletimNota findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        BoletimNota bn = new BoletimNota();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.err.println("Não foi encontrado o registo com o id: " + id);
            }
            popularComDados(bn, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return bn;
    }

    @Override
    public List<BoletimNota> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        List<BoletimNota> list = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                BoletimNota bn = new BoletimNota();
                popularComDados(bn, rs);
                list.add(bn);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar dados " + ex.getLocalizedMessage());
        }
        return list;
    }

    @Override
    public void popularComDados(BoletimNota boletim, ResultSet rs) {
        try {
            Aluno aluno = new Aluno();
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            boletim.setAluno(aluno);
            boletim.setIdBoletim(rs.getInt("id_boletin_notas"));
            boletim.setDataBoletim(rs.getDate("data_boletin_notas"));
        } catch (SQLException ex) {
            System.err.println("Erro ao popular com dados " + ex.getLocalizedMessage());
        }
    }

}
