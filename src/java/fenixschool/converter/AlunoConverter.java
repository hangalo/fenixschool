/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.converter;

import fenixschool.dao.AlunoDAO;
import fenixschool.modelo.Aluno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PENA
 */
@FacesConverter(value = "alunoConverter ", forClass = Aluno.class)
public class AlunoConverter implements Converter {

    AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Integer id = Integer.parseInt(value);
        try {
            return alunoDAO.findById(id);
        } catch (Exception e) {
            System.err.println("Erro na conversão: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Aluno aluno = (Aluno) value;
            return String.valueOf(aluno.getIdAluno());
        }
        return null;
    }

}
