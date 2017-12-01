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
public class ArtigoDAO implements GenericoDAOLogico<Artigo> {

    private static final String INSERIR = "INSERT INTO artigo(codigo_artigo, codigo_barras_artigo, nome_artigo, preco_artigo, id_categoria_artigo)VALUES(?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE artigo SET codigo_artigo=?, codigo_barras_artigo=?, nome_artigo=?, preco_artigo=?, id_categoria_artigo=? WHERE id_artigo=?";
    private static final String ELIMINAR = "DELETE FROM artigo WHERE id_artigo=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE id_artigo=? ORDER BY nome_artigo";
    private static final String LISTAR_TUDO = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo ORDER BY nome_artigo";
    
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE codigo_artigo=? ORDER BY nome_artigo";
    private static final String LISTAR_POR_CODIGO_BARRAS = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE codigo_barras_artigo=? ORDER BY nome_artigo";
    private static final String LISTAR_POR_NOME = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE nome_artigo=? ORDER BY nome_artigo";
    private static final String LISTAR_POR_PRECO = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE preco_artigo=? ORDER BY nome_artigo";
    private static final String LISTAR_POR_CATEGORIA = "SELECT * FROM artigo ar INNER JOIN categoria_artigo ca ON ar.id_categoria_artigo=ca.id_categoria_artigo WHERE ar.id_categoria_artigo=? ORDER BY nome_artigo";
    
    
    
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /* @Override
    public void save(Artigo artigo){
        if (artigo!=null) {
            System.out.println("Valor passado nao pode ser nulo");           
        }
        try {
            conn=Conexao.getConnection();
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
    @Override
    public void update(Artigo artigo){
        if (artigo!=null) {
            System.out.println("O Valor passado nao pode ser nulo");
         }
        try {
            conn=Conexao.getConnection();
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
    @Override
    public void delete(Artigo artigo){
        if (artigo!=null) {
            
            System.out.println("Valor passado nao pode ser nulo");
            
            try {
                conn=Conexao.getConnection();
                ps=conn.prepareStatement(DELETE);
                ps.setInt(1, artigo.getIdArtigo());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao eliminar registo"+e.getLocalizedMessage());
            }finally{
                Conexao.closeConnection(conn, ps);
            }
            
        }
    }*/
    @Override
    public boolean save(Artigo artigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (artigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, artigo.getCodigoArgito());
            ps.setString(2, artigo.getCodigoBarraArtigo());
            ps.setString(3, artigo.getNomeArtigo());
            ps.setDouble(4, artigo.getPrecoArtigo());
            ps.setInt(5, artigo.getCategoriaArtigo().getIdCategoriaArtigo());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Artigo artigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (artigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, artigo.getCodigoArgito());
            ps.setString(2, artigo.getCodigoBarraArtigo());
            ps.setString(3, artigo.getNomeArtigo());
            ps.setDouble(4, artigo.getPrecoArtigo());
            ps.setInt(5, artigo.getCategoriaArtigo().getIdCategoriaArtigo());
            ps.setInt(6, artigo.getIdArtigo());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Artigo artigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (artigo == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, artigo.getIdArtigo());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Artigo findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artigo artigo = new Artigo();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareCall(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Nao foi Encontrado nenhum registo com id" + id);
            }
            popularComDados(artigo, rs);
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigo;
    }

    @Override
    public List<Artigo> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }

    @Override
    public void popularComDados(Artigo artigo, ResultSet rs) {
        try {
            artigo.setIdArtigo(rs.getInt("id_artigo"));
            artigo.setCodigoArgito(rs.getString("codigo_artigo"));
            artigo.setCodigoBarraArtigo(rs.getString("codigo_barras_artigo"));
            artigo.setNomeArtigo(rs.getString("nome_artigo"));
            artigo.setPrecoArtigo((Double)rs.getDouble("preco_artigo"));
            
            CategoriaArtigo categoriaArtigo = new CategoriaArtigo();
            categoriaArtigo.setIdCategoriaArtigo(rs.getInt("id_categoria_artigo"));
            categoriaArtigo.setCategoriaArtigo(rs.getString("categoria_artigo"));
            artigo.setCategoriaArtigo(categoriaArtigo);
        
        } catch (SQLException ex) {
            System.out.println("Erro ao carrgar dados" + ex.getLocalizedMessage());
        }

    }
    
    // Consultas parametrisadas
    
    public List<Artigo> buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }

    public List<Artigo> buscarPorCodigoBarras(String codigoBarra) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO_BARRAS);
            ps.setString(1, codigoBarra);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }
    
    public List<Artigo> buscarNome(String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }
    
    public List<Artigo> buscarPreco(double preco) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_PRECO);
            ps.setDouble(1, preco);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }
    
    public List<Artigo> buscarNomeCategoria(String nomeCategoria) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> artigos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CATEGORIA);
            ps.setString(1, nomeCategoria);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Artigo artigo = new Artigo();
                popularComDados(artigo, rs);
                artigos.add(artigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados" + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return artigos;
    }

}
