/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.TipoDocumentoIdentidade;
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
public class TipoDocumentoIdentidadeDAO implements GenericoDAO<TipoDocumentoIdentidade> {
    private static final String INSERIR = "INSERT into tipo_documento_identidade (tipo_documento_identidade) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE tipo_documento_identidade set tipo_documento_identidade = ? WHERE id_tipo_documento_identidade = ?";
    private static final String ELIMINAR = "DELETE FROM tipo_documento_identidade WHERE id_tipo_documento_identidade = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * From tipo_documento_identidade WHERE id_tipo_documento_identidade = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM tipo_documento_identidade ORDER BY tipo_documento_identidade ASC;";

    @Override
    public void save(TipoDocumentoIdentidade t){
        
        PreparedStatement ps = null;
        Connection conn = null;
        if (t== null){
            System.err.println("O valor anterior nao pode ser nullo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, t.getTipoDOcumentoIdentidade());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na insercao de dados: " +e.getMessage());
        } finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }

    @Override
    public void update(TipoDocumentoIdentidade t) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        if(t == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1,t.getTipoDOcumentoIdentidade());
            ps.setInt(2,t.getIdTipoDocumentoIdentidade());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(TipoDocumentoIdentidade t){
        
        PreparedStatement ps = null;
        Connection conn = null;
        if (t == null){
            System.err.println("O valor anterior nao pode ser nullo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, t.getIdTipoDocumentoIdentidade());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        
        }}

    @Override
    public TipoDocumentoIdentidade findById(Integer id){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        TipoDocumentoIdentidade tdi = new TipoDocumentoIdentidade();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tdi, rs);
            
        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return tdi;
    }

    @Override
    public List<TipoDocumentoIdentidade> findAll(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<TipoDocumentoIdentidade> tdi = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                TipoDocumentoIdentidade tdi1 = new TipoDocumentoIdentidade();
                popularComDados(tdi1, rs);
                tdi.add(tdi1);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
       } finally{
            Conexao.closeConnection(conn);
        }
        return tdi;
    }

    @Override
    public void popularComDados(TipoDocumentoIdentidade t, ResultSet rs){
        
        try {
            t.setIdTipoDocumentoIdentidade(rs.getInt("id_tipo_documento_identidade"));
            t.setTipoDOcumentoIdentidade(rs.getString("tipo_documento_identidade"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }
    
}
