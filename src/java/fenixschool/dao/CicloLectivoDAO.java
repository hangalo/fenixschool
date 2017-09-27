/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CicloLectivo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CicloLectivoDAO implements GenericoDAO<CicloLectivo>{
    private static final String INSERIR ="INSERT INTO ciclo_letivo(ciclo_letivo) VALUES (?)";
    private static final String ACTUALIZAR ="UPDATE ciclo_letivo SET ciclo_letivo =? WHERE id_ciclo_letivo=?";
    private static final String ELIMINAR = "DELETE FROM ciclo_letivo WHERE id_ciclo_letivo=?";
    private static final String BUSCAR_POR_CODIGO ="SELECT * FROM ciclo_letivo WHERE id_ciclo_letivo=?";
    private static final String LISTAR_TUDO ="SELECT  *FROM ciclo_letivo ORDER BY ciclo_letivo ASC"; 

    @Override
    public void save(CicloLectivo cicloLectivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (cicloLectivo== null){System.err.println("O valor anterior nao pode ser nulo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1,cicloLectivo.getCicloLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados: " + e.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }
        }

    @Override
    public void update(CicloLectivo cicloLectivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(cicloLectivo == null){
            System.err.println("O valor anterior nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
             ps.setInt(1,cicloLectivo.getIdCicloLectivo());
            ps.setString(2,cicloLectivo.getCicloLectivo());
           
            ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Erro na actualização dos dados: " + ex.getLocalizedMessage());
        }
        finally {
            Conexao.closeConnection(conn, ps);}   
    }

    @Override
    public void delete(CicloLectivo cicloLectivo){
        PreparedStatement ps = null;
        Connection conn = null;
        if (cicloLectivo == null){
        System.err.println("O valor anterior nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1,cicloLectivo.getIdCicloLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminação de dados:" + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        
        }
        
    }

    @Override
    public CicloLectivo findById(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        CicloLectivo cicloLectivo = new CicloLectivo();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
        }
            popularComDados(cicloLectivo, rs);
        } catch (Exception e) {
            System.err.println("Erro ao ler os dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return cicloLectivo;
        }

    @Override
    public List<CicloLectivo> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<CicloLectivo> cicloLectivos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                CicloLectivo cicloLectivo = new CicloLectivo();
                popularComDados(cicloLectivo, rs);
                cicloLectivos.add(cicloLectivo);
                
            
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura de dados: " + e.getLocalizedMessage());            
        }finally{
            Conexao.closeConnection(conn);
        }
       return cicloLectivos;
    }

    @Override
    public void popularComDados(CicloLectivo cicloLectivo, ResultSet rs){
        try {
            cicloLectivo.setIdCicloLectivo(rs.getInt("id_ciclo_letivo"));
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados do ciclo lectivo: " + ex.getLocalizedMessage());
        }
        
    }
    
    
}
