/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.PeriodoLectivo;
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
public class PeriodoLectivoDAO implements GenericoDAOLogico<PeriodoLectivo> {

    private static final String INSERIR = "INSERT into periodo_letivo (periodo_letivo) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE periodo_letivo SET periodo_letivo = ? WHERE id_periodo_letivo = ?";
    private static final String ELIMINAR = "DELETE FROM periodo_letivo WHERE id_periodo_letivo = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_periodo_letivo, periodo_letivo from periodo_letivo WHERE id_periodo_letivo =?";
    private static final String LISTAR_TUDO = "SELECT *FROM periodo_letivo ORDER BY periodo_letivo DESC";

    @Override
    public boolean save(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (periodoletivo == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, periodoletivo.getPeriodoLectivo());
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
    public boolean update(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (periodoletivo == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, periodoletivo.getPeriodoLectivo());
            ps.setInt(2, periodoletivo.getIdPeriodoLectivo());
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
    public boolean delete(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (periodoletivo == null) {
            System.err.println("O valor anterior nao pode ser nulo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, periodoletivo.getIdPeriodoLectivo());
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
    public PeriodoLectivo findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        PeriodoLectivo periodoletivo = new PeriodoLectivo();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(periodoletivo, rs);

        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return periodoletivo;

    }

    @Override
    public List<PeriodoLectivo> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<PeriodoLectivo> periodoLectivos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                PeriodoLectivo periodoletivo = new PeriodoLectivo();
                popularComDados(periodoletivo, rs);
                periodoLectivos.add(periodoletivo);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return periodoLectivos;
    }

    @Override
    public void popularComDados(PeriodoLectivo periodoletivo, ResultSet rs) {
        try {
            periodoletivo.setIdPeriodoLectivo(rs.getInt("id_periodo_letivo"));
            periodoletivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }

}
