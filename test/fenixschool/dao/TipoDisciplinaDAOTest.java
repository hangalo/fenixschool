/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.TipoDisciplina;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class TipoDisciplinaDAOTest {
    
    public TipoDisciplinaDAOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of save method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        TipoDisciplina tipoDisciplina = new TipoDisciplina();
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        tipoDisciplina.setTipoDisciplina("Anual");
        //boolean expResult = false;
        boolean result = instance.save(tipoDisciplina);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testUpdate() {
        /*System.out.println("update");
        TipoDisciplina tipoDisciplina = null;
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        boolean expResult = false;
        boolean result = instance.update(tipoDisciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of delete method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testDelete() {
        /*System.out.println("delete");
        TipoDisciplina tipoDisciplina = null;
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        boolean expResult = false;
        boolean result = instance.delete(tipoDisciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findById method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testFindById() {
        /*System.out.println("findById");
        Integer id = null;
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        TipoDisciplina expResult = null;
        TipoDisciplina result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findAll method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testFindAll() {
        /*System.out.println("findAll");
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        List<TipoDisciplina> expResult = null;
        List<TipoDisciplina> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of popularComDados method, of class TipoDisciplinaDAO.
     */
    @Test
    public void testPopularComDados() {
        /*System.out.println("popularComDados");
        TipoDisciplina tipoDisciplina = null;
        ResultSet rs = null;
        TipoDisciplinaDAO instance = new TipoDisciplinaDAO();
        instance.popularComDados(tipoDisciplina, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
