/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.TipoDisciplinaDAO;
import fenixschool.modelo.TipoDisciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */
@FacesConverter(value = "tipoDisciplinaConverter", forClass = TipoDisciplina.class)
public class TipoDisciplinaConverter implements Converter{

    TipoDisciplinaDAO tipoDisciplinaDAO = new TipoDisciplinaDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return tipoDisciplinaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
            TipoDisciplina tipoDisciplina = (TipoDisciplina)value;
            return String.valueOf(tipoDisciplina.getIdTipoDisciplina());
        }
        return null;
    }
    
}
