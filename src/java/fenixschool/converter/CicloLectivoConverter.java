/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CicloLectivoDAO;
import fenixschool.modelo.CicloLectivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */

@FacesConverter(value = "cicloLectivoConverter", forClass = CicloLectivo.class)
public class CicloLectivoConverter implements Converter{
     CicloLectivoDAO cicloLectivoDAO = new CicloLectivoDAO();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          Integer id = Integer.parseInt(value);
        try {
            return cicloLectivoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
            CicloLectivo cicloLectivo=(CicloLectivo)value;
            return String.valueOf(cicloLectivo.getIdCicloLectivo());
        }
        return null;
    }
    
}
