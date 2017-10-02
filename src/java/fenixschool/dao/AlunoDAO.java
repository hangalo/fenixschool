/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Profissao;
import fenixschool.modelo.Sexo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulley
 */
public class AlunoDAO implements GenericoDAOLogico<Aluno>{
    
    private static final String INSERIR = "INSERT INTO aluno (numero_aluno, nome_aluno, sobrenome_aluno, data_nascimento, casa_aluno, bairro_aluno, distrito_aluno, id_municipio, url_foto_aluno, foto_aluno, telefone_fixo, telefone_movel, email_aluno, id_profissao, sexo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = " UPDATE aluno SET numero_aluno=?, nome_aluno=?, sobrenome_aluno=?, data_nascimento=?, casa_aluno=?, bairro_aluno=?, distrito_aluno=?, id_municipio=?, url_foto_aluno=?, foto_aluno=?,telefone_fixo=?,telefone_movel=?,email_aluno=?,id_profissao=?, sexo=? WHERE id_aluno=?";
    private static final String DELETE = "DELETE FROM aluno WHERE id_aluno=?";
    private static final String SELECT_BY_ID = "SELECT a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.sexo, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao p FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE id_aluno = ?";
    private static final String SELECT_ALL = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao";
    private static final String SELECT_BY_NOME = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE nome_aluno = ?";
    private static final String SELECT_BY_SOBRENOME = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE sobrenome_aluno = ?";
    private static final String SELECT_BY_NOME_E_SOBRENOME = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE nome_aluno =? AND sobrenome_aluno=? ORDER BY nome_aluno ASC";
    private static final String SELECT_BY_NUMERO = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE numero_aluno =? ";
    private static final String SELECT_BY_SEXO = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE sexo =? ";
    private static final String SELECT_BY_NASCIMENTO = "select a.id_aluno, a.numero_aluno, a.nome_aluno, a.sobrenome_aluno, a.data_nascimento, a.casa_aluno, a.bairro_aluno, a.distrito_aluno, m.nome_municipio, a.url_foto_aluno, a.foto_aluno, a.telefone_fixo, a.telefone_movel, a.email_aluno, p.nome_profissao, a.sexo FROM aluno a INNER JOIN municipio m ON m.id_municipio=a.id_municipio INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE data_nascimento =? ";
    
    
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public boolean save(Aluno aluno) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if(aluno == null){
            System.err.println("O campo anterior não pode ser nulo!");
        }
        
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, aluno.getNumeroAluno());
            ps.setString(2, aluno.getNomeAluno());
            ps.setString(3, aluno.getSobrenomeAluno());
            ps.setDate(4, new java.sql.Date(aluno.getDataNascimentoAluno().getTime()));
            ps.setString(5 , aluno.getCasaAluno());
            ps.setString(6, aluno.getBairroAluno());
            ps.setString(7, aluno.getDistritoAluno());
            //System.out.println("Municipio"+aluno.getMunicipioAluno().getIdMunicipio());
            ps.setInt(8, aluno.getMunicipioAluno().getIdMunicipio());
            ps.setString(9, aluno.getUrlfotoAluno());
            ps.setBytes(10, aluno.getFotoAluno());
            ps.setString(11, aluno.getTelefoneFixoAluno());
            ps.setString(12, aluno.getTelefoneMovelAluno());
            ps.setString(13, aluno.getEmailAluno());
            ps.setInt(14, aluno.getProfissaoAluno().getIdProfissao());
            ps.setString(15, aluno.getSexo().getAbreviatura());
            //ps.setInt(16, aluno.getProvincia().getIdProvincia());
            
            int retorno = ps.executeUpdate();
            if(retorno > 0){
                System.out.println("Dados inseridos com Sucesso: " +ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally{Conexao.closeConnection(conn,ps);}
        
        
    }

    @Override
    public boolean update(Aluno aluno) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (aluno == null) {

            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, aluno.getNumeroAluno());
            ps.setString(2, aluno.getNomeAluno());
            ps.setString(3, aluno.getSobrenomeAluno());
            ps.setDate(4, new java.sql.Date(aluno.getDataNascimentoAluno().getTime()));
            ps.setString(5 , aluno.getCasaAluno());
            ps.setString(6, aluno.getBairroAluno());
            ps.setString(7, aluno.getDistritoAluno());
            System.out.println("Municipio"+aluno.getMunicipioAluno().getIdMunicipio());
            ps.setInt(8, aluno.getMunicipioAluno().getIdMunicipio());
            ps.setString(9, aluno.getUrlfotoAluno());
            ps.setBytes(10, aluno.getFotoAluno());
            ps.setString(11, aluno.getTelefoneFixoAluno());
            ps.setString(12, aluno.getTelefoneMovelAluno());
            ps.setString(13, aluno.getEmailAluno());
            ps.setInt(14, aluno.getProfissaoAluno().getIdProfissao());
            ps.setString(15, aluno.getSexo().getAbreviatura());
            ps.setInt(16, aluno.getIdAluno());

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
    public boolean delete(Aluno aluno) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (aluno == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, aluno.getIdAluno());
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
    public Aluno findById(Integer id) {
        Aluno aluno = new Aluno();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse ID: " + id);

            }
            popularComDados(aluno, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return aluno;
    }
    
    public List<Aluno> findByNomeSobrenome(String nome, String sobrenome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME_E_SOBRENOME);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            rs = ps.executeQuery();
            while (rs.next()){
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }            
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunos;
    }
    
    public List<Aluno> findByNome(String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            } 
          
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunos;
    }
    
    public List<Aluno> findBySobrenome(String sobrenome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_SOBRENOME);
            ps.setString(1, sobrenome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }  

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunos;
    }
    
    public Aluno findByNumero(String numero) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Aluno aluno = new Aluno();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NUMERO);
            ps.setString(1, numero);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o numero:  " + numero);
            }
            popularComDados(aluno, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return aluno;
    }
    
    public List<Aluno> findBySexo(String sexo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_SEXO);
            ps.setString(1, sexo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }  
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunos;
    }

    public List<Aluno> findByDataDeNascimento(Date data) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NASCIMENTO);
            ps.setDate(1, data);
         
            rs = ps.executeQuery();
            while (rs.next()){
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return alunos;
    }
    
    @Override
    public List<Aluno> findAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn);
        }

        return alunos;
    }


    @Override
    public void popularComDados(Aluno aluno, ResultSet rs) {
        try {
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setNumeroAluno(rs.getString("numero_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));

            aluno.setCasaAluno(rs.getString("casa_aluno"));
            aluno.setBairroAluno(rs.getString("bairro_aluno"));
            aluno.setDistritoAluno(rs.getString("distrito_aluno"));

            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            aluno.setMunicipioAluno(municipio);
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));

            aluno.setFotoAluno(rs.getBytes("foto_aluno"));
            aluno.setTelefoneFixoAluno(rs.getString("telefone_fixo"));
            aluno.setTelefoneMovelAluno(rs.getString("telefone_movel"));
            aluno.setEmailAluno(rs.getString("email_aluno"));

            Profissao profissao = new Profissao();
            profissao.setNomeProfissao(rs.getString("nome_profissao"));
            aluno.setProfissaoAluno(profissao);
            aluno.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do aluno: " + ex.getLocalizedMessage());
           
        }

    }
    
}