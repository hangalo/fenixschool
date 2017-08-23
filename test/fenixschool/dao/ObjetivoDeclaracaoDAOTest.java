/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.ObjetivoDeclaracao;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kulley
 */


public class ObjetivoDeclaracaoDAOTest {
    /**
    @Test
    public void testSave() {
        System.out.println("save");
        ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
        ObjetivoDeclaracaoDAO instance = new ObjetivoDeclaracaoDAO();
        objetivoDeclaracao.setObjectivoDeclaracao("PDA");
        instance.save(objetivoDeclaracao);
        objetivoDeclaracao.setObjectivoDeclaracao("PDHG");
        instance.save(objetivoDeclaracao);
        objetivoDeclaracao.setObjectivoDeclaracao("QWERTY");
        instance.save(objetivoDeclaracao);
        
    }

    
    
    @Test
    public void testUpdate() {
        System.out.println("update");
        ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
        ObjetivoDeclaracaoDAO instance = new ObjetivoDeclaracaoDAO();
        objetivoDeclaracao.setObjectivoDeclaracao("PPDDAA");
        objetivoDeclaracao.setIdObjetivoDeclaracao(2);
        instance.update(objetivoDeclaracao);
       
    } 

    
    @Test
    public void testDelete() {
        System.out.println("delete");
        ObjetivoDeclaracao objetivoDeclaracao = new ObjetivoDeclaracao();
        ObjetivoDeclaracaoDAO instance = new ObjetivoDeclaracaoDAO();
        objetivoDeclaracao.setIdObjetivoDeclaracao(4);
        instance.delete(objetivoDeclaracao);
        
    }

   
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        ObjetivoDeclaracaoDAO instance = new ObjetivoDeclaracaoDAO();
        
        ObjetivoDeclaracao result = instance.findById(id);
        assertTrue(result != null);
        
    }
*/
   
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ObjetivoDeclaracaoDAO instance = new ObjetivoDeclaracaoDAO();
    
        List<ObjetivoDeclaracao> result = instance.findAll();
        assertTrue(result.size() > 0);
    }

   
}
