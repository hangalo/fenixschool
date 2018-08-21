/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.BoletimNotaDAO;
import fenixschool.modelo.BoletimNota;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "boletimConverter", forClass = BoletimNota.class)
public class BoletimNotaConverter implements Converter {

    BoletimNotaDAO boletimNotaDAO = new BoletimNotaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return boletimNotaDAO.findById(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            System.out.println("Ops! Ocorreu um erro de conversão... " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof BoletimNota) {
            BoletimNota bn = (BoletimNota) value;
            return String.valueOf(bn.getIdBoletim());
        }
        return null;
    }

}
