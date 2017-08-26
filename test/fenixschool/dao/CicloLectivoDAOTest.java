/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CicloLectivo;
import java.sql.ResultSet;
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
        CicloLectivo cicloLectivo = null;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.save(cicloLectivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CicloLectivoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CicloLectivo cicloLectivo = null;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.update(cicloLectivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CicloLectivoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        CicloLectivo cicloLectivo = null;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.delete(cicloLectivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class CicloLectivoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        CicloLectivo expResult = null;
        CicloLectivo result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CicloLectivoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CicloLectivoDAO instance = new CicloLectivoDAO();
        List<CicloLectivo> expResult = null;
        List<CicloLectivo> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popularComDados method, of class CicloLectivoDAO.
     */
    @Test
    public void testPopularComDados() {
        System.out.println("popularComDados");
        CicloLectivo cicloLectivo = null;
        ResultSet rs = null;
        CicloLectivoDAO instance = new CicloLectivoDAO();
        instance.popularComDados(cicloLectivo, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
