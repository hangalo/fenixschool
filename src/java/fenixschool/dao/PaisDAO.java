/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Pais;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HACKER
 */
public class PaisDAO implements GenericoDAO<Pais> {

    private static final String INSERIR = "INSERT INTO pais(codigoISOAlpha2Pais, codigoISOAlph3Pais, nomePais)VALUES(?, ?)";
    private static final String ACTUALIZAR = "UPDATE pais SET codigoISOAlpha2Pais=?, codigoISOAlph3Pais=?, nomePais=?";
    private static final String ELIMINAR = "DELETE FROM pais WHERE codigoISOAlpha2Pais=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM pais WHERE codigoISOAlpha2Pais=?";
    private static final String LISTAR_TUDO = "SELECT * FROM pais";

     Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Pais pais){
       
            if (pais == null) {
                System.out.println("O campo passado nao pode ser nulo");
                
            }
             try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, pais.getCodigoISOAlpha2Pais());
            ps.setString(2, pais.getCodigoISOAlph3Pais());
            ps.setString(3, pais.getNomePais());
            ps.executeUpdate();
        } catch (SQLException ex) {
                 System.out.println("erro na insercao de dados: "+ex.getMessage());
        }
             finally{
                 Conexao.closeConnection(conn, ps);
             }

    }

    @Override
    public void update(Pais pais) {
        
            if (pais == null) {
                System.out.println("O campo passado nao pode ser nulo");
                
            }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, pais.getCodigoISOAlpha2Pais());
            ps.setString(2, pais.getCodigoISOAlph3Pais());
            ps.setString(3, pais.getNomePais());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados: "+ex.getMessage());
                 }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Pais pais){
        
            if (pais == null) {
                System.out.println("O campo passado nao pode ser nulo");
                
            }
        
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setString(1, pais.getCodigoISOAlpha2Pais());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar dados: "+ex.getMessage());
                 }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Pais findById(Integer id) {
        Pais pais = new Pais();
        try {
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");
                
            }
            popularComDados(pais, rs);
            
            
        }  catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: "+ex.getMessage());
                 }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return pais;
    }

    @Override
    public List<Pais> findAll() {
         ArrayList<Pais> itens = new ArrayList<Pais>();
            
        try {
           
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Pais pais = new Pais();
                popularComDados(pais, rs);
                itens.add(pais);
                
            }
            
          
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: "+ex.getMessage());
                 }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
          return itens;
    }
    
    @Override
    public void popularComDados(Pais pais, ResultSet rs) {
        try {
            pais.setCodigoISOAlpha2Pais(rs.getString(1));
            pais.setCodigoISOAlph3Pais(rs.getString(2));
            pais.setNomePais(rs.getString(3));
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: "+ex.getMessage());
                 }

    }

}
