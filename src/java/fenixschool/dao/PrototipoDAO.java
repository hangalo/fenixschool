/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Municipio;
import fenixschool.modelo.Provincia;
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
public class PrototipoDAO implements GenericoDAO<Municipio> {

    private static final String INSERIR = " INTO XXXX (campo2, campo2 .....)VALUES(?, ?....)";
    private static final String ACTUALIZAR = "UPDATE XXXXX SET campo1 = ?, campo2 = ? WHERE campo_id = ?";
    private static final String ELIMINAR = "DELETE FROM XXXX WHERE campo_id = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT campo1, campo2 FROM XXXX WHERE campo_id = ?";
    private static final String LISTAR_TUDO = "SELECT campo1, campo2 FROM XXXX tabela1 tb1 INNER JOIN tabela2 tb2 on tb1.campo_id = tb2.campo_id ORDER BY campoX ASC;";

    /*
    
    private static final String INSERIR = " ";
    private static final String ACTUALIZAR = "";
    private static final String ELIMINAR = "";
    private static final String BUSCAR_POR_CODIGO = "";
    private static final String LISTAR_TUDO = "";
    
    
    
    
     */

    @Override
    public void save(Municipio municipio) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (municipio == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        {
        }
    }

    @Override
    public void update(Municipio municipio) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.setInt(3, municipio.getIdMunicipio());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Municipio municipio) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }

    public Municipio findById(int id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Municipio municipio = new Municipio();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return municipio;
    }

    @Override
    public List<Municipio> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return municipios;
    }

    @Override
    public void popularComDados(Municipio municipio, ResultSet rs) {

        try {
            Provincia p = new Provincia();

            municipio.setIdMunicipio(rs.getInt("Id_Municipio"));
            municipio.setNomeMunicipio(rs.getString("Nome_Municipio"));
            //  p.setIdProvincia(rs.getInt("id_Provincia"));
            p.setNomeProvincia(rs.getString("nome_provincia"));
            municipio.setProvinciaMunicipio(p);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }

    }

    @Override
    public Municipio findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Municipio municipio = new Municipio();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return municipio;
    }
}
