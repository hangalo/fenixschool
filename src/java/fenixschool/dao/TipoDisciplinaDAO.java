/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.TipoDisciplina;
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
public class TipoDisciplinaDAO implements GenericoDAO<TipoDisciplina> {
    private static final String INSERIR = "INSERT INTO tipo_disciplina(tipo_disciplina) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE tipo_disciplina SET tipo_disciplina = ? WHERE id_tipo_disciplina = ?";
    private static final String ELIMINAR = "DELETE FROM tipo_disciplina WHERE id_tipo_disciplina = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM tipo_disciplina WHERE id_tipo_disciplina = ? ORDER BY tipo_disciplina ASC";
    private static final String LISTAR_TUDO = "SELECT * FROM tipo_disciplina ORDER BY tipo_disciplina ASC";

    PreparedStatement ps = null;
    Connection conn = null;
    ResultSet rs = null;
    @Override
    public void save(TipoDisciplina tipoDisciplina){
        
        if (tipoDisciplina== null){
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoDisciplina.getTipoDisciplina());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally{
            Conexao.closeConnection(conn, ps);
        }       
    }

    @Override
    public void update(TipoDisciplina tipoDisciplina){
        
        if(tipoDisciplina == null){
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);            
            ps.setString(1, tipoDisciplina.getTipoDisciplina());
            ps.setInt(2, tipoDisciplina.getIdTipoDisciplina());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        }
        finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(TipoDisciplina tipoDisciplina){
        
        if (tipoDisciplina == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoDisciplina.getIdTipoDisciplina());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public TipoDisciplina findById(Integer id) {
        
        TipoDisciplina tipoDisciplina = new TipoDisciplina();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tipoDisciplina, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return tipoDisciplina;}

    @Override
    public List<TipoDisciplina> findAll() {
        
        List<TipoDisciplina> tipoDisciplinas = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDisciplina tipoDisciplina = new TipoDisciplina();
                popularComDados(tipoDisciplina, rs);
                tipoDisciplinas.add(tipoDisciplina);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return tipoDisciplinas;
    }

    @Override
    public void popularComDados(TipoDisciplina tipoDisciplina, ResultSet rs) {
        try {      
            tipoDisciplina.setIdTipoDisciplina(rs.getInt("id_tipo_disciplina"));
            tipoDisciplina.setTipoDisciplina(rs.getString("tipo_disciplina"));           
            } 
        catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }}
    
}
