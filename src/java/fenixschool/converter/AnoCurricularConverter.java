/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.AnoCurricularDAO;
import fenixschool.modelo.AnoCurricular;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "anoCurricularConverter", forClass = AnoCurricular.class)
public class AnoCurricularConverter implements Converter {

    AnoCurricularDAO anoCurricularDAO = new AnoCurricularDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Integer id = Integer.parseInt(value);
        try {
           return anoCurricularDAO.findById(id);
        } catch (Exception e) {
            System.err.println("Erro na conversão: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            AnoCurricular anoCurricular = (AnoCurricular) value;
            return String.valueOf(anoCurricular.getIdAnoCurricular());
        }
        return null;
    }

}
