/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CategoriaCargo;
import fenixschool.modelo.Professor;
import fenixschool.modelo.ProfessorCategoriaCargo;
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
public class ProfessorCategoriaCargoDAO implements GenericoDAOLogico<ProfessorCategoriaCargo> {

    private static final String INSERT = "INSERT INTO professor_categoria_cargo(id_categoria_cargo,id_professor,data_nomeacao,data_fim_nomeacao,Observacoes)VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE professor_categoria_cargo SET id_categoria_cargo = ?, id_professor = ?, data_nomeacao = ?, data_fim_nomeacao = ?, Observacoes = ? WHERE id_professor_categoria_cargo = ?";
    private static final String DELETE = "DELETE FROM professor_categoria_cargo WHERE id_professor_categoria_cargo = ?";
    private static final String SELECT_BY_ID = "SELECT pcc.id_professor_categoria_cargo,c.id_categoria_cargo,pf.id_professor,pcc.data_nomeacao,pcc.data_fim_nomeacao,pcc.Observacoes FROM professor_categoria_cargo pcc INNER JOIN categoria_cargo c ON (pcc.id_categoria_cargo= c.id_categoria_cargo) INNER JOIN professor pf ON (pcc.id_professor= pf.id_professor) WHERE id_professor_categoria_cargo= ?;";
    private static final String SELECT_ALL = "SELECT pcc.id_professor_categoria_cargo,c.id_categoria_cargo,pf.id_professor,pcc.data_nomeacao,pcc.data_fim_nomeacao,pcc.Observacoes FROM professor_categoria_cargo pcc INNER JOIN categoria_cargo c ON (pcc.id_categoria_cargo= c.id_categoria_cargo) INNER JOIN professor pf ON (pcc.id_professor= pf.id_professor);";

    @Override
    public boolean save(ProfessorCategoriaCargo professorCategoriaCargo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorCategoriaCargo == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, professorCategoriaCargo.getCategoriaCargo().getIdCategoriaCargo());
            ps.setInt(2, professorCategoriaCargo.getProfessor().getIdProfessor());
            ps.setDate(3, new java.sql.Date(professorCategoriaCargo.getDataNomeacao().getTime()));
            ps.setDate(4, new java.sql.Date(professorCategoriaCargo.getDataFimNomeacao().getTime()));
            ps.setString(5, professorCategoriaCargo.getObservacoes());

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
    public boolean update(ProfessorCategoriaCargo professorCategoriaCargo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorCategoriaCargo == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, professorCategoriaCargo.getCategoriaCargo().getIdCategoriaCargo());
            ps.setInt(2, professorCategoriaCargo.getProfessor().getIdProfessor());
            ps.setDate(3, new java.sql.Date(professorCategoriaCargo.getDataNomeacao().getTime()));
            ps.setDate(4, new java.sql.Date(professorCategoriaCargo.getDataFimNomeacao().getTime()));
            ps.setString(5, professorCategoriaCargo.getObservacoes());
            ps.setInt(6, professorCategoriaCargo.getIdProfessorCategoriaCargo());

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
    public boolean delete(ProfessorCategoriaCargo professorCategoriaCargo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professorCategoriaCargo == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, professorCategoriaCargo.getIdProfessorCategoriaCargo());
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
    public ProfessorCategoriaCargo findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        ProfessorCategoriaCargo professorCategoriaCargo = new ProfessorCategoriaCargo();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(professorCategoriaCargo, rs);

        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professorCategoriaCargo;
    }

    @Override
    public List<ProfessorCategoriaCargo> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ProfessorCategoriaCargo> professorCategoriaCargos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProfessorCategoriaCargo professorCategoriaCargo = new ProfessorCategoriaCargo();
                popularComDados(professorCategoriaCargo, rs);
                professorCategoriaCargos.add(professorCategoriaCargo);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return professorCategoriaCargos;
    }

    @Override
    public void popularComDados(ProfessorCategoriaCargo professorCategoriaCargo, ResultSet rs) {
        try {
            professorCategoriaCargo.setIdProfessorCategoriaCargo(rs.getInt("id_professor_categoria_cargo"));
            professorCategoriaCargo.setDataFimNomeacao(rs.getDate("data_fim_nomeacao"));
            professorCategoriaCargo.setDataNomeacao(rs.getDate("data_nomeacao"));
            Professor professor = new Professor();
            professor.setNomeProfessor(rs.getString("nome_professor"));
            professor.setSobrenomeProfessor(rs.getString("sobrenome_professor"));
            professorCategoriaCargo.setProfessor(professor);
            CategoriaCargo categoriaCargo = new CategoriaCargo();
            categoriaCargo.setCategoriaCargo(rs.getString("categoria_cargo"));
            professorCategoriaCargo.setCategoriaCargo(categoriaCargo);
            professorCategoriaCargo.setObservacoes(rs.getString("Observacoes"));
        } catch (SQLException e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }
}
