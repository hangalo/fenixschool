/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CursoDAO;
import fenixschool.modelo.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */
@FacesConverter(value = "cursoConverter", forClass = Curso.class)
public class CursoConverter implements Converter{

    CursoDAO cursoDAO = new CursoDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        try {
            return cursoDAO.findByCodigo(value);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Curso curso = (Curso)value;
            return ((Curso) value).getCodigoCurso();
        }
        return null;
    }
    
}
