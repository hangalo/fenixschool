/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Candidato;
import fenixschool.util.DateUtill2;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class CandidatoDAOTest {
    
    public CandidatoDAOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of save method, of class CandidatoDAO.
     */
    @Test
    public void testSave() {
       /* System.out.println("save");
        Candidato candidato = null;
        CandidatoDAO instance = new CandidatoDAO();
        instance.save(candidato);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");*/
    }

    /**
     * Test of update method, of class CandidatoDAO.
     */
    @Test
    public void testUpdate() {
       /* System.out.println("update");
        Candidato candidato = null;
        CandidatoDAO instance = new CandidatoDAO();
        instance.update(candidato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of delete method, of class CandidatoDAO.
     */
    @Test
    public void testDelete() {
       /* System.out.println("delete");
        Candidato candidato = null;
        CandidatoDAO instance = new CandidatoDAO();
        instance.delete(candidato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findById method, of class CandidatoDAO.
     */
    @Test
    public void testFindById() {
       /* System.out.println("findById");
        Integer id = null;
        CandidatoDAO instance = new CandidatoDAO();
        Candidato expResult = null;
        Candidato result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findNomeSobrenome method, of class CandidatoDAO.
     */
    @Test
    public void testFindNomeSobrenome() {
        /*System.out.println("findNomeSobrenome");
        String nome = "Elísio";
        String sobrenome = "Kavaimunwa";
        CandidatoDAO instance = new CandidatoDAO();
        //Candidato expResult = null;
        //Candidato candidato = instance.findByNomeSobrenome(nome, sobrenome);
        assertTrue(candidato != null);*/
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        /*System.out.println("Código: " + candidato.getIdCandidato());
        System.out.println("Número: " + candidato.getNumeroCandidato());
        System.out.println("Nome: " + candidato.getNomeCandidato());
        System.out.println("Data de Nascimento: " + DateUtill2.formataData(candidato.getDataNascimento()));
        System.out.println("Sexo: " + candidato.getSexo().getAbreviatura());
        System.out.println("Profissão: " + candidato.getProfissao().getNomeProfissao());
        System.out.println("Casa: " + candidato.getCasaCandidato());
        System.out.println("Bairro: " + candidato.getBairroCandidato());
        System.out.println("Distrito: " + candidato.getDistritoCandidato());
        System.out.println("Municipio: " + candidato.getMunicipio().getNomeMunicipio());
        System.out.println("Tel. Fixo: " + candidato.getTelefoneFixo());
        System.out.println("Tel. Movel: " + candidato.getTelefoneMovel());
        System.out.println("Email: " + candidato.getEmailCandidato());
        */
    }

    /**
     * Test of findNumero method, of class CandidatoDAO.
     */
    @Test
    public void testFindNumero() {
        System.out.println("findNumero");
        String numero = "12345";
        CandidatoDAO instance = new CandidatoDAO();
        //Candidato expResult = null;
        Candidato candidato = instance.findByNumero(numero);
        assertTrue(candidato != null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
        
        /*
        System.out.println("Código: " + candidato.getIdCandidato());
        System.out.println("Número: " + candidato.getNumeroCandidato());
        System.out.println("Nome: " + candidato.getNomeCandidato());
        System.out.println("Data de Nascimento: " + DateUtill2.formataData(candidato.getDataNascimento()));
        System.out.println("Sexo: " + candidato.getSexo().getAbreviatura());
        System.out.println("Profissão: " + candidato.getProfissao().getNomeProfissao());
        System.out.println("Casa: " + candidato.getCasaCandidato());
        System.out.println("Bairro: " + candidato.getBairroCandidato());
        System.out.println("Distrito: " + candidato.getDistritoCandidato());
        System.out.println("Municipio: " + candidato.getMunicipio().getNomeMunicipio());
        System.out.println("Tel. Fixo: " + candidato.getTelefoneFixo());
        System.out.println("Tel. Movel: " + candidato.getTelefoneMovel());
        System.out.println("Email: " + candidato.getEmailCandidato());
        */
    }

    /**
     * Test of findSexo method, of class CandidatoDAO.
     */
    @Test
    public void testFindSexo() {
       /* System.out.println("findSexo");
        String sexo = "M";
        CandidatoDAO instance = new CandidatoDAO();
        //Candidato expResult = null;
        Candidato candidato = instance.findBySexo(sexo);
        assertTrue(candidato != null);*/
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
        
        /*System.out.println("Código: " + candidato.getIdCandidato());
        System.out.println("Número: " + candidato.getNumeroCandidato());
        System.out.println("Nome: " + candidato.getNomeCandidato());
        System.out.println("Data de Nascimento: " + DateUtill2.formataData(candidato.getDataNascimento()));
        System.out.println("Sexo: " + candidato.getSexo().getAbreviatura());
        System.out.println("Profissão: " + candidato.getProfissao().getNomeProfissao());
        System.out.println("Casa: " + candidato.getCasaCandidato());
        System.out.println("Bairro: " + candidato.getBairroCandidato());
        System.out.println("Distrito: " + candidato.getDistritoCandidato());
        System.out.println("Municipio: " + candidato.getMunicipio().getNomeMunicipio());
        System.out.println("Tel. Fixo: " + candidato.getTelefoneFixo());
        System.out.println("Tel. Movel: " + candidato.getTelefoneMovel());
        System.out.println("Email: " + candidato.getEmailCandidato());
        */
    }

    /**
     * Test of findDataDeNascimento method, of class CandidatoDAO.
     */
    @Test
    public void testFindDataDeNascimento() {
        System.out.println("findDataDeNascimento");
        /*Date data = null;
        CandidatoDAO instance = new CandidatoDAO();
        //Candidato expResult = null;
        Candidato candidato = instance.findDataDeNascimento(data);
        assertTrue(candidato != null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of findAll method, of class CandidatoDAO.
     */
    @Test
    public void testFindAll() {
        /*System.out.println("findAll");
        CandidatoDAO instance = new CandidatoDAO();
        List<Candidato> expResult = null;
        List<Candidato> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of popularComDados method, of class CandidatoDAO.
     */
    @Test
    public void testPopularComDados() {
       /* System.out.println("popularComDados");
        Candidato candidato = null;
        ResultSet rs = null;
        CandidatoDAO instance = new CandidatoDAO();
        instance.popularComDados(candidato, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
