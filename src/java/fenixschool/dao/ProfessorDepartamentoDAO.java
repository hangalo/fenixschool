/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Departamento;
import fenixschool.modelo.Professor;
import fenixschool.modelo.ProfessorDepartamento;
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
public class ProfessorDepartamentoDAO implements GenericoDAOLogico<ProfessorDepartamento> {

    private static final String INSERT = "INSERT INTO professor_departamento(data_inicio, data_fim, id_professor, id_departamento, observacoes)VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE professor_departamento SET data_inicio = ?, data_fim = ?, id_professor = ?, id_departamento = ?, observacoes = ? WHERE id_professor_departamento = ?";
    private static final String DELETE = "DELETE FROM professor_departamento WHERE id_professor_departamento = ?";
    private static final String SELECT_BY_ID = "SELECT pd.id_professor_departamento, pd.data_inicio, pd.data_fim, pf.nome_professor, pf.sobrenome_professor, dp.nome_departamento, pd.observacoes FROM professor_departamento pd INNER JOIN departamento dp ON(pd.id_departamento= dp.id_departamento) INNER JOIN professor pf ON(pd.id_professor=pf.id_professor)  WHERE id_professor_departamento = ?";
    private static final String SELECT_ALL = "SELECT pd.id_professor_departamento, pd.data_inicio, pd.data_fim, pf.nome_professor, pf.sobrenome_professor, dp.nome_departamento, pd.observacoes FROM professor_departamento pd INNER JOIN departamento dp ON(pd.id_departamento= dp.id_departamento) INNER JOIN professor pf ON(pd.id_professor=pf.id_professor)";

    @Override

    public boolean save(ProfessorDepartamento professorDepartamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorDepartamento == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);

            ps.setDate(1, new java.sql.Date(professorDepartamento.getDataInicio().getTime()));
            ps.setDate(2, new java.sql.Date(professorDepartamento.getDataFim().getTime()));
            ps.setInt(3, professorDepartamento.getProfessor().getIdProfessor());
            ps.setInt(4, professorDepartamento.getDepartamento().getIdDepartamento());
            ps.setString(5, professorDepartamento.getObservacoes());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados guardados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException ex) {
            System.out.println("Erro na insersao de dados: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public boolean update(ProfessorDepartamento professorDepartamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorDepartamento == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setDate(1, new java.sql.Date(professorDepartamento.getDataInicio().getTime()));
            ps.setDate(2, new java.sql.Date(professorDepartamento.getDataFim().getTime()));
            ps.setInt(3, professorDepartamento.getProfessor().getIdProfessor());
            ps.setInt(4, professorDepartamento.getDepartamento().getIdDepartamento());
            ps.setString(5, professorDepartamento.getObservacoes());
            ps.setInt(6, professorDepartamento.getIdProfessorDepartamento());

            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(ProfessorDepartamento professorDepartamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorDepartamento == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, professorDepartamento.getIdProfessorDepartamento());
            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public ProfessorDepartamento findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        ProfessorDepartamento professorDepartamento = new ProfessorDepartamento();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(professorDepartamento, rs);

        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professorDepartamento;
    }

    @Override
    public List<ProfessorDepartamento> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ProfessorDepartamento> professorDepartamentos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProfessorDepartamento professorDepartamento = new ProfessorDepartamento();
                popularComDados(professorDepartamento, rs);
                professorDepartamentos.add(professorDepartamento);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return professorDepartamentos;
    }

    @Override
    public void popularComDados(ProfessorDepartamento professorDepartamento, ResultSet rs) {
        try {
            professorDepartamento.setIdProfessorDepartamento(rs.getInt("id_professor_departamento"));
            professorDepartamento.setDataInicio(rs.getDate("data_inicio"));
            professorDepartamento.setDataFim(rs.getDate("data_inicio"));
            Professor professor = new Professor();
            professor.setNomeProfessor(rs.getString("nome_professor"));
            professor.setSobrenomeProfessor(rs.getString("sobrenome_professor"));
            professorDepartamento.setProfessor(professor);
            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            professorDepartamento.setDepartamento(departamento);
            professorDepartamento.setObservacoes(rs.getString("observacoes"));
        } catch (SQLException e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }

}
