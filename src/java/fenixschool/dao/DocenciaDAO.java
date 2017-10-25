/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Docencia;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Professor;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DocenciaDAO implements GenericoDAOLogico<Docencia> {

    private static final String INSERT = "INSERT INTO docencia(id_disciplina, id_professor, data_inicio, data_fim, id_ano_letivo, observacao) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE docencia SET id_disciplina = ?, id_professor = ?, data_inicio = ?, data_fim = ?, id_ano_letivo = ?, observacao = ? WHERE id_docencia =? ";
    private static final String DELETE = "DELETE FROM docencia WHERE id_docencia =?";
    private static final String SELECT_BY_ID = "SELECT dc.id_docencia, ds.nome_disciplina, ps.nome_professor, ps.sobrenome_professor, dc.data_inicio, dc.data_fim, al.ano_letivo , dc.observacao FROM docencia dc INNER JOIN disciplina ds ON (dc.id_disciplina = ds.id_disciplina) INNER JOIN professor ps ON (dc.id_professor = ps.id_professor) INNER JOIN ano_letivo al ON(dc.id_ano_letivo = al.id_ano_letivo); WHERE id_docencia = ?";
    private static final String SELECT_ALL = "SELECT dc.id_docencia, ds.nome_disciplina, ps.nome_professor, ps.sobrenome_professor, dc.data_inicio, dc.data_fim, al.ano_letivo , dc.observacao FROM docencia dc INNER JOIN disciplina ds ON (dc.id_disciplina = ds.id_disciplina) INNER JOIN professor ps ON (dc.id_professor = ps.id_professor) INNER JOIN ano_letivo al ON(dc.id_ano_letivo = al.id_ano_letivo)";

    @Override
    public boolean save(Docencia docencia) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (docencia == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, docencia.getDisciplina().getIdDisciplina());
            ps.setInt(2, docencia.getProfessor().getIdProfessor());
            ps.setDate(3, new java.sql.Date(docencia.getDataIncio().getTime()));
            ps.setDate(4, new java.sql.Date(docencia.getDataFim().getTime()));
            ps.setInt(5, docencia.getAnoLectivo().getIdAnoLectivo());
            ps.setString(6, docencia.getObservacoes());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados guardados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception e) {
            System.out.println("Erro na insersao de dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public boolean update(Docencia docencia) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (docencia == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setString(1, docencia.getDisciplina().getIdDisciplina());
            ps.setInt(2, docencia.getProfessor().getIdProfessor());
            ps.setDate(3, new java.sql.Date(docencia.getDataIncio().getTime()));
            ps.setDate(4, new java.sql.Date(docencia.getDataFim().getTime()));
            ps.setInt(5, docencia.getAnoLectivo().getIdAnoLectivo());
            ps.setString(6, docencia.getObservacoes());
            ps.setInt(7, docencia.getIdDocencia());

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
    public boolean delete(Docencia docencia) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (docencia == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, docencia.getIdDocencia());
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
    public Docencia findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Docencia docencia = new Docencia();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(docencia, rs);

        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return docencia;

    }

    @Override
    public List<Docencia> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Docencia> docencias = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Docencia docencia = new Docencia();
                popularComDados(docencia, rs);
                docencias.add(docencia);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return docencias;
    }

    @Override
    public void popularComDados(Docencia docencia, ResultSet rs) {
        try {

            docencia.setIdDocencia(rs.getInt("id_docencia"));
            Disciplina disciplina = new Disciplina();
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            docencia.setDisciplina(disciplina);
            Professor professor = new Professor();
            professor.setNomeProfessor(rs.getString("nome_professor"));
            professor.setSobrenomeProfessor(rs.getString("sobrenome_professor"));
            docencia.setProfessor(professor);
            docencia.setDataIncio(rs.getDate("data_inicio"));
            docencia.setDataFim(rs.getDate("data_fim"));
            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            docencia.setAnoLectivo(anoLectivo);
            docencia.setObservacoes(rs.getString("observacao"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }

}
