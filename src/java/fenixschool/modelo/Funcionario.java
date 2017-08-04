/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author HACKER
 */
public class Funcionario {
    private int idFuncionario;
    private String nomeFuncionario;
    private String sobrenomeFuncionario;
    private Date dataNascimentoFuncionario;
    private Sexo sexo;
    private String casaFuncionario;
    private String bairroFuncionario;
    private String distritoFuncionario;
    private Municipio municipio;
    private String fotoFuncionario;
    private String telefoneFixoFuncionario;
    private String telefoneMovelFuncionario;
    private String emailFuncionario;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nomeFuncionario, String sobrenomeFuncionario, Date dataNascimentoFuncionario, Sexo sexo, String casaFuncionario, String bairroFuncionario, String distritoFuncionario, Municipio municipio, String fotoFuncionario, String telefoneFixoFuncionario, String telefoneMovelFuncionario, String emailFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
        this.sexo = sexo;
        this.casaFuncionario = casaFuncionario;
        this.bairroFuncionario = bairroFuncionario;
        this.distritoFuncionario = distritoFuncionario;
        this.municipio = municipio;
        this.fotoFuncionario = fotoFuncionario;
        this.telefoneFixoFuncionario = telefoneFixoFuncionario;
        this.telefoneMovelFuncionario = telefoneMovelFuncionario;
        this.emailFuncionario = emailFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return sobrenomeFuncionario;
    }

    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public Date getDataNascimentoFuncionario() {
        return dataNascimentoFuncionario;
    }

    public void setDataNascimentoFuncionario(Date dataNascimentoFuncionario) {
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaFuncionario() {
        return casaFuncionario;
    }

    public void setCasaFuncionario(String casaFuncionario) {
        this.casaFuncionario = casaFuncionario;
    }

    public String getBairroFuncionario() {
        return bairroFuncionario;
    }

    public void setBairroFuncionario(String bairroFuncionario) {
        this.bairroFuncionario = bairroFuncionario;
    }

    public String getDistritoFuncionario() {
        return distritoFuncionario;
    }

    public void setDistritoFuncionario(String distritoFuncionario) {
        this.distritoFuncionario = distritoFuncionario;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getFotoFuncionario() {
        return fotoFuncionario;
    }

    public void setFotoFuncionario(String fotoFuncionario) {
        this.fotoFuncionario = fotoFuncionario;
    }

    public String getTelefoneFixoFuncionario() {
        return telefoneFixoFuncionario;
    }

    public void setTelefoneFixoFuncionario(String telefoneFixoFuncionario) {
        this.telefoneFixoFuncionario = telefoneFixoFuncionario;
    }

    public String getTelefoneMovelFuncionario() {
        return telefoneMovelFuncionario;
    }

    public void setTelefoneMovelFuncionario(String telefoneMovelFuncionario) {
        this.telefoneMovelFuncionario = telefoneMovelFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nomeFuncionario=" + nomeFuncionario + '}';
    }
    
    
    
    
    
    
    
    
}
