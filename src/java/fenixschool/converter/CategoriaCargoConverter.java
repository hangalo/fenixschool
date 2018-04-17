/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CategoriaCargoDAO;
import fenixschool.modelo.CategoriaCargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Aisha Lubadika
 */

@FacesConverter(value = "categoriaCargoConverter", forClass = CategoriaCargo.class)
public class CategoriaCargoConverter implements Converter{
    
    CategoriaCargoDAO categoriaCargoDAO = new CategoriaCargoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Integer id = Integer.parseInt(value);
        try {
            return categoriaCargoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          if (value != null) {
            CategoriaCargo categoriaCargo = (CategoriaCargo) value;
            return String.valueOf(categoriaCargo.getIdCategoriaCargo());
        }
        return null;
    }
    
}
