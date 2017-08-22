/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author PENA
 */
public class Nota {
    
    private int id_nota;
    private PeriodoLectivo periodoLectivo;
    private Aluno aluno;
    private Curso curso;
   // private Disciplina disciplina;
    private String descricao;
    private Date dataLancamento;
    private double nota;
    private double peso;
    private AnoLectivo anoLectivo;
    private CicloLectivo cicloLectivo;
    //private ClassificaoNota classificacaoNota;
    private Departamento departamento;
    private Turma turma;
    private AnoCurricular anoCurricular;
    private String observacao;

    public Nota() {
    }
    
    
}
