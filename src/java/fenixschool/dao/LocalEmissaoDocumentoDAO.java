/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;


import fenixschool.modelo.LocalEmissaoDocumento;
import fenixschool.util.Conexao;
import java.util.List;
import javax.jms.Connection;
import javax.resource.cci.ResultSet;

/**
 *
 * @author henriques elias
 */
public class LocalEmissaoDocumentoDAO implements GenericoDAO <LocalEmissaoDocumento> {
    private static final String INSERIR = "INSERT into LocalEmisssaoDocumento (local_emissao_docuento) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE LocalEmissaoDocuento set local_emissao_documento = ? WHERE id_local_emissao_documento = ?";
    private static final String ELIMINAR = "DELETE FROM LocaEmisssaoDocumento WHERE id_local_emissao_documento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM LocalEmissaoDocumento WHERE id_local_emissao_documento = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM LocalEmissaoDocumento ORDER BY local_emissao_documento ASC;";

    @Override
    public void save(LocalEmissaoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LocalEmissaoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(LocalEmissaoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalEmissaoDocumento findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LocalEmissaoDocumento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(LocalEmissaoDocumento t, java.sql.ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    




}
