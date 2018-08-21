/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.NotaDAO;
import fenixschool.modelo.Nota;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "notaConverter", forClass = Nota.class)
public class NotaConverter implements Converter {

    NotaDAO notaDAO = new NotaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return notaDAO.findById(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            System.out.println("Erro de conversão da dados " + ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Nota) {
            Nota nota = (Nota) value;
            return String.valueOf(nota.getIdnota());
        }
        return null;
    }

}
