/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.ProfessorDAO;
import fenixschool.modelo.Professor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author informatica
 */
@FacesConverter(value = "professorConverter", forClass = Professor.class)
public class ProfessorConverter implements Converter {

    ProfessorDAO professorDAO = new ProfessorDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          Integer id = Integer.parseInt(value);
        try {
            return professorDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value != null) {
            Professor professor =(Professor)value;
            return String.valueOf(professor.getIdProfessor());
        }
        return null;
      
    }
    

}
