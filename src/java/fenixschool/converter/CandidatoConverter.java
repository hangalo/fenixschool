/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CandidatoDAO;
import fenixschool.modelo.Candidato;
import fenixschool.modelo.Departamento;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */
@FacesConverter(value = "candidatoConverter", forClass = Candidato.class)
public class CandidatoConverter implements Converter{

    CandidatoDAO candidatoDAO = new CandidatoDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Integer id = Integer.parseInt(value);
        try {
            return candidatoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         
      if (value != null) {
            return ((Candidato) value).getIdCandidato().toString();
        }
        return null;
    }
    
}
