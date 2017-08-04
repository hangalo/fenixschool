/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Instituicao;
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

    private static final String INSERIR = "INSERT INTO insituicao()VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE insituicao SET nome_instituicao=?, casa_instituicao=?, rua_instituicao=?, bairro_instituicao=?, telefone_fixo_instituicao=?, telefone_unitel_instituicao=?, telefone_movicel_instituicao=?, email_instituicao=?, home_instituicao=?, logotipo_instituicao=?, urllogotipo_instituicao=? WHERE id_instituicao=?";
    private static final String ELIMINAR = "DELETE FROM insituicao WHERE id_insituicao=?";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM instituicao WHERE id_insituicao=_";
    private static final String LISTAR_TUDO = "SELECT * FROM insituicao";
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Instituicao instituicao) {

        PreparedStatement ps = null;
        Connection conn = null;
        if (instituicao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, instituicao.getNomeInstituicao());
            ps.setString(2, instituicao.getCasaInstituicao());
            ps.setString(3, instituicao.getRuaInstituicao());
            ps.setString(4, instituicao.getBairroInstituicao());
            ps.setString(5, instituicao.getTelefoneFixoInstituicao());
            ps.setString(6, instituicao.getTelefoneUnitelInstituicao());
            ps.setString(7, instituicao.getTelefoneMovicelInstituicao());
            ps.setString(8, instituicao.getEmailInstituicao());
            ps.setString(9, instituicao.getHomeInstituicao());
            ps.setBytes(10, instituicao.getLogoTipoInstituicao());
            ps.setString(11, instituicao.getUrlLogoInstituicao());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Instituicao instituicao){

        PreparedStatement ps = null;
        Connection conn = null;
        if (instituicao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, instituicao.getNomeInstituicao());
            ps.setString(2, instituicao.getCasaInstituicao());
            ps.setString(3, instituicao.getRuaInstituicao());
            ps.setString(4, instituicao.getBairroInstituicao());
            ps.setString(5, instituicao.getTelefoneFixoInstituicao());
            ps.setString(6, instituicao.getTelefoneUnitelInstituicao());
            ps.setString(7, instituicao.getTelefoneMovicelInstituicao());
            ps.setString(8, instituicao.getEmailInstituicao());
            ps.setString(9, instituicao.getHomeInstituicao());
            ps.setBytes(10, instituicao.getLogoTipoInstituicao());
            ps.setString(11, instituicao.getUrlLogoInstituicao());
            ps.setInt(12, instituicao.getIdIsntituicao());
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
            ps = conn.prepareStatement(ELIMINAR);
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
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
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

    @Override
    public List<Instituicao> findAll() {
        List<Instituicao> itens = new ArrayList<Instituicao>();
              
        
         try {

            conn = Conexao.getConnection();
        ps = conn.prepareStatement(LISTAR_TUDO);
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
            instituicao.setIdIsntituicao(rs.getInt(1));
            instituicao.setNomeInstituicao(rs.getString(2));
            instituicao.setCasaInstituicao(rs.getString(3));
            instituicao.setRuaInstituicao(rs.getString(4));
            instituicao.setBairroInstituicao(rs.getString(5));
            instituicao.setTelefoneFixoInstituicao(rs.getString(6));
            instituicao.setTelefoneUnitelInstituicao(rs.getString(7));
            instituicao.setTelefoneMovicelInstituicao(rs.getString(8));
            instituicao.setEmailInstituicao(rs.getString(9));
            instituicao.setHomeInstituicao(rs.getString(10));
            instituicao.setLogoTipoInstituicao(rs.getBytes(11));
            instituicao.setUrlLogoInstituicao(rs.getString(12));
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
