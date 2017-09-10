/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;


import fenixschool.dao.LocalEmissaoDocumentoDAO;
import fenixschool.modelo.LocalEmissaoDocumento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author informatica
 */
@FacesConverter(value = "localEmissaoDocumentoConverter", forClass = LocalEmissaoDocumento.class)
public class LocalEmissaoDocumentoConverter implements Converter{

    LocalEmissaoDocumentoDAO localEmissaoDocumentoDAO = new LocalEmissaoDocumentoDAO();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return localEmissaoDocumentoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            LocalEmissaoDocumento localEmissaoDocumento =(LocalEmissaoDocumento)value;
            return String.valueOf(localEmissaoDocumento.getIdLocalEmissaoDocumento());
        }
        return null;
    }
    
}
