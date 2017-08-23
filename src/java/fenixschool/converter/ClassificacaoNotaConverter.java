/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.ClassificacaoNotaDAO;
import fenixschool.modelo.ClassificacaoNota;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Convert;

/**
 *
 * @author kulley
 */

@FacesConverter(value = "classificacaoNotaConverter" , forClass = ClassificacaoNota.class)
public class ClassificacaoNotaConverter implements Converter {
    
    ClassificacaoNotaDAO classificacaoDAO = new ClassificacaoNotaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        
        try {
            return classificacaoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na COnversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null){
            ClassificacaoNota classificacaoNota = (ClassificacaoNota)value;
            return String.valueOf(classificacaoNota.getIdClassificacaoNota());
        }
        return null;
    }
    
    
}
