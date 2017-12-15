/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.DisciplinaDAO;
import fenixschool.modelo.Disciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "disciplinaConverter", forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return disciplinaDAO.findByCodigo(value);
        } catch (Exception e) {
            System.err.println("Erro na conversao "+e.getMessage());
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if (value != null) {
            Disciplina disciplina = (Disciplina) value;
            return String.valueOf(disciplina.getIdDisciplina());
        }

        return null;
    }

}
