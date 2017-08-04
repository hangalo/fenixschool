/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HACKER
 */
public class LocalEmissaoDocumento {
    private int idLocalEmissaoDocumento;
    private String localEmissaoDocumento;

    public LocalEmissaoDocumento() {
    }

    public LocalEmissaoDocumento(int idLocalEmissaoDocumento, String localEmissaoDocumento) {
        this.idLocalEmissaoDocumento = idLocalEmissaoDocumento;
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    public int getIdLocalEmissaoDocumento() {
        return idLocalEmissaoDocumento;
    }
 
    public void setIdLocalEmissaoDocumento(int idLocalEmissaoDocumento) {
        this.idLocalEmissaoDocumento = idLocalEmissaoDocumento;
    }

    public String getLocalEmissaoDocumento() {
        return localEmissaoDocumento;
    }

    public void setLocalEmissaoDocumento(String localEmissaoDocumento) {
        this.localEmissaoDocumento = localEmissaoDocumento;
    }

    @Override
    public String toString() {
        return "LocalEmissaoDocumento{" + "localEmissaoDocumento=" + localEmissaoDocumento + '}';
    }

    public String getlocal_emissao_documento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getid_local_emissao_documento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setid_local_elmissao_documento(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setlocal_emissao_document(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
