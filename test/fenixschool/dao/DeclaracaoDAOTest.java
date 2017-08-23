/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Declaracao;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.ObjetivoDeclaracao;

import java.sql.ResultSet;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kulley
 */
public class DeclaracaoDAOTest {
    
    public DeclaracaoDAOTest() {
    }

    /**
     
    @Test
    public void testSave() {
        System.out.println("save");
        Declaracao declaracao = new Declaracao();
        DeclaracaoDAO instance = new DeclaracaoDAO();
        declaracao.setTextoDeclaracao("Hey");
        declaracao.setDataDeclaracao(DateUtil.strToDate("20/06/2017"));
        
        Funcionario f = new Funcionario();
        f.setIdFuncionario(1);
        ObjetivoDeclaracao o = new ObjetivoDeclaracao();
        o.setIdObjetivoDeclaracao(1);
        Aluno a = new Aluno();
        declaracao.setIdFuncionario(f);
        declaracao.setIdObjetivoDeclaracao(o);
        declaracao.setIdAluno(a);
        instance.save(declaracao);
        
        
    }

    /**
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        Declaracao declaracao = null;
        DeclaracaoDAO instance = new DeclaracaoDAO();
        instance.update(declaracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testDelete() {
        System.out.println("delete");
        Declaracao declaracao = null;
        DeclaracaoDAO instance = new DeclaracaoDAO();
        instance.delete(declaracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
     
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        DeclaracaoDAO instance = new DeclaracaoDAO();
        Declaracao expResult = null;
        Declaracao result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DeclaracaoDAO instance = new DeclaracaoDAO();
        List<Declaracao> expResult = null;
        List<Declaracao> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testPopularComDados() {
        System.out.println("popularComDados");
        Declaracao declaracao = null;
        ResultSet rs = null;
        DeclaracaoDAO instance = new DeclaracaoDAO();
        instance.popularComDados(declaracao, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
