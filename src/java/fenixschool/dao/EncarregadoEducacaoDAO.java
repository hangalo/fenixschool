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
    private static final String BUSCAR_POR_NOME = "";
    private static final String BSUCAR_POR_NOME_SOBRENOME="";
    private static final String BUSCAR_POR_MUNICIPIO="";
    private static final String BUSCAR_POR_SEXO="";

    @Override
    public void save(EncarregadoEducacao encarregadoEducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoEducacao == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

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
                System.err.println("NÃ£o foi encontrado nenhum registo com o id: " + id);
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
            encarregadoEducacao.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
