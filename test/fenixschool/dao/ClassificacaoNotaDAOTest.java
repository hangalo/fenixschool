/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.ClassificacaoNota;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class ClassificacaoNotaDAOTest {
    
    public ClassificacaoNotaDAOTest() {
    }

    /**
     * Test of save method, of class ClassificacaoNotaDAO.
     */
    /**
    @Test
    public void testSave() {
        System.out.println("save");
        ClassificacaoNota classificacaoNota = new ClassificacaoNota();
        ClassificacaoNotaDAO instance = new ClassificacaoNotaDAO();
        classificacaoNota.setClassificacaoNota("Es Panaca!");

        
        instance.save(classificacaoNota);
        
    }*/

   
    /**  
    @Test
    public void testUpdate() {
        System.out.println("update");
        ClassificacaoNota classificacaoNota = new ClassificacaoNota();
        ClassificacaoNotaDAO instance = new ClassificacaoNotaDAO();
        
         classificacaoNota.setClassificacaoNota("Troxuda!");
         classificacaoNota.setIdClassificacaoNota(3);
        instance.update(classificacaoNota);
        
    }

    
    @Test
    public void testDelete() {
        System.out.println("delete");
        ClassificacaoNota classificacaoNota = new ClassificacaoNota();
        ClassificacaoNotaDAO instance = new ClassificacaoNotaDAO();
        classificacaoNota.setIdClassificacaoNota(4);
        instance.delete(classificacaoNota);
       
    }/**
     
 
    
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 3;
        ClassificacaoNotaDAO instance = new ClassificacaoNotaDAO();

        ClassificacaoNota result = instance.findById(id);
         assertTrue(result != null);
       
    }

    */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ClassificacaoNotaDAO instance = new ClassificacaoNotaDAO();
  
        List<ClassificacaoNota> result = instance.findAll();
       assertTrue(result.size() > 0);
        
    }

    
   
     
    
}
