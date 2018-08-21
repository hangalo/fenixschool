/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Profissao;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HACKER
 */
public class ProfissaoDAO implements GenericoDAOLogico<Profissao> {

    private static final String INSERT = "INSERT INTO profissao(nome_profissao)VALUES(?)";
    private static final String UPDATE = "UPDATE profissao SET nome_profissao=? WHERE id_profissao=?";
    private static final String DELETE = "DELETE FROM profissao WHERE id_profissao=?";
    private static final String SELECT_BY_ID = "SELECT id_profissao, nome_profissao FROM profissao WHERE id_profissao = ?";
    private static final String SELECT_ALL = "SELECT id_profissao, nome_profissao FROM profissao";
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;


    @Override
    public boolean save(Profissao profissao) {
        boolean controlo = false;
        if (profissao == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, profissao.getNomeProfissao());
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
    public boolean update(Profissao profissao) {
        boolean controlo = false;
        if (profissao == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, profissao.getNomeProfissao());
            ps.setInt(2, profissao.getIdProfissao());
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
    public boolean delete(Profissao profissao) {
        boolean controlo = false;
        if (profissao == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, profissao.getIdProfissao());
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
    public Profissao findById(Integer id) {
        Profissao profissao = new Profissao();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(profissao, rs);

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return profissao;
    }

    @Override
    public List<Profissao> findAll() {
        List<Profissao> itens = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissao profissao = new Profissao();
                popularComDados(profissao, rs);
                itens.add(profissao);

            }

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return itens;
    }

    @Override
    public void popularComDados(Profissao profissao, ResultSet rs) {
        try {
            profissao.setIdProfissao(rs.getInt("id_profissao"));
            profissao.setNomeProfissao(rs.getString("nome_profissao"));
        } catch (SQLException ex) {
            System.out.println("erro ao ler dados: " + ex.getMessage());
        }
    }
}
