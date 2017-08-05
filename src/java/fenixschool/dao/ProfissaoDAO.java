/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Profissao;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HACKER
 */
public class ProfissaoDAO implements GenericoDAO<Profissao> {

    private static final String INSERIR = "INSERT INTO profissao(nome_profissao)VALUES(?)";
    private static final String ATUALIZAR = "UPDATE profissao SET nome_profissao=? WHERE id_profissao=?";
    private static final String ELIMINAR = "DELETE FROM profissao WHERE id_profissao=?";
    private static final String LISTAR_POR_CODIGO = "SELECT nome_profissao,id_profissao FROM profissao WHERE id_profissao=?";
    private static final String LISTAR_TUDO = "SELECT nome_profissao,id_profissao FROM profissao";
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Profissao profissao){
        if (profissao==null) {
            System.out.println("o parametro passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, profissao.getNomeProfissao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erro ao guardar dados: "+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Profissao profissao){
         if (profissao==null) {
            System.out.println("o parametro passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setString(1, profissao.getNomeProfissao());
            ps.setInt(2, profissao.getIdProfissao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados: "+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Profissao profissao){
         if (profissao==null) {
            System.out.println("o parametro passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, profissao.getIdProfissao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erro ao eliminar dados: "+ex.getMessage());
                }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Profissao findById(Integer id){
         Profissao profissao = new Profissao();
            
        try {
           
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);
                
            }
            popularComDados(profissao, rs);
          
        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: "+ex.getMessage());
         }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
          return profissao;

    }

    @Override
    public List<Profissao> findAll()  {
         List<Profissao> itens = new ArrayList<>();
            
        try {
           conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissao profissao = new Profissao();
                popularComDados(profissao, rs);
                itens.add(profissao);
                
            }
           
        }  catch (SQLException ex) {
            System.out.println("erro ao carregar dados: "+ex.getMessage());
         }finally{
            Conexao.closeConnection(conn);
        }
 return itens;
    }

    @Override
    public void popularComDados(Profissao profissao, ResultSet rs)  {
        try {
            profissao.setIdProfissao(rs.getInt("id_profissao"));
            profissao.setNomeProfissao(rs.getString("nome_profissao"));
        } catch (SQLException ex) {
            System.out.println("erro ao ler dados: "+ex.getMessage());
                }

    }

}
