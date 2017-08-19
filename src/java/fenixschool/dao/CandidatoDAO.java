/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import java.sql.PreparedStatement;
import fenixschool.modelo.Candidato;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
import fenixschool.util.Conexao;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import fenixschool.modelo.Sexo;
import java.sql.Connection;
import java.sql.ResultSet;

public class CandidatoDAO implements GenericoDAO<Candidato> {

    private static final String INSERIR = "INSERT INTO candidato (numero_candidato, nome_candidato, sobrenome_candidato, data_nascimento, sexo, casa_candidato, bairro_candidato, distrito_candidato, id_municipio, url_foto_candidato, foto_candidato, telefone_fixo, telefone_movel, email_candidato, id_profissao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE candidato SET numero_candidato =?, nome_candidato=?, sobrenome_candidato=?, data_nascimento=?, id_sexo=?, casa_candidato=?, bairro_candidato=?, distrito_candidato=?,id_municipio=?, url_foto_candidato=?, foto_candidato=?, trlrfonr_fixo=?, telefone_movel=?, email_candidato=?, id_profissao=? WHERE id_candidato=? ";
    private static final String ELIMINAR = "DELETE FROM candidato WHERE id_candidato = ? ";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM canditado WHERE id_candidato =?";
    private static final String LISTAR_TUDO = "SELECT * FROM candidato ORDER BY nome_candidato ASC";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Candidato candidato) {

        if (candidato == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, candidato.getNumeroCandidato());
            ps.setString(2, candidato.getNomeCandidato());
            ps.setString(3, candidato.getSobrenomeCandidato());
            ps.setDate(4, new java.sql.Date(candidato.getDataNascimento().getTime()));
            ps.setString(5, candidato.getSexo().getAbreviatura());
            ps.setString(6, candidato.getCasaCandidato());
            ps.setString(7, candidato.getBairroCandidato());

            ps.setString(8, candidato.getDistritoCandidato());
            ps.setInt(9, candidato.getMunicipio().getIdMunicipio());
            ps.setString(10, candidato.getUrlFotoCandidato());
            ps.setBytes(11, candidato.getFotoCandidato());
            ps.setString(12, candidato.getTelefoneFixo());
            ps.setString(13, candidato.getTelefoneMovel());
            ps.setString(14, candidato.getEmailCandidato());
            ps.setInt(15, candidato.getProfissao().getIdProfissao());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro a inserir dados: " + e.getLocalizedMessage());
            System.out.println(e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Candidato candidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (candidato == null) {

            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, candidato.getNomeCandidato());
            ps.setString(2, candidato.getCasaCandidato());
            ps.setString(3, candidato.getBairroCandidato());
            ps.setString(4, candidato.getDistritoCandidato());
            ps.setBytes(5, candidato.getFotoCandidato());
            ps.setString(6, candidato.getEmailCandidato());
            ps.setString(7, candidato.getSobrenomeCandidato());
            ps.setString(8, candidato.getTelefoneFixo());
            ps.setString(9, candidato.getTelefoneMovel());
            ps.setString(10, candidato.getUrlFotoCandidato());
            ps.setString(11, candidato.getSexo().getAbreviatura());

            ps.setInt(12, candidato.getMunicipio().getIdMunicipio());
            ps.setInt(13, candidato.getProfissao().getIdProfissao());
            ps.setString(14, candidato.getNumeroCandidato());
            ps.setDate(15, new java.sql.Date(candidato.getDataNascimento().getTime()));
            ps.setInt(16, candidato.getIdCandidato());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Candidato candidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (candidato == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, candidato.getIdCandidato());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Candidato findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Candidato candidato = new Candidato();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = (ResultSet) ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o id:  " + id);
            }
            popularComDados(candidato, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn, ps, rs);

            {
            }
        }
        return candidato;
    }

    @Override
    public List<Candidato> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn);
        }

        return candidatos;
    }

    @Override
    public void popularComDados(Candidato candidato, ResultSet rs) {
        try {
            candidato.setIdCandidato(rs.getInt("id_candidato"));
            candidato.setNumeroCandidato(rs.getString("numero_candidato"));
            candidato.setNomeCandidato(rs.getString("nome_candidato"));
            candidato.setSobrenomeCandidato(rs.getString("sobrenome_candidato"));
            candidato.setDataNascimento(rs.getDate("data_nascimento"));
            candidato.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));
            candidato.setCasaCandidato(rs.getString("casa_candidato"));
            candidato.setBairroCandidato(rs.getString("bairro_candidato"));
            candidato.setDistritoCandidato(rs.getString("distrito_candidato"));
            
            candidato.setTelefoneFixo(rs.getString("telefone_fixo"));
            candidato.setTelefoneMovel(rs.getString("telefone_movel"));
            candidato.setEmailCandidato(rs.getString("email_candidato"));

            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(rs.getInt("id_municipio"));
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            candidato.setMunicipio(municipio);

            candidato.setUrlFotoCandidato(rs.getString("url_foto_candidato"));
            candidato.setFotoCandidato(rs.getBytes("foto_candidato"));

            Profissao profissao = new Profissao();
            profissao.setIdProfissao(rs.getInt("id_profissao"));
            profissao.setNomeProfissao(rs.getString("nome_profissao"));
            candidato.setProfissao(profissao);
            

            candidato.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));

        } catch (SQLException e) {
        }
    }
}
