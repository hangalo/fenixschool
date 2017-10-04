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
    private byte [] fotoFuncionario;
    private String urlfotoFuncionario;
    private String telefoneFixoFuncionario;
    private String telefoneMovelFuncionario;
    private String emailFuncionario;
    private String loginFuncionario;
    private String passwordFuncionario;
    
    public Funcionario() {
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

    public byte[] getFotoFuncionario() {
        return fotoFuncionario;
    }

    public void setFotoFuncionario(byte[] fotoFuncionario) {
        this.fotoFuncionario = fotoFuncionario;
    }

    public String getUrlfotoFuncionario() {
        return urlfotoFuncionario;
    }

    public void setUrlfotoFuncionario(String urlfotoFuncionario) {
        this.urlfotoFuncionario = urlfotoFuncionario;
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

    public String getLoginFuncionario() {
        return loginFuncionario;
    }

    public void setLoginFuncionario(String loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    public String getPasswordFuncionario() {
        return passwordFuncionario;
    }

    public void setPasswordFuncionario(String passwordFuncionario) {
        this.passwordFuncionario = passwordFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idFuncionario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.idFuncionario != other.idFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nomeFuncionario=" + nomeFuncionario + '}';
    }

   
    
    
    
    
    
}
