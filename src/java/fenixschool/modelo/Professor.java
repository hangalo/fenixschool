/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

/**
 *
 * @author HP
 */
public class Professor {
    private int IdProfessor;
    private String NomeProfessor;
    private String SobrenomeProfessor;
    private Sexo IdSexo;
    
    public Professor(){}

    public Professor(int IdProfessor, String NomeProfessor, String SobrenomeProfessor, Sexo IdSexo) {
        this.IdProfessor = IdProfessor;
        this.NomeProfessor = NomeProfessor;
        this.SobrenomeProfessor = SobrenomeProfessor;
        this.IdSexo = IdSexo;
    }

    public int getIdProfessor() {
        return IdProfessor;
    }

    public void setIdProfessor(int IdProfessor) {
        this.IdProfessor = IdProfessor;
    }

    public String getNomeProfessor() {
        return NomeProfessor;
    }

    public void setNomeProfessor(String NomeProfessor) {
        this.NomeProfessor = NomeProfessor;
    }

    public String getSobrenomeProfessor() {
        return SobrenomeProfessor;
    }

    public void setSobrenomeProfessor(String SobrenomeProfessor) {
        this.SobrenomeProfessor = SobrenomeProfessor;
    }

    public Sexo getIdSexo() {
        return IdSexo;
    }

    public void setIdSexo(Sexo IdSexo) {
        this.IdSexo = IdSexo;
    }

}