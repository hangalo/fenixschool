/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Venda;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class VendaDAO implements GenericoDAOLogico<Venda>{
      private static final String INSERT = "INSERT INTO venda(data_venda, id_funcionario, id_cliente, total_venda) VALUES (?, ?, ?, ? )";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL ="SELECT id_venda, data_venda, f.nome_funcionario, f.sobrenome_funcionario, c.nome_cliente, c.sobrenome_cliente,total_venda FROM venda v inner JOIN cliente c ON (v.id_cliente = c.id_cliente) INNER JOIN funcionario f ON(v.id_funcionario = f.id_funcionario)";
    private static final String SELECT_BY_ID ="";
    
    private static final String SELECT_MAX_ID_FACTURA="SELECT MAX(id_venda) FROM venda";
    
  
    
    
    
     @Override
    public boolean save(Venda venda) {
       PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (venda == null) {
            System.err.println("VendaDAO:save: O valor oassado nao pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            
            /*
            data_venda, id_funcionario, id_cliente, total_venda
            */
            ps.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
            ps.setInt(2, venda.getFuncionario().getIdFuncionario());
            ps.setInt(3, venda.getCliente().getIdCliente());
            ps.setDouble(4, venda.getTotalVenda());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("VendaDAO:save:Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException e) {
            System.out.println("VendaDAO:save:Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Venda venda) {
        //implementar
        return false;
    }

    @Override
    public boolean delete(Venda venda) {
        //implementar
       return false;
    }

    @Override
    public Venda findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
       Venda venda = new Venda();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("CategoriaDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(venda, rs);
        } catch (SQLException ex) {
            System.err.println("CategoriaDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return venda;
    }

   
   

   
   

    @Override
    public List<Venda> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
               Venda venda= new Venda();
                popularComDados(venda, rs);
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return vendas;
    }

   
     public Integer buscaUltimaFactura() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
       Venda venda = new Venda();
        Integer ultimo=null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_MAX_ID_FACTURA);
             rs = ps.executeQuery();
            if (rs.next()) {
               
                ultimo = rs.getInt(1);
            }
            
            

        } catch (SQLException ex) {
            System.out.println("FacturaDAO: buscaUltimaFactura -> Erro ao carregar dados" + ex.getMessage());
        } finally {
           Conexao.closeConnection(conn);
        }
        return ultimo;

    }
   

    @Override
    public void popularComDados(Venda venda, ResultSet rs) {
        try {            
           
           venda.setIdVenda(rs.getInt("id_categoria"));
          

        } catch (SQLException ex) {
            System.err.println("Error on fill data Factura: " + ex.getLocalizedMessage());
        }

    }
}
