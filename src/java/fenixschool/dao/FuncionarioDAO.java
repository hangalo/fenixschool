/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Funcionario;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.Sexo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aisha Lubadika
 */
public class FuncionarioDAO implements GenericoDAOLogico<Funcionario> {

    private static final String INSERIR = "INSERT INTO funcionario (nome_funcionario, sobrenome_funcionario, sexo, data_nascimento, casa_funcionario, bairro_funcionario, distrito_funcionario, id_municipio, foto_funcionario, url_foto_funcionario, telefone_fixo, telefone_movel, email_funcionario, login_funcionario, password_funcionario )VALUES(?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    private static final String ACTUALIZAR = "UPDATE funcionario SET  nome_funcionario= ?, sobrenome_funcionario= ?,sexo= ?, data_nascimento =?, casa_funcionario = ?, bairro_funcionario=?, distrito_funcionario = ?, id_municipio = ?, foto_funcionario = ?,url_foto_funcionario=?, telefone_fixo= ?, telefone_movel= ?, email_funcionario= ?, login_funcionario =? ,password_funcionario=? WHERE id_funcionario = ?;";
    private static final String ELIMINAR = "DELETE FROM funcionario WHERE id_funcionario=?";
    private static final String SELECT_BY_NOME = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario,m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario, f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON (f.id_municipio=m.id_municipio) WHERE nome_funcionario = ?";
    private static final String SELECT_BY_SOBRENOME = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario, m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario, f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON (f.id_municipio=m.id_municipio) WHERE sobrenome_funcionario = ?";
    private static final String SELECT_BY_NOME_E_SOBRENOME = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario,m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario,f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON (f.id_municipio=m.id_municipio) WHERE nome_funcionario = ? AND sobrenome_funcionario= ?";
    //private static final String SELECT_FOTO_BY_ID = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario,m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario , f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON m.id_municipio=f.id_municipio WHERE f.id_funcionario = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario,m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario , f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON m.id_municipio=f.id_municipio WHERE f.id_funcionario = ?";
    private static final String BUSCAR_POR_DATA_NASCIMENTO = "SELECT f.id_funcionario ,f.nome_funcionario ,f.sobrenome_funcionario ,f.data_nascimento , f.sexo ,f.casa_funcionario ,f.bairro_funcionario ,f.distrito_funcionario,m.nome_municipio ,f.foto_funcionario ,f.url_foto_funcionario ,f.telefone_fixo ,f.telefone_movel ,f.email_funcionario, f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON m.id_municipio=f.id_municipio WHERE f.data_nascimento = ?";

    private static final String LISTAR_TUDO = "SELECT f.id_funcionario,f.nome_funcionario,f.sobrenome_funcionario,f.data_nascimento, f.sexo, f.casa_funcionario,f.bairro_funcionario,f.distrito_funcionario,m.nome_municipio,f.foto_funcionario,f.url_foto_funcionario,f.telefone_fixo,f.telefone_movel ,f.email_funcionario, f.login_funcionario, f.password_funcionario FROM funcionario f INNER JOIN municipio m ON m.id_municipio=f.id_municipio";

    /**
     *
     * @param funcionario
     * @return
     */
    @Override
    public boolean save(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (funcionario == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setString(3, funcionario.getSexo().getAbreviatura());
            ps.setDate(4, new java.sql.Date(funcionario.getDataNascimentoFuncionario().getTime()));

            ps.setString(5, funcionario.getCasaFuncionario());
            ps.setString(6, funcionario.getBairroFuncionario());

            ps.setString(7, funcionario.getDistritoFuncionario());
            ps.setInt(8, funcionario.getMunicipio().getIdMunicipio());
            ps.setBytes(9, funcionario.getFotoFuncionario());
            ps.setString(10, funcionario.getUrlfotoFuncionario());

            ps.setString(11, funcionario.getTelefoneFixoFuncionario());
            ps.setString(12, funcionario.getTelefoneMovelFuncionario());
            ps.setString(13, funcionario.getEmailFuncionario());
            ps.setString(14, funcionario.getLoginFuncionario());
            ps.setString(15, funcionario.getPasswordFuncionario());
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
    public boolean update(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (funcionario == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setString(3, funcionario.getSexo().getAbreviatura());
            ps.setDate(4, new java.sql.Date(funcionario.getDataNascimentoFuncionario().getTime()));

            ps.setString(5, funcionario.getCasaFuncionario());
            ps.setString(6, funcionario.getBairroFuncionario());

            ps.setString(7, funcionario.getDistritoFuncionario());

            ps.setInt(8, funcionario.getMunicipio().getIdMunicipio());
            ps.setBytes(9, funcionario.getFotoFuncionario());
            ps.setString(10, funcionario.getUrlfotoFuncionario());

            ps.setString(11, funcionario.getTelefoneFixoFuncionario());
            ps.setString(12, funcionario.getTelefoneMovelFuncionario());
            ps.setString(13, funcionario.getEmailFuncionario());

            ps.setString(14, funcionario.getLoginFuncionario());
            ps.setString(15, funcionario.getPasswordFuncionario());
            ps.setInt(16, funcionario.getIdFuncionario());

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
    public boolean delete(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (funcionario == null) {
            System.out.println("O valor passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, funcionario.getIdFuncionario());

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

        }
    }

    @Override
    public Funcionario findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        Funcionario funcionario = new Funcionario();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(funcionario, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection(conn);
        }
        return funcionarios;
    }

    public Funcionario findByNome(String nome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + nome);
            }
            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionario;
    }

    public Funcionario findBySobrenome(String sobrenome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_SOBRENOME);
            ps.setString(1, sobrenome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + sobrenome);
            }
            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionario;

    }

    public Funcionario findByNomeSobrenome(String nome, String sobrenome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_NOME_E_SOBRENOME);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o nome: " + sobrenome);
            }
            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionario;
    }

    public List<Funcionario> findByDataNascimento(Date data) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_DATA_NASCIMENTO);

            ps.setDate(1, new java.sql.Date(data.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionarios;
    }

    @Override
    public void popularComDados(Funcionario funcionario, ResultSet rs) {
        try {
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));

            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            funcionario.setSobrenomeFuncionario(rs.getString("sobrenome_funcionario"));
            funcionario.setDataNascimentoFuncionario(rs.getDate("data_nascimento"));

            funcionario.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));

            funcionario.setCasaFuncionario(rs.getString("casa_funcionario"));
            funcionario.setBairroFuncionario(rs.getString("bairro_funcionario"));
            funcionario.setDistritoFuncionario(rs.getString("distrito_funcionario"));

            Municipio municipio = new Municipio();

            municipio.setNomeMunicipio("nome_municipio");
            funcionario.setMunicipio(municipio);
            funcionario.setUrlfotoFuncionario(rs.getString("url_foto_funcionario"));

            funcionario.setFotoFuncionario(rs.getBytes("foto_funcionario"));
            funcionario.setTelefoneFixoFuncionario(rs.getString("telefone_fixo"));
            funcionario.setTelefoneMovelFuncionario(rs.getString("telefone_movel"));
            funcionario.setEmailFuncionario(rs.getString("email_funcionario"));
            funcionario.setLoginFuncionario(rs.getString("login_funcionario"));
            funcionario.setPasswordFuncionario(rs.getString("password_funcionario"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do funcionário: " + ex.getLocalizedMessage());
        }

    }

}
