/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Turma;
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
public class TurmaDAO implements GenericoDAO<Turma> {

    private static final String INSERIR = "INSERT INTO turma(nome_turma, id_ano_letivo, id_periodo_letivo, mumero_maximo_inscritos)VALUES(?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE turma SET nome_turma = ?, id_ano_letivo = ?, id_periodo_letivo = ?, mumero_maximo_inscritos = ? WHERE id_turma = ?";
    private static final String ELIMINAR = "DELETE FROM turma WHERE id_turma = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_turma t, nome_turma t, ano_letivo a, periodo_letivo p FROM turma t INNER JOIN ano_letivo a ON t.id_ano_letivo=a.id_ano_letivo INNER JOIN periodo_letivo p ON t.id_periodo_letivo=p.id_periodo_letivo WHERE t.id_turma = ?";
    private static final String LISTAR_TUDO = "SELECT id_turma t, nome_turma t, ano_letivo a, periodo_letivo p FROM turma t INNER JOIN ano_letivo a ON t.id_ano_letivo=a.id_ano_letivo INNER JOIN periodo_letivo p ON t.id_periodo_letivo=p.id_periodo_letivo";

    @Override
    public void save(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, turma.getNomeTurma());
            ps.setInt(2, turma.getIdAnoLetivo().getIdAnoLectivo());
            ps.setInt(3, turma.getIdPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(4, turma.getNumeroMaximoInscritos());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, turma.getNomeTurma());
            ps.setInt(2, turma.getIdAnoLetivo().getIdAnoLectivo());
            ps.setInt(3, turma.getIdPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(4, turma.getNumeroMaximoInscritos());
            ps.setInt(5, turma.getIdTurma());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, turma.getIdTurma());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }

    }

    @Override
    public Turma findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Turma turma = new Turma();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(turma, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return turma;
    }

    @Override
    public List<Turma> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Turma> turmas = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                popularComDados(turma, rs);
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return turmas;

    }

    @Override
    public void popularComDados(Turma turma, ResultSet rs) {
        try {

            turma.setIdTurma(rs.getInt("id_ano_letivo"));
            turma.setNomeTurma(rs.getString("nome_turma"));
            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_Letivo"));
            turma.setIdAnoLetivo(anoLectivo);

            PeriodoLectivo periodoLectivo = new PeriodoLectivo();
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            turma.setIdPeriodoLetivo(periodoLectivo);

            turma.setNumeroMaximoInscritos(rs.getInt("numero_maximo_inscritos"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
