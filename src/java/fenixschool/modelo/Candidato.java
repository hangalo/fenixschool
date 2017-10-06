/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author henriques elias
 */
public class Candidato {

    private Integer idCandidato;
    private String numeroCandidato;
    private String nomeCandidato;
    private String sobrenomeCandidato;
    private Date dataNascimento;
    private Sexo sexo;
    private String casaCandidato;
    private String bairroCandidato;
    private String distritoCandidato;
    private Municipio municipio;
    private String urlFotoCandidato;
    private byte[] fotoCandidato;
    private String telefoneFixo;
    private String telefoneMovel;
    private String emailCandidato;
    private Profissao profissao;
    private String loginCandidato;
    private String passwordCandidato;

    public Candidato() {
    }

    public Candidato(Integer idCandidato, String numeroCandidato, String nomeCandidato, String sobrenomeCandidato, Date dataNascimento, Sexo sexo, String casaCandidato, String bairroCandidato, String distritoCandidato, Municipio municipio, String urlFotoCandidato, byte[] fotoCandidato, String telefoneFixo, String telefoneMovel, String emailCandidato, Profissao profissao, String loginCandidato, String passwordCandidato) {
        this.idCandidato = idCandidato;
        this.numeroCandidato = numeroCandidato;
        this.nomeCandidato = nomeCandidato;
        this.sobrenomeCandidato = sobrenomeCandidato;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.casaCandidato = casaCandidato;
        this.bairroCandidato = bairroCandidato;
        this.distritoCandidato = distritoCandidato;
        this.municipio = municipio;
        this.urlFotoCandidato = urlFotoCandidato;
        this.fotoCandidato = fotoCandidato;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovel = telefoneMovel;
        this.emailCandidato = emailCandidato;
        this.profissao = profissao;
        this.loginCandidato = loginCandidato;
        this.passwordCandidato = passwordCandidato;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(String numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getSobrenomeCandidato() {
        return sobrenomeCandidato;
    }

    public void setSobrenomeCandidato(String sobrenomeCandidato) {
        this.sobrenomeCandidato = sobrenomeCandidato;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaCandidato() {
        return casaCandidato;
    }

    public void setCasaCandidato(String casaCandidato) {
        this.casaCandidato = casaCandidato;
    }

    public String getBairroCandidato() {
        return bairroCandidato;
    }

    public void setBairroCandidato(String bairroCandidato) {
        this.bairroCandidato = bairroCandidato;
    }

    public String getDistritoCandidato() {
        return distritoCandidato;
    }

    public void setDistritoCandidato(String distritoCandidato) {
        this.distritoCandidato = distritoCandidato;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getUrlFotoCandidato() {
        return urlFotoCandidato;
    }

    public void setUrlFotoCandidato(String urlFotoCandidato) {
        this.urlFotoCandidato = urlFotoCandidato;
    }

    public byte[] getFotoCandidato() {
        return fotoCandidato;
    }

    public void setFotoCandidato(byte[] fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public String getLoginCandidato() {
        return loginCandidato;
    }

    public void setLoginCandidato(String loginCandidato) {
        this.loginCandidato = loginCandidato;
    }

    public String getPasswordCandidato() {
        return passwordCandidato;
    }

    public void setPasswordCandidato(String passwordCandidato) {
        this.passwordCandidato = passwordCandidato;
    }

    @Override
    public String toString() {
        return "Candidato{" + "idCandidato=" + idCandidato + ", numeroCandidato=" + numeroCandidato + ", nomeCandidato=" + nomeCandidato + ", sobrenomeCandidato=" + sobrenomeCandidato + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", casaCandidato=" + casaCandidato + ", bairroCandidato=" + bairroCandidato + ", distritoCandidato=" + distritoCandidato + ", municipio=" + municipio + ", urlFotoCandidato=" + urlFotoCandidato + ", fotoCandidato=" + fotoCandidato + ", telefoneFixo=" + telefoneFixo + ", telefoneMovel=" + telefoneMovel + ", emailCandidato=" + emailCandidato + ", profissao=" + profissao + ", loginCandidato=" + loginCandidato + ", passwordCandidato=" + passwordCandidato + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idCandidato);
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
        final Candidato other = (Candidato) obj;
        if (!Objects.equals(this.idCandidato, other.idCandidato)) {
            return false;
        }
        return true;
    }

}
