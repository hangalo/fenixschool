/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Instituicao;
import fenixschool.modelo.Municipio;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HACKER
 */
public class InstituicaoDAO implements GenericoDAO<Instituicao> {

    private static final String INSERT = "INSERT INTO instituicao(id_instituicao, nome_instituicao, casa_instituicao, rua_instituicao, bairro_instituicao, id_municipio, telefone_fixo_instituicao, telefone_unitel_instituicao, telefone_movicel_instituicao, email_instituicao, home_instituicao, logotipo_instituicao, urllogotipo_instituicao)VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE instituicao SET nome_instituicao = ?, casa_instituicao = ?, rua_instituicao = ?, bairro_instituicao = ?,id_municipio = ?, telefone_fixo_instituicao = ?, telefone_unitel_instituicao = ?,telefone_movicel_instituicao = ?,email_instituicao = ?,home_instituicao = ?,logotipo_instituicao = ?,urllogotipo_instituicao = ? WHERE id_instituicao = ?";
    private static final String DELETE = "DELETE FROM instituicao WHERE id_instituicao=?";
    private static final String SELECT_BY_ID = "SELECT id_instituicao, nome_instituicao, casa_instituicao, rua_instituicao, bairro_instituicao, nome_municipio, telefone_fixo_instituicao, telefone_unitel_instituicao, telefone_movicel_instituicao, email_instituicao, home_instituicao, logotipo_instituicao, urllogotipo_instituicao FROM instituicao i INNER JOIN municipio m ON i.id_municipio = m.id_municipio WHERE id_instituicao=?";
    private static final String SELECT_ALL = "SELECT id_instituicao, nome_instituicao, casa_instituicao, rua_instituicao, bairro_instituicao, nome_municipio, telefone_fixo_instituicao, telefone_unitel_instituicao, telefone_movicel_instituicao, email_instituicao, home_instituicao, logotipo_instituicao, urllogotipo_instituicao FROM instituicao i INNER JOIN municipio m ON i.id_municipio = m.id_municipio";
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Instituicao instituicao) {

        PreparedStatement ps = null;
        Connection conn = null;
        if (instituicao == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);

            ps.setString(1, instituicao.getNomeInstituicao());
            ps.setString(2, instituicao.getCasaInstituicao());
            ps.setString(3, instituicao.getRuaInstituicao());
            ps.setString(4, instituicao.getBairroInstituicao());
            ps.setInt(5, instituicao.getMunicipio().getIdMunicipio());
            ps.setString(6, instituicao.getTelefoneFixoInstituicao());
            ps.setString(7, instituicao.getTelefoneUnitelInstituicao());
            ps.setString(8, instituicao.getTelefoneMovicelInstituicao());
            ps.setString(9, instituicao.getEmailInstituicao());
            ps.setString(10, instituicao.getHomeInstituicao());
            ps.setBytes(11, instituicao.getLogoTipoInstituicao());
            ps.setString(12, instituicao.getUrlLogoInstituicao());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Instituicao instituicao) {

        PreparedStatement ps = null;
        Connection conn = null;
        if (instituicao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, instituicao.getNomeInstituicao());
            ps.setString(2, instituicao.getCasaInstituicao());
            ps.setString(3, instituicao.getRuaInstituicao());
            ps.setString(4, instituicao.getBairroInstituicao());
            ps.setInt(5, instituicao.getMunicipio().getIdMunicipio());
            ps.setString(6, instituicao.getTelefoneFixoInstituicao());
            ps.setString(7, instituicao.getTelefoneUnitelInstituicao());
            ps.setString(8, instituicao.getTelefoneMovicelInstituicao());
            ps.setString(9, instituicao.getEmailInstituicao());
            ps.setString(10, instituicao.getHomeInstituicao());
            ps.setBytes(11, instituicao.getLogoTipoInstituicao());
            ps.setString(12, instituicao.getUrlLogoInstituicao());
            ps.setInt(13, instituicao.getIdIsntituicao());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Instituicao instituicao) {

        PreparedStatement ps = null;
        Connection conn = null;
        if (instituicao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, instituicao.getIdIsntituicao());
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
    public Instituicao findById(Integer id) {
        Instituicao instituicao = new Instituicao();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com este ID: " + id);

            }
            popularComDados(instituicao, rs);

        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instituicao;
    }
    
    
      
    public Instituicao findDados() {
        Instituicao instituicao = new Instituicao();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
           
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo");

            }
            popularComDados(instituicao, rs);

        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instituicao;
    }
    
    

    @Override
    public List<Instituicao> findAll() {
        List<Instituicao> itens = new ArrayList<Instituicao>();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Instituicao instituicao = new Instituicao();
                popularComDados(instituicao, rs);
                itens.add(instituicao);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return itens;

    }

    @Override
    public void popularComDados(Instituicao instituicao, ResultSet rs) {
        try {
            instituicao.setIdIsntituicao(rs.getInt("id_instituicao"));
            instituicao.setNomeInstituicao(rs.getString("nome_instituicao"));
            instituicao.setCasaInstituicao(rs.getString("casa_instituicao"));
            instituicao.setRuaInstituicao(rs.getString("rua_instituicao"));
            instituicao.setBairroInstituicao(rs.getString("bairro_instituicao"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            instituicao.setMunicipio(municipio);
            instituicao.setTelefoneFixoInstituicao(rs.getString("telefone_fixo_instituicao"));
            instituicao.setTelefoneUnitelInstituicao(rs.getString("telefone_unitel_instituicao"));
            instituicao.setTelefoneMovicelInstituicao(rs.getString("telefone_movicel_instituicao"));
            instituicao.setEmailInstituicao(rs.getString("email_instituicao"));
            instituicao.setHomeInstituicao(rs.getString("home_instituicao"));
            instituicao.setLogoTipoInstituicao(rs.getBytes("logotipo_instituicao"));
            instituicao.setUrlLogoInstituicao(rs.getString("urllogotipo_instituicao"));
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
