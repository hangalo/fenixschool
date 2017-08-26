/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.TurmaDAO;
import fenixschool.modelo.Turma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */

@FacesConverter(value = "turmaConverter", forClass = Turma.class)
public class TurmaConverter  implements Converter{

    TurmaDAO turmaDAO = new TurmaDAO();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         Integer id = Integer.parseInt(value);
        try {
            return turmaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            Turma  turma=(Turma)value;
            return String.valueOf(turma.getIdTurma());
        }
        return null;
    }
    
}
