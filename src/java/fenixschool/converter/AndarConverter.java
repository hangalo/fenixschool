/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.AndarDAO;
import fenixschool.modelo.Andar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */
@FacesConverter(value = "andarConverter", forClass = Andar.class)
public class AndarConverter implements Converter {
    AndarDAO andarDAO = new AndarDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Integer id = Integer.parseInt(value);
        try {
            return andarDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Andar andar =(Andar)value;
            return String.valueOf(andar.getIdAndar());
        }
        return null;
      
    }
    
}
