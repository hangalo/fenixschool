/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CategoriaArtigo;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class CategoriaArtigoDAOTest {

    public CategoriaArtigoDAOTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of save method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        CategoriaArtigo categoriaArtigo = new CategoriaArtigo(1, "declaração");
        CategoriaArtigoDAO instance = new CategoriaArtigoDAO();

        //boolean expResult = false;
        //boolean result = instance.save(categoriaArtigo);
        // assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        //CategoriaArtigo categoriaArtigo = new CategoriaArtigo(1, "certificado");
        //CategoriaArtigoDAO instance = new CategoriaArtigoDAO();
        //boolean expResult = false;
        //boolean result = instance.update(categoriaArtigo);
        //assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testDelete() {
        /*System.out.println("delete");
        CategoriaArtigo categoriaArtigo = new CategoriaArtigo(1, "");
        CategoriaArtigoDAO instance = new CategoriaArtigoDAO();
        boolean expResult = false;
        boolean result = instance.delete(categoriaArtigo);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of findById method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testFindById() {
        /*System.out.println("findById");
        Integer id = 2;
        CategoriaArtigoDAO instance = new CategoriaArtigoDAO();
        CategoriaArtigo expResult = null;
        CategoriaArtigo categoriaArtigo = instance.findById(id);
        assertTrue(categoriaArtigo != null);

        System.out.println("Id: " + categoriaArtigo.getIdCategoriaArtigo());
        System.out.println("Categoria: " + categoriaArtigo.getCategoriaArtigo());*/
    }

    /**
     * Test of findAll method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CategoriaArtigoDAO instance = new CategoriaArtigoDAO();
        List<CategoriaArtigo> expResult = null;
        List<CategoriaArtigo> categorias = instance.findAll();
        assertTrue(categorias.size() > 0);

        for (CategoriaArtigo categoriaArtigo : categorias) {
            System.out.println("Id: " + categoriaArtigo.getIdCategoriaArtigo());
            System.out.println("Categoria: " + categoriaArtigo.getCategoriaArtigo());
        }

    }

    /**
     * Test of popularComDados method, of class CategoriaArtigoDAO.
     */
    @Test
    public void testPopularComDados() {
        /*System.out.println("popularComDados");
        CategoriaArtigo categoriaArtigo = null;
        ResultSet rs = null;
        CategoriaArtigoDAO instance = new CategoriaArtigoDAO();
        instance.popularComDados(categoriaArtigo, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

}
