package fenixschool.dao;

import fenixschool.modelo.EncarregadoEducacao;
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

public class EncarregadoEducacaoDAO implements GenericoDAO<EncarregadoEducacao> {

    private static final String INSERIR = "INSERT INTO encarregado_educacao (nome_encarregado,sobrenome_encarregado,id_profissao_encarregado,sexo_encarregado,casa_encarregado,rua_encarregado,bairro_encarregado,distrito_urbano_encarregado,telemovel_principal_encarregado,telemovel_alternativo_encarregado,email_principal_encarregado,email_alternativo_encarregado,foto_encarregado,url_foto_encarregado,id_municipio)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE encarregado_educacao SET nome_encarregado = ?,sobrenome_encarregado= ?,id_profissao_encarregado= ?,sexo_encarregado = ?,casa_encarregado = ?,rua_encarregado = ?,bairro_encarregado =?,distrito_urbano_encarregado =?,telemovel_principal_encarregado =?,telemovel_alternativo_encarregado = ?,email_principal_encarregado = ?,email_alternativo_encarregado =?,foto_encarregado =?,url_foto_encarregado =?,id_municipio =? WHERE id_encarregado = ?";
    private static final String ELIMINAR = "DELETE FROM encarregado_educacao WHERE id_encarregado = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT e.nome_encarregado,e.sobrenome_encarregado,e.sexo_encarregado,e.casa_encarregado,e.rua_encarregado,e.bairro_encarregado,e.distrito_urbano_encarregado,e.telemovel_principal_encarregado,e.telemovel_alternativo_encarregado,e.email_principal_encarregado,e.email_alternativo_encarregado,e.foto_encarregado,e.url_foto_encarregado,e.id_municipio,m.nome_municipio,p.nome_profissao,p.id_profissao FROM encarregado_educacao e INNER JOIN municipio m ON e.id_municipio=m.id_municipio INNER JOIN profissao p ON p.id_profissao = e.id_profissao_encarregado WHERE id_encarregado=?";
    private static final String LISTAR_TUDO = "SELECT e.id_encarregado,e.nome_encarregado,e.sobrenome_encarregado,e.sexo_encarregado,e.casa_encarregado,e.rua_encarregado,e.bairro_encarregado,e.distrito_urbano_encarregado,e.telemovel_principal_encarregado,e.telemovel_alternativo_encarregado,e.email_principal_encarregado,e.email_alternativo_encarregado,e.foto_encarregado,e.url_foto_encarregado,e.id_municipio,m.nome_municipio,p.nome_profissao,p.id_profissao FROM encarregado_educacao e INNER JOIN municipio m ON e.id_municipio=m.id_municipio INNER JOIN profissao p ON p.id_profissao = e.id_profissao_encarregado";

