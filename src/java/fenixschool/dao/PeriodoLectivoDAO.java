/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.PeriodoLectivo;
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
public class PeriodoLectivoDAO implements GenericoDAO<PeriodoLectivo>{
    private static final String INSERIR = "INSERT into periodo_letivo (periodo_letivo) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE periodo_letivo set periodo_letivo = ? WHERE id_periodo_letivo = ?";
    private static final String ELIMINAR = "DELETE FROM periodo_letivo WHERE id_periodo_letivo = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM periodo_letivo WHRER id_periodo_letivo = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM periodo_letivo ORDER BY periodo_letivo ASC;";

    @Override
    public void save(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (periodoletivo== null){
            System.err.println("O valor anterior nao pode ser nullo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1,periodoletivo.getPeriodoLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na insercao de dados: " +e.getMessage());
        } finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }

    @Override
    public void update(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(periodoletivo == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1,periodoletivo.getPeriodoLectivo());
            ps.setInt(2,periodoletivo.getIdPeriodoLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        }}

    @Override
    public void delete(PeriodoLectivo periodoletivo) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (periodoletivo == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1,periodoletivo.getIdPeriodoLectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }
    

    @Override
    public PeriodoLectivo findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        PeriodoLectivo periodoletivo = new PeriodoLectivo();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(periodoletivo, rs);
            
        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return periodoletivo;
    
    }

    @Override
    public List<PeriodoLectivo> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<PeriodoLectivo> periodoletivo = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                PeriodoLectivo periodoletivo1 = new PeriodoLectivo();
                popularComDados(periodoletivo1, rs);
                periodoletivo.add(periodoletivo1);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
       } finally{
            Conexao.closeConnection(conn);
        }
        return periodoletivo;
        }
    

    @Override
    public void popularComDados(PeriodoLectivo periodoletivo, ResultSet rs){
        try {
            periodoletivo.setIdPeriodoLectivo(rs.getInt("id_periodo_letivo"));
            periodoletivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }
    
}
