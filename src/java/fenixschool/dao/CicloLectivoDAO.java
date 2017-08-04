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
    private static final String INSERIR ="insert into ciclo_letivo(ciclo_letivo) VALUES (?)";
    private static final String ATUALIZAR = "UPDATE Ciclo_Letivo set ciclo_letivo = ? WHERE id_ciclo_letivo = ?";
    private static final String ELIMINAR = " DELETE FROM Ciclo_Letivo WHERE id_ciclo_letivo = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM Ciclo_Letivo where id_ciclo_letivo = ?";
    private static final String LISTAR_TUDO ="SELECT * FROM Ciclo_Letivo ORDER BY ciclo_letivo ASC;"; 

    @Override
    public void save(CicloLectivo ciclo_lectivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (ciclo_lectivo== null){System.err.println("O valor anterior nao pode ser nullo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1,ciclo_lectivo.getCicloLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados: " + e.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }
        }

    @Override
    public void update(CicloLectivo ciclo_letivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(ciclo_letivo == null){
            System.err.println("O valor anterior nao pode ser nullo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setString(1,ciclo_letivo.getCicloLectivo());
            ps.setInt(2,ciclo_letivo.getIdCicloLectivo());
            ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Erro na atualizacao dos dados: " + ex.getLocalizedMessage());
        }
        finally {
            Conexao.closeConnection(conn, ps);}   
    }

    @Override
    public void delete(CicloLectivo ciclo_letivo){
        PreparedStatement ps = null;
        Connection conn = null;
        if (ciclo_letivo == null){
        System.err.println("O valor anterior nao pode ser nullo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1,ciclo_letivo.getIdCicloLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
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
        CicloLectivo ciclo_letivo = new CicloLectivo();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
        }
            popularComDados(ciclo_letivo, rs);
        } catch (Exception e) {
            System.err.println("Erro ao ler os dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return null;
        }

    @Override
    public List<CicloLectivo> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<CicloLectivo> ciclo = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                CicloLectivo ciclolectivo = new CicloLectivo();
                popularComDados(ciclolectivo, rs);
                ciclo.add(ciclolectivo);
                
            
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura de dados: " + e.getLocalizedMessage());            
        }finally{
            Conexao.closeConnection(conn);
        }
       return ciclo;
    }

    @Override
    public void popularComDados(CicloLectivo ciclo_letivo, ResultSet rs){
        try {
            ciclo_letivo.setIdCicloLectivo(rs.getInt("id_ciclo_letivo"));
            ciclo_letivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            
        } catch (Exception e) {
        }
        
    }
    
    
}
