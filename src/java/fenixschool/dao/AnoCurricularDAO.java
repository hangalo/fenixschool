/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.AnoCurricular;
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
public class AnoCurricularDAO implements GenericoDAO<AnoCurricular>{
      
    private static final String INSERIR = "INSERT INTO ano_curricular(ano_curricular)VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE ano_curricular SET ano_curricular=? WHERE id_ano_curricular=?";
    private static final String ELIMINAR = "DELETE FROM ano_curricular WHERE id_ano_curricular=?";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM ano_curricular WHERE id_ano_curricular=?";
    private static final String LISTAR_TUDO ="SELECT * FROM ano_curricular ORDER BY ano_curricular ASC";
      Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(AnoCurricular anoCurricular) {
        if (anoCurricular==null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, anoCurricular.getAnoCurricular());
            ps.executeUpdate();
        } catch (SQLException ex) {
                System.out.println("Erro ao guardar registro: "+ex.getMessage());
       }finally{
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(AnoCurricular anoCurricular) {
         if (anoCurricular==null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, anoCurricular.getAnoCurricular());
            ps.setInt(2, anoCurricular.getIdAnoCurricular());
            ps.executeUpdate();
        } catch (SQLException ex) {
                System.out.println("Erro ao atualizar registro: "+ex.getMessage());
       }finally{
            Conexao.closeConnection(conn, ps);
        }
    
    }

    @Override
    public void delete(AnoCurricular anoCurricular){
        if (anoCurricular == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, anoCurricular.getIdAnoCurricular());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public AnoCurricular findById(Integer id) {
         
        AnoCurricular anoCurricular = new AnoCurricular();
           
        try {
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);
                
            }
            popularComDados(anoCurricular, rs);
            
        } catch (SQLException ex) {
               System.out.println("Erro ao carregar dados: "+ex.getMessage());
       }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return anoCurricular;
    
    }

    @Override
    public List<AnoCurricular> findAll() {
         List<AnoCurricular> itens = new ArrayList<AnoCurricular>();
           
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                AnoCurricular anoCurricular = new AnoCurricular();
                popularComDados(anoCurricular, rs);
                itens.add(anoCurricular);
                
            }
           
        } catch (SQLException ex) {
             System.out.println("Erro ao carregar dados: "+ex.getMessage());
       }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
 return itens;
    
    }

    @Override
    public void popularComDados(AnoCurricular anoCurricular, ResultSet rs){
        try {
            anoCurricular.setIdAnoCurricular(rs.getInt(1));
            anoCurricular.setAnoCurricular(rs.getString(2));
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: "+ex.getMessage());
        }
        
   
    }

    
}