    @Override
    public void save(EncarregadoEducacao encarregadoEducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoEducacao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

<<<<<<< HEAD
            ps.setString(1, encarregadoEducacao.getNome_encarregado());
            ps.setString(2, encarregadoEducacao.getSobrenome_encarregado());
            ps.setInt(3, encarregadoEducacao.getId_profissao_encarregado().getIdProfissao());
            ps.setString(4, encarregadoEducacao.getSexo_encarregado().getAbreviatura());
            ps.setString(5, encarregadoEducacao.getCasa_encarregado());
            ps.setString(6, encarregadoEducacao.getRua_encarregado());
            ps.setString(7, encarregadoEducacao.getBairro_encarregado());
            ps.setString(8, encarregadoEducacao.getDistrito_urbano_encarregado());
            ps.setString(9, encarregadoEducacao.getTelemovel_principal_encarregado());
            ps.setString(10, encarregadoEducacao.getTelemovel_alternativo_encarregado());
            ps.setString(11, encarregadoEducacao.getEmail_principal_encarregado());
            ps.setString(12, encarregadoEducacao.getEmail_alternativo_encarregado());
            ps.setBytes(13, encarregadoEducacao.getFoto_encarregado());
            ps.setString(14, encarregadoEducacao.getUrl_foto_encarregado());
=======
            ps.setString(1, encarregadoEducacao.getNomeEncarregado());
            ps.setString(2, encarregadoEducacao.getSobrenomeEncarregado());
            ps.setInt(3, encarregadoEducacao.getProfissao().getIdProfissao());
            ps.setString(4, encarregadoEducacao.getSexo().getAbreviatura());
            ps.setString(5, encarregadoEducacao.getCasaEncarregado());
            ps.setString(6, encarregadoEducacao.getRuaEncarregado());
            ps.setString(7, encarregadoEducacao.getBairroEncarregado());
            ps.setString(8, encarregadoEducacao.getDistritoUrbanoEncarregado());
            ps.setString(9, encarregadoEducacao.getTelemovelPrincipalEncarregado());
            ps.setString(10, encarregadoEducacao.getTelemovelAlternativoEncarregado());
            ps.setString(11, encarregadoEducacao.getEmailPrincipalEncarregado());
            ps.setString(12, encarregadoEducacao.getEmailAlternativoEncarregado());
            ps.setBytes(13, encarregadoEducacao.getFotoEncarregado());
            ps.setString(14, encarregadoEducacao.getUrlFotoEncarregado());
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
            ps.setInt(15, encarregadoEducacao.getMunicipio().getIdMunicipio());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(EncarregadoEducacao encarregadoEducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoEducacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
<<<<<<< HEAD
            ps.setString(1, encarregadoEducacao.getNome_encarregado());
            ps.setString(2, encarregadoEducacao.getSobrenome_encarregado());
            ps.setInt(3, encarregadoEducacao.getId_profissao_encarregado().getIdProfissao());
            ps.setString(4, encarregadoEducacao.getSexo_encarregado().getAbreviatura());
            ps.setString(5, encarregadoEducacao.getCasa_encarregado());
            ps.setString(6, encarregadoEducacao.getRua_encarregado());
            ps.setString(7, encarregadoEducacao.getBairro_encarregado());
            ps.setString(8, encarregadoEducacao.getDistrito_urbano_encarregado());
            ps.setString(9, encarregadoEducacao.getTelemovel_principal_encarregado());
            ps.setString(10, encarregadoEducacao.getTelemovel_alternativo_encarregado());
            ps.setString(11, encarregadoEducacao.getEmail_principal_encarregado());
            ps.setString(12, encarregadoEducacao.getEmail_alternativo_encarregado());
            ps.setBytes(13, encarregadoEducacao.getFoto_encarregado());
            ps.setString(14, encarregadoEducacao.getUrl_foto_encarregado());
            ps.setInt(15, encarregadoEducacao.getMunicipio().getIdMunicipio());
            ps.setInt(16, encarregadoEducacao.getId_encarregado_educacao());
=======
            ps.setString(1, encarregadoEducacao.getNomeEncarregado());
            ps.setString(2, encarregadoEducacao.getSobrenomeEncarregado());
            ps.setInt(3, encarregadoEducacao.getProfissao().getIdProfissao());
            ps.setString(4, encarregadoEducacao.getSexo().getAbreviatura());
            ps.setString(5, encarregadoEducacao.getCasaEncarregado());
            ps.setString(6, encarregadoEducacao.getRuaEncarregado());
            ps.setString(7, encarregadoEducacao.getBairroEncarregado());
            ps.setString(8, encarregadoEducacao.getDistritoUrbanoEncarregado());
            ps.setString(9, encarregadoEducacao.getTelemovelPrincipalEncarregado());
            ps.setString(10, encarregadoEducacao.getTelemovelAlternativoEncarregado());
            ps.setString(11, encarregadoEducacao.getEmailPrincipalEncarregado());
            ps.setString(12, encarregadoEducacao.getEmailAlternativoEncarregado());
            ps.setBytes(13, encarregadoEducacao.getFotoEncarregado());
            ps.setString(14, encarregadoEducacao.getUrlFotoEncarregado());
            ps.setInt(15, encarregadoEducacao.getMunicipio().getIdMunicipio());
            ps.setInt(16, encarregadoEducacao.getIdEncarregadoEducacao());
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(EncarregadoEducacao encarregadoeducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoeducacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, encarregadoeducacao.getIdEncarregadoEducacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }

    @Override
    public EncarregadoEducacao findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        EncarregadoEducacao encarregadoEducacao = new EncarregadoEducacao();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(encarregadoEducacao, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return encarregadoEducacao;
    }

    @Override
    public List<EncarregadoEducacao> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<EncarregadoEducacao> educacaos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                EncarregadoEducacao educacao = new EncarregadoEducacao();
                popularComDados(educacao, rs);
                educacaos.add(educacao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return educacaos;
    }

    @Override
    public void popularComDados(EncarregadoEducacao encarregadoEducacao, ResultSet rs) {
        try {

            Profissao profissao = new Profissao();
            
<<<<<<< HEAD
            profissao.setIdProfissao(rs.getInt("id_profissao"));
            profissao.setNomeProfissao(rs.getString("nome_profissao"));
            encarregadoEducacao.setId_profissao_encarregado(profissao);
            
            encarregadoEducacao.setId_encarregado_educacao(rs.getInt("id_encarregado"));
            encarregadoEducacao.setNome_encarregado(rs.getString("nome_encarregado"));
            encarregadoEducacao.setSobrenome_encarregado(rs.getString("sobrenome_encarregado"));
            encarregadoEducacao.setSexo_encarregado(Sexo.getAbreviatura(rs.getString("sexo_encarregado")));
            encarregadoEducacao.setCasa_encarregado(rs.getString("casa_encarregado"));
            encarregadoEducacao.setRua_encarregado(rs.getString("rua_encarregado"));
            encarregadoEducacao.setBairro_encarregado(rs.getString("bairro_encarregado"));
            encarregadoEducacao.setDistrito_urbano_encarregado(rs.getString("distrito_urbano_encarregado"));
            encarregadoEducacao.setTelemovel_principal_encarregado(rs.getString("telemovel_principal_encarregado"));
            encarregadoEducacao.setTelemovel_alternativo_encarregado(rs.getString("telemovel_alternativo_encarregado"));
            encarregadoEducacao.setEmail_principal_encarregado(rs.getString("email_principal_encarregado"));
            encarregadoEducacao.setEmail_alternativo_encarregado(rs.getString("email_alternativo_encarregado"));
            encarregadoEducacao.setFoto_encarregado(rs.getBytes("foto_encarregado"));
            encarregadoEducacao.setUrl_foto_encarregado(rs.getString("url_foto_encarregado"));
            
            Municipio municipio = new Municipio();
            
            municipio.setIdMunicipio(rs.getInt("id_municipio"));
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
=======
                     profissao.setNomeProfissao(rs.getString("nome_profissao"));
            encarregadoEducacao.setProfissao(profissao);
            
            encarregadoEducacao.setIdEncarregadoEducacao(rs.getInt("id_encarregado"));
            encarregadoEducacao.setNomeEncarregado(rs.getString("nome_encarregado"));
            encarregadoEducacao.setSobrenomeEncarregado(rs.getString("sobrenome_encarregado"));
            encarregadoEducacao.setSexo(Sexo.getAbreviatura(rs.getString("sexo_encarregado")));
            encarregadoEducacao.setCasaEncarregado(rs.getString("casa_encarregado"));
            encarregadoEducacao.setRuaEncarregado(rs.getString("rua_encarregado"));
            encarregadoEducacao.setBairroEncarregado(rs.getString("bairro_encarregado"));
            encarregadoEducacao.setDistritoUrbanoEncarregado(rs.getString("distrito_urbano_encarregado"));
            encarregadoEducacao.setTelemovelPrincipalEncarregado(rs.getString("telemovel_principal_encarregado"));
            encarregadoEducacao.setTelemovelAlternativoEncarregado(rs.getString("telemovel_alternativo_encarregado"));
            encarregadoEducacao.setEmailPrincipalEncarregado(rs.getString("email_principal_encarregado"));
            encarregadoEducacao.setEmailAlternativoEncarregado(rs.getString("email_alternativo_encarregado"));
            encarregadoEducacao.setFotoEncarregado(rs.getBytes("foto_encarregado"));
            encarregadoEducacao.setUrlFotoEncarregado(rs.getString("url_foto_encarregado"));
            
            Municipio municipio = new Municipio();
           municipio.setNomeMunicipio(rs.getString("nome_municipio"));
>>>>>>> b69123825d74c301d4e3c6e31184abbfab901fc2
            encarregadoEducacao.setMunicipio(municipio);
   
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
