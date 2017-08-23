/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.ObjetivoDeclaracaoDAO;
import fenixschool.modelo.ObjetivoDeclaracao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author kulley
 */

@FacesConverter (value = "objetivoDeclaracaoConverter", forClass = ObjetivoDeclaracao.class)
public class ObjetivoDeclaracaoConverter implements Converter{
    
    ObjetivoDeclaracaoDAO objetivoDeclaracaoDAO = new ObjetivoDeclaracaoDAO();
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        
        try {
            return objetivoDeclaracaoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na Conversão: " +ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            ObjetivoDeclaracao objetivoDeclaracao = (ObjetivoDeclaracao)value;
            return String.valueOf(objetivoDeclaracao.getIdObjetivoDeclaracao());
        }
        return null;
    }
    
}
