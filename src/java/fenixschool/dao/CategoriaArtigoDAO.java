/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CategoriaArtigo;
import java.sql.Connection;
import fenixschool.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rei Santo Hangalo
 */
public class CategoriaArtigoDAO implements GenericoDAO<CategoriaArtigo>{
    private static final String INSERIR="INSERT INTO categoria_artigo (categoria_artigo)VALUES(?)";
    private static final String ACTUALIZAR="UPDATE categoria_artigo SET categoria_artigo=? WHERE id_categoria_artigo=?";
    private static final String ELIMINAR="DELETE FROM categoria_artigo WHERE id_categoria_artigo=?";
    private static final String BUSCAR_POR_CODIGO="SELECT *FROM categoria_artigo WHERE id_categori_artigo=?";
    private static final String LISTAR_TUDO="SELECT *FROM categoria-artigo";
    
    Connection conn;
    PreparedStatement ps=null;
    ResultSet rs= null;
    
    @Override
    public void save(CategoriaArtigo categoriaArtigo){
        if (categoriaArtigo!=null) {
            System.out.println("Valor passdo nao ser nulo");
            
            try {
                conn=Conexao.getConnection();
                ps=conn.prepareStatement(INSERIR);
                ps.setString(1, categoriaArtigo.getCategoriaArtigo());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erro ao Inserir dados"+e.getMessage());
            }finally{
            Conexao.closeConnection(conn, ps);
            }
            
        }
    }
    @Override
    public void update(CategoriaArtigo categoriaArtigo){
        if (categoriaArtigo!=null) {
            System.out.println("Valor nao pode ser nulo");
            try {
                conn=Conexao.getConnection();
                ps=conn.prepareStatement(ACTUALIZAR);
                ps.setInt(1, categoriaArtigo.getIdCategoriaArtigo());
                ps.setString(2, categoriaArtigo.getCategoriaArtigo());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao actualizar"+e.getMessage());
            }finally{
            Conexao.closeConnection(conn, ps);
            }
            
        }
    }
    @Override
    public void delete(CategoriaArtigo categoriaArtigo){
        if (categoriaArtigo!=null) {
            System.out.println("valor nao pode ser nulo");            
        }
        try {
            conn=Conexao.getConnection();
            ps=conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoriaArtigo.getIdCategoriaArtigo());
        } catch (SQLException e) {
            System.out.println("Erro ao eliminar"+e.getLocalizedMessage());
        }
    
    }
    @Override
    public CategoriaArtigo findById(Integer id){
    CategoriaArtigo categoriaArtigo=null;
        try {
            conn=Conexao.getConnection();
            ps=conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(!rs.next()){
                System.out.println("nao foi possivel encontrar nenhum registo com ID"+id);
            }
            categoriaArtigo= new CategoriaArtigo();
            popularComDados(categoriaArtigo, rs);
                      
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados"+ex.getLocalizedMessage());
          }finally{
        Conexao.closeConnection(conn, ps, rs);
        }
        return categoriaArtigo;
    }
    @Override
    public List<CategoriaArtigo> findAll(){
        List<CategoriaArtigo> categoriaArtigos= new ArrayList<>();
        try {
            conn=Conexao.getConnection();
            ps=conn.prepareStatement(LISTAR_TUDO);
            rs=ps.executeQuery();
            while (rs.next()) {
            CategoriaArtigo categoriaArtigo= new CategoriaArtigo();
            popularComDados(categoriaArtigo, rs);
            categoriaArtigos.add(categoriaArtigo);
               
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar"+ex.getLocalizedMessage());
        }
    return categoriaArtigos;
    }
    @Override
    public void popularComDados(CategoriaArtigo categoriaArtigo, ResultSet rs){
        
        try {
            categoriaArtigo.setIdCategoriaArtigo(rs.getInt("id_categoria_artigo"));
            categoriaArtigo.setCategoriaArtigo(rs.getString("categoria_artigo"));
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados"+ex.getLocalizedMessage());
        }
    
    }
}
