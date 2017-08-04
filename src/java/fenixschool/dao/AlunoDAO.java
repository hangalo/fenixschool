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
public class AlunoDAO implements GenericoDAO<Aluno> {

    private static final String INSERIR = "INSERT INTO aluno()VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = " UPDATE aluno SET numero_aluno=?,nome_aluno=?,sobrenome_aluno=?,data_nascimento=?,id_sexo=?,casa_aluno=?,bairro_aluno=?,distrito_aluno=?,id_municipio=?, urlfoto_aluno=? foto_aluno=?,telefone_fixo=?,telefone_movel=?,email_aluno=?,id_profissao=? WHERE id_aluno=?";
    private static final String ELIMINAR = "DELETE FROM aluno WHERE id_aluno=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_aluno a, numero_aluno a, nome_aluno a, sobrenome_aluno a, data_nascimento a, designacao_sexo s, casa_aluno a, bairro_aluno a, distrito_aluno a, nome_municipio m,urlfoto_aluno a, foto_aluno a, telefone_fixo a, telefone_movel a, email_aluno a, nome_profissao p "
            + "FROM aluno a "
            + "INNER JOIN sexo s on a.id_sexo=s.id_sexo "
            + "INNER JOIN municipio m ON m.id_municipio=a.id_municipio "
            + "INNER JOIN profissao p ON p.id_profissao=a.id_profissao WHERE id_aluno=?";

    private static final String LISTAR_TUDO = "SELECT id_aluno a, numero_aluno a, nome_aluno a, sobrenome_aluno a, data_nascimento a, designacao_sexo s, casa_aluno a, bairro_aluno a, distrito_aluno a, nome_municipio m,urlfoto_aluno a, foto_aluno a, telefone_fixo a, telefone_movel a, email_aluno a, nome_profissao p "
            + "FROM aluno a "
            + "INNER JOIN sexo s on a.id_sexo=s.id_sexo "
            + "INNER JOIN municipio m ON m.id_municipio=a.id_municipio "
            + "INNER JOIN profissao p ON p.id_profissao=a.id_profissao";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Aluno aluno) {
        if (aluno == null) {
            System.out.println("O valor passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, aluno.getNumeroAluno());
            ps.setString(2, aluno.getNomeAluno());
            ps.setString(3, aluno.getSobrenomeAluno());
            ps.setDate(4, new java.sql.Date(aluno.getDataNascimentoAluno().getTime()));
            ps.setString(5, aluno.getSexo().getAbreviatura());
            ps.setString(6, aluno.getCasaAluno());
            ps.setString(7, aluno.getBairroAluno());
            ps.setString(8, aluno.getDistritoAluno());
            ps.setInt(9, aluno.getMunicipioAluno().getIdMunicipio());
            ps.setString(10, aluno.getUrlfotoAluno());
            ps.setBytes(11, aluno.getFotoAluno());
            ps.setString(12, aluno.getTelefoneFixoAluno());
            ps.setString(13, aluno.getTelefoneMovelAluno());
            ps.setString(14, aluno.getEmailAluno());
            ps.setInt(15, aluno.getProfissaoAluno().getIdProfissao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Aluno aluno) {
        if (aluno == null) {
            System.out.println("O valor passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, aluno.getNumeroAluno());
            ps.setString(2, aluno.getNomeAluno());
            ps.setString(3, aluno.getSobrenomeAluno());
            ps.setDate(4, new java.sql.Date(aluno.getDataNascimentoAluno().getTime()));
            ps.setString(5, aluno.getSexo().getAbreviatura());
            ps.setString(6, aluno.getCasaAluno());
            ps.setString(7, aluno.getBairroAluno());
            ps.setString(8, aluno.getDistritoAluno());
            ps.setInt(9, aluno.getMunicipioAluno().getIdMunicipio());
            ps.setString(10, aluno.getUrlfotoAluno());
            ps.setBytes(11, aluno.getFotoAluno());
            ps.setString(12, aluno.getTelefoneFixoAluno());
            ps.setString(13, aluno.getTelefoneMovelAluno());
            ps.setString(14, aluno.getEmailAluno());
            ps.setInt(15, aluno.getProfissaoAluno().getIdProfissao());
            ps.setInt(16, aluno.getIdAluno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados: " + ex.getMessage());

        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Aluno aluno) {
        if (aluno == null) {
            System.out.println("O valor passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, aluno.getIdAluno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar dados: " + ex.getMessage());

        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Aluno findById(Integer id) {
        Aluno aluno = new Aluno();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
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

    @Override
    public List<Aluno> findAll() {
        ArrayList<Aluno> itens = new ArrayList<Aluno>();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                itens.add(aluno);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return itens;
    }

    @Override
    public void popularComDados(Aluno aluno, ResultSet rs) {
        try {
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setNumeroAluno(rs.getString("numero_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));
 
            aluno.setSexo(Sexo.getAbreviatura(rs.getString("designacao_sexo")));

            aluno.setCasaAluno(rs.getString("casa_aluno"));
            aluno.setBairroAluno(rs.getString("bairro_aluno"));
            aluno.setDistritoAluno(rs.getString("distrito_aluno"));

            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio("nome_municipio");
            aluno.setMunicipioAluno(municipio);
            aluno.setUrlfotoAluno(rs.getString("urlfoto_aluno"));

            aluno.setFotoAluno(rs.getBytes("foto_aluno"));
            aluno.setTelefoneFixoAluno(rs.getString("telefone_fixo"));
            aluno.setTelefoneMovelAluno(rs.getString("telefone_movel"));
            aluno.setEmailAluno(rs.getString("email_aluno"));

            Profissao profissao = new Profissao();
            profissao.setNomeProfissao("nome_profissao");
            aluno.setProfissaoAluno(profissao);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
