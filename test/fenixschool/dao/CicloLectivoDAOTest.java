/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CicloLectivo;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aisha Lubadika
 */
public class CicloLectivoDAOTest {
    
    public CicloLectivoDAOTest() {
    }

    /**
     * Test of save method, of class CicloLectivoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        CicloLectivo cicloLectivo = new CicloLectivo();
        
        cicloLectivo.setCicloLectivo("Ciclo2");
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.save(cicloLectivo);
       
    }

    
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        CicloLectivo cicloLectivo = new CicloLectivo();
        cicloLectivo.setIdCicloLectivo(2);
        cicloLectivo.setCicloLectivo("ciclo4");
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.update(cicloLectivo);
     
    }

    
    @Test
    public void testDelete() {
        System.out.println("delete");
        CicloLectivo cicloLectivo = new CicloLectivo();
        cicloLectivo.setIdCicloLectivo(1);
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.delete(cicloLectivo);
        
    }

 
     
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        
        CicloLectivo result = instance.findById(id);
      
}

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CicloLectivoDAO instance = new CicloLectivoDAO();
        
        List<CicloLectivo> result = instance.findAll();
        assertTrue(result.size()>0);
    }

}  
    

