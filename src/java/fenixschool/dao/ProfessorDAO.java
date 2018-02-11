/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CategoriaCargo;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Professor;
import fenixschool.modelo.ProfessorCategoriaCargo;
import fenixschool.modelo.ProfessorDepartamento;
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

    private static final String INSERT = "INSERT INTO professor (nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor, casa_professor, rua_professor,bairro_professor,distrito_urbano_professor,telemovel_principal_professor, telemovel_alternativo_professor,telefone_principal_professor,telefone_alternativo_professor, email_principal_professor,email_aternativo_professor,numero_bi_professor,iban_professor,numero_passaporte_professor, id_municipio, login_professor, password_professor)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Professor SET nome_professor = ?, sobrenome_professor = ?,data_nascimento_professor = ?,sexo_professor = ?,nif_professor = ?,foto_professor = ?,url_foto_professor = ?, casa_professor = ?,rua_professor = ?,bairro_professor = ?,distrito_urbano_professor = ?,telemovel_principal_professor = ?, telemovel_alternativo_professor = ?,telefone_principal_professor = ?,telefone_alternativo_professor = ?, email_principal_professor = ?,email_aternativo_professor = ?,numero_bi_professor = ?,iban_professor = ?,numero_passaporte_professor = ?, id_municipio = ? login_professor =?, password_professor=? WHERE id_professor = ?";
    private static final String DELETE = "DELETE FROM Professor WHERE id_professor = ?";
    private static final String SELECT_BY_ID = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE id_professor = ?";

    private static final String SELECT_ALL = "SELECT id_professor,nome_professor,sobrenome_professor,data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio);";
    private static final String SELECT_BY_NOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE nome_professor = ?";
    private static final String SELECT_BY_SOBRENOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE sobrenome_professor = ?";
    private static final String SELECT_BY_NOME_E_SOBRENOME = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE nome_professor = ? AND sobrenome_professor = ?";
    private static final String SELECT_FOTO_BY_ID = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE id_professor = ?";
    private static final String SELECT_BY_BI = "SELECT id_professor,nome_professor,sobrenome_professor, data_nascimento_professor, sexo_professor,nif_professor,foto_professor,url_foto_professor,casa_professor,rua_professor, bairro_professor, distrito_urbano_professor,telemovel_principal_professor,telemovel_alternativo_professor,telefone_principal_professor, telefone_alternativo_professor, email_principal_professor, email_aternativo_professor,numero_bi_professor, iban_professor, numero_passaporte_professor, nome_municipio, login_professor, password_professor FROM professor p INNER JOIN municipio m ON (p.id_municipio=m.id_municipio) WHERE numero_bi_professor = ?";
    private static final String SELECT_BY_DATE_DEPARTAMENTO = "SELECT  professor.id_professor,  professor.nome_professor,  professor.sobrenome_professor,  professor.data_nascimento_professor,  professor.sexo_professor,  professor.nif_professor,  professor.foto_professor,  professor.url_foto_professor,  professor.casa_professor,  professor.rua_professor,  professor.bairro_professor,  municipio.nome_municipio,  professor.distrito_urbano_professor,  professor.telemovel_principal_professor,  professor.telemovel_alternativo_professor,  professor.telefone_principal_professor,  professor.telefone_alternativo_professor,  professor.email_principal_professor,  professor.email_aternativo_professor,  professor.numero_bi_professor,  professor.iban_professor,  professor.numero_passaporte_professor,  professor.login_professor,  professor.password_professor,  professor_departamento.data_inicio,  professor_departamento.data_fim, departamento.nome_departamento,  professor_departamento.observacoes FROM professor  INNER JOIN professor_departamento ON professor_departamento.id_professor = professor.id_professor  INNER JOIN departamento  ON professor_departamento.id_departamento = departamento.id_departamento INNER JOIN municipio ON professor.id_municipio = municipio.id_municipio WHERE departamento.id_departamento =? AND professor_departamento.data_inicio BETWEEN ? AND ? AND professor_departamento.data_fim IS NULL";
     private static final String SELECT_BY_DATE_DEPARTAMENTO_CATEGORIA = "SELECT  professor.id_professor,  professor.nome_professor,  professor.sobrenome_professor,  professor.data_nascimento_professor,  professor.sexo_professor,  professor.nif_professor,  professor.foto_professor,  professor.url_foto_professor,  professor.casa_professor,  professor.rua_professor,  professor.bairro_professor,  municipio.nome_municipio,  professor.distrito_urbano_professor,  professor.telemovel_principal_professor,  professor.telemovel_alternativo_professor,  professor.telefone_principal_professor,  professor.telefone_alternativo_professor,  professor.email_principal_professor,  professor.email_aternativo_professor,  professor.numero_bi_professor,  professor.iban_professor,  professor.numero_passaporte_professor,  professor.login_professor,  professor.password_professor,  professor_departamento.data_inicio,  professor_departamento.data_fim, departamento.nome_departamento, categoria_cargo.categoria_cargo, professor_departamento.observacoes FROM professor  INNER JOIN professor_departamento ON professor_departamento.id_professor = professor.id_professor  INNER JOIN departamento  ON professor_departamento.id_departamento = departamento.id_departamento INNER JOIN municipio ON professor.id_municipio = municipio.id_municipio INNER JOIN professor_categoria_cargo ON professor_categoria_cargo.id_professor = professor.id_professor INNER JOIN categoria_cargo on categoria_cargo.id_categoria_cargo =professor_categoria_cargo.id_categoria_cargo WHERE departamento.id_departamento =? AND professor_departamento.data_inicio BETWEEN ? AND ? AND professor_departamento.data_fim IS NULL";

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
            System.out.println("Municipio" + professor.getMunicipio().getIdMunicipio());
            ps.setInt(21, professor.getMunicipio().getIdMunicipio());
            ps.setString(22, professor.getLoginProfessor());
            ps.setString(23, professor.getPasswordProfessor());

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
            ps.setString(22, professor.getLoginProfessor());
            ps.setString(23, professor.getPasswordProfessor());
            ps.setInt(24, professor.getIdProfessor());

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
            conn = Conexao.getConnection();
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
            conn = Conexao.getConnection();
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
            conn = Conexao.getConnection();
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

    public List<ProfessorDepartamento> findProfessorPorDepartamento(Departamento departamento, String inicioIntervalo, String fimIntervalo) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ProfessorDepartamento> professorDepartamentos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_DATE_DEPARTAMENTO_CATEGORIA);
            ps.setInt(1, departamento.getIdDepartamento());
            ps.setString(2, inicioIntervalo);
            ps.setString(3, fimIntervalo);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                ProfessorDepartamento professorDepartamento = new ProfessorDepartamento();
               popularComTodosDadosProfessorDepartamentoCategoria(professorDepartamento, rs);
                professorDepartamentos.add(professorDepartamento);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return professorDepartamentos;
    }

    public byte[] recuperarImagem(Integer id) {
        byte[] imagem = null;
        PreparedStatement ps;
        Connection conn = null;
        ResultSet rs;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_FOTO_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                imagem = rs.getBytes("foto_professor");
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }

        return imagem;
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
            professor.setLoginProfessor(rs.getString("login_professor"));
            professor.setPasswordProfessor(rs.getString("password_professor"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }

    }

   
      public void popularComTodosDadosProfessorDepartamentoCategoria(ProfessorDepartamento pd , ResultSet rs) {
        try {

            Professor professor = new Professor();
            
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
            professor.setLoginProfessor(rs.getString("login_professor"));
            professor.setPasswordProfessor(rs.getString("password_professor"));
            pd.setProfessor(professor);
            pd.setDataInicio(rs.getDate("data_inicio"));
            pd.setDataFim(rs.getDate("data_fim"));
            pd.setObservacoes(rs.getString("observacoes"));
            
            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            pd.setDepartamento(departamento);
            
            ProfessorCategoriaCargo pc = new ProfessorCategoriaCargo();
            CategoriaCargo  categoriaCargo = new CategoriaCargo();
            categoriaCargo.setCategoriaCargo(rs.getString("categoria_cargo"));
            pc.setCategoriaCargo(categoriaCargo);
            pd.setProfessorCategoriaCargo(pc);
            
          
            

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }

    }
    
/*
       public void popularComTodosDados(ProfessorDepartamento pd, ResultSet rs) {
        try {

            Professor professor = new Professor();
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
            professor.setLoginProfessor(rs.getString("login_professor"));
            professor.setPasswordProfessor(rs.getString("password_professor"));
            pd.setProfessor(professor);
            pd.setDataInicio(rs.getDate("data_inicio"));
            pd.setDataFim(rs.getDate("data_fim"));
            pd.setObservacoes(rs.getString("observacoes"));
            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            pd.setDepartamento(departamento);
            

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do professor: " + ex.getLocalizedMessage());
        }

    }

      
      */
      
      
}
