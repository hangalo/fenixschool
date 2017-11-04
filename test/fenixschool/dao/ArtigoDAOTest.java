/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Artigo;
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
public class ArtigoDAOTest {

    public ArtigoDAOTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of save method, of class ArtigoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Artigo artigo = new Artigo();
        artigo.setCodigoArgito("codigo4");
        artigo.setCodigoBarraArtigo("codigobarra4");
        artigo.setNomeArtigo("declaracao4");
        artigo.setPrecoArtigo(2500.00);
        CategoriaArtigo categoriaArtigo = new CategoriaArtigo();
        categoriaArtigo.setIdCategoriaArtigo(2);
        artigo.setCategoriaArtigo(categoriaArtigo);
        ArtigoDAO artigoDAO = new ArtigoDAO();
        // boolean expResult = false;
         //boolean result = artigoDAO.save(artigo);

        //assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ArtigoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Artigo artigo = new Artigo();
        artigo.setIdArtigo(2);
        artigo.setCodigoArgito("codigo3");
        artigo.setCodigoBarraArtigo("codigobarra3");
        artigo.setNomeArtigo("declaracao3");
        artigo.setPrecoArtigo(2500.00);
        CategoriaArtigo categoriaArtigo = new CategoriaArtigo();
        categoriaArtigo.setIdCategoriaArtigo(2);
        artigo.setCategoriaArtigo(categoriaArtigo);
        ArtigoDAO artigoDAO = new ArtigoDAO();
        // boolean expResult = false;
        //boolean result = artigoDAO.update(artigo);
        // assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of delete method, of class ArtigoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Artigo artigo = new Artigo();
        artigo.setIdArtigo(2);
        ArtigoDAO instance = new ArtigoDAO();
        boolean expResult = false;
        //boolean result = instance.delete(artigo);
        //assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");*/
    }

    /**
     * Test of findById method, of class ArtigoDAO.
     */
    @Test
    public void testFindById() {
        /* System.out.println("findById");
        Integer id = 1;
        ArtigoDAO instance = new ArtigoDAO();
        Artigo expResult = null;
        Artigo artigo = instance.findById(id);
        assertTrue(artigo != null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("Id: " + artigo.getIdArtigo());
        System.out.println("Código: " + artigo.getCodigoArgito());
        System.out.println("Nome: " + artigo.getNomeArtigo());
        System.out.println("Código de barras: " + artigo.getCodigoBarraArtigo());
        System.out.println("Preço: " + artigo.getPrecoArtigo());
        System.out.println("Categoria: " + artigo.getCategoriaArtigo().getCategoriaArtigo());
         */
    }

    /**
     * Test of findAll method, of class ArtigoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArtigoDAO instance = new ArtigoDAO();
        //List<Artigo> expResult = null;
        List<Artigo> artigos = instance.findAll();
        assertTrue(artigos.size() > 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        for (Artigo artigo : artigos) {
            System.out.println("Id: " + artigo.getIdArtigo());
            System.out.println("Código: " + artigo.getCodigoArgito());
            System.out.println("Nome: " + artigo.getNomeArtigo());
            System.out.println("Código de barras: " + artigo.getCodigoBarraArtigo());
            System.out.println("Preço: " + artigo.getPrecoArtigo());
            System.out.println("Categoria: " + artigo.getCategoriaArtigo().getCategoriaArtigo());
            System.out.println("--------------------------------------------------------------");
        }
    }

    /**
     * Test of popularComDados method, of class ArtigoDAO.
     */
    @Test
    public void testPopularComDados() {
        /*System.out.println("popularComDados");
        Artigo artigo = null;
        ResultSet rs = null;
        ArtigoDAO instance = new ArtigoDAO();
        instance.popularComDados(artigo, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

}
