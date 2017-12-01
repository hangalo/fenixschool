/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CategoriaArtigoDAO;
import fenixschool.modelo.CategoriaArtigo;
import fenixschool.modelo.CicloLectivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elísio Kavaimunwa
 */

@FacesConverter(value = "categoriaArtigoConverter", forClass = CategoriaArtigo.class)
public class CategoriaArtigoConverter implements Converter{
    
    CategoriaArtigoDAO categoriaArtigoDAO = new CategoriaArtigoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Integer id = Integer.parseInt(value);
        try {
            return categoriaArtigoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            CategoriaArtigo categoriaArtigo = (CategoriaArtigo) value;
            return String.valueOf(categoriaArtigo.getIdCategoriaArtigo());
        }
        return null;
    }
    

    
    
}
