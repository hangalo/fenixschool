/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;


import fenixschool.modelo.LocalEmissaoDocumento;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henriques elias
 */
public class LocalEmissaoDocumentoDAO implements GenericoDAO <LocalEmissaoDocumento> {
    private static final String INSERIR = "INSERT into local_emissao_documento (local_emissao_documento) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE local_emissao_documento set local_emissao_documento = ? WHERE id_local_emissao_documento = ?";
    private static final String ELIMINAR = "DELETE FROM local_emissao_documento WHERE id_local_emissao_documento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM local_emissao_documento WHERE id_local_emissao_documento = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM local_emissao_documento ORDER BY local_emissao_documento ASC;";

   @Override
    public void save(LocalEmissaoDocumento local) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (local== null){
            System.err.println("O valor anterior nao pode ser nullo!");}
        try {
            conn=Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, local.getLocalEmissaoDocumento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na insersao de dados: " +e.getMessage());
        } finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }

    @Override
    public void update(LocalEmissaoDocumento local) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(local == null){
            System.err.println("O valor anterior nao pode ser nulo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1,local.getLocalEmissaoDocumento());
            ps.setInt(2,local.getIdLocalEmissaoDocumento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        }}

    @Override
    public void delete(LocalEmissaoDocumento local) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (local == null){
            System.err.println("O valor anterior nao pode ser nulo");
        
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1,local.getIdLocalEmissaoDocumento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
        }
        finally{
            Conexao.closeConnection(conn, ps);
        
        }
    }
    

    @Override
    public LocalEmissaoDocumento findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        LocalEmissaoDocumento local = new LocalEmissaoDocumento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(local, rs);
            
        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return local;
    
    }

    @Override
    public List<LocalEmissaoDocumento> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<LocalEmissaoDocumento> locais = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                LocalEmissaoDocumento local = new LocalEmissaoDocumento();
                popularComDados(local, rs);
                locais.add(local);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
       } finally{
            Conexao.closeConnection(conn);
        }
        return locais;
        }
    

    @Override
    public void popularComDados(LocalEmissaoDocumento local, ResultSet rs){
        try {
            local.setIdLocalEmissaoDocumento(rs.getInt("id_local_emissao_documento"));
            local.setLocalEmissaoDocumento(rs.getString("local_emissao_documento"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }
    

}
