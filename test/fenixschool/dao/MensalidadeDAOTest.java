/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Mensalidade;
import fenixschool.modelo.Mes;
import fenixschool.modelo.Turma;
import fenixschool.util.DateUtill2;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class MensalidadeDAOTest {
    String data = "01/09/2017";
    Date dataFormatada = DateUtill2.strToDate(data);
    
    public MensalidadeDAOTest() {
    }
    
   
    /**
     * Test of save method, of class MensalidadeDAO.
     */
    @Test
    public void testSave() {
        AnoLectivo anoLectivo = new AnoLectivo();
        anoLectivo.setIdAnoLectivo(1);
        
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(5);
        Turma turma = new Turma();
        turma.setIdTurma(1);
        CicloLectivo cicloLectivo = new CicloLectivo();
        cicloLectivo.setIdCicloLectivo(1);
        Mes mes = new Mes();
        mes.setIdMes(1);
        Aluno aluno = new Aluno();
        aluno.setIdAluno(1);
        Curso curso = new Curso();
        curso.setCodigoCurso("MAT");

        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setDescricaoMensalidade("Descricao 4");
        mensalidade.setObservacaoMensalidade("Observação 4");
        mensalidade.setDataPagamento(dataFormatada);
        mensalidade.setAnoLetivo(anoLectivo);
        mensalidade.setDepartamento(departamento);
        mensalidade.setTurma(turma);
        mensalidade.setCicloLectivo(cicloLectivo);
        mensalidade.setMes(mes);
        mensalidade.setAluno(aluno);
        mensalidade.setCurso(curso);
        System.out.println("save");
       
        MensalidadeDAO instance = new MensalidadeDAO();
        instance.save(mensalidade);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of update method, of class MensalidadeDAO.
     */
    @Test
    public void testUpdate() {
        
       /* AnoLectivo anoLectivo = new AnoLectivo();
        anoLectivo.setIdAnoLectivo(1);
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(5);
        Turma turma = new Turma();
        turma.setIdTurma(1);
        CicloLectivo cicloLectivo = new CicloLectivo();
        cicloLectivo.setIdCicloLectivo(1);
        Mes mes = new Mes();
        mes.setIdMes(1);
        Aluno aluno = new Aluno();
        aluno.setIdAluno(1);
        Curso curso = new Curso();
        curso.setCodigoCurso("MAT");

        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setIdMensalidade(1);
        
        mensalidade.setValorJuro(150000);
        mensalidade.setValorPago(250000);
        mensalidade.setDescricaoMensalidade("Descricao 5");
        mensalidade.setObservacaoMensalidade("Observação 5");
        mensalidade.setDataPagamento(dataFormatada);
        mensalidade.setAnoLetivo(anoLectivo);
        mensalidade.setDepartamento(departamento);
        mensalidade.setTurma(turma);
        mensalidade.setCicloLectivo(cicloLectivo);
        mensalidade.setMes(mes);
        mensalidade.setAluno(aluno);
        mensalidade.setCurso(curso);

        System.out.println("update");
        MensalidadeDAO instance = new MensalidadeDAO();
        instance.update(mensalidade);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");*/

    }

    /**
     * Test of delete method, of class MensalidadeDAO.
     */
    @Test
    public void testDelete() {
       /* System.out.println("delete");
        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setIdMensalidade(1);
        MensalidadeDAO instance = new MensalidadeDAO();
        //instance.delete(mensalidade);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of findById method, of class MensalidadeDAO.
     */
    @Test
    public void testFindById() {
        /*System.out.println("findById");
        Integer id = 2;
        MensalidadeDAO instance = new MensalidadeDAO();
        Mensalidade mensalidade = new Mensalidade();
        mensalidade = instance.findById(id);
        //Assert.assertTrue(mensalidade != null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("Id: " + mensalidade.getIdMensalidade());
        System.out.println("Descrição: " + mensalidade.getDescricaoMensalidade());
        System.out.println("Observação: " + mensalidade.getObservacaoMensalidade());
        System.out.println("Data de Pagamento: " + DateUtill2.formataData(mensalidade.getDataPagamento()));
        System.out.println("\n");
        
        System.out.println("Ano Lectivo: " + mensalidade.getAnoLetivo().getAnoLectivo());
        System.out.println("Departamento: " + mensalidade.getDepartamento().getNomeDepartamento());
        System.out.println("Turma: " + mensalidade.getTurma().getNomeTurma());
        System.out.println("Ciclo Ectivo: " + mensalidade.getCicloLectivo().getCicloLectivo());
        System.out.println("Mes: " + mensalidade.getMes().getNomeMes());
        System.out.println("Aluno: " + mensalidade.getAluno().getNomeAluno());
        System.out.println("Curso: " + mensalidade.getCurso().getNomeCurso());
        */
    }

    /**
     * Test of findAll method, of class MensalidadeDAO.
     */
    @Test
    public void testFindAll() {
       /* System.out.println("findAll");
        MensalidadeDAO instance = new MensalidadeDAO();
        //List<Mensalidade> expResult = null;
        List<Mensalidade> mensalidades = instance.findAll();
        assertTrue(mensalidades.size() > 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        for (Mensalidade mensalidade : mensalidades) {
            System.out.println("Id: " + mensalidade.getIdMensalidade());
            System.out.println("Descrição: " + mensalidade.getDescricaoMensalidade());
            System.out.println("Observação: " + mensalidade.getObservacaoMensalidade());
            System.out.println("Data de Pagamento: " + DateUtill2.formataData(mensalidade.getDataPagamento()));
            System.out.println("\n");

            System.out.println("Ano Lectivo: " + mensalidade.getAnoLetivo().getAnoLectivo());
            System.out.println("Departamento: " + mensalidade.getDepartamento().getNomeDepartamento());
            System.out.println("Turma: " + mensalidade.getTurma().getNomeTurma());
            System.out.println("Ciclo Ectivo: " + mensalidade.getCicloLectivo().getCicloLectivo());
            System.out.println("Mes: " + mensalidade.getMes().getNomeMes());
            System.out.println("Aluno: " + mensalidade.getAluno().getNomeAluno());
            System.out.println("Curso: " + mensalidade.getCurso().getNomeCurso());
            System.out.println("\n---------------------------------------------------");
        }*/
    }

    /**
     * Test of popularComDados method, of class MensalidadeDAO.
     */
    @Test
    public void testPopularComDados() {
       /* System.out.println("popularComDados");
        Mensalidade mensalidade = null;
        ResultSet rs = null;
        MensalidadeDAO instance = new MensalidadeDAO();
        instance.popularComDados(mensalidade, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
