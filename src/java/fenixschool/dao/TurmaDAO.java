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
 * @author Aisha Lubadika
 */
public class TurmaDAO implements GenericoDAOLogico<Turma> {

    private static final String INSERIR = "INSERT INTO turma(nome_turma, id_ano_letivo, id_periodo_letivo, numero_maximo_inscristos )VALUES(?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE turma SET nome_turma = ?, id_ano_letivo = ?, id_periodo_letivo = ?, mumero_maximo_inscristos =? WHERE id_turma = ?";
    private static final String ELIMINAR = "DELETE FROM turma WHERE id_turma = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT t.id_turma , t.nome_turma ,a.ano_letivo , p.periodo_letivo, t.numero_maximo_inscristos FROM turma t INNER JOIN ano_letivo a ON t.id_ano_letivo=a.id_ano_letivo INNER JOIN periodo_letivo p ON t.id_periodo_letivo=p.id_periodo_letivo WHERE id_turma= ?";
    private static final String LISTAR_TUDO = "SELECT t.id_turma , t.nome_turma ,a.ano_letivo , p.periodo_letivo, t.numero_maximo_inscristos FROM turma t INNER JOIN ano_letivo a ON t.id_ano_letivo=a.id_ano_letivo INNER JOIN periodo_letivo p ON t.id_periodo_letivo=p.id_periodo_letivo";

    @Override
    public boolean save(Turma turma) {
         PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (turma == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, turma.getNomeTurma());
            ps.setInt(2, turma.getAnoLectivo().getIdAnoLectivo());
            ps.setInt(3, turma.getPeriodoLectivo().getIdPeriodoLectivo());
            ps.setInt(4, turma.getNumeroMaximoInscritos());
             int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
              return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Turma turma) {
          PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (turma == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

            ps.setString(1, turma.getNomeTurma());
            ps.setInt(2, turma.getAnoLectivo().getIdAnoLectivo());
            ps.setInt(3, turma.getPeriodoLectivo().getIdPeriodoLectivo());
            ps.setInt(4, turma.getNumeroMaximoInscritos());
            ps.setInt(5, turma.getIdTurma());
             int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar dados: " + e.getMessage());
              return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Turma turma) {
            PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (turma == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

           ps.setInt(1, turma.getIdTurma());
            
             int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
              return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Turma findById(Integer id) {
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        Turma turma = new Turma(); 
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Não foi encontrado nenhum registo com o id: " + id);
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
            conn = Conexao.getConnection();
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

            turma.setIdTurma(rs.getInt("id_turma"));
            turma.setNomeTurma(rs.getString("nome_turma"));
            
            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            turma.setAnoLectivo(anoLectivo);

            PeriodoLectivo periodoLectivo = new PeriodoLectivo();
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            turma.setPeriodoLectivo(periodoLectivo);

            turma.setNumeroMaximoInscritos(rs.getInt("numero_maximo_inscristos"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
