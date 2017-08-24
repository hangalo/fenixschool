/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.TipoDocumentoIdentidadeDAO;
import fenixschool.modelo.TipoDocumentoIdentidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */
@FacesConverter(value = "tipoDocumentoIdentidadeConverter", forClass = TipoDocumentoIdentidade.class)
public class TipoDocumentoIdentidadeConverter implements Converter{
    TipoDocumentoIdentidadeDAO tipoDocumentoIdentidadeDAO = new TipoDocumentoIdentidadeDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return tipoDocumentoIdentidadeDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((TipoDocumentoIdentidade) value).getIdTipoDocumentoIdentidade().toString();
        }
        return null;
    }
    
}
