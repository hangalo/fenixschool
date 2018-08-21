/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.SemestreLectivoDAO;
import fenixschool.modelo.SemestreLectivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "semestreLectivoConverter", forClass = SemestreLectivo.class)
public class SemestreLectivoConverter implements Converter {
    
    SemestreLectivoDAO semestreDAO = new SemestreLectivoDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id = Integer.parseInt(value);
        try {
            return semestreDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            SemestreLectivo semestreLectivo = (SemestreLectivo) value;
            return String.valueOf(semestreLectivo.getIdSemestreLectivo());
        }
        return null;
    }
    
}
