/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Professor {
    private int IdProfessor;
    private String nomeProfessor;
    private String sobrenomeProfessor;
    private Date dataNascimentoProfessor;
    private Sexo sexo;
    private String nifProfessor;
    private byte[] fotoProfessor;
    private String urlFotoProfessor;
    private String casaProfessor;
    private String ruaProfessor;
    private String bairroProfessor;
    private String distritoUrbanoProfessor;
    private String telemovelPrincipalProfessor;
    private String telemovelAlternativoProfessor;
    private String telefonePrincipalProfessor;
    private String telefoneAlternativoProfessor;
    private String emailPrincipalProfessor;
    private String emailAlternativoProfessor;
    private String numeroBIProfessor;
    private String IBAMProfessor;
    private String numeroPassaporteProfessor;
    private Municipio municipio;      
       
    
 
    
    public Professor(){}

    public Professor(int IdProfessor, String nomeProfessor, String sobrenomeProfessor, Date dataNascimentoProfessor, Sexo sexo, String nifProfessor, byte[] fotoProfessor, String urlFotoProfessor, String casaProfessor, String ruaProfessor, String bairroProfessor, String distritoUrbanoProfessor, String telemovelPrincipalProfessor, String telemovelAlternativoProfessor, String telefonePrincipalProfessor, String telefoneAlternativoProfessor, String emailPrincipalProfessor, String emailAlternativoProfessor, String numeroBIProfessor, String IBAMProfessor, String numeroPassaporteProfessor, Municipio municipio) {
        this.IdProfessor = IdProfessor;
        this.nomeProfessor = nomeProfessor;
        this.sobrenomeProfessor = sobrenomeProfessor;
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.sexo = sexo;
        this.nifProfessor = nifProfessor;
        this.fotoProfessor = fotoProfessor;
        this.urlFotoProfessor = urlFotoProfessor;
        this.casaProfessor = casaProfessor;
        this.ruaProfessor = ruaProfessor;
        this.bairroProfessor = bairroProfessor;
        this.distritoUrbanoProfessor = distritoUrbanoProfessor;
        this.telemovelPrincipalProfessor = telemovelPrincipalProfessor;
        this.telemovelAlternativoProfessor = telemovelAlternativoProfessor;
        this.telefonePrincipalProfessor = telefonePrincipalProfessor;
        this.telefoneAlternativoProfessor = telefoneAlternativoProfessor;
        this.emailPrincipalProfessor = emailPrincipalProfessor;
        this.emailAlternativoProfessor = emailAlternativoProfessor;
        this.numeroBIProfessor = numeroBIProfessor;
        this.IBAMProfessor = IBAMProfessor;
        this.numeroPassaporteProfessor = numeroPassaporteProfessor;
        this.municipio = municipio;
    }

   
    public int getIdProfessor() {
        return IdProfessor;
    }

    public void setIdProfessor(int IdProfessor) {
        this.IdProfessor = IdProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSobrenomeProfessor() {
        return sobrenomeProfessor;
    }

    public void setSobrenomeProfessor(String sobrenomeProfessor) {
        this.sobrenomeProfessor = sobrenomeProfessor;
    }

    public Date getDataNascimentoProfessor() {
        return dataNascimentoProfessor;
    }

    public void setDataNascimentoProfessor(Date dataNascimentoProfessor) {
        this.dataNascimentoProfessor = dataNascimentoProfessor;
    }

    
    
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNifProfessor() {
        return nifProfessor;
    }

    public void setNifProfessor(String nifProfessor) {
        this.nifProfessor = nifProfessor;
    }

    public byte[] getFotoProfessor() {
        return fotoProfessor;
    }

    public void setFotoProfessor(byte[] fotoProfessor) {
        this.fotoProfessor = fotoProfessor;
    }

    public String getUrlFotoProfessor() {
        return urlFotoProfessor;
    }

    public void setUrlFotoProfessor(String urlFotoProfessor) {
        this.urlFotoProfessor = urlFotoProfessor;
    }

    public String getCasaProfessor() {
        return casaProfessor;
    }

    public void setCasaProfessor(String casaProfessor) {
        this.casaProfessor = casaProfessor;
    }

    public String getRuaProfessor() {
        return ruaProfessor;
    }

    public void setRuaProfessor(String ruaProfessor) {
        this.ruaProfessor = ruaProfessor;
    }

    public String getBairroProfessor() {
        return bairroProfessor;
    }

    public void setBairroProfessor(String bairroProfessor) {
        this.bairroProfessor = bairroProfessor;
    }

    public String getDistritoUrbanoProfessor() {
        return distritoUrbanoProfessor;
    }

    public void setDistritoUrbanoProfessor(String distritoUrbanoProfessor) {
        this.distritoUrbanoProfessor = distritoUrbanoProfessor;
    }

    public String getTelemovelPrincipalProfessor() {
        return telemovelPrincipalProfessor;
    }

    public void setTelemovelPrincipalProfessor(String telemovelPrincipalProfessor) {
        this.telemovelPrincipalProfessor = telemovelPrincipalProfessor;
    }

    public String getTelemovelAlternativoProfessor() {
        return telemovelAlternativoProfessor;
    }

    public void setTelemovelAlternativoProfessor(String telemovelAlternativoProfessor) {
        this.telemovelAlternativoProfessor = telemovelAlternativoProfessor;
    }

    public String getTelefonePrincipalProfessor() {
        return telefonePrincipalProfessor;
    }

    public void setTelefonePrincipalProfessor(String telefonePrincipalProfessor) {
        this.telefonePrincipalProfessor = telefonePrincipalProfessor;
    }

    public String getTelefoneAlternativoProfessor() {
        return telefoneAlternativoProfessor;
    }

    public void setTelefoneAlternativoProfessor(String telefoneAlternativoProfessor) {
        this.telefoneAlternativoProfessor = telefoneAlternativoProfessor;
    }

    public String getEmailPrincipalProfessor() {
        return emailPrincipalProfessor;
    }

    public void setEmailPrincipalProfessor(String emailPrincipalProfessor) {
        this.emailPrincipalProfessor = emailPrincipalProfessor;
    }

    public String getEmailAlternativoProfessor() {
        return emailAlternativoProfessor;
    }

    public void setEmailAlternativoProfessor(String emailAlternativoProfessor) {
        this.emailAlternativoProfessor = emailAlternativoProfessor;
    }

    public String getNumeroBIProfessor() {
        return numeroBIProfessor;
    }

    public void setNumeroBIProfessor(String numeroBIProfessor) {
        this.numeroBIProfessor = numeroBIProfessor;
    }

    public String getIBAMProfessor() {
        return IBAMProfessor;
    }

    public void setIBAMProfessor(String IBAMProfessor) {
        this.IBAMProfessor = IBAMProfessor;
    }

    public String getNumeroPassaporteProfessor() {
        return numeroPassaporteProfessor;
    }

    public void setNumeroPassaporteProfessor(String numeroPassaporteProfessor) {
        this.numeroPassaporteProfessor = numeroPassaporteProfessor;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.IdProfessor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.IdProfessor != other.IdProfessor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeProfessor + " " + this.sobrenomeProfessor;
    }

    

}