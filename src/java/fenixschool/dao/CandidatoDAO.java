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
import java.util.ArrayList;
import java.util.List;
import fenixschool.modelo.Sexo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

public class CandidatoDAO implements GenericoDAOLogico<Candidato> {

    private static final String INSERIR = "INSERT INTO candidato (numero_candidato, nome_candidato, sobrenome_candidato, data_nascimento, sexo, casa_candidato, bairro_candidato, distrito_candidato, id_municipio, url_foto_candidato, foto_candidato, telefone_fixo, telefone_movel, email_candidato, id_profissao, login_candidato, password_candidato) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE candidato SET numero_candidato =?, nome_candidato=?, sobrenome_candidato=?, data_nascimento=?, sexo=?, casa_candidato=?, bairro_candidato=?, distrito_candidato=?,id_municipio=?, url_foto_candidato=?, foto_candidato=?, telefone_fixo=?, telefone_movel=?, email_candidato=?, id_profissao=?, login_candidato=?, password_candidato=? WHERE id_candidato=? ";
    private static final String ELIMINAR = "DELETE FROM candidato WHERE id_candidato = ? ";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE id_candidato =? ORDER BY nome_candidato ASC";

    private static final String LISTAR_TUDO = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio ORDER BY nome_candidato ASC";

    
    private static final String LISTAR_POR_NOME_E_SOBRENOME = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE nome_candidato =? AND sobrenome_candidato=? ORDER BY nome_candidato ASC";

    private static final String LISTAR_POR_NUMERO = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE numero_candidato=? ORDER BY nome_candidato ASC";

    private static final String LISTAR_POR_SEXO = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE sexo=? ORDER BY nome_candidato ASC";

    private static final String SELECT_BY_NOME = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE nome_candidato=? ORDER BY nome_candidato ASC ";

    private static final String SELECT_BY_SOBRENOME = "SELECT * FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao "
            + "INNER JOIN municipio m ON c.id_municipio = m.id_municipio WHERE sobrenome_candidato=? ORDER BY nome_candidato ASC ";
    
    private static final String SELECT_DATA_NASCIMENTO ="SELECT *  FROM candidato c INNER JOIN profissao p ON c.id_profissao = p.id_profissao INNER JOIN municipio m ON c.id_municipio = m.id_municipio  WHERE c.data_nascimento < ? AND c.data_nascimento > ?  ORDER BY c.nome_candidato ASC;";
    
    
    @Override
    public boolean save(Candidato candidato){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
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
            ps.setString(16, candidato.getLoginCandidato());
            ps.setString(17, candidato.getPasswordCandidato());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Candidato candidato) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (candidato == null) {

            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

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
            ps.setInt(16, candidato.getIdCandidato());
            ps.setString(16, candidato.getLoginCandidato());
            ps.setString(17, candidato.getPasswordCandidato());
            ps.setInt(18, candidato.getIdCandidato());
            
            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

         } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Candidato candidato) {
          Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (candidato == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, candidato.getIdCandidato());
            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            
             return flagControlo;
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }
    
    
    @Override
    public Candidato findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Candidato candidato = new Candidato();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o id:  " + id);
            }
            popularComDados(candidato, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidato;

    }

    public List<Candidato> findByNomeSobrenome(String nome, String sobrenome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_NOME_E_SOBRENOME);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            rs = ps.executeQuery();
             while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            } 
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }

    public List<Candidato> findByNome(String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            } 
          
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }

    public List<Candidato> findBySobrenome(String sobrenome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_SOBRENOME);
            ps.setString(1, sobrenome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            }  

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }

    public Candidato findByNumero(String numero) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Candidato candidato = new Candidato();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_NUMERO);
            ps.setString(1, numero);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o numero:  " + numero);
            }
            popularComDados(candidato, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidato;
    }

    public List<Candidato> findBySexo(String sexo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_SEXO);
            ps.setString(1, sexo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            }  
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }

    public List<Candidato> findByDataDeNascimento(String dataInicio, String dataFim) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_DATA_NASCIMENTO);
            
              ps.setString(1, dataInicio);
              ps.setString(2, dataFim);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }

    @Override
    public List<Candidato> findAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Candidato> candidatos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
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
            candidato.setLoginCandidato(rs.getString("login_candidato"));
            candidato.setPasswordCandidato(rs.getString("password_candidato"));

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
            System.out.println("Erro ao carregar dados");
        }
    }

    
    
}
