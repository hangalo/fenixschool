/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.util;

import fenixschool.dao.MatriculaDAO;
import fenixschool.dao.ProfessorDAO;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.ProfessorDepartamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class App {

    public static void main(String[] args) {
       MatriculaDAO dao = new MatriculaDAO();
       dao.decrementaVagas(1);
        System.out.println("Ok");
       // System.out.println(">>>>>> Valor achao- Ultima matricula"+dao.buscaUltimaMatriculaFeita());
        
        /*
        ProfessorDAO pdao = new ProfessorDAO();
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(5);
        Date inicioIntervalo = null;
        Date fimIntervalo = null;
        
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            inicioIntervalo = dateFormat.parse("05/09/2017");
            fimIntervalo = dateFormat.parse("12/09/2017");

        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println("Datas\t" + DateUtil.formataData(fimIntervalo));

        List<ProfessorDepartamento> lista = pdao.findProfessorPorDepartamento(departamento, DateUtil.formataData(inicioIntervalo), DateUtil.formataData(fimIntervalo));

        for (ProfessorDepartamento professorDepartamento : lista) {
            System.err.println("Algum dado" + professorDepartamento.getProfessor());
        }
        */
    }

}
