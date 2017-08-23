/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.AnoLectivoDAO;
import fenixschool.modelo.AnoLectivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "anoLectivoConverter", forClass = AnoLectivo.class)
public class AnoLectivoConverter implements Converter {

    AnoLectivoDAO anoLectivoDAO = new AnoLectivoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        anoLectivoDAO.findById(id);
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            AnoLectivo anoLectivo = (AnoLectivo) value;
            return String.valueOf(anoLectivo.getIdAnoLectivo());
        }
        return null;
    }

}
