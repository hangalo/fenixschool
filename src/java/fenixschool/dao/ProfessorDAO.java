/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Municipio;
import fenixschool.modelo.Professor;
import fenixschool.modelo.Sexo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulley
 */
public class ProfessorDAO implements GenericoDAOLogico<Professor> {

    private static final String INSERT = "INSERT INTO professor (nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor, casa_professor, rua_professor,bairro_professor,distrito_urbano_professor,telemovel_principal_professor, telemovel_alternativo_professor,telefone_principal_professor,telefone_alternativo_professor, email_principal_professor,email_aternativo_professor,numero_bi_professor,iban_professor,numero_passaporte_professor, id_municipio)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Professor SET nome_professor = ?, sobrenome_professor = ?,data_nascimento_professor = ?,sexo_professor = ?,nif_professor = ?,foto_professor = ?,url_foto_professor = ?, casa_professor = ?,rua_professor = ?,bairro_professor = ?,distrito_urbano_professor = ?,telemovel_principal_professor = ?, telemovel_alternativo_professor = ?,telefone_principal_professor = ?,telefone_alternativo_professor = ?, email_principal_professor = ?,email_aternativo_professor = ?,numero_bi_professor = ?,iban_professor = ?,numero_passaporte_professor = ?, id_municipio = ? WHERE id_professor = ?";
    private static final String DELETE = "DELETE FROM Professor WHERE id_professor = ?";
    private static final String SELECT_BY_ID = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE id_professor = ?";
    private static final String SELECT_ALL = "SELECT id_professor,nome_professor,sobrenome_professor,data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio);";
    private static final String SELECT_BY_NOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE nome_professor = ?";
    private static final String SELECT_BY_SOBRENOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE sobrenome_professor = ?";
    private static final String SELECT_BY_NOME_E_SOBRENOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE nome_professor = ? AND sobrenome_professor = ?";

    private static final String SELECT_BY_BI = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE numero_bi_professor = ?";

    @Override
    public boolean save(Professor professor) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professor == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);

            ps.setString(1, professor.getNomeProfessor());
            ps.setString(2, professor.getSobrenomeProfessor());
            ps.setDate(3, new java.sql.Date(professor.getDataNascimentoProfessor().getTime()));
            ps.setString(4, professor.getSexo().getAbreviatura());
            ps.setString(5, professor.getNifProfessor());
            ps.setBytes(6, professor.getFotoProfessor());
            ps.setString(7, professor.getUrlFotoProfessor());
            ps.setString(8, professor.getCasaProfessor());
            ps.setString(9, professor.getRuaProfessor());
            ps.setString(10, professor.getBairroProfessor());
            ps.setString(11, professor.getDistritoUrbanoProfessor());
            ps.setString(12, professor.getTelemovelPrincipalProfessor());
            ps.setString(13, professor.getTelemovelAlternativoProfessor());
            ps.setString(14, professor.getTelefonePrincipalProfessor());
            ps.setString(15, professor.getTelefoneAlternativoProfessor());
            ps.setString(16, professor.getEmailPrincipalProfessor());
            ps.setString(17, professor.getEmailAlternativoProfessor());
            ps.setString(18, professor.getNumeroBIProfessor());
            ps.setString(19, professor.getIBAMProfessor());
            ps.setString(20, professor.getNumeroPassaporteProfessor());
            ps.setInt(21, professor.getMunicipio().getIdMunicipio());

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
    public boolean update(Professor professor) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professor == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, professor.getNomeProfessor());
            ps.setString(2, professor.getSobrenomeProfessor());
            ps.setDate(3, new java.sql.Date(professor.getDataNascimentoProfessor().getTime()));
            ps.setString(4, professor.getSexo().getAbreviatura());
            ps.setString(5, professor.getNifProfessor());
            ps.setBytes(6, professor.getFotoProfessor());
            ps.setString(7, professor.getUrlFotoProfessor());
            ps.setString(8, professor.getCasaProfessor());
            ps.setString(9, professor.getRuaProfessor());
            ps.setString(10, professor.getBairroProfessor());
            ps.setString(11, professor.getDistritoUrbanoProfessor());
            ps.setString(12, professor.getTelemovelPrincipalProfessor());
            ps.setString(13, professor.getTelemovelAlternativoProfessor());
            ps.setString(14, professor.getTelefonePrincipalProfessor());
            ps.setString(15, professor.getTelefoneAlternativoProfessor());
            ps.setString(16, professor.getEmailPrincipalProfessor());
            ps.setString(17, professor.getEmailAlternativoProfessor());
            ps.setString(18, professor.getNumeroBIProfessor());
            ps.setString(19, professor.getIBAMProfessor());
            ps.setString(20, professor.getNumeroPassaporteProfessor());
            ps.setInt(21, professor.getMunicipio().getIdMunicipio());
            ps.setInt(22, professor.getIdProfessor());

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
    public boolean delete(Professor professor) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professor == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, professor.getIdProfessor());

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
    public Professor findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("NÃ£o foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    public Professor findByNome(String nome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + nome);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    public Professor findBySobrenome(String sobrenome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_SOBRENOME);
            ps.setString(1, sobrenome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + sobrenome);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    public Professor findByNomeSobrenome(String nome, String sobrenome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME_E_SOBRENOME);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + sobrenome);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    public Professor findByNumeroBI(String numeroBI) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_BI);
            ps.setString(1, numeroBI);

            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o BI: " + numeroBI);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    @Override
    public List<Professor> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Professor> professores = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                popularComDados(professor, rs);
                professores.add(professor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return professores;
    }

    @Override
    public void popularComDados(Professor professor, ResultSet rs) {
        try {

            professor.setIdProfessor(rs.getInt("id_professor"));
            professor.setNomeProfessor(rs.getString("nome_professor"));
            professor.setSobrenomeProfessor(rs.getString("sobrenome_professor"));
            professor.setDataNascimentoProfessor(rs.getDate("data_nascimento_professor"));
            professor.setSexo(Sexo.getAbreviatura(rs.getString("sexo_professor")));
            professor.setNifProfessor(rs.getString("nif_professor"));
            professor.setFotoProfessor(rs.getBytes("foto_professor"));
            professor.setUrlFotoProfessor(rs.getString("url_foto_professor"));
            professor.setCasaProfessor(rs.getString("casa_professor"));
            professor.setRuaProfessor(rs.getString("rua_professor"));
            professor.setBairroProfessor(rs.getString("bairro_professor"));
            professor.setDistritoUrbanoProfessor(rs.getString("distrito_urbano_professor"));
            professor.setTelemovelPrincipalProfessor(rs.getString("telemovel_principal_professor"));
            professor.setTelemovelAlternativoProfessor(rs.getString("telemovel_alternativo_professor"));
            professor.setTelefonePrincipalProfessor(rs.getString("telefone_principal_professor"));
            professor.setTelefoneAlternativoProfessor(rs.getString("telefone_alternativo_professor"));
            professor.setEmailPrincipalProfessor(rs.getString("email_principal_professor"));
            professor.setEmailAlternativoProfessor(rs.getString("email_aternativo_professor"));
            professor.setNumeroBIProfessor(rs.getString("numero_bi_professor"));
            professor.setIBAMProfessor(rs.getString("iban_professor"));
            professor.setNumeroPassaporteProfessor(rs.getString("numero_passaporte_professor"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            professor.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }

    }

}
