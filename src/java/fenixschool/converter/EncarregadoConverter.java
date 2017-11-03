/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.EncarregadoEducacaoDAO;
import fenixschool.modelo.EncarregadoEducacao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(forClass = EncarregadoEducacao.class, value = "encarregadoConverter")
public class EncarregadoConverter implements Converter {

    EncarregadoEducacaoDAO encarregadoEducacaoDAO = new EncarregadoEducacaoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return encarregadoEducacaoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão:" + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            EncarregadoEducacao encarregado = (EncarregadoEducacao) value;
            return String.valueOf(encarregado.getIdEncarregadoEducacao());
        }
        return null;
    }

}
