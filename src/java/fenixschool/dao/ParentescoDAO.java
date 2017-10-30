/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Parentesco;
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
public class ParentescoDAO implements GenericoDAO<Parentesco>{
    
    private static final String INSERT = "INSERT INTO parentesco(parentesco)VALUES( ?);";
    private static final String UPDATE = "UPDATE parentesco SET parentesco = ? WHERE id_parentesco = ?";
    private static final String DELETE = "DELETE FROM parentesco WHERE id_parentesco = ? ";
    private static final String SELECT_BY_ID = "SELECT id_parentesco,parentesco FROM parentesco WHERE id_parentesco = ?";
    private static final String SELECT_ALL = "SELECT id_parentesco, parentesco FROM parentesco";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public ParentescoDAO() {
    }

    public ParentescoDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }
    

    @Override
    public void save(Parentesco parentesco) {
        if (parentesco == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, parentesco.getParentesco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Parentesco parentesco) {
        if (parentesco == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, parentesco.getParentesco());
            ps.setInt(2, parentesco.getIdParentesco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Parentesco parentesco) {
        if (parentesco == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, parentesco.getIdParentesco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Parentesco findById(Integer id) {
        
        Parentesco parentesco = new Parentesco();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(parentesco, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return parentesco;
    }

    @Override
    public List<Parentesco> findAll() {
        List<Parentesco> parentescos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Parentesco parentesco = new Parentesco();
                popularComDados(parentesco, rs);
                parentescos.add(parentesco);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return parentescos;
    }

    @Override
    public void popularComDados(Parentesco parentesco, ResultSet rs) {
        try {
            parentesco.setIdParentesco(rs.getInt("id_parentesco"));
            parentesco.setParentesco(rs.getString("parentesco"));
        } catch (SQLException ex) {
            System.err.println("Erro ao popular com dados! "+ex);
        }
    }
    
}
