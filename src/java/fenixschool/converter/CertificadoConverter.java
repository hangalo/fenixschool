/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.CertificadoDAO;
import fenixschool.modelo.Certificado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "certificadoConverter", forClass = Certificado.class)
public class CertificadoConverter implements Converter {

    CertificadoDAO certificadoDAO = new CertificadoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return certificadoDAO.findById(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            System.out.println("Ops! erro de conversão..." + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Certificado) {
            Certificado certificado = (Certificado) value;
            return String.valueOf(certificado.getIdCertificado());
        }
        return null;
    }

}
