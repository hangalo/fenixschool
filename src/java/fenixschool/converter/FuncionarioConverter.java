/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.FuncionarioDAO;
import fenixschool.modelo.Funcionario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author kulley
 */

@FacesConverter(value = "funcionarioConverter", forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return funcionarioDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Funcionario funcionario =(Funcionario)value;
            return String.valueOf(funcionario.getIdFuncionario());
        }
        return null;
    }
    
}
