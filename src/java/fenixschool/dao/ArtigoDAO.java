/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Artigo;
import fenixschool.modelo.CategoriaArtigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fenixschool.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rei Santo Hangalo
 */
public class ArtigoDAO {
    private static final String INSERIR="INSERT INTO artigo(codigo_artigo, codigo_barra_artigo, nome_artigo, preco_artigo, id_categoria_artigo)VALUES(?,?,?,?,?)";
    private static final String UPDATE="UPDATE artigo SET codigo_artigo=?, codigo_barra_artigo=?, nome_artigo=?, id_categoria_artigo=? WHERE id_artigo=?";
    private static final String DELETE="DELETE FROM artigo WHERE id_artigo=?";
    private static final String BUSCAR_POR_CODIGO="SELECT id_artigo, codigo_artigo, codigo_barra_artigo, nome_artigo, preco_artigo, id_categoria_artigo FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE id_artigo=?";
    private static final String LISTAR_TUDO="SELECT id_artigo, codigo_artigo, codigo_barra_artigo, nome_artigo, preco_artigo, id_categoria_artigo FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo";
    
    Connection conn=Conexao.getConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public void sava(Artigo artigo){
        if (artigo!=null) {
            System.out.println("Valor passado nao pode ser nulo");           
        }
        try {
            ps=conn.prepareStatement(INSERIR);
            ps.setString(1, artigo.getCodigoArgito());
            ps.setString(2, artigo.getCodigoBarraArtigo());
            ps.setString(3, artigo.getNomeArtigo());
            ps.setDouble(4, artigo.getPrecoArtigo());
            ps.setInt(5, artigo.getCategoriaArtigo().getIdCategoriaArtigo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados"+e.getMessage());
        }finally{
        Conexao.closeConnection(conn, ps);
        }
    
    }
    public void update(Artigo artigo){
        if (artigo!=null) {
            System.out.println("O Valor passado nao pode ser nulo");
         }
        try {
            ps=conn.prepareCall(UPDATE);
            ps.setInt(1, artigo.getIdArtigo());
            ps.setString(2, artigo.getCodigoArgito());
            ps.setString(3, artigo.getCodigoBarraArtigo());
            ps.setString(4, artigo.getNomeArtigo());
            ps.setDouble(4, artigo.getPrecoArtigo());
            ps.setInt(6, artigo.getCategoriaArtigo().getIdCategoriaArtigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao actualizar dados"+e.getMessage());
        }finally{
        Conexao.closeConnection(conn, ps);
        }
    }
    public void delete(Artigo artigo){
        if (artigo!=null) {
            
            System.out.println("Valor passado nao pode ser nulo");
            
            try {
                ps=conn.prepareStatement(DELETE);
                ps.setInt(1, artigo.getIdArtigo());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao eliminar registo"+e.getLocalizedMessage());
            }finally{
                Conexao.closeConnection(conn, ps);
            }
            
        }
    }
    public Artigo findById(Integer id){
        Artigo artigo=null;
        try {
            ps=conn.prepareCall(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi Encontrado nenhum registo com ID"+id);
            }
            artigo= new Artigo();
            popularComDado(artigo, rs);
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados"+ex.getLocalizedMessage());
        }finally{
        Conexao.closeConnection(conn, ps, rs);
        }
        return artigo;
    }
    public List<Artigo> findAll(){
    List<Artigo> artigos= new ArrayList<>();
        try {
            ps=conn.prepareStatement(LISTAR_TUDO);
            rs=ps.executeQuery();
            while (rs.next()) {
            Artigo artigo= new Artigo();
            popularComDado(artigo, rs);
            artigos.add(artigo);               
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados"+ex.getLocalizedMessage());
        }finally{
        Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }
    public void popularComDado(Artigo artigo, ResultSet rs){
        try {
            artigo.setIdArtigo(rs.getInt("id_artigo"));
            artigo.setCodigoArgito(rs.getString("codigo_artigo"));
            artigo.setCodigoBarraArtigo(rs.getString("codigo_barra_artigo"));
            artigo.setNomeArtigo(rs.getString("nome_artigo"));
            artigo.setPrecoArtigo(rs.getDouble("preco_artigo"));
            CategoriaArtigo ca= new CategoriaArtigo();
            ca.setCategoriaArtigo(rs.getString("categoria_artigo"));
            artigo.setCategoriaArtigo(ca);
            } catch (SQLException ex) {
                System.out.println("Erro ao carrgar dados"+ex.getLocalizedMessage());
        }
    
    }
}
