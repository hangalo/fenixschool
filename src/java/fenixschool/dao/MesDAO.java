/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Mes;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class MesDAO implements GenericoDAO<Mes>{
    private static final String INSERIR = "INSERT into Mes (nome_mes) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE Mes set nome_mes = ? WHERE id_mes = ?";
    private static final String ELIMINAR = "DELETE FROM Mes WHERE id_mes = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM Mes WHRER id_mes = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM Mes ORDER BY nome_mes ASC;";
    
    

    @Override
    public void save(Mes mes) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (mes== null){
            System.err.println("O valor anterior nao pode ser nullo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1,mes.getNomeMes());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na insercao de dados: " +e.getMessage());
        } finally{
            Conexao.closeConnection(conn, ps);
        
        }
        }
     

    @Override
    public void update(Mes mes) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(mes == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1,mes.getNomeMes());
            ps.setInt(2,mes.getIdMes());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Mes mes){
        PreparedStatement ps = null;
        Connection conn = null;
        if (mes == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1,mes.getIdMes());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }

    @Override
    public Mes findById(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Mes mes = new Mes();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(mes, rs);
            
        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return mes;
    }

    @Override
    public List<Mes> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Mes> mes = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                Mes mes1 = new Mes();
                popularComDados(mes1, rs);
                mes.add(mes1);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
       } finally{
            Conexao.closeConnection(conn);
        }
        return mes;
        }

    @Override
    public void popularComDados(Mes mes, ResultSet rs) {
        try {
            mes.setIdMes(rs.getInt("id_mes"));
            mes.setNomeMes(rs.getString("nome_mes"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }
    
}
