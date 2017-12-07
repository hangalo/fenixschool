/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.MesDAO;
import fenixschool.modelo.Mes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */
@FacesConverter(value = "mesConverter", forClass = Mes.class)
public class MesConverter implements Converter {

    MesDAO mesDAO = new MesDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Integer id = Integer.parseInt(value);
        try {
            return mesDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Mes mes = (Mes) value;
            return String.valueOf(mes.getIdMes());
        }
        return null;
        
    }

}
