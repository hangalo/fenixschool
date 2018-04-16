/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.VendaDetalhe;
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
public class VendaDetalhesDAO implements GenericoDAOLogico<VendaDetalhe> {

    private static final String INSERT = "INSERT INTO venda_detalhes(id_venda, id_artigo, quantidade_detalhes_venda, desconto_detalhes_venda, preco_detalhes_venda) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "";
    private static final String SELECT_BY_ID = "";

    @Override
    public boolean save(VendaDetalhe detalhe) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (detalhe == null) {
            System.err.println("ItemDAO:save: O valor oassado nao pode ser nulo!");
        }
        try {

          
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
              ps.setInt(1, detalhe.getVenda().getIdVenda());
            ps.setInt(2, detalhe.getArtigo().getIdArtigo());
            ps.setInt(3, detalhe.getQuantidadeVendaDetalhe());
            ps.setDouble(4, detalhe.getDescontoIVAVendaDetalhe());
            ps.setDouble(5, detalhe.getPrecoVendaDetalhe());
          
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("ItemDAO:save:Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException e) {
            System.out.println("ItemDAO:save:Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(VendaDetalhe detalhe) {
        //implementar
        return false;
    }

    @Override
    public boolean delete(VendaDetalhe detalhe) {
        //implementar
        return false;
    }

    @Override
    public VendaDetalhe findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        VendaDetalhe detalhe = new VendaDetalhe();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("ItemDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(detalhe, rs);
        } catch (SQLException ex) {
            System.err.println("ItemDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return detalhe;
    }

    @Override
    public List<VendaDetalhe> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<VendaDetalhe> detalhes = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                VendaDetalhe detalhe = new VendaDetalhe();
                popularComDados(detalhe, rs);
                detalhes.add(detalhe);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return detalhes;
    }

    @Override
    public void popularComDados(VendaDetalhe detalhe, ResultSet rs) {
        try {

           detalhe.setIdVendaDetalhe(rs.getInt(""));

        } catch (SQLException ex) {
            System.err.println("Error on fill data Item: " + ex.getLocalizedMessage());
        }

    }
}
