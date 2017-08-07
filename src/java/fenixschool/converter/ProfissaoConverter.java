/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;


import fenixschool.dao.ProfissaoDAO;

import fenixschool.modelo.Profissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author informatica
 */
@FacesConverter(value = "profissaoConverter", forClass = Profissao.class)
public class ProfissaoConverter implements Converter {

    ProfissaoDAO profissaoDAO = new ProfissaoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return profissaoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
        if (value != null) {
            Profissao profissao =(Profissao)value;
            return String.valueOf(profissao.getIdProfissao());
        }
        return null;
    }

}
