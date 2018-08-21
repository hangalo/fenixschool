/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.SemestreLectivo;
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
public class SemestreLectivoDAO implements GenericoDAOLogico<SemestreLectivo> {

    private static final String INSERT = "INSERT INTO semestre_lectivo (semestre_lectivo,data_inicio,data_fim,observacoes) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE semestre_lectivo SET semestre_lectivo = ?, data_inicio = ?, data_fim = ?, observacoes = ? WHERE id_semestre_lectivo = ?";
    private static final String DELETE = "DELETE FROM semestre_lectivo WHERE id_semestre_lectivo=?";
    private static final String SELECT_BY_ID = "SELECT id_semestre_lectivo,semestre_lectivo,data_inicio,data_fim,observacoes FROM semestre_lectivo WHERE id_semestre_lectivo=?";
    private static final String SELECT_ALL = "SELECT id_semestre_lectivo,semestre_lectivo,data_inicio,data_fim,observacoes FROM semestre_lectivo";

    private static final String SELECT_EXIST = "SELECT id_semestre_lectivo,semestre_lectivo,data_inicio,data_fim,observacoes FROM semestre_lectivo WHERE semestre_lectivo =?";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean save(SemestreLectivo semestreLectivo) {
        boolean controlo = false;
        if (semestreLectivo == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, semestreLectivo.getSemestreLectivo());
            ps.setDate(2, new java.sql.Date(semestreLectivo.getDataInicio().getTime()));
            ps.setDate(3, new java.sql.Date(semestreLectivo.getDataFim().getTime()));
            ps.setString(4, semestreLectivo.getObservacoes());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados Salvado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(SemestreLectivo semestreLectivo) {
        boolean controlo = false;
        if (semestreLectivo == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, semestreLectivo.getSemestreLectivo());
            ps.setDate(2, new java.sql.Date(semestreLectivo.getDataInicio().getTime()));
            ps.setDate(3, new java.sql.Date(semestreLectivo.getDataFim().getTime()));
            ps.setString(4, semestreLectivo.getObservacoes());
            ps.setInt(5, semestreLectivo.getIdSemestreLectivo());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao actualizar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(SemestreLectivo semestreLectivo) {
        boolean controlo = false;
        if (semestreLectivo == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, semestreLectivo.getIdSemestreLectivo());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public SemestreLectivo findById(Integer id) {
        SemestreLectivo semestreLectivo = new SemestreLectivo();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);
            }
            popularComDados(semestreLectivo, rs);

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return semestreLectivo;
    }

    @Override
    public List<SemestreLectivo> findAll() {
        List<SemestreLectivo> semestreLectivos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                SemestreLectivo semestreLectivo = new SemestreLectivo();
                popularComDados(semestreLectivo, rs);
                semestreLectivos.add(semestreLectivo);
            }

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return semestreLectivos;
    }

    public boolean existe(SemestreLectivo lectivo) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_EXIST);
            ps.setString(1, lectivo.getSemestreLectivo());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Novo registro adicionado " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return false;
    }

    @Override
    public void popularComDados(SemestreLectivo semestreLectivo, ResultSet rs) {
        try {
            semestreLectivo.setIdSemestreLectivo(rs.getInt("id_semestre_lectivo"));
            semestreLectivo.setSemestreLectivo(rs.getString("semestre_lectivo"));
            semestreLectivo.setDataInicio(rs.getDate("data_inicio"));
            semestreLectivo.setDataFim(rs.getDate("data_fim"));
            semestreLectivo.setObservacoes(rs.getString("observacoes"));
        } catch (SQLException ex) {
            System.out.println("erro ao ler dados: " + ex.getMessage());
        }
    }

}
