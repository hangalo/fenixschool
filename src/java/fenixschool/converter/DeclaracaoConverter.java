/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.DeclaracaoDAO;
import fenixschool.modelo.Declaracao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author kulley
 */

@FacesConverter(value = "declaracaoConverter", forClass = Declaracao.class)
public class DeclaracaoConverter implements Converter {

    DeclaracaoDAO declaracaoDAO = new DeclaracaoDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return declaracaoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Declaracao declaracao = (Declaracao)value;
            return String.valueOf(declaracao.getIdDeclaracao());
        }
        return null;
    }
    
}
