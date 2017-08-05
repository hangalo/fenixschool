package fenixschool.dao;

import fenixschool.modelo.EncarregadoEducacao;
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
    private static final String INSERIR = "INSERT INTO encarregado_educacao (nome_encarregado, sobrenome_encarregado, id_profissao, id_sexo)VALUES(?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE encarregado_educacao SET nome_encarregado = ?, sobrenome_encarregado = ?, id_profissao = ?, id_sexo = ? WHERE id_encarregado_educacao = ?";
    private static final String ELIMINAR = "DELETE FROM encarregado_educacao WHERE id_encarregado_educacao = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM encarregado_educacao WHERE id_municipio = ?";
    private static final String LISTAR_TUDO = "SELECT id_encarregado_educacao i, nome_encarregado i, sobrenome_encarregado i, id_profissao i, id_sexo i FROM encarregado_educacao i INNER JOIN profissao p on i.id_profissao = p.id_profissao INNER JOIN sexo s on i.id_sexo = s.id_sexo;";

    @Override
    public void save(EncarregadoEducacao encarregadoeducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoeducacao == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            
            ps.setString(1, encarregadoeducacao.getNome_encarregado());
            ps.setString(2, encarregadoeducacao.getSobrenome_encarregado());
            ps.setInt(3, encarregadoeducacao.getId_profissao().getIdProfissao());
            ps.setString(4, encarregadoeducacao.getId_sexo().getAbreviatura());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
     
        
    }

    @Override
    public void update(EncarregadoEducacao encarregadoeducacao) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (encarregadoeducacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);            
             ps.setString(1, encarregadoeducacao.getNome_encarregado());
            ps.setString(2, encarregadoeducacao.getSobrenome_encarregado());
            ps.setInt(3, encarregadoeducacao.getId_profissao().getIdProfissao());
            ps.setString(4, encarregadoeducacao.getId_sexo().getAbreviatura());
            ps.setInt(5, encarregadoeducacao.getId_encarregado_educacao());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }}

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
            ps.setInt(1, encarregadoeducacao.getId_encarregado_educacao());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }}

    @Override
    public EncarregadoEducacao findById(Integer id){
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
    public List<EncarregadoEducacao> findAll(){
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
    public void popularComDados(EncarregadoEducacao encarregadoEducacao, ResultSet rs){
        try {
            
            Profissao profissao = new Profissao();       
            profissao.setIdProfissao(rs.getInt("Id_Profissao"));
            
            
           
            encarregadoEducacao.setId_encarregado_educacao(rs.getInt("Id_Encarregado_Educacao"));
            encarregadoEducacao.setNome_encarregado(rs.getString("Nome_ecarregado"));
            encarregadoEducacao.setSobrenome_encarregado(rs.getString("Sobrenome_ecarregado"));
            encarregadoEducacao.setId_profissao(profissao);
            encarregadoEducacao.setId_sexo(Sexo.getAbreviatura(rs.getString("id_sexo")));
            
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }}
    
}
