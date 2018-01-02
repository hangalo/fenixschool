/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;


import fenixschool.dao.SalaDAO;
import fenixschool.modelo.Sala;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */

@FacesConverter(value = "salaConverter", forClass = Sala.class)
public class SalaConverter  implements Converter{

    SalaDAO salaDAO = new SalaDAO();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         Integer id = Integer.parseInt(value);
        try {
            return salaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            Sala  sala = (Sala) value;
            return String.valueOf(sala.getIdSala());
        }
        return null;
    }
    
}
