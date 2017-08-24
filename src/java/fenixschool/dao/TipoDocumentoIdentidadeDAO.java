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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class TipoDocumentoIdentidadeDAO implements GenericoDAO<TipoDocumentoIdentidade> {

    private static final String INSERIR = "INSERT INTO tipo_documento_identidade (tipo_documento_identidade) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE tipo_documento_identidade SET tipo_documento_identidade = ? WHERE id_tipo_documento_identidade = ?";
    private static final String ELIMINAR = "DELETE FROM tipo_documento_identidade WHERE id_tipo_documento_identidade = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM tipo_documento_identidade WHERE id_tipo_documento_identidade = ? ORDER BY tipo_documento_identidade ASC";
    private static final String LISTAR_TUDO = "SELECT * FROM tipo_documento_identidade ORDER BY tipo_documento_identidade ASC";

    PreparedStatement ps = null;
    Connection conn = null;
    ResultSet rs = null;

    @Override
    public void save(TipoDocumentoIdentidade tipoDocumentoIdentidade) {

        if (tipoDocumentoIdentidade == null) {
            System.err.println("O valor anterior nao pode ser nullo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoDocumentoIdentidade.getTipoDOcumentoIdentidade());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na insercao de dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public void update(TipoDocumentoIdentidade tipoDocumentoIdentidade) {

       
        if (tipoDocumentoIdentidade == null) {
            System.err.println("O valor anterior nao pode ser nullo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, tipoDocumentoIdentidade.getTipoDOcumentoIdentidade());
            ps.setInt(2, tipoDocumentoIdentidade.getIdTipoDocumentoIdentidade());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na actualizacao de dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(TipoDocumentoIdentidade tipoDocumentoIdentidade) { 
        if (tipoDocumentoIdentidade == null) {
            System.err.println("O valor anterior nao pode ser nullo");

        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoDocumentoIdentidade.getIdTipoDocumentoIdentidade());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro na eliminacao de dados:" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public TipoDocumentoIdentidade findById(Integer id) {
        
        TipoDocumentoIdentidade tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Nao foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tipoDocumentoIdentidade, rs);

        } catch (Exception e) {
            System.err.println("Erro ao ler dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return tipoDocumentoIdentidade;
    }

    @Override
    public List<TipoDocumentoIdentidade> findAll() {
       
        List<TipoDocumentoIdentidade> tipoDocumentoIdentidades = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDocumentoIdentidade tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
                popularComDados(tipoDocumentoIdentidade, rs);
                tipoDocumentoIdentidades.add(tipoDocumentoIdentidade);
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura dos dados: " + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return tipoDocumentoIdentidades;
    }

    @Override
    public void popularComDados(TipoDocumentoIdentidade tipoDocumentoIdentidade, ResultSet rs) {

        try {
            tipoDocumentoIdentidade.setIdTipoDocumentoIdentidade(rs.getInt("id_tipo_documento_identidade"));
            tipoDocumentoIdentidade.setTipoDOcumentoIdentidade(rs.getString("tipo_documento_identidade"));
        } catch (Exception e) {
            System.err.println("Erro no carregamento de dados: " + e.getLocalizedMessage());
        }
    }

}
