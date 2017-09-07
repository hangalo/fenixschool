/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.PeriodoLectivoDAO;
import fenixschool.modelo.PeriodoLectivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */

@FacesConverter(value = "periodoLectivoConverter", forClass = PeriodoLectivo.class)
public class PeriodoLectivoConverter implements Converter {
     PeriodoLectivoDAO periodoLectivoDAO = new PeriodoLectivoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          Integer id = Integer.parseInt(value);
        try {
            return periodoLectivoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            PeriodoLectivo periodoLectivo =(PeriodoLectivo) value;
            return String.valueOf(periodoLectivo.getIdPeriodoLectivo());
        }
        return null;
      
    }
    }
    

