/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.AnoLectivo;
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
public class AnoLectivoDAO implements GenericoDAO<AnoLectivo> {

    private static final String INSERIR = "INSERT INTO ano_letivo (ano_letivo,inicio_ano_letivo,fim_ano_letivo)VALUES (?,?,?)";
    private static final String ACTUALIZAR = "UPDATE ano_letivo SET ano_letivo = ?, inicio_ano_letivo = ?, fim_ano_letivo = ? WHERE id_ano_letivo =?";
    private static final String ELIMINAR = "DELETE FROM ano_letivo WHERE id_ano_letivo=?";
    private static final String LISTAR_POR_CODIGO = "SELECT id_ano_letivo, ano_letivo,inicio_ano_letivo,fim_ano_letivo FROM ano_letivo WHERE id_ano_letivo=?";
    private static final String LISTAR_TUDO = "SELECT id_ano_letivo, ano_letivo,inicio_ano_letivo,fim_ano_letivo FROM ano_letivo";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public AnoLectivoDAO() {
    }
/*
    public AnoLectivoDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }*/

    @Override
    public void save(AnoLectivo anoLectivo) {
        if (anoLectivo == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, anoLectivo.getAnoLectivo());
            ps.setDate(2, new java.sql.Date(anoLectivo.getInicioAnoLetivo().getTime()));
            ps.setDate(3, new java.sql.Date(anoLectivo.getFimAnoLetivo().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(AnoLectivo anoLectivo) {
        if (anoLectivo == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, anoLectivo.getAnoLectivo());
            ps.setDate(2, new java.sql.Date(anoLectivo.getInicioAnoLetivo().getTime()));
            ps.setDate(3, new java.sql.Date(anoLectivo.getFimAnoLetivo().getTime()));
            ps.setInt(4, anoLectivo.getIdAnoLectivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(AnoLectivo anoLectivo) {
        if (anoLectivo == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, anoLectivo.getIdAnoLectivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public AnoLectivo findById(Integer id) {
        AnoLectivo anoLectivo = new AnoLectivo();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(anoLectivo, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return anoLectivo;
    }

    @Override
    public List<AnoLectivo> findAll() {
        List<AnoLectivo> anoLectivos = new ArrayList<AnoLectivo>();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                AnoLectivo anoLectivo = new AnoLectivo();
                popularComDados(anoLectivo, rs);
                anoLectivos.add(anoLectivo);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return anoLectivos;
    }

    @Override
    public void popularComDados(AnoLectivo anoLectivo, ResultSet rs) {

        try {
            anoLectivo.setIdAnoLectivo(rs.getInt("id_ano_letivo"));
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            anoLectivo.setInicioAnoLetivo(rs.getDate("inicio_ano_letivo"));
            anoLectivo.setFimAnoLetivo(rs.getDate("fim_ano_letivo"));
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        }
    }
}
