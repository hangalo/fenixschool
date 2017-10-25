/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.SituacaoTransferencia;
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
public class SituacaoTransferenciaDAO implements GenericoDAO<SituacaoTransferencia> {

    private static final String INSERT = "INSERT INTO situacao_transferencia(situacao_transferencia)VALUES( ?);";
    private static final String UPDATE = "UPDATE situacao_transferencia SET situacao_transferencia = ? WHERE id_situacao_transferencia = ?";
    private static final String DELETE = "DELETE FROM situacao_transferencia WHERE id_situacao_transferencia = ? ";
    private static final String SELECT_BY_ID = "SELECT id_situacao_transferencia,situacao_transferencia FROM situacao_transferencia WHERE id_situacao_transferencia = ?";
    private static final String SELECT_ALL = "SELECT id_situacao_transferencia,situacao_transferencia FROM situacao_transferencia";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public SituacaoTransferenciaDAO() {
    }

    public SituacaoTransferenciaDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public void save(SituacaoTransferencia situacaoTransferencia) {
        if (situacaoTransferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, situacaoTransferencia.getSituacaoTransferencia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(SituacaoTransferencia situacaoTransferencia) {
       if (situacaoTransferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, situacaoTransferencia.getSituacaoTransferencia());
            ps.setInt(2, situacaoTransferencia.getIdSituacaoTransferencia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(SituacaoTransferencia situacaoTransferencia) {
        if (situacaoTransferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, situacaoTransferencia.getIdSituacaoTransferencia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public SituacaoTransferencia findById(Integer id) {
        SituacaoTransferencia situacaoTransferencia = new SituacaoTransferencia();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(situacaoTransferencia, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return situacaoTransferencia;
    }

    @Override
    public List<SituacaoTransferencia> findAll() {
        List<SituacaoTransferencia> situacaoTransferencias = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                SituacaoTransferencia situacaoTransferencia = new SituacaoTransferencia();
                popularComDados(situacaoTransferencia, rs);
                situacaoTransferencias.add(situacaoTransferencia);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return situacaoTransferencias;
    }

    @Override
    public void popularComDados(SituacaoTransferencia situacaoTranferencia, ResultSet rs) {
        try {

            situacaoTranferencia.setIdSituacaoTransferencia(rs.getInt("id_situacao_transferencia"));
            situacaoTranferencia.setSituacaoTransferencia(rs.getString("situacao_transferencia"));

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados " + ex.getMessage());
        }
    }
}
