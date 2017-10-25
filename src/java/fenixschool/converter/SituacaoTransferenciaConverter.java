/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.SituacaoTransferenciaDAO;
import fenixschool.modelo.SituacaoTransferencia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "situacaoTransferenciaConverter", forClass = SituacaoTransferencia.class)
public class SituacaoTransferenciaConverter implements Converter {

    SituacaoTransferenciaDAO situacaoTransferenciaDAO = new SituacaoTransferenciaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id = Integer.parseInt(value);
        try {
            return situacaoTransferenciaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value!=null) {
            SituacaoTransferencia situacaoTransferencia =(SituacaoTransferencia)value;
            return String.valueOf(situacaoTransferencia.getIdSituacaoTransferencia());
        }
        return null;
    }

}
