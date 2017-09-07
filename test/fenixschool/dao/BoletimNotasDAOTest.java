/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.BoletimNotas;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PENA
 */
public class BoletimNotasDAOTest {

    public BoletimNotasDAOTest() {
    }

    /**
     * Test of save method, of class BoletimNotasDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        BoletimNotas boletimNotas = new BoletimNotas();
        BoletimNotasDAO instance = new BoletimNotasDAO();

        boletimNotas.setDataBoletimNotas(Date.from(Instant.now()));
        Aluno aluno = new Aluno();
        aluno.setIdAluno(14);
        boletimNotas.setAluno(aluno);

        boletimNotas.setDataBoletimNotas(Date.from(Instant.now()));
        aluno.setIdAluno(13);
        boletimNotas.setAluno(aluno);

        boletimNotas.setDataBoletimNotas(Date.from(Instant.now()));
        aluno.setIdAluno(14);
        boletimNotas.setAluno(aluno);

        instance.save(boletimNotas);

    }

    /**
     * Test of update method, of class BoletimNotasDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BoletimNotas boletimNotas = new BoletimNotas();
        BoletimNotasDAO instance = new BoletimNotasDAO();
        boletimNotas.setDataBoletimNotas(Date.from(Instant.now()));
        Aluno aluno = new Aluno();
        aluno.setIdAluno(14);
        boletimNotas.setAluno(aluno);
        boletimNotas.setIdBoletimNotas(14);
        instance.update(boletimNotas);

    }

    /**
     * Test of delete method, of class BoletimNotasDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BoletimNotas boletimNota = new BoletimNotas();
        BoletimNotasDAO instance = new BoletimNotasDAO();
        boletimNota.setIdBoletimNotas(8);
        instance.delete(boletimNota);

    }

    /**
     * Test of findById method, of class BoletimNotasDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 5;
        BoletimNotasDAO instance = new BoletimNotasDAO();
       
        BoletimNotas result = instance.findById(id);
        assertTrue(result!=null);

    }

    /**
     * Test of findAll method, of class BoletimNotasDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        BoletimNotasDAO instance = new BoletimNotasDAO();
        List<BoletimNotas> result = instance.findAll();
        assertTrue(result.size()>0);
        
    }

}
